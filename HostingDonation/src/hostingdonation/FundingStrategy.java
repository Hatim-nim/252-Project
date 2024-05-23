
package hostingdonation;

// Strategy Pattern: Allows dynamic change in the method for funding checks.
// Basically, has methods for checking if funding is met or no.
public interface FundingStrategy {
    boolean isFundingComplete(double collected, double needed);
}





