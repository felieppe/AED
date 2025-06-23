import java.io.IOException;

public class PruebaGrafo {
    public static void main(String[] args) throws IOException {
        TGrafoDirigido grafo = UtilGrafos.cargarGrafo(
            "alumnos/src/aeropuertos_2.txt", 
            "alumnos/src/conexiones_2.txt",
            false,
            TGrafoDirigido.class
        );

        Comparable origen = "Asuncion"; 
        Comparable destino = "Curitiba"; 

        TCaminos caminos = grafo.todosLosCaminos(origen, destino);

        if (caminos != null && !caminos.getCaminos().isEmpty()) {
            System.out.println("Se encontraron caminos entre " + origen + " y " + destino);
            for (TCamino camino : caminos.getCaminos()) {
                System.out.println(camino);
            }
        } else {
            System.out.println("No se encontraron caminos entre " + origen + " y " + destino);
        }
    }
}
