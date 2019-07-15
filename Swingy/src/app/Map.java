package app;

import java.awt.event.KeyEvent;
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
        // MapSize = 5;
        // Coordinates MapLayout[][] = new Coordinates[MapSize][MapSize];
        MapLayout = new int[MapSize][MapSize];
        // MapLayout[2][2] = 1;
    }

    public static void mapDisplay() {
        System.out.println(Arrays.deepToString(MapLayout).replace("], ", "]\n").replace("[[", "[").replace("]]", "]")
                .replace(", ", " ").replace("1", "P").replace("2", "M").replace("0", "-"));
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

    public void keyPressed(KeyEvent e) {
        if (Direction.equals("up".toLowerCase()) && e.getKeyCode() == KeyEvent.VK_UP) {
            System.out.println("UP PRESSED");
        }
        if (Direction.equals("right".toLowerCase()) && e.getKeyCode() == KeyEvent.VK_RIGHT) {
            System.out.println("RIGHT PRESSED");
        }
        if (Direction.equals("down".toLowerCase()) && e.getKeyCode() == KeyEvent.VK_DOWN) {
            System.out.println("DOWN PRESSED");
        }
        if (Direction.equals("left".toLowerCase()) && e.getKeyCode() == KeyEvent.VK_LEFT) {
            System.out.println("LEFT PRESSED");
        }
        if (Direction.equals("close".toLowerCase()) && e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            System.out.println("TRY ESCAPE");
        }
    }
    // addKeyListener(new Movement(this));
    // Map.@addKeyListener(new Movement (this);
    
    public static void mapEndReach() {
        //Checks if map end is reached
        //Gives XP on clear
        //Regenerates map again
    }
}

class Main2 {
    Actions actions;
    static Scanner console = new Scanner(System.in);
    static Coordinates coordinates = new Coordinates(5, 5);

    public static void SwingRun() {
        new Thread(new Runnable() {
            // Hero Brent = new Hero("Dude", "Assasin", 2, 5, 10, 5, 5, 5, 5, 5, 5,
            // coordinates);
            @Override
            public void run() {
                while (Menu.GameState) {
                    Map.mapDisplay();
                    System.out.print("Choose Direction: ");
                    System.out.println("Left, Right, Up or Down.");
                    Map.Direction = console.nextLine();
                    // Map.assignHero(Brent.Coordinates);
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