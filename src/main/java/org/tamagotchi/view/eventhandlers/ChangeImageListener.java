package org.tamagotchi.view.eventhandlers;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class ChangeImageListener implements ChangeListener {
    private ImageView imageHolder;

    public ChangeImageListener(ImageView imageHolder) {
        this.imageHolder = imageHolder;
    }

    public void changed(ObservableValue observable, Object oldValue, Object newValue) {
        if (oldValue == null) return;
        RadioButton currentButton = (RadioButton) observable.getValue();
        RadioButton nextValueButton = (RadioButton) newValue;

        ToggleGroup tg = currentButton.getToggleGroup();

        if (tg.getSelectedToggle() != null) {
            String color = tg.getSelectedToggle().getUserData().toString();
            String path = String.format("/tamagotchi/%s/left1.png", color);
            Image image = new Image(getClass().getResourceAsStream(path));

            KeyFrame keyFrame1On = new KeyFrame(Duration.seconds(0), new KeyValue(imageHolder.imageProperty(), imageHolder.getImage()));
            KeyFrame startFadeOut = new KeyFrame(Duration.seconds(0.1), new KeyValue(imageHolder.opacityProperty(), 1.0));

            //Two below frames must have the same duration!
            KeyFrame endFadeOut = new KeyFrame(Duration.seconds(0.5), new KeyValue(imageHolder.opacityProperty(), 0.0));
            KeyFrame keyFrame2On = new KeyFrame(Duration.seconds(0.5), new KeyValue(imageHolder.imageProperty(), image));

            KeyFrame endFadeIn = new KeyFrame(Duration.seconds(1), new KeyValue(imageHolder.opacityProperty(), 1.0));

            Timeline timelineOn = new Timeline(keyFrame1On, startFadeOut, endFadeOut, keyFrame2On, endFadeIn);
            timelineOn.setAutoReverse(false);
            timelineOn.play();
        }
    }
}