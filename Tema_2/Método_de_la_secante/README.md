# **Método de la secante**

El método de la secante en un metodo abierto, se suele a similar al metodo de newton rapshon sin embargo en el metodo de newton raphson se tiene que calcular una derivada y esto en algunos casos puede ser complicado de calcular, asi que el metodo de la secante viene a facilitarlo un poquito ya que se puede calcular a traves de una diferencia finita dividida hacia atras o de otro modo utilizando una recta secante entre dos puntos.

La aproximacion se puede obtener con la siguiente formula:


![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/d21e395e-b435-442f-ba7a-7ec76ef6801f)


En este metodo no se necesitan intervalos pero se necesitan de dos valores propuestos para poder iniciar con las iteraciones, estos son Xi y Xi-1.

## **Algoritmo**

1. Se dan los valores de: Xi y Xi-1
2. Se calcula $f(Xi) y f(Xi-1)$
3. Se obtiene $Xi+1$ con la formula
4. Se cambian los valores de Xi y Xi-1 a lo obtenido con la formula
     - Xi-1 = Xi
     - Xi= Xi+1
5. Regresa al paso 2 para encontrar la nueva raiz

##Codigo en Java
```java
package metodo.de.la.secante;
import java.text.DecimalFormat;
import java.util.Scanner;

public class MetodoDeLaSecante {


    public static double f(double x){
        
        return (Math.pow(x, 3))+2*(Math.pow(x, 2))-10*x-20;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#.0000");
        
        System.out.println("Ingresa un primer valor propuesto:");
        double aa = sc.nextDouble();
        System.out.println("Ingresa un segundo valor propuesto:");
        double bb = sc.nextDouble();
        System.out.println("Ingresa la tolerancia del error:");
        double tol = sc.nextDouble();
        
        tol=tol*100;
        double error=0,xi,xiant;
        int ite=0;
        xi=aa;
        xiant=bb;
        do{
            double fxmu=f(xiant);
            double fxi=f(xi);
            double fxiN=xi-(fxi*(xiant-xi))/(fxmu-fxi);
            
            xiant=xi;
            xi=fxiN;
            if(ite==0){
                error=tol+1;
            }else{
                error=Math.abs((xi-xiant)/xi)*100;
            }
            System.out.println(ite);
            ite+=1;
        }while(error>=tol);
        
        System.out.println("El valor de la raiz aproximado es: " + df.format(xi));
    }
    
}

```

# Ejemplos del funcionamiento del codigo

## Ejercicio 1:

**_Ecuaciones:_**

![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/91a2f438-590f-4fbe-8d98-bdc44d832bf4)


**_Salida del programa:_**

![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/f4c4f167-5f18-4d2d-8a83-e668e5a096a2)


## Ejercicio 2:

**_Ecuaciones:_**

![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/68e4f7ff-b834-4949-995a-8567f08b8f28)

**_Salida del programa:_**

![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/f0325e7b-fff7-490b-b189-ffafcc4c97eb)


## Ejercicio 3:

**_Ecuaciones:_**

![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/b8589d67-1e1a-48bb-8d1a-5e50966dc477)

**_Salida del programa:_**

![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/399a9eb6-b939-4e2d-8c06-28440950fdb8)


## Ejercicio 4:

**_Ecuaciones:_**

![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/af3b9f92-01f8-4ac1-b256-354c29d81b86)

**_Salida del programa:_**

![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/02da8d4f-77e3-494b-b09f-1bfa2c574fb0)


## Ejercicio 5:

**_Ecuaciones:_**

![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/b1aa2636-2224-4c8e-954b-a2205465860f)

**_Salida del programa:_**

![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/14aced18-8c9f-4a24-bae4-b184729c12ac)



