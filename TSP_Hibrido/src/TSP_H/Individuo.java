/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TSP_H;

import Herrmientas.Herramientas;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author vazqu
 */
public class Individuo {

    private int[] genotipo;
    private int fitness;
    private int fitnessInclinaciones;
    private double fitnessGeneral;
    public int[][] distanciasCaminos;
    public int[] inclinaciones;

    public Individuo() {
    }

    public Individuo(int ciudadInicial, int matrizCargada[][], int[] inclinaciones) {
        genotipo = new int[matrizCargada[0].length];
        genotipo[0] = ciudadInicial;
        this.distanciasCaminos = matrizCargada;
        this.inclinaciones = inclinaciones;
        crearGenotipoAleatorio();
        calcularFitness();
        calcularFitnessInclinaciones();
        calcularFitnessGeneral();
    }

    public Individuo(int genotipo[], int matrizCargada[][], int[] inclinaciones) {
        this.genotipo = genotipo.clone();
        this.distanciasCaminos = matrizCargada;
        this.inclinaciones = inclinaciones;
        calcularFitness();
        calcularFitnessInclinaciones();
        calcularFitnessGeneral();
    }

    public Individuo(int ciudadInicial, int nCiudades, int limiteInclinacion) {
        genotipo = new int[nCiudades];
        genotipo[0] = ciudadInicial;
        this.distanciasCaminos = Herramientas.inicializaCaminos(nCiudades);
        Herramientas.generarInclinaciones(nCiudades, limiteInclinacion);
        this.inclinaciones = Herramientas.getInclinaciones().clone();
        crearGenotipoAleatorio();
        calcularFitness();
        calcularFitnessInclinaciones();
        calcularFitnessGeneral();
    }

    public void calcularFitness() {
        this.fitness = 0;
        if (distanciasCaminos != null) {
            this.fitness = 0;
            for (int j = 1; j < distanciasCaminos.length; j++) {
                this.fitness += distanciasCaminos[this.genotipo[j - 1]][this.genotipo[j]];
            }
            this.fitness += distanciasCaminos[
                    this.genotipo[0]][
                    this.genotipo[distanciasCaminos.length - 1]]; 
        }
    }

    public void calcularFitnessInclinaciones() {

        // recorrer el individudo y consultamos las inclinaciones
        for (int x = 0; x < this.genotipo.length - 1; x++) {
            this.fitnessInclinaciones += inclinaciones[
                    this.genotipo[x]] - inclinaciones[
                    this.genotipo[x + 1]];
        }
        // agregamos la inclinacion de la ultima a la inicial
        this.fitnessInclinaciones += inclinaciones[
                this.genotipo[
                this.genotipo.length - 1]] - inclinaciones[
                this.genotipo[0]];
    }

    private void calcularFitnessGeneral() {
        this.fitnessGeneral = 
                (0.5) * Math.abs(fitness) + (0.5) * Math.abs(fitnessInclinaciones);
    }

    public void calcularFitness2() {
        this.fitness = 0;
        if (distanciasCaminos != null) {
            this.fitness = 0;
            for (int j = 1; j < distanciasCaminos.length; j++) {
                this.fitness += distanciasCaminos[this.genotipo[j - 1]][this.genotipo[j]];
                System.out.println("Distancia " +j+ ": "+ 
                        distanciasCaminos[this.genotipo[j - 1]][this.genotipo[j]]);
            }
            this.fitness += distanciasCaminos[this.genotipo[0]][this.genotipo[distanciasCaminos.length - 1]];
            System.out.println("Distancia 10: " + 
                    distanciasCaminos[this.genotipo[0]][this.genotipo[distanciasCaminos.length - 1]]);

            System.out.println("Fitness: " + this.fitness);
        }

    }

    public void crearGenotipoAleatorio() {
        ArrayList<Integer> ciudades = new ArrayList<>();
        for (int x = 0; x < genotipo.length; x++) {
            ciudades.add(x);
        }
        ciudades.remove(this.genotipo[0]);
        Random ran = new Random();
        // llenar los espacios vacios restantes del genotipo 
        for (int x = 1; x < genotipo.length; x++) {
            int pos = ran.nextInt(ciudades.size());
            int c = ciudades.get(pos);
            this.genotipo[x] = c;
            // eliminamos de las ciudades
            ciudades.remove(pos);
        }
    }

    public void actualizarIndividuo() {
        calcularFitness();
        calcularFitnessInclinaciones();
        calcularFitnessGeneral();
    }

    public void setGenotipo(int[] genotipo) {
        this.genotipo = genotipo;
    }

    public void setFitness(int fitness) {
        this.fitness = fitness;

    }

    public void setFitness() {
        calcularFitness();
    }

    public void setDistanciasCaminos(int[][] distanciasCaminos) {
        this.distanciasCaminos = distanciasCaminos;
    }

    public int[] getGenotipo() {
        return genotipo;
    }

    public int getFitness() {
        return fitness;
    }

    public int[][] getDistanciasCaminos() {
        return distanciasCaminos;
    }

    public int getFitnessInclinaciones() {
        return fitnessInclinaciones;
    }

    public void setFitnessInclinaciones(int fitnessInclinaciones) {
        this.fitnessInclinaciones = fitnessInclinaciones;
    }

    public int[] getInclinaciones() {
        return inclinaciones;
    }

    public void setInclinaciones(int[] inclinaciones) {
        this.inclinaciones = inclinaciones;
    }

    public double getFitnessGeneral() {
        return fitnessGeneral;
    }

    public void setFitnessGeneral(double fitnessGeneral) {
        this.fitnessGeneral = fitnessGeneral;
    }

}
