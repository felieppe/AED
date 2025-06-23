import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try {
            List<TVertice> vertices = cargarVertices("src\\barrio.txt");
            List<TArista> aristas = cargarAristas("src\\distancias.txt", vertices);
            TGrafoRedElectrica grafo = new TGrafoRedElectrica(vertices, aristas);
            TAristas mejorRed = grafo.mejorRedElectrica();
            generarArchivoSalida("redelectrica.txt", mejorRed);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<TVertice> cargarVertices(String fileName) throws IOException {
        List<TVertice> vertices = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = reader.readLine()) != null) {
            if (!line.trim().isEmpty()) {
                vertices.add(new TVertice(line.trim()));
            }
        }
        reader.close();
        return vertices;
    }

    private static List<TArista> cargarAristas(String fileName, List<TVertice> vertices) throws IOException {
        List<TArista> aristas = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] partes = line.trim().split("\\s+");
            if (partes.length == 3) {
                TVertice origen = encontrarVertice(vertices, partes[0].trim());
                TVertice destino = encontrarVertice(vertices, partes[1].trim());
                int peso = Integer.parseInt(partes[2].trim());
                aristas.add(new TArista(origen, destino, peso));
            }
        }
        reader.close();
        return aristas;
    }

    private static TVertice encontrarVertice(List<TVertice> vertices, String nombre) {
        for (TVertice v : vertices) {
            if (v.getEtiqueta().equals(nombre)) return v;
        }
        return null;
    }

    private static void generarArchivoSalida(String fileName, TAristas aristas) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        writer.write("Algoritmo utilizado: Kruskal\n");
        int costoTotal = 0;
        for (TArista arista : aristas) {
            writer.write(arista.getEtiquetaOrigen() + " - " + arista.getEtiquetaDestino() + "\n");
            costoTotal += arista.getPeso();
        }
        writer.write("Costo total: " + costoTotal + "\n");
        writer.close();
    }
}
