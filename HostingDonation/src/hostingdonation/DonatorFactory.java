
package hostingdonation;

// Factory Pattern: Centralizes the creation of Donator objects.
public class DonatorFactory {

    // Method to create a new Donator instance, takes the name as a parameter.
    public Donator createDonator(String name) {
        return new Donator(name); // return a new donator object instead of creating it at Donator side bcs this is Factory pattern
    }
}

