package org.tamagotchi.view.eventhandlers;


import javafx.event.Event;
import javafx.event.EventHandler;


public class CloseButtonHandler implements EventHandler {
    public void handle(Event event) {
        System.exit(0);
    }
}
