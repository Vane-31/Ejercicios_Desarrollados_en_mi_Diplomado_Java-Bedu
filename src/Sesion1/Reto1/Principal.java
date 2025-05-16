package Sesion1.Reto1;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar datos al usuario
        System.out.print("Ingresa el nombre del paciente: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingresa la edad del paciente: ");
        int edad = scanner.nextInt();
        scanner.nextLine(); // Limpiar el salto de línea pendiente

        System.out.print("Ingresa el número de expediente: ");
        String numeroExpediente = scanner.nextLine();

        // Crear el objeto Paciente
        Paciente paciente = new Paciente(nombre, edad, numeroExpediente);

        // Mostrar la información
        paciente.mostrarInformacion();

        scanner.close();
}}
