package org.tamagotchi.view.eventhandlers;


import javafx.event.Event;
import javafx.event.EventHandler;


public class OnCloseButtonClickHandler implements EventHandler {
    private boolean runningState;

    public OnCloseButtonClickHandler(boolean runningState) {
        this.runningState = runningState;
    }
    public void handle(Event event) {
        System.exit(0);
        runningState = false;
    }
}
