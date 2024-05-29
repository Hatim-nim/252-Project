package hostingdonation;
// This class "thanks" the user for donating to apps
public class SpecialThanksDonation extends Donation {
    private Donation originalDonation;
    
    public SpecialThanksDonation(Donation donation) {
        super(donation.getDonator(), donation.getAmount(), donation.getApp());
        this.originalDonation = donation;
    }

    // Adds a thank-you message to the donation details
    @Override
    public String getDetails() {
        return originalDonation.getDetails() + ". Special thanks for your generous support :)";
    }
}

