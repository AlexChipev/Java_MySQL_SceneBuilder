
package mysql_project;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Transport {
    private final SimpleStringProperty client, carrier, truck_no;
    private final SimpleIntegerProperty volume, frwd_id, transportID;
    private final SimpleDoubleProperty amount, expenses, profit;
    private final SimpleStringProperty date;
 
    protected Transport(int transportID,String date, String client, String carrier, String truck_no, int volume, double amount, 
                        double expenses, double profit, int frwd_id) {
        this.client = new SimpleStringProperty(client);
        this.carrier = new SimpleStringProperty(carrier);
        this.truck_no = new SimpleStringProperty(truck_no);
        this.volume = new SimpleIntegerProperty(volume);
        this.amount = new SimpleDoubleProperty(amount);
        this.expenses = new SimpleDoubleProperty(expenses);
        this.profit = new SimpleDoubleProperty(profit);
        this.frwd_id = new SimpleIntegerProperty(frwd_id);
        this.transportID = new SimpleIntegerProperty(transportID);
        this.date = new SimpleStringProperty(date);
    }
     
    public int getTransportID() {
        return transportID.get();
    }
    public void setTransportID(int transportIDEntry) {
        transportID.set(transportIDEntry);
    }
    
    public String getDate() {
        return date.get();
    }
    public void setDate(String dateEntry) {
        date.set(dateEntry);
    }
    
    public String getClient() {
        return client.get();
    }
    public void setClient(String clientEntry) {
        client.set(clientEntry);
    }
        
    public String getCarrier() {
        return carrier.get();
    }
    public void setCarrier(String carrierEntry) {
        carrier.set(carrierEntry);
    }
    
    public String getTruck_no() {
        return truck_no.get();
    }
    public void setTruck_no(String truck_noEntry) {
        truck_no.set(truck_noEntry);
    }
    
    public int getVolume() {
        return volume.get();
    }
    public void setVolume(int volumeEntry) {
        volume.set(volumeEntry);
    }
    
    public double getAmount() {
        return amount.get();
    }
    public void setAmount(double amountEntry) {
        amount.set(amountEntry);
    }
    
    public double getExpenses() {
        return expenses.get();
    } 
    public void setExpenses(double expensesEntry) {
        expenses.set(expensesEntry);
    }
    
    public double getProfit() {
        return profit.get();
    }
    public void setProfit(double profitEntry) {
        profit.set(profitEntry);
    }
       
    public int getFrwdID() {
        return frwd_id.get();
    }
    public void setFrwdID(int frwd_idEntry) {
        frwd_id.set(frwd_idEntry);
    }
}
