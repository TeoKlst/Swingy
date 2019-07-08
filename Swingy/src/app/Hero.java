package app;

import java.util.LinkedList;
import java.util.List;
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
    private static List<String> listHero = new LinkedList<String>();

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

    public static void addHero() {
        listHero.add("Hero");
    }

    public static int getHeroLeveL() {
        return Level;
    }

    public static int getCoordX() {
        int x = 2;
        return (x);
    }

    public static int getCoordY() {
        int y = 2;
        return (y);
    }

    public static void getStats() {
        System.out.println("Your Stats:" + "\nLevel:" + Level + "\nExperience:" + Experience  + "\nExperienceCap:" + ExperienceCap +
        "\nAttack:" + Attack + "\nDefense:" + Defense + "\nHitPoints" + HitPoints + 
        "\nCritChance:" + CritChance + "\nMagicDmg" + MagicDmg + "\nBleedDmg" + BleedDmg);
    }

    public static void CreateHero() {
        System.out.println("Select your hero's name:");
        Name = console.nextLine();
        System.out.println("Choose your hero's class: Warrior, Assasin, Mage");
        Class = console.nextLine().toLowerCase();
        System.out.println(Class);
        //Fix later
        // while (Class.equals("assasin") || Class.equals("warrior") || Class.equals("mage")) {
        //     System.out.println("Incorrect class, please try again.");
        //     Class = console.nextLine().toLowerCase();
        //     System.out.println(Class);
        // }
        Level = 1;
        Experience = 0;
        ExperienceCap = (Level * 1000 + ((Level - 1) * (Level - 1)) * 450);
        if ("assasin".equals(Class)) {
            CritChance = 20;
            BleedDmg = 0;
            MagicDmg = 0;
        }
        else if ("warrior".equals(Class)) {
            BleedDmg = 0;
            CritChance = 20;
            MagicDmg = 0;
        }
        else if ("mage".equals(Class)) {
            MagicDmg = 1;
            CritChance = 0;
            BleedDmg = 0;
        }
        new Hero(Name, Class, Level, Experience, ExperienceCap, Attack, Defense, HitPoints, CritChance, MagicDmg, BleedDmg, Coordinates);
        System.out.println("Your " + Class + " " + Name + " has been created!");
        System.out.println("Your Stats:" + "\nLevel:" + Level + "\nExperience:" + Experience  + "\nExperienceCap:" + ExperienceCap +
        "\nAttack:" + Attack + "\nDefense:" + Defense + "\nHitPoints" + HitPoints + 
        "\nCritChance:" + CritChance + "\nMagicDmg" + MagicDmg + "\nBleedDmg" + BleedDmg);
    }

    public void DieHero() {
        // Deletes Hero || Sends to load screen
        // Maybe try hardcore mode
    }

    public boolean choiceFight() {
        boolean OutCome = true;
        return OutCome;
    }

    // public static boolean getRandomBoolean() {
    //     return Math.random() < 0.5;
    // }

    public boolean choiceRun() {
        boolean OutCome =  Math.random() < 0.5;
        return OutCome;   
    }

    public void BattleOutcome() {
        //BattleOutcome ? Wins : Looses
        // if (BattleOutcome == true)
        //     villainDeath();
        //     levelUp();
        //Wins = Gain +Exp && +RandomItem
        //Looses = GameOver
    }

    public void levelUp() {
        if (Experience >= ExperienceCap)
            Level = Level + 1;
    }
}