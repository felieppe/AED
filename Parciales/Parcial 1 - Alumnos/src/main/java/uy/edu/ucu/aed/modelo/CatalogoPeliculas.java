package uy.edu.ucu.aed.modelo;

import uy.edu.ucu.aed.tdas.ILista;

/**
 * Interfaz para el catálogo de películas.
 * Define las operaciones requeridas para insertar y buscar películas en el catálogo.
 * 
 * <p>
 * El catálogo debe permitir:
 * <ul>
 *   <li>Insertar nuevas películas.</li>
 *   <li>Buscar películas por puntaje, con posibilidad de definir un rango (mínimo y/o máximo).</li>
 *   <li>Buscar películas por género, ordenadas por año de estreno ascendente.</li>
 * </ul>
 * </p>
 */
public interface CatalogoPeliculas {
    /**
     * Inserta una nueva película en el catálogo.
     * <p>
     * Si la película ya existe (según el criterio de clave del catálogo), puede sobrescribirla o ignorar la inserción,
     * dependiendo de la implementación concreta.
     * </p>
     * 
     * @param pelicula Instancia de la película a agregar. No debe ser null.
     */
    void insertarPelicula(Pelicula pelicula);

    /**
     * Devuelve una lista de películas cuyo puntaje esté en el rango [minimo, maximo].
     * <ul>
     *   <li>Si <b>minimo</b> es null, no se aplica límite inferior.</li>
     *   <li>Si <b>maximo</b> es null, no se aplica límite superior.</li>
     *   <li>Si ambos son null, se devuelven todas las películas del catálogo.</li>
     *   <li>Si no hay películas en el rango, se retorna una lista vacía.</li>
     * </ul>
     * <p>
     * La lista devuelta debe estar ordenada por año de estreno ascendente.
     * </p>
     *
     * @param minimo Puntaje mínimo (inclusive) o null si no se desea límite inferior.
     * @param maximo Puntaje máximo (inclusive) o null si no se desea límite superior.
     * @return Una lista (nunca null) de películas en el rango de puntaje especificado, ordenadas por año ascendente.
     */
    ILista<Pelicula> buscarPorPuntaje(Float minimo, Float maximo);

    /**
     * Devuelve una lista de todas las películas de un género específico.
     * <ul>
     *   <li>La búsqueda de género no distingue mayúsculas/minúsculas.</li>
     *   <li>Si no hay películas del género solicitado, se retorna una lista vacía.</li>
     * </ul>
     * <p>
     * La lista devuelta debe estar ordenada por año de estreno ascendente.
     * </p>
     *
     * @param genero Género de las películas a buscar. No debe ser null.
     * @return Una lista (nunca null) de películas del género especificado, ordenadas por año ascendente.
     */
    ILista<Pelicula> buscarPorGenero(String genero);
}
