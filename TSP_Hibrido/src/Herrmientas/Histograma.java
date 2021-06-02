/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Herrmientas;

/**
 *
 * @author vazqu
 */
public class Histograma {

    private int[] fitnessMejores;

    public Histograma(int fitnessMejores[]) {
        this.fitnessMejores = new int[fitnessMejores.length];
        this.fitnessMejores = fitnessMejores.clone();
    }
//Usamos el la clase graficar en el histograma para tener mejor flexibilidad a 
    //la hora de solicitar los datos
    public void graficar() {
        Grafica t = new Grafica("Generaciones", "Fitnnes", "Grafica De Fitnes");
        t.agregrarSerie(fitnessMejores, "0");
        t.creaYmuestraGrafica();

    }

    public int[] getFitnessMejores() {
        return fitnessMejores;
    }

    public void setFitnessMejores(int[] fitnessMejores) {
        this.fitnessMejores = fitnessMejores;
    }

}
