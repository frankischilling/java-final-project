package com.example.finalproject;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    private ListView<Item> inventoryListView;
    @FXML
    private TextField nameField, quantityField, priceField, extraField;
    @FXML
    private ComboBox<String> typeComboBox;


    @FXML
    protected void onAddButtonClick() {
        String name = nameField.getText();
        int quantity = Integer.parseInt(quantityField.getText());
        double price = Double.parseDouble(priceField.getText());
        String extra = extraField.getText();

        Item item;
        switch (typeComboBox.getValue()) {
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
    }
}