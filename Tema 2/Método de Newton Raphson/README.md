# **Método de Newton Rapshon**

Es un metodo iterativo que busca resolver ecuaciones de una forma mas aproxmiada. Esto debido a la utilizacion de una tangente en la curva de la ecuacion.
Este curva cruza por algun punto del eje x, lo cual nos indicaria en que parte estaria la raiz.

Un agregado que tiene este metodo, es la utilizacion de derivadas ya que se tiene que derivar la funcion principal para encontrar el valor de la pendiente. Esto ira aproximara el valor hacia la raiz.

Para este metodo se tiene que tener un valor el cual sera el numero con el que empezará a trabajar con todo el proceso del metodo, el cual es pasar por la f(x) principal y f'(x).
Despues se utilizara la siguiente formula:

![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/a72f966d-510b-48bf-b0b6-74ce2662d7ee)

Donde xi es el valor de valor inicial.

El resultado de este valor sera por el cual se remplazara x para la siguiente iteracion. Todo esto hasta llegar a la raiz o hasta que el valor llegue de f(x) llegue a 0.

## **Algoritmo**

1. Se elige un punto inicial x0 cercano a la raíz buscada
2. Se calcula la pendiente f′(x0) de la función en el punto x0
3. Se utiliza la ecuación de la tangente para encontrar el punto de intersección con el eje x, que se denomina siguiente aproximación x1
4. Se repiten los pasos 2 y 3 utilizando la última aproximación como punto inicial, hasta que se alcance la precisión deseada

## Aplicaciones

Este metodo se puede usar parar resolver gran variedad de ecuaciones, aunque si se conoce que la ecuacion tiene mas de una posible raiz o raices multiples. Se tendra que ingresar como valor inicial un valor cercano a la raiz.
Por otro lado este metodo puede ser utilizado para:
+ Calcular las raices de ecuaciones polinomicas
+ Aproximarse a soluciones de ecuaciones diferenciales

## Codigo en Java
```java
package newton;
import java.util.Scanner;
import java.lang.Math;
import java.text.DecimalFormat;


public class Newton {
    
    public static double f(double x){
        double a = Math.pow(x,3);
        return a-x-1;
    }
    
    public static double fp(double x){
        double a = Math.pow(x, 2);
        return  ((3*a)-1);
    }
    
    public static void main(String[] args) {
        DecimalFormat de = new DecimalFormat("#.0000");
        double xi=0,fxi=0,fprima=0,fdivf=0,oo=0,xi2=0,error;
        int aa=0;
      
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Ingresa el punto de partida: ");
        xi = sc.nextDouble();
        
        do{
            oo = xi;
            fdivf=(xi-(f(xi)/fp(xi)));
            error= Math.abs((fdivf-oo)/fdivf);
            xi=fdivf;
        }while(error != 0);
        
        System.out.println("El valor aproximado de la raiz es: "+de.format(fdivf));
       
    }
    
}

```
# Ejemplo del funcionamiento del programa

## Ejercicio 1:

**_Ecuacion:_**

![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/5a546aed-63d4-4acb-933f-049ec03a339f)

**_Salida del programa:_**

![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/6d039f89-d180-4b89-a639-b80e10dd38c5)

## Ejercicio 2:

**_Ecuacion:_**

![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/49f88243-d906-4cc9-b6cd-cd00ff2f31e0)

**_Salida del programa:_**

![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/72ed76a0-577c-4841-9610-9b45c1417df3)

## Ejercicio 3:

**_Ecuacion:_**

![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/b59a7510-ac24-4d63-a2cd-9622e4d84381)

**_Salida del programa:_**

![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/80f8bded-6f7a-4b4f-90a0-82e9cfb0b423)

## Ejercicio 4:

**_Ecuacion:_**

![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/8329c16d-a306-4079-83a2-1c94516ba2d9)

**_Salida del programa:_**

![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/e3314538-a3df-4a5c-ac16-acd2a56b7351)

## Ejercicio 5:

**_Ecuacion:_**

![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/6b85ee9a-8fd2-4e56-a231-ecb4d54f85fc)

**_Salida del programa:_**

![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/10f2c65b-12a1-4f78-adc2-bd26ee4ce2ab)

