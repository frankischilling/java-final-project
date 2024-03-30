package com.example.finalproject;

import com.example.finalproject.Item;
import com.example.finalproject.classes.*;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class betterview {
    @FXML
    private Label itemDetailsLabel;
    @FXML
    private TextField nameField, priceField, quantityField, authorField, publisherField, pagesField, brandField, modelIdField, colorField, warrantyPeriodField, materialField, dimensionsField, descriptionField, subGroupField;
    @FXML
    private Label authorLabel, publisherLabel, pagesLabel, brandLabel, modelIdLabel, colorLabel, warrantyPeriodLabel, materialLabel, dimensionsLabel, descriptionLabel, subGroupLabel;
    private Item item;
    private Controller controller;

    public void setItem(Item item, Controller controller) {
        this.item = item;
        this.controller = controller;

        itemDetailsLabel.setText(item.toString());
        nameField.setText(item.getName());
        quantityField.setText(String.valueOf(item.getQuantity()));
        priceField.setText(String.valueOf(item.getPrice()));
        descriptionField.setText(item.getDescription());

        // Hide and unmanage all fields initially
        hideAndUnmanage(new TextField[]{authorField, publisherField, pagesField, brandField, modelIdField, colorField, warrantyPeriodField, materialField, dimensionsField});

        if (item instanceof Book) {
            Book book = (Book) item;
            authorField.setText(book.getAuthor());
            publisherField.setText(book.getPublisher());
            pagesField.setText(String.valueOf(book.getPages()));

            // Show and manage fields specific to Book
            mangeAndShow(new TextField[]{authorField, publisherField, pagesField});
        } else if (item instanceof Electronics) {
            Electronics electronics = (Electronics) item;
            brandField.setText(electronics.getBrand());
            modelIdField.setText(electronics.getModelId());
            colorField.setText(electronics.getColor());
            warrantyPeriodField.setText(String.valueOf(electronics.getWarrantyPeriod()));

            // Show and manage fields specific to Electronics
            mangeAndShow(new TextField[]{brandField, modelIdField, colorField, warrantyPeriodField});
        } else if (item instanceof Furniture) {
            Furniture furniture = (Furniture) item;
            materialField.setText(furniture.getMaterial());
            dimensionsField.setText(furniture.getDimensions());

            // Show and manage fields specific to Furniture
            mangeAndShow(new TextField[]{materialField, dimensionsField});
        }
    }

    private void hideAndUnmanage(TextField[] fields) {
        for (TextField field : fields) {
            field.setVisible(false);
            field.setManaged(false);
        }
    }

    private void mangeAndShow(TextField[] fields) {
        for (TextField field : fields) {
            field.setVisible(true);
            field.setManaged(true);
        }
    }
    @FXML
    protected void onSaveButtonClick() {
        if (item != null) {
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