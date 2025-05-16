package Sesion1.Reto2;

public class Entrada {
    String nombre;
    double precio;
    public Entrada(String nombre, double precio ) {
        this.nombre = nombre;
        this.precio = precio;
    }
    // Método que muestra la información del producto en consola
    public void mostrarInformacion() {
        System.out.println("Evento: " + nombre + "| Precio: $"+ precio);
    }
}
