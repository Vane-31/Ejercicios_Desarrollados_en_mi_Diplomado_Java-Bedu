package Sesion5.Reto02;

public class PagoTransferencia extends MetodoPago implements Autenticable {
    private boolean validacionBancaria;

    public PagoTransferencia(double monto, boolean validacionBancaria) {
        super(monto);
        this.validacionBancaria = validacionBancaria;
    }

    @Override
    public boolean autenticar() {
        return validacionBancaria;
    }

    @Override
    public void procesarPago() {
        System.out.println(" Procesando pago por transferencia por $" + monto);
    }
}

