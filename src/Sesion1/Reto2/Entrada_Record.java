package Sesion1.Reto2;


public record Entrada_Record(String nombre, double precio) {
    public void mostrarInformacion() {
        System.out.println("Evento: " + nombre + " | Precio: $" + precio);
    }
}

