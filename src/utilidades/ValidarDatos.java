package utilidades;

/**
 * Contiene métodos para validar datos.
 *
 * @author Miguel Ruiz Baca
 * @version 1.0
 */

public abstract class ValidarDatos {

    /**
     * Valida un NIF.
     *
     * @param nif NIF a validar.
     * @return
     * <ul>
     *     <li>True: Si el nif es valido.</li>
     *     <li>False: Si el nif no es valido.</li>
     * </ul>
     */
    public static boolean validarNif(String nif) {

        String letras = "TRWAGMYFPDXBNJZSQVHLCKE";

        // Comprobamos que el nif tenga 9 caracteres y que el último sea una letra.
        if (nif.length() != 9 || !Character.isLetter(nif.charAt(8))) {

            return false;

        } else {

            char letra = nif.charAt(8);
            nif = nif.substring(0,8);

            int posicion = Integer.parseInt(nif)%23;

            // Si la letra obtenida a partir del numero es igual a la letra del nif devolvera true, en caso contrario devolvera false.
            return letras.charAt(posicion) == letra;

        }

    }

}
