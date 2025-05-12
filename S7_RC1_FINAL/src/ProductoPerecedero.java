import java.time.LocalDate;

public class ProductoPerecedero extends Producto {
    private LocalDate fechaVencimiento;

    public ProductoPerecedero(String nombre, String codigo, int cantidad, double costoUnitario,
                              LocalDate fechaReabastecimiento, int tiempoEntrega, LocalDate fechaVencimiento) {
        super(nombre, codigo, cantidad, costoUnitario, fechaReabastecimiento, tiempoEntrega);
        this.fechaVencimiento = fechaVencimiento;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Producto Perecedero - " + nombre + " | Código: " + codigo + " | Cantidad: " + cantidad +
                " | Vence: " + fechaVencimiento);
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public boolean estaPorVencer(LocalDate hoy) {
        return !fechaVencimiento.isBefore(hoy) && fechaVencimiento.isBefore(hoy.plusDays(5));
    }
}
