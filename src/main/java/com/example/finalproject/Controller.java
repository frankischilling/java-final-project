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
    // Add the @FXML annotation to the subGroupComboBox field
    @FXML
    private ComboBox<String> subGroupComboBox;
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
        subGroupComboBox.getItems().clear();
        subGroupComboBox.setVisible(false);
        subGroupComboBox.setDisable(true);
        subGroupComboBox.setEditable(true);

        // Enable the text fields
        switch (typeComboBox.getValue()) {
            // Enable the extraField and disable the colorField, modelIdField and subGroupComboBox
            case "Book":
                extraField.setPromptText("Author");
                extraField.setDisable(false);
                colorField.setPromptText("");
                colorField.setDisable(true);
                modelIdField.setPromptText("");
                modelIdField.setDisable(true);
                subGroupComboBox.setVisible(true);
                subGroupComboBox.setDisable(false);
                subGroupComboBox.getItems().addAll("Non-fiction", "Fiction");
                break;
            // Enable the extraField, colorField, modelIdField and subGroupComboBox
            case "Electronics":
                extraField.setPromptText("Brand");
                extraField.setDisable(false);
                colorField.setPromptText("Color");
                colorField.setDisable(false);
                modelIdField.setPromptText("Model ID");
                modelIdField.setDisable(false);
                subGroupComboBox.setVisible(true);
                subGroupComboBox.setDisable(false);
                subGroupComboBox.getItems().addAll("TV", "Laptop", "Phone");
                break;
            // Enable the colorField and disable the extraField, modelIdField and subGroupComboBox
            case "Furniture":
                extraField.setPromptText("Material");
                extraField.setDisable(false);
                colorField.setPromptText("");
                colorField.setDisable(true);
                modelIdField.setPromptText("");
                modelIdField.setDisable(true);
                subGroupComboBox.setVisible(true);
                subGroupComboBox.setDisable(false);
                subGroupComboBox.getItems().addAll("Chair", "Table", "Desk", "Bed", "Sofa");
                break;
            // Disable the extraField, colorField, modelIdField and subGroupComboBox
            default:
                extraField.setPromptText("Extra");
                extraField.setDisable(true);
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
                case "Electronics":
                    String color = colorField.getText();
                    if (color.isEmpty()) {
                        showAlert("Color field is empty. Please enter a color.");
                        return;
                    }
                    String modelId = modelIdField.getText();
                    String subGroup = subGroupComboBox.getValue();
                    item = new Electronics(name, quantity, price, extra, modelId, subGroup);
                    break;
                case "Book":
                    subGroup = subGroupComboBox.getValue();
                    item = new Book(name, quantity, price, extra, subGroup);
                    break;
                case "Furniture":
                    String material = extraField.getText();
                    if (material.isEmpty()) {
                        showAlert("Material field is empty. Please enter a material.");
                        return;
                    }
                    subGroup = subGroupComboBox.getValue();
                    item = new Furniture(name, quantity, price, material, subGroup);
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