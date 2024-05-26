# Metodo de Euler

El metodo de Euler o tambien conocido como el metodo de Euler-Cauchy o de punto pendiente.
Es una tecnica, que tiene como objetivo aproximar la solucion de una ecuacion diferencial ordinaria. Esto se puede ya que usualmente en un problema de este calibre, se encuentran los datos necesarios para poder encontrar una respuesta acercada.

Como lo son la ecuacion dada (lineal) y sus condiciones iniciales ademas de una condicion extra (que servira como un rango), con estos datos es posible encontrar una solucion aproximada. El proceso que tiene el método es encontrar nuevos valores de _y_, para conocer mas puntos nuevos a traves de puntos previamente conocidos. Esto se hace de forma iterativa, dependiendo de la cantidad de pasos (_ch o h_) que se hayan elegido. Para encontrar los nuevos valores de _y_ se utiliza una formula, la cual es la que le da el nombre a este metodo.

La formula que se utiliza es la siguiente:

![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/7f73a712-93a5-4c6d-aba9-c5b415c07b92)(Chapra,2006)

Se puede notar que en la formula se utiliza _yi_, _f(x,y)_ y _h_
-   **yi:** Es el valor de _y_ actual
-   **f(x,y):** Es la funcion evaluada en _x_ y _y_
-   **h:** Son los pasos, este se obtiene con la siguiente formula: $\(xf-xi)/ch$   (ch es la cantidad de pasos)

Con la formula se obtiene **_yi+1_**  este es el valor de nuevo de _y_ que de forma iterada se ira encontrando.
# Algoritmo

# Codigo en Java

![image](https://github.com/CristianCHsx/Metodos-Numericos/assets/162630564/65e01dbd-5815-423c-9370-562215b80840)

# Prueba de funcionamiento