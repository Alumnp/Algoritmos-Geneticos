/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NReinas;

import java.util.Random;

/**
 *
 * @author vazqu
 */
public class Muta {

    public static void mutaSimple(IndividuoNR ind) {
        Random ran = new Random();

        int pos = ran.nextInt(ind.getN());
        ind.getFenotipo()[pos] = ran.nextInt(ind.getN());

        ind.calcularFitnessProfe();
    }

}
