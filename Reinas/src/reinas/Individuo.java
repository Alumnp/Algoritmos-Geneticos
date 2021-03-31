/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reinas;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

/**
 *
 * @author vazqu
 */
public class Individuo {

    private int[] genotipo;
    private int fitness;

    public Individuo(int reinas) {
        this.genotipo = new int[reinas];
        this.fitness = 0;
        inicializarAleatoriamente();
        calcularFitness();
    }

    public Individuo(int genotipo[]) {
        this.genotipo = genotipo.clone();
        calcularFitness();
    }

    private void inicializarAleatoriamente() {
        Random ran = new Random();
        LinkedList<Integer> reinas = new LinkedList<>();
        for (int i = 0; i < this.genotipo.length; i++) {
            reinas.add(i);
        }
        for (int i = 0; i < this.genotipo.length; i++) {
            int pos = ran.nextInt(reinas.size());
            this.genotipo[i] = reinas.get(pos);
            reinas.remove(pos);
        }
    }

    public void calcularFitness() {
        // Ataques diagonales
//        int atkD = 0;
////        
//        for (int i = 0; i < this.genotipo.length; i++) {
//            int reinaActual = this.genotipo[i];
//            for (int j = i+1; j < this.genotipo.length; j++) {
//                int reinaNueva = this.genotipo[j];
//                int posComp = j-i;
//                if( reinaActual==reinaNueva||reinaActual ==  reinaNueva-posComp || reinaActual ==  reinaNueva+posComp )
//                    atkD++;
//            }
//        }
//        
//        this.fitness = atkD;
        for (int x = 0; x < this.genotipo.length - 1; x++) {
            for (int y = x + 1; y < this.genotipo.length; y++) {
                int a = this.genotipo[x];
                int b = this.genotipo[y];
                int auxx = this.genotipo[x] - x;
                int auxy = this.genotipo[y] - y;
                int aux2x = this.genotipo[x] + x;
                int aux2y = this.genotipo[y] + y;
                if (a == b || auxx == auxy || aux2x == aux2y) {
                    this.fitness += 2;
                }
            }
        }
    }
   

    @Override
    public String toString() {
       
        String aux = "Genotipo: " + Arrays.toString(this.genotipo) + "\n Fitness: " + this.fitness;

        return aux;
    }

    /* Getters & Setters */
    public int[] getGenotipo() {
        return this.genotipo;
    }

    public int getFitness() {
        return this.fitness;
    }

    public void setGenotipo(int genotipo[]) {
        this.genotipo = genotipo.clone();
        calcularFitness();
    }
}
