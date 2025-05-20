package uy.edu.ucu.aed;

import uy.edu.ucu.aed.modelo.CatalogoPeliculas;
import uy.edu.ucu.aed.modelo.Pelicula;
import uy.edu.ucu.aed.parcial.CatalogoPeliculasAVL;
import uy.edu.ucu.aed.tdas.ILista;
import uy.edu.ucu.aed.tdas.Lista;
import uy.edu.ucu.aed.utils.ManejadorArchivosGenerico;

/**
 * En esta clase se debe realizar la carga de los datos en la estructura, las búsquedas solicitadas y la escritura de los resultados en el archivo de texto.
 */
public class Main 
{
    public static void main(String[] args)
    {
        // Leer archivo Pelis.txt
        String[] lineas = ManejadorArchivosGenerico.leerArchivo("src/main/java/uy/edu/ucu/aed/Pelis.txt");

        // Crear catálogo de películas (internamente usa un árbol AVL)
        CatalogoPeliculas catalogo = new CatalogoPeliculasAVL();

        // Cargar películas al catálogo
        for (String linea : lineas) {
            // Cargar desde la linea provista, los datos spliteados
            String titulo = linea.split(";")[1];
            int anio = Integer.parseInt(linea.split(";")[0]);
            String genero = linea.split(";")[2];
            Float puntaje = Float.parseFloat(linea.split(";")[3]);

            // Cargar la línea (una película) en el catálogo
            Pelicula pelicula = new Pelicula(titulo, anio, genero, puntaje);
            catalogo.insertarPelicula(pelicula);
        }   

        StringBuilder sb = new StringBuilder();

        // // Búsqueda por puntaje: [6.0, 8.0]
        sb.append("Búsqueda por puntaje: [6.0, 8.0]\n");
        catalogo.buscarPorPuntaje(6.0f, 8.0f).forEach(pelicula -> {
            sb.append(pelicula.getAnio()).append(";")
              .append(pelicula.getTitulo()).append(";")
              .append(pelicula.getGenero()).append(";")
              .append(pelicula.getPuntaje()).append("\n");
        });

        // // Búsqueda por puntaje: solo máximo (<= 5.0)
        sb.append("\n" + "Búsqueda por puntaje: solo máximo (<= 5.0)\n");
        catalogo.buscarPorPuntaje(null, 5.0f).forEach(pelicula -> {
            sb.append(pelicula.getAnio()).append(";")
              .append(pelicula.getTitulo()).append(";")
              .append(pelicula.getGenero()).append(";")
              .append(pelicula.getPuntaje()).append("\n");
        });

        // // Búsqueda por puntaje: solo mínimo (>= 7.5)
        sb.append("\n" + "Búsqueda por puntaje: solo mínimo (>= 7.5)\n");
        catalogo.buscarPorPuntaje(7.5f, null).forEach(pelicula -> {
            sb.append(pelicula.getAnio()).append(";")
              .append(pelicula.getTitulo()).append(";")
              .append(pelicula.getGenero()).append(";")
              .append(pelicula.getPuntaje()).append("\n");
        });

        // // Búsqueda por género: "Romance"
        sb.append("\n" + "Búsqueda por género: \"Romance\"\n");
        catalogo.buscarPorGenero("Romance").forEach(pelicula -> {
            sb.append(pelicula.getAnio()).append(";")
              .append(pelicula.getTitulo()).append(";")
              .append(pelicula.getGenero()).append(";")
              .append(pelicula.getPuntaje()).append("\n");
        });

        // // Escribir resultados en archivo "src/main/java/uy/edu/ucu/aed/ResultadoBusquedas.txt"
        String nombreArchivo = "src/main/java/uy/edu/ucu/aed/ResultadoBusquedas.txt";
        String[] contenido = sb.toString().split("\n");

        ManejadorArchivosGenerico
        .escribirArchivo(nombreArchivo, contenido);
    }
}
