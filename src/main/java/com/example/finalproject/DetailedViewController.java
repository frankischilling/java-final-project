package com.example.finalproject;

import com.example.finalproject.classes.*;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;

public class DetailedViewController {
    @FXML
    private TextField idField, nameField, quantityField, priceField, descriptionField;
    @FXML
    private TextField authorField, publisherField, pagesField; // Specific to Book
    @FXML
    private TextField brandField, modelIdField, colorField, warrantyPeriodField; // Specific to Electronics
    @FXML
    private TextField materialField, dimensionsField; // Specific to Furniture
    @FXML
    private Button saveButton;

    private Item item;
    private Controller controller; // Add a reference to the Controller

    public void setItem(Item item, Controller controller) { // Modify the method to take a Controller as a parameter
        this.item = item;
        this.controller = controller; // Set the controller

        // Update the fields with the details of the item
        idField.setText(item.getId());
        nameField.setText(item.getName());
        quantityField.setText(String.valueOf(item.getQuantity()));
        priceField.setText(String.valueOf(item.getPrice()));
        descriptionField.setText(item.getDescription());

        // Hide all specific fields initially
        authorField.setVisible(false);
        publisherField.setVisible(false);
        pagesField.setVisible(false);
        brandField.setVisible(false);
        modelIdField.setVisible(false);
        colorField.setVisible(false);
        warrantyPeriodField.setVisible(false);
        materialField.setVisible(false);
        dimensionsField.setVisible(false);

        if (item instanceof Book) {
            Book book = (Book) item;
            authorField.setText(book.getAuthor());
            publisherField.setText(book.getPublisher());
            pagesField.setText(String.valueOf(book.getPages().size()));

            // Show only the fields specific to Book
            authorField.setVisible(true);
            publisherField.setVisible(true);
            pagesField.setVisible(true);
        } else if (item instanceof Electronics) {
            Electronics electronics = (Electronics) item;
            brandField.setText(electronics.getBrand());
            modelIdField.setText(electronics.getModelId());
            colorField.setText(electronics.getColor());
            warrantyPeriodField.setText(String.valueOf(electronics.getWarrantyPeriod()));

            // Show only the fields specific to Electronics
            brandField.setVisible(true);
            modelIdField.setVisible(true);
            colorField.setVisible(true);
            warrantyPeriodField.setVisible(true);
        } else if (item instanceof Furniture) {
            Furniture furniture = (Furniture) item;
            materialField.setText(furniture.getMaterial());
            dimensionsField.setText(furniture.getDimensions());

            // Show only the fields specific to Furniture
            materialField.setVisible(true);
            dimensionsField.setVisible(true);
        }
    }

    @FXML
    protected void onSaveButtonClick() {
        if (item != null) {
            // Update the selected item's details with the values from the fields
            item.setId(idField.getText());
            item.setName(nameField.getText());
            item.setQuantity(Integer.parseInt(quantityField.getText()));
            item.setPrice(Double.parseDouble(priceField.getText()));
            item.setDescription(descriptionField.getText());

            if (item instanceof Book) {
                Book book = (Book) item;
                book.setAuthor(authorField.getText());
                book.setPublisher(publisherField.getText());
                book.setPages(Integer.parseInt(pagesField.getText()));
            } else if (item instanceof Electronics) {
                Electronics electronics = (Electronics) item;
                electronics.setBrand(brandField.getText());
                electronics.setModelId(modelIdField.getText());
                electronics.setColor(colorField.getText());
                electronics.setWarrantyPeriod(Integer.parseInt(warrantyPeriodField.getText()));
            } else if (item instanceof Furniture) {
                Furniture furniture = (Furniture) item;
                furniture.setMaterial(materialField.getText());
                furniture.setDimensions(dimensionsField.getText());
            }

            controller.refreshListView(); // Refresh the ListView in the Controller
        }
    }
}