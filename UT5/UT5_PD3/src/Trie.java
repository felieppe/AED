import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

public class Trie {
    private NodoTrie raiz;

    private HashSet<String> palabrasClave;

    public Trie() {
        raiz = new NodoTrie();
        palabrasClave = new HashSet<>();
    }

    public void cargarPalabrasClave(String rutaArchivo) throws FileNotFoundException {
        File archivo = new File(rutaArchivo);
        Scanner scanner = new Scanner(archivo);
        while (scanner.hasNextLine()) {
            String palabra = scanner.nextLine().trim().toLowerCase();
            palabrasClave.add(palabra);
        }
        scanner.close();
    }

    public void insertar(String palabra, int pagina) {
        if (palabrasClave.contains(palabra)) {  
            NodoTrie actual = raiz;
            for (char ch : palabra.toCharArray()) {
                actual = actual.obtenerOCrearHijo(ch);
            }
            actual.esFinDePalabra = true;
            actual.agregarPagina(pagina);
        }
    }
    
    public void indizarLibro(String rutaLibro) throws FileNotFoundException {
        File libro = new File(rutaLibro);
        Scanner scanner = new Scanner(libro);
        int numeroDeLinea = 0;
        int paginaActual = 1;

        while (scanner.hasNextLine()) {
            String linea = scanner.nextLine().toLowerCase().replaceAll("[^a-záéíóúñ]", " ");
            String[] palabras = linea.split("\\s+");
            for (String palabra : palabras) {
                if (!palabra.isEmpty()) {
                    insertar(palabra, paginaActual);
                }
            }
            numeroDeLinea++;
            if (numeroDeLinea % 50 == 0) {
                paginaActual++;
            }
        }
        scanner.close();
    }

    public void imprimirIndice() {
        imprimirIndice(raiz, "");
    }

    private void imprimirIndice(NodoTrie nodo, String palabra) {
        if (nodo == null) {
            return;
        }
        if (nodo.esFinDePalabra) {
            System.out.print(palabra + ": ");
            for (int pagina : nodo.paginas) {
                System.out.print(pagina + " ");
            }
            System.out.println();
        }
        nodo.hijos.forEach((ch, hijo) -> imprimirIndice(hijo, palabra + ch));
    }

    public String buscar(String palabra) {
        NodoTrie actual = raiz;
        int comparaciones = 0;

        for (char ch : palabra.toCharArray()) {
            if (!actual.hijos.containsKey(ch)) {
                return "Palabra no encontrada. Comparaciones realizadas: " + comparaciones;
            }
            actual = actual.hijos.get(ch);
            comparaciones++;
        }

        if (actual.esFinDePalabra) {
            return "Palabra encontrada. Páginas: " + actual.paginas.toString() + ". Comparaciones realizadas: " + comparaciones;
        } else {
            return "Palabra no encontrada. Comparaciones realizadas: " + comparaciones;
        }
    }
}



