
package hostingdonation;


public class ModifyAppCommand implements Command {
    private App app;
    private double newAmount;

    public ModifyAppCommand(App app, double newAmount) {
        this.app = app;
        this.newAmount = newAmount;
    }

    // Modify the amount needed for an existing app
    @Override
    public void execute() {
        app.setAmountNeeded(newAmount);
        System.out.println("App modified: " + app.getName() + ", new amount: " + newAmount);
    }
}

