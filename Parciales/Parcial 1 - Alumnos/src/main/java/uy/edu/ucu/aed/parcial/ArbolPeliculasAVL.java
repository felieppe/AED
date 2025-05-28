package uy.edu.ucu.aed.parcial;

import uy.edu.ucu.aed.tdas.ArbolAVL;
import uy.edu.ucu.aed.tdas.ElementoAB;
import uy.edu.ucu.aed.tdas.IElementoAB;
import uy.edu.ucu.aed.modelo.Pelicula;

@SuppressWarnings("rawtypes")
/**
 * Clase que representa un árbol AVL de películas.
 * Esta clase extiende la clase ArbolAVL y define un nodo específico para películas.
 */
public class ArbolPeliculasAVL extends ArbolAVL<Pelicula> {
    @Override
    protected IElementoAB<Pelicula> crearNodo(Comparable etiqueta, Pelicula unDato) {
        return new NodoPelicula(etiqueta, unDato);
    }

    // Implementar aquí los métodos necesarios a nivel del árbol

    /**
     * Clase interna que representa un nodo de película en el árbol.
     * Extiende la clase ElementoAB para almacenar películas y permite búsquedas específicas.  
     */    
    private class NodoPelicula extends ElementoAB<Pelicula> {
        /**
         * Constructor del nodo de película.
         * @param etiqueta Clave o etiqueta del nodo.
         * @param datos Datos de la película a almacenar.
         */
        public NodoPelicula(Comparable etiqueta, Pelicula datos) {
            super(etiqueta, datos);
        }

        // Implementar aquí los métodos necesarios a nivel del nodo
    }
}
