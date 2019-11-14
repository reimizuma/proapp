package proapp;

public class Data {
    private String Assetcode;
    private String Asset;
    private String Admin;
    private String Place;
    private String Number;

    public Data(String Assetcode, String Asset, String Admin, String Place, String Number) {
        this.Assetcode = Assetcode;
        this.Asset = Asset;
        this.Admin = Admin;
        this.Place = Place;
        this.Number = Number;
    }

    public String getAssetcode() {
        return Assetcode;
    }

    public String getAsset() {
        return Asset;
    }

    public String getAdmin() {
        return Admin;
    }

    public String getPlace() {
        return Place;
    }

    public String getNumber() {
        return Number;
    }

    public void setAssetcode(String Assetcode) {
        this.Assetcode = Assetcode;
    }

    public void setAsset(String Asset) {
        this.Asset = Asset;
    }

    public void setAdmin(String Admin) {
        this.Admin = Admin;
    }

    public void setPlace(String Place) {
        this.Place = Place;
    }

    public void setNumber(String Number) {
        this.Number = Number;
    }
}

