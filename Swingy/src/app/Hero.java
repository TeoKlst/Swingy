package app;

public class Hero {
    protected String        Name;
    protected String        Class;
    protected int           Level;
    protected int           Experience;
    protected int           ExperienceCap;
    protected int           Attack;
    protected int           Defense;
    protected int           HitPoints;
    protected int           CritChance;
    protected int           MagicDmg;
    protected int           BleedDmg;
    protected Coordinates   Coordinates;

    protected Hero(String Name, String Class, int Level, int Experience, int ExperienceCap,int Attack, int Defense, int HitPoints,
            int CritChance, int MagicDmg, int BleedDmg ,Coordinates Coordinates) {
        this.Name = Name;
        this.Class = Class;
        this.Level = Level;
        this.Experience = Experience;
        this.ExperienceCap = ExperienceCap;
        this.Attack = Attack;
        this.Defense = Defense;
        this.HitPoints = HitPoints;
        this.CritChance = CritChance;
        this.MagicDmg = MagicDmg;
        this.BleedDmg = BleedDmg;
        this.Coordinates = Coordinates;
    }

    public int getHeroLeveL() {
        return this.Level;
    }


    public void CreateHero() {
        if (Class.equals("Assasin")) {
            CritChance = 20;
        }
        else if (Class.equals("Warrior")) {
            BleedDmg = 1;
        }
        else if (Class.equals("Mage")) {
            MagicDmg = 1;
        }
    }

    public void DieHero() {

    }

    public boolean Fight() {
        boolean OutCome = true;
        return OutCome;
    }

    // public static boolean getRandomBoolean() {
    //     return Math.random() < 0.5;
    // }

    public boolean Run() {
        boolean OutCome =  Math.random() < 0.5;
        return OutCome;   
    }

    public void BattleOutcome() {
        //BattleOutcome ? Wins : Looses
        //Wins = Gain +Exp && +RandomItem
        //Looses = GameOver
    }

    public void LevelUp() {
        if (Experience >= (Level * 1000 + ((Level - 1) * (Level - 1)) * 450))
            Level = Level + 1;
    }
}