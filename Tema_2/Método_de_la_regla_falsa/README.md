# **Método de la regla falsa**

Este método tiene una similitud al metodo de biseccion ya que por un lado en un metodo cerrado, en cambio este metodo puede ser mas efectivo a la hora de resolver ecuaciones no lineales.
Ya que este principalmente trada lineas rectas hacia las raices provocando que sea mas aproximado el resultado. Esto da un resultado peculiar ya que tiene similaridades con un triangulo, esto lo hace mas facil a la hora aproximar a un resultado.

En cuanto al proceso es bastante similiar al metodo de biseccion, solo que la formula de Xr (xmitad) es diferente:

![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/a4cb929e-99b3-4f65-9b5e-3714b6006c3b)


Esta es la formula de la falsa posicion. Con esta se podra calcular el valor de Xr el cual momentos despues sera remplazado por uno de los intervalos de la ecuacion [a,b].
De esta manera puede asegurarse que la raiz siempre estara encerrada entre los intervalos acercandose aun mas a la obtencion de la raiz.

## Algoritmo

1. Se elige un intervalo inicial [a,b] que contiene la raíz buscada.
2. Se evalúa la función en los extremos del intervalo, f(a) y f(b).
3. Se calcula la falsa posición
4. Se evalúa la función en la falsa posición c.
5. Se compara el valor de la función en la falsa posición con el valor de la función en los extremos del intervalo.
6. Se elimina el subintervalo que no contiene la raíz.
7. Se repiten los pasos 2 a 6 utilizando el nuevo intervalo como intervalo inicial, hasta que se alcance la precisión deseada.

## Codigo en Java
```java
package regla_falsa;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author crist
 */
public class Regla_Falsa {
    
    public static double f(double x){
        return (-0.4*(Math.pow(x,2)))+(2.3*x)+2.2;
    }

    public static void main(String[] args) {
        DecimalFormat de = new DecimalFormat("#.0000");
        Scanner sc = new Scanner(System.in);
        
        
        System.out.println("Ingresa el valor de a");
        double a = sc.nextDouble();
        System.out.println("Ingrsa el valor de de b");
        double b = sc.nextDouble();
        System.out.println("Ingresa la toleracia de error");
        double tol = sc.nextDouble();
        
        int iteracion = 0;
        double errorRel=0, errorRelAnt=0,errorVV=0,fxm=0,Xmitad=0,fa=0,fb=0,xant=0,fafa=0;
        
        tol=tol*100;
        do{
            xant=Xmitad;
            Xmitad = a-((f(a)*(b-a))/(f(b)-f(a)));  
            System.out.println(Xmitad);
            fafa=f(a)*f(Xmitad);
            
            if(fafa<0){
                a=Xmitad;          
            }
            if(fafa>0){
                
                b=Xmitad;
            }
            if(iteracion==0){
                errorRel=tol+1;
            }else{
                errorRel=(Math.abs((Xmitad-xant)/Xmitad))*100;
            }
            
            iteracion+=1;
            

            
        }while(errorRel>=tol);
        System.out.println("El valor aproximado de la raiz es: "+de.format(xant));
    }
    
}

```
# Ejemplos del funcionamiento del codigo

## Ejercicio 1:

**_Ecuaciones:_**

![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/a9d6dbe4-9858-479d-a52c-a0bdd2e19c5a)

**_Salida del programa:_**

![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/af63c332-af7d-4bef-8914-622ca6adaa3f)

## Ejercicio 2:

**_Ecuaciones:_**

![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/68e4f7ff-b834-4949-995a-8567f08b8f28)

**_Salida del programa:_**

![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/d9725b66-f12b-4a0e-8b05-e0878d467213)

## Ejercicio 3:

**_Ecuaciones:_**

![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/b8589d67-1e1a-48bb-8d1a-5e50966dc477)

**_Salida del programa:_**

![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/7e123f16-57f7-4fd4-87bc-3c69f72fbee0)

## Ejercicio 4:

**_Ecuaciones:_**

![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/af3b9f92-01f8-4ac1-b256-354c29d81b86)

**_Salida del programa:_**

![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/56afad74-d018-4dae-b4f9-6756fd79e235)

## Ejercicio 5:

**_Ecuaciones:_**

![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/b1aa2636-2224-4c8e-954b-a2205465860f)

**_Salida del programa:_**

![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/fa861225-08bc-49c0-91ea-922b52921539)
