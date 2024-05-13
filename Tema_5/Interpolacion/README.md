# Interpolacion Lineal

La interpolacion es un metodo numerico, el cual tiene como objetivo encontrar un nuevo punto apartir de dos puntos conocidos.
El nuevo valor se obtiene haciendo sumas/restas entre los valores anteriores y posteriores del nuevo punto que se quiere conocer.
Evidentemente es un metodo el cual tiene su grado de error y puede tener un margen de error considerable al resultado final.
Se caracateriza principalmente por usar una linea recta entre dos puntos, esto es la explicacion por la cual puede tener un error considerable-

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