package utilidades;

import java.util.Scanner;

public abstract class IO_ES {

    private static final Scanner SCANNER_INT = new Scanner(System.in);

    private static final Scanner SCANNER_DEC = new Scanner(System.in);
    private static final Scanner SCANNER_CHAR = new Scanner(System.in);

    public static int leerEntero() {
        return SCANNER_INT.nextInt();
    }

    public static int leerEntero(String mensaje) {

        escribir(mensaje);

        return SCANNER_INT.nextInt();

    }

    public static int leerEntero(String mensaje, int min, int max) {

        escribir(mensaje);

        int entero = SCANNER_INT.nextInt();

        return (entero >= min && entero <= max) ? entero : leerEntero("El número introducido debe estar entre " + min + "-" + max + ": ", min, max);

    }

    public static double leerDecimal() {
        return SCANNER_DEC.nextDouble();
    }

    public static double leerDecimal(String mensaje) {

        escribir(mensaje);

        return SCANNER_DEC.nextDouble();

    }

    public static double leerDecimal(String mensaje, double min, double max) {

        escribir(mensaje);

        double decimal = SCANNER_DEC.nextDouble();

        return (decimal >= min && decimal <= max) ? decimal : leerDecimal("El número introducido debe estar entre " + min + "-" + max + ": ", min, max);

    }

    public static char leerCaracter() {

        char caracter = SCANNER_CHAR.nextLine().charAt(0);

        return (String.valueOf(caracter).equals("")) ? leerCaracter() : caracter;
    }

    public static char leerCaracter(String mensaje) {

        escribir(mensaje);

        char caracter = SCANNER_CHAR.nextLine().charAt(0);

        if (String.valueOf(caracter).equals("")) {

            IO_ES.escribir("ERROR: No puede dejar el campo vacío.\n");

            return leerCaracter(mensaje);

        } else {

            return caracter;

        }

    }

    public static String leerCadena() {

        String cadena = SCANNER_CHAR.nextLine();

        return (cadena.equals("")) ? leerCadena() : cadena;

    }

    public static String leerCadena(String mensaje) {

        escribir(mensaje);

        String cadena = SCANNER_CHAR.nextLine();

        if (cadena.equals("")) {

            IO_ES.escribir("ERROR: No puede dejar el campo vacío.\n");

            return leerCadena(mensaje);

        } else {

            return cadena;

        }

    }

    public static void escribir(String mensaje) {
        System.out.println(mensaje);
    }

}
