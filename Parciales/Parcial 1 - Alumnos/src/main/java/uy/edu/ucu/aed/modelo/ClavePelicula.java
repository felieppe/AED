package uy.edu.ucu.aed.modelo;

/**
 * Clase que representa una clave de película, compuesta por un puntaje y un título.
 * Implementa la interfaz Comparable para permitir la comparación entre claves.
 */
public class ClavePelicula implements Comparable<ClavePelicula> {
    /**
     * Puntaje de la película.
     */
    private final float puntaje;

    /**
     * Título de la película.
     */
    private final String titulo;

    /**
     * Constructor de la clase ClavePelicula.
     *
     * @param puntaje Puntaje de la película.
     * @param titulo  Título de la película.
     */
    public ClavePelicula(float puntaje, String titulo) {
        this.puntaje = puntaje;
        this.titulo = titulo;
    }

    @Override
    /**
     * Método que compara dos claves de película.
     * Se ordenan primero por puntaje (de mayor a menor) y luego por título (alfabéticamente).
     *
     * @param o ClavePelicula a comparar.
     * @return Valor negativo si esta clave es menor, cero si son iguales, y positivo si es mayor.
     */
    public int compareTo(ClavePelicula o) {
        int cmp = Float.compare(this.puntaje, o.puntaje);
        if (cmp != 0) return cmp;
        return this.titulo.compareTo(o.titulo);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ClavePelicula)) return false;
        ClavePelicula other = (ClavePelicula) obj;
        return Float.compare(this.puntaje, other.puntaje) == 0 && this.titulo.equals(other.titulo);
    }

    @Override
    public int hashCode() {
        int result = Float.hashCode(puntaje);
        result = 31 * result + titulo.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return puntaje + "-" + titulo;
    }
}
