package app;

public class Map {
    protected int   MapLevel;
    protected int   MapSize;

    protected Map(int MapLevel, int MapSize) {
        this.MapLevel = MapLevel;
        this.MapSize = MapSize;
    }

    public void MapGeneration() {
        
        MapSize = (MapLevel - 1) * 5 + 10 - (MapLevel % 2);
    }

    public int GetMapLevel() {
        return this.MapLevel;
    }
}