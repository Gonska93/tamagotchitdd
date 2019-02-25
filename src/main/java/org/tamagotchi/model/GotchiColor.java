package org.tamagotchi.model;

public enum GotchiColor {
    ORANGE("orange"),
    BLUE("blue"),
    YELLOW("yellow");

    private String color;
    private GotchiColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return color;
    }
}