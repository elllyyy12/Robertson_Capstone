public class Claim {
    
    private String claimNumber; //lines 3-8 declared variables 
    private String accidentDate;
    private String address;
    private String description;
    private String descriptionAccident;
    private int estimatedCostPrice;

    public Claim(String claimNumber, String accidentDate, String address, String description, String descriptionAccident, int estimatedCostPrice) {
        this.claimNumber = claimNumber;
        this.accidentDate = accidentDate;
        this.address = address;
        this.description = description;
        this.descriptionAccident = descriptionAccident;
        this.estimatedCostPrice = estimatedCostPrice;
    } //created constructor with parameters

    public String getClaimNumber() { //lines 19-65 generated getters and setters.
        return claimNumber;
    }

    public void setClaimNumber(String claimNumber) {
        this.claimNumber = claimNumber;
    }

    public String getAccidentDate() {
        return accidentDate;
    }

    public void setAccidentDate(String accidentDate) {
        this.accidentDate = accidentDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescriptionAccident() {
        return descriptionAccident;
    }

    public void setDescriptionAccident(String descriptionAccident) {
        this.descriptionAccident = descriptionAccident;
    }

    public int getEstimatedCostPrice() {
        return estimatedCostPrice;
    }

    public void setEstimatedCostPrice(int estimatedCostPrice) {
        this.estimatedCostPrice = estimatedCostPrice;
    }

    @Override
    public String toString() {
        return "Claim Number: " + claimNumber + "\n" +
               "Accident Date: " + accidentDate + "\n" +
               "Address: " + address + "\n" +
               "Description of Damage: " + description + "\n" +
               "Description of Accident: " + descriptionAccident + "\n" +
               "Estimated Cost Price: " + estimatedCostPrice; 
    }
}
