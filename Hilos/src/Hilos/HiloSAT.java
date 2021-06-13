/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hilos;

import herramientas.Datos;
import java.util.ArrayList;
import SAT.Cruza_SAT;
import SAT.Individuo_SAT;
import SAT.Muta_SAT;

/**
 *
 * @author vazqu
 */
public class HiloSAT extends Thread {

    private HilosJFrame panel;
    private ArrayList<Individuo_SAT> poblacionActual = new ArrayList<>();

    public HiloSAT(HilosJFrame panel) {
        this.panel = panel;
    }

    private void generarPoblacionInicial() {
        // generar un población aleatoria de individuos
        Datos dt = herramientas.LeerDatos.tokenizarDataSetSB();

        for (int i = 0; i < (int) panel.getjSpinnerTP().getValue(); i++) {
            this.getPoblacionActual().add(new Individuo_SAT(dt.getList(), dt.getTamArray(), dt.getNumPos(), dt.getNumVar()));
        }
    }

    private boolean generarProbabilidadMuta() {

        if ((int) panel.getjSpinnerPM().getValue() > Math.random()) {
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

    public void run() {
        ArrayList<Integer> datops = new ArrayList<>();
        generarPoblacionInicial();
        Individuo_SAT mejor = herramientas.Herramientas.mejorPoblacionSB(poblacionActual);
        datops.add(mejor.getFitness());

        // proceso evolutivo que tiene relación con el numero de generaciones
        for (int g = 1; g < (int) panel.getjSpinnerNG().getValue(); g++) {
            ArrayList<Individuo_SAT> nuevaPob = new ArrayList<>();
            // garantizar que se va a generar una población nueva 
            for (int i = 0; i < (int) panel.getjSpinnerTP().getValue(); i++) {
                // Seleccion de una madre 
                Individuo_SAT madre = herramientas.Herramientas.seleccionAleatoriaSB(this.getPoblacionActual());
                // Seleccion de un padre
                Individuo_SAT padre = herramientas.Herramientas.seleccionAleatoriaSB(this.getPoblacionActual());
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
            mejor = herramientas.Herramientas.mejorPoblacionSB(poblacionActual);
            datops.add(mejor.getFitness());

        }
        panel.actualizarGrafica(datops);
    }

}
