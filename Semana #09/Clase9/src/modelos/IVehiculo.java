package modelos;

public interface IVehiculo {
    public default void apagarVehiculo() {
        System.out.println("Apaga vehiculo");
    }
    public void encenderVehiculo();

    public default String devolverKilometraje(int kilometraje){
        return "";
    }
}
