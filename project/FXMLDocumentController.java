package mysql_project;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class FXMLDocumentController implements Initializable {

    Database base = new Database();
    double sum = 0;
    @FXML
    private TextField names;
    @FXML
    private TextField client;
    @FXML
    private TextField carrier;
    @FXML
    private TextField truck_no;
    @FXML
    private TextField volume;
    @FXML
    private TextField amount;
    @FXML
    private TextField expenses;
    @FXML
    private TextField frwd_id;
    @FXML
    private TextField searchField;
    @FXML
    private Label msgTrans;
    @FXML
    private Label msgUser;
    @FXML
    private Label profitLable;
    @FXML
    private DatePicker date;
    @FXML
    private TableView<User> forwardersTable;
    @FXML
    private TableView<Transport> transportsTable;
    @FXML
    private TableColumn trans_id;
    @FXML
    private TableColumn col_date;
    @FXML
    private TableColumn col_client;
    @FXML
    private TableColumn col_carrier;
    @FXML
    private TableColumn col_no;
    @FXML
    private TableColumn col_volume;
    @FXML
    private TableColumn col_amount;
    @FXML
    private TableColumn col_expenses;
    @FXML
    private TableColumn col_profit;
    @FXML
    private TableColumn col_frwdID;
    @FXML
    private TableColumn col_names;
    @FXML
    private TableColumn frwdID;

    @FXML
    private void importTransport(ActionEvent event) {
        base.connect();
        double amountD = Double.parseDouble(amount.getText());
        double expensesD = Double.parseDouble(expenses.getText());
        int volumeInt = Integer.parseInt(volume.getText());
        int forwarder_id = Integer.parseInt(frwd_id.getText());
        double profit = amountD - expensesD;
        LocalDate localDate = date.getValue();

        insertTransport(localDate, client, carrier, truck_no, volumeInt, amountD, expensesD, profit, forwarder_id);
    }

    @FXML
    private void importUser(ActionEvent event) {
        base.connect();
        insertForwarder();
    }

    @FXML
    private void searchBtn(ActionEvent event) {
        base.connect();
        int id = Integer.parseInt(searchField.getText());
        transportsTable.setItems(base.searchUser(id));
        sum = 0;
        totalProfit();
    }

    private void insertForwarder() {
        base.insertUser(names.getText());
        getAllUsers();
        msgUser.setText("User imported!");
    }

    private void insertTransport(LocalDate localDate, TextField client, TextField carrier, TextField truck_no,
            int volume, double amount, double expenses, double profit, int forwarder_id) {

        base.insertTrans(localDate, client.getText(), carrier.getText(), truck_no.getText(), volume, amount,
                expenses, profit, forwarder_id);
        getAllTransports();
        msgTrans.setText("Transport imported!");
    }

    private void getAllUsers() {
        col_names.setCellValueFactory(new PropertyValueFactory("names"));
        frwdID.setCellValueFactory(new PropertyValueFactory("id"));

        forwardersTable.setItems(base.getAllUserEntries());
    }

    private void getAllTransports() {
        trans_id.setCellValueFactory(new PropertyValueFactory("id"));
        col_date.setCellValueFactory(new PropertyValueFactory("date"));
        col_client.setCellValueFactory(new PropertyValueFactory("client"));
        col_carrier.setCellValueFactory(new PropertyValueFactory("carrier"));
        col_no.setCellValueFactory(new PropertyValueFactory("truck_no"));
        col_volume.setCellValueFactory(new PropertyValueFactory("volume"));
        col_amount.setCellValueFactory(new PropertyValueFactory("amount"));
        col_expenses.setCellValueFactory(new PropertyValueFactory("expenses"));
        col_profit.setCellValueFactory(new PropertyValueFactory("profit"));
        col_frwdID.setCellValueFactory(new PropertyValueFactory("frwd_id"));
        transportsTable.setItems(base.getAllTransports());

        sum = 0;
        totalProfit();
    }

    private void totalProfit() {

        transportsTable.getItems().forEach(item -> {
            sum += item.getProfit();
            profitLable.setText("" + sum);
        });
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        base.connect();

        getAllUsers();
        getAllTransports();
    }
}
