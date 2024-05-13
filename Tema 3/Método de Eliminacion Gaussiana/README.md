# Eliminacion Gaussiana

Es un metodo que se utiliza para resolver sistemas de ecuaciones lineales, el cual consiste en operar sobre una matriz ampliada del sistema de ecuaciones hasta hallar la forma escalonada.

Esto se obtiene un sistema de ecuaciones facil de resolver por despejes

Si se llegase a obtener una matriz identidad, el sistema es compatible determinado

## Algoritmo

1. Convertir el sistema de ecuaciones a una matriz aumentada
2. Hacer operaciones en las filas para convertir en una matriz escalonada
   - Intercambiar filas
   - Multplicar filas por un numero != 0
   - Sumar a una fila el multiplo de otra fila
   - Dividir entre el mismo numero
4. Regresar al paso 3 hasta tener la matriz escalonada
5. Resolver sistema de ecuaciones, remplazandolo con los valores obtenidos

## Codigo en Java

```java

package eliminaciongaussiana;


import java.util.Arrays;


public class EliminacionGaussiana {

    public static void main(String[] args) {
        
         // PASO 1: Definir nuestra matriz o nuestro vector
        double[][] A = {{7,-3},
                        {1,-6}};
        
        double[][] B = {{9},
                        {27}};
        
        // Copiamos las matrices originales y las hacemos de tipo flotante
        double[][] A_copy = new double[A.length][A[0].length];
        double[][] B_copy = new double[B.length][B[0].length];
        
        for (int i = 0; i < A.length; i++) {
            A_copy[i] = Arrays.copyOf(A[i], A[i].length);
            B_copy[i] = Arrays.copyOf(B[i], B[i].length);
        }
        
        // Se calcula el tamaño del vector
        int N = B.length;
        
        // Se recorre la matriz
        for (int i = 0; i < N; i++) {
            // Normalización
            double pivot = A_copy[i][i];
            System.out.println("Mi pivote es: " + pivot);
            for (int j = 0; j < A_copy[i].length; j++) {
                A_copy[i][j] /= pivot;
            }
            B_copy[i][0] /= pivot;
            System.out.println("\nSe divide el renglon por el pivote:");
            printMatrix(A_copy);
            System.out.println("\nSe divide el vector por el pivote:");
            printMatrix(B_copy);
            
            // Eliminación hacia adelante
            for (int j = i + 1; j < N; j++) {
                double factor = A_copy[j][i];
                System.out.println("\nConvertir en cero la matriz");
                System.out.println(factor);
                for (int k = 0; k < A_copy[j].length; k++) {
                    A_copy[j][k] -= factor * A_copy[i][k];
                }
                B_copy[j][0] -= factor * B_copy[i][0];
                printMatrix(A_copy);
                printMatrix(B_copy);
            }
        }
        
        // Sustitución hacia atrás
        double[] x = new double[N];
        for (int i = N - 1; i >= 0; i--) {
            System.out.println("\nIteracion " + i);
            System.out.println("B_copy[" + i + "]: " + B_copy[i][0]);
            System.out.println("A_copy[" + i + ", " + (i+1) + ":]: " + Arrays.toString(Arrays.copyOfRange(A_copy[i], i+1, A_copy[i].length)));
            System.out.println("x[" + (i+1) + ":]: " + Arrays.toString(Arrays.copyOfRange(x, i+1, x.length)));
            x[i] = B_copy[i][0];
            for (int j = i + 1; j < N; j++) {
                x[i] -= A_copy[i][j] * x[j];
            }
            System.out.println("x[" + i + "]: " + x[i]);
        }
        
        // Resultados
        System.out.println("\nMatriz A triangularizada:");
        printMatrix(A_copy);
        System.out.println("\nVector B triangularizado:");
        printMatrix(B_copy);
        System.out.println("\nSolucion:");
        System.out.println(Arrays.toString(x));
    }
    
    public static void printMatrix(double[][] matrix) {
        for (double[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
        
    }
    
}

```

# Ejemplos del funcionamiento del programa
## Ejercicio 1:
**Sistema de ecuaciones:**   
    
- ![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/1c8a2b0b-89fe-4bb7-9065-f7782b0ab426)

Salida del programa:

![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/b8a0a6ab-666f-4d0f-a650-631a4e02ab0f)

## Ejercicio 2:
**Sistema de ecuaciones:**

![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/0e189613-c4f3-4082-8de4-34518af166d3)

**Salida del programa:**

![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/ad1466d8-ea5b-4965-8e63-e3aeaaeb5671)

## Ejercicio 3:
**Sistema de ecuaciones:**

![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/61efa32c-cca2-4727-9358-0515ac085e5a)

**Salida del programa:**

![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/0bc60c8d-3060-404e-9234-d0c23b777f64)

## Ejercicio 4:
**Sistema de ecuaciones:**

![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/e3c85e3f-1968-49b9-b963-56ac42f4783e)

**Salida del programa:**

![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/8e152623-9b77-446c-892e-505f481e0ea1)

## Ejercicio 5:
**Sistema de ecuaciones:**

![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/1659be04-43f9-48b8-bcc6-5ae64fd6a1d6)

**Salida del programa:**

![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/79014de3-7582-458e-a086-04f35609d4a3)



