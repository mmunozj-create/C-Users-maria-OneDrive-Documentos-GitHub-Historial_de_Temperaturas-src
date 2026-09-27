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
public class Temperatura_MATRICES {
//
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        //===========================
        //PARTE 1: Dinamica de Matrices (Valores Aleatorios, Transformación y Búsqueda)
        //===========================
        
        System.out.println("===TRABAJO CON MATRICES Y BÚSQUEDA===");
        
        int[][]datos = new int[2][5];
        
        for (int i = 0; i < datos.length; i++) {
            for (int j = 0; j < datos.length; j++) {
                datos[i][j] = random.nextInt(50) + 1;
            }
        }
        System.out.println("\n---Matriz Inicial(2x5)---");
        for (int[] fila : datos){
            for (int valor : fila){
                System.out.print(valor + "\t");
           }
           System.out.println();
        }
        
        int columnas = datos[0].length;
        for (int i = 0; i < datos.length; i++){
            for (int j = 0; j < datos[i].length; j++){
                int indiceLineal = (i * columnas) + j;
                
                if (datos[i][j] % 2 !=0){
                    datos[i][j] = 0;
                }
                
                datos[i][j] = datos[i][j] * indiceLineal;
            }
        }
        
        System.out.println("\n---Matriz Transformada (Pares * índice, Impares -> 0");
        for (int i = 0; i < datos.length; i++){
            for (int j = 0; j < datos[i].length; j++){
                System.out.print("["+i+"]["+j+"]:" + datos[i][j] + "\t");
            }
            System.out.println();
        }
        
        System.out.print("\nIngrese un valor para buscar en la matriz transformadora:");
        int valorBuscar = scanner.nextInt();
        
        int[] resultadoBusqueda = busquedaLinealMatriz(datos, valorBuscar);
        if (resultadoBusqueda != null){
            System.out.println("-> El valor" + valorBuscar + "fue ENCONTRADO en la posición: Fila["+resultadoBusqueda[0]+"], Columna[" + resultadoBusqueda[1]+"]");
        }else{
            System.out.println("-> El valor "+ valorBuscar + "NO se encuentra en la matriz.");
        }
        
        System.out.println("\n" + "=".repeat(60)+ "\n");
        
        //===============================
        //PARTE 2: Historial de Temperaturas del Mes (Matriz 5 semanas x 7 días)
        //===============================
        System.out.println("===HISTORIAL DE TEMPERATURAS EN MATRIZ===");
        
        int[][] temperaturas = new int[5][7];
        int diasTotales = 30;
        int contadorDias = 0;
        
        for (int[] temperatura : temperaturas) {
            for (int j = 0; j < temperatura.length; j++) {
                if (contadorDias < diasTotales) {
                    temperatura[j] = random.nextInt(31) + 10;
                    contadorDias++;
                }
            }
        }
        int suma = 0;
        int tempMinima = Integer.MAX_VALUE;
        int tempMaxima = Integer.MIN_VALUE;
        
        contadorDias = 0;
        for (int[] semana : temperaturas){
            for (int temp : semana){
                if (contadorDias < diasTotales){
                    suma += temp;
                    if (temp < tempMinima) tempMinima = temp;
                    if (temp > tempMaxima) tempMaxima = temp;
                    contadorDias++;
                }
            }
        }
        double promedio = (double) suma / diasTotales;
        
        System.out.printf("Temperatura promedio del mes: %.2f°C\n", promedio);
        System.out.println("Temperatura más fría: " + tempMinima + "°C");
        System.out.println("Temperatura más cálida: " + tempMaxima + "°C");
        
        System.out.print(" ->Día(s) más frío(s): ");
        imprimirDiasExtremos(temperaturas, tempMinima, diasTotales);
        
        System.out.print(" ->Día(s) más cálido(s): ");
        imprimirDiasExtremos(temperaturas, tempMaxima, diasTotales);
        
        System.out.println("\n---GRÁFICA DE TEMPERATURAS DIARIAS (POR SEMANAS Y DÍAS)---");
        contadorDias = 0;
        for (int i = 0; i < temperaturas.length; i++){
            for (int j = 0; j < temperaturas[i].length; j++){
                if (contadorDias < diasTotales){
                    contadorDias++;
                    int tempActual = temperaturas[i][j];
                    
                    System.out.printf("Día %2d (Sem %d, Día 5d) [%2d°C]: ", contadorDias, (i + 1), (j + 1), tempActual);
                    
                    for (int k = 0; k < tempActual; k++){
                        System.out.print("°");
                    }
                    System.out.println();
                }
            }
        }
        scanner.close();  
    }
    
    public static int[] busquedaLinealMatriz(int[][] matriz, int objetivo){
        for (int i = 0; i < matriz.length; i++){
            for (int j = 0; j < matriz[i].length; j++){
                if (matriz[i][j] == objetivo){
                    return new int[]{i,j}; //Retorna la posición [fila, columna
                }
            }
        }
        return null;        
    }
    public static void imprimirDiasExtremos(int[][] matriz, int tempBuscada, int limiteDias){
        int dia = 0;
        for (int[] matriz1 : matriz) {
            for (int j = 0; j < matriz1.length; j++) {
                if (dia < limiteDias) {
                    dia++;
                    if (matriz1[j] == tempBuscada) {
                        System.out.print("Día " + dia + " ");
                    }
                }
            }
        }
        System.out.println();
    }
}
