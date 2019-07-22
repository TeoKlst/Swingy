package app;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import app.Hero;
import app.Villains;
import app.Actions;
import app.Coordinates;

public class Map {
    protected static int MapLayout[][];
    protected static int MapLevel;
    protected static int MapSize;
    protected static String Direction;

    Hero hero;
    Villains villains;
    Coordinates coordinates;

    protected Map(int MapLevel, int MapSize) {
        this.MapLevel = MapLevel;
        this.MapSize = MapSize;
    }

    public static int getMapLevel() {
        return MapLevel = Hero.getHeroLevel();
    }

    public static int getMapSize() {
        return MapSize = (getMapLevel() - 1) * 5 + 10 - (getMapLevel() % 2);
    }

    public static void mapGeneration() {
        MapSize = getMapSize();
        MapLayout = new int[MapSize][MapSize];
    }

    public static void mapDisplay() {
        System.out.println(Arrays.deepToString(MapLayout).replace("], ", "]\n").replace("[[", "[").replace("]]", "]")
                .replace(", ", " ").replace("1", "P").replace("2", "*").replace("0", "-"));
    }

    public static void assignHero(int X, int Y) {
        MapLayout[X][Y] = 1;
    }

    public static void unAssignHero(int X, int Y) {
        MapLayout[X][Y] = 0;
    }

    public static void assignMonster(int X, int Y) {
        MapLayout[X][Y] = 2;
    }

    public static void assignHeroCL() {
        int X = (getMapSize() / 2);
        int Y = (getMapSize() / 2);
        Hero.x = X;
        Hero.y = Y;
        MapLayout[X][Y] = 1;
    }
}

class Main2 {
    Actions actions;
    static Scanner console = new Scanner(System.in);
    static Coordinates coordinates = new Coordinates(5, 5);

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