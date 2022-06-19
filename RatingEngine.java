import java.util.Date;
import java.text.DecimalFormat;

public class RatingEngine {
    
    public static void premiumGenerator(Policy policy) {

        double premium = 0;
        DecimalFormat format = new DecimalFormat("0.00");

        for (Vehicle vehicle: policy.getVehicles()) { //Iterating over all the vehicles
            int vp = vehicle.getPurchasePrice(); //Vehicle purchase price
            double vpf; //vehicle price factor

            if (vehicle.getYear() < 1) {
                vpf = 0.01;
            }
            else if (vehicle.getYear() < 3) {
                vpf = 0.008;
            }
            else if (vehicle.getYear() < 5) {
                vpf = 0.007;
            }
            else if (vehicle.getYear() < 10) {
                vpf = 0.006;
            }
            else if (vehicle.getYear() < 15) {
                vpf = 0.004;
            }
            else if (vehicle.getYear() < 20) {
                vpf = 0.002;
            }
            else {
                vpf = 0.001;
            }

            Date date = new Date();
            int currentYear = date.getYear() + 1900; //getting the current year.
            int dlx = currentYear - Integer.parseInt(policy.getPolicyHolder().getDateOfIssue().split("/")[2]); //Calculating number of years.
            vehicle.setPremiumCharge(Double.parseDouble(format.format((vp * vpf) + ((vp / 100.0) / dlx)))); //setting premium for that vehicle.
            premium += vehicle.getPremiumCharge(); //Adding premium for each vehicle.
        }

            policy.setPolicyPremium(Double.parseDouble(format.format(premium))); //Setting premium for the policy.
    }
}
