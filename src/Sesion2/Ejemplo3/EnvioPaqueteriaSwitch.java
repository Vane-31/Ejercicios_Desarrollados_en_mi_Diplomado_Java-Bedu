package Sesion2.Ejemplo3;

import java.util.Scanner;

public class EnvioPaqueteriaSwitch {
    public static void main(String[] args) {
        String tipo = "mediano";

        double costo = switch (tipo.toLowerCase()) {
            case "pequeño" -> 49.99;
            case "mediano" -> 89.99;
            case "grande" -> 149.99;
            default -> {
                System.out.println("Tipo no válido.");
                yield 0.0;
            }
        };

        System.out.println("Costo del envío: $" + costo);
}}
