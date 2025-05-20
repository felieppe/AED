package uy.edu.ucu.aed.modelo;

/**
 * Clase que representa una película en el catálogo.
 * 
 * Cada película tiene un título, año de estreno, género y puntaje.
 * Los objetos de esta clase son inmutables una vez creados.
 */
public class Pelicula {
    /**
     * Título de la película.
     */
    private String titulo;

    /**
     * Año de estreno de la película.
     */
    private int anio;

    /**
     * Género de la película.
     */
    private String genero;

    /**
     * Puntaje de la película (por ejemplo, de 0 a 10).
     */
    private float puntaje;

    /**
     * Crea una nueva instancia de Pelicula.
     *
     * @param titulo  Título de la película. No debe ser null.
     * @param anio    Año de estreno de la película.
     * @param genero  Género de la película. No debe ser null.
     * @param puntaje Puntaje de la película.
     */
    public Pelicula(String titulo, int anio, String genero, float puntaje) {
        this.titulo = titulo;
        this.anio = anio;
        this.genero = genero;
        this.puntaje = puntaje;
    }

    /**
     * Devuelve el título de la película.
     * @return Título de la película.
     */
    public String getTitulo() { return titulo; }

    /**
     * Devuelve el año de estreno de la película.
     * @return Año de estreno.
     */
    public int getAnio() { return anio; }

    /**
     * Devuelve el género de la película.
     * @return Género de la película.
     */
    public String getGenero() { return genero; }

    /**
     * Devuelve el puntaje de la película.
     * @return Puntaje de la película.
     */
    public float getPuntaje() { return puntaje; }
}
