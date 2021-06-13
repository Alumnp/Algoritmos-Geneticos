/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NReinas;

import herramientas.Grafica;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author working
 */
public class GeneticoNReinas {

    private int tamanoPob;
    private int numGeneraciones;
    private double probMuta;
    private int n;
    private ArrayList<IndividuoNR> poblacionActual;

    private ArrayList<DatoTablero> datosArchivo;

    public GeneticoNReinas(int tamanoPob, int numGeneraciones, double probMuta, int n) {
        this.tamanoPob = tamanoPob;
        this.numGeneraciones = numGeneraciones;
        this.probMuta = probMuta;
        this.n = n;
        this.poblacionActual = new ArrayList<>();
        this.datosArchivo = new ArrayList<>();
    }

    public void evolucionar(boolean generarArchivo) {
        int[] datops = new int[numGeneraciones];
        generarPoblacionInicial();
        IndividuoNR mejor = Herramientas.mejorPoblacion(poblacionActual);
        datops[0] = mejor.getFitness();

        if (generarArchivo) {
            datosArchivo.add(new DatoTablero(0));
            for (int x = 0; x < poblacionActual.size(); x++) {
                datosArchivo.get(0).agregarIndividuo(poblacionActual.get(x));
            }

            datosArchivo.get(0).agregarMejor(mejor);
        }

        // proceso evolutivo que tiene relación con el numero de generaciones
        for (int g = 1; g < this.numGeneraciones; g++) {
            ArrayList<IndividuoNR> nuevaPob = new ArrayList<>();
            // garantizar que se va a generar una población nueva 
            for (int i = 0; i < this.tamanoPob; i++) {
                // Seleccion de una madre 
                IndividuoNR madre = Seleccion.seleccionAleatoria(this.getPoblacionActual());
                // Seleccion de un padre
                IndividuoNR padre = Seleccion.seleccionAleatoria(this.getPoblacionActual());

                // cruza (Retornar el mejor ind de la cruza)
                int[] mask = Herramientas.generarArregloBinarios(madre.getN());
                IndividuoNR hijo = Cruza.cruzaPorMascaraBinaria(madre, padre, mask);
                // Se aplica una muta evaluando una probabilidad
                if (generarProbabilidadMuta()) {
                    Muta.mutaSimple(hijo);
                }
                nuevaPob.add(hijo);

            }
            // actualización de la población
            sustituirPoblacion(nuevaPob);
            if (generarArchivo) {
                datosArchivo.add(new DatoTablero(g));
                for (int x = 0; x < poblacionActual.size(); x++) {
                    datosArchivo.get(g).agregarIndividuo(poblacionActual.get(x));
                }
            }

            mejor = Herramientas.mejorPoblacion(poblacionActual);

            if (generarArchivo) {
                datosArchivo.get(g).agregarMejor(mejor);
            }

            datops[g] = mejor.getFitness();
        }

    }

    private void generarPoblacionInicial() {
        // generar un población aleatoria de individuos
        for (int i = 0; i < this.tamanoPob; i++) {
            this.getPoblacionActual().add(new IndividuoNR(n));
        }
    }

    private boolean generarProbabilidadMuta() {

        if (this.probMuta > Math.random()) {
            return true;
        } else {
            return false;
        }
    }

    private void sustituirPoblacion(ArrayList<IndividuoNR> nuevaPob) {
        this.getPoblacionActual().clear();
        for (IndividuoNR aux : nuevaPob) {
            this.getPoblacionActual().add(new IndividuoNR(aux));
        }
    }

    /**
     * @return the poblacionActual
     */
    public ArrayList<IndividuoNR> getPoblacionActual() {
        return poblacionActual;
    }

    public class DatoTablero {

        private int numGeneracion;
        private ArrayList<IndividuoNR> individuos;
        private IndividuoNR mejor;

        public DatoTablero(int numGeneracion) {
            this.numGeneracion = numGeneracion;
            this.individuos = new ArrayList<>();
        }

        /**
         * @return the numGeneracion
         */
        public int getNumGeneracion() {
            return numGeneracion;
        }

        /**
         * @param numGeneracion the numGeneracion to set
         */
        public void setNumGeneracion(int numGeneracion) {
            this.numGeneracion = numGeneracion;
        }

        public void agregarIndividuo(IndividuoNR in) {
            individuos.add(in);
        }

        public void agregarMejor(IndividuoNR mejor) {
            this.mejor = mejor;
        }
    }
}
