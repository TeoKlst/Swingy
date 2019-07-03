package app;

import app.Hero;
import app.Villains;

public class Map {
    protected String    MapLayout[];
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

    public void mapGeneration() {
        this.MapSize = (getMapLevel() - 1) * 5 + 10 - (getMapLevel() % 2);
        
    }
}