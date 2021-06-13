/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herramientas;

/**
 *
 * @author vazqu
 */
public class Datos 
{
    private int[][] List;
    private int tamArray;
    private int numPos;
    private int numVar;

    public Datos(int[][] List, int tamArray, int numPos, int numVar) {
        this.List = List;
        this.tamArray = tamArray;
        this.numPos = numPos;
        this.numVar = numVar;
    }

    public int[][] getList() {
        return List;
    }

    public void setList(int[][] List) {
        this.List = List;
    }

    public int getTamArray() {
        return tamArray;
    }

    public void setTamArray(int tamArray) {
        this.tamArray = tamArray;
    }

    public int getNumPos() {
        return numPos;
    }

    public void setNumPos(int numPos) {
        this.numPos = numPos;
    }

    public int getNumVar() {
        return numVar;
    }

    public void setNumVar(int numVar) {
        this.numVar = numVar;
    }

}
