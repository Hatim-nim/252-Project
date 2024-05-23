package hostingdonation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HostingDonation {
    private static Scanner scanner = new Scanner(System.in);
    private static AppFactory appFactory = new AppFactory();
    private static DonatorFactory donatorFactory = new DonatorFactory();
    private static List<App> apps = new ArrayList<>();
    private static List<Donator> donators = new ArrayList<>();
     private static boolean isAdmin = false; // changeable bcs user might not be admin

    public static void main(String[] args) {
        System.out.print("Are you an Admin? (yes/no): ");
        String adminResponse = scanner.nextLine().trim().toLowerCase(); // decide the user
        isAdmin = "yes".equals(adminResponse); // if he was admin then save it

        while (true) {
            System.out.println("*********************************");
            System.out.println("\n--------- Main Menu ---------");
            System.out.println("1. Manage Apps");
            System.out.println("2. Manage Donators");
            System.out.println("3. Exit");
            System.out.println("-------------------------------");
            System.out.println("*********************************"); // simple menu
            System.out.println("");
            System.out.print("Please enter your choice: ");
            int choice = getIntInput(); 

            switch (choice) {
                case 1:
                    manageApps();
                    break;
                case 2:
                    manageDonators();
                    break;
                case 3:
                    System.out.println("Exiting program...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Please try again."); // if any other choice chosen
            }
        }
    }
    // this method manages all related matters with apps
    private static void manageApps() { 
        while (true) {
            System.out.println("*********************************");
            System.out.println("\n--------- Manage Apps ---------"); // design can be changed later
            System.out.println("1. Create New App");
            System.out.println("2. View All Apps");

            if (isAdmin) { // if the user was admin, he could see the following choices (3 & 4)
                System.out.println("3. Modify App");
                System.out.println("4. Delete App");
                System.out.println("5. Return to Main Menu");
            System.out.println("-------------------------------");
            System.out.println("*********************************");    
            System.out.println("");                
            } else {// if the user was not an admin..
                System.out.println("3. Return to Main Menu"); 
            }
            System.out.print("Please enter your choice: ");
            System.out.println("");
            int choice = getIntInput();

            switch (choice) {
                case 1:
                    createApp(); // straight to creating an app
                    break;
                case 2:
                    viewAllApps(); // veiwing all apps
                    break;
                case 3:
                    if (isAdmin) { // can modify the app details if user was admin
                        modifyApp();
                    } else { 
                        return;
                    }
                    break;
                case 4:
                    if (isAdmin) {
                        deleteApp(); // can delete the app details if user was admin
                    }
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Please try again.");
            }
        }
    }
    // this method manages all related choices for donators
    private static void manageDonators() {
        while (true) {
            System.out.println("*********************************");
            System.out.println("\n--------- Manage Donators ---------");// menu
            System.out.println("1. Create New Donator"); 
            System.out.println("2. Make a Donation");
            System.out.println("3. View Donation History");
            if (isAdmin) {// again, if user was admin, he could see the two following choices
                System.out.println("4. Modify Donator");
                System.out.println("5. Delete Donator");
                System.out.println("6. Return to Main Menu");
            System.out.println("-------------------------------");
            System.out.println("*********************************");    
                System.out.println("");
            } else { // if he was not an admin then show the following choice instead 
                System.out.println("4. Return to Main Menu");
            System.out.println("-------------------------------");
            System.out.println("*********************************");
                System.out.println("");
            }
            System.out.print("Please enter your choice: ");
            int choice = getIntInput(); // user input

            switch (choice) {
                case 1:
                    createDonator(); // invokation for create method
                    break;
                case 2:
                    makeDonation(); // invokation for make a donation method
                    break;
                case 3:
                    viewDonationHistory(); // invokation..
                    break;
                case 4:
                    if (isAdmin) {
                        modifyDonator(); // can modify donators info if user was admin
                    } else {
                        return;
                    }
                    break;
                case 5:
                    if (isAdmin) {
                        deleteDonator(); // same as above but could delete instead
                    }
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Please try again.");
            }
        }
    }
    // method that returns the choice entered by user
    private static int getIntInput() {
        while (!scanner.hasNextInt()) {
            scanner.next(); // basically discard non integer values
            System.out.print("Please enter an integer: "); // Re-prompt
        }
        return scanner.nextInt();  // Return the correctly scanned integer
    }

    private static void createApp() {
        System.out.println("Enter app name: ");
        String name = scanner.next();
        System.out.println("Enter amount needed for hosting: ");
        double amountNeeded = scanner.nextDouble();
        scanner.nextLine(); // consume newline
        App app = appFactory.createApp(name, amountNeeded);
        apps.add(app);
        System.out.println("App created successfully.");
    }
    //method that return all apps created
    private static void viewAllApps() {
        if (apps.isEmpty()) { // if theres no apps, print out the following
            System.out.println("No apps created yet.");
        } else {
            for (App app : apps) { // print out all the apps
                System.out.println(app);
            }
        }
    }
    // method that return a new donator object
    private static void createDonator() {
        System.out.print("Enter donator name: ");
        String name = scanner.next();
        Donator donator = donatorFactory.createDonator(name); // Creating the object using the factory pattern
        donators.add(donator);
        System.out.println("Donator created successfully.");
    }
    // method that returns a new donation object
    private static void makeDonation() {
        if (apps.isEmpty()) { // if theres no apps to donate to..
            System.out.println("No apps available to donate to.");
            return;
        }
        System.out.print("Enter donator name: ");
        String name = scanner.next();
        Donator donator = donators.stream() //  search for and retrieve a specific Donator object from the list
                                  .filter(d -> d.getName().equals(name))
                                  .findFirst()
                                  .orElse(null);
        if (donator == null) { // null donator checker
            System.out.println("Donator not found.");
            return;
        }
        System.out.print("Enter app name for donation: ");
        String appName = scanner.next();
        App app = apps.stream() //  search for and retrieve a specific App object from the list
                      .filter(a -> a.getName().equals(appName))
                      .findFirst()
                      .orElse(null);
        if (app == null) { // null app checker
            System.out.println("App not found.");
            return;
        }
        System.out.print("Enter donation amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // consume newline
        if (amount > 0) {
            donator.donate(app, amount);
        } else {
            System.out.println("Invalid donation amount.");
        }
    }
    // method that prints out all the donations that were made by a donator
    private static void viewDonationHistory() {
        System.out.print("Enter donator name: ");
        String name = scanner.next();
        Donator donator = donators.stream() //  search for and retrieve a specific Donator object from the list
                                  .filter(d -> d.getName().equals(name))
                                  .findFirst()
                                  .orElse(null);
        if (donator == null) { // null donator checker
            System.out.println("Donator not found.");
        } else {
            donator.printDonationHistory(); //print..
        }
    }
    // method for the admin to modify the properties of an app
private static void modifyApp() {
    System.out.println("Enter the name of the app to modify:");
    String name = scanner.next().trim();
    //  search for and retrieve a specific App object from the list
    App app = apps.stream().filter(a -> a.getName().equals(name)).findFirst().orElse(null);

    if (app == null) { // null app chekcer
        System.out.println("App not found.");
        return;
    }

    System.out.print("Enter new amount needed for hosting: ");
    double amountNeeded = 0;
    boolean validInput = false;
    while (!validInput) {
        if (scanner.hasNextDouble()) {
            amountNeeded = scanner.nextDouble(); // read new amount needed to host the app
            scanner.nextLine();  // consume newline
            if (amountNeeded > 0) {
                validInput = true; // only set the amount if it was positive
                app.setAmountNeeded(amountNeeded);
                System.out.println("App hosting amount updated successfully!");
            } else {
                System.out.println("Please enter a positive number for the amount ");
            }
        } else {
            System.out.println("Please enter a valid number.");
            scanner.next();  // consume the non-double input
        }
    }

    // Ask if the user wants to change the funding strategy
    if (isAdmin) {
        System.out.println("Do you want to change the funding strategy for this app? (yes/no): ");
        String response = scanner.next().trim().toLowerCase();
        if ("yes".equals(response)) {
            changeFundingStrategy(app);
        }
    }
}
    // method thatsets new funding strategy 
private static void changeFundingStrategy(App app) {
    System.out.println("Select a new funding strategy:");
    System.out.println("1. Standard Funding Strategy");
    System.out.println("2. Incremental Funding Strategy (50% goal)");
    System.out.print("Enter your choice: ");
    int choice = getIntInput();
    switch (choice) {
        case 1:
            app.setFundingStrategy(new StandardFundingStrategy());
            System.out.println("Funding strategy set to Standard.");
            break;
        case 2:
            app.setFundingStrategy(new IncrementalFundingStrategy());
            System.out.println("Funding strategy set to Incremental (50%).");
            break;
        default:
            System.out.println("The number you entered was not a choice. So no changes made to the funding strategy.");
            break;
    }
}

    // method that remove an app 
    private static void deleteApp() {
    System.out.println("Enter the name of the app to delete:");
    String name = scanner.next();
    if (apps.removeIf(a -> a.getName().equals(name))) { // search then delete the app
        System.out.println("App deleted successfully.");
    } else {
        System.out.println("App not found.");
    }
}
    // method 
    private static void modifyDonator() {
    System.out.print("Enter the name of the donator to modify: ");
    String name = scanner.next();
    Donator donator = donators.stream().filter(d -> d.getName().equals(name)).findFirst().orElse(null);
    if (donator == null) {
        System.out.println("Donator not found.");
        return;
    }
    System.out.print("Enter new name for the donator: ");
    String newName = scanner.next();
    donator.setName(newName);
    System.out.println("Donator name updated successfully.");
}
    
    private static void deleteDonator() {
    System.out.print("Enter the name of the donator to delete: ");
    String name = scanner.next();
    if (donators.removeIf(d -> d.getName().equals(name))) {
        System.out.println("Donator deleted successfully.");
    } else {
        System.out.println("Donator not found.");
    }
}



}
