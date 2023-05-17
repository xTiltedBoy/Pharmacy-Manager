package utilidades;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Contiene métodos para la entrada y salida de datos por consola.
 */

public abstract class IO_ES {

    /**
     * Scanner para leer enteros.
     */
    private static final Scanner SCANNER_INT = new Scanner(System.in);

    /**
     * Scanner para leer decimales.
     */
    private static final Scanner SCANNER_DEC = new Scanner(System.in);

    /**
     * Scanner para leer cadenas.
     */
    private static final Scanner SCANNER_CHAR = new Scanner(System.in);

    /**
     * Devuelve un entero introducido por teclado.
     *
     * @return Entero introducido por teclado.
     */
    public static int leerEntero() {

        // Se usa try-catch para evitar que el programa se cierre si se introduce un valor no válido.
        try {

            return SCANNER_INT.nextInt();

        } catch (InputMismatchException e) {

            IO_ES.escribir("");
            IO_ES.escribir("ERROR: Debe introducir un número entero.\n");

            // Se vacía el buffer para evitar que se repita el error.
            SCANNER_INT.next();

            return leerEntero();

        }

    }

    /**
     * Muestra un mensaje y devuelve un entero introducido por teclado.
     *
     * @param mensaje Mensaje a mostrar.
     * @return Entero introducido por teclado.
     */
    public static int leerEntero(String mensaje) {

        // Se usa try-catch para evitar que el programa se cierre si se introduce un valor no válido.
        try {

            escribir(mensaje);

            return SCANNER_INT.nextInt();

        } catch (InputMismatchException e) {

            IO_ES.escribir("");
            IO_ES.escribir("ERROR: Debe introducir un número entero.\n");

            // Se vacía el buffer para evitar que se repita el error.
            SCANNER_INT.next();

            return leerEntero(mensaje);

        }

    }

    /**
     * Muestra un mensaje y devuelve un entero introducido por teclado.
     *
     * @param mensaje Mensaje a mostrar.
     * @param min Valor mínimo que puede tener el entero.
     * @param max Valor máximo que puede tener el entero.
     * @return Entero introducido por teclado.
     */
    public static int leerEntero(String mensaje, int min, int max) {

        // Se usa try-catch para evitar que el programa se cierre si se introduce un valor no válido.
        try {

            escribir(mensaje);

            int entero = SCANNER_INT.nextInt();

            // Si el entero está entre el mínimo y el máximo se devuelve, si no se vuelve a pedir con un mensaje de error.
            return (entero >= min && entero <= max) ? entero : leerEntero("ERROR: El número introducido debe estar entre " + min + "-" + max + ": ", min, max);

        } catch (InputMismatchException e) {

            IO_ES.escribir("");
            IO_ES.escribir("ERROR: Debe introducir un número entero.\n");

            // Se vacía el buffer para evitar que se repita el error.
            SCANNER_INT.next();

            return leerEntero(mensaje, min, max);

        }

    }

    /**
     * Devuelve un decimal introducido por teclado.
     *
     * @return Decimal introducido por teclado.
     */
    public static double leerDecimal() {

        // Se usa try-catch para evitar que el programa se cierre si se introduce un valor no válido.
        try {

            return SCANNER_DEC.nextDouble();

        } catch (InputMismatchException e) {

            IO_ES.escribir("");
            IO_ES.escribir("ERROR: Debe introducir un número decimal.\n");

            // Se vacía el buffer para evitar que se repita el error.
            SCANNER_DEC.next();

            return leerDecimal();

        }

    }

    /**
     * Muestra un mensaje y devuelve un decimal introducido por teclado.
     *
     * @param mensaje Mensaje a mostrar.
     * @return Decimal introducido por teclado.
     */
    public static double leerDecimal(String mensaje) {

        // Se usa try-catch para evitar que el programa se cierre si se introduce un valor no válido.
        try {

            escribir(mensaje);

            return SCANNER_DEC.nextDouble();

        } catch (InputMismatchException e) {

            IO_ES.escribir("");
            IO_ES.escribir("ERROR: Debe introducir un número decimal.\n");

            // Se vacía el buffer para evitar que se repita el error.
            SCANNER_DEC.next();

            return leerDecimal(mensaje);

        }

    }

