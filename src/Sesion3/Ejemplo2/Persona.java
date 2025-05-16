package Sesion3.Ejemplo2;

public class Persona {
    String nombre;

    public Persona(String nombre) {
        this.nombre = nombre;
    }

    // Método para cambiar el nombre
    public static void cambiarNombre(Persona p) {
        p.nombre = "Nuevo nombre";
    }

    public static void main(String[] args) {
        Persona persona = new Persona("Mario");
        cambiarNombre(persona);
        System.out.println("Nombre actualizado: " + persona.nombre);
    }
}
