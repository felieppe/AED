import java.util.Collection;
import java.util.LinkedList;

public class PruebaGrafo {
    public static void main(String[] args) {
        TAristas aristas = new TAristas();
        aristas.add(new TArista("A", "B", 1));
        aristas.add(new TArista("B", "C", 2));
        aristas.add(new TArista("A", "C", 3));

        Collection<TVertice> vertices = new LinkedList<>();
        vertices.add(new TVertice("A"));
        vertices.add(new TVertice("B"));
        vertices.add(new TVertice("C"));

        TGrafoNoDirigido grafo = new TGrafoNoDirigido(vertices, aristas);
        TAristas mst = grafo.Kruskal();
        
        for (TArista arista : mst) {
            System.out.println(arista.getEtiquetaOrigen() + " - " + arista.getEtiquetaDestino() + " : " + arista.getCosto());
        }
    }
}