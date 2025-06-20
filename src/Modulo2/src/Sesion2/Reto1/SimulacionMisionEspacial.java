package Sesion2.Reto1;

import java.util.concurrent.*;

// Sistema de navegación
class SistemaNavegacion implements Callable<String> {
    public String call() throws Exception {
        Thread.sleep(1500);
        return "🛰️ Navegación: trayectoria corregida con éxito.";
    }
}

// Sistema de soporte vital
class SistemaSoporteVital implements Callable<String> {
    public String call() throws Exception {
        Thread.sleep(1000);
        return "🧪 Soporte vital: presión y oxígeno dentro de parámetros normales.";
    }
}

// Sistema de control térmico
class SistemaControlTermico implements Callable<String> {
    public String call() throws Exception {
        Thread.sleep(1200);
        return "🔥 Control térmico: temperatura estable (22°C).";
    }
}

// Sistema de comunicaciones
class SistemaComunicaciones implements Callable<String> {
    public String call() throws Exception {
        Thread.sleep(800);
        return "📡 Comunicaciones: enlace con estación terrestre establecido.";
    }
}

// Clase principal para simular la misión
public class SimulacionMisionEspacial {
    public static void main(String[] args) {
        System.out.println("🚀 Simulación de misión espacial iniciada...");

        // Crear un pool fijo de 4 hilos
        ExecutorService executor = Executors.newFixedThreadPool(4);

        try {
            // Enviar tareas
            Future<String> futuroNav = executor.submit(new SistemaNavegacion());
            Future<String> futuroVida = executor.submit(new SistemaSoporteVital());
            Future<String> futuroTermico = executor.submit(new SistemaControlTermico());
            Future<String> futuroCom = executor.submit(new SistemaComunicaciones());

            // Mostrar resultados (puede variar el orden de ejecución real)
            System.out.println(futuroCom.get());
            System.out.println(futuroVida.get());
            System.out.println(futuroTermico.get());
            System.out.println(futuroNav.get());

            System.out.println("✅ Todos los sistemas reportan estado operativo.");

        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown(); // cerrar correctamente el executor
        }
    }
}

