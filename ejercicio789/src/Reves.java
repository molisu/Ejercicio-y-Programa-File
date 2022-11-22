import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;

public class Reves {

    public static void main(String[] args) {

        // 1. Array Unidimensional de String
        String arrayStrings[] = {"A", "l", " ", "r", "e", "v", "e", "s", " ", ":", "o"};

        for (String dato : arrayStrings) {
            System.out.println(dato);
        }

        // 2. Array Bidimensional de enteros
        int[][] enteros = new int[2][3];

        enteros[0][0] = 4;
        enteros[0][1] = 5;
        enteros[0][2] = 6;

        enteros[1][0] = 1;
        enteros[1][1] = 2;
        enteros[1][2] = 3;

        for (int i = 0; i < enteros.length; i ++) {
            for (int f = 0; f < enteros[i].length; f ++) {
                System.out.println("La posicion es: " + i + ", " + f + "    y su valor: " + enteros[i][f]);
            }
        }

        // 3. Vector
        Vector<Integer> vectorInt = new Vector<>();

        vectorInt.add(10);
        vectorInt.add(20);
        vectorInt.add(30);
        vectorInt.add(40);
        vectorInt.add(50);

        vectorInt.remove(1);
        vectorInt.remove(2);

        System.out.println(vectorInt);

        // 4. Problema de utilizar un Vector con capacidad x defecto si tuviera 1000 elem para ser añadidos

        //      Un vector x defecto tiene una capacida de 10, cuando debe incrementarse x defecto se duplica
        // cada vez que sea necesario para llegar al tamaño desesado, proceso que utiliza demasiada memoria
        // y puede asi volver demasiado lento y pesado el programa.


        // 5. ArrayList de String
        ArrayList<String> arrayListString = new ArrayList<>();

        arrayListString.add("ñau");
        arrayListString.add("guau");
        arrayListString.add("oink");
        arrayListString.add("muuu");

        for (String dato : arrayListString) {
            System.out.println(dato);
        }

        LinkedList<String> linkedListCopy = new LinkedList<>(arrayListString);

        for (String dato : linkedListCopy) {
            System.out.println(dato);
        }

        // 6. ArrayList de int
        ArrayList<Integer> arrayListInteger = new ArrayList<>();

        for (int i = 1; i < 11; i ++) {
            arrayListInteger.add(i);
        }

        for (int i = 0; i < arrayListInteger.size(); i ++) {
            if (arrayListInteger.get(i) % 2 == 0) {
                arrayListInteger.remove(arrayListInteger.get(i));
            }
        }

        System.out.println(arrayListInteger);

    }

    // 7. Funcion DividePorCero
    public static int dividePorCero(int a, int b) throws ArithmeticException {
        int result = 0;

        try {
            result = a / b;
        } catch (ArithmeticException e) {
            System.out.println("Esto no puede hacerse");
        } finally {
            System.out.println("Demo de código");
        }
        return result;
    }

    // 8. Funcion con InputStream y PrintStream
    public static void copiarFichero(InputStream fileIn, PrintStream fileOut) {
        try {
            byte[] datos = fileIn.readAllBytes();
            fileIn.close();

            fileOut.write(datos);
            fileOut.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }



    // Cadena al revés
    public static String reverse(String texto) {
        String reves = "";

        for (int i = texto.length() -1; i >= 0; i --) {
            reves += texto.charAt(i);
        }
        return reves;
    }
}
