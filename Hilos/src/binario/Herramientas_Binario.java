/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binario;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author vazqu
 */
public class Herramientas_Binario {

    public static int[] generarArregloBinarios(int n) {
        int[] arreglo = new int[n];
        Random ran = new Random();
        for (int x = 0; x < n; x++) {
            arreglo[x] = ran.nextInt(2);
        }
        return arreglo;
    }

    public static Individuo_Binario mejorPoblacion(ArrayList<Individuo_Binario> pob) {
        Individuo_Binario mejor = new Individuo_Binario(pob.get(0));
        for (Individuo_Binario aux : pob) {
            if (aux.getFitness() < mejor.getFitness()) {
                mejor = new Individuo_Binario(aux);
            }
        }
        return mejor;
    }
}
