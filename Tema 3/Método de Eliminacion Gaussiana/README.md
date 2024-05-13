# Eliminacion Gaussiana

Es un metodo que se utiliza para resolver sistemas de ecuaciones lineales, el cual consiste en operar sobre una matriz ampliada del sistema de ecuaciones hasta hallar la forma escalonada.

Esto se obtiene un sistema de ecuaciones facil de resolver por despejes

Si se llegase a obtener una matriz identidad, el sistema es compatible determinado

## Algoritmo

1. Convertir el sistema de ecuaciones a una matriz aumentada
2. Hacer operaciones en las filas para convertir en una matriz escalonada
   - Intercambiar filas
   - Multplicar filas por un numero != 0
   - Sumar a una fila el multiplo de otra fila
   - Dividir entre el mismo numero
4. Regresar al paso 3 hasta tener la matriz escalonada
5. Resolver sistema de ecuaciones, remplazandolo con los valores obtenidos

