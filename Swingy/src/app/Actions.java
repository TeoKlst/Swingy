package app;

import app.Map;
import app.Hero;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Actions {
    static Map map;
    static Hero hero;

    public static void heroMovement() {
        if ("up".equals(map.Direction.toLowerCase())) {
            System.out.println("Up Pressed");
            hero.movement();
        }
        if ("right".equals(map.Direction.toLowerCase())) {
            System.out.println("Right Pressed");
            hero.movement();
        }
        if ("down".equals(map.Direction.toLowerCase())) {
            System.out.println("Down Pressed");
            hero.movement();
        }
        if ("left".equals(map.Direction.toLowerCase())) {
            System.out.println("Left Pressed");
            hero.movement();
        }
    }

    public static void heroActions() {
        if ("fight".equals(map.Direction.toLowerCase()))
            System.out.println("Fight Pressed");
        if ("run".equals(map.Direction.toLowerCase()))
            System.out.println("Run Pressed");
        if ("stats".equals(map.Direction.toLowerCase()))
            Hero.getStats();
        if ("equip".equals(map.Direction.toLowerCase()))
            //equip function needed
            Hero.getStats();
    }

    public static void menuActions() throws IOException {
        if("create".equals(map.Direction.toLowerCase())) {
            Hero.createHero();
        }
        if("save".equals(map.Direction.toLowerCase())) {
            HeroSave.saveHero();
        }
        if("load".equals(map.Direction.toLowerCase())) {
            HeroSave.loadHero();
        }
        if("close".equals(map.Direction.toLowerCase())) {
            Menu.closeGame();
            System.out.println(" -- Game Closed --");
        }
    }

    public static void assignHero(Coordinates coordinates) {
        
    }
}