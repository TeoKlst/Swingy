package app;

import controller.Actions;
import java.util.Scanner;
import java.io.IOException;

import controller.HeroSave;
import view.Map;
import view.Menu;
import model.Hero;
import model.Villains;

class Main {
    Actions actions;
    static Scanner console = new Scanner(System.in);

    public static void SwingRun() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (Menu.GameState) {
                    Map.mapDisplay();
                    System.out.print("Choose Direction: ");
                    System.out.println("Left, Right, Up or Down.");
                    Map.Direction = console.nextLine();
                    try {
                        Actions.menuActions();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Actions.heroActions();
                    Actions.heroMovement();
                    Map.assignHero(Hero.getCoordX(), Hero.getCoordY());
                }
            }
        }).start();
    }
    public static void main(String[] args) throws Exception {
        Menu.menuSelection();
        if (Menu.CL == true) {
            Hero.createHero();
            Map.mapGeneration();
            Villains.villainGenerate();
            Map.assignHeroCL();
        }
        else {
            HeroSave.loadHero();
            Map.assignHeroCL();
        }
        SwingRun();
    }
}