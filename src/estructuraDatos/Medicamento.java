package estructuraDatos;

public class Medicamento extends Producto{

    private String comoTomar;
    private String efectosAdverso;
    private TipoMedicamento tipoMedicamento;

    public Medicamento(String codigo, String nombre, String descripcion, Double precio, int unidades, TipoMedicamento tipoMedicamento, String comoTomar, String efectosAdverso) {
        super(codigo, nombre, descripcion, precio, unidades);
        this.tipoMedicamento = tipoMedicamento;
        this.comoTomar = comoTomar;
        this.efectosAdverso = efectosAdverso;
    }

    public Medicamento(Medicamento m) {
        super(m);
        this.tipoMedicamento = m.tipoMedicamento;
        this.comoTomar = m.comoTomar;
        this.efectosAdverso = m.efectosAdverso;
    }

    public TipoMedicamento getTipoMedicamento() {
        return tipoMedicamento;
    }

    public void setTipoMedicamento(TipoMedicamento tipoMedicamento) {
        this.tipoMedicamento = tipoMedicamento;
    }

    public String getComoTomar() {
        return comoTomar;
    }

    public void setComoTomar(String comoTomar) {
        this.comoTomar = comoTomar;
    }

    public String getEfectosAdverso() {
        return efectosAdverso;
    }

    public void setEfectosAdverso(String efectosAdverso) {
        this.efectosAdverso = efectosAdverso;
    }

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
