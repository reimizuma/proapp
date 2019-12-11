package proapp;
import java.lang.String;
import java.util.ArrayList;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Data {
    private final SimpleStringProperty Assetcode;
    private final SimpleStringProperty Asset;
    private final SimpleStringProperty Admin;
    private final SimpleStringProperty Place;
    private final SimpleStringProperty Number;
    private final SimpleBooleanProperty Check;
    private final SimpleStringProperty Day;

    public Data(Boolean Check, String Assetcode, String Asset, String Admin, String Place, String Number, String Day) {
        this.Check = new SimpleBooleanProperty(Check);
        this.Assetcode = new SimpleStringProperty(Assetcode);
        this.Asset = new SimpleStringProperty(Asset);
        this.Admin = new SimpleStringProperty(Admin);
        this.Place = new SimpleStringProperty(Place);
        this.Number = new SimpleStringProperty(Number);
        this.Day = new SimpleStringProperty(Day);
    }

    public BooleanProperty CheckProperty() {
        return Check;
    }

    public StringProperty AssetcodeProperty() {
        return Assetcode;
    }

    public StringProperty AssetProperty() {
        return Asset;
    }

    public StringProperty AdminProperty() {
        return Admin;
    }

    public StringProperty PlaceProperty() {
        return Place;
    }

    public StringProperty DayProperty() {
        return Day;
    }

    public StringProperty NumberProperty() { return Number; }

    public boolean getCheck() {return Check.get();}
    public String getAssetcode() {return Assetcode.get();}
    public String getAsset() {return Asset.get();}
    public String getAdmin() {return Admin.get();}
    public String getPlace() {return Place.get();}
    public String getNumber() {return Number.get();}
    public String getDay() {return Day.get();}

    public void setCheck(Boolean Check) { this.Check.set(Check); }

    public void setAssetcode(String Assetcode) {
        this.Assetcode.set(Assetcode);
    }

    public void setAsset(String Asset) {
        this.Asset.set(Asset);
    }

    public void setAdmin(String Admin) {
        this.Admin.set(Admin);
    }

    public void setPlace(String Place) {
        this.Place.set(Place);
    }

    public void setNumber(String Number) {
        this.Number.set(Number);
    }
    public void setDay(String Day) {
        this.Day.set(Day);
    }
}

