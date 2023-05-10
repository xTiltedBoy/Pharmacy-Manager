package estructuraDatos;

import java.io.Serializable;

public class ParaFarmacia extends Producto implements Serializable {

    private int dosisUnidades;
    private double descuento;
    private Categoria categoria;

    public ParaFarmacia(String codigo, String nombre, String descripcion, Double precio, int unidades, Categoria categoria, int dosisUnidades, Double descuento) {
        super(codigo, nombre, descripcion, precio, unidades);
        this.categoria = categoria;
        this.dosisUnidades = dosisUnidades;
        this.descuento = descuento;
    }

    public ParaFarmacia(ParaFarmacia p, int dosisUnidades, Double descuento) {
        super(p);
        this.categoria = categoria;
        this.dosisUnidades = dosisUnidades;
        this.descuento = descuento;
    }

    public int getDosisUnidades() {
        return dosisUnidades;
    }

    public void setDosisUnidades(int dosisUnidades) {
        this.dosisUnidades = dosisUnidades;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

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
