package uy.edu.ucu.aed.parcial;

import uy.edu.ucu.aed.tdas.ArbolAVL;
import uy.edu.ucu.aed.tdas.ILista;
import uy.edu.ucu.aed.tdas.Lista;

import java.util.List;

import uy.edu.ucu.aed.modelo.CatalogoPeliculas;
import uy.edu.ucu.aed.modelo.ClavePelicula;
import uy.edu.ucu.aed.modelo.Pelicula;

/**
 * Clase que representa un catálogo de películas utilizando un árbol AVL.
 * Permite insertar películas y realizar búsquedas por puntaje y género.
 */
public class CatalogoPeliculasAVL implements CatalogoPeliculas {
    /**
     * Árbol AVL que almacena las películas, ordenadas por puntaje y título.
     */
    private ArbolPeliculasAVL arbolPorPuntaje;

    /**
     * Constructor de la clase CatalogoPeliculasAVL.
     * Inicializa el árbol AVL para almacenar las películas.
     */
    public CatalogoPeliculasAVL() {
        this.arbolPorPuntaje = new ArbolPeliculasAVL();
    }

    @Override
    public void insertarPelicula(Pelicula pelicula) {
        ClavePelicula clave = new ClavePelicula(pelicula.getPuntaje(), pelicula.getTitulo());
        arbolPorPuntaje.insertar(clave, pelicula);
    }

    @Override
    public ILista<Pelicula> buscarPorPuntaje(Float minimo, Float maximo) {
        ILista<Pelicula> encontradas = new Lista<Pelicula>();
        List<Pelicula> peliculas = arbolPorPuntaje.inOrden();
        ILista<Pelicula> peliculasOrdenadas = new Lista<Pelicula>();

        if (minimo == null && maximo == null) {
            for (int x = 0; x < peliculas.size(); x++) {
                Pelicula peli = peliculas.get(x);

                ClavePelicula clave = new ClavePelicula(peli.getPuntaje(), peli.getTitulo());
                encontradas.insertar(peli, clave);
            }
        } else {
            for (int x = 0; x < peliculas.size(); x++) {
                Pelicula peli = peliculas.get(x);
                ClavePelicula clave = new ClavePelicula(peli.getPuntaje(), peli.getTitulo());
 
                if (minimo != null && peli.getPuntaje() >= minimo) {
                    encontradas.insertar(peli, clave);
                } else if (maximo != null && peli.getPuntaje() <= maximo) {
                    encontradas.insertar(peli, clave);
                }
            }
        }
        // crear un arbol avl para ordenar las peliculas encontradas por año
        ArbolAVL<Pelicula> arbolPorAnio = new ArbolAVL<>();

        // ordenar las peliculas encontradas por  año en el arbol
        for (Pelicula peli : encontradas){
            ClaveAnio clave = new ClaveAnio(peli.getAnio(), peli.getTitulo());
            arbolPorAnio.insertar(clave, peli);
        }

        //recorremos el arbol en inorden dandonos el orden de menor a mayor
        List<Pelicula> ordenadas =  arbolPorAnio.inOrden();

        for (Pelicula peli : ordenadas){
           peliculasOrdenadas.insertar(peli, new ClavePelicula(peli.getPuntaje(), peli.getTitulo()));
        }

        return peliculasOrdenadas;
    }

    @Override
    public ILista<Pelicula> buscarPorGenero(String genero) {
        ILista<Pelicula> encontradas = new Lista<Pelicula>();
        List<Pelicula> peliculas = arbolPorPuntaje.inOrden();
        ILista<Pelicula> peliculasOrdenadas = new Lista<Pelicula>();

        if (genero == null || genero.isEmpty()) {
            for (int x = 0; x < peliculas.size(); x++) {
                Pelicula peli = peliculas.get(x);

                ClavePelicula clave = new ClavePelicula(peli.getPuntaje(), peli.getTitulo());
                encontradas.insertar(peli, clave);
            }
        } else {
            for (int x = 0; x < peliculas.size(); x++) {
                Pelicula peli = peliculas.get(x);

                if (peli.getGenero().equals(genero)) {
                    ClavePelicula clave = new ClavePelicula(peli.getPuntaje(), peli.getTitulo());
                    encontradas.insertar(peli, clave);
                }
            }
        }
        if (encontradas.cantElementos() == 0) {
            return peliculasOrdenadas;
        }
        
        ArbolAVL<Pelicula> arbolPorAnio = new ArbolAVL<>();
        // ordenar las peliculas encontradas por  año en el arbol
        for (Pelicula peli : encontradas){
            ClaveAnio clave = new ClaveAnio(peli.getAnio(), peli.getTitulo());
            arbolPorAnio.insertar(clave, peli);
        }

        List<Pelicula> ordenadas =  arbolPorAnio.inOrden();

        for (Pelicula peli : ordenadas){
           peliculasOrdenadas.insertar(peli, new ClavePelicula(peli.getPuntaje(), peli.getTitulo()));
        }
        return peliculasOrdenadas;
    }
}