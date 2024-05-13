# **Método de Gauss-Seidel**

Es un metodo iterativo el cual se utiliza para hallar soluciones aproxmiadas de un sistema de ecuaciones algrebica lineal, con una precion arbitrariamente elegida.

Esta se aplica en matrices cuadradas con elementos no nulos en sus diagonales ademas de que convergencia se garantiza si la matriz es diagonalmente dominante.

## Algoritmo

1. Se obtiene el sistema de ecuaciones
2. Se crea el sistema matricial del sistema de ecuaciones
3. Se empieza a recorrer el sistema por fila para
   - Calcular el valor para cada incognita de la ecucacion
     - Si esta en la posicion i==j dividira la incognita / i
     - Si se esta en una posicion i!=j se restara a la incognita
   - Se actualiza el valor de la incognita por la obtenida aproximadamente
   - Se obtiene el error con x1Anterior, x2Anterior, x3Anterior con x1,x2,x3
   - Pasa a la siguiente fila hasta terminar
4. Se repite el paso 3 hasta que el valor del error sea menor al valor de error dado

## Codigo en Java
```java
package Paquete01;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
  
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Pedir al usuario el tamaño del sistema de ecuaciones
        System.out.print("Ingrese el número de ecuaciones: ");
        int n = scanner.nextInt();

        // Crear matrices para almacenar los coeficientes y los términos independientes
        double[][] coeficientes = new double[n][n];
        double[] b = new double[n];

        // Pedir al usuario los coeficientes y términos independientes
        System.out.println("Ingrese los coeficientes de las ecuaciones:");
        for (int i = 0; i < n; i++) {
            System.out.printf("Ecuación %d:\n", i + 1);
            for (int j = 0; j < n; j++) {
                System.out.printf("Coeficiente %d: ", j + 1);
                coeficientes[i][j] = scanner.nextDouble();
            }
            System.out.print("Término independiente: ");
            b[i] = scanner.nextDouble();
        }

        // Pedir al usuario el porcentaje de error aceptado
        System.out.print("Ingrese el porcentaje de error aceptado: ");
        double error = scanner.nextDouble();

        // Llamar al método GaussSeidel para calcular los resultados
        double[] resultados = gaussSeidel(coeficientes, b, error);

        // Imprimir los resultados
        System.out.println("Resultados:");
        for (int i = 0; i < n; i++) {
            System.out.printf("x%d = %.4f\n", i + 1, resultados[i]);
        }

        scanner.close();
    }

    // Método para el cálculo de los resultados mediante el método de Gauss-Seidel
    public static double[] gaussSeidel(double[][] coeficientes, double[] b, double error) {
        int n = b.length;
        double[] resultados = new double[n];
        double[] nuevosResultados = new double[n];
        double[] errores = new double[n];
        double maxError;

        // Inicializar los resultados
        for (int i = 0; i < n; i++) {
            resultados[i] = 0; // Suponer todos los resultados iniciales como 0
        }

        // Iterar hasta que se alcance el error deseado
        do {
            // Calcular los nuevos resultados
            for (int i = 0; i < n; i++) {
                double sum = 0;
                for (int j = 0; j < n; j++) {
                    if (j != i) {
                        sum += coeficientes[i][j] * resultados[j];
                    }
                }
                nuevosResultados[i] = (b[i] - sum) / coeficientes[i][i];
            }

            // Calcular el error de cada resultado
            maxError = 0;
            for (int i = 0; i < n; i++) {
                errores[i] = Math.abs((nuevosResultados[i] - resultados[i]) / nuevosResultados[i]);
                if (errores[i] > maxError) {
                    maxError = errores[i];
                }
            }

            // Actualizar los resultados con los nuevos resultados
            System.arraycopy(nuevosResultados, 0, resultados, 0, n);

        } while (maxError > error);

        return resultados;
    }
    
}

```

# Ejemplos del funcionamiento del codigo

## Ejercicio 1:
**_Sistema de ecuaciones_**

![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/027c053d-bd07-4378-b1ea-1c92425fb628)

**_Salida del programa_**

![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/a8782cec-d859-463b-a59f-bc9f55cf76a5)

## Ejercicio 2:
**_Sistema de ecuaciones_**

![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/a9047c82-0586-4408-8c98-bd3ccff1a829)

**_Salida del programa_**

![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/ca6f277d-d346-4673-aea2-27980d396c00)

## Ejercicio 3:
**_Sistema de ecuaciones_**

![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/625f08fe-6086-4791-be7f-6770834a955c)

**_Salida del programa_**

![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/e12ba048-11ad-4055-a769-809903ee46e6)

## Ejercicio 4:
**_Sistema de ecuaciones_**

![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/9d91a0d2-b3f1-40b0-9c68-183dc1fca6cb)

**_Salida del programa_**

![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/b5b7211c-4a4b-4edf-bce5-58c6354d2282)

## Ejercicio 5:
**_Sistema de ecuaciones_**

![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/1c0cc2eb-4b0b-4733-bbe5-995de33c1623)

**_Salida del programa_**

![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/f01285b6-0499-4830-9746-5a81c58e0bdb)
