package estructuraDatos;

import java.io.Serializable;

/**
 * Guarda los datos de un producto de tipo Medicamento.
 *
 * @author Miguel Ruiz Baca
 * @version 1.0
 * @see Producto
 * @see TipoMedicamento
 */

public class Medicamento extends Producto implements Serializable {

    /**
     * Instrucciones de como tomar el medicamento.
     */
    private String comoTomar;

    /**
     * Posibles efectos adversos del medicamento.
     */
    private String efectosAdverso;

    /**
     * Tipo del medicamento.
     */
    private TipoMedicamento tipoMedicamento;

    /**
     * Constructor de la clase Medicamento.
     *
     * @param codigo Código del medicamento.
     * @param nombre Nombre del medicamento.
     * @param descripcion Descripción del medicamento.
     * @param precio Precio del medicamento.
     * @param unidades Unidades del medicamento.
     * @param tipoMedicamento Tipo del medicamento.
     * @param comoTomar Instrucciones de como tomar el medicamento.
     * @param efectosAdverso Posibles efectos adversos del medicamento.
     */
    public Medicamento(String codigo, String nombre, String descripcion, Double precio, int unidades, TipoMedicamento tipoMedicamento, String comoTomar, String efectosAdverso) {
        super(codigo, nombre, descripcion, precio, unidades);
        this.tipoMedicamento = tipoMedicamento;
        this.comoTomar = comoTomar;
        this.efectosAdverso = efectosAdverso;
    }

    /**
     * Constructor Copia de la clase Medicamento.
     *
     * @param m Medicamento a copiar.
     */
    public Medicamento(Medicamento m) {
        super(m);
        this.tipoMedicamento = m.tipoMedicamento;
        this.comoTomar = m.comoTomar;
        this.efectosAdverso = m.efectosAdverso;
    }

    /**
     * Devuelve el tipo del medicamento.
     *
     * @return Tipo del medicamento.
     */
    public TipoMedicamento getTipoMedicamento() {
        return tipoMedicamento;
    }

    /**
     * Establece el tipo del medicamento.
     *
     * @param tipoMedicamento Tipo del medicamento.
     */
    public void setTipoMedicamento(TipoMedicamento tipoMedicamento) {
        this.tipoMedicamento = tipoMedicamento;
    }

    /**
     * Devuelve las instrucciones de como tomar el medicamento.
     *
     * @return Instrucciones de como tomar el medicamento.
     */
    public String getComoTomar() {
        return comoTomar;
    }

    /**
     * Establece las instrucciones de como tomar el medicamento.
     *
     * @param comoTomar Instrucciones de como tomar el medicamento.
     */
    public void setComoTomar(String comoTomar) {
        this.comoTomar = comoTomar;
    }

    /**
     * Devuelve los posibles efectos adversos del medicamento.
     *
     * @return Posibles efectos adversos del medicamento.
     */
    public String getEfectosAdverso() {
        return efectosAdverso;
    }

    /**
     * Establece los posibles efectos adversos del medicamento.
     *
     * @param efectosAdverso Posibles efectos adversos del medicamento.
     */
    public void setEfectosAdverso(String efectosAdverso) {
        this.efectosAdverso = efectosAdverso;
    }

    /**
     * Devuelve un String con la información del medicamento.
     *
     * @return String con la información del medicamento.
     */
    @Override
    public String toString() {
        return "Medicamento{" +
                "codigo='" + this.getCodigo() + '\'' +
                ", nombre='" + this.getNombre() + '\'' +
                ", descripcion='" + this.getDescripcion() + '\'' +
                ", precio=" + this.getPrecio() +
                ", unidades=" + this.getUnidades() +
                ", comoTomar='" + comoTomar + '\'' +
                ", efectosAdverso='" + efectosAdverso + '\'' +
                ", tipoMedicamento=" + tipoMedicamento +
                '}';
    }
}
