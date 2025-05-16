package Sesion5.Ejemplo3;

public class DroneVigilancia extends Drone implements Vigilancia {

    public DroneVigilancia(String id) {
        super(id);
    }

    @Override
    public void ejecutarMision() {
        System.out.println("Drone " + id + " iniciando misión de vigilancia.");
        escanearArea();
    }

    @Override
    public void escanearArea() {
        System.out.println("Escaneando área en 360°...");
    }
}
