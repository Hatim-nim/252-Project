
package hostingdonation;

import java.util.List;

public class CreateAppCommand implements Command {
    private AppFactory appFactory;
    private String name;
    private double amountNeeded;
    private List<App> apps;

    public CreateAppCommand(AppFactory appFactory, String name, double amountNeeded, List<App> apps) {
        this.appFactory = appFactory;
        this.name = name;
        this.amountNeeded = amountNeeded;
        this.apps = apps;
    }

    // Create a new app and add it to the list
    @Override
    public void execute() { // we're making use of the creation of the app by making it a command.
        App app = appFactory.createApp(name, amountNeeded);
        apps.add(app);
        System.out.println("App created: " + app.getName());
    }
}

