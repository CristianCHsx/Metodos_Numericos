# Regla del Trapecio
Tambien conocido como el método del trapecio. Es una tecnica usada para la obtencion del area bajo la curva de una funcion.
O de otra forma, poder conocer el valor de una integral. 
Su nombre proviene de la manera en la obtiene el area, ya que usa trapecios para obtener el area abajo de la curva, utilizando la formula del area de un trapecio.


Resultando de esta manera en el area aproximada de la integral. Por otro lado se usan intervalos para dividir la funcion en secciones y entre estos intervalos es donde se representaban con trapecios.


Una desventaja de usar trapecios es que el posible resultado no este muy aproximado al original, ya que por la peculiar forma de los trapecios provoca que se dejen espacios vacios en donde no se cuenta para el area final, asi como tambien abarca mas espacio de lo necesario. En consecuencia de esto da un resultado muy alejado o cercano al valor original, por esta incomidad puede que el metodo pueda tener una tasa de error alta.

Existen dos "formulas" para calcula el valor de la integral, una es la manera simple y la otra la compuesta.

## Simple:

![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/1aff443b-71ba-4005-a885-dd2b22fe310d)

Esta se utiliza cuando el numero de intervalos es igual 2.

1. Aqui lo que se requiere es tener a y b, estos son los valores de los limites de la integral.

2. Se tiene que evaluar la funcion propuesta entre cada valor de a y b, despues de evaluar las funciones se suman entre estas dos para dividir entre 2 el resultado

3. Finalmente el resultado obtenido se multiplica por h/2.

4. El resutlado dado seria la aproximacion de la integral, eso si solo usando 2 intervalos (n=2) esto puede hacer que el valor tenga una tasa de error alta.
## Compuesta:

![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/4e349b3b-6b30-405e-a010-a3d01c7293a2)

En esta se utiliza cuando el numero de intervalos es mayor a 2.

Aqui ya empiza a cambiar un poquito la formula, sin embargo sigue manteniendo la esencia.

1. Para esto se tiene que calcular h=b-a/2. Esto son son pasos entre cada intervalo

2. Para saber el valor de cada intervalo, se empieza sumando el valor h a el valor de a (a+h) consecutivamente hasta llegar con el valor de b. Esto seran las xi

3. Cada xi obtenida será evaluada en la funcion. Una vez evaluada todas las xi y teniendo el resultado lo que sigue es hacer la sumatoria.

4. Para esto los valores de x1 hasta xn-1 seran multiplicados por 2, los unicos que no seran multiplicados son X0 y Xn. Finalmente se hace la suma de estos valores

5. Teniendo el resultado se multiplicara por h/2, y se obtendria el resultado final

Podria parecer que no hay mucha diferencia entre las dos formas de aplicar la formula pero la verdad es que si hay una diferencia y es en la aproximacion del resultado ya que en la formula compuesta puede manejar mas de 2 intervalos provocando que el resultado sea mas acercado al real

## Algoritmo

![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/c4ffb3d2-0caa-4548-a4ac-2801e00d66e0) (Chapra,2007)

En la imagen anterior extraida del librp de Chapra, se encunetran dos algoritmos simples de operar con la regla del trapecio.

En algoritmo de lado izquierdo es para la version de un segmento o simple. En cambio el del lado contrario es para la version de multiples segmentos, compuesto o multivariable, donde se tiene un ancho (h) se segmento constante.

En donde se puede observar que en el algoritmo de un solo segmento es demasiado simple, ya que solo esta evaluando unas pocas operaciones. Por otro lado en el algoritmo de segmentos multiples se ve requerido una funcion donde este contenga un for que acumulara la suma de los numeros compendidos entre _i > i hasta n-1_ y los numeros restantes que vienen siendo f(a) y f(b) son evaluados y agregados a la suma total, para finalmente operar con una division y multiplicacion para obtener el resultado final.

## Codigo en Java

```java
package javaapplication5;
import java.util.Scanner;
import java.text.DecimalFormat;
/**
 *
 * @author crist
 */
public class JavaApplication5 {
    
    public static double f(double x){
        return Math.sin(x)*Math.exp(x);
    }
    
    public static double tSimple(double a, double b){
        double res = (b-a)*((f(b)+f(a))/2);
        return res;
    }
    
    public static float tCompuesta(double a, double b, int n){
        double h,sum=0;
        int tn=n+1;
        double vector[] = new double[tn];
        h=(b-a)/n;
        double x = a;
        for (int i = 0; i <= n; i++) {
            vector[i]=x;
            x+=h;
            if(i>=1 && i<n){
                sum+= 2*f(vector[i]);
            }else{
                sum+=f(vector[i]);
            }
        }
        sum = (h/2)*sum;
     
        return (float)sum;
    }

    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("####.####");
        Scanner sc = new Scanner(System.in);
        boolean adentro = true;
        double a,b;
        int n;
        System.out.println("------------------------REGLA DEL TRAPECIO------------------------");
        do{
            System.out.println("Ingresa el limite a:");
            a = sc.nextDouble();
            System.out.println("Ingresa el limite b:");
            b = sc.nextDouble();
            System.out.println("Ingresa el numero de intervalos (n):");
            n = sc.nextInt();
            
            if(n<2){
                System.out.println("Se necesitan al menos dos intervalos para continuar\n");
            }
            else if(n==2){
                System.out.println(df.format(tSimple(a,b)));
                adentro=false;
            }else{
                System.out.println(df.format(tCompuesta(a,b,n)));
                adentro=false;
            } 
        }while(adentro!=false);
    }
}

```
# Pruebas de funcionamiento

## 1. Prueba 1
- **Funcion:**

  ![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/e893282d-3789-47e4-8fef-a83dcf149fbd)

- **Solucion por el programa:**

  ![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/042ca038-1f5b-4f93-9650-7618288ac02d)

- **Solucion dada por un software de integrales:**
  
  ![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/5ec7c3c9-0de6-428e-b156-5e1b5eeb1f7a)

## 2. Prueba 2
- **Funcion:**

  ![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/d7070b45-0478-43e7-b3fa-9e24a287a4db)

- **Solucion dada por el programa:**

  ![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/12376ab0-f261-4387-8a3f-537811d77dd3)

- **Solucion dada por un software de integrales:**

  ![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/b08cdffd-ef0b-4b41-a4f5-98f4e0e5e072)

## 3. Prueba 3
- **Funcion:**

  ![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/bd3d4447-3133-4faa-af5c-42b3b62f3ce6)

- **Solucion dada por el programa:**

  ![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/a602a59c-5d64-480a-b463-e1372b4df28e)

- **Solucion dada por un software de integrales:**

  ![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/941c7537-7f63-44ff-ba9e-33f8cbb4f8ec)

## 4. Prueba 4
- **Funcion:**

  ![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/fdbf8975-9ae5-41c5-9cce-be6c16b50aaf)

- **Solucion dada por el programa:**

  ![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/5305516b-ab4e-4f33-9cf5-a7d941c22eaa)

- **Solucion a dada por un software de integrales:**

  ![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/696227fe-bd14-45ac-8d9f-d92d3c58e6d2)

## 5. Prueba 5
 - **Funcion:**

   ![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/fc571f19-1276-4e63-803b-f969cb217023)

 - **Solucion dada por el programa:**

   ![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/b768ff22-9d99-4701-aa84-94c4eb7bfc22)

- **Solucion a dada por un sotfware de integrales:**

   ![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/f1b634ad-42fc-423d-b432-3f2a7d268aff)

 
