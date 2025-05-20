import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        Trie trie = new Trie();

        String rutaPalabrasClave = "UT5_PD3\\src\\PalabrasIndice.txt";
        String rutaLibro = "UT5_PD3\\src\\libro.txt";

        try {
            trie.cargarPalabrasClave(rutaPalabrasClave);
            System.out.println("Palabras clave cargadas con éxito desde: " + rutaPalabrasClave);
        } catch (FileNotFoundException e) {
            System.out.println("Error: El archivo de palabras clave no fue encontrado.");
            return; 
        }

        try {
            trie.indizarLibro(rutaLibro);
            System.out.println("Libro indexado con éxito.");
        } catch (FileNotFoundException e) {
            System.out.println("Error: El archivo del libro no fue encontrado.");
            return; 
        }

        String palabraABuscar = "dragón";
        String resultadoBusqueda = trie.buscar(palabraABuscar);
        System.out.println("Resultado de buscar '" + palabraABuscar + "': " + resultadoBusqueda);

        System.out.println("Índice del libro:");
        trie.imprimirIndice();
    }
}



