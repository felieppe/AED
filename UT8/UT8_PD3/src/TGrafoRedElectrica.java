import java.util.*;

public class TGrafoRedElectrica extends TGrafoNoDirigido {
    public TGrafoRedElectrica(List<TVertice> vertices, List<TArista> aristas) {
        super(vertices, aristas);
    }

    public TAristas mejorRedElectrica() {
        return kruskal();
    }

    private TAristas kruskal() {
        TAristas resultado = new TAristas();
        Collections.sort(this.lasAristas); 

        Map<TVertice, TVertice> parent = new HashMap<>();
        for (TVertice v : this.getVertices().values()) {
            parent.put(v, v);
        }

        int numAristas = 0;
        for (TArista arista : this.lasAristas) {
            if (numAristas == this.getVertices().size() - 1) break;

            TVertice u = arista.getEtVerticeOrigen();
            TVertice v = arista.getEtVerticeDestino();
            if (find(parent, u) != find(parent, v)) {
                resultado.add(arista);
                union(parent, u, v);
                numAristas++;
            }
        }
        return resultado;
    }

    private TVertice find(Map<TVertice, TVertice> parent, TVertice vertex) {
        if (parent.get(vertex) == vertex) return vertex;
        return find(parent, parent.get(vertex));
    }

    private void union(Map<TVertice, TVertice> parent, TVertice u, TVertice v) {
        TVertice rootU = find(parent, u);
        TVertice rootV = find(parent, v);
        parent.put(rootU, rootV);
    }
}
