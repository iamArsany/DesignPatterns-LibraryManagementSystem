# Library Management System (Refactored)

This project is a refactored version of a flat Library Management System, using design-patterns architecture in Java.

## Getting Started

### Compilation

From the project root directory, run the following command to compile all files:

```bash
javac com/library/model/*.java com/library/observer/*.java com/library/factory/*.java com/library/decorator/*.java com/library/approval/*.java com/library/adapter/*.java com/library/service/*.java com/library/Main.java
```

### Run

Run the compiled `Main` class:

```bash
java com.library.Main
```

## Implemented Design Patterns

- **Facade (`LibraryService`)**: Simplifies the interaction between the system's components (Borrowing, Adding, Notifying).
- **Factory Method (`BookFactory`)**: Handles the instantiation of different book types (`EBook`, `PhysicalBook`).
- **Decorator (`PremiumBookDecorator`)**: Adds +10 days to a book's borrowing limit without modifying the base classes.
- **Chain of Responsibility (`Librarian` -> `Manager` -> `Director`)**: Handles the approval flow for borrowing requests based on the number of requested days.
- **Observer (`AvailabilityNotifier`, `User`)**: A notification system that alerts users when a book becomes available for borrowing.
- **Adapter (`ExternalBookAdapter`)**: Converts external JSON input into the internal `Book` entity.

## Project Structure

- `com.library.model`: Core entities (`Book`, `EBook`, `PhysicalBook`, `User`).
- `com.library.factory`: The `BookFactory`.
- `com.library.decorator`: Base and concrete decorators for book features.
- `com.library.approval`: The approval chain for borrowing requests.
- `com.library.observer`: The subject interface and the availability notifier.
- `com.library.adapter`: The adapter for external book data.
- `com.library.service`: The `LibraryService` (Facade).
- `com.library.Main`: Entry point for the application.
