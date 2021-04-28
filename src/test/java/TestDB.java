import mx.edu.j2se.Guerrero.Client;
import mx.edu.j2se.Guerrero.ClientDAO;

import java.util.List;

public class TestDB {
    public static void main(String[] args) {
        ClientDAO clientDAO = new ClientDAO();
        List<Client> clients = clientDAO.filter("last_name","Guerrero");
        for (Client client: clients) {
            System.out.println("client = " + client);
        }
    }
}
