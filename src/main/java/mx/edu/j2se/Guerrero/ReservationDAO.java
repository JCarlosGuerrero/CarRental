package mx.edu.j2se.Guerrero;

import java.sql.*;
import java.util.*;
import java.util.Date;

import static mx.edu.j2se.Guerrero.ConnectionDB.*;

public class ReservationDAO {

    private static final String SQL_SELECT = "SELECT id_reservation, id_vehicle, id_client, id_typevehicle, deliver_date, return_date, total_price FROM reservation";
    private static final String SQL_ORDER = "SELECT id_reservation, id_vehicle, id_client, id_typevehicle, deliver_date, return_date, total_price FROM reservation ORDER BY ";
    private static final String SQL_FILTER = "SELECT id_reservation, id_vehicle, id_client, id_typevehicle, deliver_date, return_date, total_price FROM reservation WHERE ";

    public List<Reservation> select(){
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Reservation reservation  = null;
        List<Reservation> reservations = new ArrayList<>();

        try {
            conn = getConnection();
            stm = conn.prepareStatement(SQL_SELECT);
            rs = stm.executeQuery();
            while(rs.next()) {
                int idReservation = rs.getInt("id_reservation");
                int idVehicle = rs.getInt("id_vehicle");
                int idClient = rs.getInt("id_client");
                int idTypeVehicle = rs.getInt("id_typevehicle");
                Date deliverDate = rs.getDate("deliver_date");
                Date returnDate = rs.getDate("return_date");
                int totalPrice = rs.getInt("total_price");

                reservation = new Reservation(idReservation,idVehicle,idClient,idTypeVehicle,deliverDate,returnDate,totalPrice);
                reservations.add(reservation);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            try {
                close(rs);
                close(stm);
                close(conn);
            } catch (SQLException throwables) {
                throwables.printStackTrace(System.out);
            }
        }
        return reservations;
    }

    public List<Reservation> order(String column,String order) {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Reservation reservation = null;
        List<Reservation> reservations = new ArrayList<>();

        try {
            conn = getConnection();
            stm = conn.prepareStatement(SQL_ORDER + column + " " + order);
            rs = stm.executeQuery();
            while(rs.next()) {
                int idReservation = rs.getInt("id_reservation");
                int idVehicle = rs.getInt("id_vehicle");
                int idClient = rs.getInt("id_client");
                int idTypeVehicle = rs.getInt("id_typevehicle");
                Date deliverDate = rs.getDate("deliver_date");
                Date returnDate = rs.getDate("return_date");
                int totalPrice = rs.getInt("total_price");

                reservation = new Reservation(idReservation,idVehicle,idClient,idTypeVehicle,deliverDate,returnDate,totalPrice);
                reservations.add(reservation);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            try {
                close(rs);
                close(stm);
                close(conn);
            } catch (SQLException throwables) {
                throwables.printStackTrace(System.out);
            }
        }
        return reservations;
    }

    public List<Reservation> filter(String column,String value){
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Reservation reservation = null;
        List<Reservation> reservations = new ArrayList<>();

        try {
            conn = getConnection();
            stm = conn.prepareStatement(SQL_FILTER + column + " = " + "'" + value + "'");
            rs = stm.executeQuery();
            while(rs.next()) {
                int idReservation = rs.getInt("id_reservation");
                int idVehicle = rs.getInt("id_vehicle");
                int idClient = rs.getInt("id_client");
                int idTypeVehicle = rs.getInt("id_typevehicle");
                Date deliverDate = rs.getDate("deliver_date");
                Date returnDate = rs.getDate("return_date");
                int totalPrice = rs.getInt("total_price");

                reservation = new Reservation(idReservation,idVehicle,idClient,idTypeVehicle,deliverDate,returnDate,totalPrice);
                reservations.add(reservation);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            try {
                close(rs);
                close(stm);
                close(conn);
            } catch (SQLException throwables) {
                throwables.printStackTrace(System.out);
            }
        }
        return reservations;
    }
}