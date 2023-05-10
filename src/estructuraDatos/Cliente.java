package estructuraDatos;

import java.io.Serializable;

public class Cliente implements Serializable {

    private String id;
    private String dni;
    private String nombre;
    private String direccion;
    private String telefono;
    private boolean baja;

    public Cliente(String id, String dni, String nombre, String direccion, String telefono) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.baja = false;
    }

    public Cliente(Cliente c) {
        this.id = c.id;
        this.dni = c.dni;
        this.nombre = c.nombre;
        this.direccion = c.direccion;
        this.telefono = c.telefono;
        this.baja = c.baja;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public boolean isBaja() {
        return baja;
    }

    public void setBaja(boolean baja) {
        this.baja = baja;
    }

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
