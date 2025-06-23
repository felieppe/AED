public class TArista implements Comparable<TArista> {
    private final TVertice etOrigen;
    private final TVertice etDestino;
    private final double peso;  // Change the type to double

    public TArista(TVertice etDestino2, TVertice etOrigen2, double peso) {
        this.etOrigen = etDestino2;
        this.etDestino = etOrigen2;
        this.peso = peso;
    }

    public TVertice getEtVerticeOrigen() {
        return etOrigen;
    }

    public TVertice getEtVerticeDestino() {
        return etDestino;
    }

    public double getPeso() {  
        return peso;
    }

    public TArista aristaInversa() {
        return new TArista(etDestino, etOrigen, peso);
    }

    @Override
    public int compareTo(TArista otraArista) {
        return Double.compare(this.peso, otraArista.getPeso());  
    }

    public TVertice getEtiquetaOrigen() {
        return etOrigen;
    }

    public TVertice getEtiquetaDestino() {
        return etDestino;
    }
}