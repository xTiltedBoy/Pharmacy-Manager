package estructuraDatos;

import java.io.Serializable;

public class Producto implements Serializable {

    private String codigo;
    private String nombre;
    private String descripcion;
    private double precio;
    private int unidades;

    public Producto(String codigo, String nombre, String descripcion, Double precio, int unidades) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.unidades = unidades;
    }

    public Producto(Producto p) {
        this.codigo = p.codigo;
        this.nombre = p.nombre;
        this.descripcion = p.descripcion;
        this.precio = p.precio;
        this.unidades = p.unidades;
    }

    public boolean anadirUnidades(int unidades) {

        if (unidades<1){

            return false;

        } else {

            this.unidades += unidades;
            return true;

        }

    }

    public boolean quitarUnidades(int unidades) {

        if (unidades<1 || (this.unidades-unidades)<0){

            return false;

        } else {

            this.unidades -= unidades;
            return true;

        }

    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public int getUnidades() {
        return unidades;
    }

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
