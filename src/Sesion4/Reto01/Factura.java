package Sesion4.Reto01;

public class Factura {
    private String folio;
    private String cliente;
    private double total;

    // Constructor
    public Factura(String folio, String cliente, double total) {
        this.folio = folio;
        this.cliente = cliente;
        this.total = total;
    }

    // toString para mostrar formato personalizado
    @Override
    public String toString() {
        return "Factura [folio=" + folio + ", cliente=" + cliente + ", total=$" + total + "]";
    }

    // equals: compara solo por folio
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;  // misma referencia
        if (obj == null || getClass() != obj.getClass()) return false;
        Factura otra = (Factura) obj;
        return folio.equals(otra.folio);  // solo importa el folio
    }

    // hashCode basado solo en el folio
    @Override
    public int hashCode() {
        return folio.hashCode();
    }
}
