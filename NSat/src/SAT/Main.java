/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAT;

/**
 *
 * @author vazqu
 */
public class Main {

    public static void main(String[] args) {
        Genetico_SAT gen = new Genetico_SAT(100, 25000, 0.1);
        gen.evolucionar();
        System.out.println();
    }
}
