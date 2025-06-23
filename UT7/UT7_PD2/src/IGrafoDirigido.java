import java.util.Map;

public interface IGrafoDirigido {
    boolean eliminarArista(Comparable nomVerticeOrigen, Comparable nomVerticeDestino);

    boolean existeArista(Comparable etiquetaOrigen, Comparable etiquetaDestino);

    boolean existeVertice(Comparable unaEtiqueta);

    boolean insertarArista(TArista arista);

    boolean insertarVertice(Comparable unaEtiqueta);

    boolean insertarVertice(TVertice vertice);

    Object[] getEtiquetasOrdenado();

    Map<Comparable, TVertice> getVertices();

    Comparable centroDelGrafo();

    Double[][] floyd();

    Comparable obtenerExcentricidad(Comparable etiquetaVertice);

    boolean[][] warshall();

    boolean eliminarVertice(Comparable nombreVertice);
}

