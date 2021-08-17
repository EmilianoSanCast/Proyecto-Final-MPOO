package classes;

import static classes.Principal.alumnos;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class Archivo {

    public static final String SEPARATOR = ";";
    public static final String QUOTE = "\"";

    public static ArrayList<String> leer_archivo_csv(String name) {
        ArrayList<String> data = new ArrayList<>();
        try {
            BufferedReader br = null;
            br = new BufferedReader(new FileReader(name));
            String line = br.readLine();
            while (null != line) {
                data.add(line);
                line = br.readLine();
            }
            br.close();
        } catch (Exception e) {
            System.out.println("Excepcion: " + e.getMessage());
        }
        return data;
    }

    public static void escribir_archivo_csv(String name) {
        alumnos.sort((o1, o2) -> String.valueOf(o2.getNumero_inscripcion()).compareTo(
                String.valueOf(o1.getNumero_inscripcion())));
        try {
            FileWriter csvWriter = new FileWriter(name);
            csvWriter.append("Name\n");

            for (Alumno item : alumnos) {
                csvWriter.append(item.toFile() + "\n");
            }

            csvWriter.flush();
            csvWriter.close();
            System.out.println("\nDatos exportados correctamente\n");
        } catch (Exception e) {
            System.out.println("Excepcion: " + e.getMessage());
        }
    }
}
