import java.util.*;

public class TGrafoDirigido implements IGrafoDirigido {

    private Map<Comparable, TVertice> vertices; // vertices del grafo

    public TGrafoDirigido(Collection<TVertice> vertices, Collection<TArista> aristas) {
        this.vertices = new HashMap<>();
        for (TVertice vertice : vertices) {
            insertarVertice(vertice);
        }
        for (TArista arista : aristas) {
            insertarArista(arista);
        }
    }

    @Override
    public boolean eliminarArista(Comparable nomVerticeOrigen, Comparable nomVerticeDestino) {
        if (nomVerticeOrigen != null && nomVerticeDestino != null) {
            TVertice vertOrigen = buscarVertice(nomVerticeOrigen);
            if (vertOrigen != null) {
                return vertOrigen.eliminarAdyacencia(nomVerticeDestino);
            }
        }
        return false;
    }

    @Override
    public boolean existeArista(Comparable etiquetaOrigen, Comparable etiquetaDestino) {
        TVertice vertOrigen = buscarVertice(etiquetaOrigen);
        TVertice vertDestino = buscarVertice(etiquetaDestino);
        if (vertOrigen != null && vertDestino != null) {
            return vertOrigen.buscarAdyacencia(vertDestino) != null;
        }
        return false;
    }

    @Override
    public boolean existeVertice(Comparable unaEtiqueta) {
        return getVertices().get(unaEtiqueta) != null;
    }

    private TVertice buscarVertice(Comparable unaEtiqueta) {
        return getVertices().get(unaEtiqueta);
    }

    @Override
    public boolean insertarArista(TArista arista) {
        if (arista.getEtiquetaOrigen() != null && arista.getEtiquetaDestino() != null) {
            TVertice vertOrigen = buscarVertice(arista.getEtiquetaOrigen());
            TVertice vertDestino = buscarVertice(arista.getEtiquetaDestino());
            if (vertOrigen != null && vertDestino != null) {
                return vertOrigen.insertarAdyacencia(arista.getCosto(), vertDestino);
            }
        }
        return false;
    }

    @Override
    public boolean insertarVertice(Comparable unaEtiqueta) {
        if (unaEtiqueta != null && !existeVertice(unaEtiqueta)) {
            TVertice vert = new TVertice(unaEtiqueta);
            getVertices().put(unaEtiqueta, vert);
            return getVertices().containsKey(unaEtiqueta);
        }
        return false;
    }

    @Override
    public boolean insertarVertice(TVertice vertice) {
        Comparable unaEtiqueta = vertice.getEtiqueta();
        if (unaEtiqueta != null && !existeVertice(unaEtiqueta)) {
            getVertices().put(unaEtiqueta, vertice);
            return getVertices().containsKey(unaEtiqueta);
        }
        return false;
    }

    @Override
    public Object[] getEtiquetasOrdenado() {
        TreeMap<Comparable, TVertice> mapOrdenado = new TreeMap<>(this.getVertices());
        return mapOrdenado.keySet().toArray();
    }

    @Override
    public Map<Comparable, TVertice> getVertices() {
        return vertices;
    }

    @Override
    public Comparable centroDelGrafo() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Double[][] floyd() {
        int n = vertices.size();
        Double[][] dist = new Double[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Double.POSITIVE_INFINITY);
            dist[i][i] = 0.0;
        }

        int i = 0;
        Map<Comparable, Integer> indices = new HashMap<>();
        for (Comparable etiqueta : vertices.keySet()) {
            indices.put(etiqueta, i++);
        }

        for (TVertice vertice : vertices.values()) {
            int origenIdx = indices.get(vertice.getEtiqueta());
            for (Object adyacenciaObj : vertice.getAdyacentes()) {
                TAdyacencia adyacencia = (TAdyacencia) adyacenciaObj;
                int destinoIdx = indices.get(adyacencia.getDestino().getEtiqueta());
                dist[origenIdx][destinoIdx] = (Double) adyacencia.getCosto();
            }
        }

        for (int k = 0; k < n; k++) {
            for (int i2 = 0; i2 < n; i2++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i2][k] + dist[k][j] < dist[i2][j]) {
                        dist[i2][j] = dist[i2][k] + dist[k][j];
                    }
                }
            }
        }

        return dist;
    }

    @Override
    public Comparable obtenerExcentricidad(Comparable etiquetaVertice) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean[][] warshall() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean eliminarVertice(Comparable nombreVertice) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int[][] matrizCostos() {
        int n = vertices.size();
        int[][] matriz = new int[n][n];
        for (int[] fila : matriz) {
            Arrays.fill(fila, Integer.MAX_VALUE);
        }
        int i = 0;
        Map<Comparable, Integer> indices = new HashMap<>();
        for (Comparable etiqueta : vertices.keySet()) {
            indices.put(etiqueta, i++);
        }
        for (TVertice vertice : vertices.values()) {
            int origenIdx = indices.get(vertice.getEtiqueta());
            for (Object obj : vertice.getAdyacentes()) {
                TAdyacencia adyacencia = (TAdyacencia) obj;
                int destinoIdx = indices.get(adyacencia.getDestino().getEtiqueta());
                matriz[origenIdx][destinoIdx] = (int) adyacencia.getCosto();
            }
        }
        return matriz;
    }

    public List<List<Comparable>> todosLosCaminos(Comparable origen, Comparable destino) {
        List<List<Comparable>> caminos = new LinkedList<>();
        List<Comparable> caminoActual = new LinkedList<>();
        TVertice verticeOrigen = buscarVertice(origen);
        if (verticeOrigen != null) {
            encontrarCaminos(verticeOrigen, destino, caminoActual, caminos);
        }
        return caminos;
    }

    private void encontrarCaminos(TVertice actual, Comparable destino, List<Comparable> caminoActual, List<List<Comparable>> caminos) {
        caminoActual.add(actual.getEtiqueta());
        actual.setVisitado(true);
    
        if (actual.getEtiqueta().equals(destino)) {
            caminos.add(new LinkedList<>(caminoActual));
        } else {
            for (Object obj : actual.getAdyacentes()) {
                TAdyacencia adyacencia = (TAdyacencia) obj;
                TVertice verticeDestino = adyacencia.getDestino();
                if (!verticeDestino.getVisitado()) {
                    encontrarCaminos(verticeDestino, destino, caminoActual, caminos);
                }
            }
        }
    
        caminoActual.remove(actual.getEtiqueta());
        actual.setVisitado(false);
    }
}
