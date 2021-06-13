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
public class Individuo_SAT {

    private int[][] genotipo;
    private boolean[] fenotipo;
    private int fitness;

    private int numPosi;
    private int numVariables;

    public Individuo_SAT(int[][] genotipo, int tamArray, int numPosi,
            int numVariables) {
        this.genotipo = genotipo;
        fenotipo = new boolean[tamArray];
        this.numPosi = numPosi;
        this.numVariables = numVariables;
        generarFenotipo();
        calcularFitness();
    }

    public Individuo_SAT(int[][] genotipo, boolean[] fenotipo, int numPosi,
            int numVariables) {
        this.genotipo = genotipo;
        this.fenotipo = fenotipo;
        this.numPosi = numPosi;
        this.numVariables = numVariables;
        calcularFitness();
    }

    public Individuo_SAT(Individuo_SAT i) {
        this.genotipo = i.getGenotipo();
        this.fenotipo = i.getFenotipo();
        this.fitness = i.getFitness();

        this.numPosi = i.getNumPosi();
        this.numVariables = i.getNumVariables();
    }

    public void generarFenotipo() {
        Random random = new Random();
        for (int i = 0; i < getFenotipo().length; i++) {
            this.getFenotipo()[i] = random.nextBoolean();
        }
        System.out.println("");
    }

    public void calcularFitness() {
        int auxFitness = 0;

        for (int x = 0; x < getNumPosi(); x++) {
            boolean auxOR = false;
            for (int y = 0; y < getNumVariables(); y++) {
                if (getGenotipo()[x][y] < 0) {
                    auxOR = auxOR
                            || !getFenotipo()[((-1 * getGenotipo()[x][y])) - 1];
                } else {
                    auxOR = auxOR
                            || getFenotipo()[(getGenotipo()[x][y]) - 1];
                }
            }
            if (auxOR) {
                auxFitness++;
            }
        }
        this.setFitness(auxFitness);
    }

    public int[][] getGenotipo() {
        return genotipo;
    }

    public void setGenotipo(int[][] genotipo) {
        this.genotipo = genotipo;
    }

    public boolean[] getFenotipo() {
        return fenotipo;
    }

    public void setFenotipo(boolean[] fenotipo) {
        this.fenotipo = fenotipo;
    }

    public int getFitness() {
        return fitness;
    }

    public void setFitness(int fitness) {
        this.fitness = fitness;
    }

    public int getNumPosi() {
        return numPosi;
    }

    public void setNumPosi(int numPosi) {
        this.numPosi = numPosi;
    }

    public int getNumVariables() {
        return numVariables;
    }

    public void setNumVariables(int numVariables) {
        this.numVariables = numVariables;
    }
}
