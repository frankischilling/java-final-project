// thou who read this code may god have mercy on your soul
// i have no idea what i am doing
// i was forced to do this... im not a murderer i swear

package com.example.finalproject;

import com.example.finalproject.classes.*;
import com.example.finalproject.classes.Book;
import com.example.finalproject.classes.Electronics;
import com.example.finalproject.classes.Furniture;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.collections.FXCollections;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    // Add the @FXML annotation to the inventoryListView field
    @FXML
    private ListView<Item> inventoryListView;
    // Add the @FXML annotation to the nameField, quantityField, priceField, extraField, colorField, and typeComboBox fields
    @FXML
    private TextField nameField, quantityField, priceField, extraField, colorField;
    // Add the @FXML annotation to the typeComboBox field
    @FXML
    private ComboBox<String> typeComboBox;
    // Add the @FXML annotation to the modelIdField field
    @FXML
    private TextField modelIdField;
    // Add the @FXML annotation to the subGroupComboBox field
    @FXML
    private ComboBox<String> subGroupComboBox;
    // Add the @FXML annotation to the pagesField field
    @FXML
    private TextField pagesField;
    @FXML
    private TextField descriptionField, publisherField, warrantyPeriodField, dimensionsField;
    @FXML
    private TextField searchField;

    private ObservableList<Item> allItems = FXCollections.observableArrayList();

    // Add the @FXML annotation to the addButton field
    public void refreshListView() {
        // Clear the ListView
        inventoryListView.getItems().clear();

        // Add all items back to the ListView
        inventoryListView.getItems().addAll(allItems);

        // Sort the items by the numerical part of their ID
        inventoryListView.getItems().sort((item1, item2) -> {
            int id1 = Integer.parseInt(item1.getId().substring(4)); // Extract the numerical part of the ID
            int id2 = Integer.parseInt(item2.getId().substring(4)); // Extract the numerical part of the ID
            return Integer.compare(id1, id2); // Compare the numerical parts
        });
    }
    private void clearFields() {
        nameField.clear();
        quantityField.clear();
        priceField.clear();
        extraField.clear();
        colorField.clear();
        modelIdField.clear();
        descriptionField.clear();
        publisherField.clear();
        warrantyPeriodField.clear();
        dimensionsField.clear();

        if (!"Book".equals(typeComboBox.getValue())) {
            subGroupComboBox.getItems().clear();
            subGroupComboBox.setValue("");
            pagesField.clear();
        }

        if (!"Electronics".equals(typeComboBox.getValue()) && !"Furniture".equals(typeComboBox.getValue())) {
            subGroupComboBox.getItems().clear();
        }

        if (!"Furniture".equals(typeComboBox.getValue())) {
            subGroupComboBox.getItems().clear();
            colorField.clear();
            modelIdField.clear();
            warrantyPeriodField.clear();
            dimensionsField.clear();
        }
    }

    @FXML
    protected void onTypeSelected() {
        // Clear the text fields
        nameField.clear();
        quantityField.clear();
        priceField.clear();
        extraField.clear();
        colorField.clear();
        modelIdField.clear();
        descriptionField.clear();
        publisherField.clear();
        warrantyPeriodField.clear();
        dimensionsField.clear();
        subGroupComboBox.getItems().clear();
        subGroupComboBox.setValue(null);
        subGroupComboBox.setVisible(false);
        subGroupComboBox.setDisable(true);
        subGroupComboBox.setEditable(true);
        inventoryListView.getSelectionModel().clearSelection();

        // Enable the text fields
        switch (typeComboBox.getValue()) {
            // Enable the extraField and subGroupComboBox
            case "Book":
                extraField.setPromptText("Author");
                extraField.setManaged(true);
                extraField.setVisible(true);
                colorField.setManaged(false);
                colorField.setVisible(false);
                modelIdField.setManaged(false);
                modelIdField.setVisible(false);
                subGroupComboBox.setManaged(true);
                subGroupComboBox.setVisible(true);
                subGroupComboBox.setDisable(false);
                subGroupComboBox.getItems().addAll("Non-fiction", "Fiction");
                pagesField.setManaged(true);
                pagesField.setVisible(true);
                pagesField.setPromptText("Number of pages");
                descriptionField.setManaged(true);
                descriptionField.setVisible(true);
                publisherField.setManaged(true);
                publisherField.setVisible(true);
                warrantyPeriodField.setManaged(false);
                warrantyPeriodField.setVisible(false);
                dimensionsField.setManaged(false);
                dimensionsField.setVisible(false);


                break;
            // Enable the extraField, colorField, modelIdField and subGroupComboBox
            case "Electronics":
                extraField.setPromptText("Brand");
                extraField.setDisable(false);
                colorField.setPromptText("Color");
                colorField.setVisible(true);
                colorField.setManaged(true);
                modelIdField.setPromptText("Model ID");
                modelIdField.setVisible(true);
                modelIdField.setManaged(true);
                pagesField.setVisible(false);
                pagesField.setManaged(false);
                pagesField.setPromptText("");
                subGroupComboBox.setVisible(true);
                subGroupComboBox.setDisable(false);
                subGroupComboBox.getItems().addAll("TV", "Laptop", "Phone");
                descriptionField.setManaged(true);
                descriptionField.setVisible(true);
                publisherField.setManaged(false);
                publisherField.setVisible(false);
                warrantyPeriodField.setManaged(true);
                warrantyPeriodField.setVisible(true);
                dimensionsField.setManaged(false);
                dimensionsField.setVisible(false);
                break;
            // Enable the extraField, colorField and subGroupComboBox
            case "Furniture":
                extraField.setPromptText("Material");
                extraField.setDisable(false);
                colorField.setPromptText("Color");
                colorField.setVisible(true);
                colorField.setManaged(true);
                modelIdField.setPromptText("");
                modelIdField.setVisible(false);
                modelIdField.setManaged(false);
                pagesField.setVisible(false);
                pagesField.setManaged(false);
                pagesField.setPromptText("");
                subGroupComboBox.setVisible(true);
                subGroupComboBox.setDisable(false);
                subGroupComboBox.getItems().addAll("Chair", "Table", "Desk", "Bed", "Sofa");
                descriptionField.setManaged(true);
                descriptionField.setVisible(true);
                publisherField.setManaged(false);
                publisherField.setVisible(false);
                warrantyPeriodField.setManaged(false);
                warrantyPeriodField.setVisible(false);
                dimensionsField.setManaged(true);
                dimensionsField.setVisible(true);
                break;
            // Disable all the text fields
            default:
                extraField.setPromptText("Extra");
                extraField.setDisable(true);
                colorField.setPromptText("");
                colorField.setDisable(true);
                modelIdField.setPromptText("");
                modelIdField.setDisable(true);
                descriptionField.setManaged(false);
                descriptionField.setVisible(false);
                publisherField.setManaged(false);
                publisherField.setVisible(false);
                warrantyPeriodField.setManaged(false);
                warrantyPeriodField.setVisible(false);
                dimensionsField.setManaged(false);
                dimensionsField.setVisible(false);
                subGroupComboBox.getItems().clear();

                break;
        }
    }
    // Add the @FXML annotation to the onAddButtonClick method
    @FXML
    protected void onAddButtonClick() {
        try {
            String description = descriptionField.getText();
            String name = nameField.getText();
            if (name == null || name.isEmpty()) {
                showAlert("Name field is empty. Please enter a name.");
                return;
            }

            String quantityText = quantityField.getText();
            if (quantityText == null || !quantityText.matches("\\d+")) {
                showAlert("Invalid quantity. Please enter a positive integer.");
                return;
            }
            int quantity = Integer.parseInt(quantityText);

            String priceText = priceField.getText();
            if (priceText == null || !priceText.matches("\\d*(\\.\\d+)?")) {
                showAlert("Invalid price. Please enter a non-negative number.");
                return;
            }
            double price = Double.parseDouble(priceText);

            String extra = extraField.getText();
            if (extra == null || extra.isEmpty()) {
                showAlert("Extra field is empty. Please enter a value.");
                return;
            }

            String type = typeComboBox.getValue();
            if (type == null) {
                showAlert("No item type selected. Please select a type.");
                return;
            }

            // Additional checks for Book
            if ("Book".equals(type)) {
                String publisher = publisherField.getText();
                if (publisher == null || publisher.isEmpty()) {
                    showAlert("Publisher field is empty. Please enter a publisher.");
                    return;
                }

                String pagesText = pagesField.getText();
                if (pagesText == null || !pagesText.matches("\\d+")) {
                    showAlert("Invalid number of pages. Please enter a positive integer.");
                    return;
                }
            }

            // Additional checks for Electronics
            if ("Electronics".equals(type)) {
                String color = colorField.getText();
                if (color == null || color.isEmpty()) {
                    showAlert("Color field is empty. Please enter a color.");
                    return;
                }

                String modelId = modelIdField.getText();
                if (modelId == null || modelId.isEmpty()) {
                    showAlert("Model ID field is empty. Please enter a Model ID.");
                    return;
                }

                String warrantyPeriodText = warrantyPeriodField.getText();
                if (warrantyPeriodText == null || !warrantyPeriodText.matches("\\d+")) {
                    showAlert("Invalid warranty period. Please enter a positive integer.");
                    return;
                }
            }

            // Additional checks for Furniture
            if ("Furniture".equals(type)) {
                String dimensions = dimensionsField.getText();
                if (dimensions == null || dimensions.isEmpty()) {
                    showAlert("Dimensions field is empty. Please enter dimensions.");
                    return;
                }
            }

            Item item;
            switch (type) {
                case "Electronics":
                    String color = colorField.getText();
                    if (color.isEmpty()) {
                        showAlert("Color field is empty. Please enter a color.");
                        return;
                    }
                    String modelId = modelIdField.getText();
                    if (modelId.isEmpty()) {
                        showAlert("Model ID field is empty. Please enter a Model ID.");
                        return;
                    }
                    String subGroup = subGroupComboBox.getValue();
                    if (subGroup == null || subGroup.isEmpty()) {
                        showAlert("Sub Group field is empty. Please select a Sub Group.");
                        return;
                    }

                    String warrantyPeriodText = warrantyPeriodField.getText();
                    if (warrantyPeriodText == null || !warrantyPeriodText.matches("\\d+")) {
                        showAlert("Invalid warranty period. Please enter a positive integer.");
                        return;
                    }
                    int warrantyPeriod = Integer.parseInt(warrantyPeriodText);

                    item = new Electronics(name, quantity, price, extra, modelId, subGroup, color);
                    item.setDescription(description);
                    ((Electronics) item).setWarrantyPeriod(warrantyPeriod);
                    clearFields();
                    break;
                case "Book":
                    subGroup = subGroupComboBox.getValue();
                    if (subGroup == null || subGroup.isEmpty()) {
                        showAlert("Sub Group field is empty. Please select a Sub Group.");
                        return;
                    }
                    List<Page> pages = new ArrayList<Page>();
                    int numberOfPages = Integer.parseInt(pagesField.getText());
                    if (numberOfPages <= 0) {
                        showAlert("Invalid number of pages. Please enter a positive integer.");
                        return;
                    }
                    for (int i = 0; i < numberOfPages; i++) {
                        pages.add(new Page(i + 1, "")); // You can replace "" with the actual content of the page
                    }
                    String publisher = publisherField.getText();
                    if (publisher == null || publisher.isEmpty()) {
                        showAlert("Publisher field is empty. Please enter a publisher.");
                        return;
                    }

                    item = new Book(name, quantity, price, extra, subGroup, pages);
                    item.setDescription(description);
                    ((Book) item).setPublisher(publisher);
                    pagesField.setVisible(true);
                    pagesField.setText("");
                    clearFields();
                    break;
                case "Furniture":
                    String material = extraField.getText();
                    if (material.isEmpty()) {
                        showAlert("Material field is empty. Please enter a material.");
                        return;
                    }
                    subGroup = subGroupComboBox.getValue();
                    if (subGroup == null || subGroup.isEmpty()) {
                        showAlert("Sub Group field is empty. Please select a Sub Group.");
                        return;
                    }

                    String dimensions = dimensionsField.getText();
                    if (dimensions == null || dimensions.isEmpty()) {
                        showAlert("Dimensions field is empty. Please enter dimensions.");
                        return;
                    }

                    item = new Furniture(name, quantity, price, material, subGroup);
                    item.setDescription(description);
                    ((Furniture) item).setDimensions(dimensions);
                    clearFields();
                    break;
                default:
                    pagesField.setVisible(false);
                    return;
            }

            if (item != null) { // Add the item to the list view
                inventoryListView.getItems().add(item);
                inventoryListView.getItems().sort((item1, item2) -> {
                    int id1 = Integer.parseInt(item1.getId().substring(4)); // Extract the numerical part of the ID
                    int id2 = Integer.parseInt(item2.getId().substring(4)); // Extract the numerical part of the ID
                    return Integer.compare(id1, id2); // Compare the numerical parts
                });
            };
        } catch (NumberFormatException e) {
            showAlert("An error occurred: " + e.getMessage());
        }
    }
    // Add the @FXML annotation to the onRemoveButtonClick method
    @FXML
    protected void onRemoveButtonClick() {
        Item selectedItem = inventoryListView.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            if (selectedItem.getQuantity() == 1) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Dialog");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to remove this item?");

                alert.showAndWait().ifPresent(response -> {
                    if (response == ButtonType.OK) {
                        removeQuantity(1); // Decrease the quantity of the selected item by 1
                    }
                });
            } else {
                removeQuantity(1); // Decrease the quantity of the selected item by 1
            }
        } else {
            showAlert("No item selected. Please select an item to remove.");
        }
    }
    // Add the @FXML annotation to the onRemoveButtonClick method
    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Input Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    private void onItemSelected() throws IOException {
        Item selectedItem = inventoryListView.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("better-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 800, 600); // Change 800 and 600 to your desired width and height

            // Pass the selected item and the current Controller instance to the BetterViewController
            betterview betterViewController = fxmlLoader.getController();
            betterViewController.setItem(selectedItem, this); // 'this' refers to the current Controller instance

            // Show the new stage
            stage.setScene(scene);
            stage.show();
        }
    }

    @FXML
    protected void onSaveButtonClick() {
        Item selectedItem = inventoryListView.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
        // Get the values from the text fields
            String name = nameField.getText();
            int quantity = Integer.parseInt(quantityField.getText());
            double price = Double.parseDouble(priceField.getText());
            String description = descriptionField.getText();

            if (name == null || name.isEmpty()) {
                showAlert("Name field is empty. Please enter a name.");
                return;
            }

            String quantityText = quantityField.getText();
            if (quantityText == null || !quantityText.matches("\\d+")) {
                showAlert("Invalid quantity. Please enter a positive integer.");
                return;
            }

            String priceText = priceField.getText();
            if (priceText == null || !priceText.matches("\\d*(\\.\\d+)?")) {
                showAlert("Invalid price. Please enter a non-negative number.");
                return;
            }

            // Update the selected item's details with the values from the fields
            selectedItem.setName(nameField.getText());
            selectedItem.setQuantity(Integer.parseInt(quantityField.getText()));
            selectedItem.setPrice(Double.parseDouble(priceField.getText()));
            selectedItem.setDescription(descriptionField.getText());


            if (selectedItem instanceof Book) {
                Book book = (Book) selectedItem;
                book.setAuthor(extraField.getText());
                book.setSubGroup(subGroupComboBox.getValue());
                // Update the pages and publisher as needed
            } else if (selectedItem instanceof Electronics) {
                Electronics electronics = (Electronics) selectedItem;
                electronics.setBrand(extraField.getText());
                electronics.setColor(colorField.getText());
                electronics.setModelId(modelIdField.getText());
                electronics.setSubGroup(subGroupComboBox.getValue());
                electronics.setWarrantyPeriod(Integer.parseInt(warrantyPeriodField.getText()));
            } else if (selectedItem instanceof Furniture) {
                Furniture furniture = (Furniture) selectedItem;
                furniture.setMaterial(extraField.getText());
                furniture.setSubGroup(subGroupComboBox.getValue());
                furniture.setDimensions(dimensionsField.getText());
            }

            inventoryListView.refresh(); // Refresh the ListView to show the updated details
            clearFields(); // Clear the fields after saving the changes
        }
    }

    @FXML
    public void initialize() {
        //add tester book
        List<Page> pages = new ArrayList<Page>();
        for (int i = 0; i < 100; i++) {
            pages.add(new Page(i + 1, "Content of page " + (i + 1)));
        }
        // tester boook, phone, and chair

        Electronics testElectronics = new Electronics("Test Electronics", 5, 499.99, "Test Brand", "Test Model ID", "Test Sub Group", "Test Color");
        testElectronics.setDescription("This is a test electronics item.");
        testElectronics.setWarrantyPeriod(1);

        Furniture testFurniture = new Furniture("Test Furniture", 3, 199.99, "Test Material", "Test Sub Group");
        testFurniture.setDescription("This is a test furniture item.");
        testFurniture.setDimensions("10x10x10");

        Book testBook = new Book("Test Book", 10, 59.99, "Test Author", "Fiction", pages);
        testBook.setDescription("This is a test book.");
        testBook.setPublisher("Test Publisher");

        // Add the test items
        inventoryListView.getItems().add(testBook);
        inventoryListView.getItems().add(testElectronics);
        inventoryListView.getItems().add(testFurniture);

        // Sort the items by the numerical part of their ID
        inventoryListView.getItems().sort((item1, item2) -> {
            int id1 = Integer.parseInt(item1.getId().substring(4)); // Extract the numerical part of the ID
            int id2 = Integer.parseInt(item2.getId().substring(4)); // Extract the numerical part of the ID
            return Integer.compare(id1, id2); // Compare the numerical parts
        });

        // Add a listener to the subGroupComboBox's editor property
        quantityField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                // If the new value is not a number, clear the input
                if (!newValue.matches("\\d*")) {
                    quantityField.setText("");
                }
            }
        });

        inventoryListView.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) { // Check for double click
                Item selectedItem = inventoryListView.getSelectionModel().getSelectedItem();
                if (selectedItem != null) {
                    try {
                        // Create a new stage and scene
                        Stage stage = new Stage();
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("better-view.fxml"));
                        Scene scene = new Scene(fxmlLoader.load(), 800, 600); // Change 800 and 600 to your desired width and height

                        // Pass the selected item and the Controller to the BetterViewController
                        betterview betterview = fxmlLoader.getController();
                        betterview.setItem(selectedItem, this); // Pass 'this' as the second argument

                        // Show the new stage
                        stage.setScene(scene);
                        stage.show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        // search shit

        // Initialize allItems with the items in inventoryListView
        allItems.addAll(inventoryListView.getItems());

        // Add a listener to the search field
        searchField.textProperty().addListener((observable, oldValue, newValue) -> {
            // Convert the search text to lower case
            String searchText = newValue.toLowerCase();

            // If the search text is not empty, filter the items in allItems based on the search text
            if (!searchText.isEmpty()) {
                ObservableList<Item> filteredItems = allItems.filtered(item -> item.getName().toLowerCase().contains(searchText));
                inventoryListView.setItems(filteredItems);
            } else {
                // If the search text is empty, set all items back to the inventoryListView
                inventoryListView.setItems(allItems);
            }
        });
    }
    @FXML
    protected void removeQuantity(int amount) {
        Item selectedItem = inventoryListView.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            int newQuantity = selectedItem.getQuantity() - amount;
            if (newQuantity <= 0) {
                inventoryListView.getItems().remove(selectedItem);
            } else {
                selectedItem.setQuantity(newQuantity);
            }
            inventoryListView.refresh(); // Refresh the ListView to show the updated quantity
        }
    }
}