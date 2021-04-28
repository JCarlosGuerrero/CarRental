package mx.edu.j2se.Guerrero;

import java.sql.*;
import java.util.*;
import static mx.edu.j2se.Guerrero.ConnectionDB.*;

public class ClientDAO {
    private static final String SQL_SELECT = "SELECT id_client, name_client, last_name, phone FROM client";
    private static final String SQL_ORDER = "SELECT id_client, name_client, last_name, phone FROM client ORDER BY ";
    private static final String SQL_FILTER = "SELECT id_client, name_client, last_name, phone FROM client WHERE ";

    public List<Client> select(){
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Client client = null;
        List<Client> clients = new ArrayList<>();

        try {
            conn = getConnection();
            stm = conn.prepareStatement(SQL_SELECT);
            rs = stm.executeQuery();
            while(rs.next()) {
                int idClient = rs.getInt("id_client");
                String nameClient = rs.getString("name_client");
                String lastName = rs.getString("last_name");
                String phone = rs.getString("phone");

                client = new Client(idClient,nameClient,lastName,phone);
                clients.add(client);
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
        return clients;
    }

    public List<Client> order(String column,String order) {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Client client = null;
        List<Client> clients = new ArrayList<>();

        try {
            conn = getConnection();
            stm = conn.prepareStatement(SQL_ORDER + column + " " + order);
            rs = stm.executeQuery();
            while(rs.next()) {
                int idClient = rs.getInt("id_client");
                String nameClient = rs.getString("name_client");
                String lastName = rs.getString("last_name");
                String phone = rs.getString("phone");

                client = new Client(idClient,nameClient,lastName,phone);
                clients.add(client);
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
        return clients;
    }

    public List<Client> filter(String column,String value){
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Client client = null;
        List<Client> clients = new ArrayList<>();

        try {
            conn = getConnection();
            stm = conn.prepareStatement(SQL_FILTER + column + " = " + "'" + value + "'");
            rs = stm.executeQuery();
            while(rs.next()) {
                int idClient = rs.getInt("id_client");
                String nameClient = rs.getString("name_client");
                String lastName = rs.getString("last_name");
                String phone = rs.getString("phone");

                client = new Client(idClient,nameClient,lastName,phone);
                clients.add(client);
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
        return clients;
    }
}
