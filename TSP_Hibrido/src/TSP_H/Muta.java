/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TSP_H;

import java.util.Random;

/**
 *
 * @author vazqu
 */
public class Muta {

    public static void muta(double prob, Individuo i) {
        double aux = Math.random();
        if (aux <= prob) {

            Random ran = new Random();
            int pos1 = ran.nextInt(i.getGenotipo().length - 1) + 1;
            int pos2 = ran.nextInt(i.getGenotipo().length - 1) + 1;

            int auxPos1 = i.getGenotipo()[pos1];

            i.getGenotipo()[pos1] = i.getGenotipo()[pos2];
            i.getGenotipo()[pos2] = auxPos1;

            i.actualizarIndividuo();
        }
    }
}
