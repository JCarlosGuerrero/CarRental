package mx.edu.j2se.Guerrero;

public class TypeVehicle {

    private int idTypeVehicle;
    private String typeVehicle;

    public TypeVehicle() {}

    public TypeVehicle(int idTypeVehicle) {this.idTypeVehicle = idTypeVehicle; }

    public TypeVehicle(int idTypeVehicle, String typeVehicle) {
        this.idTypeVehicle = idTypeVehicle;
        this.typeVehicle = typeVehicle;
    }

    public int getIdTypeVehicle() {
        return idTypeVehicle;
    }

    public void setIdTypeVehicle(int idTypeVehicle) {
        this.idTypeVehicle = idTypeVehicle;
    }

    public String getTypeVehicle() {
        return typeVehicle;
    }

    public void setTypeVehicle(String typeVehicle) {
        this.typeVehicle = typeVehicle;
    }

    @Override
    public String toString() {
        return "typeVehicle{" +
                "idTypeVehicle=" + idTypeVehicle +
                ", typeVehicle='" + typeVehicle + '\'' +
                '}';
    }
}
