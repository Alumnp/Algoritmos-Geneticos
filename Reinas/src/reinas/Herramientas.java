/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reinas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

/**
 *
 * @author vazqu
 */
public class Herramientas {

    public static void Informacion(Individuo mejor) {
        BufferedWriter bw = null;
        FileWriter fw = null;
        PrintWriter wr = null;

        try {
            String data = "Hola stackoverflow.com...";
            File file = new File("Informacion.txt");
            // Si el archivo no existe, se crea!
            if (!file.exists()) {
                file.createNewFile();
            }
            // flag true, indica adjuntar información al archivo.
            fw = new FileWriter(file.getAbsoluteFile(), true);
            bw = new BufferedWriter(fw);
            wr = new PrintWriter(bw);
            //FITNESS
            wr.println("\nFitness: " + mejor.getFitness());

            //GENOTIPO
            wr.println("Genotipo: ");
            for (int i = 0; i < mejor.getGenotipo().length; i++) {
                if (i == mejor.getGenotipo().length - 1) {
                    wr.println(mejor.getGenotipo()[i]);
                } else {
                    wr.print(mejor.getGenotipo()[i] + ",");
                }
            }
            System.out.println("información agregada!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //Cierra instancias de FileWriter y BufferedWriter
                if (bw != null) {
                    bw.close();
                }
                if (fw != null) {
                    fw.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void Datos(Individuo mejor) {
        BufferedWriter bw = null;
        FileWriter fw = null;
        PrintWriter wr = null;

        try {
            File file = new File("Datos.txt");
            // Si el archivo no existe, se crea!
            if (!file.exists()) {
                file.createNewFile();
            }
            // flag true, indica adjuntar información al archivo.
            fw = new FileWriter(file.getAbsoluteFile(), true);
            bw = new BufferedWriter(fw);
            wr = new PrintWriter(bw);
            //FITNESS
            wr.println(+mejor.getFitness());

            System.out.println("Dato agregado!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //Cierra instancias de FileWriter y BufferedWriter
                if (bw != null) {
                    bw.close();
                }
                if (fw != null) {
                    fw.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static Individuo cargarIndividuo(String ruta) {
        String linea;
        LinkedList<String> lineas = new LinkedList<>();
        Individuo individuo = null;

        try {

            //Abrimos el archivo seleccionado
            File abre = new File(ruta);
            FileReader archivos = new FileReader(abre);
            BufferedReader lee = new BufferedReader(archivos);

            //Agregamos cada renglon a la coleccion "lineas"
            while ((linea = lee.readLine()) != null) {
                lineas.add(linea);
            }
            lee.close();

            //NUMERO DE REINAS
            String aux = lineas.get(0);
            int nReinas = Integer.parseInt(aux);
            int genotipo[] = new int[nReinas];

            //GENOTIPO
            //Tokenizar cada una de las lineas
            aux = lineas.get(2);
            StringTokenizer tokens = new StringTokenizer(aux, ",");

            int c = 0;
            while (tokens.hasMoreTokens()) {
                int valor = Integer.parseInt(tokens.nextToken());
                genotipo[c] = valor;
                c++;
            }

            individuo = new Individuo(genotipo);

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex + ""
                    + "\nNo se ha encontrado el archivo",
                    "ADVERTENCIA!!!", JOptionPane.WARNING_MESSAGE);

        }

        return individuo;
    }
}
