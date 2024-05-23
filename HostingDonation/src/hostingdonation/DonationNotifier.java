
package hostingdonation;


public class DonationNotifier implements Observer {
    // Reacts to updates from Observable (App)
    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof App) {
            System.out.println("New donation of " + arg + " received by " + ((App) o).getName());
        }
    }
}

