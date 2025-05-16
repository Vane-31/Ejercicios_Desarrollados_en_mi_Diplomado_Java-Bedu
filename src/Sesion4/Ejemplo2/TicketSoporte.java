package Sesion4.Ejemplo2;

import java.util.Objects;

public class TicketSoporte {

    private String titulo;
    private String categoria;
    private int prioridad;
    private boolean estaActivo;

    public TicketSoporte(String titulo, String categoria, int prioridad) {
        this.titulo = titulo;
        this.categoria = categoria;
        this.prioridad = prioridad;
        this.estaActivo = true;
    }

    // Sobrescribimos equals() para comparar contenido
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // Mismo objeto
        if (obj == null || getClass() != obj.getClass()) return false;

        TicketSoporte otro = (TicketSoporte) obj;
        return this.titulo.equals(otro.titulo) &&
                this.categoria.equals(otro.categoria) &&
                this.prioridad == otro.prioridad &&
                this.estaActivo == otro.estaActivo;
    }

    // hashCode() compatible con equals()
    @Override
    public int hashCode() {
        return Objects.hash(titulo, categoria, prioridad, estaActivo);
    }

    // toString() para ver fácilmente la información del ticket
    @Override
    public String toString() {
        return "🎫 TicketSoporte {" +
                "titulo='" + titulo + '\'' +
                ", categoria='" + categoria + '\'' +
                ", prioridad=" + prioridad +
                ", estaActivo=" + estaActivo +
                '}';
    }
}
