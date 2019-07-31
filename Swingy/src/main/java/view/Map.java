package view;

import java.util.Arrays;

import gui.GameMenu;
import model.Coordinates;
import model.Hero;
import model.Villains;

public class Map {
    public static int MapLayout[][];
    protected static int MapLevel;
    protected static int MapSize;
    public static String Direction;

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

    public static int tempMapSize() {
        int temp1;
        int temp2 = getMapSize();
        if (((MapLayout[0].length) != getMapSize()) ) {
            return temp1 = ((getMapLevel() - 1) - 1) * 5 + 10 - ((getMapLevel() - 1) % 2);
        }
        else
            return temp2;
    }

    public static void mapGeneration() {
        MapSize = getMapSize();
        MapLayout = new int[MapSize][MapSize];
    }

    public static void mapDisplayGUI() {
        GameMenu.mapArea.setText(Arrays.deepToString(MapLayout).replace("], ", "]\n").replace("[[", "[").replace("]]", "]")
                .replace(", ", " ").replace("1", "P").replace("2", "M").replace("0", "-"));
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