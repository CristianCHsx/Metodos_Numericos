# Interpolacion cuadratica

La interpolacion cuadratica sigue el mismo objetivo que la interpolacion lineal, es cual es encontrar un punto nuevo apartir de otros ya conocidos. Tambien es conocido como la interpolacion de Newton.

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