package Sesion4.Reto01;

public class Main {
    public static void main(String[] args) {
        Factura f1 = new Factura("FAC001", "Juan Pérez", 1450.0);
        Factura f2 = new Factura("FAC001", "Comercial XYZ", 1450.0);

        System.out.println(f1);
        System.out.println(f2);

        System.out.println("¿Las facturas son iguales?: " + f1.equals(f2));
    }
}
