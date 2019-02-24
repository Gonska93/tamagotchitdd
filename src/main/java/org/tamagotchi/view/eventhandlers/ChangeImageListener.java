package org.tamagotchi.view.eventhandlers;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class ChangeImageListener implements ChangeListener {
    private ImageView imageHolder;
    private ToggleGroup toggleGroup;

    public ChangeImageListener(ImageView imageHolder, ToggleGroup toggleGroup) {
        this.imageHolder = imageHolder;
        this.toggleGroup = toggleGroup;
    }

    public void changed(ObservableValue observable, Object oldValue, Object newValue) {
        if (null == oldValue || null == observable.getValue()) return;

        if (toggleGroup.getSelectedToggle() != null) {
            Toggle selectedToggle = toggleGroup.getSelectedToggle();
            ((ToggleButton) oldValue).setDisable(false);
            ((ToggleButton) newValue).setDisable(true);
            String color = selectedToggle.getUserData().toString();
            String path = String.format("/tamagotchi/%s/left1.png", color);
            Image image = new Image(getClass().getResourceAsStream(path));

            KeyFrame keyFrame1On = new KeyFrame(Duration.seconds(0), new KeyValue(imageHolder.imageProperty(), imageHolder.getImage()));
            KeyFrame startFadeOut = new KeyFrame(Duration.seconds(0.05), new KeyValue(imageHolder.opacityProperty(), 1.0));

            //Two below frames must have the same duration!
            KeyFrame endFadeOut = new KeyFrame(Duration.seconds(0.25), new KeyValue(imageHolder.opacityProperty(), 0.0));
            KeyFrame keyFrame2On = new KeyFrame(Duration.seconds(0.25), new KeyValue(imageHolder.imageProperty(), image));

            KeyFrame endFadeIn = new KeyFrame(Duration.seconds(0.5), new KeyValue(imageHolder.opacityProperty(), 1.0));

            Timeline timelineOn = new Timeline(keyFrame1On, startFadeOut, endFadeOut, keyFrame2On, endFadeIn);
            timelineOn.setAutoReverse(false);
            timelineOn.play();
        }
    }
}