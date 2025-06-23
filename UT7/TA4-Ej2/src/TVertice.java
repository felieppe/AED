import java.util.*;

public class TVertice {
    private Comparable etiqueta;
    private LinkedList<TArista> adyacentes;
    private boolean visitado;

    public TVertice(Comparable etiqueta) {
        this.etiqueta = etiqueta;
        this.adyacentes = new LinkedList<>();
        this.visitado = false;
    }

    public Comparable getEtiqueta() {
        return etiqueta;
    }

    public void agregarAdyacente(TArista arista) {
        adyacentes.add(arista);
    }

    public void bpf(Collection<TVertice> visitados) {
        this.visitado = true;
        visitados.add(this);
        for (TArista adyacente : adyacentes) {
            TVertice verticeDestino = adyacente.getDestino();
            if (!verticeDestino.visitado) {
                verticeDestino.bpf(visitados);
            }
        }
    }

    public static class TArista {
        private TVertice origen;
        private TVertice destino;

        public TArista(TVertice origen, TVertice destino) {
            this.origen = origen;
            this.destino = destino;
        }

        public TVertice getDestino() {
            return destino;
        }
    }
}

