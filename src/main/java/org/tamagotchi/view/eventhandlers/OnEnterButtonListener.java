package org.tamagotchi.view.eventhandlers;

import javafx.animation.FadeTransition;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBase;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;


public class OnEnterButtonListener implements EventHandler<MouseEvent> {

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
        fadeTransition.setFromValue(0.5f);
        fadeTransition.setToValue(1.0f);
        fadeTransition.play();
    }
}
