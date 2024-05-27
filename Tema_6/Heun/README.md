# Metodo de Heun

Este metodo viene de la mano con el metodo de Euler. Mientras que en el metodo de Euler calcula la recta de la pendiente base y con eso calcular el siguiente punto. De esta manera se genera un error al momento de calcular la aproximacion, ya que al calcular la pendiente se esta asumiendo que la recta seguira siendo la misma desde su punto base hasta el punto final. Lo cual no es asi, dejando un hueco enorme en comparacion a la funcion original.

Gracias a conocer este error, se puede saber la existencia de una correcion al algortimo de este metodo para obtener una respuesta mas aproximada. El cual recibe el nombre de Metodo de Heun o Euler mejorado.

Este metodo lo que hace es estimar la pendiente del punto base pero tambien estimar la pendiente del punto final que queremos calcular. Estas dos pendientes se van a promediar resultando en una pendiente mas aproximada al valor original.

Dentro de la formula, se hacen cambios los cuales provocaran que se trabajen por cada iteracion con dos ecuaciones a calcular. Una será para la pendiente en el punto base y otra en la pendiente en el punto final que deseamos calcular. Con esa nueva pendiente calcular los valores nuevos que se desean calcular, hasta llegar al valor adecuado.

![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/1899ff3e-e60c-4882-b368-897518e62f26)

En la anterior imagen se puede observar las formulas con las cuales se van a trabajar en este método.

La primera es la que se utiliza para el método de Euler. Mientras que la segunda en la nueva que se va a calcular.
En esta se evaluan la ecuacion con los valores de _xi_ y _yi_ (x0, y0) siendo sumado con la misma evaluacion pero con los valores de _xi+1_ y _yn+1*_. De este modo calculando el promedio entre ambas pendientes, para despues continuar con las iteraciones correspondientes.


# Algortimo

![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/c8b012ee-a9c1-4b55-ba51-3b8403b97d3a)(Chapra, 2006)

En la imagen anterior se muestra un seudocodigo del método de Heun.

En el se puede observar que "CALL Derivs" indica el llamado de un metodo que calcula los valores de x, y en la ecuacion indicada de dy1dx.

Para despues en la variable ye guardar el resultado de la formula de Euler.

De la misma manera vuelve a llamar al metodo para calcular la ecuacion pero ahora con los valores de x+h, ye (obtenido en el paso anterior).

Posteriormente guarda en la variable Slope el resultado del promedio de estas dos pendientes, seguidamente en la variable ynew asigna el valor de la formula de Heun.

# Codigo en Java

```java
package Tema_6.Heun;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Heun {
    
    public static double edo(double x, double y){
        return 2*x*y;
    }
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        DecimalFormat de = new DecimalFormat("#.00000");
        
        
        double x0=0,xL,y0=0,xf=0,h=0,yn,x=0,n=0,ynL;

        System.out.print("Ingresa el valor de x inferior: ");
        x0 = sc.nextDouble();
        System.out.print("Ingresa el valor de y: ");
        y0 = sc.nextDouble();
        System.out.print("Ingresa el valor de x final: ");
        xf = sc.nextDouble();
        System.out.print("Ingresa la cantidad de pasos: ");
        n = sc.nextDouble();
        xL=x0;
        h=(xf-x0)/n;

        do{
            yn=y0+(h*edo(x0, y0));
            System.out.println("yn"+yn);
            xL+=h;
            System.out.println("xL:"+xL);
            ynL=y0+((h/2)*(edo(x0, y0)+edo(xL, yn)));
            System.out.println("ynl: "+ ynL);
            x0=xL;
            y0=ynL;
            x+=1;
            System.out.println("------------");
        }while(x!=n);

        System.out.println("\nEn la iteracion "+x+"--"+de.format(x0)+"[El resultado es: "+ de.format(y0));
    }
}


```

# Pruebas del funcionamiento del codigo

 ## Ejemplo 1:
 - Ecuacion:

   ![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/6b3cd036-8b37-43dc-8498-d4cf94c182cd)

 - Resultado mediante el programa:

   ![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/22fbd8e9-62b8-4cf4-b975-a4e5f872bf33)

 ## Ejemplo 2:
 - Ecuacion:

  ![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/b8ac92d6-22c3-472b-a692-9c6347560d2e)

 - Resultado mediante el programa:

  ![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/6eea3315-b5af-4003-9c1a-cfd676048cf4)

 ## Ejemplo 3:
 - Ecuacion:

   ![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/37d33202-a758-4108-bdaf-fb8f034357e8)

 - Resultado mediante el programa:

   ![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/5ead1396-0889-4ada-bff0-c9aab57abf67)

 ## Ejemplo 4:
 - Ecuacion:

   ![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/f2d7716f-73f6-4b7f-b0a3-b796dded62e2)

 - Resultado mediante el programa:

   ![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/66a78fb7-cdfe-4d0b-a65e-25c79f34ecbb)

 ## Ejemplo 5:
 - Ecuacion:

   ![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/a2ec09ee-a77d-446e-af52-16847eccc8cb)

 - Resultado mediante el programa:

   ![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/11435dcf-941d-431e-abf0-989c8b65469c)