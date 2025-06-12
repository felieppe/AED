
import java.util.LinkedList;

public interface IVertice<T> {
    Comparable getEtiqueta();

    LinkedList<TAdyacencia> getAdyacentes();

    TAdyacencia buscarAdyacencia(TVertice verticeDestino);

    Double obtenerCostoAdyacencia(TVertice verticeDestino);

    boolean insertarAdyacencia(Double costo, TVertice verticeDestino);

    boolean eliminarAdyacencia(Comparable nomVerticeDestino);

    TVertice primerAdyacente();

    TVertice siguienteAdyacente(TVertice w);
    
    TAdyacencia buscarAdyacencia(Comparable etiquetaDestino);
}
