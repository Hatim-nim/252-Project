package hostingdonation;
// This class "thanks" the user for donating to apps
public class SpecialThanksDonation extends Donation {
    // Constructor wraps a Donation object
    public SpecialThanksDonation(Donator donator, double amount, App app) {
        super(donator, amount, app); // passing parameters to super class
    }

    // Adds a special thank-you message to the donation details
    @Override
    public String getDetails() {
        return super.getDetails() + ". Special thanks for your generous support :)";
    }
}

