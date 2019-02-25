package org.tamagotchi.controller;

import org.tamagotchi.model.Config;
import org.tamagotchi.model.Tamagotchi;

import java.util.Observable;

public class GameController extends Observable implements Runnable {
    private Tamagotchi tamagotchi;
    private boolean runningState;

    public GameController(boolean runningState) {
        tamagotchi = new Tamagotchi();
        this.runningState = runningState;
    }

    private void updateView() {
        setChanged();
        notifyObservers(tamagotchi);
    }

    private void processCycle() {
        System.out.println(tamagotchi.getHealthPoints());
        if (tamagotchi.getHunger() > 99) {
            tamagotchi.setHealthPoints(tamagotchi.getHealthPoints() - 1);
            this.updateView();
        } else if (tamagotchi.getTireness() < 1) {
            tamagotchi.setHealthPoints(tamagotchi.getHealthPoints() - 1);
            this.updateView();
        }
    }

    public void run() {
        while (runningState) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (Config.hasStarted) {
                this.processCycle();
            }
        }
    }
}
