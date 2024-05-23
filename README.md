# 252-Project
An app that signs new apps and make people donate to them in order to guarantee next hosting payment.

Donation Management System

This repository contains the implementation of a Donation Management System designed to manage donations for app hosting. The system is built with Java and utilizes several design patterns to structure the code effectively, ensuring that the application is maintainable, scalable, and flexible.
Design Patterns Used
1. Singleton Pattern

Purpose: Ensures that only one instance of the Admin class exists throughout the application. This pattern is crucial for managing centralized operations and maintaining consistent state across the system.

Implementation:

    The Admin class uses a private constructor and a static method to provide a global point of access to the single instance.

2. Factory Pattern

Purpose: Simplifies the object creation process, particularly for creating instances of App and Donator. It centralizes the creation logic to one location, making the process more manageable and consistent.

Implementation:

    AppFactory and DonatorFactory are used to create instances of App and Donator, respectively. This pattern helps decouple the construction of objects from the classes that use these objects.

3. Strategy Pattern

Purpose: Allows the behavior of the application to be selected at runtime. The App class uses this pattern to change the method by which funding status is checked.

Implementation:

    App objects can dynamically change their funding check strategy, allowing the use of different criteria to determine if funding is complete.

4. Observer Pattern

Purpose: Enables objects to receive updates about changes in other objects without being tightly coupled to them. This pattern is used in the system to notify interested parties (observers) when new donations are made.

Implementation:

    The App class implements the Observable interface and notifies all registered observers when a donation is added.

5. Command Pattern

Purpose: Encapsulates a request as an object, thereby letting users parameterize clients with queues, requests, and operations. Useful for undoing operations or maintaining a history of actions.

Implementation:

    Commands such as CreateAppCommand and ModifyAppCommand encapsulate all details of these operations and are executed when required. This allows for easy addition of new commands without changing existing code.

Getting Started

To get a local copy up and running, follow these simple steps:

bash

git clone https://github.com/your-username/your-repo-name.git
cd your-repo-name
# Run your application
java -jar YourApp.jar

Contributing

Contributions are what make the open-source community such an amazing place to learn, inspire, and create. Any contributions you make are greatly appreciated.

    Fork the Project
    Create your Feature Branch (git checkout -b feature/AmazingFeature)
    Commit your Changes (git commit -m 'Add some AmazingFeature')
    Push to the Branch (git push origin feature/AmazingFeature)
    Open a Pull Request

License

Distributed under the MIT License. See LICENSE for more information.
Contact

Your Name - @haisshin

Project Link: https://github.com/Hatim-nim/252-Project
