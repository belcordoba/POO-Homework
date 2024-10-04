import modelos.ASistema;
import modelos.Carro;
import modelos.Camion;

public class Main {
    public static void main(String[] args) {
        Carro carro1 = new Carro("1", "Toyota");
        carro1.encenderVehiculo();
        Camion camion1 = new Camion();
        camion1.encenderVehiculo();
        System.out.println(camion1.devolverKilometraje(0));
        ASistema.saludar();
    }
}