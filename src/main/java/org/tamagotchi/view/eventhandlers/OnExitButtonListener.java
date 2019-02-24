package org.tamagotchi.view.eventhandlers;

import javafx.animation.FadeTransition;
import javafx.animation.FillTransition;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.util.Duration;


public class OnExitButtonListener implements EventHandler<MouseEvent> {
    public void handle(MouseEvent event) {
        Button currentButton = (Button) event.getSource();

        FadeTransition fadeTransition = new FadeTransition(Duration.millis(200), currentButton);
        fadeTransition.setFromValue(1.0f);
        fadeTransition.setToValue(0.5f);
        fadeTransition.play();
    }
}
