package org.tamagotchi.controller;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import org.tamagotchi.view.GotchiColor;
import org.tamagotchi.view.GraphicSettings;
import org.tamagotchi.view.eventhandlers.ChangeImageListener;
import org.tamagotchi.view.eventhandlers.CloseButtonHandler;
import org.tamagotchi.view.eventhandlers.OnEnterButtonListener;
import org.tamagotchi.view.eventhandlers.OnExitButtonListener;

public class MenuPanelController {

    @FXML
    private VBox mainMenuContainer;

    @FXML
    private Button startButton;

    @FXML
    private Button quitButton;

    @FXML
    private HBox toggleButtonsContainer;

    @FXML
    private ToggleButton firstToggleButton;

    @FXML
    private ToggleButton secondToggleButton;

    @FXML
    private ToggleButton thirdToggleButton;

    @FXML
    private BorderPane choiceImageBorderPane;

    @FXML
    private ImageView choiceImageView;

    @FXML
    private ToggleGroup toggleGroup;

    @FXML
    public void initialize() {
        mainMenuContainer.setMaxWidth(GraphicSettings.MENU_PANEL_WIDTH);
        mainMenuContainer.setMaxHeight(GraphicSettings.MENU_PANEL_HEIGHT);
        setupChoiceContainer();
        setupButtonContainer();
    }

    private void setupButtonContainer() {
        startButton.setPrefWidth(GraphicSettings.BUTTON_WIDTH);
        startButton.setOnMouseEntered(new OnEnterButtonListener());
        startButton.setOnMouseExited(new OnExitButtonListener());

        quitButton.setPrefWidth(GraphicSettings.BUTTON_WIDTH);
        quitButton.setOnAction(new CloseButtonHandler());
        quitButton.setOnMouseEntered(new OnEnterButtonListener());
        quitButton.setOnMouseExited(new OnExitButtonListener());
    }

    private void setupChoiceContainer() {
        choiceImageBorderPane.setPrefWidth(GraphicSettings.IMAGE_WIDTH);
        choiceImageBorderPane.setPrefHeight(GraphicSettings.IMAGE_HEIGHT);

        toggleGroup.selectedToggleProperty().addListener(new ChangeImageListener(choiceImageView, toggleGroup));
        firstToggleButton.setUserData(GotchiColor.BLUE);
        firstToggleButton.setPrefWidth(GraphicSettings.TOGGLE_BUTTON_WIDTH);
        firstToggleButton.setDisable(true);

        secondToggleButton.setUserData(GotchiColor.YELLOW);
        secondToggleButton.setPrefWidth(GraphicSettings.TOGGLE_BUTTON_WIDTH);

        thirdToggleButton.setUserData(GotchiColor.ORANGE);
        thirdToggleButton.setPrefWidth(GraphicSettings.TOGGLE_BUTTON_WIDTH);
    }
}
