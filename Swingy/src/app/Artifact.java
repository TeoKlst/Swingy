package app;

public class Artifact {
    protected String    Rarity;
    protected int       Attack;
    protected int       Defense;
    protected int       HitPoints;

    protected Artifact(String Rarity, int Attack, int Defense, int HitPoints) {
        this.Rarity = Rarity;
        this.Attack = Attack;
        this.Defense = Defense;
        this.HitPoints = HitPoints;
    }
}