package aed;

import java.util.Scanner;
import java.io.FileInputStream;
import java.io.PrintStream;

class Archivos {
    float[] leerVector(Scanner entrada, int largo) {
        float[] vector = new float[largo];

        for (int i = 0; i < largo; i++) {
            if (entrada.hasNextFloat()) {
                vector[i] = entrada.nextFloat();
            } else {
                System.out.println("No hay suficientes valores en el archivo.");
                break;
            }
        }

        return vector;
    }

    float[][] leerMatriz(Scanner entrada, int filas, int columnas) {

        float[][] matriz = new float[filas][columnas];

        for (int i = 0; i < filas; i++) {

            float[] vector = new float[columnas];
            
            for (int j = 0; j < columnas; j++) {

                if (entrada.hasNextFloat()) {
                    vector[j] = entrada.nextFloat();
                } else {
                    System.out.println("No hay suficientes valores en el archivo.");
                    break;
                }
            }
            
            matriz[i] = vector;
        }

        return matriz;
    }

    void imprimirPiramide(PrintStream salida, int alto) {

        for (int i = 1; i <= alto; i++) {
            
            for (int j = 1; j <= alto - i; j++) {
                salida.print(" ");
            }
            
            for (int j = 1; j <= 2 * i - 1; j++) {
                salida.print("*");
            }

            for (int j = 1; j <= alto - i; j++) {
                salida.print(" ");
            }
            
            salida.println(); 
        }
    }
}
