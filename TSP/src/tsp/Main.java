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
        GeneradorInstanciasTSP.cargarMatriz("m3.txt");

        Genetico g = new Genetico(25000, 45, 500, 4, 10);

        Scanner sc = new Scanner(System.in);

        System.out.print("Desea cargar el genetico Si(1), No(2): ");
        double x = sc.nextDouble(); //asigna a la variable x el número double introducido por teclado 
        if (x == 1) {
            //Cargar gentico
            g.evolucionar(Herramientas.cargarIndividuo("10_4_i_27-04-2021.txt"));
//            System.out.println(g.getMejor());
            System.out.println();
        } else if (x == 2) {
            //Crear y guardar el genetico
        
            g.evolucionar();
            System.out.println(g.getMejor());
            Herramientas.guardarMejor(g.getMejor());

            System.out.println();
        }
    }
}
