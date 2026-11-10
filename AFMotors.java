// ============================================================================
// 3. CLASE AFMOTORS: Administra los arreglos y la lógica del sistema
// ============================================================================
public class AFMotors {
    // 2 Arreglos unidimensionales obligatorios con capacidad definida (10 elementos)
    Moto[] inventario = new Moto[10];
    Cliente[] clientes = new Cliente[10];

    int cantMotos = 0;
    int cantClientes = 0;

    // MÉTODO 1 (void): Registrar motocicleta en el inventario
    public void registrarMoto(String placa, String marca, String modelo, double precio) {
        if (cantMotos < inventario.length) {
            inventario[cantMotos] = new Moto(placa, marca, modelo, precio);
            cantMotos++;
            System.out.println("Motocicleta registrada con éxito en AF-MOTORS.");
        } else {
            System.out.println("No hay espacio disponible en el inventario.");
        }
    }

    // MÉTODO 2 (void): Mostrar inventario usando ciclo for
    public void mostrarInventario() {
        System.out.println("\n================ INVENTARIO DE AF-MOTORS ================");
        if (cantMotos == 0) {
            System.out.println("No hay motocicletas registradas.");
            return;
        }
        for (int i = 0; i < cantMotos; i++) {
            System.out.println("Posición [" + i + "] | Placa: " + inventario[i].placa +
                            " | Marca: " + inventario[i].marca +
                            " | Modelo: " + inventario[i].modelo +
                            " | Precio: $" + String.format("%.0f", inventario[i].precio) +
                            " | Estado: " + (inventario[i].disponible ? "Disponible" : "Vendida"));
        }
    }

    // MÉTODO 3 (void): SIMULADOR DE COMPRA (Condicionales Múltiples + Porcentajes)
    public void simularCompra(int posMoto, int cuotas) {
        if (posMoto < 0 || posMoto >= cantMotos) {
            System.out.println("Posición de motocicleta no válida.");
            return;
        }

        Moto m = inventario[posMoto];
        double precio = m.precio;
        double descuento = 0;
        double iva = 19; // IVA estándar del 19%

        // Condicional Múltiple (if / else if / else) para asignar el % de descuento
        if (precio >= 50000000) {
            descuento = 15; // 15% para motocicletas de alta gama (ej. MT-09)
        } else if (precio >= 25000000) {
            descuento = 10; // 10% para gama media-alta (ej. XTZ 250)
        } else if (precio >= 10000000) {
            descuento = 5;  // 5% de descuento
        } else {
            descuento = 0;  // Sin descuento
        }

        double valorDescuento = precio * descuento / 100;
        double subtotal = precio - valorDescuento;
        double valorIva = subtotal * iva / 100;
        double totalAPagar = subtotal + valorIva;

        System.out.println("\n==================================================");
        System.out.println("      SIMULACIÓN DE COMPRA - AF MOTORS            ");
        System.out.println("==================================================");
        System.out.println("Vehículo: " + m.marca + " " + m.modelo + " (Placa: " + m.placa + ")");
        System.out.printf("Precio Lista:       $%.0f%n", precio);
        System.out.println("Descuento Aplicado: " + (int)descuento + "%");
        System.out.printf("Valor Descuento:   -$%.0f%n", valorDescuento);
        System.out.printf("Subtotal:           $%.0f%n", subtotal);
        System.out.printf("IVA (19%%):          +$%.0f%n", valorIva);
        System.out.printf("TOTAL A PAGAR:      $%.0f%n", totalAPagar);
        System.out.println("--------------------------------------------------");

        if (cuotas > 1) {
            double valorCuota = totalAPagar / cuotas;
            System.out.printf("Plan Financiamiento: %d cuotas mensuales de $%.0f%n", cuotas, valorCuota);
        } else {
            System.out.println("Modalidad de Pago: De contado");
        }
        System.out.println("==================================================\n");
    }

    // FUNCIÓN 1 (retorna int): Buscar posición por placa
    public int buscarMotoPorPlaca(String placaBuscada) {
        for (int i = 0; i < cantMotos; i++) {
            if (inventario[i].placa.equalsIgnoreCase(placaBuscada)) {
                return i;
            }
        }
        return -1;
    }

    // FUNCIÓN 2 (retorna int): Contar cuántas motos están disponibles
    public int contarMotosDisponibles() {
        int contador = 0;
        for (int i = 0; i < cantMotos; i++) {
            if (inventario[i].disponible) {
                contador++;
            }
        }
        return contador;
    }
}
