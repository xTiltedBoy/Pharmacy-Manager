package estructuraDatos;

import java.io.Serializable;

/**
 * Guarda los datos de un producto de tipo ParaFarmacia de la farmacia.
 *
 * @author Miguel Ruiz Baca
 * @version 1.0
 * @see Producto
 * @see Categoria
 */

public class ParaFarmacia extends Producto implements Serializable {

    /**
     * Dosis por cada unidad del producto.
     */
    private int dosisUnidades;

    /**
     * Descuento del producto.
     */
    private double descuento;

    /**
     * Categoría del producto.
     */
    private Categoria categoria;

    /**
     * Constructor de la clase ParaFarmacia.
     *
     * @param codigo Código del producto.
     * @param nombre Nombre del producto.
     * @param descripcion Descripción del producto.
     * @param precio Precio del producto.
     * @param unidades Unidades del producto.
     * @param categoria Categoría del producto.
     * @param dosisUnidades Dosis por cada unidad del producto.
     * @param descuento Descuento del producto.
     */

    public ParaFarmacia(String codigo, String nombre, String descripcion, Double precio, int unidades, Categoria categoria, int dosisUnidades, Double descuento) {
        super(codigo, nombre, descripcion, precio, unidades);
        this.categoria = categoria;
        this.dosisUnidades = dosisUnidades;
        this.descuento = descuento;
    }

    /**
     * Constructor Copia de la clase ParaFarmacia.
     *
     * @param p Producto a copiar.
     */
    public ParaFarmacia(ParaFarmacia p) {
        super(p);
        this.categoria = p.categoria;
        this.dosisUnidades = p.dosisUnidades;
        this.descuento = p.descuento;
    }

    /**
     * Devuelve la dosis por cada unidad del producto.
     */
    public int getDosisUnidades() {
        return dosisUnidades;
    }

    /**
     * Establece la dosis por cada unidad del producto.
     */
    public void setDosisUnidades(int dosisUnidades) {
        this.dosisUnidades = dosisUnidades;
    }

    /**
     * Devuelve el descuento del producto.
     */
    public double getDescuento() {
        return descuento;
    }

    /**
     * Establece el descuento del producto.
     */
    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    /**
     * Devuelve la categoría del producto.
     */
    public Categoria getCategoria() {
        return categoria;
    }

    /**
     * Establece la categoría del producto.
     */
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    /**
     * Devuelve el precio del producto.
     */
    @Override
    public String toString() {
        return "ParaFarmacia{" +
                "codigo='" + this.getCodigo() + '\'' +
                ", nombre='" + this.getNombre() + '\'' +
                ", descripcion='" + this.getDescripcion() + '\'' +
                ", precio=" + this.getPrecio() +
                ", unidades=" + this.getUnidades() +
                ", dosisUnidades=" + dosisUnidades +
                ", descuento=" + descuento +
                ", categoria=" + categoria +
                '}';
    }
}
