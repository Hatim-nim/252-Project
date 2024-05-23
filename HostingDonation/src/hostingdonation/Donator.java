
package hostingdonation;

import java.util.ArrayList;
import java.util.List;

public class Donator {
    private String name;
    private List<Donation> donations;

    public Donator(String name) {
        this.name = name;
        this.donations = new ArrayList<>();
    }

    // Method to make a donation to an app
    public void donate(App app, double amount) {
        if (amount > 0) {
            Donation donation = new Donation(this, amount, app);
            donations.add(donation);
            app.addDonation(amount);
            System.out.println("Donated " + amount + " to " + app.getName());
        } else {
            System.out.println("Invalid donation amount.");
        }
    }

    // Retrieve and print the donation history
    public void printDonationHistory() {
        if (donations.isEmpty()) {
            System.out.println(name + " has not made any donations yet.");
        } else {
            System.out.println(name + "'s Donation History:");
            for (Donation donation : donations) {
                System.out.println("Donated " + donation.getAmount() + " to " + donation.getApp().getName());
            }
        }
    }

    // Getters for name and donations
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
    public List<Donation> getDonations() {
        return donations;
    }
}
