package Sesion4.Reto2;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class AeropuertoControl {

    private static final Random random = new Random();

    public static void main(String[] args) {
        System.out.println("🛫 Verificando condiciones para aterrizaje...\n");

        CompletableFuture<Boolean> pista = verificarPista();
        CompletableFuture<Boolean> clima = verificarClima();
        CompletableFuture<Boolean> trafico = verificarTraficoAereo();
        CompletableFuture<Boolean> personal = verificarPersonalTierra();

        CompletableFuture<Void> allChecks = CompletableFuture.allOf(pista, clima, trafico, personal);

        allChecks.thenRun(() -> {
            try {
                boolean resultadoPista = pista.get();
                boolean resultadoClima = clima.get();
                boolean resultadoTrafico = trafico.get();
                boolean resultadoPersonal = personal.get();

                System.out.println("🛣️ Pista disponible: " + resultadoPista);
                System.out.println("🌦️ Clima favorable: " + resultadoClima);
                System.out.println("🚦 Tráfico aéreo despejado: " + resultadoTrafico);
                System.out.println("👷‍♂️ Personal disponible: " + resultadoPersonal);

                if (resultadoPista && resultadoClima && resultadoTrafico && resultadoPersonal) {
                    System.out.println("\n🛬 Aterrizaje autorizado: todas las condiciones óptimas.");
                } else {
                    System.out.println("\n🚫 Aterrizaje denegado: condiciones no óptimas.");
                }
            } catch (Exception e) {
                System.out.println("\n❌ Error en la verificación de condiciones: " + e.getMessage());
            }
        }).exceptionally(ex -> {
            System.out.println("\n❌ Error inesperado en el sistema: " + ex.getMessage());
            return null;
        });

        // Evitar que el programa finalice antes de que las tareas terminen
        try {
            Thread.sleep(4000); // Espera un poco más de lo que tarda la verificación
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static CompletableFuture<Boolean> verificarPista() {
        return CompletableFuture.supplyAsync(() -> {
            esperar(2, 3);
            boolean disponible = random.nextDouble() < 0.80; // 80% de probabilidad de éxito
            return disponible;
        });
    }

    public static CompletableFuture<Boolean> verificarClima() {
        return CompletableFuture.supplyAsync(() -> {
            esperar(2, 3);
            boolean favorable = random.nextDouble() < 0.85; // 85%
            return favorable;
        });
    }

    public static CompletableFuture<Boolean> verificarTraficoAereo() {
        return CompletableFuture.supplyAsync(() -> {
            esperar(2, 3);
            boolean despejado = random.nextDouble() < 0.90; // 90%
            return despejado;
        });
    }

    public static CompletableFuture<Boolean> verificarPersonalTierra() {
        return CompletableFuture.supplyAsync(() -> {
            esperar(2, 3);
            boolean disponible = random.nextDouble() < 0.95; // 95%
            return disponible;
        });
    }

    private static void esperar(int minSegundos, int maxSegundos) {
        try {
            int tiempo = minSegundos + random.nextInt(maxSegundos - minSegundos + 1);
            TimeUnit.SECONDS.sleep(tiempo);
        } catch (InterruptedException e) {
            throw new RuntimeException("Error durante la simulación de latencia.");
        }
    }
}
