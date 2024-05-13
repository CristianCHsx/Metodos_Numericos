# **Método de Gauss-Jordan**

Es un procedimiento para resolver sistemas de ecuacinoes con 3 incognitas.

El objetivo es tratar de convertir el sistema de ecuaciones a un sistema escalonado, para esto se puede hacer cualquier operacion como dividir, sumar, restar o multiplcar para cambiar el orden de las filas. Para que en cada posicion 1:1, 2:2, 3:3 (llamados pivotes), etc pueda convertirse en 1 y los terminos restantes sean convertidos en 0.

Para convertir en 1 se tiene que dividir el valor del pivote por si mismo en toda la fila
Para convertir en 0 se tiene sustituir una fila por la suma de la misma fila mas otra fila multiplicada por un numero.


## **Algoritmo**

1. Convertir sistema de ecuaciones en una matriz aumentada
2. Utilizar operaionces para convertir la matriz en una matriz diagonal
   - Intercambiar filas
   - Multiplicar filas por un numero !=0
   - Sumar a una fila un multiplo de otra fila
3. Regresar al paso 2
4. Resolver el sistema ecuaciones apartir de la matriz diagonal

## Codigo en Java
```java
package gauss.jordan;
import java.util.Scanner;
/**
 *
 * @author crist
 */
public class GaussJordan {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el número de ecuaciones en el sistema: ");
        int n = scanner.nextInt(); // Lee el número de ecuaciones del usuario

        double[][] coefficients = new double[n][n + 1]; // Matriz extendida [coeficientes | términos independientes]

        // Lee los coeficientes y términos independientes del usuario
        System.out.println("Por favor, ingrese los coeficientes de las ecuaciones y los términos independientes:");
        for (int i = 0; i < n; i++) {
            System.out.println("Ecuación " + (i + 1) + ":");
            for (int j = 0; j < n; j++) {
                System.out.print("Ingrese el coeficiente de x" + (j + 1) + ": ");
                coefficients[i][j] = scanner.nextDouble();
            }
            System.out.print("Ingrese el término independiente de la ecuación " + (i + 1) + ": ");
            coefficients[i][n] = scanner.nextDouble();
        }

        // Aplica el método de Gauss-Jordan
        for (int i = 0; i < n; i++) {
            // Hace que el coeficiente diagonal actual sea 1
            double divisor = coefficients[i][i];
            for (int j = i; j <= n; j++) {
                coefficients[i][j] /= divisor;
            }
            // Hace que todos los otros coeficientes en la columna sean 0
            for (int k = 0; k < n; k++) {
                if (k != i) {
                    double factor = coefficients[k][i];
                    for (int j = i; j <= n; j++) {
                        coefficients[k][j] -= factor * coefficients[i][j];
                    }
                }
            }
        }

        // Imprime la solución
        System.out.println("La solución del sistema de ecuaciones es:");
        for (int i = 0; i < n; i++) {
            System.out.println("x" + (i + 1) + " = " + coefficients[i][n]);
        }

        scanner.close();
    }
    
}

```
# Ejemplo del funcionamineto del codigo

## Ejercicio 1:

**_Sistema de Ecuaciones_**

![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/1b8e53ec-936d-4942-8b6d-7a1669728de1)

**_Salida del programa_**

![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/8dd02401-6002-493f-9935-28910424f2b1)

## Ejercicio 2:

**_Sistema de Ecuaciones_**

![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/2d66b56a-8256-4578-9556-fff51288a114)

**_Salida del programa_**

![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/440edd4a-0c8c-4995-b1e9-c7c1528edfa0)

## Ejercicio 3:

**_Sistema de Ecuaciones_**

![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/ac196a30-0296-4736-a671-f2e61d639e15)

**_Salida del programa_**

![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/dae38260-cb23-4947-9cc2-55a98a63db62)

## Ejercicio 4:

**_Sistema de Ecuaciones_**

![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/b620a067-b702-4cd8-a491-c2603d6c0b23)

**_Salida del programa_**

![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/5251c650-c3ee-4695-ac8d-0289eab2c7ec)

## Ejercicio 5:

**_Sistema de Ecuaciones_**

![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/940d50c7-02ba-4b3b-9dc4-4f895515a65e)

**_Salida del programa_**

![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/5314ec8b-e8a3-4789-9c9b-0358f9999099)
