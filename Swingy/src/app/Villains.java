package app;

public class Villains {
    protected String        Name;
    protected int           Level;
    protected int           ExpAmount;
    protected int           Attack;
    protected int           Defense;
    protected int           HitPoints;
    protected Coordinates   Coordinates;

    protected Villains(String Name, int Level, int ExpAmount, int Attack, int Defense, int HitPoints, Coordinates Coordinates) {
        this.Name = Name;
        this.Level = Level;
        this.ExpAmount = ExpAmount;
        this.Attack = Attack;
        this.Defense = Defense;
        this.HitPoints = HitPoints;
        this.Coordinates = Coordinates;
    }

    public void VillainStats() {

    }

    public void VillainGenerate() {

    }
}