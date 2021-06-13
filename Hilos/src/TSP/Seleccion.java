/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TSP;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author vazqu
 */
public class Seleccion {

    public static Individuo_TSP seleccionAleatoria(ArrayList<Individuo_TSP> pob) {
        Random ran = new Random();
        int pos = ran.nextInt(pob.size());
        return new Individuo_TSP(pob.get(pos));
    }

}
