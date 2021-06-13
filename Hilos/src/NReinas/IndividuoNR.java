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
public class IndividuoNR {

    private Tablero genotipo;
    private int[] fenotipo;
    private int fitness;

    private int n;

    public IndividuoNR(Tablero genotipo) {
        this.genotipo = genotipo;
        fenotipo = new int[genotipo.getN()];
        n = genotipo.getN();
        calcularFenotipo();
    }

    public void Individuo(int[] fenotipo, int fitness) {
        this.fenotipo = fenotipo;
        this.fitness = fitness;

        genotipo = new Tablero(fenotipo);
    }

    public IndividuoNR(int n) {
        this.genotipo = new Tablero(n);
        this.n = n;
        this.fenotipo = new int[genotipo.getN()];

        Random random = new Random();

        for (int x = 0; x < n; x++) {
            this.fenotipo[x] = random.nextInt(n);
        }

        calcularFitnessProfe();
    }

    public IndividuoNR(IndividuoNR i) {
        this.genotipo = i.getGenotipo();
        this.fenotipo = i.getFenotipo();
        this.fitness = i.getFitness();
        this.n = i.getN();
    }

    public void calcularFenotipo() {
        for (int x = 0; x < getGenotipo().getN(); x++) {
            for (int y = 0; y < getGenotipo().getN(); y++) {
                if (getGenotipo().getCelda(x, y)) {
                    getFenotipo()[x] = y;
                }
            }
        }
        calcularFitnessProfe();
    }

    public void calcularFitnessProfe() {
        this.fitness = 0;
        for (int x = 0; x < this.n - 1; x++) {
            for (int y = x + 1; y < this.n; y++) {
                int a = this.getFenotipo()[x];
                int b = this.getFenotipo()[y];

                int auxx = this.getFenotipo()[x] - x;
                int auxy = this.getFenotipo()[y] - y;

                int aux2x = this.getFenotipo()[x] + x;
                int aux2y = this.getFenotipo()[y] + y;

                if ((a == b) || (auxx == auxy) || (aux2x == aux2y)) {
                    this.fitness += 2;
                }
            }
        }
    }

    public int getN() {
        return n;
    }

    public Tablero getGenotipo() {
        return genotipo;
    }

    public void setGenotipo(Tablero genotipo) {
        this.genotipo = genotipo;
    }

    public int getFitness() {
        return fitness;
    }

    public void setFitness(int fitness) {
        this.fitness = fitness;
    }

    public int[] getFenotipo() {
        return fenotipo;
    }

    public void setFenotipo(int[] fenotipo) {
        this.fenotipo = fenotipo;
    }
}
