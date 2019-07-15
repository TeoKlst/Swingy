package app;

import app.Map;
import app.Hero;

import java.io.IOException;

public class Actions {

    public static void heroMovement() {
        if ("up".equals(Map.Direction.toLowerCase())) {
            System.out.println("Up Pressed");
            Hero.movement();
        }
        if ("right".equals(Map.Direction.toLowerCase())) {
            System.out.println("Right Pressed");
            Hero.movement();
        }
        if ("down".equals(Map.Direction.toLowerCase())) {
            System.out.println("Down Pressed");
            Hero.movement();
        }
        if ("left".equals(Map.Direction.toLowerCase())) {
            System.out.println("Left Pressed");
            Hero.movement();
        }
    }

    public static void heroActions() {
        if ("fight".equals(Map.Direction.toLowerCase()))
            System.out.println("Fight Pressed");
        if ("run".equals(Map.Direction.toLowerCase()))
            System.out.println("Run Pressed");
        if ("stats".equals(Map.Direction.toLowerCase()))
            Hero.getStats();
        if ("equip".equals(Map.Direction.toLowerCase()))
            //equip function needed
            Hero.getStats();
    }

    public static void menuActions() throws IOException {
        if("create".equals(Map.Direction.toLowerCase())) {
            Hero.createHero();
        }
        if("save".equals(Map.Direction.toLowerCase())) {
            HeroSave.saveHero();
        }
        if("load".equals(Map.Direction.toLowerCase())) {
            HeroSave.loadHero();
        }
        if("close".equals(Map.Direction.toLowerCase())) {
            Menu.closeGame();
            System.out.println(" -- Game Closed --");
        }
    }

    public static void assignHero(Coordinates coordinates) {
        
    }
}