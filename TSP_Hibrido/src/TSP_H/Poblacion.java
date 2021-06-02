/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TSP_H;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author vazqu
 */
public class Poblacion {

    private ArrayList<Individuo> individuos;

    public Poblacion(ArrayList<Individuo> aux) {
        this.individuos = (ArrayList<Individuo>) aux.clone();
    }

    public Poblacion(int tamPob, int ciudadInicial, int nCiudades, int limiteinclinacion) {
        this.individuos = new ArrayList<>();

        Individuo auxIND = new Individuo(ciudadInicial, nCiudades, limiteinclinacion);

        for (int i = 0; i < tamPob; i++) {
            Individuo auxIND2 = new Individuo(ciudadInicial, nCiudades, limiteinclinacion);
            auxIND2.setDistanciasCaminos(auxIND.getDistanciasCaminos().clone());
            auxIND2.setInclinaciones(auxIND.getInclinaciones().clone());

            this.individuos.add(auxIND2);
        }
    }

    public Poblacion(int tamPob, int ciudadInicial, 
            int matrizCargada[][], int[] inclinaciones) {
        this.individuos = new ArrayList<>();

        for (int i = 0; i < tamPob; i++) {
            this.individuos.add(new Individuo(ciudadInicial, 
                    matrizCargada.clone(), inclinaciones.clone()));
        }
    }

    public ArrayList<Individuo> getMejoresIndividuos(int n) {
        // Validamos que n no sea mas grande que el tamaño de la población
        if (n <= this.individuos.size()) { 
            // ordenar a la población
            ordenarPoblacionActual();
            // creamos un ArrayList nuevo de individuos
            ArrayList<Individuo> nMejores = new ArrayList<>();

            for (int x = 
                    this.individuos.size() - 1; x >= 
                    this.individuos.size() - n; x--) { //recorremos la lista ordenada de atras para delante

                Individuo e = new Individuo(
                        this.individuos.get(x).getGenotipo(), 
                        this.individuos.get(x).getDistanciasCaminos(), 
                        this.individuos.get(x).getInclinaciones());
                nMejores.add(e);
            }
            return nMejores;
        }

        return (ArrayList<Individuo>) this.individuos.clone();
    }

    public Individuo getMejorIndividuo() {
        int idMejor = 0;
        for (int x = 1; x < this.individuos.size(); x++) {
            if (
                    this.individuos.get(x).getFitnessGeneral() < 
                    this.individuos.get(idMejor).getFitnessGeneral()) { 
                idMejor = x;
            }
        }
        return this.individuos.get(idMejor);
    }

    public ArrayList<Individuo> getIndividuos() {
        return individuos;
    }

    private void ordenarPoblacionActual() {
        for (int z = 1; z < this.individuos.size(); z++) {
            for (int v = 0; v < (this.individuos.size() - z); v++) {
                if (this.individuos.get(v).getFitnessGeneral()
                        < this.individuos.get(v + 1).getFitnessGeneral()) {
                    Individuo aux = 
                            new Individuo(
                                    this.individuos.get(v).getGenotipo(), 
                                    this.individuos.get(v).getDistanciasCaminos(), 
                                    this.individuos.get(v).getInclinaciones());
                    this.individuos.set(v, 
                            new Individuo(
                            this.individuos.get(v + 1).getGenotipo(), 
                                    this.individuos.get(v + 1).getDistanciasCaminos(), 
                                    this.individuos.get(v + 1).getInclinaciones()));
                    this.individuos.set(v + 1, aux);
                }
            }
        }

    }

    public int getFitnessTotal() {
        int acumulador = 0;

        for (int i = 0; i < individuos.size(); i++) {
            acumulador += individuos.get(i).getFitnessGeneral();
        }
        return acumulador;
    }

    public void mostrarPob() {
        System.out.println("----- Tengo " + individuos.size() + " individuos -----");
        for (int z = 0; z < individuos.size(); z++) {
            String aux = "Genotipo: ";
            aux += Arrays.toString(individuos.get(z).getGenotipo());
            aux += " Fitness => " + individuos.get(z).getFitnessGeneral();
            System.out.println("------- " + z + " -------");
            System.out.println(aux);
            System.out.println("");
        }
    }

    public void setIndividuos(ArrayList<Individuo> individuos) {
        this.individuos = individuos;
    }

}
