/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TSP_H;

import Herrmientas.Herramientas;

/**
 *
 * @author vazqu
 */
public class Main {

   public static void main(String[] args) {
        //Adopte este formato para que sea mas facil de entender, es parecido a la practica anterior
        int numGeneraciones = 25000;
        int tamPoblacion = 100;
        int nCiudades = 500;
        int ciudadInicial = 1;
        double pMuta = 0.1;

        if (ciudadInicial < nCiudades) {
            Genetico tsp2 = new Genetico(numGeneraciones, tamPoblacion, pMuta, ciudadInicial, Herramientas.cargarMatrizDeDistancias(), Herramientas.cargarInclinaciones());
            tsp2.crearNuevasGeneraciones();
        }
    }
}
