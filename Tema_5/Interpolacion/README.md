# Interpolacion Lineal

La interpolacion es un metodo numerico, el cual tiene como objetivo encontrar un nuevo punto apartir de dos puntos conocidos.
El nuevo valor se obtiene haciendo sumas/restas entre los valores anteriores y posteriores del nuevo punto que se quiere conocer.
Evidentemente es un metodo el cual tiene su grado de error y puede tener un margen de error considerable al resultado final.
La interpolacion lineal, se caracateriza principalmente por usar una linea recta entre los dos puntos, para adivinar el valor en el nuevo punto.

De esta forma puede resultar en un error considerable al resultado, esto porque al ser una linea recta deja campo libre donde no esta siendo ocupado y que esta siendo ignorado para la operacion.

![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/d8c469f3-4126-486a-b06a-100185a82df2)

En esta imagen se puede apreciar el campo que se pierde al usar una linea recta entre los dos puntos. Puede verse similar a otros metodos. La parabola formada es la comparacion con otros metodos con el modo lineal.

## **Para calcular la interpolacion Lineal**

![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/cdab2527-500e-45b4-bd97-468ca32c184f)

Se necesitan los valores de y0, y1,x1,x0. En muchos otros casos y0 es lo mismo a f(x0) no importa la forma en la que se indique es cuestion de preferencias. Estos valores son lo que tenemos como conocidos dentro del conjunto de datos, siendo x0 el valor anterior a x y x1 el valor posterior de valor de x. Por otro lado el valor de y0 es el valor anterior que se quiere encontrar y y1 el valor posterior al que se quiere encontrar.

Esta formula es facil de aplicar, ya que solo se necesitan conocer los valores de alrededor y no necesita algo mas poderoso.

Resulta ser un metodo facil de aplicar y más aun si se conoce de buena manera la teoria de la interpolacion, ya que no resullta complicado de resolver gracias a la formula con la que se trabaja.

# Algoritmo

1.-Inicio

2.-Se sacan los coeficientes de "l" , sustituyendo las cordenas  con la formula.

3.-Se desarrolla las operaciones de cada expresion

4.-Estos resutados en forma de trinomios o binomios, se utilizan en la exprecion de pn(x)

5.-Se desarrolla la ecuacion

6.-Se simplifican los terminos similares

7.-Se encuentra el resultado.

8.-Final


# Codigo en Java
```java
import java.util.Scanner;

public class interlineal{

    public static float inter(float x0, float x1, float y0, float y1, float x){
        return y0+((y1-y0)/(x1-x0))*(x-x0);
    }
    
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);         

        float x0=0,x1=0,y0=0,y1=0,y=0,x=0;
        
        System.out.println("-------------Interpolacion lineal-------------");
        System.out.println("Ingresa el valor de x0:");
        x0 = sc.nextFloat();
        System.out.println("Ingresa el valor de x1:");
        x1 = sc.nextFloat();
        System.out.println("Ingresa el valor de y0:");
        y0 = sc.nextFloat();
        System.out.println("Ingresa el valor de y1: ");
        y1 = sc.nextFloat();
        System.out.println("Ingresa el valor de x");
        x = sc.nextFloat();

        System.out.println(inter(x0,x1,y0,y1,x));

    }


}

```

# Ejemplos del funcionamiento del codigo

## Ejemplo 1:
-  ![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/706dd050-b240-44d8-b7fa-4d4bb1f58473)
    
    En esta tabla tenemos los datos de horas del dia _(X)_ y respecto a la hora del dia tenemos su temperatura que se tiene en esa hora _((f(x))_. Se quiere conocer que temperatura haria a las 9 a.m. Por lo tanto con ayuda de los puntos conocidos se va a tratar de encontrar la temperatura.

    -Resultado en java:

    ![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/b441144c-ec47-4694-b7f6-2e46fd9bb05b)

## Ejemplo 2:
- ![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/ea5d23cb-d428-4a1e-be42-d15c313e75e8)

    En esta tabla se muetran los valores que tienen un logaritmo natural evaluado en x, pero se quiere saber que valor tendria que el valor de x fuera 2

    - Resultado en java:

    ![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/0a85a6be-ef57-476d-ae7d-c1d3ab399d35)

