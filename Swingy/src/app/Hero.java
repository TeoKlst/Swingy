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
    protected static int            x;
    protected static int            y;

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
    protected static String choice;

	private static Object myHero;

    public static void addHero() {
        listHero.add("Hero");
    }

    public static int getHeroLevel() {
        return Level;
    }

    public static int getCoordX() {
        return (x);
    }

    public static int getCoordY() {
        return (y);
    }

    public static void getStats() {
        // System.out.println("Your Stats:" + "\nLevel:" + Level + "\nExperience:" + Experience  + "\nExperienceCap:" + ExperienceCap +
        // "\nAttack:" + Attack + "\nDefense:" + Defense + "\nHitPoints" + HitPoints + 
        // "\nCritChance:" + CritChance + "\nMagicDmg" + MagicDmg + "\nBleedDmg" + BleedDmg);
        System.out.println("Your Stats:" + "\nName:" + Name + "\nClass:" + Class + "\nLevel:"  + Level +
        "\nExperience" + Experience + "\nExperienceCap" + ExperienceCap + "\nAttack"  + Attack + "\nDefense" + Defense +
        "\nHitPoints" + HitPoints + "\nCritChance" + CritChance + "\nMagicDmg" + MagicDmg + "\nBleedDmg" + BleedDmg);
    }

    public static void createHero() {
        System.out.println("Select your hero's name:");
        Name = console.nextLine();
        System.out.println("Choose your hero's class: Warrior, Assasin, Mage");
        Class = console.nextLine().toLowerCase();
        System.out.println(Class);
        //Fix later
        while ("assasin" != Class.intern() && "warrior" != Class.intern()
                    && "mage" != Class.intern() && "hacker" != Class.intern()) {
            System.out.println("Incorrect class, please try again.");
            Class = console.nextLine().toLowerCase();
            System.out.println(Class);
        }
        Level = 1;
        Experience = 0;
        ExperienceCap = (Level * 1000 + ((Level - 1) * (Level - 1)) * 450);
        HitPoints = Level * 10;
        if ("assasin".equals(Class)) {
            CritChance = 20;
            BleedDmg = 0;
            MagicDmg = 0;
            Attack = 5;
            Defense = 1;
        }
        else if ("warrior".equals(Class)) {
            BleedDmg = 1;
            CritChance = 0;
            MagicDmg = 0;
            Attack = 2;
            Defense = 5;
        }
        else if ("mage".equals(Class)) {
            MagicDmg = 3;
            CritChance = 0;
            BleedDmg = 0;
            Attack = 1;
            Defense = 2;
        }
        else if ("hacker".equals(Class)) {
            MagicDmg = 10;
            CritChance = 100;
            BleedDmg = 10;
            Attack = 10;
            Defense = 10;
            HitPoints = 100;
            System.out.println("W0W You are a hacker!");
        }
        myHero = new Hero(Name, Class, Level, Experience, ExperienceCap, Attack, Defense, HitPoints, CritChance, MagicDmg, BleedDmg, Coordinates);
        System.out.println(Name + " the " + Class + " has been teleported to the fantasy realm!");
        System.out.println("Your Stats:" + "\nLevel:" + Level + "\nExperience:" + Experience  + "\nExperienceCap:" + ExperienceCap +
        "\nAttack:" + Attack + "\nDefense:" + Defense + "\nHitPoints" + HitPoints + 
        "\nCritChance:" + CritChance + "\nMagicDmg" + MagicDmg + "\nBleedDmg" + BleedDmg);
    }

    public static void loadHero(String name, String heroclass, int level, int experience,
            int attack, int defense, int hitPoints , int critChance, int magicDmg, int bleedDmg) {
        Name = name;
        Class =  heroclass;
        Level = level;
        Experience = experience;
        ExperienceCap = (Level * 1000 + ((Level - 1) * (Level - 1)) * 450);
        CritChance = critChance;
        BleedDmg = bleedDmg;
        MagicDmg = magicDmg;
        Attack = attack;
        Defense = defense;
        HitPoints = hitPoints;
    }

    public static String heroPrintable() {
       String heroData;
       return heroData = Name + " " + Class + " "  + Level + " "  + Experience + " " 
        + ExperienceCap + " "  + Attack + " " + Defense + " " + HitPoints + " " 
        + CritChance + " " + MagicDmg + " " + BleedDmg;
    }

    public static void heroDie() {
        System.out.println("You have died!");
        // Sound.play();
        // Deletes Hero || Sends to load screen
    }

    public static boolean choiceFight() {
        boolean OutCome = true;
        return OutCome;
    }

    // public static boolean getRandomBoolean() {
    //     return Math.random() < 0.5;
    // }

    public static void choiceRun() {
        boolean OutCome =  Math.random() < 0.5;
        if (OutCome) {
            System.out.println("You ran away successfully!");
        }
        else {
            System.out.println("Failed to run away!\nNow you have to fight!");
            battleOutcome();
        }
    }

    public static void battleOutcome() {
        Villains.villainStats();
        System.out.println("You have encountered " + Villains.Name + Villains.Title);
        while (Villains.getHitPoints() > 0 && HitPoints > 0) {
            //CritChance Ignored
            Villains.HitPoints = Villains.HitPoints - (((Villains.Defense > Attack) ? 0 : Attack - Villains.Defense) + MagicDmg + BleedDmg);
            System.out.println("You attacked for " + Attack + " damage!\n" + Villains.Name + Villains.Title + " has " + Villains.HitPoints + " hp left.");
            if (Villains.getHitPoints() <= 0)
                break;
            HitPoints = HitPoints - ((Villains.Attack < Defense) ? 0 : Attack - Villains.Defense);
            System.out.println(Villains.Name + Villains.Title + " has attacked you for " + Villains.Attack + "\nYou have " + HitPoints + " hp left.");
        }
        if (Villains.getHitPoints() <= 0) {
            System.out.println("You have killed " + Villains.Name + Villains.Title);
            Villains.villainDeath();
        }
        else {
            heroDie();
        }
    }

    public static void statsLevelUp() {
        Level = Level + 1;
        Experience = 0;
        ExperienceCap = (Level * 1000 + ((Level - 1) * (Level - 1)) * 450);
        if (Class.equals("assasin"))
            CritChance = CritChance + 10;
        if (Class.equals("warrior"))
            BleedDmg = BleedDmg + 1;
        if (Class.equals("mage"))
            MagicDmg = MagicDmg + 2;
        Attack = Attack + 1;
        Defense = Defense + 1;
        HitPoints = Level * 10;
    }

    public static void expAdd(int exp) {
        Experience = Experience + exp;
        if (Experience >= ExperienceCap) {
            System.out.println("* * WOOW you level'd up! * *");
            statsLevelUp();
        }
    }

    public static void movement() {
        Map.unAssignHero(getCoordX(), getCoordY());
        if (Map.Direction.equals("up")) {
            if (Map.MapLayout[(getCoordX() - 1 == -1) ? 0 : getCoordX() - 1][getCoordY()] == 2) {
                System.out.println("Encountered a monster!\nFight or Run!");
                choice = console.nextLine().toLowerCase();
                while ("fight" != choice.intern() && "run" != choice.intern()) {
                    System.out.println("Incorrect command!\nChoose Fight or Run!");
                    choice = console.nextLine().toLowerCase();
                }
                if ("fight".equals(choice)) {
                    battleOutcome();
                    x = x - 1;
                }
                else {
                    choiceRun();
                }
            }
            else if((x - 1) == -1)
                Menu.winRound(); 
            else
                x = x - 1;
        }
        if (Map.Direction.equals("right")) {
            if (Map.MapLayout[getCoordX()][(getCoordY() + 1) >= Map.getMapSize() ? 0 : getCoordY() + 1] == 2) {
                System.out.println("Encountered a monster!");
                y = y + 1;
            }
            else if((y + 1) >= Map.getMapSize())
                Menu.winRound(); 
            else
                y = y + 1;
        }
        if (Map.Direction.equals("down")) {
            if (Map.MapLayout[(getCoordX() + 1 >= Map.getMapSize()) ? 0 : getCoordX() + 1][getCoordY()] == 2) {
                System.out.println("Encountered a monster!");
                x = x + 1;
            }
            else if((x + 1) >= Map.getMapSize())
                Menu.winRound(); 
            else
                x = x + 1;
            System.out.println(x);
        }
        if (Map.Direction.equals("left")) {
            if (Map.MapLayout[getCoordX()][(getCoordY() - 1) == -1 ? 0 : getCoordY() - 1] == 2) {
                System.out.println("Encountered a monster!");
                y = y - 1;
            }
            else if((y - 1) == -1)
                Menu.winRound(); 
            else
                y = y - 1;
        }
    }
}