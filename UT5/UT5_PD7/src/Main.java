import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        TArbolTrieTelefonos trie = new TArbolTrieTelefonos();
        cargarAbonados(trie, "src/abonados.txt");

        try {
            LinkedList<TAbonado> resultados;
            BufferedReader br = new BufferedReader(new FileReader("src/codigos1.txt"));
            BufferedWriter bw = new BufferedWriter(new FileWriter("src/salida.txt"));
            String linea;
            String codigoPais = "";
            String codigoArea = "";
            while ((linea = br.readLine()) != null) {
                if (linea.startsWith("CODIGO PAIS:")) {
                    codigoPais = linea.split(":")[1].trim();
                } else if (linea.startsWith("CODIGO AREA:")) {
                    codigoArea = linea.split(":")[1].trim();
                    resultados = trie.buscarTelefonos(codigoPais, codigoArea);
                    for (TAbonado abonado : resultados) {
                        bw.write(abonado.getNombre() + "," + abonado.getTelefono() + "\n");
                    }
                    codigoPais = "";
                    codigoArea = "";
                }
            }
            br.close();
            bw.close();
        } catch (IOException e) {
            System.out.println("Error al manejar archivos: " + e.getMessage());
        }
    }

    private static void cargarAbonados(TArbolTrieTelefonos trie, String archivo) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(archivo));
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length < 2) {
                    System.out.println("Línea mal formateada: " + linea);
                    continue;
                }
                TAbonado abonado = new TAbonado(datos[1], datos[0]);
                trie.insertar(abonado);
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
