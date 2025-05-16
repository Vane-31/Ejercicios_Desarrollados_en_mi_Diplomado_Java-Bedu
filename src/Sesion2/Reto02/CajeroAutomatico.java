package Sesion2.Reto02;

import java.util.Scanner;

public class CajeroAutomatico {
    public static void main(String[] args) {
        var saldo = 1000.0; // Saldo inicial
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Bienvenido al cajero automático ---");
            System.out.println("1. Consultar saldo");
            System.out.println("2. Depositar dinero");
            System.out.println("3. Retirar dinero");
            System.out.println("4. Salir");
            System.out.print("Elige una opción: ");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Tu saldo actual es: $" + saldo);
                    break;

                case 2:
                    System.out.print("Ingresa el monto a depositar: ");
                    double deposito = scanner.nextDouble();
                    if (deposito <= 0) {
                        System.out.println("El monto debe ser mayor a cero.");
                        continue; // vuelve a mostrar el menú
                    }
                    saldo += deposito;
                    System.out.println("Depósito exitoso. Nuevo saldo: $" + saldo);
                    break;

                case 3:
                    System.out.print("¿Cuál sería el monto a retirar?: ");
                    double retiro = scanner.nextDouble();
                    if (retiro <= 0) {
                        System.out.println("El monto debe ser mayor a cero.");
                        continue;
                    }
                    if (retiro > saldo) {
                        System.out.println("Fondos insuficientes. Tu saldo es: $" + saldo);
                        continue;
                    }
                    saldo -= retiro;
                    System.out.println("Retiro exitoso. Nuevo saldo: $" + saldo);
                    break;

                case 4:
                    System.out.println("Gracias por usar el cajero automático. ¡Hasta luego!");
                    break;

                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }

        } while (opcion != 4);

        scanner.close();
    }
}
