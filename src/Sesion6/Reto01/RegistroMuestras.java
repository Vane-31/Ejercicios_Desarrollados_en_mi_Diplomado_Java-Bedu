package Sesion6.Reto01;

import java.util.*;

public class RegistroMuestras {
    public static void main(String[] args) {

        // Paso 1: ArrayList para registrar todas las especies en orden de llegada
        List<String> muestrasEnOrden = new ArrayList<>();
        muestrasEnOrden.add("Homo sapiens");
        muestrasEnOrden.add("Mus musculus");
        muestrasEnOrden.add("Arabidopsis thaliana");
        muestrasEnOrden.add("Homo sapiens"); // Se repite porque es una réplica
        muestrasEnOrden.add("Drosophila melanogaster");

        System.out.println("Orden de llegada de muestras genéticas:");
        for (String especie : muestrasEnOrden) {
            System.out.println("- " + especie);
        }

        // Paso 2: HashSet para obtener especies únicas procesadas
        Set<String> especiesUnicas = new HashSet<>(muestrasEnOrden);

        System.out.println("\n Especies únicas procesadas en el laboratorio:");
        for (String especie : especiesUnicas) {
            System.out.println("- " + especie);
        }

        // Paso 3: HashMap para asociar ID de muestra con nombre del investigador
        Map<String, String> registroInvestigadores = new HashMap<>();
        registroInvestigadores.put("M-001", "Dra. López");
        registroInvestigadores.put("M-002", "Dr. Hernández");
        registroInvestigadores.put("M-003", "Dra. Ramírez");
        registroInvestigadores.put("M-004", "Dr. Ortega");

        System.out.println("\n Asociación de muestras con investigadores:");
        for (Map.Entry<String, String> entrada : registroInvestigadores.entrySet()) {
            System.out.println(entrada.getKey() + " → " + entrada.getValue());
        }

        // Paso 4: Búsqueda por ID de muestra
        String idBuscado = "M-002";
        String investigador = registroInvestigadores.get(idBuscado);

        System.out.println("\n Búsqueda de responsable de la muestra " + idBuscado + ":");
        if (investigador != null) {
            System.out.println("El investigador responsable es: " + investigador);
        } else {
            System.out.println(" No se encontró ningún investigador con ese ID de muestra.");
        }
    }
}

