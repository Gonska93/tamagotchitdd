package org.tamagotchi.view;

import javafx.scene.Parent;
import javafx.scene.Scene;

public class MainScene extends Scene {

    public MainScene(Parent root) {
        super(root);
        this.setFill(GraphicSettings.BACKGROUND_COLOR);
        this.getStylesheets().add("stylesheet.css");
    }
}
