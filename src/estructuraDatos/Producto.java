package estructuraDatos;

import java.io.Serializable;

/**
 * Guarda los datos de un producto.
 *
 * @author Miguel Ruiz Baca
 * @version 1.0
 */

public class Producto implements Serializable {

    /**
     * Código del producto.
     */
    private String codigo;

    /**
     * Nombre del producto.
     */
    private String nombre;

    /**
     * Descripción del producto.
     */
    private String descripcion;

    /**
     * Precio del producto.
     */
    private double precio;

    /**
     * Unidades del producto.
     */
    private int unidades;

    /**
     * Constructor de la clase Producto.
     *
     * @param codigo Código del producto.
     * @param nombre Nombre del producto.
     * @param descripcion Descripción del producto.
     * @param precio Precio del producto.
     * @param unidades Unidades del producto.
     */
    public Producto(String codigo, String nombre, String descripcion, Double precio, int unidades) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.unidades = unidades;
    }

    /**
     * Constructor Copia de la clase Producto.
     *
     * @param p Producto a copiar.
     */
    public Producto(Producto p) {
        this.codigo = p.codigo;
        this.nombre = p.nombre;
        this.descripcion = p.descripcion;
        this.precio = p.precio;
        this.unidades = p.unidades;
    }

    /**
     * Añade unidades al producto.
     *
     * @return
     * <ul>
     *     <li>True: Si ha sido posible añadir las unidades.</li>
     *     <li>False: Si no ha sido posible añadis las unidades.</li>
     * </ul>
     */
    public boolean anadirUnidades(int unidades) {

        // Si el numero de unidades es negativo devolvera false, en caso contrario se sumaran las unidades.
        if (unidades<1){

            return false;

        } else {

            this.unidades += unidades;
            return true;

        }

    }

    /**
     * Quita unidades al producto.
     *
     * @return
     * <ul>
     *     <li>True: Si ha sido posible quitar las unidades.</li>
     *     <li>False: Si no ha sido posible quitar las unidades.</li>
     * </ul>
     */
    public boolean quitarUnidades(int unidades) {

        // Si el numero de unidades es negativo o si el numero de unidades a quitar es mayor que el numero de unidades que hay devolvera false, en caso contrario se restaran las unidades.
        if (unidades<1 || (this.unidades-unidades)<0){

            return false;

        } else {

            this.unidades -= unidades;
            return true;

        }

    }

    /**
     * Devuelve el codigo del producto.
     *
     * @return Código del producto.
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Establece el codigo del producto.
     *
     * @param codigo Código del producto.
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * Devuelve el nombre del producto.
     *
     * @return Nombre del producto.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del producto.
     *
     * @param nombre Nombre del producto.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve la descripción del producto.
     *
     * @return Descripción del producto.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Establece la descripción del producto.
     *
     * @param descripcion Descripción del producto.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Devuelve el precio del producto.
     *
     * @return Precio del producto.
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Establece el precio del producto.
     *
     * @param precio Precio del producto.
     */
    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    /**
     * Establece las unidades del producto.
     *
     * @param unidades Unidades del producto.
     */
    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    /**
     * Devuelve las unidades del producto.
     *
     * @return Unidades del producto.
     */
    public int getUnidades() {
        return unidades;
    }

    /**
     * Devuelve un String con la información del producto.
     *
     * @return String con la información del producto.
     */
    @Override
    public String toString() {
        return "Producto{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                ", unidades=" + unidades +
                '}';
    }

}
