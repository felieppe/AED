import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ConstructorIndiceTrie {
    private Trie trie;

    public ConstructorIndiceTrie() {
        trie = new Trie();
    }

    public void cargarPalabrasIniciales(String rutaArchivo) throws FileNotFoundException {
        File archivo = new File(rutaArchivo);
        Scanner scanner = new Scanner(archivo);
        int numeroDeLinea = 1; 

        while (scanner.hasNextLine()) {
            String palabra = scanner.nextLine().trim().toLowerCase();
            if (!palabra.isEmpty()) {
                trie.insertar(palabra, numeroDeLinea); 
            }
            numeroDeLinea++;
        }
        scanner.close();
    }

    public void indizarLibro(String rutaLibro) throws FileNotFoundException {
        trie.indizarLibro(rutaLibro);
    }

    public void imprimirIndice() {
        trie.imprimirIndice();
    }

    public Trie getTrie() {
        return trie;
    }
}
