/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3sat;

import java.util.Random;

/**
 *
 * @author vazqu
 */
public class Muta {

    public static void mutaGeno(double prob, Individu ind) {
        double aux = Math.random();
        if (aux <= prob) {
            Random ran = new Random();
            int pos = ran.nextInt(ind.getGenotipo().length);
            if (ind.getGenotipo()[pos] == 1) {
                ind.getGenotipo()[pos] = 0;
            } else {
                ind.getGenotipo()[pos] = 1;
            }
            ind.actualizarIndividuo();

        }
    }

}
