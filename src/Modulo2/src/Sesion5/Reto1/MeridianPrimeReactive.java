package Sesion5.Reto1;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class MeridianPrimeReactive {

    private static final Random random = new Random();
    private static final AtomicInteger redLightCounter = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {

        Flux.interval(Duration.ofMillis(500))
                .map(i -> random.nextInt(101))
                .filter(congestion -> congestion > 70)
                .onBackpressureBuffer()
                .subscribe(c -> System.out.println("\uD83D\uDE97 Alerta: Congestión del " + c + "% en Avenida Solar"));

        Flux.interval(Duration.ofMillis(600))
                .map(i -> random.nextInt(101))
                .filter(pm -> pm > 50)
                .subscribe(pm -> System.out.println("\uD83C\uDF2B\uFE0F Alerta: Contaminación alta (PM2.5: " + pm + " ug/m3)"));

        Flux.interval(Duration.ofMillis(800))
                .map(i -> {
                    String[] priorities = {"Baja", "Media", "Alta"};
                    return priorities[random.nextInt(3)];
                })
                .filter(priority -> priority.equals("Alta"))
                .subscribe(p -> System.out.println("\uD83D\uDE91 Emergencia vial: Accidente con prioridad Alta"));

        Flux.interval(Duration.ofMillis(700))
                .map(i -> random.nextInt(11))
                .filter(delay -> delay > 5)
                .onBackpressureBuffer()
                .subscribe(delay -> System.out.println("\uD83D\uDE89 Tren maglev con retraso crítico: " + delay + " minutos"));

        Flux.interval(Duration.ofMillis(400))
                .map(i -> {
                    String[] lights = {"Verde", "Amarillo", "Rojo"};
                    return lights[random.nextInt(3)];
                })
                .publishOn(Schedulers.parallel())
                .subscribe(state -> {
                    if (state.equals("Rojo")) {
                        if (redLightCounter.incrementAndGet() >= 3) {
                            System.out.println("\uD83D\uDEA6 Semáforo en Rojo detectado 3 veces seguidas en cruce Norte");
                            redLightCounter.set(0);
                        }
                    } else {
                        redLightCounter.set(0);
                    }
                });

        // Simulación continua (por ser ejemplo educativo, detener con Ctrl+C)
        Thread.sleep(15000);
    }
}
