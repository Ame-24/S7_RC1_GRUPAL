import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Inventario inventario = new Inventario(1000.0, 500); // Presupuesto: $1000, Espacio: 500 unidades

        int opcion;
        do {
            System.out.println("\nGESTIÓN DE INVENTARIO");
            System.out.println("1. Agregar producto perecedero");
            System.out.println("2. Agregar producto no perecedero");
            System.out.println("3. Ver inventario completo");
            System.out.println("4. Buscar producto por nombre o código");
            System.out.println("5. Mostrar productos próximos a vencer");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> {
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Código: ");
                    String codigo = sc.nextLine();
                    System.out.print("Cantidad: ");
                    int cantidad = sc.nextInt();
                    System.out.print("Costo unitario: ");
                    double costo = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Fecha de reabastecimiento (AAAA-MM-DD): ");
                    LocalDate fechaReabastecimiento = LocalDate.parse(sc.nextLine());
                    System.out.print("Tiempo de entrega (días): ");
                    int tiempoEntrega = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Fecha de vencimiento (AAAA-MM-DD): ");
                    LocalDate fechaVenc = LocalDate.parse(sc.nextLine());

                    Producto perecedero = new ProductoPerecedero(nombre, codigo, cantidad, costo,
                            fechaReabastecimiento, tiempoEntrega, fechaVenc);
                    inventario.agregarProducto(perecedero);
                }
                case 2 -> {
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Código: ");
                    String codigo = sc.nextLine();
                    System.out.print("Cantidad: ");
                    int cantidad = sc.nextInt();
                    System.out.print("Costo unitario: ");
                    double costo = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Fecha de reabastecimiento (AAAA-MM-DD): ");
                    LocalDate fechaReabastecimiento = LocalDate.parse(sc.nextLine());
                    System.out.print("Tiempo de entrega (días): ");
                    int tiempoEntrega = sc.nextInt();
                    sc.nextLine();

                    Producto noPerecedero = new ProductoNoPerecedero(nombre, codigo, cantidad, costo,
                            fechaReabastecimiento, tiempoEntrega);
                    inventario.agregarProducto(noPerecedero);
                }
                case 3 -> inventario.mostrarInventario();
                case 4 -> {
                    System.out.print("Buscar por nombre o código: ");
                    String texto = sc.nextLine();
                    inventario.buscarProducto(texto);
                }
                case 5 -> inventario.mostrarProductosProximosAVencer();
                case 0 -> System.out.println("Programa finalizado.");
                default -> System.out.println("Opción inválida.");
            }

        } while (opcion != 0);
    }
}
