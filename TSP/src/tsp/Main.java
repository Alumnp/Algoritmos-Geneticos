/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsp;

import Herramientas.GeneradorInstanciasTSP;
import java.util.Scanner;

/**
 *
 * @author vazqu
 */
public class Main {

    public static void main(String[] args) {
        GeneradorInstanciasTSP.cargarMatriz("Matriz_20_50.txt");

        Genetico g = new Genetico(25000, 45, 100, 1, GeneradorInstanciasTSP.INSTANCIAS.length);
        Scanner sc = new Scanner(System.in);
        System.out.print("Desea cargar el genetico Si(1), No(2): ");
        double x = sc.nextDouble(); //asigna a la variable x el número double introducido por teclado 
        
        if (x == 1) {
            //Cargamos los datos obtenidos anteriormente
            g.evolucionar(Herramientas.cargarIndividuo("Guardado.txt"));
            System.out.println(g.getMejor());
            System.out.println();

        } else if (x == 2) {
            //Crear y guardar los datos para caragarlos
            g.evolucionar();
            System.out.println(g.getMejor());
            Herramientas.Informacion(g.getMejor());
            Herramientas.Datos(g.getMejor());
            Herramientas.guardarMejor(g.getMejor());
            System.out.println();

        }
        grafica t = new grafica("Generaciones", "Fitnnes", "Grafica De Fitnes");
        t.agregrarSerie(g.Sacar(), "0");
        t.creaYmuestraGrafica();
    }
}
