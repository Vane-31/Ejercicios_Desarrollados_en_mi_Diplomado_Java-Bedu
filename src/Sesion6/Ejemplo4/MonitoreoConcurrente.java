package Sesion6.Ejemplo4;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ConcurrentHashMap;

public class MonitoreoConcurrente {
    public static void main(String[] args) {

        // Lista concurrente: usuarios conectados
        List<String> tecnicosConectados = new CopyOnWriteArrayList<>();
        tecnicosConectados.add("Ana");
        tecnicosConectados.add("Luis");
        tecnicosConectados.add("Carlos");

        // Simulación de lectura de usuarios conectados desde varios hilos
        System.out.println("👥 Técnicos actualmente conectados:");
        for (String tecnico : tecnicosConectados) {
            System.out.println("- " + tecnico);
        }

        // Mapa concurrente: sensores por máquina
        ConcurrentHashMap<String, Double> sensoresTemperatura = new ConcurrentHashMap<>();
        sensoresTemperatura.put("M-01", 68.5);
        sensoresTemperatura.put("M-02", 72.3);
        sensoresTemperatura.put("M-03", 70.0);

        // Simulación de actualización concurrente (solo un hilo en este caso)
        sensoresTemperatura.put("M-01", 69.1); // Nueva lectura
        sensoresTemperatura.put("M-04", 65.7); // Nueva máquina

        System.out.println("\n🌡️ Temperaturas por máquina:");
        for (String maquina : sensoresTemperatura.keySet()) {
            System.out.println(maquina + " → " + sensoresTemperatura.get(maquina) + " °C");
        }
    }
}
