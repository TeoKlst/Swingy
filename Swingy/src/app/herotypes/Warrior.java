package app.herotypes;
import app.Hero;

public class Warrior extends Hero {

    protected String Description = "Strong bulky fighters who give extra bleed(damage passes through armor) on each hit";

    protected Warrior(String Name, String Class, int Level, int Experience, int ExperienceCap, int Attack, int Defense,
            int HitPoints, int CritChance, int MagicDmg, int BleedDmg, app.Coordinates Coordinates) {
        super(Name, Class, Level, Experience, ExperienceCap, Attack, Defense, HitPoints, CritChance, MagicDmg, BleedDmg,
                Coordinates);
        // TODO Auto-generated constructor stub
    }
}