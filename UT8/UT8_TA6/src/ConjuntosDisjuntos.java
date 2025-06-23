public class ConjuntosDisjuntos {
    private int[] padre;
    private int[] rango;

    public ConjuntosDisjuntos(int n) {
        padre = new int[n];
        rango = new int[n];
        for (int i = 0; i < n; i++) {
            padre[i] = i;
            rango[i] = 0;
        }
    }

    public int encontrar(int u) {
        if (padre[u] != u) {
            padre[u] = encontrar(padre[u]);
        }
        return padre[u];
    }

    public void unir(int u, int v) {
        int raizU = encontrar(u);
        int raizV = encontrar(v);
        if (raizU != raizV) {
            if (rango[raizU] > rango[raizV]) {
                padre[raizV] = raizU;
            } else {
                padre[raizU] = raizV;
                if (rango[raizU] == rango[raizV]) {
                    rango[raizV]++;
                }
            }
        }
    }
}
