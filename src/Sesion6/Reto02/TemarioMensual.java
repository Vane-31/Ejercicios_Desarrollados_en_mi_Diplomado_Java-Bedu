package Sesion6.Reto02;

import java.util.concurrent.*;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

// Clase Tema que implementa Comparable para orden natural (por título)
class Tema implements Comparable<Tema> {
    private String titulo;
    private int prioridad;

    public Tema(String titulo, int prioridad) {
        this.titulo = titulo;
        this.prioridad = prioridad;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getPrioridad() {
        return prioridad;
    }

    @Override
    public int compareTo(Tema otro) {
        // Orden alfabético por título (orden natural)
        return this.titulo.compareTo(otro.titulo);
    }

    @Override
    public String toString() {
        return titulo + " (Prioridad: " + prioridad + ")";
    }
}

public class TemarioMensual {
    public static void main(String[] args) {

        // Lista concurrente de temas activos
        CopyOnWriteArrayList<Tema> temas = new CopyOnWriteArrayList<>();

        // Agregamos temas de ejemplo
        temas.add(new Tema("Lectura comprensiva", 2));
        temas.add(new Tema("Matemáticas básicas", 1));
        temas.add(new Tema("Cuidado del medio ambiente", 3));
        temas.add(new Tema("Arte y creatividad", 2));

        // Mostrar temas ordenados alfabéticamente (Comparable)
        Collections.sort(temas);
        System.out.println("Temas ordenados por título:");
        for (Tema t : temas) {
            System.out.println("- " + t);
        }

        // Ordenar por prioridad ascendente (Comparator)
        temas.sort(Comparator.comparingInt(Tema::getPrioridad));
        System.out.println("\n Temas ordenados por prioridad:");
        for (Tema t : temas) {
            System.out.println("- " + t);
        }

        // Repositorio de recursos concurrente
        ConcurrentHashMap<String, String> recursos = new ConcurrentHashMap<>();
        recursos.put("Lectura comprensiva", "https://recursos.edu/lectura");
        recursos.put("Matemáticas básicas", "https://recursos.edu/mate");
        recursos.put("Cuidado del medio ambiente", "https://recursos.edu/ambiente");
        recursos.put("Arte y creatividad", "https://recursos.edu/arte");

        // Mostrar los recursos disponibles por tema
        System.out.println("\nRepositorio de recursos por tema:");
        for (Map.Entry<String, String> entrada : recursos.entrySet()) {
            System.out.println("Lectura compresiva" + entrada.getKey() + " → " + entrada.getValue());
        }

        // Búsqueda de un recurso específico
        String temaBuscado = "Matemáticas básicas";
        System.out.println("\n Recurso para '" + temaBuscado + "':");
        System.out.println(recursos.getOrDefault(temaBuscado, "No hay recurso disponible."));
    }
}
