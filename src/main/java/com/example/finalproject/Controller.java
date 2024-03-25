package com.example.finalproject;

import com.example.finalproject.classes.*;
import com.example.finalproject.classes.Book;
import com.example.finalproject.classes.Electronics;
import com.example.finalproject.classes.Furniture;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
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
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to remove this item?");

            alert.showAndWait().ifPresent(response -> {
                if (response == ButtonType.OK) {
                    inventoryListView.getItems().remove(selectedItem);
                }
            });
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
                typeComboBox.setValue("Book");
            } else if (selectedItem instanceof Electronics) {
                Electronics electronics = (Electronics) selectedItem;
                extraField.setText(electronics.getBrand());
                colorField.setText(electronics.getColor());
                modelIdField.setText(electronics.getModelId());
                subGroupComboBox.setValue(electronics.getSubGroup());
                warrantyPeriodField.setText(String.valueOf(electronics.getWarrantyPeriod()));
                typeComboBox.setValue("Electronics");
            } else if (selectedItem instanceof Furniture) {
                Furniture furniture = (Furniture) selectedItem;
                extraField.setText(furniture.getMaterial());
                subGroupComboBox.setValue(furniture.getSubGroup());
                dimensionsField.setText(furniture.getDimensions());
                typeComboBox.setValue("Furniture");
            }
        }
    }

    @FXML
    protected void onSaveButtonClick() {
        Item selectedItem = inventoryListView.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
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

            String description = descriptionField.getText();

            if (selectedItem instanceof Book) {
                Book book = (Book) selectedItem;
                String author = extraField.getText();
                if (author == null || author.isEmpty()) {
                    showAlert("Author field is empty. Please enter an author.");
                    return;
                }
                String subGroup = subGroupComboBox.getValue();
                if (subGroup == null || subGroup.isEmpty()) {
                    showAlert("Sub Group field is empty. Please select a Sub Group.");
                    return;
                }
                String pagesText = pagesField.getText();
                if (pagesText == null || !pagesText.matches("\\d+")) {
                    showAlert("Invalid number of pages. Please enter a positive integer.");
                    return;
                }
                int numberOfPages = Integer.parseInt(pagesText);
                String publisher = publisherField.getText();
                if (publisher == null || publisher.isEmpty()) {
                    showAlert("Publisher field is empty. Please enter a publisher.");
                    return;
                }

                book.setName(name);
                book.setQuantity(quantity);
                book.setPrice(price);
                book.setDescription(description);
                book.setAuthor(author);
                book.setSubGroup(subGroup);
                // Update the pages and publisher as needed
                book.setPublisher(publisher);
            } else if (selectedItem instanceof Electronics) {
                Electronics electronics = (Electronics) selectedItem;
                String brand = extraField.getText();
                if (brand == null || brand.isEmpty()) {
                    showAlert("Brand field is empty. Please enter a brand.");
                    return;
                }
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

                electronics.setName(name);
                electronics.setQuantity(quantity);
                electronics.setPrice(price);
                electronics.setDescription(description);
                electronics.setBrand(brand);
                electronics.setColor(color);
                electronics.setModelId(modelId);
                electronics.setSubGroup(subGroup);
                electronics.setWarrantyPeriod(warrantyPeriod);
            } else if (selectedItem instanceof Furniture) {
                Furniture furniture = (Furniture) selectedItem;
                String material = extraField.getText();
                if (material == null || material.isEmpty()) {
                    showAlert("Material field is empty. Please enter a material.");
                    return;
                }
                String subGroup = subGroupComboBox.getValue();
                if (subGroup == null || subGroup.isEmpty()) {
                    showAlert("Sub Group field is empty. Please select a Sub Group.");
                    return;
                }
                String dimensions = dimensionsField.getText();
                if (dimensions == null || dimensions.isEmpty()) {
                    showAlert("Dimensions field is empty. Please enter dimensions.");
                    return;
                }

                furniture.setName(name);
                furniture.setQuantity(quantity);
                furniture.setPrice(price);
                furniture.setDescription(description);
                furniture.setMaterial(material);
                furniture.setSubGroup(subGroup);
                furniture.setDimensions(dimensions);
            }

            inventoryListView.refresh(); // Refresh the ListView to show the updated details
            clearFields(); // Clear the fields after saving the changes
        }
    }
}