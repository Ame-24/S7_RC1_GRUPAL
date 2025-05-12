import java.time.LocalDate;

public class ProductoNoPerecedero extends Producto {
    public ProductoNoPerecedero(String nombre, String codigo, int cantidad, double costoUnitario,
                                LocalDate fechaReabastecimiento, int tiempoEntrega) {
        super(nombre, codigo, cantidad, costoUnitario, fechaReabastecimiento, tiempoEntrega);
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Producto No Perecedero - " + nombre + " | Código: " + codigo + " | Cantidad: " + cantidad);
    }
}
