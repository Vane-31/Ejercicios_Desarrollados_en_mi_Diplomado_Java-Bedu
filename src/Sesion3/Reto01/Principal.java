package Sesion3.Reto01;

public class Principal {
    public static void main(String[] args) {
        Pasajero p1 = new Pasajero("Ana Martínez", "AB123456");
        Vuelo vuelo1 = new Vuelo("UX123", "París", "14:30");

        boolean exito = vuelo1.reservarAsiento(p1);
        if (exito) {
            System.out.println("✅ Reserva realizada con éxito.\n");
        } else {
            System.out.println("❌ No se pudo reservar el asiento.\n");
        }

        System.out.println(vuelo1.obtenerItinerario() + "\n");

        System.out.println("❌ Cancelando reserva...\n");
        vuelo1.cancelarReserva();

        System.out.println(vuelo1.obtenerItinerario() + "\n");

        vuelo1.reservarAsiento("Mario Gonzalez", "CD7891011");

        System.out.println(vuelo1.obtenerItinerario() + "\n");

    }
}
