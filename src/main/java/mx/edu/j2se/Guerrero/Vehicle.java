package mx.edu.j2se.Guerrero;

public class Vehicle {

    private int idVehicle;
    private String model;
    private String brand;
    private String transmission;
    private int idTypeVehicle;
    private int price;

    public Vehicle() {}

    public Vehicle(int idVehicle) {this.idVehicle = idVehicle; }

    public Vehicle(int idVehicle, String model, String brand, String transmission, int idTypeVehicle, int price) {
        this.idVehicle = idVehicle;
        this.model = model;
        this.brand = brand;
        this.transmission = transmission;
        this.idTypeVehicle = idTypeVehicle;
        this.price = price;
    }

    public int getIdVehicle() {
        return idVehicle;
    }

    public void setIdVehicle(int idVehicle) {
        this.idVehicle = idVehicle;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public int getIdTypeVehicle() {
        return idTypeVehicle;
    }

    public void setIdTypeVehicle(int idTypeVehicle) {
        this.idTypeVehicle = idTypeVehicle;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "vehicle{" +
                "idVehicle=" + idVehicle +
                ", model='" + model + '\'' +
                ", brand='" + brand + '\'' +
                ", transmission='" + transmission + '\'' +
                ", idTypeVehicle=" + idTypeVehicle +
                ", price=" + price +
                '}';
    }
}
