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
        if ("assasin".equals(Class)) {
            CritChance = 20;
            BleedDmg = 0;
            MagicDmg = 0;
            Attack = 3;
            Defense = 1;
            HitPoints = 10;
        }
        else if ("warrior".equals(Class)) {
            BleedDmg = 1;
            CritChance = 0;
            MagicDmg = 0;
            Attack = 2;
            Defense = 5;
            HitPoints = 20;
        }
        else if ("mage".equals(Class)) {
            MagicDmg = 1;
            CritChance = 0;
            BleedDmg = 0;
            Attack = 4;
            Defense = 2;
            HitPoints = 5;
        }
        else if ("hacker".equals(Class)) {
            MagicDmg = 10;
            CritChance = 100;
            BleedDmg = 10;
            Attack = 10;
            Defense = 10;
            HitPoints = 100;
            System.out.println("W0W You are a hacker! \n... cheeky cu#*");
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
        // Deletes Hero || Sends to load screen
        // Maybe try hardcore mode
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
        while (Villains.getHitPoints() >= 0 && HitPoints >= 0) {
            Villains.HitPoints =- Attack;
            HitPoints =- Villains.Attack;
        }
        // if (Villain hp <= 0)
        //     villainDeath();
        //     levelUp();
        //  Wins = Gain +Exp && +RandomItem
        // else
        //      Looses = GameOver
        heroDie();
    }

    public static void expAdd(int exp) {
        Experience = Experience + exp;
        if (Experience >= ExperienceCap) {
            Level = Level + 1;
            System.out.println("* * WOOW you level'd up! * *");
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