/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Herramientas;

import java.util.ArrayList;
import java.util.Random;
import SAT.Individuo_SAT;

/**
 *
 * @author vazqu
 */
public class Herramientas {

    public static int[] generarArregloBinarios(int n) {
        int[] arreglo = new int[n];
        Random ran = new Random();
        for (int x = 0; x < n; x++) {
            arreglo[x] = ran.nextInt(2);
        }
        return arreglo;
    }

    /* Seleccion SB */
    public static Individuo_SAT mejorPoblacionSB(ArrayList<Individuo_SAT> pobSB) {
        Individuo_SAT mejor = new Individuo_SAT(pobSB.get(0));
        for (Individuo_SAT aux : pobSB) {
            if (aux.getFitness() > mejor.getFitness()) {
                mejor = new Individuo_SAT(aux);
            }
        }
        return mejor;
    }

    public static Individuo_SAT seleccionAleatoriaSB(ArrayList<Individuo_SAT> pob) {
        Random ran = new Random();
        int pos = ran.nextInt(pob.size());
        return new Individuo_SAT(pob.get(pos));
    }
}
