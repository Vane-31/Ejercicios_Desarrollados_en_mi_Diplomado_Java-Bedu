package Sesion5.Reto2;

import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.Random;

public class UCIReactiveMonitoring {

    private static final Random random = new Random();

    public static void main(String[] args) throws InterruptedException {

        Flux<String> paciente1 = Flux.interval(Duration.ofMillis(300))
                .flatMap(i -> Flux.just(generarEvento(1))
                        .filter(UCIReactiveMonitoring::esEventoCritico)
                        .delayElements(Duration.ofSeconds(1)));

        Flux<String> paciente2 = Flux.interval(Duration.ofMillis(300))
                .flatMap(i -> Flux.just(generarEvento(2))
                        .filter(UCIReactiveMonitoring::esEventoCritico)
                        .delayElements(Duration.ofSeconds(1)));

        Flux<String> paciente3 = Flux.interval(Duration.ofMillis(300))
                .flatMap(i -> Flux.just(generarEvento(3))
                        .filter(UCIReactiveMonitoring::esEventoCritico)
                        .delayElements(Duration.ofSeconds(1)));

        // Desafío adicional: fusionar flujos y mostrar en un solo stream
        Flux.merge(paciente1, paciente2, paciente3)
                .subscribe(System.out::println);

        // Mantener el programa activo para simular el monitoreo continuo
        Thread.sleep(20000);
    }

    private static String generarEvento(int pacienteId) {
        int fc = random.nextInt(161) + 40; // 40 - 200 bpm
        int paSistolica = random.nextInt(101) + 80; // 80 - 180 mmHg
        int paDiastolica = random.nextInt(61) + 40; // 40 - 100 mmHg
        int spo2 = random.nextInt(21) + 80; // 80 - 100 %

        return String.format("P%d|FC=%d|PA=%d/%d|SpO2=%d",
                pacienteId, fc, paSistolica, paDiastolica, spo2);
    }


    private static boolean esEventoCritico(String evento) {
        try {
            String[] campos = evento.split("\\|");
            int fc = Integer.parseInt(campos[1].split("=")[1]);
            String[] pa = campos[2].split("=")[1].split("/");
            int paS = Integer.parseInt(pa[0]);
            int paD = Integer.parseInt(pa[1]);
            int spo2 = Integer.parseInt(campos[3].split("=")[1]);

            return fc < 50 || fc > 120 || paS < 90 || paD < 60 || paS > 140 || paD > 90 || spo2 < 90;
        } catch (Exception e) {
            System.err.println("\u26A0\uFE0F Error al analizar evento: " + evento + " → " + e.getMessage());
            return false;
        }
    }

}
