package hostingdonation;
// This class acts like a wrapper class for Donation to ultimately add additional functionalities.
public abstract class DonationDecorator {
    protected Donation wrappedDonation;  // So here is the original Donation object.

    // Constructor to wrap a Donation object
    public DonationDecorator(Donation donation) {
        this.wrappedDonation = donation;
    }

    // Abstract method that must be implemented by concrete decorators to add or modify behavior
    public abstract String getDetails();
}
