
import java.util.Collection;

public class PruebaGrafo {

        public static void main(String[] args) {
            TGrafoDirigido grafo = new TGrafoDirigido();
    
            TVertice v1 = new TVertice("A");
            TVertice v2 = new TVertice("B");
            TVertice v3 = new TVertice("C");
            TVertice v4 = new TVertice("D");
    
            grafo.agregarVertice(v1);
            grafo.agregarVertice(v2);
            grafo.agregarVertice(v3);
            grafo.agregarVertice(v4);
    
            v1.agregarAdyacente(new TVertice.TArista(v1, v2));
            v1.agregarAdyacente(new TVertice.TArista(v1, v3));
            v2.agregarAdyacente(new TVertice.TArista(v2, v4));
            v3.agregarAdyacente(new TVertice.TArista(v3, v4));
    
            Collection<TVertice> resultado = grafo.bpf();
            System.out.println("Recorrido BPF desde el primer vértice:");
            for (TVertice vertice : resultado) {
                System.out.println(vertice.getEtiqueta());
            }
        }
    }

