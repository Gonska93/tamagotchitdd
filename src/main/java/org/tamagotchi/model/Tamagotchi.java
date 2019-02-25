package org.tamagotchi.model;

public class Tamagotchi {
    private int healthPoints;
    private int tireness;
    private int hunger;

    public Tamagotchi() {
        healthPoints = 100;
        tireness = 0;
        hunger = 0;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public int getTireness() {
        return tireness;
    }

    public void setTireness(int tireness) {
        this.tireness = tireness;
    }

    public int getHunger() {
        return hunger;
    }

    public void setHunger(int hunger) {
        this.hunger = hunger;
    }
}
