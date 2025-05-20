package ta2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Main {
    public static void main(String[] args) {
        TArbolBB arbol = new TArbolBB();
        try (BufferedReader reader = new BufferedReader(new FileReader("claves.txt"));
            BufferedWriter writer = new BufferedWriter(new FileWriter("resultados.txt"))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                boolean insertado = arbol.insertar(linea);
                writer.write(linea + " " + (insertado ? arbol.getContador() : 0));
                writer.newLine();
            }
        } catch (IOException e) {
        String archivo = "";
        TArbolBB arbol = new TArbolBB();
        String archivo2 = "";
    }

    public void leerYEscribirArchivo(String archivo, String archivo2, TArbolBB arbol) throws IOException {
        FileReader fr = new FileReader(archivo);
        BufferedReader br = new BufferedReader (fr);
        FileWriter fw = new FileWriter(archivo2);
        BufferedWriter bw = new BufferedWriter(fw);
        try {
            fr = new FileReader (archivo);
            String linea = br.readLine();
            while (linea != null) {
                arbol.buscar(linea);
                StringBuilder sb = new StringBuilder();
                sb.append(linea + ",");
                if (arbol.buscar(linea) != null) {
                    sb.append("encontrado");
                } else {
                    sb.append("no encontrado");
                }
                bw.close();
                linea = br.readLine();
            }
            fr.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}