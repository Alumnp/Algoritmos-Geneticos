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
public class Seleccion_Binario {

    public static Individuo_Binario seleccionAleatoria(ArrayList<Individuo_Binario> pob) {
        Random ran = new Random();
        int pos = ran.nextInt(pob.size());
        return new Individuo_Binario(pob.get(pos));
    }

}
