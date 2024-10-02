package modelos;

public class Carro implements IVehiculo {
    private String id;
    private String marca;
    public Carro (String id, String marca) {
        this.id = id;
        this.marca = marca;
    }

    public void encenderVehiculo() {
        System.out.println("Encendiendo vehículo " + this.marca);
    }
}
