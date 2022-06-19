import java.util.ArrayList;
import java.util.List;

public class Customer {

    private int accountNumber; //Lines 6-11 declared a variable
    private String firstName;
    private String lastName;
    private String address;
    private List<Policy> policies;
    private List<PolicyHolder> holders;

    public Customer(int accountNumber, String firstName, String lastName, String address) { //create constructor with parameters.
        this.accountNumber = accountNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        policies = new ArrayList<>();
        holders = new ArrayList<>();
    }

    public int getAccountNumber() { //Lines 22 - 68 generated getters and setters
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getFirstName() {
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Policy> getPolicies() {
        return policies;
    }

    public void setPolicies(List<Policy> policies) {
        this.policies = policies;
    }

    public List<PolicyHolder> getHolders() {
        return holders;
    }

    public void setHolders(List<PolicyHolder> holders) {
        this.holders = holders;
    }

    public void addPolicy(Policy policy) {
        this.policies.add(policy);
    }

    public void addHolder(PolicyHolder holder) {
        this.holders.add(holder);
    }

    @Override
    public String toString() {

        String policiesS = "";
        for (Policy policy: policies) {
            policiesS += "Policy Number: " + policy.getPolicyNumber() + "\n" +
                         "Policy Holder Name: " + policy.getPolicyHolder().getFirstName() + " " + policy.getPolicyHolder().getLastName() + "\n";
        }

        return "Account Number: " + accountNumber + "\n" +
               "First Name: " + firstName + "\n" +
               "Last Name: " + lastName + "\n" +
               "Address: " + address + "\n" +
               "Policies: " + "\n" + policiesS;
    }
}