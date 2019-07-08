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
        return MapLevel = Hero.getHeroLeveL();
    }

    public int getMapSize() {
        return this.MapSize;
    }

    public static void mapGeneration() {
        // this.MapSize = (getMapLevel() - 1) * 5 + 10 - (getMapLevel() % 2);
        MapSize = 5;
        // Coordinates MapLayout[][] = new Coordinates[MapSize][MapSize];
        MapLayout = new int[MapSize][MapSize];
        // MapLayout[2][2] = 1;
    }

    public static void mapDisplay() {
        System.out.println(Arrays.deepToString(MapLayout).replace("], ", "]\n").replace("[[", "[").replace("]]", "]")
                .replace(", ", " ").replace("1", "P").replace("2", "M"));
    }

    public static void assignHero(int X, int Y) {
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
                while (true) {
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
                }
            }
        }).start();
    }
    public static void main(String[] args) throws Exception {
        Hero.CreateHero();
        Map.mapGeneration();
        Map.assignHero(Hero.getCoordX(), Hero.getCoordY());
        SwingRun();
    }
}