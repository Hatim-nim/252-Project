
package hostingdonation;

import java.util.ArrayList;
import java.util.List;

public class App implements Observable{
        private List<Observer> observers = new ArrayList<>();
    private String name;
    private State currentState;
    private double amountNeeded;
    private double totalCollected = 0;
    private FundingStrategy fundingStrategy; // chosen later on

    // Constructor no longer requires a funding strategy as a parameter
    public App(String name, double amountNeeded) {
        this.name = name;
        this.amountNeeded = amountNeeded;
        this.fundingStrategy = new StandardFundingStrategy(); // forced standard unless someone wants to change it
        this.currentState = new PendingState();  // Default initial state
    }
    
    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers(Object arg) {
        for (Observer observer : observers) {
            observer.update(this, arg); // Notify each observer about a new donation
        }
    }

    // Method to add donations to the total collected amount
    public void addDonation(double amount) {
        totalCollected += amount;
        checkFundingStatus();
        // The following line is part of the Observer pattern
        notifyObservers(amount);  // Notify observers when a donation is made
        currentState.handleFunding(this);  // Delegate to current state
    }

    // Check funding status using the fixed strategy.
    private void checkFundingStatus() {
    if (fundingStrategy != null && fundingStrategy.isFundingComplete(totalCollected, amountNeeded)) {
        System.out.println(name + " has reached its funding goal!");
    } else {
        System.out.println("Funding strategy not set or goal not reached.");
    }
    }
    
        // Method to change the funding strategy at runtime.
    public void setFundingStrategy(FundingStrategy strategy) {
        this.fundingStrategy = strategy;
    }

    public void setState(State newState) {
        this.currentState = newState;  // Set the new state
    }

    
    
        public String getName() {
        return name;
    }

    public double getAmountNeeded() {
        return amountNeeded;
    }

    public void setAmountNeeded(double amountNeeded) {
        this.amountNeeded = amountNeeded;
    }

    public double getTotalCollected() {
        return totalCollected;
    }

    public void setTotalCollected(double totalCollected) {
        this.totalCollected = totalCollected;
    }
        
    @Override
    public String toString() {
        return "App{" +
               "name='" + name + '\'' +
               ", amountNeeded=" + amountNeeded +
               ", totalCollected=" + totalCollected +
               ", State=" + currentState.getDescription() +
               '}';
    }

    public String getCurrentStateDescription() {
        return currentState.getDescription();  // Return the current state description
    }
}

