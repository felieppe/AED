import java.util.HashMap;

class TNodoTrie {
    private HashMap<Character, TNodoTrie> hijos;
    private boolean esPalabra;

    public TNodoTrie() {
        hijos = new HashMap<>();
        esPalabra = false;
    }

    public void insertar(String palabra) {
        TNodoTrie nodo = this;
        for (char c : palabra.toCharArray()) {
            nodo.hijos.putIfAbsent(c, new TNodoTrie());
            nodo = nodo.hijos.get(c);
        }
        nodo.esPalabra = true;
    }

    public boolean buscar(String palabra) {
        TNodoTrie nodo = this;
        for (char c : palabra.toCharArray()) {
            nodo = nodo.hijos.get(c);
            if (nodo == null) {
                return false;
            }
        }
        return nodo.esPalabra;
    }

    public void predecir(String prefijo, String resultado) {
        TNodoTrie nodo = this;
        for (char c : prefijo.toCharArray()) {
            nodo = nodo.hijos.get(c);
            if (nodo == null) {
                return;
            }
        }
        predecirRecursivo(nodo, prefijo, resultado);
    }

    private void predecirRecursivo(TNodoTrie nodo, String prefijo, String resultado) {
        if (nodo.esPalabra) {
            System.out.println(prefijo + resultado);
        }
        for (Character c : nodo.hijos.keySet()) {
            predecirRecursivo(nodo.hijos.get(c), prefijo, resultado + c);
        }
    }
}