package app;

import java.util.Scanner;

public class Menu {
    static Scanner console = new Scanner(System.in);
    protected static Boolean    CL;
    protected static Boolean    GameState = true;
    protected static String     buffer;
    protected static Boolean    roundwin;

    public static void menuSelection () {
        System.out.println("Create new hero or load from existing save file?\nCreate or Load?");
        buffer = console.nextLine();
        while (!("create".equals(buffer.toLowerCase())) && !("load".equals(buffer.toLowerCase()))) {
            System.out.println("Invalid option!\nPlease choose Create or Load");
            buffer = console.nextLine();
        }
        if ("create".equals(buffer.toLowerCase()))
        CL = true;
        if ("load".equals(buffer.toLowerCase()))
        CL = false;
    }

    public static void closeGame() {
        GameState = false;
    }

    public static void winRound() {
        int view;
        Hero.expAdd(Map.getMapLevel() * 250);
        System.out.println("WON THE ROUND\nReceived " + (view = Map.getMapLevel() * 250) + " map clear exp!");
        roundwin = true;
        //Create new map
        System.out.println("- New Round -");
        Map.mapGeneration();
        Map.assignHeroCL();
    }
}