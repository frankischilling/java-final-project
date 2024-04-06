---

# Java Final Project - Inventory Management System

A brief description of what this project does and who it's for. For example, "A JavaFX-based Inventory Management System designed to manage and categorize different types of items including books, electronics, and furniture."

## Getting Started

These instructions will get your copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

What things you need to install the software and how to install them:

- Java JDK 16 or newer
- JavaFX SDK (compatible with your Java version)
- An IDE that supports Java (e.g., IntelliJ IDEA, Lol who uses -> Eclipse)

### Installing

A step-by-step series of examples that tell you how to get a development environment running.

1. **Clone the repository**

```bash
git clone https://github.com/frankischilling/java-final-project.git
cd java-project-final-main
```

2. **Set up JavaFX**

Ensure that you have JavaFX configured in your project's library path.

- For IntelliJ IDEA, you can follow [this guide](https://openjfx.io/openjfx-docs/#install-java).
- For Eclipse, [this guide](https://openjfx.io/openjfx-docs/#IDE-Eclipse) might be helpful.

3. **Include the JavaFX modules**

Make sure to include the necessary JavaFX modules in your VM options:

```bash
--module-path /path/to/javafx-sdk-17/lib --add-modules javafx.controls,javafx.fxml
```

## Running the Application

To run the application, navigate to the `src/com/example/finalproject` directory and execute the `Application.java` file.

```bash
cd src/com/example/finalproject
java Application.java
```

This will launch the "Inventory Management System" GUI where you can manage and categorize items.

## Usage

### Adding Items

1. Select the type of item you want to add (Book, Electronics, Furniture) from the dropdown menu.
2. Fill in the required fields specific to the type of item.
3. Click the "Add" button to add the item to the inventory.

### Viewing Items

- The inventory list on the main screen displays all added items. Click on an item to view its details or to edit them.

### Editing Items

- After selecting an item, click the "Edit" button to modify its details. You can change any information except for the item's ID.


## Authors

- **Frank Hagan** - *Initial work* - [frankischilling](https://github.com/frankischilling)

## License

This project is licensed under the GPL-3.0 License - see the [LICENSE.md](LICENSE.md) file for details

## Acknowledgments

- Hat tip to anyone whose code was used
- getting this done in time for the class 
- etc

---
