package mx.edu.j2se.Guerrero;

import java.sql.*;

public class ConnectionDB {
    private static final String URL = "jdbc:mysql://localhost:3306/carrental?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String USER = "root";
    private static final String PASSWORD = "9270";

    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(URL,USER,PASSWORD);
    }

    public static void close(ResultSet rs) throws SQLException{
        rs.close();
    }

    public static void close(PreparedStatement stm) throws SQLException{
        stm.close();
    }

    public static void close(Connection conn) throws SQLException{
        conn.close();
    }
}
