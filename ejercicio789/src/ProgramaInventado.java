import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ProgramaInventado {

    public static void main(String[] args) {
        String rutaIn;
        String rutaOut;
        String claves;
        String[] datos = new String[0];
        String[] datosSeparados;
        Map<String, String> user;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese ruta del fichero: ");

        rutaIn = scanner.nextLine();

        // Guardo el file
        claves = readFromFile(rutaIn);
        // Separo datos
        datosSeparados = separar(claves);
        // Mapeo Usuario
        user = mapearUser(datosSeparados);


        System.out.println("Ingrese ruta y nombre del archivo (formato: ../../ejemplo.txt):     ");
        rutaOut = scanner.nextLine();
        scanner.close();


        // Creo File con info user mapeada
        crearFile(rutaOut, user);
    }

    // Funcion que devuelve en String los datos del fichero
    public static String readFromFile(String ruta) {
        byte[] datos;
        String str = "";
        try {
            InputStream in = new FileInputStream(ruta);
            datos = in.readAllBytes();
            in.close();

            str = new String(datos, StandardCharsets.UTF_8);
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: Ruta invalida! No se puede leer el archivo.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return str;
    }

    // Funcion que separa por cadera y lo guarda en un array de String
    public static String[] separar(String datos) {

        String[] datosSeparados = new String[0];
        datosSeparados = datos.split("\r\n" );
        return datosSeparados;
    }

    // Funcion que mapea la info en un Hash Map con clave (clasificacion) y valor desde el file
    public static Map<String, String> mapearUser(String[] datos) {
        Map<String, String> mapa = new HashMap<>();

        for (int i = 0; i < datos.length; i ++) {
            switch (i) {
                case 0:
                    mapa.put("Usuario", datos[i]);

                case 1:
                    mapa.put("Password", datos[i]);

                case 2:
                    mapa.put("Correo", datos[i]);

                case 3:
                    mapa.put("Telefono", datos[i]);
                    break;
            }
        }
        return mapa;
    }

    // Funcion que crea file con la info de HashMap
    public static void crearFile(String ruta, Map<String, String> user) {
        try {
            PrintStream ps = new PrintStream(ruta);
            ps.println(user);
            ps.close();

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }
}
