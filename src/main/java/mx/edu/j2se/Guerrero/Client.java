package mx.edu.j2se.Guerrero;

public class Client {
    private int idClient;
    private String nameClient;
    private String lastName;
    private String phone;

    public Client() {}

    public Client(int idClient) {
        this.idClient = idClient;
    }

    public Client(String nameClient, String lastName, String phone) {
        this.nameClient = nameClient;
        this.lastName = lastName;
        this.phone = phone;
    }

    public Client(int idClient, String nameClient, String lastName, String phone) {
        this.idClient = idClient;
        this.nameClient = nameClient;
        this.lastName = lastName;
        this.phone = phone;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getNameClient() {
        return nameClient;
    }

    public void setNameClient(String nameClient) {
        this.nameClient = nameClient;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Client{" +
                "idClient=" + idClient +
                ", nameClient='" + nameClient + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}