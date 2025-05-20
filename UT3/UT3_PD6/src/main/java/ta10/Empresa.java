package ta10;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Empresa extends LinkedList {
    private LinkedList<Sucursal> listaDeSucursales;

    public Empresa() {
        this.listaDeSucursales = new LinkedList<>();
    }

    /* Orden N, porque inserta al final y para eso recorrés la lista. */
    public boolean add(Sucursal direccion) {
        listaDeSucursales.add(direccion);
        return true;
    }
    
    /* Orden N, porque tiene que recorrer la lista. */
    public Sucursal buscar(Sucursal direccion) {
        for (Sucursal sucursal : listaDeSucursales) {
            if (sucursal.getDireccion().equals(direccion)) {
                return sucursal;
            }
        }
        return null;
    }

    /* Orden N */
    public boolean remove(Sucursal direccion) {
        this.remove(direccion);
        return true;
    }

    /* Orden N */
    public List<Comparable> listarSucursales() {
        ArrayList<Comparable> lista = new ArrayList<>();
        for (Sucursal sucursal : listaDeSucursales) {
            lista.add(sucursal.getDireccion());
        }
        return lista;
    }

    /* Orden 1 */
    public int cantSucursales() {
        return this.size();
    }

    /* Orden 1 */
    public boolean estaVacio() {
        return this.isEmpty();
    }
}

