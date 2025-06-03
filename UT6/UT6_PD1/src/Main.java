public class Main {
    public static void main(String[] args) {
        
        TNodoTrie trieHashMap = new TNodoTrie();
        TNodoTrie trieArray = new TNodoTrie(); 
        
        String[] palabras = {"hola", "holanda", "holaquehace", "hoja", "hora"};
        for (String palabra : palabras) {
            trieHashMap.insertar(palabra);
            trieArray.insertar(palabra);
        }

        long inicioHashMap = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            for (String palabra : palabras) {
                trieHashMap.buscar(palabra);
            }
        }
        long finHashMap = System.nanoTime();
        
        long inicioArray = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            for (String palabra : palabras) {
                trieArray.buscar(palabra);
            }
        }
        long finArray = System.nanoTime();

        long duracionHashMap = finHashMap - inicioHashMap;
        long duracionArray = finArray - inicioArray;
        System.out.println("Tiempo de búsqueda en Trie con HashMap: " + duracionHashMap + " nanosegundos.");
        System.out.println("Tiempo de búsqueda en Trie con Array: " + duracionArray + " nanosegundos.");
    }
}
