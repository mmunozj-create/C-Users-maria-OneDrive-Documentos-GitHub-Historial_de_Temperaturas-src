/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.historial_de_temperaturas;

/**
 *
 * @author maria
 */
public class Temperatura_ARRAYS_EjemplodePractica {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //Declaración y creación de un arreglo de 4 enteros
    int[] numeros = new int[5];
    
    //Asignación de valores
    numeros[0] = 23;
    numeros[1] = 43;
    numeros[2] = 12;
    numeros[3] = 56;
    numeros[4] = 24;
    
    System.out.println("----Imprimiendo con ciclo For clasico----");
    
    //Recorremos desde el índice i=0 hasta que i sea menor a la longitud del arreglo(5)
    for (int i=0; i < numeros.length; i++){
        System.out.println("Temperatura en la posicion ["+i+"]:" + numeros[i] + "°");
    }
  }   
}