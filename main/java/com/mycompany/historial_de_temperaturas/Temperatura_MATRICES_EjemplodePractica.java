/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.historial_de_temperaturas;

/**
 *
 * @author maria
 */
public class Temperatura_MATRICES_EjemplodePractica {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //Declaración de una Matriz de 4 filas por 4 columnas
        int[][] matriz = new int[5][5];
        
        //Asignación de valores
        matriz[0][0] = 23; 
        matriz[0][1] = 43;
        matriz[1][2] = 12;
        matriz[2][3] = 56;
        matriz[3][4] = 24;
        matriz[4][4] = 13;
        
        //Recorrer una matriz completa (requiere dos ciclos anidados)
        for (int i=0; i < matriz.length; i++){
            for (int j=0; j < matriz[i].length; j++){
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
}