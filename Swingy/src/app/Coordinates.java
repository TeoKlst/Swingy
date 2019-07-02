package app;

public class Coordinates {
    protected int X;
    protected int Y;

    protected Coordinates(int X, int Y) {
        this.X = X;
        this.Y = Y;
    }

    public int GetCoordX() {
        return this.X;
    }

    public int GetCoordY() {
        return this.Y;
    }
}