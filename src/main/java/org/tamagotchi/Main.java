package org.tamagotchi;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.tamagotchi.controller.GameController;
import org.tamagotchi.view.GraphicSettings;
import org.tamagotchi.view.MainScene;
import org.tamagotchi.view.MenuPanelController;
import org.tamagotchi.view.eventhandlers.OnCloseButtonClickHandler;

public class Main extends Application {
    private double xOffset;
    private double yOffset;
    private boolean isRunning = true;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
        GameController gameController = new GameController(isRunning);
        new Thread(gameController).start();

        MainScene mainScene = generateMainScene(primaryStage, gameController);
        primaryStage.setHeight(GraphicSettings.WINDOW_HEIGHT/1.5);
        primaryStage.setWidth(GraphicSettings.WINDOW_WIDTH/1.5);

        primaryStage.setOnCloseRequest(new OnCloseButtonClickHandler(isRunning));
        primaryStage.setScene(mainScene);
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.setResizable(true);
        primaryStage.setTitle("Tamagotchi");
        primaryStage.show();
    }

    private MainScene generateMainScene(Stage stage, GameController gameController) throws Exception{
        StackPane root = new StackPane();
        root.setStyle("-fx-background-color: transparent;");
        root.setOnMousePressed(new OnWindowPressedHandler());
        root.setOnMouseDragged(new OnWindowDraggedHandler(stage));

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/MenuPanel.fxml"));
        Parent menuPanel = fxmlLoader.load();
        MenuPanelController menuPanelController = fxmlLoader.getController();
        menuPanelController.setupStartButtonHandler(stage, gameController);
        menuPanelController.setupCloseButtonHandler(isRunning);
        root.getChildren().add(menuPanel);
        MainScene mainScene = new MainScene(root);

        return mainScene;
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
