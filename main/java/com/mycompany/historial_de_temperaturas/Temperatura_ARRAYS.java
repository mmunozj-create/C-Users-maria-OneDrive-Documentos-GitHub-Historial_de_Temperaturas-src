/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.historial_de_temperaturas;

/**
 *
 * @author maria
 */
import java.util.Random;
import java.util.Scanner;
public class Temperatura_ARRAYS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        //==========================================
        //PARTE1: Dinamica básica de Arreglos 
        //==========================================
        System.out.println("=== Dinamica de Arreglos de 10 Enteros ===");
        
        int[] datos = new int[10];
        for (int i = 0; i < datos.length; i++){
            datos[i] = random.nextInt(50) + 1;
        }
        
        System.out.print("Arreglo inicial: ");
        for (int valor : datos){
            System.out.print(valor + " ");
        }
        System.out.println();
        
        for (int i = 0; i < datos.length; i++){
            if (datos[i] % 2 != 0){
                datos[i] = 0; //Cambia impares por cero
            }
            datos[i] = datos[i] * i; //Multiplica por su índice
        }
        
        System.out.print("Arreglo transformado (pares * indice, impares -> 0):");
        for (int i = 0; i < datos.length; i++){
            System.out.print("["+ i +"]:" + datos[i] + " ");
        }
        System.out.println("\n");
        
        System.out.print("Ingrese un valor para buscar en el arreglo transformado: ");
        int valorBuscar = scanner.nextInt();
        int posicionEncontrada = busquedaLineal(datos, valorBuscar);
        
        if (posicionEncontrada != -1){
            System.out.println("-> El valor " + valorBuscar + "fue ENCONTRADO en la posición/índice: " + posicionEncontrada);
        }else{
            System.out.println("-> El valor " + valorBuscar + "NO se encuentra en el arreglo.");
        }
        
        System.out.println("\n" + "=".repeat(50) + "\n");
        
        //===================================
        //PARTE 2: Historial de Temperaturas del mes
        //===================================
        System.out.println("== Historial de Temperaturas del Mes (30 días) ");
        
        int diasDelMes = 30;
        int[] temperaturas = new int[diasDelMes];
        
        for (int i = 0; i < temperaturas.length; i++){
            temperaturas[i] = random.nextInt(31) + 10;
        }
        
        int suma = 0;
        int tempMinima = temperaturas[0];
        int tempMaxima = temperaturas[0];
        
        for (int temp : temperaturas){
            suma += temp;
            if (temp < tempMinima) tempMinima = temp;
            if (temp > tempMaxima) tempMaxima = temp;
        }
        
        double promedio = (double) suma / temperaturas.length;
        
        System.out.printf("Temperatura promedio del mes: %.2f°C\n", promedio);
        System.out.println("Temperatura más fría: " + tempMinima + "°C");
        System.out.println("Temperatura más cálida: " + tempMaxima + "°C");
        
        System.out.print(" -> Día(s) más frío(s): ");
        for (int i = 0; i < temperaturas.length; i++){
            if (temperaturas[i] == tempMinima){
                System.out.print("Día " + (i + 1) + " ");
            }
        }
        System.out.println();
        
        System.out.print(" -> Día(s) más cálido(s): ");
        for (int i = 0; i < temperaturas.length; i++){
            if (temperaturas[i] == tempMaxima){
                System.out.print("Día " + (i + 1) + " ");
            }
        }
        System.out.println("\n");
        
        System.out.println("---GRAFICA DE TEMPERATURAS DIARIAS---");
        for (int i = 0; i < temperaturas.length; i++){
            System.out.printf("Día %2d [%2d°C]: ", (i + 1), temperaturas[i]);
            
            for (int j = 0; j < temperaturas[i]; j++){
                System.out.print("°");
            }
            System.out.println();
        }
        
        scanner.close();
        
    }
    public static int busquedaLineal(int[] arreglo, int objetivo){
        for (int i = 0; i < arreglo.length; i++){
            if (arreglo[i] == objetivo){
                return i;
            }
        }
        return -1;
    }
    
}
