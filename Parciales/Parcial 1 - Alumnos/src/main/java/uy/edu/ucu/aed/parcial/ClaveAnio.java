package uy.edu.ucu.aed.parcial;

//Clase auxiliar para representar una clave compuesta por año y título de una película para que se puedan repetir años en el arbol AVL
public class ClaveAnio implements Comparable<ClaveAnio> {

    private final int anio;

    private final String titulo;

    public ClaveAnio(int anio, String titulo) {
        this.anio = anio;
        this.titulo = titulo;
    }

    @Override
    public int compareTo(ClaveAnio o) {
        int cmp = Float.compare(this.anio, o.anio);
        if (cmp != 0) return cmp;
        return this.titulo.compareTo(o.titulo);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ClaveAnio)) return false;
        ClaveAnio other = (ClaveAnio) obj;
        return Float.compare(this.anio, other.anio) == 0 && this.titulo.equals(other.titulo);
    }

    @Override
    public int hashCode() {
        int result = Float.hashCode(anio);
        result = 31 * result + titulo.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return anio + "-" + titulo;
    }
}
