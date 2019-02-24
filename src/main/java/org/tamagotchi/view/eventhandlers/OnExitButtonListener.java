package org.tamagotchi.view.eventhandlers;

import javafx.animation.FadeTransition;
import javafx.animation.FillTransition;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBase;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.util.Duration;


public class OnExitButtonListener implements EventHandler<MouseEvent> {
    public void handle(MouseEvent event) {
        FadeTransition fadeTransition = new FadeTransition(Duration.millis(200));
        if (event.getSource() instanceof Button) {
            Button currentButton = (Button) event.getSource();
            playTransition(fadeTransition, currentButton);
        } else {
            ToggleButton currentButton = (ToggleButton) event.getSource();
            fadeTransition.setNode(currentButton);
            playTransition(fadeTransition, currentButton);
        }
    }

    private void playTransition(FadeTransition fadeTransition, ButtonBase button) {
        fadeTransition.setNode(button);
        fadeTransition.setFromValue(1.0f);
        fadeTransition.setToValue(0.5f);
        fadeTransition.play();
    }
}
