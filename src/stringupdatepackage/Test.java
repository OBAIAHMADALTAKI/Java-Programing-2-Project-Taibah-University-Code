package stringupdatepackage;

import javafx.application.Application;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Test extends Application {
    
    AllOperations a = new AllOperations();
    
    
    private double logoX = 0;
    private double logoY = 0;

    // Buttons
    Button setText = new Button("Confirm String");
    Button executeButton = new Button("Execute");
    Button refreshButton = new Button("Refresh");
    Button helpButton = new Button("Help");
    
    // Labels with improved descriptive text
    Label lbMainText = new Label("Enter the text to Edit:");
    Label lbElement = new Label("Element to search for:");
    Label lbIndex = new Label("Index position:");
    Label lbEndIndex = new Label("End index position:"); 
    Label lbInsert = new Label("Text to insert:");
    Label lbResult = new Label("Result:");
    
    // Text components
    Text titleText = new Text("Advanced Text Editor");
    Text statusText = new Text("Ready");
    Text footerText = new Text("© 2025 Text Editor");
    
    // TextFields
    TextField mainText = new TextField();
    TextField elementField = new TextField();
    TextField indexField = new TextField();
    TextField endIndexField = new TextField();
    TextField insertField = new TextField();
    TextArea resultField = new TextArea();
    TextField sumFirstNumberField = new TextField();
    TextField sumScoendNumberField = new TextField();

    // TextArea for multiline text
    TextArea logTextArea = new TextArea();
    
    // CheckBox components
    CheckBox darkModeCheckBox = new CheckBox("Dark Mode");

    CheckBox trimSpacesCheckBox = new CheckBox("Trim Spaces");
    
    // RadioButton components with ToggleGroup
    
    
    // Images
    Image logoImage = null;
    ImageView logoView = null;
    Image refreshIcon = null;
    ImageView refreshIconView = null;
    Image helpIcon = null;
    ImageView helpIconView = null;
    
    // Method lists
    ObservableList<String> insertMethodsNames = FXCollections.observableArrayList(
            "Insert Methods (Select one)",
            "Insert at end of string",
            "Insert before last",
            "Insert before & after last",
            "Insert at beginning of string",
            "Insert after first character",
            "Insert before & after first",
            "Insert after specific element",
            "Insert after all occurrences of element",
            "Insert before specific element",
            "Insert before all occurrences of element",
            "Insert before & after specific element",
            "Insert before & after all occurrences of element",
            "Insert at specific index from beginning",
            "Insert at specific index from end"
    );
    
    ObservableList<String> deleteMethodNames = FXCollections.observableArrayList(
            "Delete Methods (Select one)",
            "Delete first character",
            "Delete character after first",
            "Delete all after first character",
            "Delete last character",
            "Delete character before last",
            "Delete all before last character",
            "Delete specific element",
            "Delete all occurrences of element",
            "Delete after specific element",
            "Delete after all occurrences of element",
            "Delete all after specific element",
            "Delete before specific element",
            "Delete before all occurrences of element",
            "Delete all before specific element",
            "Delete before & after specific element",
            "Delete before & after all occurrences of element",
            "Delete character at specific index from beginning",
            "Delete character at specific index from end",
            "Delete character at any index",
            "Delete from start index to end index",
            "Delete from first char to second char",
            "Delete all digits",
            "Delete all letters",
            "Delete all except digits and letters",
            "Delete all (clear)"
    );
    
    // New Print method list
    ObservableList<String> printMethodNames = FXCollections.observableArrayList(
            "Print Methods (Select one)",
            "Print first letter",
            "Print first word",
            "Print first sentence",
            "Print last letter",
            "Print last word",
            "Print last sentence",
            "Print size",
            "Print capacity",
            "Print character at specific index",
            "Print text between indices",
            "Print index of first occurrence",
            "Print index of last occurrence", 
            "Print indices of all occurrences"
    );
    
    // New Traversal method list
    ObservableList<String> traversalMethodNames = FXCollections.observableArrayList(
            "Traversal Methods (Select one)",
            "Convert words to array",
            "Convert letters to array",
            "Shuffle words",
            "Shuffle letters",
            "Reverse content",
            "Sort letters ascending",
            "Sort letters descending",
            "Search for substring",
            "Sum Number",
            "Update by index range",
            "Update first occurrence",
            "Update all occurrences"
    );
    
    // Method categories for the ListView
    ObservableList<String> methodCategories = FXCollections.observableArrayList(
            "Insert Methods",
            "Delete Methods",
            "Print Methods",
            "Traversal Methods"
    );
    
    ListView<String> methodCategoryListView = new ListView<>(methodCategories);
    ComboBox<String> methodsComboBox = new ComboBox<>();
    
    // Operation log
    StringBuilder operationLog = new StringBuilder();
    
    @Override
    public void start(Stage primaryStage) {
        	

        // Setup containers
        BorderPane mainPane = new BorderPane();
        GridPane centerPane = new GridPane();
        VBox leftPane = new VBox(15);
        HBox buttonBox = new HBox(15);
        VBox topPane = new VBox(10);
        HBox bottomPane = new HBox(10);

        // General formatting
        centerPane.setAlignment(Pos.CENTER);
        centerPane.setVgap(15);
        centerPane.setHgap(15);
        centerPane.setPadding(new Insets(25));
        centerPane.setStyle("-fx-background-color: #f5f5f5;");

        leftPane.setPadding(new Insets(20));
        leftPane.setAlignment(Pos.TOP_CENTER);
        leftPane.setStyle("-fx-background-color: #e0f0ff;");
        leftPane.setPrefWidth(250); // Wider to show full method names
        
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.setPadding(new Insets(15));
        
        topPane.setAlignment(Pos.CENTER);
        topPane.setPadding(new Insets(15));
        topPane.setStyle("-fx-background-color: #4a90e2;");
        
        bottomPane.setAlignment(Pos.CENTER);
        bottomPane.setPadding(new Insets(10));
        bottomPane.setStyle("-fx-background-color: #dcdcdc;");

        // Setup fonts and Text node styling
        Font labelFont = Font.font("Arial", 14);
        Font inputFont = Font.font("Arial", 14);
        
        titleText.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        titleText.setFill(Color.WHITE);
        titleText.setTextAlignment(TextAlignment.CENTER);
        
        statusText.setFont(Font.font("Arial", 12));
        statusText.setFill(Color.DARKSLATEGRAY);
        
        footerText.setFont(Font.font("Arial", 12));
        footerText.setFill(Color.DARKSLATEGRAY);

        // Apply fonts
        lbMainText.setFont(labelFont);
        lbElement.setFont(labelFont);
        lbIndex.setFont(labelFont);
        lbEndIndex.setFont(labelFont);
        lbInsert.setFont(labelFont);
        lbResult.setFont(labelFont);

        mainText.setFont(inputFont);
        elementField.setFont(inputFont);
        indexField.setFont(inputFont);
        endIndexField.setFont(inputFont);
        insertField.setFont(inputFont);
        resultField.setFont(inputFont);

        setText.setFont(labelFont);
        executeButton.setFont(labelFont);
        refreshButton.setFont(labelFont);
        helpButton.setFont(labelFont);
        
        // Configure TextArea
        logTextArea.setFont(Font.font("Monospace", 12));
        logTextArea.setEditable(false);
        logTextArea.setWrapText(true);
        logTextArea.setPrefHeight(100);
        logTextArea.setVisible(false);
        
        // Setup CheckBoxes
        darkModeCheckBox.setFont(labelFont);
        darkModeCheckBox.setSelected(true);
        
        trimSpacesCheckBox.setFont(labelFont);
        trimSpacesCheckBox.setSelected(false);
        
        // Setup RadioButtons
       
        RadioButton moveWithMouseRadio = new RadioButton("Move image with mouse");
        RadioButton moveWithArrowsRadio = new RadioButton("Move the image with arrows");

        // Create ToggleGroup
        ToggleGroup movementToggleGroup = new ToggleGroup();
        moveWithMouseRadio.setToggleGroup(movementToggleGroup);
        moveWithArrowsRadio.setToggleGroup(movementToggleGroup);

        // Create container for radio buttons
        VBox radioGroup = new VBox(5);
        radioGroup.getChildren().addAll(moveWithMouseRadio, moveWithArrowsRadio);

        // Set default selection
        moveWithArrowsRadio.setSelected(true);

       
        
        // Setup ListView and ComboBox
        methodCategoryListView.setPrefHeight(150);
        methodsComboBox.setPrefWidth(230);
        methodsComboBox.setPrefHeight(30);
        methodsComboBox.setStyle("-fx-font-family: 'Arial'; -fx-font-size: 14;");
        
        // Create headers with clear styling
        Label categoryLabel = new Label("Step 1: Select Method Category");
        categoryLabel.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        categoryLabel.setTextFill(Color.DARKBLUE);
        
        Label methodLabel = new Label("Step 2: Select Specific Method");
        methodLabel.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        methodLabel.setTextFill(Color.DARKBLUE);
        
        // Create top panel with title and logo
        
        try {
            File gifFile = new File("C:/Users/noors/git/Java-Programing-2-Project-Taibah-University-Code/logo.gif");

            if (gifFile.exists()) {
                logoImage = new Image(gifFile.toURI().toString());
                logoView = new ImageView(logoImage);
                logoView.setFitHeight(64);
                logoView.setFitWidth(64);
            } else {
                logoView = new ImageView(); // Empty image placeholder
                logoView.setFitHeight(64);
                logoView.setFitWidth(64);
                System.out.println("GIF not found at: " + gifFile.getAbsolutePath());
            }
        } catch (Exception e) {
            logoView = new ImageView();
            logoView.setFitHeight(64);
            logoView.setFitWidth(64);
            System.out.println("Error loading GIF: " + e.getMessage());
        }
        HBox titleBox = new HBox(15);
        titleBox.setAlignment(Pos.CENTER);
        titleBox.getChildren().addAll(logoView, titleText);
        topPane.getChildren().add(titleBox);
        
        // Create bottom panel with status and footer
        bottomPane.getChildren().addAll(statusText, footerText);
        HBox.setMargin(footerText, new Insets(0, 0, 0, 300)); // Push footer to the right
        
        // Organize method selection in left panel
        VBox methodSelectionBox = new VBox(12);
        methodSelectionBox.getChildren().addAll(
            categoryLabel, 
            methodCategoryListView,
            methodLabel,
            methodsComboBox
        );
        
        // Create options panel
        VBox optionsPanel = new VBox(10);
        optionsPanel.setPadding(new Insets(10));
        optionsPanel.setStyle("-fx-background-color: #f0f0f0; -fx-border-color: #cccccc; -fx-border-radius: 5;");
        
        // Add title to options panel
        Text optionsTitle = new Text("Options");
        optionsTitle.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        
        // Group checkboxes and radio buttons
        HBox checkBoxGroup = new HBox(10);
        checkBoxGroup.getChildren().addAll(darkModeCheckBox);
        
       ;
        
        optionsPanel.getChildren().addAll(optionsTitle, checkBoxGroup, radioGroup);
        
        // Add help button at the bottom of left panel
        leftPane.getChildren().addAll(methodSelectionBox, optionsPanel, helpButton);

        // Main text input with confirmation button
        HBox mainTextBox = new HBox(10);
        mainTextBox.setAlignment(Pos.CENTER_LEFT);
        mainText.setPrefWidth(350);
        setText.setPrefWidth(120);
        mainTextBox.getChildren().addAll(lbMainText, mainText, setText);
        
        // Create containers for input fields
        HBox sumBox = new HBox(10);
        sumBox.setAlignment(Pos.CENTER_LEFT);
        sumFirstNumberField.setPrefWidth(120);
        sumScoendNumberField.setPrefWidth(120);
        Label sumLabel1 = new Label("Number 1:");
        Label sumLabel2 = new Label("Number 2:");
        sumLabel1.setFont(labelFont);
        sumLabel2.setFont(labelFont);
        sumBox.getChildren().addAll(sumLabel1, sumFirstNumberField, sumLabel2, sumScoendNumberField);
        sumBox.setVisible(false);

        VBox inputFields = new VBox(15);
        
        // Input field groups
        HBox elementBox = new HBox(10);
        elementBox.setAlignment(Pos.CENTER_LEFT);
        elementField.setPrefWidth(250);
        elementBox.getChildren().addAll(lbElement, elementField);
        
        HBox indexBox = new HBox(10);
        indexBox.setAlignment(Pos.CENTER_LEFT);
        indexField.setPrefWidth(250);
        indexBox.getChildren().addAll(lbIndex, indexField);
        
        HBox endIndexBox = new HBox(10);
        endIndexBox.setAlignment(Pos.CENTER_LEFT);
        endIndexField.setPrefWidth(250);
        endIndexBox.getChildren().addAll(lbEndIndex, endIndexField);
        
        HBox insertBox = new HBox(10);
        insertBox.setAlignment(Pos.CENTER_LEFT);
        insertField.setPrefWidth(250);
        insertBox.getChildren().addAll(lbInsert, insertField);
        
        // Hide all fields initially
        elementBox.setVisible(false);
        indexBox.setVisible(false);
        endIndexBox.setVisible(false);
        insertBox.setVisible(false);
        
        // Add field groups to input container
        inputFields.getChildren().addAll(elementBox, indexBox, endIndexBox, insertBox, sumBox);
        
        // Result field
        HBox resultBox = new HBox(10);
        resultBox.setAlignment(Pos.CENTER_LEFT);
        resultField.setPrefWidth(350);
        resultField.setEditable(false);
        resultField.setStyle("-fx-background-color: #f0f8ff;");
        resultBox.getChildren().addAll(lbResult, resultField);
        
        // Step labels for the center pane
        Label step3Label = new Label("Step 3: Enter your string and parameters");
        step3Label.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        step3Label.setTextFill(Color.DARKBLUE);
        
        Label step4Label = new Label("Step 4: Execute the operation");
        step4Label.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        step4Label.setTextFill(Color.DARKBLUE);
        
        // Set up action buttons
        buttonBox.getChildren().addAll(executeButton, refreshButton);
        executeButton.setPrefWidth(120);
        refreshButton.setPrefWidth(120);
        
        // Set up the center pane in sections with spacing
        VBox centerVBox = new VBox(20);
        centerVBox.getChildren().addAll(
            step3Label,
            mainTextBox,
            inputFields,
            step4Label,
            buttonBox,
            resultBox,
            logTextArea
        );
        
        centerPane.add(centerVBox, 0, 0);
        
        
        // Event handlers
        setText.setOnAction(e -> {
            if (!mainText.getText().isEmpty()) {
                a.setText(mainText.getText());
                updateStatus("Text confirmed: " + mainText.getText());
                showMessage("Text confirmed: " + mainText.getText());
                addToLog("Text set to: \"" + mainText.getText() + "\"");
            } else {
                showError("Please enter text to modify");
            }
        });
        
        refreshButton.setOnAction(e -> {
            resetFields();
            updateStatus("All fields reset");
        });
        
        helpButton.setOnAction(e -> {
            showHelp();
        });
        
        // Add mouse event handlers
        logoView.setOnMouseDragged(e -> {
            if (moveWithMouseRadio.isSelected()) {
                // Get the parent container of the logo (likely titleBox)
                HBox titleBox1= (HBox) logoView.getParent();
                
                // Calculate new position
                double newX = e.getX() - logoView.getFitWidth() / 2;
                double newY = e.getY() - logoView.getFitHeight() / 2;
                
                // Update translation
                logoView.setTranslateX(newX);
                logoView.setTranslateY(newY);
                
                // Store current position
                logoX = newX;
                logoY = newY;
                
                // Update status
                updateStatus("Logo moved to: " + logoX + ", " + logoY);
            }
        });

        // Key press handler for arrow keys
        mainPane.setOnKeyPressed(e -> {
            if (moveWithArrowsRadio.isSelected()) {
                double moveDelta = 5.0; // Amount to move per key press
                
                switch (e.getCode()) {
                    case UP:
                        logoY -= moveDelta;
                        logoView.setTranslateY(logoY);
                        break;
                    case DOWN:
                        logoY += moveDelta;
                        logoView.setTranslateY(logoY);
                        break;
                    case LEFT:
                        logoX -= moveDelta;
                        logoView.setTranslateX(logoX);
                        break;
                    case RIGHT:
                        logoX += moveDelta;
                        logoView.setTranslateX(logoX);
                        break;
                    default:
                        break;
                }
                
                // Update status
                if (e.getCode() == KeyCode.UP || e.getCode() == KeyCode.DOWN || 
                    e.getCode() == KeyCode.LEFT || e.getCode() == KeyCode.RIGHT) {
                    updateStatus("Logo moved to: " + logoX + ", " + logoY);
                }
            }
        });

        // Make mainPane focusable to receive key events
        mainPane.setFocusTraversable(true);

        // Request focus when a movement radio button is selected
        moveWithArrowsRadio.setOnAction(e -> mainPane.requestFocus());
        moveWithMouseRadio.setOnAction(e -> mainPane.requestFocus());
        // Display option radio buttons event
        
        
        // ListView selection event
        methodCategoryListView.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                if (newVal.equals("Insert Methods") && methodsComboBox.getItems() != insertMethodsNames) {
                    methodsComboBox.setItems(insertMethodsNames);
                    methodsComboBox.getSelectionModel().selectFirst();
                } else if (newVal.equals("Delete Methods") && methodsComboBox.getItems() != deleteMethodNames) {
                    methodsComboBox.setItems(deleteMethodNames);
                    methodsComboBox.getSelectionModel().selectFirst();
                } else if (newVal.equals("Print Methods") && methodsComboBox.getItems() != printMethodNames) {
                    methodsComboBox.setItems(printMethodNames);
                    methodsComboBox.getSelectionModel().selectFirst();
                } else if (newVal.equals("Traversal Methods") && methodsComboBox.getItems() != traversalMethodNames) {
                    methodsComboBox.setItems(traversalMethodNames);
                    methodsComboBox.getSelectionModel().selectFirst();
                }
                // Reset visibility of fields
                elementBox.setVisible(false);
                indexBox.setVisible(false);
                endIndexBox.setVisible(false);
                insertBox.setVisible(false);
                sumBox.setVisible(false);
                mainTextBox.setVisible(true);
                
                updateStatus("Selected category: " + newVal);
                addToLog("Category selected: " + newVal);
            }
        });
        
        // ComboBox selection event
        methodsComboBox.setOnAction(event -> {
            String selectedMethod = methodsComboBox.getValue();
            if (selectedMethod != null && 
                !selectedMethod.equals("Insert Methods (Select one)") && 
                !selectedMethod.equals("Delete Methods (Select one)") &&
                !selectedMethod.equals("Print Methods (Select one)") &&
                !selectedMethod.equals("Traversal Methods (Select one)")) {
                
                // Show/hide fields based on method requirements
                updateFieldVisibility(selectedMethod, elementBox, indexBox, endIndexBox, insertBox);
                updateStatus("Selected method: " + selectedMethod);
                addToLog("Method selected: " + selectedMethod);
            } else {
                // Reset all field visibility
                elementBox.setVisible(false);
                indexBox.setVisible(false);
                endIndexBox.setVisible(false);
                insertBox.setVisible(false);
                sumBox.setVisible(false);
                mainTextBox.setVisible(true);
            }
        });
        

        
        // Execute button action
        executeButton.setOnAction(e -> {
            String selectedMethod = methodsComboBox.getValue();
            if (selectedMethod == null) {
                showError("Please select a method to execute");
                return;
            }
            
            if (selectedMethod.equals("Insert Methods (Select one)") || 
                selectedMethod.equals("Delete Methods (Select one)") ||
                selectedMethod.equals("Print Methods (Select one)") ||
                selectedMethod.equals("Traversal Methods (Select one)")) {
                showError("Please select a specific method to execute");
                return;
            }
            
             
            // Special case for Sum Number
            if (!selectedMethod.equals("Sum Number") && mainText.getText().isEmpty()) {
                showError("Please enter and confirm the text to modify");
                return;
            }
            
            
            
            executeSelectedMethod(selectedMethod);
        });
        
       

        // تطبيق الوضع المظلم إذا كان مفعلاً
        
        darkModeCheckBox.setSelected(false);
        applyDarkMode(mainPane, false);

        // تحديث معالج حدث خانة الاختيار للوضع المظلم
        darkModeCheckBox.setOnAction(e -> {
            boolean isDark = darkModeCheckBox.isSelected();
            applyDarkMode(mainPane, isDark);
        });


        // Assemble the main layout
        mainPane.setTop(topPane);
        mainPane.setLeft(leftPane);
        mainPane.setCenter(centerPane);
        mainPane.setBottom(bottomPane);

        // Display the scene
        Scene scene = new Scene(mainPane, 900, 700);
        primaryStage.setTitle("Advanced Text Editor");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        // Initial update for log
        addToLog("Application started");
        updateStatus("Ready");
    }
    
    private void resetFields() {
        mainText.clear();
        elementField.clear();
        indexField.clear();
        endIndexField.clear();
        insertField.clear();
        resultField.clear();
        sumFirstNumberField.clear();
        sumScoendNumberField.clear();
        methodsComboBox.getSelectionModel().clearSelection();
        methodCategoryListView.getSelectionModel().select(null);
        
        // Reset visibility
        HBox mainTextBox = (HBox) mainText.getParent();
        mainTextBox.setVisible(true);
        
        HBox elementBox = (HBox) elementField.getParent();
        HBox indexBox = (HBox) indexField.getParent();
        HBox endIndexBox = (HBox) endIndexField.getParent();
        HBox insertBox = (HBox) insertField.getParent();
        HBox sumBox = (HBox) sumFirstNumberField.getParent();
        
        elementBox.setVisible(false);
        indexBox.setVisible(false);
        endIndexBox.setVisible(false);
        insertBox.setVisible(false);
        sumBox.setVisible(false);
        
        addToLog("All fields reset");
    }
    
    private void updateStatus(String message) {
        statusText.setText(message);
    }
    
    private void addToLog(String message) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        String timestamp = dateFormat.format(new Date());
        
        operationLog.append("[").append(timestamp).append("] ").append(message).append("\n");
        logTextArea.setText(operationLog.toString());
        
        // Auto-scroll to bottom
        logTextArea.positionCaret(logTextArea.getText().length());
    }
    
    private void updateFieldVisibility(String methodName, HBox elementBox, HBox indexBox, HBox endIndexBox, HBox insertBox) {
        // Reset field labels to default
        lbElement.setText("Element to search for:");
        lbInsert.setText("Text to insert:");
        lbIndex.setText("Index position:");
        lbEndIndex.setText("End index position:");
        
        // Get reference to sumBox and mainTextBox
        HBox sumBox = (HBox) sumFirstNumberField.getParent();
        HBox mainTextBox = (HBox) mainText.getParent();
        
        // Special case for Sum Number
        if (methodName.equals("Sum Number")) {
            sumBox.setVisible(true);
            mainTextBox.setVisible(false);
            elementBox.setVisible(false);
            indexBox.setVisible(false);
            endIndexBox.setVisible(false);
            insertBox.setVisible(false);
            return;
        } else {
            sumBox.setVisible(false);
            mainTextBox.setVisible(true);
        }
        
        // Determine required fields for each method type
        boolean needsElement = false;
        boolean needsIndex = false;
        boolean needsEndIndex = false;
        boolean needsInsert = false;
        
        // Check which category the method belongs to
        boolean isInsertMethod = methodName.toLowerCase().contains("insert") && !methodsComboBox.getItems().get(0).equals("Print Methods (Select one)") && !methodsComboBox.getItems().get(0).equals("Traversal Methods (Select one)");
        boolean isPrintMethod = methodsComboBox.getItems().get(0).equals("Print Methods (Select one)");
        boolean isTraversalMethod = methodsComboBox.getItems().get(0).equals("Traversal Methods (Select one)");
        
        if (isInsertMethod) {
            // All insert methods need text to insert
            needsInsert = true;
            
            // Methods that need element field
            if (methodName.contains("specific element") || 
                methodName.contains("occurrences of element")) {
                needsElement = true;
            }
            
            // Methods that need index field
            if (methodName.contains("specific index")) {
                needsIndex = true;
            }
        } else if (isPrintMethod) {
            // Print methods
            if (methodName.equals("Print character at specific index")) {
                needsIndex = true;
            } else if (methodName.equals("Print text between indices")) {
                needsIndex = true;
                needsEndIndex = true;
            } else if (methodName.contains("occurrence")) {
                needsElement = true;
            }
        } else if (isTraversalMethod) {
            // Traversal methods
            if (methodName.equals("Search for substring")) {
                needsElement = true;
            } else if (methodName.equals("Update by index range")) {
                needsIndex = true;
                needsEndIndex = true;
                needsInsert = true;
            } else if (methodName.equals("Update first occurrence") || 
                       methodName.equals("Update all occurrences")) {
                needsElement = true;
                needsInsert = true;
            }
        } else {
            // Delete methods
            if (methodName.contains("specific element") || 
                methodName.contains("occurrences of element")) {
                needsElement = true;
                lbElement.setText("Element to delete:");
            }
            
            if (methodName.equals("Delete character at specific index from beginning") || 
                methodName.equals("Delete character at specific index from end") ||
                methodName.equals("Delete character at any index")) {
                needsIndex = true;
            }
            
            if (methodName.equals("Delete from start index to end index")) {
                needsIndex = true;
                needsEndIndex = true;
            }
            
            if (methodName.equals("Delete from first char to second char")) {
                needsElement = true;
                lbElement.setText("First character:");
                needsInsert = true;
                lbInsert.setText("Second character:");
            }
        }
        
        // Update field visibility based on needs
        elementBox.setVisible(needsElement);
        indexBox.setVisible(needsIndex);
        endIndexBox.setVisible(needsEndIndex);
        insertBox.setVisible(needsInsert);
    }
    
    private void executeSelectedMethod(String methodName) {
        try {
            String result = "";
            String original = mainText.getText();
            
            // Setup parameters
            String element = elementField.getText();
            String insertText = insertField.getText();
            int index = -1;
            int endIndex = -1;
            
            // Parse indices if they exist
            try {
                if (!indexField.getText().isEmpty()) {
                    index = Integer.parseInt(indexField.getText());
                }
                
                if (!endIndexField.getText().isEmpty()) {
                    endIndex = Integer.parseInt(endIndexField.getText());
                }
            } catch (NumberFormatException ex) {
                showError("Please enter valid numbers for indices");
                return;
            }
            
            // Handle insert methods
            if (methodsComboBox.getItems().get(0).equals("Insert Methods (Select one)")) {
                switch (methodName) {
                    case "Insert at end of string":
                        result = a.insertLast(insertText);
                        break;
                    case "Insert before last":
                        result = a.insertBeforeLast(insertText);
                        break;
                    case "Insert before & after last":
                        result = a.insertBeforeAndAfterLast(insertText);
                        break;
                    case "Insert at beginning of string":
                        result = a.insertFirst(insertText);
                        break;
                    case "Insert after first":
                        result = a.insertAfterFirst(insertText);
                        break;
                    case "Insert before & after first":
                        result = a.insertBeforeAndAfterFirst(insertText);
                        break;
                    case "Insert after specific element":
                        result = a.insertAfterElement(element, insertText);
                        break;
                    case "Insert after all occurrences of element":
                        result = a.insertAfterAllElement(element, insertText);
                        break;
                    case "Insert before specific element":
                        result = a.insertBeforeElement(element, insertText);
                        break;
                    case "Insert before all occurrences of element":
                        result = a.insertBeforeAllElement(element, insertText);
                        break;
                    case "Insert before & after specific element":
                        result = a.insertBeforeAndAfterElement(element, insertText);
                        break;
                    case "Insert before & after all occurrences of element":
                        result = a.insertBeforeAndAfterAllElement(element, insertText);
                        break;
                    case "Insert at specific index from beginning":
                        if (index < 0) {
                            showError("Index must be a non-negative number");
                            return;
                        }
                        result = a.insertElementWithStartingFirstIndex(index, insertText);
                        break;
                    case "Insert at specific index from end":
                        if (index < 0) {
                            showError("Index must be a non-negative number");
                            return;
                        }
                        result = a.insertElementWithStartingLastIndex(index, insertText);
                        break;
                    default:
                        showError("Invalid insert method");
                        return;
                }
            }
            // Handle delete methods
            else if (methodsComboBox.getItems().get(0).equals("Delete Methods (Select one)")) {
                switch (methodName) {
                    case "Delete first character":
                        result = a.deleteFirstChar();
                        break;
                    case "Delete character after first":
                        result = a.deleteAfterFirstChar();
                        break;
                    case "Delete all after first character":
                        result = a.deleteAllAfterFirstChar();
                        break;
                    case "Delete last character":
                        result = a.deleteLastChar();
                        break;
                    case "Delete character before last":
                        result = a.deleteBeforeLastChar();
                        break;
                    case "Delete all before last character":
                        result = a.deleteAllBeforeLastChar();
                        break;
                    case "Delete specific element":
                        result = a.deleteElement(element);
                        break;
                    case "Delete all occurrences of element":
                        result = a.deleteAllElement(element);
                        break;
                    case "Delete after specific element":
                        result = a.deleteAfterElement(element);
                        break;
                    case "Delete after all occurrences of element":
                        result = a.deleteAfterAllElement(element);
                        break;
                    case "Delete all after specific element":
                        result = a.deleteAllAfterElement(element);
                        break;
                    case "Delete before specific element":
                        result = a.deleteBeforeElement(element);
                        break;
                    case "Delete before all occurrences of element":
                        result = a.deleteBeforeAllElement(element);
                        break;
                    case "Delete all before specific element":
                        result = a.deleteAllBeforeElement(element);
                        break;
                    case "Delete before & after specific element":
                        result = a.deleteBeforeAndAfterElement(element);
                        break;
                    case "Delete before & after all occurrences of element":
                        result = a.deleteBeforeAndAfterAllElement(element);
                        break;
                    case "Delete character at specific index from beginning":
                        if (index < 0) {
                            showError("Index must be a non-negative number");
                            return;
                        }
                        result = a.DeleteCharWithStartingFirstIndex(index);
                        break;
                    case "Delete character at specific index from end":
                        if (index < 0) {
                            showError("Index must be a non-negative number");
                            return;
                        }
                        result = a.deleteCharWithLastIndex(index);
                        break;
                    case "Delete character at any index":
                        if (index < 0) {
                            showError("Index must be a non-negative number");
                            return;
                        }
                        result = a.deleteCharWithAnyIndex(index);
                        break;
                    case "Delete from start index to end index":
                        if (index < 0 || endIndex < 0) {
                            showError("Indices must be non-negative numbers");
                            return;
                        }
                        result = a.deleteStartsIndexToLast(index, endIndex);
                        break;
                    case "Delete from first char to second char":
                        if (element == null || insertText == null || element.length() != 1 || insertText.length() != 1) {
                            showError("Please provide two single characters");
                            return;
                        }
                        result = a.deleteStartsCharToChar(element.charAt(0), insertText.charAt(0));
                        break;
                    case "Delete all digits":
                        result = a.deleteAllDigits();
                        break;
                    case "Delete all letters":
                        result = a.deleteAllLetters();
                        break;
                    case "Delete all except digits and letters":
                        result = a.deleteAllCharExceptDigitsAndLetters();
                        break;
                    case "Delete all (clear)":
                        result = a.deleteAll();
                        break;
                    default:
                        showError("Invalid delete method");
                        return;
                }
            }

            // Handle print methods
            else if (methodsComboBox.getItems().get(0).equals("Print Methods (Select one)")) {
                switch (methodName) {
                    case "Print first letter":
                        result = String.valueOf(a.printFirstLetter());  // char → String
                        break;
                    case "Print first word":
                        result = a.printFirstWord();  // String
                        break;
                    case "Print first sentence":
                        result = a.printFirstSentence();  // String
                        break;
                    case "Print last letter":
                        result = String.valueOf(a.printLastLetter());  // char → String
                        break;
                    case "Print last word":
                        result = a.printLastWord();  // String
                        break;
                    case "Print last sentence":
                        result = a.printLastSentence();  // String
                        break;
                    case "Print size":
                        result = String.valueOf(a.printSize());  // int → String
                        break;
                    case "Print capacity":
                        result = String.valueOf(a.printCapacity());  // int → String
                        break;
                    case "Print character at specific index":
                        if (index < 0) {
                            showError("Index must be a non-negative number");
                            return;
                        }
                        result = String.valueOf(a.printChar(index));  // char → String
                        break;
                    case "Print text between indices":
                        if (index < 0 || endIndex < 0) {
                            showError("Indices must be non-negative numbers");
                            return;
                        }
                        result = a.PrintElement(index, endIndex);  // String
                        break;
                    case "Print index of first occurrence":
                        result = String.valueOf(a.printIndexOfFirstElement(element));  // int → String
                        break;
                    case "Print index of last occurrence":
                        result = String.valueOf(a.printIndexOfLastElement(element));  // int → String
                        break;
                    case "Print indices of all occurrences":
                        result = Arrays.toString(a.printIndexOfAllElement(element));  // int[] → String
                        break;
                    default:
                        showError("Invalid print method");
                        return;
                }
            }


            // Handle traversal methods
            else if (methodsComboBox.getItems().get(0).equals("Traversal Methods (Select one)")) {
                switch (methodName) {
                    case "Convert words to array":
                        result = Arrays.toString(a.convertWordsToArray());
                        break;
                    case "Convert letters to array":
                        result = Arrays.toString(a.convertLettersToArray());
                        break;
                    case "Shuffle words":
                        result = a.shuffleWords();
                        break;
                    case "Shuffle letters":
                        result = a.shuffleLetters();
                        break;
                    case "Reverse content":
                        result = a.reverse();
                        break;
                    case "Sort letters ascending":
                        result = a.sortLettersAsc();
                        break;
                    case "Sort letters descending":
                        result = a.sortLettersDesc();
                        break;
                    case "Search for substring":
                        result = Boolean.toString(a.search(element));
                        break;
                    case "Sum Number":
                        try {
                            double num1 = Double.parseDouble(sumFirstNumberField.getText());
                            double num2 = Double.parseDouble(sumScoendNumberField.getText());
                            result = String.valueOf(a.sum(num1, num2));
                        } catch (NumberFormatException ex) {
                            showError("Please enter valid numbers");
                            return;
                        }
                        break;
                    case "Update by index range":
                        if (index < 0 || endIndex < 0) {
                            showError("Indices must be non-negative numbers");
                            return;
                        }
                        result = a.updateByIndex(index, endIndex, insertText);
                        break;
                    case "Update first occurrence":
                         result = a.updateFirst(element, insertText);
                        break;
                    case "Update all occurrences":
                        result = a.updateAll(element, insertText);
                        break;
                    default:
                        showError("Invalid traversal method");
                        return;
                }
            }
            
            // Update result field
            resultField.setText(result);
            
            // Update log
            addToLog("Method executed: " + methodName);
            addToLog("Original: \"" + original + "\"");
            addToLog("Result: \"" + result + "\"");
            
            // Update status
            updateStatus("Operation completed successfully");
        } catch (Exception ex) {
            showError("Error executing method: " + ex.getMessage());
            addToLog("ERROR: " + ex.getMessage());
        }
    }
    
    private void showMessage(String message) {
        Stage msgStage = new Stage();
        msgStage.initModality(Modality.APPLICATION_MODAL);
        msgStage.setTitle("Message");

        VBox layout = new VBox(15);
        layout.setPadding(new Insets(20));
        layout.setAlignment(Pos.CENTER);

        Label msgLabel = new Label(message);
        Button okButton = new Button("OK");
        okButton.setOnAction(e -> msgStage.close());

        layout.getChildren().addAll(msgLabel, okButton);

        Scene scene = new Scene(layout, 300, 150);
        msgStage.setScene(scene);
        msgStage.showAndWait();
    }

    
    private void showError(String message) {
        Stage errorStage = new Stage();
        errorStage.initModality(Modality.APPLICATION_MODAL);
        errorStage.setTitle("Error");

        VBox layout = new VBox(15);
        layout.setPadding(new Insets(20));
        layout.setAlignment(Pos.CENTER);

        Label errorLabel = new Label(message);
        errorLabel.setTextFill(Color.RED);
        Button closeButton = new Button("Close");
        closeButton.setOnAction(e -> errorStage.close());

        layout.getChildren().addAll(errorLabel, closeButton);

        Scene scene = new Scene(layout, 300, 150);
        errorStage.setScene(scene);
        errorStage.showAndWait();
    }

    
    private void showHelp() {
        Stage helpStage = new Stage();
        helpStage.initModality(Modality.APPLICATION_MODAL);
        helpStage.setTitle("Help");

        VBox helpContent = new VBox(15);
        helpContent.setPadding(new Insets(20));
        helpContent.setAlignment(Pos.TOP_LEFT);

        Text helpTitle = new Text("Advanced Text Editor - Help");
        helpTitle.setFont(Font.font("Arial", FontWeight.BOLD, 20));

        Text helpText = new Text(
            "This application allows you to perform various text operations.\n\n" +
            "How to use:\n" +
            "1. Select a method category from the list on the left.\n" +
            "2. Choose a specific method from the dropdown menu.\n" +
            "3. Enter your text in the 'Enter the text to Edit' field and click 'Confirm String'.\n" +
            "4. Fill in any additional parameters required by the selected method.\n" +
            "5. Click the 'Execute' button to perform the operation.\n" +
            "6. The result will appear in the 'Result' field.\n\n" +
            "Display Options:\n" +
            "- Show All Operations\n" +
            "- Show Result Only\n" +
            "- Show Log\n\n" +
            "Shortcuts:\n" +
            "- Enter: Confirm text input\n" +
            "- Ctrl+R: Reset all fields"
        );
        helpText.setFont(Font.font("Arial", 14));
        helpText.setWrappingWidth(550);

        Button closeButton = new Button("Close");
        closeButton.setFont(Font.font("Arial", 14));
        closeButton.setOnAction(e -> helpStage.close());

        helpContent.getChildren().addAll(helpTitle, helpText, closeButton);

        Scene helpScene = new Scene(helpContent, 600, 500);
        helpStage.setScene(helpScene);
        helpStage.showAndWait();
    }

    private void applyDarkMode(Pane root, boolean isDark) {
        // ألوان محسنة للوضع المظلم
        String darkBg = "#121212";            // خلفية داكنة أكثر
        String darkSecondaryBg = "#1e1e1e";   // خلفية ثانوية للعناصر المضمنة
        String darkTertiaryBg = "#2d2d2d";    // خلفية ثالثة للعناصر التفاعلية
        String darkText = "#e1e1e1";          // نص فاتح مريح للعين
        String darkAccent = "#4a90e2";        // لون التمييز الأزرق
        String darkBorder = "#555555";        // لون الحدود
        
        // ألوان الوضع الفاتح
        String lightBg = "#f5f5f5";
        String lightSecondaryBg = "#ffffff";
        String lightTertiaryBg = "#e8e8e8";
        String lightText = "#212121";
        String lightAccent = "#1a73e8";
        String lightBorder = "#cccccc";
        
        // مدة التأثير الانتقالي
        String transition = "-fx-transition: color 0.3s, background-color 0.3s;";
        
        if (isDark) {
            // تطبيق الوضع المظلم على الخلفية الرئيسية
            root.setStyle("-fx-background-color: " + darkBg + ";" + transition);
            
            // تطبيق النمط على عناصر النص
            titleText.setFill(Color.web(darkText));
            statusText.setFill(Color.web(darkText));
            footerText.setFill(Color.web(darkText));
            
            // تطبيق النمط على جميع التسميات
            applyStyleToLabels(root, "-fx-text-fill: " + darkText + ";" + transition);
            
            // تطبيق النمط على حقول النص
            String textFieldStyle = "-fx-control-inner-background: " + darkTertiaryBg + "; " +
                                   "-fx-text-fill: " + darkText + "; " +
                                   "-fx-highlight-fill: " + darkAccent + "; " +
                                   "-fx-border-color: " + darkBorder + ";" + transition;
            
            mainText.setStyle(textFieldStyle);
            elementField.setStyle(textFieldStyle);
            indexField.setStyle(textFieldStyle);
            endIndexField.setStyle(textFieldStyle);
            insertField.setStyle(textFieldStyle);
            resultField.setStyle(textFieldStyle);
            sumFirstNumberField.setStyle(textFieldStyle);
            sumScoendNumberField.setStyle(textFieldStyle);
            
            // تطبيق النمط على منطقة النص
            logTextArea.setStyle("-fx-control-inner-background: " + darkSecondaryBg + "; " +
                                "-fx-text-fill: " + darkText + "; " +
                                "-fx-border-color: " + darkBorder + ";" + transition);
            
            // تطبيق النمط على القوائم المنسدلة وقوائم العرض
            String listStyle = "-fx-control-inner-background: " + darkTertiaryBg + "; " +
                              "-fx-background: " + darkTertiaryBg + "; " +
                              "-fx-text-fill: " + darkText + ";" + transition;
            
            methodsComboBox.setStyle(listStyle);
            methodCategoryListView.setStyle(listStyle);
            
            // تطبيق النمط على الأزرار
            String buttonStyle = "-fx-background-color: " + darkTertiaryBg + "; " +
                                "-fx-text-fill: " + darkText + "; " +
                                "-fx-border-color: " + darkBorder + ";" + transition;
            
            applyStyleToButtons(root, buttonStyle);
            
            // تطبيق النمط على الألواح الفرعية
            applyStyleToPanes(root, "-fx-background-color: " + darkSecondaryBg + ";" + transition);
            
            // تطبيق النمط على خانات الاختيار وأزرار الراديو
            String checkRadioStyle = "-fx-text-fill: " + darkText + ";" + transition;
            applyStyleToCheckboxes(root, checkRadioStyle);
            applyStyleToRadioButtons(root, checkRadioStyle);
            
            // تغيير لون العنوان والشريط السفلي
            BorderPane mainPane = (BorderPane) root;
            if (mainPane.getTop() instanceof Pane) {
                ((Pane) mainPane.getTop()).setStyle("-fx-background-color: " + darkAccent + ";" + transition);
            }
            if (mainPane.getBottom() instanceof Pane) {
                ((Pane) mainPane.getBottom()).setStyle("-fx-background-color: " + darkSecondaryBg + ";" + transition);
            }
            if (mainPane.getLeft() instanceof Pane) {
                ((Pane) mainPane.getLeft()).setStyle("-fx-background-color: " + darkSecondaryBg + ";" + transition);
            }
            
        } else {
            // تطبيق الوضع الفاتح على الخلفية الرئيسية
            root.setStyle("-fx-background-color: " + lightBg + ";" + transition);
            
            // تطبيق النمط على عناصر النص
            titleText.setFill(Color.BLACK);
            statusText.setFill(Color.DARKSLATEGRAY);
            footerText.setFill(Color.DARKSLATEGRAY);
            
            // تطبيق النمط على جميع التسميات
            applyStyleToLabels(root, "-fx-text-fill: " + lightText + ";" + transition);
            
            // إعادة تعيين حقول النص إلى النمط الافتراضي
            String textFieldStyle = "-fx-control-inner-background: " + lightSecondaryBg + "; " +
                                   "-fx-text-fill: " + lightText + "; " +
                                   "-fx-highlight-fill: " + lightAccent + "; " +
                                   "-fx-border-color: " + lightBorder + ";" + transition;
            
            mainText.setStyle(textFieldStyle);
            elementField.setStyle(textFieldStyle);
            indexField.setStyle(textFieldStyle);
            endIndexField.setStyle(textFieldStyle);
            insertField.setStyle(textFieldStyle);
            resultField.setStyle(textFieldStyle);
            sumFirstNumberField.setStyle(textFieldStyle);
            sumScoendNumberField.setStyle(textFieldStyle);
            
            // إعادة تعيين منطقة النص
            logTextArea.setStyle("-fx-control-inner-background: " + lightSecondaryBg + "; " +
                                "-fx-text-fill: " + lightText + "; " +
                                "-fx-border-color: " + lightBorder + ";" + transition);
            
            // إعادة تعيين القوائم المنسدلة وقوائم العرض
            String listStyle = "-fx-control-inner-background: " + lightSecondaryBg + "; " +
                              "-fx-background: " + lightSecondaryBg + "; " +
                              "-fx-text-fill: " + lightText + ";" + transition;
            
            methodsComboBox.setStyle(listStyle);
            methodCategoryListView.setStyle(listStyle);
            
            // إعادة تعيين الأزرار
            String buttonStyle = "-fx-background-color: " + lightTertiaryBg + "; " +
                                "-fx-text-fill: " + lightText + "; " +
                                "-fx-border-color: " + lightBorder + ";" + transition;
            
            applyStyleToButtons(root, buttonStyle);
            
            // إعادة تعيين الألواح الفرعية
            applyStyleToPanes(root, "-fx-background-color: " + lightSecondaryBg + ";" + transition);
            
            // إعادة تعيين خانات الاختيار وأزرار الراديو
            String checkRadioStyle = "-fx-text-fill: " + lightText + ";" + transition;
            applyStyleToCheckboxes(root, checkRadioStyle);
            applyStyleToRadioButtons(root, checkRadioStyle);
            
            // إعادة تعيين لون العنوان والشريط السفلي
            BorderPane mainPane = (BorderPane) root;
            if (mainPane.getTop() instanceof Pane) {
                ((Pane) mainPane.getTop()).setStyle("-fx-background-color: " + lightAccent + ";" + transition);
            }
            if (mainPane.getBottom() instanceof Pane) {
                ((Pane) mainPane.getBottom()).setStyle("-fx-background-color: " + lightTertiaryBg + ";" + transition);
            }
            if (mainPane.getLeft() instanceof Pane) {
                ((Pane) mainPane.getLeft()).setStyle("-fx-background-color: " + lightSecondaryBg + ";" + transition);
            }
        }
        
        // تحديث حالة زر تنفيذ العملية لتتناسب مع الوضع الحالي
        updateExecuteButtonStyle(isDark);
        
    }

    // دوال مساعدة لتطبيق النمط على مجموعات من العناصر
    private void applyStyleToLabels(Pane root, String style) {
        for (javafx.scene.Node node : root.getChildren()) {
            if (node instanceof Label) {
                ((Label) node).setStyle(style);
            } else if (node instanceof Pane) {
                applyStyleToLabels((Pane) node, style);
            }
        }
    }

    private void applyStyleToButtons(Pane root, String style) {
        for (javafx.scene.Node node : root.getChildren()) {
            if (node instanceof Button && node != executeButton) { // تجنب تغيير نمط زر التنفيذ هنا
                ((Button) node).setStyle(style);
            } else if (node instanceof Pane) {
                applyStyleToButtons((Pane) node, style);
            }
        }
    }

    private void applyStyleToPanes(Pane root, String style) {
        for (javafx.scene.Node node : root.getChildren()) {
            if (node instanceof GridPane || node instanceof HBox || node instanceof VBox) {
                ((Pane) node).setStyle(style);
            } else if (node instanceof Pane && node != root) {
                ((Pane) node).setStyle(style);
                applyStyleToPanes((Pane) node, style);
            }
        }
    }

    private void applyStyleToCheckboxes(Pane root, String style) {
        for (javafx.scene.Node node : root.getChildren()) {
            if (node instanceof CheckBox) {
                ((CheckBox) node).setStyle(style);
            } else if (node instanceof Pane) {
                applyStyleToCheckboxes((Pane) node, style);
            }
        }
    }

    private void applyStyleToRadioButtons(Pane root, String style) {
        for (javafx.scene.Node node : root.getChildren()) {
            if (node instanceof RadioButton) {
                ((RadioButton) node).setStyle(style);
            } else if (node instanceof Pane) {
                applyStyleToRadioButtons((Pane) node, style);
            }
        }
    }

    // تحديث نمط زر التنفيذ لإبرازه
    private void updateExecuteButtonStyle(boolean isDark) {
        if (isDark) {
            executeButton.setStyle(
                "-fx-background-color: #1a73e8; " +
                "-fx-text-fill: white; " +
                "-fx-font-weight: bold; " +
                "-fx-border-radius: 3; " +
                "-fx-background-radius: 3; " +
                "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.6), 5, 0.0, 0, 1);"
            );
        } else {
            executeButton.setStyle(
                "-fx-background-color: #4285f4; " +
                "-fx-text-fill: white; " +
                "-fx-font-weight: bold; " +
                "-fx-border-radius: 3; " +
                "-fx-background-radius: 3; " +
                "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.3), 5, 0.0, 0, 1);"
            );
        }
        
        // إضافة تأثيرات تفاعلية على الزر
        executeButton.setOnMouseEntered(e -> {
            if (isDark) {
                executeButton.setStyle(
                    "-fx-background-color: #4a90e2; " +
                    "-fx-text-fill: white; " +
                    "-fx-font-weight: bold; " +
                    "-fx-border-radius: 3; " +
                    "-fx-background-radius: 3; " +
                    "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 7, 0.0, 0, 2);"
                );
            } else {
                executeButton.setStyle(
                    "-fx-background-color: #5c9afe; " +
                    "-fx-text-fill: white; " +
                    "-fx-font-weight: bold; " +
                    "-fx-border-radius: 3; " +
                    "-fx-background-radius: 3; " +
                    "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.5), 7, 0.0, 0, 2);"
                );
            }
        });
        
        executeButton.setOnMouseExited(e -> {
            if (isDark) {
                executeButton.setStyle(
                    "-fx-background-color: #1a73e8; " +
                    "-fx-text-fill: white; " +
                    "-fx-font-weight: bold; " +
                    "-fx-border-radius: 3; " +
                    "-fx-background-radius: 3; " +
                    "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.6), 5, 0.0, 0, 1);"
                );
            } else {
                executeButton.setStyle(
                    "-fx-background-color: #4285f4; " +
                    "-fx-text-fill: white; " +
                    "-fx-font-weight: bold; " +
                    "-fx-border-radius: 3; " +
                    "-fx-background-radius: 3; " +
                    "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.3), 5, 0.0, 0, 1);"
                );
            }
        });
        
    }

    public static void main(String[] args) {
    	Application.launch(args);
        Scanner scanner = new Scanner(System.in);
        AllOperations ops = new AllOperations();
        File WriteTheDate = new File("WriteTheDate.txt");
        File readTheStatistic = new File("ReadTheStatistic.txt");

        try {
            if (!WriteTheDate.exists()) WriteTheDate.createNewFile();
            if (!readTheStatistic.exists()) readTheStatistic.createNewFile();
        } catch (IOException e) {
            System.err.println("Error creating files: " + e.getMessage());
            return; // Exit if files can't be created
        }

        System.out.print("Enter your text: ");
        String input = scanner.nextLine();
        ops.setText(input);

        mainLoop:
        while (true) {
            try {
                System.out.println("\nChoose an operation category:");
                System.out.println("1. Adding Operations");
                System.out.println("2. Deleting Operations");
                System.out.println("3. Printing Operations");
                System.out.println("4. Traversal Operations");
                System.out.println("0. Exit and show file info");
                System.out.print("Your choice: ");
                
                int opCat;
                try {
                    opCat = scanner.nextInt();
                } catch (InputMismatchException e) {
                    scanner.nextLine(); // Clear the invalid input
                    System.err.println("Error: Please enter a valid number.");
                    continue;
                }
                scanner.nextLine(); // Clean buffer

                if (opCat == 0) break mainLoop;

                switch (opCat) {
                    case 1:
                        handleAddingOperations(scanner, ops);
                        break;
                    case 2:
                        handleDeletingOperations(scanner, ops);
                        break;
                    case 3:
                        handlePrintingOperations(scanner, ops);
                        break;
                    case 4:
                        handleTraversalOperations(scanner, ops);
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid operation category: " + opCat);
                }
            } catch (IllegalArgumentException e) {
                System.err.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.err.println("Unexpected error occurred: " + e.getMessage());
                e.printStackTrace();
            }
        }
        
        try {
            displayFileProperties(WriteTheDate);
            displayFileProperties(readTheStatistic);
            System.out.println("");
            ops.writeFile(WriteTheDate);
            System.out.println("");
            ops.readFile(readTheStatistic);
        } catch (IOException e) {
            System.err.println("Error handling files: " + e.getMessage());
        } finally {
            System.out.println("\nClosing resources...");
            if (scanner != null) {
                scanner.close();
                System.out.println("Scanner closed successfully.");
            }
            System.out.println("Program terminated.");
        }
    }



    private static void handleAddingOperations(Scanner scanner, AllOperations ops) {
        System.out.println("\nAddition operations:");
        System.out.println("1. insertLast\n2. insertBeforeLast\n3. insertBeforeAndAfterLast\n4. insertFirst\n5. insertAfterFirst\n6. insertBeforeAndAfterFirst\n7. insertAfterElement\n8. insertAfterAllElement\n9. insertBeforeElement\n10. insertBeforeAllElement\n11. insertBeforeAndAfterElement\n12. insertBeforeAndAfterAllElement\n13. insertElementWithStartingFirstIndex\n14. insertElementWithStartingLastIndex");
        System.out.println("0. Back to operation category");
        System.out.print("Your choice: ");
        
        int addOp;
        try {
            addOp = scanner.nextInt();
        } catch (InputMismatchException e) {
            scanner.nextLine(); // Clear the invalid input
            System.err.println("Error: Please enter a valid number.");
            return;
        }
        scanner.nextLine();
        
        if (addOp == 0) return;
        
        System.out.print("Enter text to insert: ");
        String ins = scanner.nextLine();
        
        try {
            switch (addOp) {
                case 1: System.out.println("Result: " + ops.insertLast(ins)); break;
                case 2: System.out.println("Result: " + ops.insertBeforeLast(ins)); break;
                case 3: System.out.println("Result: " + ops.insertBeforeAndAfterLast(ins)); break;
                case 4: System.out.println("Result: " + ops.insertFirst(ins)); break;
                case 5: System.out.println("Result: " + ops.insertAfterFirst(ins)); break;
                case 6: System.out.println("Result: " + ops.insertBeforeAndAfterFirst(ins)); break;
                case 7: 
                    System.out.print("Enter the Element you want to add After first Element: ");
                    String el1 = scanner.nextLine();
                    if (el1.isEmpty()) {
                        throw new IllegalArgumentException("Element cannot be empty");
                    }
                    System.out.println("Result: " + ops.insertAfterElement(el1, ins)); 
                    break;
                case 8:
                    System.out.print("Enter the Element you want to add after all similar Element: ");
                    String el2 = scanner.nextLine();
                    System.out.println("Result: " + ops.insertAfterAllElement(el2, ins)); 
                    break;
                case 9:
                    System.out.print("Enter the Element you want to add before first Element: ");
                    String el3 = scanner.nextLine();
                    System.out.println("Result: " + ops.insertBeforeElement(el3, ins)); 
                    break;
                case 10:
                    System.out.print("Enter the Element you want to add before all similar Element: ");
                    String el4 = scanner.nextLine();
                    System.out.println("Result: " + ops.insertBeforeAllElement(el4, ins)); 
                    break;
                case 11:
                    System.out.print("Enter the Element you want to add before and after similar Element: ");
                    String el5 = scanner.nextLine();
                    System.out.println("Result: " + ops.insertBeforeAndAfterElement(el5, ins)); 
                    break;
                case 12:
                    System.out.print("Enter the Element you want to add before and after All similar Element: ");
                    String el6 = scanner.nextLine();
                    System.out.println("Result: " + ops.insertBeforeAndAfterAllElement(el6, ins)); 
                    break;
                case 13:
                    System.out.print("Enter the Element you want to add with Starting First index: ");
                    int in1;
                    try {
                        in1 = scanner.nextInt();
                        if (in1 < 0) {
                            throw new IndexOutOfBoundsException("Index cannot be negative");
                        }
                    } catch (InputMismatchException e) {
                        scanner.nextLine(); // Clear the invalid input
                        throw new IllegalArgumentException("Please enter a valid number");
                    }
                    scanner.nextLine(); // Clear buffer
                    System.out.println("Result: " + ops.insertElementWithStartingFirstIndex(in1, ins)); 
                    break;
                case 14:
                    System.out.print("Enter the Element you want to add with Starting Last index: ");
                    int in2;
                    try {
                        in2 = scanner.nextInt();
                        if (in2 < 0) {
                            throw new IndexOutOfBoundsException("Index cannot be negative");
                        }
                    } catch (InputMismatchException e) {
                        scanner.nextLine(); // Clear the invalid input
                        throw new IllegalArgumentException("Please enter a valid number");
                    }
                    scanner.nextLine(); // Clear buffer
                    System.out.println("Result: " + ops.insertElementWithStartingLastIndex(in2, ins)); 
                    break;
                default: throw new IllegalArgumentException("Invalid addition operation: " + addOp);
            }
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Error: Index out of bounds - " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Unexpected error during addition operation: " + e.getMessage());
        }
    }

    private static void handleDeletingOperations(Scanner scanner, AllOperations ops) {
        System.out.println("\nDeletion operations:");
        System.out.println("1. deleteFirstChar\n2. deleteLastChar\n3. deleteAll\n4. deleteElement");
        System.out.println("5. deleteAfterFirstChar\n6. deleteAllAfterFirstChar\n7. deleteBeforeLastChar");
        System.out.println("8. deleteAllBeforeLastChar\n9. deleteAllElement\n10. deleteAfterElement");
        System.out.println("11. deleteAfterAllElement\n12. deleteAllAfterElement\n13. deleteBeforeElement");
        System.out.println("14. deleteBeforeAllElement\n15. deleteAllBeforeElement\n16. deleteBeforeAndAfterElement");
        System.out.println("17. deleteBeforeAndAfterAllElement\n18. deleteCharWithStartingFirstIndex\n19. deleteCharWithLastIndex");
        System.out.println("20. deleteCharWithAnyIndex\n21. deleteStartsIndexToLast\n22. deleteStartsCharToChar");
        System.out.println("23. deleteAllDigits\n24. deleteAllLetters\n25. deleteAllCharExceptDigitsAndLetters");
        System.out.println("0. Back to operation category");
        System.out.print("Your choice: ");
        
        int delOp;
        try {
            delOp = scanner.nextInt();
        } catch (InputMismatchException e) {
            scanner.nextLine(); // Clear the invalid input
            System.err.println("Error: Please enter a valid number.");
            return;
        }
        scanner.nextLine();
        
        if (delOp == 0) return;
        
        try {
            switch (delOp) {
                case 1: 
                    if (ops.getText().isEmpty()) {
                        throw new IllegalStateException("Text is empty, cannot delete first character");
                    }
                    System.out.println("Result: " + ops.deleteFirstChar()); 
                    break;
                case 2: 
                    if (ops.getText().isEmpty()) {
                        throw new IllegalStateException("Text is empty, cannot delete last character");
                    }
                    System.out.println("Result: " + ops.deleteLastChar()); 
                    break;
                case 3: 
                    System.out.println("Result: " + ops.deleteAll()); 
                    break;
                case 4:
                    System.out.print("Enter element to delete: ");
                    String toDel = scanner.nextLine();
                    if (!ops.getText().contains(toDel)) {
                        throw new NoSuchElementException("Element not found in text");
                    }
                    System.out.println("Result: " + ops.deleteElement(toDel));
                    break;
                case 5:
                    if (ops.getText().isEmpty()) {
                        throw new IllegalStateException("Text is empty, cannot delete after first character");
                    }
                    System.out.println("Result: " + ops.deleteAfterFirstChar());
                    break;
                case 6:
                    if (ops.getText().isEmpty()) {
                        throw new IllegalStateException("Text is empty, cannot delete all after first character");
                    }
                    System.out.println("Result: " + ops.deleteAllAfterFirstChar());
                    break;
                case 7:
                    if (ops.getText().isEmpty()) {
                        throw new IllegalStateException("Text is empty, cannot delete before last character");
                    }
                    System.out.println("Result: " + ops.deleteBeforeLastChar());
                    break;
                case 8:
                    if (ops.getText().isEmpty()) {
                        throw new IllegalStateException("Text is empty, cannot delete all before last character");
                    }
                    System.out.println("Result: " + ops.deleteAllBeforeLastChar());
                    break;
                case 9:
                    System.out.print("Enter element to delete all occurrences: ");
                    String toDelAll = scanner.nextLine();
                    System.out.println("Result: " + ops.deleteAllElement(toDelAll));
                    break;
                case 10:
                    System.out.print("Enter element: ");
                    String elem = scanner.nextLine();
                    System.out.println("Result: " + ops.deleteAfterElement(elem));
                    break;
                case 11:
                    System.out.print("Enter element: ");
                    String elemAll = scanner.nextLine();
                    System.out.println("Result: " + ops.deleteAfterAllElement(elemAll));
                    break;
                case 12:
                    System.out.print("Enter element: ");
                    String elemAllAfter = scanner.nextLine();
                    System.out.println("Result: " + ops.deleteAllAfterElement(elemAllAfter));
                    break;
                case 13:
                    System.out.print("Enter element: ");
                    String elemBefore = scanner.nextLine();
                    System.out.println("Result: " + ops.deleteBeforeElement(elemBefore));
                    break;
                case 14:
                    System.out.print("Enter element: ");
                    String elemBeforeAll = scanner.nextLine();
                    System.out.println("Result: " + ops.deleteBeforeAllElement(elemBeforeAll));
                    break;
                case 15:
                    System.out.print("Enter element: ");
                    String elemAllBefore = scanner.nextLine();
                    System.out.println("Result: " + ops.deleteAllBeforeElement(elemAllBefore));
                    break;
                case 16:
                    System.out.print("Enter element: ");
                    String elemBeforeAfter = scanner.nextLine();
                    System.out.println("Result: " + ops.deleteBeforeAndAfterElement(elemBeforeAfter));
                    break;
                case 17:
                    System.out.print("Enter element: ");
                    String elemBeforeAfterAll = scanner.nextLine();
                    System.out.println("Result: " + ops.deleteBeforeAndAfterAllElement(elemBeforeAfterAll));
                    break;
                case 18:
                    System.out.print("Enter index: ");
                    int firstIndex;
                    try {
                        firstIndex = scanner.nextInt();
                        if (firstIndex < 0 || firstIndex >= ops.getText().length()) {
                            throw new IndexOutOfBoundsException("Index out of range: " + firstIndex);
                        }
                    } catch (InputMismatchException e) {
                        scanner.nextLine(); // Clear the invalid input
                        throw new IllegalArgumentException("Please enter a valid number");
                    }
                    scanner.nextLine(); // Clear buffer
                    System.out.println("Result: " + ops.DeleteCharWithStartingFirstIndex(firstIndex));
                    break;
                case 19:
                    System.out.print("Enter index: ");
                    int lastIndex;
                    try {
                        lastIndex = scanner.nextInt();
                        if (lastIndex < 0 || lastIndex >= ops.getText().length()) {
                            throw new IndexOutOfBoundsException("Index out of range: " + lastIndex);
                        }
                    } catch (InputMismatchException e) {
                        scanner.nextLine(); // Clear the invalid input
                        throw new IllegalArgumentException("Please enter a valid number");
                    }
                    scanner.nextLine(); // Clear buffer
                    System.out.println("Result: " + ops.deleteCharWithLastIndex(lastIndex));
                    break;
                case 20:
                    System.out.print("Enter index: ");
                    int anyIndex;
                    try {
                        anyIndex = scanner.nextInt();
                        if (anyIndex < 0 || anyIndex >= ops.getText().length()) {
                            throw new IndexOutOfBoundsException("Index out of range: " + anyIndex);
                        }
                    } catch (InputMismatchException e) {
                        scanner.nextLine(); // Clear the invalid input
                        throw new IllegalArgumentException("Please enter a valid number");
                    }
                    scanner.nextLine(); // Clear buffer
                    System.out.println("Result: " + ops.deleteCharWithAnyIndex(anyIndex));
                    break;
                case 21:
                    System.out.print("Enter start index: ");
                    int startIndex;
                    int endIndex;
                    try {
                        startIndex = scanner.nextInt();
                        System.out.print("Enter end index: ");
                        endIndex = scanner.nextInt();
                        
                        if (startIndex < 0 || startIndex >= ops.getText().length() ||
                            endIndex < 0 || endIndex >= ops.getText().length() ||
                            startIndex > endIndex) {
                            throw new IndexOutOfBoundsException("Invalid index range: " + startIndex + " to " + endIndex);
                        }
                    } catch (InputMismatchException e) {
                        scanner.nextLine(); // Clear the invalid input
                        throw new IllegalArgumentException("Please enter valid numbers");
                    }
                    scanner.nextLine(); // Clear buffer
                    System.out.println("Result: " + ops.deleteStartsIndexToLast(startIndex, endIndex));
                    break;
                case 22:
                    System.out.print("Enter first character: ");
                    char c1;
                    char c2;
                    try {
                        c1 = scanner.nextLine().charAt(0);
                        System.out.print("Enter second character: ");
                        c2 = scanner.nextLine().charAt(0);
                    } catch (StringIndexOutOfBoundsException e) {
                        throw new IllegalArgumentException("Please enter valid characters");
                    }
                    System.out.println("Result: " + ops.deleteStartsCharToChar(c1, c2));
                    break;
                case 23:
                    System.out.println("Result: " + ops.deleteAllDigits());
                    break;
                case 24:
                    System.out.println("Result: " + ops.deleteAllLetters());
                    break;
                case 25:
                    System.out.println("Result: " + ops.deleteAllCharExceptDigitsAndLetters());
                    break;
                default: 
                    throw new IllegalArgumentException("Invalid deletion operation: " + delOp);
            }
        } catch (NoSuchElementException e) {
            System.err.println("Warning: " + e.getMessage());
        } catch (IllegalStateException | IllegalArgumentException | IndexOutOfBoundsException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Unexpected error during deletion operation: " + e.getMessage());
        }
    }

    private static void handlePrintingOperations(Scanner scanner, AllOperations ops) {
        System.out.println("\nPrint operations:");
        System.out.println("1. printFirstLetter\n2. printLastLetter\n3. printFirstWord\n4. printLastWord");
        System.out.println("5. printFirstSentence\n6. printLastSentence\n7. printSize\n8. printCapacity");
        System.out.println("9. printChar\n10. printElement");
        System.out.println("11. printIndexOfFirst\n12. printIndexOfLast\n13. printIndexOfAll");
        System.out.println("0. Back to operation category");
        System.out.print("Your choice: ");
        
        int prOp;
        try {
            prOp = scanner.nextInt();
        } catch (InputMismatchException e) {
            scanner.nextLine(); // Clear the invalid input
            System.err.println("Error: Please enter a valid number.");
            return;
        }
        scanner.nextLine();
        
        if (prOp == 0) return;
        
        try {
            switch (prOp) {
                case 1: 
                    if (ops.getText().isEmpty()) {
                        throw new IllegalStateException("Text is empty, cannot print first letter");
                    }
                    System.out.println("Result: " + ops.printFirstLetter()); 
                    break;
                case 2: 
                    if (ops.getText().isEmpty()) {
                        throw new IllegalStateException("Text is empty, cannot print last letter");
                    }
                    System.out.println("Result: " + ops.printLastLetter()); 
                    break;
                case 3: 
                    if (ops.getText().isEmpty()) {
                        throw new IllegalStateException("Text is empty, cannot print first word");
                    }
                    System.out.println("Result: " + ops.printFirstWord()); 
                    break;
                case 4: 
                    if (ops.getText().isEmpty()) {
                        throw new IllegalStateException("Text is empty, cannot print last word");
                    }
                    System.out.println("Result: " + ops.printLastWord()); 
                    break;
                case 5: 
                    if (ops.getText().isEmpty()) {
                        throw new IllegalStateException("Text is empty, cannot print first sentence");
                    }
                    System.out.println("Result: " + ops.printFirstSentence()); 
                    break;
                case 6: 
                    if (ops.getText().isEmpty()) {
                        throw new IllegalStateException("Text is empty, cannot print last sentence");
                    }
                    System.out.println("Result: " + ops.printLastSentence()); 
                    break;
                case 7: System.out.println("Result: " + ops.printSize()); break;
                case 8: System.out.println("Result: " + ops.printCapacity()); break;
                case 9:
                    System.out.print("Enter index: ");
                    int idx;
                    try {
                        idx = scanner.nextInt();
                        if (idx < 0 || idx >= ops.getText().length()) {
                            throw new IndexOutOfBoundsException("Index out of range: " + idx);
                        }
                    } catch (InputMismatchException e) {
                        scanner.nextLine(); // Clear the invalid input
                        throw new IllegalArgumentException("Please enter a valid number");
                    }
                    scanner.nextLine();
                    System.out.println("Result: " + ops.printChar(idx));
                    break;
                case 10:
                    System.out.print("Enter start index: ");
                    int startIdx;
                    int endIdx;
                    try {
                        startIdx = scanner.nextInt();
                        System.out.print("Enter end index: ");
                        endIdx = scanner.nextInt();
                        
                        if (startIdx < 0 || startIdx >= ops.getText().length() ||
                            endIdx < 0 || endIdx >= ops.getText().length() ||
                            startIdx > endIdx) {
                            throw new IndexOutOfBoundsException("Invalid index range: " + startIdx + " to " + endIdx);
                        }
                    } catch (InputMismatchException e) {
                        scanner.nextLine(); // Clear the invalid input
                        throw new IllegalArgumentException("Please enter valid numbers");
                    }
                    scanner.nextLine();
                    System.out.println("Result: " + ops.PrintElement(startIdx, endIdx));
                    break;
                case 11:
                    System.out.print("Enter element: ");
                    String e1 = scanner.nextLine();
                    System.out.println("Result: " + ops.printIndexOfFirstElement(e1));
                    break;
                case 12:
                    System.out.print("Enter element: ");
                    String e2 = scanner.nextLine();
                    System.out.println("Result: " + ops.printIndexOfLastElement(e2));
                    break;
                case 13:
                    System.out.print("Enter element: ");
                    String e3 = scanner.nextLine();
                    int[] arr = ops.printIndexOfAllElement(e3);
                    System.out.println("Result: " + Arrays.toString(arr));
                    break;
                default: throw new IllegalArgumentException("Invalid print operation: " + prOp);
            }
        } catch (IllegalStateException | IllegalArgumentException | IndexOutOfBoundsException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Unexpected error during print operation: " + e.getMessage());
        }
    }

    private static void handleTraversalOperations(Scanner scanner, AllOperations ops) {
        System.out.println("\nTraversal operations:");
        System.out.println("1. convertWordsToArray\n2. convertLettersToArray\n3. shuffleWords\n4. shuffleLetters");
        System.out.println("5. reverse\n6. sortLettersAsc\n7. sortLettersDesc\n8. search");
        System.out.println("9. updateElementWithIndex\n10. updateElementWithNewValue\n11. updateAllElementWithNewValue\n12. Sum");
        System.out.println("0. Back to operation category");
        System.out.print("Your choice: ");
        
        int travOp;
        try {
            travOp = scanner.nextInt();
        } catch (InputMismatchException e) {
            scanner.nextLine(); // Clear the invalid input
            System.err.println("Error: Please enter a valid number.");
            return;
        }
        scanner.nextLine();
        
        if (travOp == 0) return;
        
        try {
            switch (travOp) {
                case 1: 
                    if (ops.getText().isEmpty()) {
                        throw new IllegalStateException("Text is empty, cannot convert to words array");
                    }
                    String[] words = ops.convertWordsToArray();
                    System.out.println("Result: " + Arrays.toString(words)); 
                    break;
                case 2: 
                    if (ops.getText().isEmpty()) {
                        throw new IllegalStateException("Text is empty, cannot convert to letters array");
                    }
                    char[] letters = ops.convertLettersToArray();
                    System.out.println("Result: " + Arrays.toString(letters)); 
                    break;
                case 3: 
                    if (ops.getText().isEmpty()) {
                        throw new IllegalStateException("Text is empty, cannot shuffle words");
                    }
                    System.out.println("Result: " + ops.shuffleWords()); 
                    break;
                case 4: 
                    if (ops.getText().isEmpty()) {
                        throw new IllegalStateException("Text is empty, cannot shuffle letters");
                    }
                    System.out.println("Result: " + ops.shuffleLetters()); 
                    break;
                case 5: 
                    if (ops.getText().isEmpty()) {
                        throw new IllegalStateException("Text is empty, cannot reverse");
                    }
                    System.out.println("Result: " + ops.reverse()); 
                    break;
                case 6: 
                    if (ops.getText().isEmpty()) {
                        throw new IllegalStateException("Text is empty, cannot sort letters");
                    }
                    System.out.println("Result: " + ops.sortLettersAsc()); 
                    break;
                case 7: 
                    if (ops.getText().isEmpty()) {
                        throw new IllegalStateException("Text is empty, cannot sort letters");
                    }
                    System.out.println("Result: " + ops.sortLettersDesc()); 
                    break;
                case 8:
                    System.out.print("Enter substring to search: ");
                    String sub = scanner.nextLine();
                    System.out.println("Found? " + ops.search(sub));
                    break;
                case 9:
                    System.out.print("Enter start index: ");
                    int start;
                    int end;
                    try {
                        start = scanner.nextInt();
                        System.out.print("Enter end index: ");
                        end = scanner.nextInt();
                        
                        if (start < 0 || start >= ops.getText().length() ||
                            end < 0 || end >= ops.getText().length() ||
                            start > end) {
                            throw new IndexOutOfBoundsException("Invalid index range: " + start + " to " + end);
                        }
                    } catch (InputMismatchException e) {
                        scanner.nextLine(); // Clear the invalid input
                        throw new IllegalArgumentException("Please enter valid numbers");
                    }
                    scanner.nextLine(); // Clear buffer
                    
                    System.out.print("Enter new element: ");
                    String newElement = scanner.nextLine();
                    
                    try {
                        ops.updateByIndex(start, end, newElement);
                        System.out.println("Updated successfully.");
                    } catch (Exception e) {
                        throw new RuntimeException("Update failed: " + e.getMessage());
                    }
                    break;
                case 10:
                    System.out.print("Enter old value: ");
                    String oldValue = scanner.nextLine();
                    System.out.print("Enter new value: ");
                    String newValue = scanner.nextLine();
                    String success = ops.updateFirst(oldValue, newValue);
                    break;
                case 11:
                    System.out.print("Enter old value: ");
                    String oldVal = scanner.nextLine();
                    System.out.print("Enter new value: ");
                    String newVal = scanner.nextLine();
                   ops.updateAll(oldVal, newVal);
                    break;
                case 12:
                    System.out.print("Enter the First Number: ");
                    String input1 = scanner.nextLine();
                    
                    System.out.print("Enter the Second Number: ");
                    String input2 = scanner.nextLine();
                    
                    Number n1 = null;
                    Number n2 = null;
                    
                    try {
                        n1 = parseDynamicNumber(input1);
                        n2 = parseDynamicNumber(input2);
                        
                        if (n1 == null || n2 == null) {
                            throw new IllegalArgumentException("One of the inputs is not a valid number");
                        }
                        
                        Number result = ops.sum(n1, n2);
                        System.out.println("Result: " + result);
                    } catch (ArithmeticException e) {
                        System.err.println("Arithmetic error: " + e.getMessage());
                    } catch (IllegalArgumentException e) {
                        System.err.println("Input error: " + e.getMessage());
                    }
                    break;
                default: 
                    throw new IllegalArgumentException("Invalid traversal operation: " + travOp);
            }
        } catch (IllegalStateException | IllegalArgumentException | IndexOutOfBoundsException | NoSuchElementException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Unexpected error during traversal operation: " + e.getMessage());
        }
    }

    private static void displayFileProperties(File file) throws IOException {
        if (file == null) {
            throw new IllegalArgumentException("File cannot be null");
        }
        
        System.out.println("\n==== File Properties for " + file.getName() + " ====");
        System.out.println("- exists: " + file.exists());
        System.out.println("- canRead: " + file.canRead());
        System.out.println("- canWrite: " + file.canWrite());
        System.out.println("- isDirectory: " + file.isDirectory());
        System.out.println("- isFile: " + file.isFile());
        System.out.println("- isAbsolute: " + file.isAbsolute());
        System.out.println("- isHidden: " + file.isHidden());
        
        try {
            System.out.println("- getAbsolutePath: " + file.getAbsolutePath());
            System.out.println("- getCanonicalPath: " + file.getCanonicalPath());
        } catch (IOException e) {
            throw new IOException("Error getting canonical path: " + e.getMessage());
        }
        
        System.out.println("- getName: " + file.getName());
        System.out.println("- getPath: " + file.getPath());
        System.out.println("- getParent: " + (file.getParent() != null ? file.getParent() : "null"));
        
        Date lastModified = new Date(file.lastModified());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("- lastModified: " + sdf.format(lastModified));
        System.out.println("- length: " + file.length() + " bytes");
    }
    
    public static Number parseDynamicNumber(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("Input cannot be null or empty");
        }
        
        try {
            if (input.contains(".")) {
                double d = Double.parseDouble(input);
                if (d <= Float.MAX_VALUE && d >= -Float.MAX_VALUE) {
                    return (float) d;
                } else {
                    return d;
                }
            } else {
                long l = Long.parseLong(input);
                if (l <= Byte.MAX_VALUE && l >= Byte.MIN_VALUE) {
                    return (byte) l;
                } else if (l <= Short.MAX_VALUE && l >= Short.MIN_VALUE) {
                    return (short) l;
                } else if (l <= Integer.MAX_VALUE && l >= Integer.MIN_VALUE) {
                    return (int) l;
                } else {
                    return l;
                }
            }
        } catch (NumberFormatException e) {
            return null;
        }
    }

	
}
