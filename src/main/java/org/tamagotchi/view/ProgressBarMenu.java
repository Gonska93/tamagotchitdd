package org.tamagotchi.view;

import javafx.application.Platform;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.VBox;
import org.tamagotchi.model.Tamagotchi;

import java.util.Observable;
import java.util.Observer;

public class ProgressBarMenu extends VBox implements Observer {
    private ProgressBar healthBar;
    private ProgressBar hungerBar;
    private ProgressBar tirenessBar;

    public ProgressBarMenu() {
        healthBar = new ProgressBar(100);
        hungerBar = new ProgressBar(0);
        tirenessBar = new ProgressBar(0);
        this.getChildren().addAll(healthBar, hungerBar, tirenessBar);
        this.setOpacity(0);

    }

    public void update(Observable o, Object arg) {
        final Tamagotchi tamagotchi = (Tamagotchi) arg;
        Platform.runLater(new Runnable() {
            public void run() {
                healthBar.setProgress(tamagotchi.getHealthPoints()*0.01f);
                hungerBar.setProgress(tamagotchi.getHunger()*0.01f);
                tirenessBar.setProgress(tamagotchi.getTireness()*0.01f);
            }
        });
    }
}
