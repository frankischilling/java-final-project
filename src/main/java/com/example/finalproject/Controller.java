package com.example.finalproject;

import com.example.finalproject.classes.*;
import com.example.finalproject.classes.Book;
import com.example.finalproject.classes.Electronics;
import com.example.finalproject.classes.Furniture;

import javafx.fxml.FXML;
import javafx.scene.control.*;
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
    // Add the @FXML annotation to the addButton field

    private void clearFields() {
        nameField.clear();
        quantityField.clear();
        priceField.clear();
        extraField.clear();
        colorField.clear();
        modelIdField.clear();
        subGroupComboBox.getItems().clear();
        subGroupComboBox.setVisible(false);
        subGroupComboBox.setDisable(true);
        subGroupComboBox.setEditable(true);
        descriptionField.clear();
        publisherField.clear();
        warrantyPeriodField.clear();
        dimensionsField.clear();
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
        subGroupComboBox.getItems().clear();
        subGroupComboBox.setVisible(false);
        subGroupComboBox.setDisable(true);
        subGroupComboBox.setEditable(true);
        descriptionField.clear();
        publisherField.clear();
        warrantyPeriodField.clear();
        dimensionsField.clear();

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
                modelIdField.setPromptText("Model ID");
                modelIdField.setDisable(false);
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
            Item item;
            switch (type) {
                case "Electronics":
                    String color = colorField.getText();
                    if (color.isEmpty()) {
                        showAlert("Color field is empty. Please enter a color.");
                        return;
                    }
                    String modelId = modelIdField.getText();
                    String subGroup = subGroupComboBox.getValue();

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
                    List<Page> pages = new ArrayList<Page>();
                    int numberOfPages = Integer.parseInt(pagesField.getText());
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
                    clearFields();
                    break;
                case "Furniture":
                    String material = extraField.getText();
                    if (material.isEmpty()) {
                        showAlert("Material field is empty. Please enter a material.");
                        return;
                    }
                    subGroup = subGroupComboBox.getValue();

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
            inventoryListView.getItems().remove(selectedItem);
        } else {
            showAlert("No item selected. Please select an item to remove.");
        }
    }
    // Add the @FXML annotation to the onRemoveButtonClick method
    private void showAlert(String message) {
        // Create an alert
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Input Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    private void onItemSelected() {
        Item selectedItem = inventoryListView.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            nameField.setText(selectedItem.getName());
            quantityField.setText(String.valueOf(selectedItem.getQuantity()));
            priceField.setText(String.valueOf(selectedItem.getPrice()));
            descriptionField.setText(selectedItem.getDescription());

            if (selectedItem instanceof Book) {
                Book book = (Book) selectedItem;
                extraField.setText(book.getAuthor());
                subGroupComboBox.setValue(book.getSubGroup());
                pagesField.setText(String.valueOf(book.getPages().size()));
                publisherField.setText(book.getPublisher());
            } else if (selectedItem instanceof Electronics) {
                Electronics electronics = (Electronics) selectedItem;
                extraField.setText(electronics.getBrand());
                colorField.setText(electronics.getColor());
                modelIdField.setText(electronics.getModelId());
                subGroupComboBox.setValue(electronics.getSubGroup());
                warrantyPeriodField.setText(String.valueOf(electronics.getWarrantyPeriod()));
            } else if (selectedItem instanceof Furniture) {
                Furniture furniture = (Furniture) selectedItem;
                extraField.setText(furniture.getMaterial());
                subGroupComboBox.setValue(furniture.getSubGroup());
                dimensionsField.setText(furniture.getDimensions());
            }
        }
    }

    @FXML
    protected void onSaveButtonClick() {
        Item selectedItem = inventoryListView.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            selectedItem.setName(nameField.getText());
            selectedItem.setQuantity(Integer.parseInt(quantityField.getText()));
            selectedItem.setPrice(Double.parseDouble(priceField.getText()));
            selectedItem.setDescription(descriptionField.getText());

            if (selectedItem instanceof Book) {
                Book book = (Book) selectedItem;
                book.setAuthor(extraField.getText());
                book.setSubGroup(subGroupComboBox.getValue());
                clearFields();
                // Update the pages and publisher as needed
            } else if (selectedItem instanceof Electronics) {
                Electronics electronics = (Electronics) selectedItem;
                electronics.setBrand(extraField.getText());
                electronics.setColor(colorField.getText());
                electronics.setModelId(modelIdField.getText());
                electronics.setSubGroup(subGroupComboBox.getValue());
                electronics.setWarrantyPeriod(Integer.parseInt(warrantyPeriodField.getText()));
                clearFields();
            } else if (selectedItem instanceof Furniture) {
                Furniture furniture = (Furniture) selectedItem;
                furniture.setMaterial(extraField.getText());
                furniture.setSubGroup(subGroupComboBox.getValue());
                furniture.setDimensions(dimensionsField.getText());
                clearFields();
            }

            inventoryListView.refresh(); // Refresh the ListView to show the updated details
        }
    }
}