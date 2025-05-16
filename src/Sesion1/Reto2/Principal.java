package Sesion1.Reto2;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar datos al usuario
        System.out.print("Ingresa el nombre del evento: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingresa el precio de la entrada: ");
        double precio = scanner.nextInt();
        scanner.nextLine(); // Limpiar el salto de línea pendiente

        // Crear el objeto Paciente
        Entrada entrada1 = new Entrada(nombre, precio);
        Entrada entrada2 = new Entrada("Concierto de Rock", 600.0);

        // Mostrar la información
        entrada1.mostrarInformacion();
        entrada2.mostrarInformacion();

        scanner.close();
        Entrada_Record entrada3 = new Entrada_Record("Festival de Jazz", 320.5);
        entrada3.mostrarInformacion();

    }
}
