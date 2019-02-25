package org.tamagotchi.view.eventhandlers;

import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.tamagotchi.controller.GameController;
import org.tamagotchi.model.Config;
import org.tamagotchi.view.ProgressBarMenu;

public class OnStartButtonClickHandler implements EventHandler<MouseEvent> {
    private Stage stage;
    private HBox toggleButtonsContainer;
    private Rectangle backgroundRectangle;
    private GameController gameController;

    public OnStartButtonClickHandler(Stage stage, HBox toggleButtonsContainer,
                                     Rectangle backgroundRectangle, GameController gameController) {
        this.stage = stage;
        this.toggleButtonsContainer = toggleButtonsContainer;
        this.backgroundRectangle = backgroundRectangle;
        this.gameController = gameController;
    }

    public void handle(MouseEvent event) {
        Button startButton = (Button) event.getSource();
        Pane parentNode = (Pane) startButton.getParent();
        ProgressBarMenu progressBarMenu = new ProgressBarMenu();
        gameController.addObserver(progressBarMenu);

        removeNode(toggleButtonsContainer, null);
        removeNode(parentNode, progressBarMenu);
        showBackgroundImage();
        Config.hasStarted = true;
        new Thread(gameController).start();
    }

    private void removeNode(final Node node, final Node swapNode) {
        KeyFrame hidingKeyFrame = new KeyFrame(Duration.seconds(1), new KeyValue(node.opacityProperty(), 0));
        Timeline tl = new Timeline(hidingKeyFrame);
        tl.play();
        tl.setOnFinished(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                Pane pane = (Pane) node.getParent();
                pane.getChildren().remove(node);

                if (null != swapNode) {
                    ((BorderPane) pane).setBottom(swapNode);
                    showHiddenNode(swapNode);
                }
            }
        });
    }

    private void showHiddenNode(Node node) {
        KeyFrame hidingKeyFrame = new KeyFrame(Duration.seconds(1), new KeyValue(node.opacityProperty(), 1));
        Timeline tl = new Timeline(hidingKeyFrame);
        tl.play();
    }

    private void showBackgroundImage() {
        KeyFrame hidingKeyFrame = new KeyFrame(Duration.seconds(1), new KeyValue(backgroundRectangle.opacityProperty(), 1));
        Timeline tl = new Timeline(hidingKeyFrame);
        tl.play();
        tl.setOnFinished(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                resizeWindow();
            }
        });
    }

    private void resizeWindow() {
        ScaleTransition st = new ScaleTransition(Duration.seconds(1), stage.getScene().getRoot());
        st.setByX(0.6f);
        st.setByY(0.6f);
        st.play();
    }
}
