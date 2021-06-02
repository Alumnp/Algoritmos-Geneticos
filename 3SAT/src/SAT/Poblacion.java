/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAT;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author vazqu
 */
public class Poblacion {

    private ArrayList<Individu> indivduos;

    public Poblacion(int numInd) {
        this.indivduos = new ArrayList<>();
        for (int x = 0; x < numInd; x++) {
            this.indivduos.add(new Individu());
        }

    }

    public ArrayList<Individu> getNMejores(int n) {
        // validar que n <= tamaño de la población
        if (n < this.indivduos.size()) {
            // ordenar a la población
            ordenarPoblacionActual();
            // creamos un coleccion nueva de individuos
            ArrayList<Individu> muestra = new ArrayList<>();

            for (int x = this.indivduos.size() - 1; x >= this.indivduos.size() - n; x--) {

                Individu e = new Individu(this.indivduos.get(x).getGenotipo());
                muestra.add(e);
            }
            return muestra;
        }

        return (ArrayList<Individu>) this.indivduos.clone();
    }

    public Poblacion(ArrayList<Individu> aux) {
        this.indivduos = (ArrayList<Individu>) aux.clone();
    }

    public Individu getMejor() {
        int idMejor = 0;
        for (int x = 1; x < this.indivduos.size(); x++) {
            if (this.indivduos.get(x).getFitness() > this.indivduos.get(idMejor).getFitness()) {
                idMejor = x;
            }
        }
        return new Individu(this.indivduos.get(idMejor).getGenotipo());

    }

    public ArrayList<Individu> getMuestraAleatoria(int n) {
        // validar que n <= tamaño de la población
        if (n < this.indivduos.size()) {
            // creamos un coleccion nueva de individuos
            ArrayList<Individu> muestra = new ArrayList<>();
            Random ran = new Random();
            for (int x = 0; x < n; x++) {
                int pos = ran.nextInt(this.indivduos.size());
                Individu e = new Individu(this.indivduos.get(pos).getGenotipo());
                muestra.add(e);
            }
            return muestra;
        }

        return (ArrayList<Individu>) this.indivduos.clone();
    }

    /**
     * @return the indivduos
     */
    public ArrayList<Individu> getIndivduos() {
        return indivduos;
    }

    private void ordenarPoblacionActual() {
        for (int z = 1; z < this.indivduos.size(); ++z) {
            for (int v = 0; v < (this.indivduos.size() - z); ++v) {

                if (this.indivduos.get(v).getFitness()
                        > this.indivduos.get(v + 1).getFitness()) {
                    Individu aux = new Individu(this.indivduos.get(v).getGenotipo());
                    this.indivduos.set(v, new Individu(this.indivduos.get(v + 1).getGenotipo()));
                    this.indivduos.set(v + 1, aux);

                }
            }
        }

    }

}
