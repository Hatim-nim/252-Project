
package hostingdonation;

// 50% funding startegy strategy, If the amount gathered were 50 % then consider the funding goal is fulfilled .
class IncrementalFundingStrategy implements FundingStrategy {
    @Override
    public boolean isFundingComplete(double collected, double needed) {
        return collected >= 0.5 * needed; // 50% of the needed amount
    }
}

