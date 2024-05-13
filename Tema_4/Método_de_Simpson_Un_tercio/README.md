# Método de Simpson 1/3
El metodo de simpson, es un metodo de integracion numerica que se utiliza para aproximar el valor de una integra definida.
Este a comparacion a el de regla del trepacio, rescata en la peridida de area por usar trapecio en usar parabolas para encontrar valor de la integral.

El uso de parabolas permite tener un resultado mas aproximado al real, ya que no deja tantos espacios vacios como cuando se media con trapecios. Estas parabolas se miden entre caada intervalos
para obtener el area de la parabola y asi obtener la sumatoria total para el valor de la integral.

La formula de simpson 1/3 consiste en lo siguiente:
∫[a,b] f(x) dx ≈ (h/6) * [f(a) + f(b) + 4f(m)]

- h = (b - a) / n 

- m = (a + b) / 2 

En este se ocupan 3 puntos para obtener un valor de la integral, 2 de ellos provienen de los limites y el restante proviene del punto medio entre estos dos limites.

Lo anterior es la forma simple del metodo de simpson 1/3. Existe tambien la forma complejta o de multivariable para el metodo de simpson de 1/3.

En donde el numero de intervalos es mayor a 3.

∫[a,b] f(x) dx ≈ (h/3) * [f(a) + 4f(ah) + 2f(ah) + f(b)]

Donde:
- h = (b - a) / n
- ah = a+(h)(x) donde x es un numero entero desde 1 hasta b
- Dependiendo si el numero de posicion de ah sea par se multiplicara por 2 y si es impar se multiplicaria por 4

# Algoritmo

Algoritmo para Simpson 1/3 para una sola aplicacion

![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/0152eed8-77d7-41fb-82ed-42711215633d) (Chapra, 2006)

Algoritmo para Simpson 1/3 de aplicacion multiple

![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/f42452df-6fb5-42aa-a4f1-f5dc14f9d26d) (Chapra, 2006)

Como podemos ver en el algoritmo de _**Simpson para una sola aplicacion**_ vemos que lo que hace solo es remplazar los valores en la formula para obtener el resultado, estos valores pueden ya ser evaluados antes y solo ser mandados a la funcion o por otro lado pueden ser calculados dentro de la misma funcion, en este caso se puede ver que es mejor calcularlos antes para que no sea muy extenso.

En el segundo algoritmo de _**Simpson para una aplicacion multiple**_ podemos ver que hace el uso de un for para recorrer de i = 1 hasta n-2 y que ira aumentando de 2 en 2 esto para cumplir con la formula donde genera la suma de la multiplicacion de 4*fi + 2*fi+1 en el caso que fueron pares, acabando el for terminaria de completar las operaciones restantes de acuerdo a las funciones.

# Codigo en Java

```java
package simpson.pkg1tercio;
import java.util.Scanner;
import java.text.DecimalFormat;
/**
 *
 * @author crist
 */
public class Simpson1tercio {
    
    public static double f(double x){
        return (5*Math.pow(x, 2))-x/3;
    }
    
    public static double simpSimple(double a, double b){
        double cL = (a+b)/2;
        double res = ((b-a)/6)*(f(a)+(4*f(cL))+f(b));
        return res;
    }
    
    public static double simpCompuesto(double a, double b, int n){
        double h,x=a,sum=0;
        double xi[] = new double[n+1];
        h=(b-a)/n;
       
        for (int i = 0; i <= n; i++) {
            xi[i]= x;
            x+=h;
            if(i==0||i==n){
                sum+=f(xi[i]);
            }else if((i%2)==0){
                sum+=2*f(xi[i]);
            }else{
                sum+=4*f(xi[i]);
            }
        }
        
        sum = (h/3)*sum;
        
        return sum;
    }
    
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("####.####");
        double a,b;
        int n;
        System.out.println("------------------Método de Simpson------------------");
        System.out.println("Ingresa el valor de a:");
        a = sc.nextDouble();
        System.out.println("Ingresa el valor de b:");
        b = sc.nextDouble();
        System.out.println("Ingresa el numero de intervalos(n):");
        n = sc.nextInt();
        
        if(n<2){
            System.out.println("Se necesita por lo menos dos intervalos para operar");
        }
        else if(n==2){
            System.out.println(df.format(simpSimple(a,b)));
        }else{
            System.out.println(df.format(simpCompuesto(a,b,n)));
        }
    }
    
}

```
# Demostracion del funcionamiento del codigo hecho en Java

## Ejemplo 1:
  - **Funcion:**

    ![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/820eb034-478a-46e7-b255-30b3468478d0)

 - **Solucion dado por el programa:**

    ![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/c5e3e86f-c4e3-47f0-97b0-e99535db0927)

 - **Solucion dado por Symbolab**

   ![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/6f5364f8-315c-4f23-b6c5-743cc7b8bf56)
 
## Ejemplo 2:
  - **Funcion:**

    ![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/4f0f6631-fe33-40c5-a69e-ee508869b42d)

 - **Solucion dado por el programa:**

    ![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/39bbf27a-9cec-4850-acfa-7799adf89ff7)

 - **Solucion dado por Symbolab**

   ![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/c5b4182f-3621-48fa-987e-317d439dfeb1)

## Ejemplo 3:
  - **Funcion:**

    ![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/2ea530c4-5d6b-4812-b5bc-b03cb34fdf38)

 - **Solucion dado por el programa:**

    ![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/7aabf5ea-44c0-4fcb-bfa0-6333dc34dd90)

 - **Solucion dado por Symbolab**

   ![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/1128c7f3-e274-40cd-baf8-c48a7d850737)

## Ejemplo 4:
  - **Funcion:**

    ![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/ab075003-7a68-4b93-adbf-0ed3be07b8eb)

 - **Solucion dado por el programa:**

    ![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/5ce7e0db-197d-49c6-8030-d8f5bf2c54b9)

 - **Solucion dado por Symbolab**

   ![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/1503f675-8efd-48e4-aa9d-953019a649ad)

## Ejemplo 5:
  - **Funcion:**

    ![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/d28e5aa4-9c76-47d1-87f1-42cefe57b0c7)

 - **Solucion dado por el programa:**

    ![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/40bdd9a0-4f69-4064-af8a-727968ff342a)

 - **Solucion dado por Symbolab**

   ![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/8853087c-45bf-4882-b9f1-cb2aee881d9b)
