/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAT;

/**
 *
 * @author vazqu
 */
public class Cruza_SAT {

    public static Individuo_SAT cruzaPorMascaraBinaria(Individuo_SAT madre,
            Individuo_SAT padre) {

        boolean[] gen1 = padre.getFenotipo();
        boolean[] gen2 = madre.getFenotipo();

        int num = gen2.length / 2;

        for (int x = 0; x < padre.getFenotipo().length; x++) {
            if (x < num) {
                boolean aux = gen1[x];
                gen1[x] = gen2[x];
                gen2[x] = aux;
            }
        }

        for (int x = 0; x < padre.getFenotipo().length; x++) {
            if (x < num) {
                boolean aux = gen2[x];
                gen2[x] = gen1[x];
                gen1[x] = aux;
            }
        }

        Individuo_SAT i1 = new Individuo_SAT(padre.getGenotipo(), gen1,
                madre.getNumPosi(), madre.getNumVariables());
        Individuo_SAT i2 = new Individuo_SAT(madre.getGenotipo(), gen2,
                madre.getNumPosi(), madre.getNumVariables());

        if (i1.getFitness() > i2.getFitness()) {
            return i1;
        } else {
            return i2;
        }
    }

}
