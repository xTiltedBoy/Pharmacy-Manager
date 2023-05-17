package estructuraDatos;

import java.io.Serializable;

/**
 * Guarda información sobre un cliente de la farmacia.
 *
 * @author Miguel Ruiz Baca
 * @version 1.0
 */

public class Cliente implements Serializable {

    /**
     * Identificador del cliente.
     */
    private String id;

    /**
     * DNI del cliente.
     */
    private String dni;

    /**
     * Nombre del cliente.
     */
    private String nombre;

    /**
     * Dirección del cliente.
     */
    private String direccion;

    /**
     * Teléfono del cliente.
     */
    private String telefono;

    /**
     * Indica si el cliente está dado de baja.
     */
    private boolean baja;

    /**
     * Constructor de la clase Cliente.
     *
     * @param id Identificador del cliente.
     * @param dni DNI del cliente.
     * @param nombre Nombre del cliente.
     * @param direccion Dirección del cliente.
     * @param telefono Teléfono del cliente.
     */
    public Cliente(String id, String dni, String nombre, String direccion, String telefono) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.baja = false;
    }

    /**
     * Constructor Copia de la clase Cliente.
     *
     * @param c Cliente a copiar.
     */
    public Cliente(Cliente c) {
        this.id = c.id;
        this.dni = c.dni;
        this.nombre = c.nombre;
        this.direccion = c.direccion;
        this.telefono = c.telefono;
        this.baja = c.baja;
    }

    /**
     * Devuelve el identificador del cliente.
     *
     * @return Identificador del cliente.
     */
    public String getId() {
        return id;
    }

    /**
     * Establece el identificador del cliente.
     *
     * @param id Identificador del cliente.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Devuelve el nombre del cliente.
     *
     * @return Nombre del cliente.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del cliente.
     *
     * @param nombre Nombre del cliente.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve la dirección del cliente.
     *
     * @return Dirección del cliente.
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Establece la dirección del cliente.
     *
     * @param direccion Dirección del cliente.
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Devuelve el teléfono del cliente.
     *
     * @return Teléfono del cliente.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Establece el teléfono del cliente.
     *
     * @param telefono Teléfono del cliente.
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Devuelve el DNI del cliente.
     *
     * @return DNI del cliente.
     */
    public String getDni() {
        return dni;
    }

    /**
     * Establece el DNI del cliente.
     *
     * @param dni DNI del cliente.
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * Devuelve si el cliente está dado de baja.
     *
     * @return
     * <ul>
     *     <li>True: Si el cliente está dado de baja.</li>
     *     <li>False: Si el cliente no está dado de baja.</li>
     * </ul>
     */
    public boolean isBaja() {
        return baja;
    }

    /**
     * Establece si el cliente está dado de baja.
     *
     * @param baja
     */
    public void setBaja(boolean baja) {
        this.baja = baja;
    }

    /**
     * Devuelve un String con la información del cliente.
     *
     * @return String con la información del cliente.
     */
    @Override
    public String toString() {
        return "Cliente{" +
                "id='" + id + '\'' +
                ", dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", baja=" + baja +
                '}';
    }

}
