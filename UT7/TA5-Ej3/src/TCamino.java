import java.util.LinkedList;

public class TCamino {
    private LinkedList<TAdyacencia> adyacencias;
    private TVertice origen;
    private double costoTotal;

    public TCamino(TVertice origen) {
        this.adyacencias = new LinkedList<>();
        this.origen = origen;
        this.costoTotal = 0;
    }

    public LinkedList<TAdyacencia> getAdyacencias() {
        return adyacencias;
    }

    public TVertice getUltimoVertice() {
        if (adyacencias.isEmpty()) {
            return origen;
        } else {
            return adyacencias.getLast().getDestino();
        }
    }

    public void agregarAdyacencia(TAdyacencia adyacencia) {
        adyacencias.add(adyacencia);
        costoTotal += adyacencia.getCosto();
    }

    public double getCostoTotal() {
        return costoTotal;
    }

    public TCamino copiar() {
        TCamino copia = new TCamino(this.origen);
        for (TAdyacencia adyacencia : this.adyacencias) {
            copia.agregarAdyacencia(adyacencia);
        }
        return copia;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(origen.getEtiqueta());
        for (TAdyacencia adyacencia : adyacencias) {
            sb.append(" -> ").append(adyacencia.getDestino().getEtiqueta());
        }
        sb.append(" (Costo: ").append(costoTotal).append(")");
        return sb.toString();
    }
}
