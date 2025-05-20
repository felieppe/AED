package ta10;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String rutaArchivo = "src/main/java/ta10/sucursales.txt";

        Empresa empresa1 = new Empresa();
        try {
            FileReader fileReader = new FileReader(rutaArchivo);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String linea;
            while ((linea = bufferedReader.readLine()) != null) {
                Sucursal sucursal1 = new Sucursal(linea);
                empresa1. add(sucursal1);
            }
            bufferedReader.close();

            List<Comparable> direcciones = empresa1.listarSucursales();
            for (Comparable direccion : direcciones) {
                System.out.println(direccion.toString());
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}

/*
Pregunta 3: Consumo de memoria
El consumo de memoria en estructuras de datos como las que hemos discutido (listas y conjuntos) depende principalmente de:

Tipo de datos almacenados: Los objetos más complejos consumen más memoria.
Estructura de la colección: Listas y conjuntos pueden tener diferentes requisitos de memoria según su implementación (e.g., listas enlazadas vs. arrays dinámicos).
Listas:

En Java, el uso de ArrayList para implementar un conjunto implica un array interno. El consumo de memoria de un ArrayList incluye el array subyacente más una pequeña cantidad de memoria para los atributos de la clase (como el tamaño). Cuando el array se llena, se crea un nuevo array de mayor tamaño y se copian los elementos, lo que temporalmente duplica el consumo de memoria durante la expansión.
Conjuntos (Set) implementados como listas:

La implementación del conjunto como lista sin duplicados implica verificar cada inserción para duplicados, lo cual no aumenta el uso de memoria más allá de lo que usa una lista, excepto por las estructuras temporales durante operaciones como la unión e intersección.
Para un conjunto basado en HashSet (aunque no se ha discutido en este contexto, pero es relevante para comparar), el uso de memoria sería mayor inicialmente debido al uso de una tabla hash, pero ofrece inserciones, eliminaciones y búsquedas más rápidas en promedio.
*/
/*
Pregunta 4: Tiempo de Ejecucion 
Órdenes del Tiempo de Ejecución de las Funcionalidades Desarrolladas
Unión e Intersección en Listas Ordenadas:

Unión: O(n + m), donde n y m son las longitudes de las dos listas. Esto es porque cada elemento de ambas listas se visita una vez en el peor caso.
Intersección: O(n + m), por la misma razón que la unión.
Estos tiempos de ejecución asumen que las listas están ordenadas y que se puede avanzar secuencialmente a través de ambas listas, comparando elementos actuales y avanzando los índices de manera adecuada.

Operaciones sobre Conjuntos basados en Listas:

Las operaciones de unión e intersección dependen de cómo se implementen los métodos add y contains:
Si add verifica duplicados usando contains, y contains es O(n) (búsqueda lineal en una lista), entonces agregar n elementos puede ser O(n^2) en el peor caso si cada inserción requiere una búsqueda completa.
Las implementaciones optimizadas, como usando HashSet o árboles binarios, pueden mejorar significativamente estos tiempos.
*/