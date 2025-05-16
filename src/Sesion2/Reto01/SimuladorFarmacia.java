package Sesion2.Reto01;

import java.util.Scanner;

public class SimuladorFarmacia {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar datos al usuario
        System.out.print("Ingresa el nombre del medicamento: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingresa precio unitario: ");
        double precio = scanner.nextInt();
        scanner.nextLine(); // Limpiar el salto de línea pendiente

        System.out.print("Ingresa cantidad de piezas: ");
        int cantidad = scanner.nextInt();

        var totalsindescuento = precio*cantidad;
        boolean aplicaDescuento = totalsindescuento > 500;
        double descuento = aplicaDescuento ? totalsindescuento * 0.15 : 0;
        double totalFinal = totalsindescuento - descuento;

        System.out.println("Medicamento: " + nombre);
        System.out.println("Cantidad: " + cantidad);
        System.out.println("Precio unitario: $" + precio);
        System.out.println("Total sin descuento: $" + totalsindescuento);
        System.out.println("¿Aplica descuento?: " + aplicaDescuento);
        System.out.println("Descuento: $" + descuento);
        System.out.println("Total a pagar: $" + totalFinal);

        scanner.close();
    }
}
