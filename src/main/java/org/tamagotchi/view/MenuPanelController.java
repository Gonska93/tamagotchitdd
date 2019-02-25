package org.tamagotchi.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import org.tamagotchi.controller.GameController;
import org.tamagotchi.model.GotchiColor;
import org.tamagotchi.view.eventhandlers.*;

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
    private StackPane choiceImageStackPane;

    @FXML
    private ImageView choiceImageView;

    @FXML
    private Rectangle backgroundRectangle;

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
        quitButton.setOnMouseEntered(new OnEnterButtonListener());
        quitButton.setOnMouseExited(new OnExitButtonListener());
    }

    private void setupChoiceContainer() {
        choiceImageStackPane.setPrefWidth(GraphicSettings.IMAGE_WIDTH);
        choiceImageStackPane.setPrefHeight(GraphicSettings.IMAGE_HEIGHT);

        toggleGroup.selectedToggleProperty().addListener(new ChangeImageListener(choiceImageView, toggleGroup));
        backgroundRectangle.setArcHeight(96.0);
        backgroundRectangle.setArcWidth(96.0);
        Image backgroundImage = new Image(getClass().getResourceAsStream("/background.png"));
        backgroundRectangle.setFill(new ImagePattern(backgroundImage));
        firstToggleButton.setUserData(GotchiColor.BLUE);
        firstToggleButton.setPrefWidth(GraphicSettings.TOGGLE_BUTTON_WIDTH);
        firstToggleButton.setDisable(true);

        secondToggleButton.setUserData(GotchiColor.YELLOW);
        secondToggleButton.setPrefWidth(GraphicSettings.TOGGLE_BUTTON_WIDTH);

        thirdToggleButton.setUserData(GotchiColor.ORANGE);
        thirdToggleButton.setPrefWidth(GraphicSettings.TOGGLE_BUTTON_WIDTH);
    }

    public void setupStartButtonHandler(Stage stage, GameController gameController) {
        startButton.setOnMouseClicked(new OnStartButtonClickHandler(stage, toggleButtonsContainer, backgroundRectangle, gameController));
    }

    public void setupCloseButtonHandler(boolean runningState) {
        quitButton.setOnAction(new OnCloseButtonClickHandler(runningState));
    }
}
