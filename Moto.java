// ============================================================================
// 1. CLASE MOTO: Plantilla para representar cada motocicleta (Plano POO)
// ============================================================================
public class Moto {
    String placa;
    String marca;
    String modelo;
    double precio;
    boolean disponible;

    public Moto(String placa, String marca, String modelo, double precio) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
        this.disponible = true; // Por defecto todas nacen disponibles
    }
}
