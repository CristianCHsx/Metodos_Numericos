# Interpolacion cuadratica

La interpolacion cuadratica sigue el mismo objetivo que la interpolacion lineal, es cual es encontrar un punto nuevo apartir de otros ya conocidos.

Lo diferencia es que a comparacion del metodo anterior, en este se usa un polinomio cuadratico para encontrar el valor nuevo. En la interpolacion lineal se usaba un polinomio de primer grado lo cual hacia un poco mas sencillo y corto al momento de resolverlo.

Al incluir un polinomio cuadratico, puede sonar a que será un proceso complicado sin embargo es todo lo contrario, se sigue manteniendo en la linea de lo no complicado.

En este metodo se necesitan 3 puntos conocidos para encontrar el nuevo, estos 3 puntos se evaluaran en un polinomio cuadratico _(ax^2+bx+c)_. Una vez evaluados, se obtendra un sistema de ecuaciones de 3x3 (Normalmente, aveces sera de menor tamaño o mayor).
Donde se tendra que obtener el valor de las incognitas(a,b y c) utlizando un metodo de resolucion de sistemas de ecuaciones, como el de eliminacion, sustitucion, gauss-jordan, entre otros. 

Para finalmente habiendo encontrado el valor de a,b y c, se tiene que remplazar con el polinomio cudratico y asi poder evaluar el valor de x a encontrar. Esto es de forma resumida el metodo analitico para obtener el nuevo valor, pero existe una forma de resolverlo para tener una optimizacion en el algoritmo.

Dentro del libro de Chapra se encuentra lo siguiente:

![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/ef48ff63-a82c-47ed-88fe-afe7b3e84fdb) (Chapra,2006)

En esta imagen se encuentra una forma distinta de obtener el resultado, utilizando sumas,restas,multiplicacion y division.

Vemos como _f(x)_ se divide en 3 partes la operacion en _b0,b1 y b2_. Donde cada una de estas estan acompañadas de operaciones para obtener su resultado. Estos valores son los que conocemos. Al hacer cada operacion respectiva de _b0,b1 y b2_ nos dara un resultado el cual sera remplazado los valores de b0,b1 yb2 en f(x), para posteriormente resolver las operaciones que se presentan. 

De esta manera obtener el valor nuevo dentro de la interpolacion. Cabe a destarcar que la variable x es la variable que queremos encontrar su valor en f(x).

De esa manera se ahorra utlizar un metodo de despeje, lo que puede ahorrar tiempo.

# Algoritmo
    def funcion(x[],fx[])

        b0=fx0

        b1=(fx1-fx0)/(x1-x0)

        b2=(((fx2-fx1)/(x2-x1))-((fx1-fx0)/(x1-x0)))/(x2-x0)

        f2=b0+b1*(x-x0)+b2*(x-x0)*(x-x1)

En este algortimo, se hace respecto a la imagen obtenida del libro de Chapra, en el cual muestra como realizar el metodo de manera sencilla.

En el algoritmo se representa la manera en la cual se iran trabajando las operaciones de b0,b1 y b2 que son parte de una funcion, el cual recibe dos parametros de tipo lista o float (en el caso de que no se manejen listas) donde contengan los valores de x y f(x) conocidos tambien como x0,f(x0)...x2 y f(x2).

De esta manera se realizaran las operaciones correspondientes para asi obtener el resultado de f(x) que en este caso es llamado f2.

# Codigo en Java
```java
import java.util.Scanner;

public class Intercuadra {

    public static float cuad(float x0,float fx0,float x1,float fx1,float x2,float fx2,float x){
        float b0,b1,b2,f2;
        b0=fx0;
        b1=(fx1-fx0)/(x1-x0);
        b2=(((fx2-fx1)/(x2-x1))-((fx1-fx0)/(x1-x0)))/(x2-x0);
        f2=b0+b1*(x-x0)+b2*(x-x0)*(x-x1);
        return f2;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        float x0=0,fx0=0,x1=0,fx1=0,x2=0,fx2=0,x=0;
        System.out.println("Ingresa el valor para x0: ");
        x0 = sc.nextFloat();
        System.out.println("Ingresa el valor para fx0: ");
        fx0 = sc.nextFloat();
        System.out.println("Ingresa el valor para x1: ");
        x1 = sc.nextFloat();
        System.out.println("Ingresa el valor para fx1: ");
        fx1 = sc.nextFloat();
        System.out.println("Ingresa el valor para x2: ");
        x2 = sc.nextFloat();
        System.out.println("Ingresa el valor para fx2: ");
        fx2 = sc.nextFloat();
        System.out.println("Ingresa el valor de x para calcular f(x): ");
        x = sc.nextFloat();
        
        System.out.println("El valor de f(x) es: "+cuad(x0,fx0,x1,fx1,x2,fx2,x) );
    }
}

```

# Comprobacion del funcionamiento del codigo

## Ejercicio 1:
-  ![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/706dd050-b240-44d8-b7fa-4d4bb1f58473)
    
    En esta tabla tenemos los datos de horas del dia _(X)_ y respecto a la hora del dia tenemos su temperatura que se tiene en esa hora _((f(x))_. Se quiere conocer que temperatura haria a las 9 a.m. Por lo tanto con ayuda de los puntos conocidos se va a tratar de encontrar la temperatura.

    + Codigo:

     ![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/9173ee3b-020d-4496-84f1-3381b20ab925)

## Ejercicio 2:   
- ![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/ea5d23cb-d428-4a1e-be42-d15c313e75e8)

    En esta tabla se muetran los valores que tienen un logaritmo natural evaluado en x, pero se quiere saber que valor tendria que el valor de x fuera 2

    - Resultado en java:

    ![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/0cb37b15-5557-4e3b-963b-fea796cf0ab6)
