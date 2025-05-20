import java.util.HashMap;
import java.util.HashSet;

public class NodoTrie {
    public HashMap<Character, NodoTrie> hijos;
    public boolean esFinDePalabra;
    public HashSet<Integer> paginas;

    public NodoTrie() {
        this.hijos = new HashMap<>();
        this.esFinDePalabra = false;
        this.paginas = new HashSet<>();
    }

    public void agregarPagina(int pagina) {
        this.paginas.add(pagina);
    }

    public NodoTrie obtenerOCrearHijo(char caracter) {
        return hijos.computeIfAbsent(caracter, c -> new NodoTrie());
    }

    public boolean tieneHijo(char caracter) {
        return hijos.containsKey(caracter);
    }

    public NodoTrie obtenerHijo(char caracter) {
        return hijos.get(caracter);
    }
}
