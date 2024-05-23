
package hostingdonation;


public interface Observable {
        // Add an observer to the list
    void addObserver(Observer o);

    // Remove an observer from the list
    void removeObserver(Observer o);

    // Notify all observers about an update
    void notifyObservers(Object arg);
    
}
