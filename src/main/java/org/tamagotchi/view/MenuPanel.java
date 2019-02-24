package org.tamagotchi.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import org.tamagotchi.view.eventhandlers.ChangeImageListener;
import org.tamagotchi.view.eventhandlers.CloseButtonHandler;

public class MenuPanel extends StackPane {
    public MenuPanel() {
        super();
        this.setAlignment(Pos.CENTER);
        this.init();
    }

    private void init() {
        VBox mainContainer = new VBox();
        mainContainer.setId("main-menu-main-container");
        mainContainer.setMaxWidth(GraphicSettings.MENU_PANEL_WIDTH);
        mainContainer.setMaxHeight(GraphicSettings.MENU_PANEL_HEIGHT);
        VBox choiceContainer = createChoiceContainer();
        HBox buttonContainer = createButtonContainer();

        mainContainer.getChildren().addAll(choiceContainer, buttonContainer);
        this.getChildren().addAll(mainContainer);
    }

    private VBox createChoiceContainer() {
        VBox container = new VBox();
        container.setSpacing(10);
        HBox buttonContainer = new HBox();
        BorderPane iconContainer = new BorderPane();
        iconContainer.setId("icon-border-pane");

        final ImageView icon = new ImageView();
        String path = String.format("/tamagotchi/%s/left1.png", "blue");
        Image image = new Image(getClass().getResourceAsStream(path));
        icon.setImage(image);
        iconContainer.setCenter(icon);


        final ToggleGroup tg = new ToggleGroup();
        tg.selectedToggleProperty().addListener(new ChangeImageListener(icon));

        RadioButton rb1 = new RadioButton("Blue");
        rb1.setToggleGroup(tg);
        rb1.setUserData(GotchiColor.BLUE);
        rb1.setSelected(true);

        RadioButton rb2 = new RadioButton("Yellow");
        rb2.setToggleGroup(tg);
        rb2.setUserData(GotchiColor.YELLOW);

        RadioButton rb3 = new RadioButton("Orange");
        rb3.setToggleGroup(tg);
        rb3.setUserData(GotchiColor.ORANGE);

        Insets buttonInsets = new Insets(0, GraphicSettings.BUTTON_SIDE_MARGIN, 0, GraphicSettings.BUTTON_SIDE_MARGIN);
        buttonContainer.setMargin(rb1, buttonInsets);
        buttonContainer.setMargin(rb2, buttonInsets);
        buttonContainer.setMargin(rb3, buttonInsets);
        buttonContainer.getChildren().addAll(rb1, rb2, rb3);
        container.getChildren().addAll(iconContainer, buttonContainer);

        return container;
    }

    private HBox createButtonContainer() {
        HBox buttonContainer = new HBox();

        buttonContainer.setSpacing(10);
        buttonContainer.setAlignment(Pos.CENTER);

        Button startButton = new Button("Start Game");
        startButton.setPrefWidth(GraphicSettings.BUTTON_WIDTH);
        startButton.setFocusTraversable(false);

        Button quitButton = new Button("Quit");
        quitButton.setPrefWidth(GraphicSettings.BUTTON_WIDTH);
        quitButton.setFocusTraversable(false);
        quitButton.setOnAction(new CloseButtonHandler());


        buttonContainer.getChildren().addAll(startButton, quitButton);

        return buttonContainer;
    }
}
