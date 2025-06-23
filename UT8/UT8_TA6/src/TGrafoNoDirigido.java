
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class TGrafoNoDirigido extends TGrafoDirigido implements IGrafoNoDirigido {

    protected TAristas lasAristas = new TAristas();
    private TAristas aristas;

    /**
     *
     * @param vertices
     * @param aristas
     */
    public TGrafoNoDirigido(Collection<TVertice> vertices, Collection<TArista> aristas) {
        super(vertices, aristas);
        lasAristas.insertarAmbosSentidos(aristas);

    }

    @Override
    public boolean insertarArista(TArista arista) {
        boolean tempbool = false;
        TArista arInv = new TArista(arista.getEtiquetaDestino(), arista.getEtiquetaOrigen(), arista.getCosto());
        tempbool = (super.insertarArista(arista) && super.insertarArista(arInv));
        return tempbool;
    }

    public TAristas getLasAristas() {
        return lasAristas;
    }

    @Override
    public TGrafoNoDirigido Prim() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public TGrafoNoDirigido Kruskal() {
        ConjuntosDisjuntos cd = new ConjuntosDisjuntos(vertices.size());
        Collection<TArista> resultado = new ArrayList<TArista>();
        aristas.ordenarPorCosto();
    
        for (TArista arista : aristas.getAristas()) {
            int u = getVertexIndex(arista.getEtiquetaOrigen());
            int v = getVertexIndex(arista.getEtiquetaDestino());
            if (cd.encontrar(u) != cd.encontrar(v)) {
                resultado.add(arista);
                cd.unir(u, v);
            }
        }
        return this;
    }

    private int getVertexIndex(Comparable etiqueta) {
        int index = 0;
        for (TVertice vertice : vertices) {
            if (vertice.getEtiqueta().equals(etiqueta)) {
                return index;
            }
            index++;
        }
        return -1;
    }

    @Override
    public Collection<TVertice> bea(Comparable etiquetaOrigen) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
