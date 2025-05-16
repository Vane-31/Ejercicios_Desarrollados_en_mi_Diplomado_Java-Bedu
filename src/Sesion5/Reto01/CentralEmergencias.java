package Sesion5.Reto01;

public class CentralEmergencias {
    public static void main(String[] args) {
        Ambulancia ambulancia = new Ambulancia("Ambulancia", new Operador("Juan"));
        Patrulla patrulla = new Patrulla("Patrulla", new Operador("Laura"));
        UnidadBomberos bomberos = new UnidadBomberos("UnidadBomberos", new Operador("Marco"));

        System.out.println();
        ambulancia.iniciarOperacion();
        System.out.println();
        patrulla.iniciarOperacion();
        System.out.println();
        bomberos.iniciarOperacion();
    }
}

