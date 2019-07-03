package app.herotypes;
import app.Hero;

public class Mage extends Hero {

    protected String Description = "Fragile fighters who posses mighty magic(damage passes through armor) ability on each attack.";
    
    protected Mage(String Name, String Class, int Level, int Experience, int ExperienceCap, int Attack, int Defense,
            int HitPoints, int CritChance, int MagicDmg, int BleedDmg, app.Coordinates Coordinates) {
        super(Name, Class, Level, Experience, ExperienceCap, Attack, Defense, HitPoints, CritChance, MagicDmg, BleedDmg,
                Coordinates);
        // TODO Auto-generated constructor stub
    }
}