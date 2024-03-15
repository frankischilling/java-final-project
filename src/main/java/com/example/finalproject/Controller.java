package com.example.finalproject;

import com.example.finalproject.classes.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class Controller {
    @FXML
    private ListView<Item> inventoryListView;
    @FXML
    private TextField nameField, quantityField, priceField, extraField, colorField;
    @FXML
    private ComboBox<String> typeComboBox;
    @FXML
    private TextField modelIdField;

    @FXML
    protected void onTypeSelected() {
        // Clear the text fields
        nameField.clear();
        quantityField.clear();
        priceField.clear();
        extraField.clear();
        colorField.clear();
        modelIdField.clear();

        switch (typeComboBox.getValue()) {
            case "Book":
                extraField.setPromptText("Author");
                colorField.setPromptText("");
                colorField.setDisable(true);
                modelIdField.setPromptText("");
                modelIdField.setDisable(true);
                break;
            case "Electronics":
                extraField.setPromptText("Brand");
                colorField.setPromptText("Color");
                colorField.setDisable(false);
                modelIdField.setPromptText("Model ID");
                modelIdField.setDisable(false);
                break;
            case "Furniture":
                extraField.setPromptText("Material");
                colorField.setPromptText("Color");
                colorField.setDisable(false);
                modelIdField.setPromptText("");
                modelIdField.setDisable(true);
                break;
            default:
                extraField.setPromptText("Extra");
                colorField.setPromptText("");
                colorField.setDisable(true);
                modelIdField.setPromptText("");
                modelIdField.setDisable(true);
                break;
        }
    }

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

            String color = colorField.getText();
            if (color.isEmpty()) {
                showAlert("Color field is empty. Please enter a color.");
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
                    String modelId = extraField.getText(); // retrieve the model ID from the extraField
                    item = new Electronics(name, quantity, price, extra, modelId); // pass the model ID to the Electronics constructor
                    break;
                case "Furniture":
                    item = new Furniture(name, quantity, price, extra, color);
                    break;
                default:
                    return;
            }

            inventoryListView.getItems().add(item);
        } catch (NumberFormatException e) {
            showAlert("Invalid input. Please enter a valid number for quantity and price.");
        }
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Input Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}