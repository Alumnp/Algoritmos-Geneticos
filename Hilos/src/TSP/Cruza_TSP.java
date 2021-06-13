/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TSP;

/**
 *
 * @author vazqu
 */
public class Cruza_TSP {

    public static Individuo_TSP cruzaPorMascaraBinaria(Individuo_TSP madre, Individuo_TSP padre) {
        int[] genotipo1 = padre.getFenotipo();
        int[] genotipo2 = madre.getFenotipo();

        for (int x = 1; x < madre.getFenotipo().length; x++) {
            int aux = genotipo1[x];
            genotipo1[x] = genotipo2[x];
            genotipo2[x] = aux;
        }

        Individuo_TSP i1 = new Individuo_TSP(padre.getGenotipo(), genotipo1);
        Individuo_TSP i2 = new Individuo_TSP(madre.getGenotipo(), genotipo2);

        if (i1.getFitness() < i2.getFitness()) {
            return i1;
        } else {
            return i2;
        }
    }

}
