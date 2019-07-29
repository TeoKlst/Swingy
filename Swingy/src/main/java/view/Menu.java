package view;

import java.util.Scanner;
import javax.swing.JOptionPane;

import controller.HeroSave;
import view.Map;
import model.Hero;
import model.Villains;

public class Menu {
    static Scanner console = new Scanner(System.in);
    public static Boolean    CL;
    public static Boolean    GameState = true;
    protected static String     buffer;
    protected static Boolean    roundwin;

    public static void menuSelection () {
        System.out.println("Create new hero or load from existing save file?\nCreate or Load?");
        buffer = console.nextLine();
        while (!("create".equals(buffer.toLowerCase())) && !("load".equals(buffer.toLowerCase()))) {
            System.out.println("Invalid option!\nPlease choose Create or Load");
            buffer = console.nextLine();
        }
        if ("create".equals(buffer.toLowerCase())) {
            CL = true;
        }
        if ("load".equals(buffer.toLowerCase())) {
            if (!(HeroSave.checkSaveFile()))
                menuSelection();
            else
                CL = false;
        }
    }

    public static void closeGame() {
        GameState = false;
        System.out.println(" -- Game Closed --");
    }

    public static void winRoundGUI() {
        Hero.expAdd(Map.getMapLevel() * 250);
        roundwin = true;
        JOptionPane.showMessageDialog(null, "YOU WON THE ROUND");
        Map.mapGeneration();
        Villains.villainGenerate();
        Map.assignHeroCL();
    }

    public static void winRound() {
        Hero.expAdd(Map.getMapLevel() * 250);
        System.out.println("YOU WON THE ROUND");
        roundwin = true;
        System.out.println("- New Round -");
        Map.mapGeneration();
        Villains.villainGenerate();
        Map.assignHeroCL();
    }
}