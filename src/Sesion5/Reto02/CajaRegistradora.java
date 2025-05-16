package Sesion5.Reto02;

public class CajaRegistradora {
    public static void main(String[] args) {
        MetodoPago[] pagos = {
                new PagoEfectivo(150.0),
                new PagoTarjeta(320.0, 500.0),
                new PagoTransferencia(200.0, false) // simulando fallo
        };

        for (MetodoPago pago : pagos) {
            if (pago instanceof Autenticable) {
                Autenticable auth = (Autenticable) pago;
                if (auth.autenticar()) {
                    System.out.println("Autenticación exitosa.");
                    pago.procesarPago();
                    pago.mostrarResumen();
                } else {
                    System.out.println("Fallo de autenticación. " + pago.getClass().getSimpleName() + " no válido.");
                }
                System.out.println();
            }
        }
    }
}
