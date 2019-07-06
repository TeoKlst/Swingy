package app;

import java.util.Scanner;

public class Hero {
    protected static String        Name;
    protected static String        Class;
    protected static int           Level;
    protected static int           Experience;
    protected static int           ExperienceCap;
    protected static int           Attack;
    protected static int           Defense;
    protected static int           HitPoints;
    protected static int           CritChance;
    protected static int           MagicDmg;
    protected static int           BleedDmg;
    protected static Coordinates   Coordinates;

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

    static Scanner console = new Scanner(System.in);

    public int getHeroLeveL() {
        return this.Level;
    }

    static public int getCoordX() {
        int x = 2;
        return (x);
    }

    static public int getCoordY() {
        int y = 2;
        return (y);
    }

    static public void CreateHero() {
        System.out.println("Select your hero's name:");
        Name = console.nextLine();
        System.out.println("Choose your hero's class:");
        Class = console.nextLine();
        Level = 1;
        Experience = 0;
        ExperienceCap = 10;
        if (Class.equals("Assasin")) {
            CritChance = 20;
            BleedDmg = 0;
            MagicDmg = 0;
        }
        else if (Class.equals("Warrior")) {
            BleedDmg = 0;
            CritChance = 20;
            MagicDmg = 0;
        }
        else if (Class.equals("Mage")) {
            MagicDmg = 1;
            CritChance = 0;
            BleedDmg = 0;
        }
        new Hero(Name, Class, Level, Experience, ExperienceCap, Attack, Defense, HitPoints, CritChance, MagicDmg, BleedDmg, Coordinates);
        System.out.println("Your " + Class + " " + Name + " has been created!");
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