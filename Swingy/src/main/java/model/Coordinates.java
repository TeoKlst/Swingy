package model;

import javax.validation.constraints.NotNull;

public class Coordinates {
    @NotNull(message = "Coords may not be null")
    protected int X;
    protected int Y;

    Coordinates(int X, int Y) {
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