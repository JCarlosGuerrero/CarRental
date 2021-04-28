package mx.edu.j2se.Guerrero;

import java.sql.*;

public class Main {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/carrental?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
            try {
                //Class.forName("com.mysql.jdbc.Driver");
                Connection conexion = DriverManager.getConnection(url,"root","9270");
                Statement instruccion = conexion.createStatement();
                String sql = "SELECT id_client, name_client, last_name, phone FROM client";
                ResultSet resultado = instruccion.executeQuery(sql);
                while(resultado.next()) {
                    System.out.println("Id_client: " + resultado.getInt("id_client"));
                    System.out.println("name_client: " + resultado.getString("name_client"));
                    System.out.println("last_name: " + resultado.getString("last_name"));
                    System.out.println("phone: " + resultado.getString("phone"));
                }

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
    }
}