# HostingDonations (CPIT 252)

## Description
HostingDonations, also known as a Donation Management System, is designed to manage donations for app hosting. This system enables users to register new apps and encourage people to donate to them, ensuring these apps can afford their next hosting period.

## Features
- Register new applications to receive donations.
- Facilitate and manage donations towards hosting fees.
- Maintain consistent application operation through managed hosting fees.

## Design Patterns Used
This project utilizes several well-known design patterns to improve code manageability and scalability:

### Singleton Pattern
- **Purpose**: Ensures that only one instance of the Admin class exists throughout the application.
- **Implementation**: The `Admin` class uses a private constructor and a static method to provide a global point of access to the single instance.

### Factory Pattern
- **Purpose**: Simplifies the object creation process for creating instances of `App` and `Donator`.
- **Implementation**: `AppFactory` and `DonatorFactory` are utilized to create instances, decoupling the creation process from the business logic.

### Strategy Pattern
- **Purpose**: Allows the behavior of the application, specifically how funding status is checked, to be selected at runtime.
- **Implementation**: `App` objects dynamically change their funding check strategy, facilitating the use of different criteria to determine if funding is complete.

### Observer Pattern
- **Purpose**: Enables objects to receive updates about changes in other objects.
- **Implementation**: The `App` class implements the `Observable` interface and notifies all registered observers when a donation is added.

### Command Pattern
- **Purpose**: Encapsulates a request as an object, letting users parameterize clients with different requests.
- **Implementation**: Commands such as `CreateAppCommand` and `ModifyAppConsoleCommand` encapsulate operation details and are executed as required.

### Decorator Pattern
- **Purpose**: Adds new functionality to an existing object without altering its structure.
- **Implementation**: Donations can be wrapped with additional features like rewards and special thanks dynamically at runtime.

### State Pattern
- **Purpose**: Allows an object to alter its behavior when its internal state changes.
- **Implementation**: The `App` class changes its behavior based on its hosting funding status.

### Proxy Pattern
- **Purpose**: Controls access to another object, performing tasks like security checks or logging before forwarding requests.
- **Implementation**: The `ProxyWriteTXT` class performs authorization checks before delegating write operations to `RealWriteTXT`.

## Technologies
- Visual Studio Code (VSCode)
## Reference Used
- Dr. Khalid's Software Design Patterns
- Java Object-Oriented Programming (OOP)
- GitHub for version control
- [Refactoring Guru](https://refactoring.guru) for design pattern references

## Installation
```bash
git clone https://github.com/Hatim-nim/252-Project.git
cd 252-Project
```

## contributors

- Hamza Sebaih
- Hatim Alharbi
- Amr Mahmoud
- Wael Alkiyani 


License

This project is a college group project and does not currently include a specific license.
Contact

  

Project Link: https://github.com/Hatim-nim/252-Project
