/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3sat;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author vazqu
 */
public class GeneticoTresSat {

    private Poblacion poblacionActual;
    private int numG, tamP;
    private double pMuta;

    public GeneticoTresSat(int numG, int tamP, double pMuta, int c) {
        this.numG = numG;
        this.tamP = tamP;
        this.pMuta = pMuta;
        this.poblacionActual = new Poblacion(tamP);
    }

    public void evolucionar() {
        int mask[] = Cruza.generarMascaraAleatoria(100);
        Individu mejor = null;
        for (int g = 1; g < this.numG; g++) {
            ArrayList<Individu> ind = new ArrayList<>();
            for (int i = 0; i < this.tamP; i++) {
                Individu madre = Seleccion.seleccionTorneo(this.poblacionActual);
                Individu padre = Seleccion.seleccionAleatoria(this.poblacionActual);

                Individu hijo = Cruza.cruzaPorMascara(mask, madre, padre);
                Muta.mutaGeno(pMuta, hijo);
                ind.add(hijo);
            }
            this.poblacionActual = new Poblacion(ind);
            mejor = this.poblacionActual.getMejor();
            System.out.println(g + ": " + mejor.getFitness());

        }
        System.out.println("\n\n\n\n\n\n\n\n");

        System.out.println(mejor.getFitness());
        System.out.println(Arrays.toString(mejor.getGenotipo()));
    }

    private void mejor() {
        Individu i = new Individu(new int[]{0, 0, 0, 1, 0, 1, 1, 0, 1, 0, 0, 0, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 1, 1, 0});
        this.poblacionActual.getIndivduos().add(i);
    }

}
