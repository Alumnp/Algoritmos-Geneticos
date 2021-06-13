/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binario;

import java.util.Random;

/**
 *
 * @author vazqu
 */
public class Muta {

    public static void aplicarMutaAleatoria(Individuo p) {
        Random ran = new Random();
        int pos = ran.nextInt(p.getGenotipo().length);
        if (p.getGenotipo()[pos] == 1) {
            p.getGenotipo()[pos] = 0;

        } else {
            p.getGenotipo()[pos] = 1;
        }
        // actualizar el genotipo, fenotipo y fitness
        p.calcularFitness();

    }
}
