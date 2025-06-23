import java.util.*;

public class TGrafoDirigido {
    private Map<Comparable, TVertice> vertices;

    public TGrafoDirigido() {
        vertices = new HashMap<>();
    }

    public Collection<TVertice> bpf() {
        Collection<TVertice> visitados = new LinkedList<>();
        for (TVertice vertice : vertices.values()) {
            if (!visitados.contains(vertice)) {
                vertice.bpf(visitados);
            }
        }
        return visitados;
    }

    public Collection<TVertice> bpf(TVertice verticeOrigen) {
        Collection<TVertice> visitados = new LinkedList<>();
        verticeOrigen.bpf(visitados);
        return visitados;
    }

    public Collection<TVertice> bpf(Comparable etiquetaOrigen) {
        Collection<TVertice> visitados = new LinkedList<>();
        TVertice verticeOrigen = vertices.get(etiquetaOrigen);
        if (verticeOrigen != null) {
            verticeOrigen.bpf(visitados);
        }
        return visitados;
    }

    public void agregarVertice(TVertice vertice) {
        vertices.put(vertice.getEtiqueta(), vertice);
    }

    public TVertice getVertice(Comparable etiqueta) {
        return vertices.get(etiqueta);
    }
}
