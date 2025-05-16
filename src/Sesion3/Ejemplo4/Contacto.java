package Sesion3.Ejemplo4;

import java.util.Optional;

public class Contacto {
    private Optional<String> telefono;

    public Contacto(String telefono) {
        this.telefono = Optional.ofNullable(telefono);
    }

    public Optional<String> getTelefono() {
        return telefono;
    }

    public static void main(String[] args) {
        Contacto c1 = new Contacto("555-1234");
        Contacto c2 = new Contacto(null);

        // Usando isPresent (menos recomendado)
        if (c1.getTelefono().isPresent()) {
            System.out.println("📞 Teléfono: " + c1.getTelefono().get());
        }

        // Mejor: usando ifPresent
        c2.getTelefono().ifPresent(tel -> System.out.println("📞 Teléfono: " + tel));

        // orElse devuelve el valor si existe, o el alternativo si no
        String tel1 = c1.getTelefono().orElse("No registrado");
        String tel2 = c2.getTelefono().orElse("No registrado");

        System.out.println("📞 Teléfono 1: " + tel1);
        System.out.println("📞 Teléfono 2: " + tel2);

        // orElseThrow lanza una excepción si no hay valor
        try {
            String telSeguro = c1.getTelefono().orElseThrow(() -> new RuntimeException("⚠️ Teléfono obligatorio"));
            System.out.println("Teléfono seguro: " + telSeguro);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
