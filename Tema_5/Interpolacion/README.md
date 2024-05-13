# Interpolacion Lineal

La interpolacion es un metodo numerico, el cual tiene como objetivo encontrar un nuevo punto apartir de dos puntos conocidos.
El nuevo valor se obtiene haciendo sumas/restas entre los valores anteriores y posteriores del nuevo punto que se quiere conocer.
Evidentemente es un metodo el cual tiene su grado de error y puede tener un margen de error considerable al resultado final.
La interpolacion lineal, se caracateriza principalmente por usar una linea recta entre los dos puntos, para adivinar el valor en el nuevo punto.

De esta forma puede resultar en un error considerable al resultado, esto porque al ser una linea recta deja campo libre donde no esta siendo ocupado y que esta siendo ignorado para la operacion.

![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/d8c469f3-4126-486a-b06a-100185a82df2)

En esta imagen se puede apreciar el campo que se pierde al usar una linea recta entre los dos puntos. Puede verse similar a otros metodos. La parabola formada es la comparacion con otros metodos con el modo lineal.

**Para calcular la interpolacion Lineal**

![image](https://github.com/CristianCHsx/Metodos_Numericos/assets/162630564/26573f1e-89b2-483b-af14-2614c7091b6c)

Resulta ser un metodo facil de aplicar y más aun si se conoce de buena manera la teoria de la interpolacion, ya que no resullta complicado de resolver gracias a la formula con la que se trabaja.

# Algoritmo




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

## Ejemplo 2:

## Ejemplo 3:

## Ejemplo 4:

## Ejemplo 5: