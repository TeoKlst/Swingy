package app;

public class Artifact {
    protected String    Name;
    protected String    Rarity;
    protected int       Attack;
    protected int       Defense;
    protected int       HitPoints;

    protected Artifact(String Name, String Rarity, int Attack, int Defense, int HitPoints) {
        this.Name = Name;
        this.Rarity = Rarity;
        this.Attack = Attack;
        this.Defense = Defense;
        this.HitPoints = HitPoints;
    }

    static public void createArtifact() {
        
    }
}