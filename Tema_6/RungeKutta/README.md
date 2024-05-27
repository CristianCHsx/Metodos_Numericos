# Metodo Runge-Kutta de 4to orden

Pertence a una familia de metodos de Runge-Kutta (RK), los cuales llegan a realizar el mismo procedimiento de la series de Taylor pero sin calcular derivadas de orden superior (Chapra, 2006).

Como se mencionó proviene de una familia de metodos, los cuales se clasifican respecto a su orden (primer orden, segundo orden, tercer orden y cuarto orden). En cada clasificacion se encuentran diferentes tecnicas para resolver ecucaiones diferenciales ordinarias, por ejemplo dentro del primer orden se encuentra el metodo de Euler que ya se ha expuesto aqui.

Entre sus demas clasificacion se encuentran varios metodos mas para aplicarse a cada caso, otro ejemplo seria en el caso del segundo orden se encuentran el metodo de Heun, Punto medio y RK Ralston.

Entre sus 4 clasificaciones, solo se va a centrar en el metodo del 4to orden. Este es el metodo mas popular de esta familia, muchos lo conocen como el metodo clasico de RK de cuarto orden. Esto porque existen diferentes maneras de emplear el metodo, sin embargo el que voy a mostrar es el basico.

![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/c8c0b38f-999e-4e39-8513-974ffa3d956b)(Chapra,2006)

La imagen anterior muestra las formulas que se llevan a cabo al momento de operar con el metodo. Vemos que se calcula _Yi+1_ similar a como se hacia en el metodo de Euler, pero en este caso se añade nuevos valores a calcular (k1,k2,k3 y k4).

Estos valores de Kn son calculados a traves de sus respectivas formulas, donde lo que comparten entre las 4 formulas, es que las 4 se evaluan con la ecuacion.

De esta forma se puede conocer los nuevos valores de yn, resultando de esta manera en una iteracion hasta encontrar el valor adecuado.

Este metodo es el mas popular ya que tiene una muy buena aproximacion al resultado real, esto porque calcula varias estimaciones de la pendiente de la ecuacion. Esto para encontrar la mejor pendiente promedio entre las varias estimadas en el intervalo. Por eso se calcula k1,k2,k3 y k4, cada valor de k representa una pendiente, y el promedio de estas resultara en el resultado de la ecucaion.

![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/313337de-e476-4ee9-9564-f43492e0459e)(Chapra,2006)

# Algoritmo

![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/d3a1eafc-def9-491f-9129-d6c15980cd1f)(Chapra,2006)

En el Seudocodigo, se puede observar que recibe los valores de x,y,h,ynew.

Para despues ir calculando las derivadas, o bien calculado cada valor de k1. Que en este caso el calculo de kn lo hace a traves de funciones ya definidos, para solo ir juntado los valores necesarios para la formula general que se puede ver que tiene el nombre de "_slope_". 

Para finalmente imprimir el resultado, terminando el bucle.

# Codigo en Java

```java
package Tema_6.RungeKutta;
import java.util.Scanner;
import java.text.DecimalFormat;

public class Rk4 {

    public static double edo(double x, double y){
        return 2*x*y;
    }
    public static void main (String[]args){
        Scanner sc = new Scanner(System.in);
        DecimalFormat de = new DecimalFormat("#.00000");
        

        double x0,y0,xf,h,ch,ynm,k1,k2,k3,k4,x=0;

        System.out.print("Ingresa el valor de x inicial: ");
        x0=sc.nextDouble();
        System.out.print("Ingresa el valor de y: ");
        y0=sc.nextDouble();
        System.out.print("Ingresa el valor de x final: ");
        xf=sc.nextDouble();
        System.out.print("Ingresa la cantidad de pasos: ");
        ch=sc.nextDouble();
        
        h=(xf-x0)/ch;

        do{
            //System.out.println(y0);
            k1=edo(x0, y0);

            k2=edo(x0+(h/2),y0+((h/2)*k1));
            k3=edo(x0+(h/2),y0+((h/2)*k2));
            k4=edo(x0+h,(y0+(h*k3)));
            ynm=y0+(h/6)*(k1+(2*k2)+(2*k3)+k4);
            x0+=h;
            y0=ynm;
            x+=1;
        }while(x!=ch);
        System.out.println("El resultado es: "+ de.format(y0));
    }
    
}

```

# Pruebas del funcionamiento del codigo

 ## Ejemplo 1:
 - **Ecuacion**

   ![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/6b3cd036-8b37-43dc-8498-d4cf94c182cd)

 - **Resultado dado por el programa:**

 ## Ejemplo 2:
 - **Ecuacion**

   ![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/b8ac92d6-22c3-472b-a692-9c6347560d2e)

 - **Resultado dado por el programa:**

 ## Ejemplo 3:
 - **Ecuacion**

   ![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/37d33202-a758-4108-bdaf-fb8f034357e8)

 - **Resultado dado por el programa:**

 ## Ejemplo 4:
 - **Ecuacion**

   ![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/f2d7716f-73f6-4b7f-b0a3-b796dded62e2)

 - **Resultado dado por el programa:**

 ## Ejemplo 5:
 - **Ecuacion**

   ![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/a2ec09ee-a77d-446e-af52-16847eccc8cb)

 - **Resultado dado por el programa:**