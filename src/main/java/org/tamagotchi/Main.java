package org.tamagotchi;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.tamagotchi.view.MainScene;

public class Main extends Application {
    private double xOffset;
    private double yOffset;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
        StackPane root = new StackPane();
        root.setStyle("-fx-background-color: transparent;");
        root.setOnMousePressed(new OnWindowPressedHandler());
        root.setOnMouseDragged(new OnWindowDraggedHandler(primaryStage));

        Parent menuPanel = FXMLLoader.load(getClass().getResource("/fxml/MenuPanel.fxml"));
        root.getChildren().add(menuPanel);
        MainScene mainScene = new MainScene(root);

        primaryStage.setScene(mainScene);
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.setResizable(false);
        primaryStage.sizeToScene();
        primaryStage.setTitle("Tamagotchi");
        primaryStage.show();
    }

    private class OnWindowDraggedHandler implements EventHandler<MouseEvent> {
        private Stage stage;
        public OnWindowDraggedHandler(Stage stage) {
            this.stage = stage;
        }

        public void handle(MouseEvent event) {
            stage.setX(event.getScreenX() - xOffset);
            stage.setY(event.getScreenY() - yOffset);
        }
    }

    public class OnWindowPressedHandler implements EventHandler<MouseEvent> {
        public void handle(MouseEvent event) {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        }
    }
}
