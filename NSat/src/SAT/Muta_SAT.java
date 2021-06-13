/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAT;

import java.util.Random;

/**
 *
 * @author vazqu
 */
public class Muta_SAT {

    public static void mutaSimple(Individuo_SAT ind) {
        Random ran = new Random();

        int pos = ran.nextInt(ind.getFenotipo().length);
        ind.getFenotipo()[pos] = ran.nextBoolean();

        pos = ran.nextInt(ind.getFenotipo().length);
        ind.getFenotipo()[pos] = ran.nextBoolean();

        pos = ran.nextInt(ind.getFenotipo().length);
        ind.getFenotipo()[pos] = ran.nextBoolean();

        ind.calcularFitness();
    }
}
