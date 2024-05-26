# Metodo de Euler

El metodo de Euler o tambien conocido como el metodo de Euler-Cauchy o de punto pendiente.
Es una tecnica, que tiene como objetivo aproximar la solucion de una ecuacion diferencial ordinaria. Se suele utilizar cuando una ecuacion suele ser complicada de resolver de manera analitica, resultando en la opcion de recurrir a esta tecnica. Este metodo es posible ya que usualmente en un problema de este calibre, se encuentran los datos necesarios para encontrar una respuesta acercada.

Estos datos son: la ecuacion dada del ejercicio (lineal) y sus condiciones iniciales ademas de una condicion extra (que servira como un especie de rango), con estos datos es posible encontrar una solucion aproximada. El proceso que tiene el método es encontrar nuevos valores de _y_, en donde se eligen **_x inicial (xi ó x0)_** y **_y inicial (yi ó y0)_** que son puntos que pertenecen a la funcion original y con estos poder calcular un nuevo valor de _y_ (extrapolacion).

## Proceso/formula

Esto se hace de forma iterativa, dependiendo de la cantidad de pasos (_ch o h_) que se hayan elegido. Para encontrar los nuevos valores de _y_ se utiliza una formula, la cual es la que le da el nombre a este metodo.

La formula que se utiliza es la siguiente:

![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/7f73a712-93a5-4c6d-aba9-c5b415c07b92)(Chapra,2006)

Se puede notar que en la formula se utiliza _yi_, _f(xi,yi)_ y _h_
-   **yi:** Es el valor de _y_ actual, con la cual se esta operando en la iteracion.
-   **f(xi,yi):** Es la funcion evaluada en _xi_ y _yi_.
-   **h:** Son los pasos, este se obtiene con la siguiente formula: $\(xf-xi)/ch$   (ch es la cantidad de pasos).

Con la formula se obtiene **_yi+1_**  este es el nuevo valor de _yi_ que de forma iterada se remplazará con la misma formula hasta completar la cantidad de pasos totales o cuando xi sea igual al valor de la cantidad de los pasos.

Ademas para encontrar xi, en cada iteracion se debe de sumar el valor $\xi+h$

Este metodo como varios que sean visto a lo largo de este repositorio, es un metodo facil de entender sin embargo tiene el problema de que tener una tasa de error considerable, ya que el metodo puede arrojar valores bastantes alejados al resultado real. Evidentemente esto puede depender del numero o cantidad de pasos con el que se trabaje, sin obstante puede estar bastante alejado a la respuesta/funcion original.

![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/9ccf7b28-dc90-4b17-b1e7-543b80fd3442)(Chapra,2006)

Como se puede ver en la imagen anterior. Se encuentran dos funciones graficadas, la de color azul es la funcion obtenida con el metodo de Euler y la de color negro es la solucion real.

Se puede apreciar notablemente que los cuerpos de ambas funciones se alejan bastante, este espacio que las separa se considera como su error notable. Este es el error de cual mencionaba. Esto da a entender que el metodo puede ser facil de aplicar pero su tasa de error puede ser bastante alejado al original.


# Algoritmo

![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/65e01dbd-5815-423c-9370-562215b80840)(Chapra, 2006)

La imagen previa, es Seudocódigo del método de Euler.

Vemos que en las primeras seis lineas declara los valores de _xi ,xf x (es el mismo que xi)_ y de _y_. Los cuales son lo que pertenecen a las condiciones iniciales de la ecuacion, ademas _xf_ siendo el valor de _x_ del nuevo punto de _y_ a encontrar.

Posteriormente, encuentra el numero paso (nh) utilizando la formula. $\xf-xi/dx$

Finalmente inicia un ciclo for, donde empezara desde el valor 1 hasta llegar al valor del numero de paso. En donde aplicara la formula del metodo de Euler, despues indica la funcion con la que se trabajará (_dydx_), luego encuentra el valor nuevo de _y_ utilizando la formula mencionada, para despues encontrar _xi+1_ sumando _dx (h)_ al valor de _xi_. Para finalmente imprimir el resultado de la iteracion.

# Codigo en Java
``` java
package Tema_6.Euler;
import java.util.Scanner;
import java.text.DecimalFormat;


public class Me_Euler{

    public static double edo(double x, double y){
        return 2*x;
    }
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        DecimalFormat de = new DecimalFormat("#.00000");
        
        
        double x0=0,y0=0,xf=0,h=0,yn,x=0,n=0;

        System.out.print("Ingresa el valor de x inferior: ");
        x0 = sc.nextDouble();
        System.out.print("Ingresa el valor de y: ");
        y0 = sc.nextDouble();
        System.out.print("Ingresa el valor de x final: ");
        xf = sc.nextDouble();
        System.out.print("Ingresa la cantidad de pasos: ");
        n = sc.nextDouble();

        h=(xf-x0)/n;

        do{
            System.out.println(x);
            yn=y0+(h*edo(x0, y0));
            x0+=h;
            y0=yn;
            x+=1;
        }while(x!=n);

        System.out.println("En la iteracion "+x+"--"+de.format(x0)+"[El resultado es: "+ de.format(yn));
    }
}

```


# Prueba de funcionamiento

 ## Ejercicio 1:
  + Ecuacion: 

  + Resultado dado por el programa:

 ## Ejercicio 2:
   + Ecuacion: 

  + Resultado dado por el programa:

 ## Ejercicio 3:
  + Ecuacion: 

  + Resultado dado por el programa:

 ## Ejercicio 4:
  + Ecuacion: 

  + Resultado dado por el programa:

 ## Ejercicio 5:
  + Ecuacion:

  + Resultado dado por el programa: