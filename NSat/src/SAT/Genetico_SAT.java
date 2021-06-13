/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAT;

import Herramientas.Datos;
import Herramientas.Grafica;
import java.util.ArrayList;


/**
 *
 * @author vazqu
 */
public class Genetico_SAT {

    private int tamanoPob;
    private int numGeneraciones;
    private double probMuta;
    private ArrayList<Individuo_SAT> poblacionActual;

    public Genetico_SAT(int tamanoPob, int numGeneraciones, double probMuta) {
        this.tamanoPob = tamanoPob;
        this.numGeneraciones = numGeneraciones;
        this.probMuta = probMuta;
        this.poblacionActual = new ArrayList<>();
    }

    public void evolucionar() {
        int[] datops = new int[numGeneraciones];
        generarPoblacionInicial();
        Individuo_SAT mejor = Herramientas.Herramientas.mejorPoblacionSB(poblacionActual);
        datops[0] = mejor.getFitness();

        // proceso evolutivo que tiene relación con el numero de generaciones
        for (int g = 1; g < this.numGeneraciones; g++) {
            ArrayList<Individuo_SAT> nuevaPob = new ArrayList<>();
            // garantizar que se va a generar una población nueva 
            for (int i = 0; i < this.tamanoPob; i++) {
                // Seleccion de una madre 
                Individuo_SAT madre = Herramientas.Herramientas.seleccionAleatoriaSB(this.getPoblacionActual());
                // Seleccion de un padre
                Individuo_SAT padre = Herramientas.Herramientas.seleccionAleatoriaSB(this.getPoblacionActual());
                // cruza (Retornar el mejor ind de la cruza)
                Individuo_SAT hijo = Cruza_SAT.cruzaPorMascaraBinaria(madre, padre);
                // Se aplica una muta evaluando una probabilidad
                if (generarProbabilidadMuta()) {
                    Muta_SAT.mutaSimple(hijo);
                }
                nuevaPob.add(hijo);
            }
            // actualización de la población
            sustituirPoblacion(nuevaPob);
            mejor = Herramientas.Herramientas.mejorPoblacionSB(poblacionActual);
            datops[g] = mejor.getFitness();
        }
        System.out.println("Num generaciones: "+datops.length);
        Grafica grafica = new Grafica("Generacion","Fitness","Algoritmo Genetico");
        grafica.agregarSerie("Generaciones", datops);
        grafica.crearGrafica();
        grafica.muestraGrafica();
    }

    private void generarPoblacionInicial() {
        // generar un población aleatoria de individuos
        Datos dt = Herramientas.LeerDatos.tokenizarDataSetSB();

        //int[][] array = new int[][]{{0,64,22,64},{64,0,51,60},{22,51,0,50},{64,60,50,0}}; 
        for (int i = 0; i < this.tamanoPob; i++) {
            this.getPoblacionActual().add(new Individuo_SAT(dt.getList(), dt.getTamArray(), dt.getNumPos(), dt.getNumVar()));
        }
    }

    private boolean generarProbabilidadMuta() {

        if (this.probMuta > Math.random()) {
            return true;
        } else {
            return false;
        }

    }

    private void sustituirPoblacion(ArrayList<Individuo_SAT> nuevaPob) {
        this.getPoblacionActual().clear();
        for (Individuo_SAT aux : nuevaPob) {
            this.getPoblacionActual().add(new Individuo_SAT(aux));
        }
    }

    public ArrayList<Individuo_SAT> getPoblacionActual() {
        return poblacionActual;
    }
}
