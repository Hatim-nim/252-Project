package hostingdonation;

public class PendingState implements State{
    @Override
    public void handleFunding(App context) {
        if (context.getTotalCollected() >= context.getAmountNeeded()) {// if the total was equal or more then create a new funded state
            context.setState(new FundedState());
            System.out.println(context.getName() + " is now fully funded.");
        }
    }
    
    @Override
    public String getDescription() { // description for the pending state of the app
        return "Pending Funding";
    }
}
