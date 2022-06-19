public class PolicyHolder {

    private String firstName; //lines 3-8 declared variables
    private String lastName;
    private String dateOfBirth;
    private String Address;
    private int licenseNumber;
    private String dateOfIssue;

    public PolicyHolder(String firstName, String lastName, String dateOfBirth, String address, int licenseNumber, String dateOfIssue) { 
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        Address = address;
        this.licenseNumber = licenseNumber;
        this.dateOfIssue = dateOfIssue;
    } //created constructor with parameters.

    public String getFirstName() { //lines 19-65 generated getters and setters
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public int getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(int licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getDateOfIssue() {
        return dateOfIssue;
    }

    public void setDateOfIssue(String dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    
}
