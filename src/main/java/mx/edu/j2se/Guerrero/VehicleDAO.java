package mx.edu.j2se.Guerrero;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static mx.edu.j2se.Guerrero.ConnectionDB.close;
import static mx.edu.j2se.Guerrero.ConnectionDB.getConnection;

public class VehicleDAO {

    private static final String SQL_SELECT = "SELECT id_vehicle, model, brand, transmission, id_typevehicle, price FROM vehicle";
    private static final String SQL_ORDER = "SELECT id_vehicle, model, brand, transmission, id_typevehicle, price FROM vehicle ORDER BY ";
    private static final String SQL_FILTER = "SELECT id_vehicle, model, brand, transmission, id_typevehicle, price FROM vehicle WHERE ";

    public List<Vehicle> select(){
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Vehicle vehicle  = null;
        List<Vehicle> vehicles = new ArrayList<>();

        try {
            conn = getConnection();
            stm = conn.prepareStatement(SQL_SELECT);
            rs = stm.executeQuery();
            while(rs.next()) {
                int idVehicle = rs.getInt("id_vehicle");
                String model = rs.getString("model");
                String brand = rs.getString("brand");
                String transmission = rs.getString("transmission");
                int idTypeVehicle = rs.getInt("id_typevehicle");
                int price = rs.getInt("price");

                vehicle = new Vehicle(idVehicle,model,brand,transmission,idTypeVehicle,price);
                vehicles.add(vehicle);
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
        return vehicles;
    }

    public List<Vehicle> order(String column,String order) {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Vehicle vehicle = null;
        List<Vehicle> vehicles = new ArrayList<>();

        try {
            conn = getConnection();
            stm = conn.prepareStatement(SQL_ORDER + column + " " + order);
            rs = stm.executeQuery();
            while(rs.next()) {
                int idVehicle = rs.getInt("id_vehicle");
                String model = rs.getString("model");
                String brand = rs.getString("brand");
                String transmission = rs.getString("transmission");
                int idTypeVehicle = rs.getInt("id_typevehicle");
                int price = rs.getInt("price");

                vehicle = new Vehicle(idVehicle,model,brand,transmission,idTypeVehicle,price);
                vehicles.add(vehicle);
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
        return vehicles;
    }

    public List<Vehicle> filter(String column,String value){
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Vehicle vehicle = null;
        List<Vehicle> vehicles = new ArrayList<>();

        try {
            conn = getConnection();
            stm = conn.prepareStatement(SQL_FILTER + column + " = " + "'" + value + "'");
            rs = stm.executeQuery();
            while(rs.next()) {
                int idVehicle = rs.getInt("id_vehicle");
                String model = rs.getString("model");
                String brand = rs.getString("brand");
                String transmission = rs.getString("transmission");
                int idTypeVehicle = rs.getInt("id_typevehicle");
                int price = rs.getInt("price");

                vehicle = new Vehicle(idVehicle,model,brand,transmission,idTypeVehicle,price);
                vehicles.add(vehicle);
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
        return vehicles;
    }
}