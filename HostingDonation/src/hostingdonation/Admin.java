
package hostingdonation;
// Singleton Pattern: Ensures that there is only one instance of the Admin class.
public class Admin {
        // Static variable to hold the single instance of the Admin class.
    private static Admin instance = new Admin();

    // Private constructor to prevent instantiation from outside the class.
    private Admin() {}

    // Public method to provide global access to the single instance.
    public static Admin getInstance() {
        return instance;
    }

    // Example method to manage apps (can be extended for other functionalities).
    public void manageApp() {
        // Implementation for managing apps.
    }
    
}
