import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Trie trie = new Trie();

        String archivo = "UT5_PD2\\src\\texto.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",\\s*"); 
                String palabra = partes[0]; 
                List<String> paginas = Arrays.asList(Arrays.copyOfRange(partes, 1, partes.length));
                for (String paginaStr : paginas) {
                    int pagina = Integer.parseInt(paginaStr.trim()); // Convertir el número de página a entero porque antes lee todo en string
                    // Insertar la palabra en el Trie junto con su número de página
                    trie.insertar(palabra, pagina);
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
        

        List<Integer> paginasAlimaña = trie.buscar("Alimaña");
        System.out.println("Páginas de la palabra 'Alimaña': " + paginasAlimaña);
        List<Integer> paginasPerro = trie.buscar("Perro");
        System.out.println("Páginas de la palabra 'Perro': " + paginasPerro);
        List<Integer> paginasPrograma = trie.buscar("Programa");
        System.out.println("Páginas de la palabra 'Programa': " + paginasPrograma);
        List<Integer> paginasCazar = trie.buscar("Cazar");
        System.out.println("Páginas de la palabra 'Cazar': " + paginasCazar);
        List<Integer> paginasMaru = trie.buscar("Maru");
        System.out.println("Páginas de la palabra 'Maru': " + paginasMaru);
        
        ConstructorIndiceTrie constructorIndice = new ConstructorIndiceTrie();
        Map<String, List<Integer>> indice = constructorIndice.construirIndice(archivo);

        // Imprimir el índice
        System.out.println("Índice del texto:");
        for (Map.Entry<String, List<Integer>> entrada : indice.entrySet()) {
            System.out.println(entrada.getKey() + ": " + entrada.getValue());
        }
        }
}



