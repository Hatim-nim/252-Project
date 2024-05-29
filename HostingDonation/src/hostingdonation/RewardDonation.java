package hostingdonation;
// This class provides just additional functionality which is points per donations
public class RewardDonation extends Donation {
    // Constructor wraps a Donation object.
    public RewardDonation(Donator donator, double amount, App app) {
        super(donator, amount, app);
    }

     // Override the getDetails method to add reward points information
     @Override
     public String getDetails() {
         // Calls the base class getDetails method and appends the reward points message
         return super.getDetails() + " and earned 10 reward points :)";
     }
}

