package mysql_project;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class User {

    private final SimpleStringProperty names;
    private final SimpleIntegerProperty id;

    protected User(String names, int id) {
        this.names = new SimpleStringProperty(names);
        this.id = new SimpleIntegerProperty(id);
    }

    public String getNames() {
        return names.get();
    }

    public void setNames(String setNames) {
        names.set(setNames);
    }

    public int getId() {
        return id.get();
    }

    public void setId(int setId) {
        id.set(setId);
    }
}
