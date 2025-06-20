package Sesion1.Reto2;

import java.util.*;
import java.util.function.Predicate;

// Clase base abstracta
abstract class MaterialCurso {
    protected String titulo;
    protected String autor;

    public MaterialCurso(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
    }

    public String getAutor() {
        return autor;
    }

    public abstract void mostrarDetalle();
}

// Subclase Video
class Video extends MaterialCurso {
    private int duracion; // minutos

    public Video(String titulo, String autor, int duracion) {
        super(titulo, autor);
        this.duracion = duracion;
    }

    public int getDuracion() {
        return duracion;
    }

    @Override
    public void mostrarDetalle() {
        System.out.println("🎥 Video: " + titulo + " - Autor: " + autor + " - Duración: " + duracion + " min");
    }
}

// Subclase Articulo
class Articulo extends MaterialCurso {
    private int palabras;

    public Articulo(String titulo, String autor, int palabras) {
        super(titulo, autor);
        this.palabras = palabras;
    }

    @Override
    public void mostrarDetalle() {
        System.out.println("📄 Artículo: " + titulo + " - Autor: " + autor + " - Palabras: " + palabras);
    }
}

// Subclase Ejercicio
class Ejercicio extends MaterialCurso {
    private boolean revisado;

    public Ejercicio(String titulo, String autor) {
        super(titulo, autor);
        this.revisado = false;
    }

    public void marcarRevisado() {
        this.revisado = true;
        System.out.println("✅ Ejercicio '" + titulo + "' marcado como revisado.");
    }

    public boolean isRevisado() {
        return revisado;
    }

    @Override
    public void mostrarDetalle() {
        System.out.println("📝 Ejercicio: " + titulo + " - Autor: " + autor + " - Revisado: " + revisado);
    }
}

// Clase principal
public class PlataformaEducativa {

    // Mostrar todos los materiales
    public static void mostrarMateriales(List<? extends MaterialCurso> lista) {
        for (MaterialCurso material : lista) {
            material.mostrarDetalle();
        }
    }

    // Contar duración de videos
    public static void contarDuracionVideos(List<? extends Video> lista) {
        int total = 0;
        for (Video video : lista) {
            total += video.getDuracion();
        }
        System.out.println("\n🎥 Duración total de videos: " + total + " minutos");
    }

    // Marcar ejercicios como revisados
    public static void marcarEjerciciosRevisados(List<? super Ejercicio> lista) {
        for (Object obj : lista) {
            if (obj instanceof Ejercicio) {
                ((Ejercicio) obj).marcarRevisado();
            }
        }
    }

    // Filtrar materiales por autor
    public static void filtrarPorAutor(List<? extends MaterialCurso> lista, Predicate<MaterialCurso> filtro) {
        System.out.println("\n🔍 Filtrando materiales por autor:");
        for (MaterialCurso material : lista) {
            if (filtro.test(material)) {
                material.mostrarDetalle();
            }
        }
    }

    public static void main(String[] args) {
        // Crear materiales
        Video v1 = new Video("Introducción a Java", "Mario", 15);
        Video v2 = new Video("POO en Java", "Carlos", 20);

        Articulo a1 = new Articulo("Historia de Java", "Ana", 1200);
        Articulo a2 = new Articulo("Tipos de datos", "Luis", 800);

        Ejercicio e1 = new Ejercicio("Variables y tipos", "Luis");
        Ejercicio e2 = new Ejercicio("Condicionales", "Mario");

        // Lista general de materiales
        List<MaterialCurso> materiales = new ArrayList<>();
        materiales.addAll(List.of(v1, v2, a1, a2, e1, e2));

        System.out.println("📚 Materiales del curso:");
        mostrarMateriales(materiales);

        // Lista solo de videos
        List<Video> videos = List.of(v1, v2);
        contarDuracionVideos(videos);

        // Marcar ejercicios como revisados
        marcarEjerciciosRevisados(materiales);

        // Filtro por autor usando Predicate
        filtrarPorAutor(materiales, m -> m.getAutor().equals("Mario"));
    }
}
