import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Trie {
    private NodoTrie raiz;

    public Trie() {
        this.raiz = new NodoTrie();
    }

    public void insertar(String palabra, int pagina) {
        NodoTrie nodoActual = raiz;
        for (char c : palabra.toCharArray()) {
            if (!nodoActual.getHijos().containsKey(c)) {
                nodoActual.setHijo(c, new NodoTrie());
            }
            nodoActual = nodoActual.getHijo(c);
        }
        nodoActual.setFinPalabra(true);
        nodoActual.agregarPagina(pagina);
    }

    public List<Integer> buscar(String palabra) {
        NodoTrie nodoActual = raiz;
        for (char c : palabra.toCharArray()) {
            if (!nodoActual.getHijos().containsKey(c)) {
                return new ArrayList<>(); // Palabra no encontrada
            }
            nodoActual = nodoActual.getHijo(c);
        }
        if (nodoActual == null || !nodoActual.esFinPalabra()) {
            return new ArrayList<>(); // Palabra no encontrada
        }
        return nodoActual.getPaginas();
    }   

    public List<String> obtenerTodasLasPalabras() {
        List<String> palabras = new ArrayList<>();
        obtenerTodasLasPalabras(raiz, "", palabras);
        return palabras;
    }

    private void obtenerTodasLasPalabras(NodoTrie nodo, String prefijo, List<String> palabras) {
        if (nodo == null) return;
        if (nodo.esFinPalabra()) {
            palabras.add(prefijo);
        }
        for (char c : nodo.getHijos().keySet()) {
            obtenerTodasLasPalabras(nodo.getHijo(c), prefijo + c, palabras);
        }
    }
}


