package org.tamagotchi.view.eventhandlers;

import javafx.animation.FadeTransition;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;


public class OnEnterButtonListener implements EventHandler<MouseEvent> {
    public void handle(MouseEvent event) {
        Button currentButton = (Button) event.getSource();

        FadeTransition fadeTransition = new FadeTransition(Duration.millis(200), currentButton);
        fadeTransition.setFromValue(0.5f);
        fadeTransition.setToValue(1.0f);
        fadeTransition.play();
    }
}
