import java.util.LinkedList;

public class TNodoTrieTelefonos implements INodoTrieTelefonos {

    private TNodoTrieTelefonos[] hijos;
    private boolean esFinal;
    private TAbonado abonado;

    public TNodoTrieTelefonos() {
        hijos = new TNodoTrieTelefonos[10]; // Nodos para cada dígito del 0 al 9
        esFinal = false;
        abonado = null;
    }

    @Override
    public void insertar(TAbonado unAbonado) {
        TNodoTrieTelefonos nodo = this;
        for (char digito : unAbonado.getTelefono().toCharArray()) {
            int indice = digito - '0';
            if (nodo.hijos[indice] == null) {
                nodo.hijos[indice] = new TNodoTrieTelefonos();
            }
            nodo = nodo.hijos[indice];
        }
        nodo.esFinal = true;
        nodo.abonado = unAbonado;
    }

    @Override
    public void buscarTelefonos(String primerosDigitos, LinkedList<TAbonado> abonados) {
        TNodoTrieTelefonos nodo = this;
        for (char digito : primerosDigitos.toCharArray()) {
            int indice = digito - '0';
            if (nodo.hijos[indice] == null) {
                return; // No hay abonados con esos primeros dígitos
            }
            nodo = nodo.hijos[indice];
        }
        nodo.recolectarAbonados(abonados);
    }

    private void recolectarAbonados(LinkedList<TAbonado> abonados) {
        if (this.esFinal) {
            abonados.add(this.abonado);
        }
        for (TNodoTrieTelefonos hijo : this.hijos) {
            if (hijo != null) {
                hijo.recolectarAbonados(abonados);
            }
        }
    }
}

