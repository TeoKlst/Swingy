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
            // Hero.getCoordY() = Hero.getCoordY + 1;
            Map.MapLayout[1][1] = 2;
        }
        if ("right".equals(map.Direction.toLowerCase()))
            System.out.println("Right Pressed");
        if ("down".equals(map.Direction.toLowerCase()))
            System.out.println("Down Pressed");
        if ("left".equals(map.Direction.toLowerCase()))
            System.out.println("Left Pressed");
    }

    public static void heroActions() {
        if ("fight".equals(map.Direction.toLowerCase()))
            System.out.println("Fight Pressed");
        if ("run".equals(map.Direction.toLowerCase()))
            System.out.println("Run Pressed");
        if ("stats".equals(map.Direction.toLowerCase()))
            Hero.getStats();
    }

    public static void menuActions() throws IOException {
        if("create".equals(map.Direction.toLowerCase()))
            System.out.println("Create Pressed");
        if("save".equals(map.Direction.toLowerCase())) {
            HeroSave.saveHero();
        }
        if("load".equals(map.Direction.toLowerCase())) {
            HeroSave.loadHero();
        }
        if("close".equals(map.Direction.toLowerCase()))
            System.out.println("Close Pressed");
    }

    public static void assignHero(Coordinates coordinates) {
        
    }
}