package utilidades;

public abstract class ValidarDatos {

    public static boolean validarNif(String nif) {

        String letras = "TRWAGMYFPDXBNJZSQVHLCKE";

        if (nif.length() != 9 || !Character.isLetter(nif.charAt(8))) {

            return false;

        } else {

            char letra = nif.charAt(8);
            nif = nif.substring(0,8);

            int posicion = Integer.parseInt(nif)%23;

            if (letras.charAt(posicion) == letra) {

                return true;

            } else {

                return false;

            }

        }

    }

}
