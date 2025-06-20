package Sesion3.Reto1;

import java.util.*;
import java.util.stream.*;

class Pedido {
    private String cliente;
    private String tipoEntrega; // "domicilio" o "local"
    private String telefono;    // puede ser null

    public Pedido(String cliente, String tipoEntrega, String telefono) {
        this.cliente = cliente;
        this.tipoEntrega = tipoEntrega;
        this.telefono = telefono;
    }

    public String getTipoEntrega() {
        return tipoEntrega;
    }

    public Optional<String> getTelefono() {
        return Optional.ofNullable(telefono);
    }
}

public class Pizzeria {
    public static void main(String[] args) {
        // Lista de pedidos
        List<Pedido> pedidos = Arrays.asList(
                new Pedido("Ana", "domicilio", "555-1234"),
                new Pedido("Luis", "local", null),
                new Pedido("María", "domicilio", null),
                new Pedido("Carlos", "domicilio", "555-5678"),
                new Pedido("Laura", "local", "555-1111"),
                new Pedido("Pedro", "domicilio", "555-9999")
        );

        // Procesar los pedidos
        pedidos.stream()
                .filter(p -> "domicilio".equalsIgnoreCase(p.getTipoEntrega())) // solo pedidos a domicilio
                .map(Pedido::getTelefono)                                      // obtener Optional<String>
                .filter(Optional::isPresent)                                   // descartar nulls
                .map(Optional::get)                                            // obtener el valor del teléfono
                .map(tel -> "📞 Confirmación enviada al número: " + tel)       // transformar en mensaje
                .forEach(System.out::println);                                 // mostrar mensajes
    }
}
