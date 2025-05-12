import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Inventario {
    private List<Producto> productos;
    private double presupuestoMaximo;
    private int capacidadMaxima;

    public Inventario(double presupuestoMaximo, int capacidadMaxima) {
        this.productos = new ArrayList<>();
        this.presupuestoMaximo = presupuestoMaximo;
        this.capacidadMaxima = capacidadMaxima;
    }

    public void agregarProducto(Producto producto) {
        double costoTotal = producto.calcularCostoTotal();
        int totalCantidad = getCantidadTotalActual() + producto.cantidad;
        double totalCosto = getCostoTotalActual() + costoTotal;

        if (totalCantidad > capacidadMaxima) {
            System.out.println("Error: No hay suficiente espacio en el inventario.");
            return;
        }

        if (totalCosto > presupuestoMaximo) {
            System.out.println("Error: No hay suficiente presupuesto para agregar este producto.");
            return;
        }

        productos.add(producto);
        System.out.println("Producto agregado correctamente.");
    }

    public void mostrarInventario() {
        System.out.println("\n=== INVENTARIO COMPLETO ===");
        for (Producto p : productos) {
            p.mostrarInfo();
            System.out.printf("   Precio Unitario: $%.2f | Precio Total: $%.2f\n",
                    p.costoUnitario, p.calcularCostoTotal());
        }
    }


    public void buscarProducto(String texto) {
        System.out.println("\n=== RESULTADOS DE BÚSQUEDA ===");
        boolean encontrado = false;
        for (Producto p : productos) {
            if (p.getNombre().toLowerCase().contains(texto.toLowerCase())
                    || p.getCodigo().equalsIgnoreCase(texto)) {
                p.mostrarInfo();
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontraron productos que coincidan.");
        }
    }

    public void mostrarProductosProximosAVencer() {
        LocalDate hoy = LocalDate.now();
        System.out.println("\n=== PRODUCTOS PRÓXIMOS A VENCER (5 días) ===");
        boolean hayAlertas = false;
        for (Producto p : productos) {
            if (p instanceof ProductoPerecedero perecedero) {
                if (perecedero.estaPorVencer(hoy)) {
                    perecedero.mostrarInfo();
                    hayAlertas = true;
                }
            }
        }
        if (!hayAlertas) {
            System.out.println("No hay productos próximos a vencer.");
        }
    }

    private int getCantidadTotalActual() {
        return productos.stream().mapToInt(p -> p.cantidad).sum();
    }

    private double getCostoTotalActual() {
        return productos.stream().mapToDouble(Producto::calcularCostoTotal).sum();
    }
}
