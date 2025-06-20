package Sesion3.Reto2;

import java.util.*;
import java.util.stream.*;

class Encuesta {
    private String paciente;
    private String comentario; // puede ser null
    private int calificacion;

    public Encuesta(String paciente, String comentario, int calificacion) {
        this.paciente = paciente;
        this.comentario = comentario;
        this.calificacion = calificacion;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public Optional<String> getComentario() {
        return Optional.ofNullable(comentario);
    }
}

class Sucursal {
    private String nombre;
    private List<Encuesta> encuestas;

    public Sucursal(String nombre, List<Encuesta> encuestas) {
        this.nombre = nombre;
        this.encuestas = encuestas;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Encuesta> getEncuestas() {
        return encuestas;
    }
}

public class ClinicaEncuestas {
    public static void main(String[] args) {
        // Encuestas de la sucursal Centro
        Sucursal centro = new Sucursal("Centro", Arrays.asList(
                new Encuesta("Juan", "El tiempo de espera fue largo", 2),
                new Encuesta("Ana", null, 4),
                new Encuesta("Luis", "Atención regular", 3)
        ));

        // Encuestas de la sucursal Norte
        Sucursal norte = new Sucursal("Norte", Arrays.asList(
                new Encuesta("Carlos", "La atención fue buena, pero la limpieza puede mejorar", 3),
                new Encuesta("María", null, 5),
                new Encuesta("Pedro", "Poca disponibilidad de personal", 2)
        ));

        List<Sucursal> sucursales = Arrays.asList(centro, norte);

        // Procesar las encuestas
        sucursales.stream()
                .flatMap(sucursal ->
                        sucursal.getEncuestas().stream()
                                .filter(e -> e.getCalificacion() <= 3)                // Filtrar calificaciones bajas
                                .map(e -> e.getComentario()
                                        .map(comentario ->
                                                "Sucursal " + sucursal.getNombre() + ": Seguimiento a paciente con comentario: \"" + comentario + "\""
                                        )
                                )
                                .filter(Optional::isPresent)                         // Quitar los comentarios null
                                .map(Optional::get)                                  // Obtener los comentarios
                )
                .forEach(System.out::println);                               // Imprimir mensajes
    }
}
