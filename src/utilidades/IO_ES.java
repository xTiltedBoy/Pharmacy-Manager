package utilidades;

import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class IO_ES {

    private static final Scanner SCANNER_INT = new Scanner(System.in);

    private static final Scanner SCANNER_DEC = new Scanner(System.in);
    private static final Scanner SCANNER_CHAR = new Scanner(System.in);

    public static int leerEntero() {

        try {

            return SCANNER_INT.nextInt();

        } catch (InputMismatchException e) {

            IO_ES.escribir("");
            IO_ES.escribir("ERROR: Debe introducir un número entero.\n");

            SCANNER_INT.next();

            return leerEntero();

        }

    }

    public static int leerEntero(String mensaje) {

        try {

            escribir(mensaje);

            return SCANNER_INT.nextInt();

        } catch (InputMismatchException e) {

            IO_ES.escribir("");
            IO_ES.escribir("ERROR: Debe introducir un número entero.\n");

            SCANNER_INT.next();

            return leerEntero(mensaje);

        }

    }

    public static int leerEntero(String mensaje, int min, int max) {

        try {

            escribir(mensaje);

            int entero = SCANNER_INT.nextInt();

            return (entero >= min && entero <= max) ? entero : leerEntero("El número introducido debe estar entre " + min + "-" + max + ": ", min, max);

        } catch (InputMismatchException e) {

            IO_ES.escribir("");
            IO_ES.escribir("ERROR: Debe introducir un número entero.\n");

            SCANNER_INT.next();

            return leerEntero(mensaje, min, max);

        }

    }

    public static double leerDecimal() {

        try {

            return SCANNER_DEC.nextDouble();

        } catch (InputMismatchException e) {

            IO_ES.escribir("");
            IO_ES.escribir("ERROR: Debe introducir un número decimal.\n");

            SCANNER_DEC.next();

            return leerDecimal();

        }

    }

    public static double leerDecimal(String mensaje) {

        try {

            escribir(mensaje);

            return SCANNER_DEC.nextDouble();

        } catch (InputMismatchException e) {

            IO_ES.escribir("");
            IO_ES.escribir("ERROR: Debe introducir un número decimal.\n");

            SCANNER_DEC.next();

            return leerDecimal(mensaje);

        }

    }

    public static double leerDecimal(String mensaje, double min, double max) {

        try {

            escribir(mensaje);

            double decimal = SCANNER_DEC.nextDouble();

            return (decimal >= min && decimal <= max) ? decimal : leerDecimal("El número introducido debe estar entre " + min + "-" + max + ": ", min, max);

        } catch (InputMismatchException e) {

            IO_ES.escribir("");
            IO_ES.escribir("ERROR: Debe introducir un número decimal.\n");

            SCANNER_DEC.next();

            return leerDecimal(mensaje, min, max);

        }

    }

    public static char leerCaracter() {

        try {

            char caracter = SCANNER_CHAR.nextLine().charAt(0);

            return (String.valueOf(caracter).equals("")) ? leerCaracter() : caracter;

        } catch (InputMismatchException e) {

            IO_ES.escribir("");
            IO_ES.escribir("ERROR: Debe introducir un caracter.\n");

            SCANNER_CHAR.next();

            return leerCaracter();

        }

    }

    public static char leerCaracter(String mensaje) {

        try {

            escribir(mensaje);

            char caracter = SCANNER_CHAR.nextLine().charAt(0);

            if (String.valueOf(caracter).equals("")) {

                IO_ES.escribir("ERROR: No puede dejar el campo vacío.\n");

                return leerCaracter(mensaje);

            } else {

                return caracter;

            }

        } catch (InputMismatchException e) {

            IO_ES.escribir("");
            IO_ES.escribir("ERROR: Debe introducir un caracter.\n");

            SCANNER_CHAR.next();

            return leerCaracter(mensaje);

        }

    }

    public static String leerCadena() {

        try {

            String cadena = SCANNER_CHAR.nextLine();

            return (cadena.equals("")) ? leerCadena() : cadena;

        } catch (InputMismatchException e) {

            IO_ES.escribir("");
            IO_ES.escribir("ERROR: Debe introducir una cadena de texto.\n");

            SCANNER_CHAR.next();

            return leerCadena();

        }

    }

    public static String leerCadena(String mensaje) {

        try {

            escribir(mensaje);

            String cadena = SCANNER_CHAR.nextLine();

            if (cadena.equals("")) {

                IO_ES.escribir("ERROR: No puede dejar el campo vacío.\n");

                return leerCadena(mensaje);

            } else {

                return cadena;

            }

        } catch (InputMismatchException e) {

            IO_ES.escribir("");
            IO_ES.escribir("ERROR: Debe introducir una cadena de texto.\n");

            SCANNER_CHAR.next();

            return leerCadena(mensaje);

        }

    }

    public static void escribir(String mensaje) {
        System.out.println(mensaje);
    }

}