    /**
     * Muestra un mensaje y devuelve un decimal introducido por teclado.
     *
     * @param mensaje Mensaje a mostrar.
     * @param min Valor mínimo que puede tener el decimal.
     * @param max Valor máximo que puede tener el decimal.
     * @return Decimal introducido por teclado.
     */
    public static double leerDecimal(String mensaje, double min, double max) {

        // Se usa try-catch para evitar que el programa se cierre si se introduce un valor no válido.
        try {

            escribir(mensaje);

            double decimal = SCANNER_DEC.nextDouble();

            // Si el decimal está entre el mínimo y el máximo se devuelve, si no se vuelve a pedir con un mensaje de error.
            return (decimal >= min && decimal <= max) ? decimal : leerDecimal("ERROR: El número introducido debe estar entre " + min + "-" + max + ": ", min, max);

        } catch (InputMismatchException e) {

            IO_ES.escribir("");
            IO_ES.escribir("ERROR: Debe introducir un número decimal.\n");

            // Se vacía el buffer para evitar que se repita el error.
            SCANNER_DEC.next();

            return leerDecimal(mensaje, min, max);

        }

    }

    /**
     * Devuelve un caracter introducido por teclado.
     *
     * @return Caracter introducido por teclado.
     */
    public static char leerCaracter() {

        try {

            char caracter = SCANNER_CHAR.nextLine().charAt(0);

            // Si el caracter está vacío se vuelve a pedir.
            return (String.valueOf(caracter).equals("")) ? leerCaracter() : caracter;

        } catch (InputMismatchException e) {

            IO_ES.escribir("");
            IO_ES.escribir("ERROR: Debe introducir un caracter.\n");

            SCANNER_CHAR.next();

            return leerCaracter();

        }

    }

    /**
     * Muestra un mensaje y devuelve un caracter introducido por teclado.
     *
     * @param mensaje Mensaje a mostrar.
     * @return Caracter introducido por teclado.
     */
    public static char leerCaracter(String mensaje) {

        // Se usa try-catch para evitar que el programa se cierre si se introduce un valor no válido.
        try {

            escribir(mensaje);

            char caracter = SCANNER_CHAR.nextLine().charAt(0);

            // Si el caracter está vacío se vuelve a pedir con un mensaje de error.
            if (String.valueOf(caracter).equals("")) {

                IO_ES.escribir("ERROR: No puede dejar el campo vacío.\n");

                return leerCaracter(mensaje);

            } else {

                return caracter;

            }

        } catch (InputMismatchException e) {

            IO_ES.escribir("");
            IO_ES.escribir("ERROR: Debe introducir un caracter.\n");

            // Se vacía el buffer para evitar que se repita el error.
            SCANNER_CHAR.next();

            return leerCaracter(mensaje);

        }

    }

    /**
     * Devuelve una cadena introducida por teclado.
     *
     * @return Cadena introducida por teclado.
     */
    public static String leerCadena() {

        // Se usa try-catch para evitar que el programa se cierre si se introduce un valor no válido.
        try {

            String cadena = SCANNER_CHAR.nextLine();

            // Si la cadena está vacía se vuelve a pedir.
            return (cadena.equals("")) ? leerCadena() : cadena;

        } catch (InputMismatchException e) {

            IO_ES.escribir("");
            IO_ES.escribir("ERROR: Debe introducir una cadena de texto.\n");

            // Se vacía el buffer para evitar que se repita el error.
            SCANNER_CHAR.next();

            return leerCadena();

        }

    }

    /**
     * Muestra un mensaje y devuelve una cadena introducida por teclado.
     *
     * @param mensaje Mensaje a mostrar.
     * @return Cadena introducida por teclado.
     */
    public static String leerCadena(String mensaje) {

        // Se usa try-catch para evitar que el programa se cierre si se introduce un valor no válido.
        try {

            escribir(mensaje);

            String cadena = SCANNER_CHAR.nextLine();

            // Si la cadena está vacía se vuelve a pedir con un mensaje de error.
            if (cadena.equals("")) {

                IO_ES.escribir("ERROR: No puede dejar el campo vacío.\n");

                return leerCadena(mensaje);

            } else {

                return cadena;

            }

        } catch (InputMismatchException e) {

            IO_ES.escribir("");
            IO_ES.escribir("ERROR: Debe introducir una cadena de texto.\n");

            // Se vacía el buffer para evitar que se repita el error.
            SCANNER_CHAR.next();

            return leerCadena(mensaje);

        }

    }

    /**
     * Escribe un mensaje por consola.
     *
     * @param mensaje Mensaje a escribir.
     */
    public static void escribir(String mensaje) {
        System.out.println(mensaje);
    }

}
