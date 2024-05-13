# **Método de Jacobi**

Este método es iterativo que se usa para resolver sistemas de ecuaciones lineales de cualquier tamaño.

Se basa principalmente en calcular sucesivamente de las raices de las ecucaiones, utilizando los valores obtenidos en cada iteraciones para remplazarlos en la nueva itereacion para obtener asi aproximaciones.

## **Algortimo**

1. Se obtiene el sistema de ecuaciones
2. Se crea el sistema matricial del sistema de ecuaciones
3. Se empieza a recorrer el sistema por fila para:
   - Calcular el valor de cada variable (x1,x2,x3)
     - Esto si la posicion i==j  dividira xn/i
     - Si i!=j entonces xn-i
  - Se actulizan los valores nuevos de x1,x2,x3,xn
  - Se obtiene el error con x1Anterior, x2Anterior, x3Anterior con x1,x2,x3
4. Repetir paso 3 hasta que
  - Error Relativo < Error Tolerado

## Codigo en Java
```java
package metodojacobi;

import java.util.Scanner;

public class MetodoJacobi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar el tamaño del sistema
        System.out.print("Ingrese el tamaño del sistema (2, 3 o 4): ");
        int tam = scanner.nextInt();

        // Validar el tamaño del sistema
        if (tam < 2 || tam > 4) {
            System.out.println("Tamaño del sistema no válido. Debe ser 2, 3 o 4.");
            return;
        }

        // Solicitar la matriz de coeficientes y el vector de resultados
        double[][] matrizCoeficientes = new double[tam][tam];
        double[] vectorResultados = new double[tam];

        System.out.println("Ingrese la matriz de coeficientes:");
        for (int i = 0; i < tam; i++) {
            for (int j = 0; j < tam; j++) {
                System.out.print("Ingrese el elemento [" + (i + 1) + "][" + (j + 1) + "]: ");
                matrizCoeficientes[i][j] = scanner.nextDouble();
            }
        }

        System.out.println("Ingrese el vector de resultados:");
        for (int i = 0; i < tam; i++) {
            System.out.print("Ingrese el elemento [" + (i + 1) + "]: ");
            vectorResultados[i] = scanner.nextDouble();
        }

        // Definir el vector inicial (puede ser cualquier valor)
        double[] vectorInicial = new double[tam];

        // Definir el número máximo de iteraciones
        int maxIteraciones = 1000;
        double[] vectorAnterior = new double[tam]; 
        // Realizar iteraciones en el método de Jacobi
        for (int k = 0; k < maxIteraciones; k++) {
            System.out.print("Iteración " + (k + 1) + ": ");

            // Calcular nuevos valores de x
            double[] x = new double[tam];
            for (int i = 0; i < tam; i++) {
                double sum = 0;
                for (int j = 0; j < tam; j++) {
                    if (j != i) {
                        sum += matrizCoeficientes[i][j] * vectorInicial[j];
                    }
                }
                x[i] = (vectorResultados[i] - sum) / matrizCoeficientes[i][i];
            }
            
             double errorAbsoluto = calcularErrorAbsoluto(x, vectorAnterior);

            if (k > 0 && errorAbsoluto < 0.05) {
                System.out.println("Error absoluto menor al 5% en la iteración " + (k + 1) + ".");
                break; // Romper el ciclo si el error es menor al 1%
            }
            // Mostrar resultados de la iteración
            for (int i = 0; i < tam; i++) {
                System.out.printf("x%d = %.4f", i + 1, x[i]);
            }
            System.out.println();

            // Actualizar el vector inicial para la próxima iteración
            System.arraycopy(x, 0, vectorInicial, 0, tam);
            System.arraycopy(x, 0, vectorAnterior, 0, tam);
            
        }

        
    }
    private static double calcularErrorAbsoluto(double[] vectorActual, double[] vectorAnterior) {
        double maxError = 0;
        for (int i = 0; i < vectorActual.length; i++) {
            double error = Math.abs((vectorActual[i] - vectorAnterior[i]) / Math.abs(vectorActual[i]));
            maxError = Math.max(maxError, error);
        }
        return maxError;
    }
}

```
 # Ejemplos/ejercicios de la ejecucion del funcionamiento del programa

# Ejercicio 1:

![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/f7e51023-d300-49a9-b5a0-785e97c125ee)  - Sistema de Ecuaciones

![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/fa3294db-46b8-4d7b-b88a-a2c4be05459d)


# Ejercicio 2:

![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/55f74914-7283-4aed-bd18-729b932f4b30) - Sistema de Ecuaciones

![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/b2801b95-c789-4ff9-bc5e-e0018418f8f4)

# Ejercicio 3:

![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/db9bf4eb-7c25-4566-a74a-d27c4533fb19) - Sistema de Ecuaciones

 
 ![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/f7647fb2-bb03-434a-9678-9fe0e6f69a94)

# Ejercicio 4:

![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/25a186c5-cddc-4490-9469-0af080b0af93) - Sistema de Ecuaciones

![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/5e081ca5-c246-45b6-8421-c7ffd97a62b0)

# Ejercicio 5:

![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/8fca41d3-f5eb-4f48-a166-50c44800b92c) - Sistema de Ecuaciones

![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/db1746f6-4a61-49a3-a636-249f099e2661)
