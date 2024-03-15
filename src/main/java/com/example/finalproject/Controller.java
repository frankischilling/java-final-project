package com.example.finalproject;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class Controller {
    @FXML
    private ListView<Item> inventoryListView;
    @FXML
    private TextField nameField, quantityField, priceField, extraField;
    @FXML
    private ComboBox<String> typeComboBox;

    @FXML
    protected void onTypeSelected() {
        switch (typeComboBox.getValue()) {
            case "Book":
                extraField.setPromptText("Author");
                break;
            case "Electronics":
                extraField.setPromptText("Brand");
                break;
            default:
                extraField.setPromptText("Extra");
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
                    item = new Electronics(name, quantity, price, extra);
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