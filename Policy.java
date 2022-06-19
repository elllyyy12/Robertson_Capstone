import java.util.ArrayList;
import java.util.List;

public class Policy {

    private int policyNumber; //lines 6-11 declared variables
    private String effectiveDate;
    private String expirationDate;
    private PolicyHolder policyHolder;
    private List<Vehicle> vehicles;
    private double policyPremium;

    public Policy(int policyNumber, String effectiveDate, PolicyHolder policyHolder) { //created constructors with parameters.
        this.policyNumber = policyNumber;
        this.effectiveDate = effectiveDate;
        String[] Date = effectiveDate.split("/");
        int month = Integer.parseInt(Date[1] + 6);
        int year = Integer.parseInt(Date[2]);

        if (month > 12) {
            year += 1;
            month = month - 12;
        }

        vehicles = new ArrayList<>();
        expirationDate = Date[0] + "/" + month + "/" + year;
        this.policyHolder = policyHolder;
    }

    public int getPolicyNumber() { //lines 30-76 generated getters and setters. 
        return policyNumber;
    }

    public void setPolicyNumber(int policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public PolicyHolder getPolicyHolder() {
        return policyHolder;
    }

    public void setPolicyHolder(PolicyHolder policyHolder) {
        this.policyHolder = policyHolder;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public double getPolicyPremium() {
        return policyPremium;
    }

    public void setPolicyPremium(double policyPremium) {
        this.policyPremium = policyPremium;
    }

    public void addVehicles(Vehicle vehicle) {
        this.vehicles.add(vehicle);
    }

    @Override
    public String toString() {
        String veh = "";
        for (Vehicle vehicle: vehicles) { //for loop over all vehicles and storing their info in the "veh" variable.
            veh += "Vehicle Model: " + vehicle.getModel() + "\n";
        }

        return "Policy Number: " + policyNumber +
               "Effective Date: " + effectiveDate + "\n" +
               "Expiration Date: " + expirationDate + "\n" +
               "Policy Holder: " + policyHolder.getFirstName() + " " + policyHolder.getLastName() + "\n" +
               "Vehicles: " + "\n" + veh +
               "Policy Premium: " + policyPremium;
    }
}
