package com.example.finalproject;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.example.finalproject.Controller;
import com.example.finalproject.classes.*;

public class BetterView {
    public VBox defaultFieldsContainer;
    @FXML
    private TextField nameField, priceField, quantityField, descriptionField, authorField, publisherField, pagesField, brandField, modelIdField, colorField, warrantyPeriodField, materialField, dimensionsField;
    @FXML
    private Label authorLabel, publisherLabel, pagesLabel, brandLabel, modelIdLabel, colorLabel, warrantyPeriodLabel, materialLabel, dimensionsLabel;
    @FXML
    private VBox bookFieldsContainer, electronicsFieldsContainer, furnitureFieldsContainer;
    @FXML
    private ScrollPane imageScrollPane;
    @FXML
    private ImageView itemImageView;
    @FXML
    private Button imageButton;
    private String selectedImagePath;
    private Item item;
    private Controller controller;

    public void setItem(Item item, Controller controller) {
        this.item = item;
        this.controller = controller;

        // Enable default fields
        nameField.setEditable(true);
        quantityField.setEditable(true);
        priceField.setEditable(true);
        descriptionField.setEditable(true);

        nameField.setText(item.getName());
        quantityField.setText(String.valueOf(item.getQuantity()));
        priceField.setText(String.valueOf(item.getPrice()));
        descriptionField.setText(item.getDescription());

        defaultFieldsContainer.setVisible(true);
        defaultFieldsContainer.setManaged(true);

        // Initially hide all containers
        hideAllContainers();

        // Show container based on item type
        if (item instanceof Book book) {
            authorField.setText(book.getAuthor());
            publisherField.setText(book.getPublisher());
            pagesField.setText(String.valueOf(book.getPages().size())); // Set the text to the number of pages

            bookFieldsContainer.setVisible(true);
            bookFieldsContainer.setManaged(true);
        } else if (item instanceof Electronics electronics) {
            brandField.setText(electronics.getBrand());
            modelIdField.setText(electronics.getModelId());
            colorField.setText(electronics.getColor());
            warrantyPeriodField.setText(String.valueOf(electronics.getWarrantyPeriod()));

            electronicsFieldsContainer.setVisible(true);
            electronicsFieldsContainer.setManaged(true);
        } else if (item instanceof Furniture furniture) {
            materialField.setText(furniture.getMaterial());
            dimensionsField.setText(furniture.getDimensions());

            furnitureFieldsContainer.setVisible(true);
            furnitureFieldsContainer.setManaged(true);
        }

        // Load the item image
        if (item.getImagePath() != null && !item.getImagePath().isEmpty()) {
            Image image = new Image(item.getImagePath());
            itemImageView.setImage(image);
        }
    }

    private void hideAllContainers() {
        bookFieldsContainer.setVisible(false);
        bookFieldsContainer.setManaged(false);
        electronicsFieldsContainer.setVisible(false);
        electronicsFieldsContainer.setManaged(false);
        furnitureFieldsContainer.setVisible(false);
        furnitureFieldsContainer.setManaged(false);
    }

    private void hideAndUnmanage(TextField[] fields, Label[] labels) {
        for (TextField field : fields) {
            if (field != null) {
                field.setVisible(false);
                field.setManaged(false);
            }
        }
        for (Label label : labels) {
            if (label != null) {
                label.setVisible(false);
                label.setManaged(false);
            }
        }
    }

    private void manageAndShow(TextField[] fields, Label[] labels) {
        for (TextField field : fields) {
            if (field != null) {
                field.setVisible(true);
                field.setManaged(true);
            }
        }
        for (Label label : labels) {
            if (label != null) {
                label.setVisible(true);
                label.setManaged(true);
            }
        }
    }

    @FXML
    protected void onSaveButtonClick() {
        // If an image has been selected, update the Item object's image path and hasImage flag
        if (selectedImagePath != null) {
            item.setImagePath(selectedImagePath);
            item.setHasImage(true);
        }

        if (item != null) {
            item.setName(nameField.getText());
            try {
                item.setQuantity(Integer.parseInt(quantityField.getText()));
            } catch (NumberFormatException e) {
                System.out.println("Invalid quantity. Please enter a valid integer.");
                return;
            }
            try {
                item.setPrice(Double.parseDouble(priceField.getText()));
            } catch (NumberFormatException e) {
                System.out.println("Invalid price. Please enter a valid number.");
                return;
            }
            item.setDescription(descriptionField.getText());

            if (item instanceof Book book) {
                book.setAuthor(authorField.getText());
                book.setPublisher(publisherField.getText());
                try {
                    int numOfPages = Integer.parseInt(pagesField.getText());
                    List<Page> pages = new ArrayList<>();
                    for (int i = 0; i < numOfPages; i++) {
                        pages.add(new Page(i + 1, "")); // You can replace "" with the actual content of the page
                    }
                    book.setPages(pages);

                } catch (NumberFormatException e) {
                    System.out.println("Invalid number of pages. Please enter a valid integer.");
                    return;
                }
            } else if (item instanceof Electronics electronics) {
                electronics.setBrand(brandField.getText());
                electronics.setModelId(modelIdField.getText());
                electronics.setColor(colorField.getText());
                try {
                    electronics.setWarrantyPeriod(Integer.parseInt(warrantyPeriodField.getText()));
                } catch (NumberFormatException e) {
                    System.out.println("Invalid warranty period. Please enter a valid integer.");
                    return;
                }
            } else if (item instanceof Furniture furniture) {
                furniture.setMaterial(materialField.getText());
                furniture.setDimensions(dimensionsField.getText());
            }

            controller.refreshListView();
        }
    }

    @FXML
    protected void onImageButtonClick() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg"));
        File selectedFile = fileChooser.showOpenDialog(imageButton.getScene().getWindow());
        if (selectedFile != null) {
            // Load the image from the selected file
            Image image = new Image(selectedFile.toURI().toString());
            // Set the image to the ImageView
            itemImageView.setImage(image);
            // Preserve the ratio of the image
            itemImageView.setPreserveRatio(true);
            // Set the ScrollPane to fit the size of the image
            imageScrollPane.setFitToHeight(true);
            imageScrollPane.setFitToWidth(true);
            // Store the image path in the temporary variable
            selectedImagePath = selectedFile.toURI().toString();
        }
    }

    @FXML
    protected void onRemoveImageButtonClick() {
        if (item.hasImage()) {
            item.setHasImage(false);
            item.setImagePath(null);
            itemImageView.setImage(null);
            controller.refreshListView();
        }
    }

    public void initialize() {
        // Add a ChangeListener to the width and height properties of the ScrollPane
        imageScrollPane.widthProperty().addListener((observable, oldValue, newValue) -> {
            // Adjust the fit width of the ImageView based on the new width of the ScrollPane
            itemImageView.setFitWidth(newValue.doubleValue());
        });
        imageScrollPane.heightProperty().addListener((observable, oldValue, newValue) -> {
            // Adjust the fit height of the ImageView based on the new height of the ScrollPane
            itemImageView.setFitHeight(newValue.doubleValue());
        });
    }
}