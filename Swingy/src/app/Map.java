package app;

import app.Hero;
import app.Villains;

public class Map {
    protected int       MapLayout;
    protected int       MapLevel;
    protected int       MapSize;

    Hero        hero;
    Villains    villains;


    protected Map(int MapLevel, int MapSize) {
        this.MapLevel = MapLevel;
        this.MapSize = MapSize;
    }

    public int getMapLevel() {
        return this.MapLevel = hero.getHeroLeveL();
    }

    public int getMapSize() {
        return this.MapSize;
    }
    
    public void mapGeneration() {
        this.MapSize = (getMapLevel() - 1) * 5 + 10 - (getMapLevel() % 2);
                int MapLayout[][] = new int[this.MapSize][this.MapSize];
    }
}
class Main2 {
    public static void main(String[] args) throws Exception {
        System.out.println("TEST");
    }
}