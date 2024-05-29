package hostingdonation;

public interface State { // new interface for State pattern 
    void handleFunding(App context);

    String getDescription(); // implemented in FundedState and PendingState classes
}
