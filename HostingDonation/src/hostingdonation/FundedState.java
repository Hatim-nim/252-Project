package hostingdonation;

public class FundedState implements State{
    @Override
    public void handleFunding(App context) {
        System.out.println(context.getName() + " has reached its funding goal. No further donations needed.");
    }
}
