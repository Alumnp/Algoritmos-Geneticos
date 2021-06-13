/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binario;

/**
 *
 * @author vazqu
 */
public class Main {

    public static void main(String[] args) {

        Genetico gen = new Genetico(25000, 0.1, 100);
        gen.evolucionar();
        System.out.println();
    }

}
