
package hostingdonation;
// Factory Pattern: Simplifies object creation, here for App objects.
public class AppFactory {
       // Method to create App instances. Takes app details as parameters.
    public App createApp(String name, double amountNeeded) {
        return new App(name, amountNeeded);
    } 
}




