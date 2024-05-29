package hostingdonation;

public class PendingState implements State{
    @Override
    public void handleFunding(App context) {
        if (context.getTotalCollected() >= context.getAmountNeeded()) {
            context.setState(new FundedState());
            System.out.println(context.getName() + " is now fully funded.");
        }
    } 
}
