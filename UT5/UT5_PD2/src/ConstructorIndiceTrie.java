import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConstructorIndiceTrie {
    
    public Map<String, List<Integer>> construirIndice(String archivo) {
        Trie trie = new Trie();

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",\\s*"); 
                String palabra = partes[0]; 
                List<Integer> paginas = new ArrayList<>();
                for (int i = 1; i < partes.length; i++) {
                    paginas.add(Integer.parseInt(partes[i].trim()));
                }
                // Insertar la palabra en el Trie junto con sus páginas
                for (Integer pagina : paginas) {
                    trie.insertar(palabra, pagina);
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
        
        // Construir el índice a partir del Trie
        return construirIndiceDesdeTrie(trie);
    }
    
    private Map<String, List<Integer>> construirIndiceDesdeTrie(Trie trie) {
        Map<String, List<Integer>> indice = new HashMap<>();
        for (String palabra : trie.obtenerTodasLasPalabras()) {
            indice.put(palabra, trie.buscar(palabra));
        }
        return indice;
    }
}
