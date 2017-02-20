package mysql_project;

import java.sql.*;
import java.time.LocalDate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Database {

    private Connection connect;
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    private static final String CONNECTION = "jdbc:mysql://localhost:3306/user";
    private ObservableList<User> user;
    private ObservableList<Transport> transport;

    protected Connection connect() {
        connect = null;
        try {
            connect = DriverManager.getConnection(CONNECTION, USERNAME, PASSWORD);
            System.out.println("Connected!");
        } catch (SQLException err) {
            System.err.println(err);
        }
        return connect;
    }

    protected void insertUser(String names) {

        try {
            Statement stmt = (Statement) connect.createStatement();
            String insert = "INSERT INTO forwarders" + "(names)" + "VALUES ('" + names + "')";
            stmt.executeUpdate(insert);
        } catch (SQLException err) {
            System.err.println(err);
        }
    }

    protected void insertTrans(LocalDate date, String client, String carrier, String truck_no, int volume, double amount,
            double expenses, double profit, int forwarder_id) {
        try {
            Statement stmt = (Statement) connect.createStatement();
            String insert = "INSERT INTO transports" + "(date, client, carrier, truck_no, volume, amount, expenses, profit, frwd_id)"
                    + "VALUES ('" + date + "', '" + client + "', '" + carrier + "', '" + truck_no + "', '" + volume + "', '" + amount + "', '" + expenses + "', '" + profit + "', '" + forwarder_id + "')";
            stmt.executeUpdate(insert);
        } catch (SQLException err) {
            System.err.println(err);
        }
    }

    protected ObservableList<Transport> searchUser(int searchedEntry) {
        transport = FXCollections.observableArrayList();
        try {
            Statement stmt = (Statement) connect.createStatement();
            String query = "SELECT * FROM transports WHERE frwd_id='" + searchedEntry + "'";
            ResultSet result = stmt.executeQuery(query);

            while (result.next()) {

                transport.add(new Transport(result.getInt("id"), result.getDate("date").toString(), result.getString("client"), result.getString("carrier"),
                        result.getString("truck_no"), result.getInt("volume"),
                        result.getDouble("amount"), result.getDouble("expenses"),
                        result.getDouble("profit"), result.getInt("frwd_id")));
            }
        } catch (SQLException err) {
            System.err.println(err);
        }
        return transport;
    }

    protected ObservableList<User> getAllUserEntries() {
        user = FXCollections.observableArrayList();
        try {
            Statement stmt = (Statement) connect.createStatement();
            String query = "SELECT * FROM forwarders";
            ResultSet result = stmt.executeQuery(query);

            while (result.next()) {

                user.add(new User(result.getString("names"), result.getInt(result.findColumn("id"))));
            }
        } catch (SQLException err) {
            System.err.println(err);
        }
        return user;
    }

    protected ObservableList<Transport> getAllTransports() {
        transport = FXCollections.observableArrayList();
        try {
            Statement stmt = (Statement) connect.createStatement();
            String query = "SELECT * FROM transports";
            ResultSet result = stmt.executeQuery(query);

            while (result.next()) {

                transport.add(new Transport(result.getInt("id"), result.getDate("date").toString(), result.getString("client"), result.getString("carrier"),
                        result.getString("truck_no"), result.getInt("volume"),
                        result.getDouble("amount"), result.getDouble("expenses"),
                        result.getDouble("profit"), result.getInt("frwd_id")));
            }

        } catch (SQLException err) {
            System.err.println(err);
        }
        return transport;
    }
}
