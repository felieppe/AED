import java.util.*;

public class Main {
    public static void main(String[] args) {
        Collection<TVertice> vertices = new LinkedList<>();
        vertices.add(new TVertice("Artigas", null));
        vertices.add(new TVertice("Canelones", null));
        vertices.add(new TVertice("Durazno", null));
        vertices.add(new TVertice("Florida", null));
        vertices.add(new TVertice("Montevideo", null));
        vertices.add(new TVertice("Punta del Este", null));
        vertices.add(new TVertice("Rocha", null));

        Collection<TArista> aristas = new LinkedList<>();
        aristas.add(new TArista("Artigas", "Rocha", 400));
        aristas.add(new TArista("Canelones", "Artigas", 500));
        aristas.add(new TArista("Canelones", "Colonia", 200));
        aristas.add(new TArista("Canelones", "Durazno", 170));
        aristas.add(new TArista("Canelones", "Punta del Este", 90));
        aristas.add(new TArista("Colonia", "Montevideo", 180));
        aristas.add(new TArista("Florida", "Durazno", 60));
        aristas.add(new TArista("Montevideo", "Artigas", 700));
        aristas.add(new TArista("Montevideo", "Canelones", 30));
        aristas.add(new TArista("Montevideo", "Punta del Este", 130));
        aristas.add(new TArista("Punta del Este", "Rocha", 90));
        aristas.add(new TArista("Rocha", "Montevideo", 270));

        TGrafoDirigido grafo = new TGrafoDirigido(vertices, aristas);

        System.out.println("Existe el vértice Montevideo: " + grafo.existeVertice("Montevideo"));
        System.out.println("Existe el vértice Colonia: " + grafo.existeVertice("Colonia"));

        System.out.println("Existe la arista Montevideo -> Punta del Este: " + grafo.existeArista("Montevideo", "Punta del Este"));
        System.out.println("Existe la arista Florida -> Durazno: " + grafo.existeArista("Florida", "Durazno"));

        Object[] etiquetasOrdenadas = grafo.getEtiquetasOrdenado();
        System.out.println("Etiquetas de los vértices ordenadas: " + Arrays.toString(etiquetasOrdenadas));

        int[][] matrizCostos = grafo.matrizCostos();
        System.out.println("Matriz de costos:");
        for (int i = 0; i < matrizCostos.length; i++) {
            for (int j = 0; j < matrizCostos[i].length; j++) {
                if (matrizCostos[i][j] == Integer.MAX_VALUE) {
                    System.out.print("INF ");
                } else {
                    System.out.print(matrizCostos[i][j] + " ");
                }
            }
            System.out.println();
        }

        Double[][] floydResult = grafo.floyd();
        System.out.println("Resultado del algoritmo de Floyd:");
        for (int i = 0; i < floydResult.length; i++) {
            for (int j = 0; j < floydResult[i].length; j++) {
                if (floydResult[i][j] == Double.POSITIVE_INFINITY) {
                    System.out.print("INF ");
                } else {
                    System.out.print(floydResult[i][j] + " ");
                }
            }
            System.out.println();
        }

        Comparable origen = "Montevideo";
        Comparable destino = "Rocha";
        List<List<Comparable>> caminos = grafo.todosLosCaminos(origen, destino);
        System.out.println("Todos los caminos desde " + origen + " hasta " + destino + ":");
        for (List<Comparable> camino : caminos) {
            System.out.println(camino);
        }
    }
}
