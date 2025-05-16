package Sesion1.Reto1;

public class Paciente {
    String nombre;
    int edad;
    String numeroExpediente;
    public Paciente(String nombre, int edad, String numeroExpediente) {
        this.nombre = nombre;
        this.edad = edad;
        this.numeroExpediente = numeroExpediente;
    }

    // Método que muestra la información del producto en consola
    public void mostrarInformacion() {
        System.out.println("Paciente: " + nombre);
        System.out.println(" - Edad: " + edad);
        System.out.println("Número de expediente: " + numeroExpediente);
    }

}
