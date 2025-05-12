import java.time.LocalDate;

public abstract class Producto {
    protected String nombre;
    protected String codigo;
    protected int cantidad;
    protected double costoUnitario;
    protected LocalDate fechaReabastecimiento;
    protected int tiempoEntrega;

    public Producto(String nombre, String codigo, int cantidad, double costoUnitario,
                    LocalDate fechaReabastecimiento, int tiempoEntrega) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.cantidad = cantidad;
        this.costoUnitario = costoUnitario;
        this.fechaReabastecimiento = fechaReabastecimiento;
        this.tiempoEntrega = tiempoEntrega;
    }

    public double calcularCostoTotal() {
        return cantidad * costoUnitario;
    }

    public abstract void mostrarInfo();

    public String getNombre() {
        return nombre;
    }

    public String getCodigo() {
        return codigo;
    }
}
