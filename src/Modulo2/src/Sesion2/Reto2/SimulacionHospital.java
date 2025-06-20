package Sesion2.Reto2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

// Clase que representa un recurso médico crítico (como una sala de cirugía)
class RecursoMedico {
    private final String nombre;
    private final ReentrantLock lock = new ReentrantLock();

    public RecursoMedico(String nombre) {
        this.nombre = nombre;
    }

    public void usar(String profesional) {
        System.out.println("⏳ " + profesional + " está intentando acceder a " + nombre);
        lock.lock(); // Bloqueo exclusivo
        try {
            System.out.println("👩‍⚕️ " + profesional + " ha ingresado a " + nombre);
            Thread.sleep(1000); // Simula el uso del recurso
            System.out.println("✅ " + profesional + " ha salido de " + nombre);
        } catch (InterruptedException e) {
            System.out.println("❌ " + profesional + " fue interrumpido.");
        } finally {
            lock.unlock(); // Libera el recurso
        }
    }
}

// Clase principal
public class SimulacionHospital {
    public static void main(String[] args) {
        System.out.println("🏥 Iniciando acceso a la Sala de cirugía...\n");

        RecursoMedico salaCirugia = new RecursoMedico("Sala de cirugía");

        // Crear un pool de 4 hilos
        ExecutorService executor = Executors.newFixedThreadPool(4);

        // Lista de profesionales que intentan acceder
        String[] profesionales = {
                "Dra. Sánchez", "Dr. Gómez", "Enf. Ramírez", "Dr. Pérez", "Dra. Ruiz", "Enf. Torres"
        };

        // Enviar tareas
        for (String nombre : profesionales) {
            executor.submit(() -> salaCirugia.usar(nombre));
        }

        // Cierre ordenado del executor
        executor.shutdown();
        try {
            if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }

        System.out.println("\n🛑 Simulación finalizada.");
    }
}
