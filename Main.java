import java.util.Scanner;

// ============================================================================
// 4. CLASE PRINCIPAL MAIN: Punto de entrada (do-while + switch + Scanner)
// ============================================================================
public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        AFMotors concesionario = new AFMotors();

        // Datos iniciales de prueba cargados automáticamente
        concesionario.registrarMoto("XYZ987", "Yamaha", "MT-09 V4", 65000000);
        concesionario.registrarMoto("ABC123", "Yamaha", "XTZ 250", 25500000);
        concesionario.registrarMoto("KTM456", "KTM", "Duke 200", 14000000);

        int opcion = 0;

        do {
            System.out.println("\n========== MENÚ PRINCIPAL - AF MOTORS ==========");
            System.out.println("1. Registrar nueva motocicleta");
            System.out.println("2. Ver catálogo de inventario");
            System.out.println("3. Buscar moto por placa");
            System.out.println("4. Ver cantidad de motos disponibles");
            System.out.println("5. SIMULADOR DE COMPRA DE MOTOS");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = teclado.nextInt();
            teclado.nextLine(); // Limpieza del salto de línea del Scanner (Manejo de Buffer)

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese la placa: ");
                    String placa = teclado.nextLine();
                    System.out.print("Ingrese la marca: ");
                    String marca = teclado.nextLine();
                    System.out.print("Ingrese el modelo: ");
                    String modelo = teclado.nextLine();
                    System.out.print("Ingrese el precio: $");
                    double precio = teclado.nextDouble();
                    teclado.nextLine(); // Limpiar buffer
                    
                    concesionario.registrarMoto(placa, marca, modelo, precio);
                    break;

                case 2:
                    concesionario.mostrarInventario();
                    break;

                case 3:
                    System.out.print("Ingrese la placa de la motocicleta a buscar: ");
                    String placaBusqueda = teclado.nextLine();
                    int posEncontrada = concesionario.buscarMotoPorPlaca(placaBusqueda);
                    
                    if (posEncontrada != -1) {
                        System.out.println("¡Motocicleta encontrada!");
                        System.out.println("Se encuentra en la posición [" + posEncontrada + "] del inventario.");
                    } else {
                        System.out.println("La motocicleta con la placa indicada no existe.");
                    }
                    break;

                case 4:
                    System.out.println("Cantidad de motocicletas disponibles para la venta: " 
                                       + concesionario.contarMotosDisponibles());
                    break;

                case 5:
                    System.out.print("Ingrese el número de la posición de la moto a cotizar: ");
                    int posMoto = teclado.nextInt();
                    System.out.print("¿A cuántas cuotas desea financiar? (1 para pago de contado): ");
                    int cuotas = teclado.nextInt();
                    teclado.nextLine(); // Limpiar buffer
                    
                    concesionario.simularCompra(posMoto, cuotas);
                    break;

                case 6:
                    System.out.println("Saliendo de AF-MOTORS. ¡Mucho éxito en la exposición!");
                    break;

                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }

        } while (opcion != 6);

        teclado.close();
    }
}
