package mx.edu.j2se.Guerrero;

import java.sql.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("hola");
        String url = "jdbc:postgresql://localhost:5432/pesca";
        try {
           //Class.forName("org.postgresql.Driver");
            Connection connection = null;
            connection = DriverManager.getConnection(url,"postgres","9270");
            Statement instruccion = connection.createStatement();
            boolean valid = connection.isValid(50000);
            System.out.println(valid ? "TEST OK" : "TEST FAIL");
            String sql = "SELECT nombre_miembro FROM miembro";
            ResultSet resultado = instruccion.executeQuery(sql);
            while(resultado.next()) {
                System.out.println("nombre: " + resultado.getString("nombre_miembro"));
            }
            resultado.close();
            instruccion.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
    }
}
