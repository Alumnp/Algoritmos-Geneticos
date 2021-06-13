package TSP;

import herramientas.Grafica;
import java.util.ArrayList;
import java.util.Random;

public class Genetico_TSP 
{
    
    private int tamanoPob;
    private int numGeneraciones;
    private double probMuta;
    private int bits;
    private ArrayList<Individuo_TSP> poblacionActual;
    
    private int ciudadInicial;

    public Genetico_TSP(int tamanoPob, int numGeneraciones, double probMuta,int bits, int ciudadInicial) 
    {
        this.tamanoPob = tamanoPob;
        this.numGeneraciones = numGeneraciones;
        this.probMuta = probMuta;
        this.bits =bits;
        this.poblacionActual = new ArrayList<>();
        
        this.ciudadInicial = ciudadInicial;
    }
    
    public void evolucionar()
    {
        int[] valores = new int[numGeneraciones];
        generarPoblacionInicial();    
        Individuo_TSP mejor = Herramientas_TSP.mejorPoblacion(poblacionActual);
        valores[0] = mejor.getFitness();
        
        // proceso evolutivo que tiene relación con el numero de generaciones
        for(int g=1;g<this.numGeneraciones;g++)
        {
            ArrayList<Individuo_TSP> nuevaPob = new ArrayList<>();
            // garantizar que se va a generar una población nueva 
            for (int i=0; i<this.tamanoPob;i++)
            {
                // Seleccion de una madre 
                Individuo_TSP madre = Seleccion.seleccionAleatoria(this.getPoblacionActual());
                // Seleccion de un padre
                Individuo_TSP padre = Seleccion.seleccionAleatoria(this.getPoblacionActual());
                // cruza (Retornar el mejor ind de la cruza)
                Individuo_TSP hijo = Cruza_TSP.cruzaPorMascaraBinaria(madre, padre);
                // Se aplica una muta evaluando una probabilidad
                if (generarProbabilidadMuta())
                {
                   Muta_TSP.mutaSimple(hijo);
                }
                nuevaPob.add(hijo);
            }
            // actualización de la población
            sustituirPoblacion(nuevaPob);
            mejor = Herramientas_TSP.mejorPoblacion(poblacionActual);
            valores[g] = mejor.getFitness();
        }
        
        System.out.println("Num generaciones: "+valores.length);
    }

    private void generarPoblacionInicial() 
    {
       // generar un población aleatoria de individuos
       int[][] array = herramientas.LeerDatos.tokenizarDataSet();
       
       //int[][] array = new int[][]{{0,64,22,64},{64,0,51,60},{22,51,0,50},{64,60,50,0}}; 
       for(int i=0; i < this.tamanoPob;i++)
       {
           int[] ruta = new int[array.length];
           ruta[0] = ciudadInicial;
           for(int x = 1; x < array.length; x++)
           {
               boolean diferente = true;
               Random numAleatorio = new Random();
               int aux = 0;
               while(diferente)
               {
                    diferente = false;
                    aux = numAleatorio.nextInt(array.length);
                    for(int y = 0; y < ruta.length; y++)
                    {
                        if(ruta[y] == aux)
                        {
                            diferente = true;
                        }
                    }
               }
               ruta[x] = aux;
           }
           this.getPoblacionActual().add(new Individuo_TSP(array,ruta));
       }
    }

    private boolean generarProbabilidadMuta() 
    {
       
        if (this.probMuta>Math.random())
        {
           return true;
        } 
        else{ return false;}
        
    }

    private void sustituirPoblacion(ArrayList<Individuo_TSP> nuevaPob) 
    {
       this.getPoblacionActual().clear();
       for(Individuo_TSP aux:nuevaPob)
       {
           this.getPoblacionActual().add(new Individuo_TSP(aux));
       }
    }

    /**
     * @return the poblacionActual
     */
    public ArrayList<Individuo_TSP> getPoblacionActual() 
    {
        return poblacionActual;
    }

  
}
