package hostingdonation;

public class FundedState implements State{
    @Override
    public void handleFunding(App context) {
        System.out.println(context.getName() + " has reached its funding goal. No further donations needed. ");
    }
// if a full donation were to be made, its state would be fully funded
    @Override
    public String getDescription() {
        return "Fully Funded";
    }
}
