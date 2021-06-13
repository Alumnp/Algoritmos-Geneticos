/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hilos;

import binario.Cruza_Binario;
import binario.Herramientas_Binario;
import binario.Individuo_Binario;
import binario.Muta_Binario;
import binario.Seleccion_Binario;
import java.util.ArrayList;

/**
 *
 * @author vazqu
 */
public class HiloBinario extends Thread {

    HilosJFrame panel;

    private ArrayList<Individuo_Binario> poblacionActual = new ArrayList<>();

    public HiloBinario(HilosJFrame panel) {
        this.panel = panel;
    }

    private void generarPoblacionInicial() {
        // generar un población aleatoria de individuos
        for (int i = 0; i < (Integer) panel.getjSpinnerTP().getValue(); i++) {
            this.getPoblacionActual().add(new Individuo_Binario((Integer) panel.getjSpinnerAux().getValue()));
        }

    }

    private boolean generarProbabilidadMuta() {

        if ((Integer) panel.getjSpinnerPM().getValue() > Math.random()) {
            return true;
        } else {
            return false;
        }

    }

    private void sustituirPoblacion(ArrayList<Individuo_Binario> nuevaPob) {
        this.getPoblacionActual().clear();
        for (Individuo_Binario aux : nuevaPob) {
            this.getPoblacionActual().add(new Individuo_Binario(aux));
        }
    }

    public void run() {

        ArrayList<Integer> datops = new ArrayList<>();
        generarPoblacionInicial();
        Individuo_Binario mejor = Herramientas_Binario.mejorPoblacion(poblacionActual);
        datops.add(mejor.getFitness());

        // proceso evolutivo que tiene relación con el numero de generaciones
        for (int g = 1; g < (Integer) panel.getjSpinnerNG().getValue(); g++) {
            ArrayList<Individuo_Binario> nuevaPob = new ArrayList<>();
            // garantizar que se va a generar una población nueva 
            for (int i = 0; i < (Integer) panel.getjSpinnerTP().getValue(); i++) {
                // Seleccion de una madre 
                Individuo_Binario madre = Seleccion_Binario.seleccionAleatoria(this.getPoblacionActual());
                // Seleccion de un padre
                Individuo_Binario padre = Seleccion_Binario.seleccionAleatoria(this.getPoblacionActual());
                // cruza (Retornar el mejor ind de la cruza)
                int[] mask = Herramientas_Binario.generarArregloBinarios(madre.getGenotipo().length);
                Individuo_Binario hijo = Cruza_Binario.cruzaPorMascaraBinaria(madre, padre, mask);
                // Se aplica una muta evaluando una probabilidad
                if (generarProbabilidadMuta()) {
                    Muta_Binario.mutaSimple(hijo);
                }
                nuevaPob.add(hijo);
            }
            // actualización de la población
            sustituirPoblacion(nuevaPob);
            mejor = Herramientas_Binario.mejorPoblacion(poblacionActual);
            datops.add(mejor.getFitness());

        }
        panel.actualizarGrafica(datops);
    }

    public ArrayList<Individuo_Binario> getPoblacionActual() {
        return poblacionActual;
    }
}
