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
public class Seleccion {

    public static Individu seleccionTorneo(Poblacion pob) {
        Individu mejor = new Individu(pob.getMejor().getGenotipo());
        return mejor;
    }

    public static Individu seleccionAleatoria(Poblacion pob) {
        Random ran = new Random();
        int pos = ran.nextInt(pob.getIndivduos().size());
        Individu mejor = new Individu(pob.getIndivduos()
                .get(pos).getGenotipo());
        return mejor;
    }
}
