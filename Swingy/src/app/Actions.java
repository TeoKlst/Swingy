package app;

import app.Map;
import app.Hero;

public class Actions {
    static Map map;
    static Hero hero;

    public static void heroMovement() {
        if("up".equals(map.Direction.toLowerCase()))
            System.out.println("Up Pressed");
        if("right".equals(map.Direction.toLowerCase()))
            System.out.println("Right Pressed");
        if("down".equals(map.Direction.toLowerCase()))
            System.out.println("Down Pressed");
        if ("left".equals(map.Direction.toLowerCase()))
            System.out.println("Left Pressed");
    }

    public static void heroActions() {
        if("fight".equals(map.Direction.toLowerCase()))
            System.out.println("Fight Pressed");
        if("run".equals(map.Direction.toLowerCase()))
            System.out.println("Run Pressed");
    }

    public static void menuActions() {
        if("create".equals(map.Direction.toLowerCase()))
            System.out.println("Create Pressed");
        if("save".equals(map.Direction.toLowerCase()))
            System.out.println("Save Pressed");
        if("load".equals(map.Direction.toLowerCase()))
            System.out.println("Load Pressed");
        if("close".equals(map.Direction.toLowerCase()))
            System.out.println("Close Pressed");
    }

    public static void assignHero(Coordinates coordinates) {
        
    }
}