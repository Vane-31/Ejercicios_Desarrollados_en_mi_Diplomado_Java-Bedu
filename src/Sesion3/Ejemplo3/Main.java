package Sesion3.Ejemplo3;

public class Main {
    public static void main(String[] args) {
        Usuario u = new Usuario("Mario", 500.0);

        System.out.println("👤 Usuario: " + u.getNombre());
        System.out.println("💰 Saldo inicial: $" + u.getSaldo());

        u.depositar(250.0);
        System.out.println("💰 Saldo después del depósito: $" + u.getSaldo());
    }
}

