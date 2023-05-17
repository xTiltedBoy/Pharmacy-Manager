package estructuraDatos;

import java.io.Serializable;

/**
 * Tipos de medicamento posibles para los productos de tipo Medicamento.
 *
 * @author Miguel Ruiz Baca
 * @version 1.0
 * @see Medicamento
 */

public enum TipoMedicamento implements Serializable {
    ANALGESICOS,
    LAXANTES,
    ANTIINFECCIOSOS,
    ANTIDEPRESIVOS,
    ANTITUSIVOS,
    MUCOLITICOS,
    ANTIACIDOS,
    ANTIULCEROSOS,
    ANTIALERGICOS,
    ANTIFIARREICOS
}
