import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<String> buscar(String palabra) {
    NodoTrie nodoActual = raiz;
    for (char c : palabra.toCharArray()) {
        if (!nodoActual.getHijos().containsKey(c)) {
            return Collections.singletonList("La palabra no esta en ninguna pagina"); // -1 indica que la palabra no se encontró en ninguna página
        }
        nodoActual = nodoActual.getHijo(c);
    }
    if (nodoActual == null || !nodoActual.esFinPalabra()) {
        return Collections.singletonList("La palabra no esta en ninguna pagina"); // -1 indica que la palabra no se encontró en ninguna página
    }
    return nodoActual.getPaginas().stream().map(String::valueOf).collect(Collectors.toList());
}
}
