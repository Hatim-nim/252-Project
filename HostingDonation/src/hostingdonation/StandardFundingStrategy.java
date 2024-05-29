
package hostingdonation;

// If the funding amount gathered was more or equal then consider the funding goal is met.
public class StandardFundingStrategy implements FundingStrategy {
    @Override
    public boolean isFundingComplete(double collected, double needed) {
        return collected >= needed; //return T or F
    }
}
