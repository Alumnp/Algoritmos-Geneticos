/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Herrmientas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import javax.swing.JFileChooser;

/**
 *
 * @author vazqu
 */
public class Herramientas {

    public static int distancias[][];
    public static int inclinaciones[];

    public static int[][] inicializaCaminos(int n) {
        int[][] recorridos = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    recorridos[i][j] = 0;
                } else if (recorridos[i][j] == 0) {
                    int nuevo = generarCaminoNuevo();
                    recorridos[i][j] = nuevo;
                    recorridos[j][i] = nuevo;
                }

            }
        }
        return recorridos;
    }

    public static void imprimirMat(int distancias[][]) {
        System.out.println("Matriz de distancias");
        for (int i = 0; i < distancias.length; i++) {
            for (int j = 0; j < distancias.length; j++) {

                if (j == distancias.length - 1) {
                    System.out.println(distancias[i][j]);

                } else {
                    System.out.print(distancias[i][j] + ",");
                }

            }
        }

    }

    public static int generarCaminoNuevo() {
        Random ran = new Random();
        int aux = ran.nextInt(10);
        return aux;
    }

    public static void generarInclinaciones(int numCiudades,
            int limInclinacion) {
        inclinaciones = new int[numCiudades];
        Random ran = new Random();

        for (int y = 0; y < numCiudades; y++) {

            int incli = ran.nextInt(limInclinacion) + 1;

            inclinaciones[y] = incli;

        }

    }

    public static void escribir(int matrizEscribe[][],
            int matrizInclinaciones[]) {
        File f = new File("Matriz");
        if (!f.exists()) {
            f.mkdirs();
        }
        String carpeta = f.getAbsolutePath();
        try {

            FileWriter fi = new FileWriter(carpeta + "\\Matriz.txt");
            BufferedWriter bs = new BufferedWriter(fi);
            for (int i = 0; i < matrizEscribe[0].length; i++) {
                String linea = Arrays.toString(matrizEscribe[i]);
                char[] aux = linea.substring(1,
                        linea.length() - 1).toCharArray();
                for (int j = 0; j < aux.length - 1; j++) {
                    if (aux[j] == 32 || aux[j] == 44) {
                    } else {
                        bs.append(aux[j]);
                        bs.append(",");
                    }
                }
                bs.append(aux[aux.length - 1]);
                bs.append("\n");
            }
            bs.close();

            //aqui vamos a escribir el archivo de inclinaciones
            FileWriter fI = new FileWriter(carpeta
                    + "\\InclinacionesDeMatriz.txt");
            BufferedWriter bI = new BufferedWriter(fI);

            String linea = Arrays.toString(matrizInclinaciones);
            char[] aux = linea.substring(1,
                    linea.length() - 1).toCharArray();

            for (int i = 0; i < aux.length; i++) {

                if (aux[i] == 32 || aux[i] == 44) {
                } else {
                    bI.append(aux[i]);
                    if (i != aux.length - 1) {
                        bI.append(",");
                    }
                }
            }
            bI.append("\n");
            bI.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static int[][] cargarMatrizDeDistancias() {
        FileReader archivos = null;
        try {
            String cadenaLeyendo;
            JFileChooser file = new JFileChooser();
            file.showOpenDialog(file);
            //abrimos el archivo seleccionado
            File abre = file.getSelectedFile();
            archivos = new FileReader(abre);
            BufferedReader lee = new BufferedReader(archivos);
            ArrayList<ArrayList<Integer>> matriz = new ArrayList();
            if (abre != null) {
                int i = 0;

                while ((cadenaLeyendo = lee.readLine()) != null) {
                    String[] linea = cadenaLeyendo.split(",");
                    ArrayList<Integer> lineaArrayList = new ArrayList();
                    for (int j = 0; j < linea.length; j++) {
                        lineaArrayList.add(Integer.parseInt(linea[j]));
                    }
                    matriz.add(lineaArrayList);
                    i++;
                }
                lee.close();
            }
            distancias = new int[matriz.size()][matriz.size()];
            for (int i = 0; i < matriz.size(); i++) {
                for (int j = 0; j < matriz.get(0).size(); j++) {
                    distancias[i][j] = matriz.get(i).get(j);
                }
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                archivos.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return distancias;
    }

    public static int[] cargarInclinaciones() {
        FileReader archivos = null;
        try {
            JFileChooser file = new JFileChooser();
            file.showOpenDialog(file);
            //abrimos el archivo seleccionado
            File abre = file.getSelectedFile();
            archivos = new FileReader(abre);
            BufferedReader lee = new BufferedReader(archivos);

            if (abre != null) {
                String[] valores = lee.readLine().split(",");
                inclinaciones = new int[valores.length];
                for (int x = 0; x < valores.length; x++) {
                    //System.out.println(valores[x]);
                    inclinaciones[x] = Integer.parseInt(valores[x]);
                }
                lee.close();
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                archivos.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return inclinaciones;
    }

    public static int[] getInclinaciones() {
        return inclinaciones;
    }
    
    public static void setInclinaciones(int[] inclinaciones) {
        Herramientas.inclinaciones = inclinaciones;
    }

}
