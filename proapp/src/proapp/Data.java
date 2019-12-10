package proapp;
import java.lang.String;
import java.util.ArrayList;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Data {
    private final SimpleStringProperty Assetcode;
    private final SimpleStringProperty Asset;
    private final SimpleStringProperty Admin;
    private final SimpleStringProperty Place;
    private final SimpleStringProperty Number;

    public Data(String Assetcode, String Asset, String Admin, String Place, String Number) {
        this.Assetcode = new SimpleStringProperty(Assetcode);
        this.Asset = new SimpleStringProperty(Asset);
        this.Admin = new SimpleStringProperty(Admin);
        this.Place = new SimpleStringProperty(Place);
        this.Number = new SimpleStringProperty(Number);
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

    public StringProperty NumberProperty() { return Number; }

    public String getAssetcode() {return Assetcode.get();}
    public String getAsset() {return Asset.get();}
    public String getAdmin() {return Admin.get();}
    public String getPlace() {return Place.get();}
    public String getNumber() {return Number.get();}

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
}

