
package hostingdonation;


public class DonationNotifier implements Observer { 
    // Reacts to updates from Observable (App)
    @Override // Automatic broadcasting to all interseted objects 
    public void update(Observable o, Object arg) {
        if (o instanceof App) { // if a donation was made then print these info
            System.out.println("New donation of " + arg + " received by " + ((App) o).getName());
        }
    }
}

