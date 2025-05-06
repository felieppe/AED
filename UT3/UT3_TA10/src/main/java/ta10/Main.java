package ta10;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String rutaArchivo = "src/main/java/ta10/sucursales.txt";

        Empresa empresa1 = new Empresa();
        try {
            FileReader fileReader = new FileReader(rutaArchivo);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String linea;
            while ((linea = bufferedReader.readLine()) != null) {
                Sucursal sucursal1 = new Sucursal(linea);
                empresa1. add(sucursal1);
            }
            bufferedReader.close();

            List<Comparable> direcciones = empresa1.listarSucursales();
            for (Comparable direccion : direcciones) {
                System.out.println(direccion.toString());
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}