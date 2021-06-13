/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hilos;

import java.util.ArrayList;
import NReinas.Cruza;
import NReinas.Herramientas;
import NReinas.IndividuoNR;
import NReinas.Muta;
import NReinas.Seleccion;

/**
 *
 * @author vazqu
 */
public class HiloNReinas extends Thread {

    private HilosJFrame panel;
    private ArrayList<IndividuoNR> poblacionActual = new ArrayList<>();

    public HiloNReinas(HilosJFrame panel) {
        this.panel = panel;
    }

    private void generarPoblacionInicial() {
        // generar un población aleatoria de individuos
        for (int i = 0; i < (int) panel.getjSpinnerTP().getValue(); i++) {
            this.getPoblacionActual().add(new IndividuoNR((int) panel.getjSpinnerTP().getValue()));
        }
    }

    private boolean generarProbabilidadMuta() {

        if ((int) panel.getjSpinnerPM().getValue() > Math.random()) {
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

    public ArrayList<IndividuoNR> getPoblacionActual() {
        return poblacionActual;
    }

    public void run() {
        ArrayList<Integer> datops = new ArrayList<>();
        generarPoblacionInicial();
        IndividuoNR mejor = Herramientas.mejorPoblacion(poblacionActual);
        datops.add(mejor.getFitness());
        panel.actualizarGrafica(datops);

        // proceso evolutivo que tiene relación con el numero de generaciones
        for (int g = 1; g < (int) panel.getjSpinnerNG().getValue(); g++) {
            ArrayList<IndividuoNR> nuevaPob = new ArrayList<>();
            // garantizar que se va a generar una población nueva 
            for (int i = 0; i < (int) panel.getjSpinnerTP().getValue(); i++) {
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
            mejor = Herramientas.mejorPoblacion(poblacionActual);
            datops.add(mejor.getFitness());

        }
        panel.actualizarGrafica(datops);
    }

}
