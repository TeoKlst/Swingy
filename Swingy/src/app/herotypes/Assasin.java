package app.herotypes;
import app.Hero;

public class Assasin extends Hero {

    protected String Description = "Agile fighters with a special chance to crit on attack.";

    protected Assasin(String Name, String Class, int Level, int Experience, int Attack, int Defense, int HitPoints,
            int CritChance, int MagicDmg, int BleedDmg, app.Coordinates Coordinates) {
        super(Name, Class, Level, Experience, Attack, Defense, HitPoints, CritChance, MagicDmg, BleedDmg, Coordinates);
        // TODO Auto-generated constructor stub
    }
}