package hostingdonation;
// This class provides just additional functionality which is points per donations
public class RewardDonation extends Donation {
    private Donation originalDonation;
    
    public RewardDonation(Donation donation) {
        super(donation.getDonator(), donation.getAmount(), donation.getApp());
        this.originalDonation = donation;
    }

     // Override the getDetails method to add reward points information
     @Override
     public String getDetails() {
         // Calls the base class getDetails method and appends the reward points message
         return originalDonation.getDetails() + " and earned 10 reward points :)";
     }
}

