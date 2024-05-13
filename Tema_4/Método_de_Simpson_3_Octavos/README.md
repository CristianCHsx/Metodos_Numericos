# Método de Simpson 3/8
Es un metodo de integracion numerica que busca aproximar el resultado a una integral definida. Este método es una variente al metodo de simpson de 1/3.

La diferencia clave entre este y el otro método es en la forma de caso particula que se puede usar. Puede considerarse un poco mas exacto al resultado pero con unos requisitos previos.

Por ejemplo el numero de intervalos que se pueden utilizar deben ser multiplos de 3. Ya que regla lo maneja asi, utilizando puntos establecidos para ta tener un medida mas aprxomiada.

Si los valores de los intervalos fueran diferentes a un multiplo de 3 no se podria aplicar este metodo.
De igual modo existe la forma simple de aplicar y la forma compuesta (multivariable)

∫[a,b] f(x) dx ≈ (3h/8) * [f(a) + 3f(m1) + 3f(m2) + f(b)]

La forma compuesta tendra lo siguiente:

∫[a,b] f(x) dx ≈ (3h/8) * [f(a) + 3f(m1) + 3f(m2) + 2f(m3) + f(b)]

En donde se tendrá que evaluar un tercer valor mas y ser multiplicado por 2.

# Algoritmo

![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/1f3fcb3a-0755-4e77-b0bc-70914783c93d)(Chapra,2006)

Se puede visualizar que aplica la formula con los valores para la formula.

Existe un algoritmo mas que esta incluido en la seccion, que es un combiacion de los algoritmos para poder crear un algoritmo de aplicacion multiple para un numero de segmentos tanto impares como pares, en cual es el siguiente:

![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/c8c4507f-b74c-460a-98a8-be3034b22ad7)



# Codigo en Java
```java
package simpsonun8;
import java.util.Scanner;
import java.text.DecimalFormat;
/**
 *
 * @author crist
 */
public class SimpsonUn8 {
    
    
    public static double f(double x){
        return 1/x;
    }

    public static double simpSimple(double a, double b, int n){
        double h,sum=0;
        double xi[] = new double [n+1];
        h=(b-a)/3;
        for (int i = 0; i <= n; i++) {
            xi[i]=a;
            a+=h;
            if(i>0&&i<n){
                sum += 3*f(xi[i]);
            }else{
                sum +=f(xi[i]);
            }   
        }
      
        sum = ((3*h)/8)*sum;
        
        return sum;
    }
    
    public static double simpCompuesta(double a, double b, int n){
        double h,sum=0;
        double xi[] = new double [n+1];
        h=(b-a)/n;
        
        for (int i = 0; i <= n; i++) {
            xi[i]=a;
            a+=h;
            if(i==0||i==n){
                sum+=f(xi[i]);
            }else if(i%3==0){
                sum+=2*f(xi[i]);
            }else{
                sum+=3*f(xi[i]);
            }
        }
        
        sum = ((3*h)/8)*sum;
        
        return sum;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("####.####");
        double a,b;
        int n;
        
        System.out.println("Ingresa el valor de a:");
        a = sc.nextDouble();
        System.out.println("Ingresa el valor de b:");
        b = sc.nextDouble();
        System.out.println("Ingresa el numero de intervalos(n):");
        n = sc.nextInt();
        
        if(n==3){
            System.out.println(df.format(simpSimple(a,b,n)));
        }else if (n%3==0){
            System.out.println(df.format(simpCompuesta(a,b,n)));
        }     
        
    }
    
}

```

# Demostracion del funcionamiento del codigo hecho en Java

## Ejemplo 1:
  - **Funcion:**

    ![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/820eb034-478a-46e7-b255-30b3468478d0)

 - **Solucion dado por el programa:**

    ![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/18c062f0-07e1-479d-a7a7-0cbad7d6d403)

 - **Solucion dado por Symbolab**

   ![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/6f5364f8-315c-4f23-b6c5-743cc7b8bf56)
 
## Ejemplo 2:
  - **Funcion:**

    ![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/4f0f6631-fe33-40c5-a69e-ee508869b42d)

 - **Solucion dado por el programa:**

    ![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/3573d8d2-56ff-4ce7-8ca7-8b6804d9d211)

 - **Solucion dado por Symbolab**

   ![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/c5b4182f-3621-48fa-987e-317d439dfeb1)

## Ejemplo 3:
  - **Funcion:**

    ![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/2ea530c4-5d6b-4812-b5bc-b03cb34fdf38)

 - **Solucion dado por el programa:**

    ![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/467ac190-7f00-4a59-8d14-b56582fd59f4)

 - **Solucion dado por Symbolab**

   ![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/1128c7f3-e274-40cd-baf8-c48a7d850737)

## Ejemplo 4:
  - **Funcion:**

    ![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/ab075003-7a68-4b93-adbf-0ed3be07b8eb)

 - **Solucion dado por el programa:**

    ![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/428fb386-7df5-46f5-bfb7-588d274480f0)

 - **Solucion dado por Symbolab**

   ![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/1503f675-8efd-48e4-aa9d-953019a649ad)

## Ejemplo 5:
  - **Funcion:**

    ![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/d28e5aa4-9c76-47d1-87f1-42cefe57b0c7)

 - **Solucion dado por el programa:**

    ![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/19540fcc-dfb2-468e-ac4c-cb4ec76c7c2f)

 - **Solucion dado por Symbolab**

   ![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/8853087c-45bf-4882-b9f1-cb2aee881d9b)
