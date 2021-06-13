/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hilos;

import java.util.ArrayList;
import java.util.Random;
import TSP.Cruza_TSP;
import TSP.Herramientas_TSP;
import TSP.Individuo_TSP;
import TSP.Muta_TSP;
import TSP.Seleccion;

/**
 *
 * @author vazqu
 */
public class HiloTSP extends Thread {

    HilosJFrame panel;
    private ArrayList<Individuo_TSP> poblacionActual = new ArrayList<>();

    public HiloTSP(HilosJFrame panel) {
        this.panel = panel;
    }

    private void generarPoblacionInicial() {
        // generar un población aleatoria de individuos
        int[][] array = herramientas.LeerDatos.tokenizarDataSet();

        //int[][] array = new int[][]{{0,64,22,64},{64,0,51,60},{22,51,0,50},{64,60,50,0}}; 
        for (int i = 0; i < (int) panel.getjSpinnerTP().getValue(); i++) {
            int[] ruta = new int[array.length];
            ruta[0] = (int) panel.getjSpinnerAux().getValue();
            for (int x = 1; x < array.length; x++) {
                boolean diferente = true;
                Random numAleatorio = new Random();
                int aux = 0;
                while (diferente) {
                    diferente = false;
                    aux = numAleatorio.nextInt(array.length);
                    for (int y = 0; y < ruta.length; y++) {
                        if (ruta[y] == aux) {
                            diferente = true;
                        }
                    }
                }
                ruta[x] = aux;
            }
            this.getPoblacionActual().add(new Individuo_TSP(array, ruta));
        }
    }

    private boolean generarProbabilidadMuta() {

        if ((int) panel.getjSpinnerPM().getValue() > Math.random()) {
            return true;
        } else {
            return false;
        }

    }

    private void sustituirPoblacion(ArrayList<Individuo_TSP> nuevaPob) {
        this.getPoblacionActual().clear();
        for (Individuo_TSP aux : nuevaPob) {
            this.getPoblacionActual().add(new Individuo_TSP(aux));
        }
    }

    public ArrayList<Individuo_TSP> getPoblacionActual() {
        return poblacionActual;
    }

    public void run() {
        ArrayList<Integer> datops = new ArrayList<>();
        generarPoblacionInicial();
        Individuo_TSP mejor = Herramientas_TSP.mejorPoblacion(poblacionActual);
        datops.add(mejor.getFitness());
        panel.actualizarGrafica(datops);

        // proceso evolutivo que tiene relación con el numero de generaciones
        for (int g = 1; g < (int) panel.getjSpinnerNG().getValue(); g++) {
            ArrayList<Individuo_TSP> nuevaPob = new ArrayList<>();
            // garantizar que se va a generar una población nueva 
            for (int i = 0; i < (int) panel.getjSpinnerTP().getValue(); i++) {
                // Seleccion de una madre 
                Individuo_TSP madre = Seleccion.seleccionAleatoria(this.getPoblacionActual());
                // Seleccion de un padre
                Individuo_TSP padre = Seleccion.seleccionAleatoria(this.getPoblacionActual());
                // cruza (Retornar el mejor ind de la cruza)
                Individuo_TSP hijo = Cruza_TSP.cruzaPorMascaraBinaria(madre, padre);
                // Se aplica una muta evaluando una probabilidad
                if (generarProbabilidadMuta()) {
                    Muta_TSP.mutaSimple(hijo);
                }
                nuevaPob.add(hijo);
            }
            // actualización de la población
            sustituirPoblacion(nuevaPob);
            mejor = Herramientas_TSP.mejorPoblacion(poblacionActual);
            datops.add(mejor.getFitness());
        }
        panel.actualizarGrafica(datops);
    }

}
