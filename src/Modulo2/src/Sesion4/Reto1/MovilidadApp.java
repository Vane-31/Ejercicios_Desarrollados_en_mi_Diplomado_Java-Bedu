package Sesion4.Reto1;

import java.util.concurrent.*;
import java.util.concurrent.ThreadLocalRandom;

public class MovilidadApp {

    // Simula cálculo de ruta con retardo entre 2 y 3 segundos
    public static CompletableFuture<String> calcularRuta() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("🚦 Calculando ruta...");
                Thread.sleep(ThreadLocalRandom.current().nextInt(2000, 3000));
                return "Centro -> Norte";
            } catch (InterruptedException e) {
                throw new RuntimeException("Error al calcular la ruta");
            }
        });
    }

    // Simula estimación de tarifa con retardo entre 1 y 2 segundos
    public static CompletableFuture<Double> estimarTarifa() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("💰 Estimando tarifa...");
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 2000));

                // Simular error aleatorio (opcional)
                if (ThreadLocalRandom.current().nextInt(10) < 2) {
                    throw new RuntimeException("Demasiada demanda para calcular tarifa");
                }

                return 75.50;
            } catch (InterruptedException e) {
                throw new RuntimeException("Error al estimar la tarifa");
            }
        });
    }

    public static void main(String[] args) {
        CompletableFuture<String> rutaFuture = calcularRuta()
                .exceptionally(ex -> {
                    System.out.println("❌ Error en ruta: " + ex.getMessage());
                    return "Ruta desconocida";
                });

        CompletableFuture<Double> tarifaFuture = estimarTarifa()
                .exceptionally(ex -> {
                    System.out.println("❌ Error en tarifa: " + ex.getMessage());
                    return -1.0;
                });

        rutaFuture.thenCombine(tarifaFuture, (ruta, tarifa) -> {
            if (tarifa >= 0) {
                return "✅ 🚗 Ruta calculada: " + ruta + " | Tarifa estimada: $" + tarifa;
            } else {
                return "⚠️ Ruta calculada: " + ruta + " | No se pudo estimar la tarifa.";
            }
        }).thenAccept(System.out::println);

        // Esperar a que las tareas finalicen (solo para que el programa no termine antes)
        try {
            Thread.sleep(4000); // Máximo retardo simulado
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

