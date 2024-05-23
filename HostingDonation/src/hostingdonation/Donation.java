
package hostingdonation;

import java.util.Date;

public class Donation {
    private Donator donator;
    private double amount;
    private App app;
    private Date date; // To track when the donation was made.

    public Donation(Donator donator, double amount, App app) {
        this.donator = donator;
        this.amount = amount;
        this.app = app;
        this.date = new Date(); // Sets the current date/time for the donation.
    }

    // Getter methods 
    public Donator getDonator() {
        return donator;
    }

    public double getAmount() {
        return amount;
    }

    public App getApp() {
        return app;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Donation{" +
               "donator=" + donator.getName() +
               ", amount=" + amount +
               ", app=" + app.getName() +
               ", date=" + date +
               '}';
    }
}

