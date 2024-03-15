package com.example.finalproject;

import com.example.finalproject.classes.*;
import com.example.finalproject.classes.Book;
import com.example.finalproject.classes.Electronics;
import com.example.finalproject.classes.Furniture;

import javafx.fxml.FXML;
import javafx.scene.control.*;

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
    // Add the @FXML annotation to the addButton field
    @FXML
    protected void onTypeSelected() {
        // Clear the text fields
        nameField.clear();
        quantityField.clear();
        priceField.clear();
        extraField.clear();
        colorField.clear();
        modelIdField.clear();
        // Enable the text fields
        switch (typeComboBox.getValue()) {
            // Enable the extraField and disable the colorField and modelIdField
            case "Book":
                extraField.setPromptText("Author");
                colorField.setPromptText("");
                colorField.setDisable(true);
                modelIdField.setPromptText("");
                modelIdField.setDisable(true);
                break;
            // Enable the extraField, colorField, and modelIdField
            case "Electronics":
                extraField.setPromptText("Brand");
                colorField.setPromptText("Color");
                colorField.setDisable(false);
                modelIdField.setPromptText("Model ID");
                modelIdField.setDisable(false);
                break;
            // Enable the extraField and disable the colorField and modelIdField
            case "Furniture":
                extraField.setPromptText("Material");
                colorField.setPromptText("Color");
                colorField.setDisable(false);
                modelIdField.setPromptText("");
                modelIdField.setDisable(true);
                break;
                // Disable the extraField, colorField, and modelIdField
            default:
                extraField.setPromptText("Extra");
                colorField.setPromptText("");
                colorField.setDisable(true);
                modelIdField.setPromptText("");
                modelIdField.setDisable(true);
                break;
        }
    }
    // Add the @FXML annotation to the onAddButtonClick method
    @FXML
    protected void onAddButtonClick() {
        try {
            String name = nameField.getText();
            if (name.isEmpty()) {
                showAlert("Name field is empty. Please enter a name.");
                return;
            }

            int quantity = Integer.parseInt(quantityField.getText());
            double price = Double.parseDouble(priceField.getText());

            String extra = extraField.getText();
            if (extra.isEmpty()) {
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
                case "Book":
                    item = new Book(name, quantity, price, extra);
                    break;
                case "Electronics":
                    String color = colorField.getText();
                    if (color.isEmpty()) {
                        showAlert("Color field is empty. Please enter a color.");
                        return;
                    }
                    String modelId = modelIdField.getText();
                    item = new Electronics(name, quantity, price, extra, modelId);
                    break;
                case "Furniture":
                    color = colorField.getText();
                    if (color.isEmpty()) {
                        showAlert("Color field is empty. Please enter a color.");
                        return;
                    }
                    item = new Furniture(name, quantity, price, extra);
                    break;
                default:
                    return;
            }

            inventoryListView.getItems().add(item);
        } catch (NumberFormatException e) {
            showAlert("Invalid input. Please enter a valid number for quantity and price.");
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
}