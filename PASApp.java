import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PASApp {
    public static void main(String[] args) {
        
        int response = 0; //Variable to take user input.
        Scanner scan = new Scanner(System.in); //to take user input.

        List<Customer> accounts = new ArrayList<>(); //List to hold all customers accounts.
        List<Policy> policies = new ArrayList<>(); //list to hold all policies.
        List<Claim> claims = new ArrayList<>(); //list to hold all claims. 

        while (response != 8) { //while loop till response is not 8.

            System.out.println("1. Create a new Customer Account\n" + //Menu
                               "2. Get a Policy quote and buy the policy.\n" +
                               "3. Cancel a specific policy.\n" +
                               "4. File an accident claim against a policy.\n" +
                               "5. Search for a customer account.\n" +
                               "6. Search for and display a specific policy.\n" +
                               "7. Search for and display a specific claim.\n" +
                               "8. Exit the PAS System."
            );
            scan.nextLine();
            System.out.println("What would you like to do? ");
            response = scan.nextInt();

            switch (response) {
                case 1 -> {
                    int number = 1000; //variable for policy number.
                    number++; //increment the number variable for policy number.
                    scan.nextLine();
                    System.out.println("Enter First Name: "); //user input
                    String firstName = scan.nextLine(); //get user input
                    System.out.println("Enter Last Name: "); //user input
                    String lastName = scan.nextLine(); //get user input
                    System.out.println("Enter Address: "); 
                    String address = scan.nextLine();
                    System.out.println("Account Number: " + number);
                    accounts.add(new Customer(number, firstName, lastName, address)); //adding customer account.
                    System.out.println();
                }

                case 2 -> {
                    System.out.println("Enter Account Number: ");
                    int number = scan.nextInt();
                    scan.nextLine();
                    boolean flag = false;
                    Customer customer = null;

                    for (Customer account: accounts) { //Iterating over all the accounts.
                        if (account.getAccountNumber() == number) { //if the given account number matches
                            flag = true;
                            customer = account;
                            break;
                        }
                    }

                    if (flag) { //if account is present.
                        PolicyHolder holder;
                        System.out.println("Are you the policy holder? ");
                        String check = scan.nextLine();

                        if (check.equals("Yes") || check.equals("yes")) { //if the customer is the policy holder.
                            System.out.println("Please Enter Birth Date (dd/mm/yyyy): "); //asking birth date in dd/mm/yyyy format e.g 12/02/1999
                            String dob = scan.nextLine();
                            System.out.println("Enter License Number: ");
                            int license = scan.nextInt();
                            scan.nextLine();
                            System.out.println("Please enter date of issuance (dd/mm/yyyy): ");
                            String doi = scan.nextLine();
                            holder = new PolicyHolder(customer.getFirstName(), customer.getLastName(), dob, customer.getAddress(), license, doi); //creating policy holder with the same customer details.
                        }
                        else { //if policy holder is someone else
                            System.out.println("Enter First Name: ");
                            String firstName = scan.nextLine();
                            System.out.println("Enter Last Name: ");
                            String lastName = scan.nextLine();
                            System.out.println("Enter Address: ");
                            String address = scan.nextLine();
                            System.out.println("Enter date of birth (mm/dd/yyyy): ");
                            String dob = scan.nextLine();
                            System.out.println("Enter License number: ");
                            int license = scan.nextInt();
                            scan.nextLine();
                            System.out.println("Please Enter date of issuance: ");
                            String doi = scan.nextLine();
                            holder = new PolicyHolder(firstName, lastName, dob, address, license, doi);
                        }
                        System.out.println("Enter Policy Number: ");
                        int policyNumber = scan.nextInt();
                        scan.nextLine();
                        System.out.println("Enter Effective Date (dd/mm/yyyy): ");
                        String effectiveDate = scan.nextLine();
                        Policy policy = new Policy(policyNumber, effectiveDate, holder); //creating new policy
                        policy.addVehicles(inputVehicle(scan)); //asking for the user to add vehicle.
                        int flag2 = -1;
                        while (flag2 != 0) { //Asking to add vehicle until user enters 0 for no.
                            System.out.println("Do you want to add more vehicles? If no, Enter 0.");
                            flag2 = scan.nextInt();
                            scan.nextLine();
                            if (flag2 != 0 ) {
                                policy.addVehicles(inputVehicle(scan));
                            }
                        }
                        RatingEngine.premiumGenerator(policy); //Setting policy premium with rating engine
                        System.out.println("The cost of the policy is " + policy.getPolicyPremium());
                        System.out.println("Do you want to purchase it? (Press 1 = Yes, Press 0 = No)");
                        int yesOrNo = scan.nextInt();

                        if (yesOrNo == 1) {
                            policies.add(policy);
                            customer.addPolicy(policy);
                            System.out.println("Policy is added to the Customer Account.");
                        }
                        else if (yesOrNo == 0) {
                            System.out.println("Policy Cancelled.");
                        }
                        else {
                            System.out.println("You Entered wrong input.");
                        }
                    } else {
                        System.out.println("Acccount does not exist.");
                    }
                    System.out.println();
                }

                case 3 -> {
                    System.out.println("Enter Policy Number: ");
                    int number = scan.nextInt();
                    boolean flag = false;

                    for (Customer account: accounts) {
                        for (Policy policy: account.getPolicies()) {
                            if (policy.getPolicyNumber() == number) {
                                Date date = new Date();
                                policy.setExpirationDate(date.getDate() + "/" +
                                                         date.getMonth() + "/" +
                                                         (date.getYear() + 1900)); //Setting expiration date of policy to current date.
                                System.out.println("Policy is cancelled.");
                                flag = true;
                                break;
                            }
                            if (flag) {
                                break;
                            }
                        }
                            if (!flag) {
                                System.out.println("No policy with the given number.");
                            }
                    }
                    System.out.println();
                }

                case 4 -> {
                    System.out.println("Enter Policy Number: ");
                    int number = scan.nextInt();
                    scan.nextLine();
                    boolean flag = false;

                    for (Customer account: accounts) {
                        for (Policy policy: account.getPolicies()) {
                            if (policy.getPolicyNumber() == number) {
                                System.out.println("Enter Claim Number: ");
                                System.out.println("C");
                                String claimNumber = "C" + scan.nextLine();
                                scan.nextLine();
                                System.out.println("Enter Accident Date in dd/mm/yyyy format: ");
                                String accidentDate = scan.nextLine();
                                System.out.println("Enter Accident Address: ");
                                String address = scan.nextLine();
                                System.out.println("Enter Description of Accident: ");
                                String descriptionAccident = scan.nextLine();
                                System.out.println("Enter Description of damage to vehicle: ");
                                String description = scan.nextLine();
                                System.out.println("Enter Estimated Cost: ");
                                int cost = scan.nextInt();
                                scan.nextLine();
                                claims.add(new Claim(claimNumber, accidentDate, address, description, descriptionAccident, cost));
                                System.out.println("Claim is Added succesfully.");
                                flag = true;
                                break;
                            }
                        }
                        if (flag) {
                            break;
                        }
                    }
                        if (flag) {
                            System.out.println("No policy with the given number.");
                        }
                        System.out.println();
                }

                case 5 -> {
                    scan.nextLine();
                    System.out.println("Enter First Name: ");
                    String firstName = scan.nextLine();
                    System.out.println("Enter Last Name: ");
                    String lastName = scan.nextLine();
                    boolean flag = false;

                    for (Customer account: accounts) {
                        if (account.getFirstName().equalsIgnoreCase(firstName) && account.getLastName().equalsIgnoreCase(lastName)) {
                            System.out.println(account);
                            flag = true;
                            break;
                        }
                    }
                    if (!flag) {
                        System.out.println("No Customer Account with the given name.");
                    }
                    System.out.println();
                }
                
                case 6 -> {
                    System.out.println("Enter Policy Number: ");
                    int number = scan.nextInt();
                    boolean flag = false;

                    for (Policy policy: policies) {
                        if (policy.getPolicyNumber() == number) {
                            System.out.println(policy);
                            flag = true;
                            break;
                        }
                    }
                    if (!flag) {
                        System.out.println("No Policy with the given number.");
                    }
                    System.out.println();
                }

                case 7 -> {
                    System.out.println("Enter Claim Number: ");
                    System.out.println("C");
                    String number = "C" + scan.nextLine();
                    scan.nextLine();
                    boolean flag = false;

                    for (Claim claim: claims) {
                        if (claim.getClaimNumber().equalsIgnoreCase(number)) {
                            System.out.println(claim);
                            flag = true;
                            break;
                        }
                    }
                    if (!flag) {
                        System.out.println("No Claim number with the given number.");
                    }
                    System.out.println();
                }
                case 8 -> {
                    System.out.println("Thank you for using PAS System.");
                }
                default -> {
                    System.out.println("Please Choose from the given options.");
                }
            }
        }
    }

    public static Vehicle inputVehicle(Scanner scan) { //method to input vehicle details and returning that vehicle.
        System.out.println("Enter make of Vehicle: ");
        String make = scan.nextLine();
        System.out.println("Enter Model of Vehicle: ");
        String model = scan.nextLine();
        System.out.println("Enter year of Vehicle: ");
        int year = scan.nextInt();
        scan.nextLine();
        System.out.println("Enter type of Vehicle (2-Door sportscar, 4-Door sedan, suv)");
        String type = scan.nextLine();
        System.out.println("Enter Fuel Type: ");
        String fuel = scan.nextLine();
        System.out.println("Enter purchase price of the Vehicle: ");
        int purchase = scan.nextInt();
        scan.nextLine();
        System.out.println("Enter the Color of Vehicle: ");
        String color = scan.nextLine();
        return new Vehicle(make, model, year, type, fuel, purchase, color);
    }
}


