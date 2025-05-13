import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NodoTrie {
    private Map<Character, NodoTrie> hijos;
    private boolean finPalabra;
    private List<Integer> paginas;

    public NodoTrie() {
        this.hijos = new HashMap<>();
        this.finPalabra = false;
        this.paginas = new ArrayList<>();
    }

    public Map<Character, NodoTrie> getHijos() {
        return hijos;
    }

    public NodoTrie getHijo(char c) {
        return hijos.get(c);
    }

    public void setHijo(char c, NodoTrie nodo) {
        hijos.put(c, nodo);
    }

    public boolean esFinPalabra() {
        return finPalabra;
    }

    public void setFinPalabra(boolean finPalabra) {
        this.finPalabra = finPalabra;
    }

    public List<Integer> getPaginas() {
        return paginas;
    }

    public void agregarPagina(int pagina) {
        paginas.add(pagina);
    }
}