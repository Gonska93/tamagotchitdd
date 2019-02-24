package org.tamagotchi.view;

import javafx.scene.paint.Color;

import java.awt.Toolkit;

public class GraphicSettings {
    // Window Settings
    public static final double WINDOW_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().getWidth() * 0.9;
    public static final double WINDOW_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().getHeight() * 0.9;
    public static final Color BACKGROUND_COLOR = Color.TRANSPARENT;

    // Menu Settings
    public static final double MENU_PANEL_WIDTH = WINDOW_WIDTH*0.3;
    public static final double MENU_PANEL_HEIGHT = WINDOW_HEIGHT*0.6;
    public static final double IMAGE_WIDTH = MENU_PANEL_WIDTH*0.7;
    public static final double IMAGE_HEIGHT = MENU_PANEL_HEIGHT*0.5;
    public static final double BUTTON_WIDTH = MENU_PANEL_WIDTH*0.2;
    public static final double TOGGLE_BUTTON_WIDTH = (IMAGE_WIDTH*0.9)/3;
}
