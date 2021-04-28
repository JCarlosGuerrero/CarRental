package mx.edu.j2se.Guerrero;

        import java.sql.Connection;
        import java.sql.PreparedStatement;
        import java.sql.ResultSet;
        import java.sql.SQLException;
        import java.util.ArrayList;
        import java.util.List;

        import static mx.edu.j2se.Guerrero.ConnectionDB.close;
        import static mx.edu.j2se.Guerrero.ConnectionDB.getConnection;

public class TypeVehicleDAO {

    private static final String SQL_SELECT = "SELECT id_typevehicle, type_vehicle FROM type_vehicle";
    private static final String SQL_ORDER = "SELECT id_typevehicle, type_vehicle FROM type_vehicle ORDER BY ";
    private static final String SQL_FILTER = "SELECT id_typevehicle, type_vehicle FROM type_vehicle WHERE ";

    public List<TypeVehicle> select(){
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        TypeVehicle vehicle  = null;
        List<TypeVehicle> vehicles = new ArrayList<>();

        try {
            conn = getConnection();
            stm = conn.prepareStatement(SQL_SELECT);
            rs = stm.executeQuery();
            while(rs.next()) {
                int idTypeVehicle = rs.getInt("id_typevehicle");
                String typeVehicle = rs.getString("type_vehicle");

                vehicle = new TypeVehicle(idTypeVehicle,typeVehicle);
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

    public List<TypeVehicle> order(String column,String order) {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        TypeVehicle vehicle = null;
        List<TypeVehicle> vehicles = new ArrayList<>();

        try {
            conn = getConnection();
            stm = conn.prepareStatement(SQL_ORDER + column + " " + order);
            rs = stm.executeQuery();
            while(rs.next()) {
                int idTypeVehicle = rs.getInt("id_typevehicle");
                String typeVehicle = rs.getString("type_vehicle");

                vehicle = new TypeVehicle(idTypeVehicle,typeVehicle);
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

    public List<TypeVehicle> filter(String column,String value){
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        TypeVehicle vehicle = null;
        List<TypeVehicle> vehicles = new ArrayList<>();

        try {
            conn = getConnection();
            stm = conn.prepareStatement(SQL_FILTER + column + " = " + "'" + value + "'");
            rs = stm.executeQuery();
            while(rs.next()) {
                int idTypeVehicle = rs.getInt("id_typevehicle");
                String typeVehicle = rs.getString("type_vehicle");

                vehicle = new TypeVehicle(idTypeVehicle,typeVehicle);
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