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
public class Genetico {

    private int num_G;
    private double pMuta;
    private Poblacion pobActual;
    private int tamPob;

    public Genetico(int num_G, double pMuta, int tamPob) {
        this.num_G = num_G;
        this.pMuta = pMuta;
        this.tamPob = tamPob;
        // generamos la poblacian inicial como aleatoria
        this.pobActual = new Poblacion(tamPob);
    }

    public void evolucionar() {
        int mascara[] = new int[]{1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1,
            0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1};
        // proceso evolutivo donde se generan nuevas poblaciones
        Individuo mejor;
        for (int g = 0; g < this.num_G; g++) {
            Poblacion nueva = new Poblacion();
            // se agregan los individuos de la poblacian
            mejor = new Individuo(new int[31]);
            for (int i = 0; i < this.tamPob; i++) {
                // proceso de Seleccian
                Individuo madre = Seleccion.seleccionAleatoria(this.pobActual);
                Individuo padre = Seleccion.seleccionAleatoria(this.pobActual);
                // proceso de Cruza
                Individuo hijo = Cruza.cruzaPorMascara(mascara, madre, padre);
                // proceso de Mutacion

                if (Math.random() < this.pMuta) {
                    Muta.aplicarMutaAleatoria(hijo);
                    // mutar por referencia al hijo
                }
                // el hijo generado se agregar a la nueva poblacian
                nueva.getPoblacion().add(hijo);
                if (hijo.getFitness() > mejor.getFitness()) {
                    mejor = new Individuo(hijo.getGenotipo());
                }
            }
            System.out.println("Generacion numero: " + g + " "
                             + "Mejor Caso: " + mejor.toString());
            // actualizar la poblacian actual 
            this.pobActual = new Poblacion(nueva);
        }
        System.out.println();

    }

}
