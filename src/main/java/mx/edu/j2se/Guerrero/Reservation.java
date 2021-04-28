package mx.edu.j2se.Guerrero;

import java.util.Date;

public class Reservation {
    private int idReservation;
    private int idVehicle;
    private int idClient;
    private int idTypeVehicle;
    private Date deliver_date;
    private Date return_date;
    private int totalPrice;

    public Reservation() {}

    public Reservation(int idReservation) {
        this.idReservation = idReservation;
    }

    public Reservation(int idReservation, int idVehicle, int idClient, int idTypeVehicle, Date deliver_date, Date return_date, int totalPrice) {
        this.idReservation = idReservation;
        this.idVehicle = idVehicle;
        this.idClient = idClient;
        this.idTypeVehicle = idTypeVehicle;
        this.deliver_date = deliver_date;
        this.return_date = return_date;
        this.totalPrice = totalPrice;
    }

    public int getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(int idReservation) {
        this.idReservation = idReservation;
    }

    public int getIdVehicle() {
        return idVehicle;
    }

    public void setIdVehicle(int idVehicle) {
        this.idVehicle = idVehicle;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public int getIdTypeVehicle() {
        return idTypeVehicle;
    }

    public void setIdTypeVehicle(int idTypeVehicle) {
        this.idTypeVehicle = idTypeVehicle;
    }

    public Date getDeliver_date() {
        return deliver_date;
    }

    public void setDeliver_date(Date deliver_date) {
        this.deliver_date = deliver_date;
    }

    public Date getReturn_date() {
        return return_date;
    }

    public void setReturn_date(Date return_date) {
        this.return_date = return_date;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "idReservation=" + idReservation +
                ", idVehicle=" + idVehicle +
                ", idClient=" + idClient +
                ", idTypeVehicle=" + idTypeVehicle +
                ", deliver_date=" + deliver_date +
                ", return_date=" + return_date +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
