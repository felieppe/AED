import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AlgoritmoWarshall {
    private int[][] matrizAdyacencia;
    private int numCiudades;
    private Map<String, Integer> mapaCiudades;
    private Map<String, Integer> costosVuelos;

    public AlgoritmoWarshall(int numCiudades) {
        this.numCiudades = numCiudades;
        matrizAdyacencia = new int[numCiudades][numCiudades];
        costosVuelos = new HashMap<>();
    }

    public void agregarRuta(int desde, int hasta, int costo) {
        matrizAdyacencia[desde][hasta] = 1;
        String ruta = desde + "->" + hasta;
        costosVuelos.put(ruta, costo);
    }

    public void calcularCierreTransitivo() {
        for (int k = 0; k < numCiudades; k++) {
            for (int i = 0; i < numCiudades; i++) {
                for (int j = 0; j < numCiudades; j++) {
                    matrizAdyacencia[i][j] = matrizAdyacencia[i][j] | (matrizAdyacencia[i][k] & matrizAdyacencia[k][j]);
                }
            }
        }
    }

    public boolean estaConectado(int desde, int hasta) {
        return matrizAdyacencia[desde][hasta] == 1;
    }

    public static void main(String[] args) {
        String rutaAeropuertos = "TA3-CODIGO BASE/TA3-CODIGO BASE/src/aeropuertos_1.txt";
        String rutaConexiones = "TA3-CODIGO BASE/TA3-CODIGO BASE/src/conexiones_1.txt";

        try {
            // Leer el archivo de aeropuertos para mapear nombres a índices
            String[] lineasAeropuertos = ManejadorArchivosGenerico.leerArchivo(rutaAeropuertos, false);
            Map<String, Integer> mapaCiudades = new HashMap<>();
            int indiceCiudad = 0;

            for (String linea : lineasAeropuertos) {
                linea = linea.trim();
                if (!linea.isEmpty()) {
                    String[] partes = linea.split(" ", 2); // Divide en dos partes
                    if (partes.length == 2) {
                        String nombreCiudad = partes[1].trim();
                        mapaCiudades.put(nombreCiudad, indiceCiudad++);
                    }
                }
            }

            int numCiudades = mapaCiudades.size();
            AlgoritmoWarshall warshall = new AlgoritmoWarshall(numCiudades);
            warshall.mapaCiudades = mapaCiudades;

            // Leer el archivo de conexiones para agregar las rutas y costos
            String[] lineasConexiones = ManejadorArchivosGenerico.leerArchivo(rutaConexiones, false);
            for (String linea : lineasConexiones) {
                linea = linea.trim();
                if (!linea.isEmpty()) {
                    String[] partes = linea.split(",");
                    if (partes.length == 3) {
                        String desdeNombre = partes[0].trim();
                        String hastaNombre = partes[1].trim();
                        int costo = Integer.parseInt(partes[2].trim());
                        if (mapaCiudades.containsKey(desdeNombre) && mapaCiudades.containsKey(hastaNombre)) {
                            int desde = mapaCiudades.get(desdeNombre);
                            int hasta = mapaCiudades.get(hastaNombre);
                            warshall.agregarRuta(desde, hasta, costo);
                        }
                    }
                }
            }

            warshall.calcularCierreTransitivo();

            Scanner scanner = new Scanner(System.in);
            System.out.println("Ingrese las consultas (formato: 'ciudad_origen ciudad_destino'), -1 para terminar:");
            while (true) {
                System.out.print("Ciudad de origen: ");
                String desdeNombre = scanner.next().trim();
                if (desdeNombre.equals("-1")) break;
                System.out.print("Ciudad de destino: ");
                String hastaNombre = scanner.next().trim();
                if (mapaCiudades.containsKey(desdeNombre) && mapaCiudades.containsKey(hastaNombre)) {
                    int desde = mapaCiudades.get(desdeNombre);
                    int hasta = mapaCiudades.get(hastaNombre);

                    if (warshall.estaConectado(desde, hasta)) {
                        String ruta = desde + "->" + hasta;
                        int costo = warshall.costosVuelos.getOrDefault(ruta, -1);
                        if (costo != -1) {
                            System.out.println("Sí, es posible volar desde " + desdeNombre + " a " + hastaNombre + " con un costo de " + costo);
                        } else {
                            System.out.println("Sí, es posible volar desde " + desdeNombre + " a " + hastaNombre);
                        }
                    } else {
                        System.out.println("No, no es posible volar desde " + desdeNombre + " a " + hastaNombre);
                    }
                } else {
                    System.out.println("Una o ambas ciudades no se encuentran en el mapa: " + desdeNombre + ", " + hastaNombre);
                }
            }
            scanner.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
