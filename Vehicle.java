public class Vehicle {
    
    private String Make; //lines 3-10 declared variables
    private String Model;
    private int year;
    private String Type;
    private String fuelType;
    private int purchasePrice;
    private String Color;
    private double premiumCharge;

    public Vehicle(String make, String model, int year, String type, String fuelType, int purchasePrice, String color) { //created constructors with parameters
        Make = make;
        Model = model;
        this.year = year;
        Type = type;
        this.fuelType = fuelType;
        this.purchasePrice = purchasePrice;
        Color = color;
    }

    public String getMake() { //lines 22-84 generated getters and setters.
        return Make;
    }

    public void setMake(String make) {
        Make = make;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public int getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(int purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    public double getPremiumCharge() {
        return premiumCharge;
    }

    public void setPremiumCharge(double premiumCharge) {
        this.premiumCharge = premiumCharge;
    }

    
}
