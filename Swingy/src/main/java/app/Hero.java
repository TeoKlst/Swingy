package app;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;
import javax.validation.constraints.NotNull;

import gui.AttackRunMenu;
import gui.CreateMenu;
import gui.GameMenu;
import gui.MainMenu;

public class Hero {
    // @NotNull (message = "Not null");
    protected static String Name;
    protected static String Class;
    protected static int Level;
    protected static int Experience;
    protected static int ExperienceCap;
    protected static int Attack;
    protected static int Defense;
    protected static int HitPoints;
    protected static int CritChance;
    protected static int MagicDmg;
    protected static int BleedDmg;
    protected static Coordinates Coordinates;
    private static List<String> listHero = new LinkedList<String>();
    protected static int x;
    protected static int y;
    public static AttackRunMenu attackRunMenu = null;
    public static Boolean RunSuccess = true; 

    protected Hero(String Name, String Class, int Level, int Experience, int ExperienceCap, int Attack, int Defense,
            int HitPoints, int CritChance, int MagicDmg, int BleedDmg, Coordinates Coordinates) {
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

    public static void getStatsGUI() {
        GameMenu.terminalArea.setText("Your Stats:" + "\nName:" + Name + "\nClass:" + Class + "\nLevel:" + Level + "\nExperience"
                + Experience + "\nExperienceCap" + ExperienceCap + "\nAttack" + Attack + "\nDefense" + Defense
                + "\nHitPoints" + HitPoints + "\nCritChance" + CritChance + "\nMagicDmg" + MagicDmg + "\nBleedDmg"
                + BleedDmg + "\nSaved stats" + Artifact.savedAttack + Artifact.savedDefense + Artifact.savedHitPoints);
    }

    public static void getStats() {
        System.out.println("Your Stats:" + "\nName:" + Name + "\nClass:" + Class + "\nLevel:" + Level + "\nExperience"
                + Experience + "\nExperienceCap" + ExperienceCap + "\nAttack" + Attack + "\nDefense" + Defense
                + "\nHitPoints" + HitPoints + "\nCritChance" + CritChance + "\nMagicDmg" + MagicDmg + "\nBleedDmg"
                + BleedDmg + "\nSaved stats" + Artifact.savedAttack + Artifact.savedDefense + Artifact.savedHitPoints);
    }

    public static void createHeroGUI() {
        Name = CreateMenu.textField1.getText();
        Class = CreateMenu.value;
        Level = 1;
        Experience = 0;
        ExperienceCap = (Level * 1000 + ((Level - 1) * (Level - 1)) * 450);
        HitPoints = Level * 5;
        if ("assasin".equals(Class)) {
            CritChance = 20;
            BleedDmg = 0;
            MagicDmg = 0;
            Attack = 3;
            Defense = 1;
        } else if ("warrior".equals(Class)) {
            BleedDmg = 1;
            CritChance = 0;
            MagicDmg = 0;
            Attack = 1;
            Defense = 2;
        } else if ("mage".equals(Class)) {
            MagicDmg = 2;
            CritChance = 0;
            BleedDmg = 0;
            Attack = 1;
            Defense = 0;
        } else if ("hacker".equals(Class)) {
            MagicDmg = 10;
            CritChance = 100;
            BleedDmg = 10;
            Attack = 10;
            Defense = 10;
            HitPoints = 100;
            System.out.println("W0W You are a hacker!");
        }
        myHero = new Hero(Name, Class, Level, Experience, ExperienceCap, Attack, Defense, HitPoints, CritChance,
                MagicDmg, BleedDmg, Coordinates);
        System.out.println(Name + " the " + Class + " has been teleported to the fantasy realm!");
        System.out.println("Your Stats:" + "\nLevel:" + Level + "\nExperience:" + Experience + "\nExperienceCap:"
                + ExperienceCap + "\nAttack:" + Attack + "\nDefense:" + Defense + "\nHitPoints" + HitPoints
                + "\nCritChance:" + CritChance + "\nMagicDmg" + MagicDmg + "\nBleedDmg" + BleedDmg);
        Artifact.preStatsSave();
        System.out.println("Hero Created");
    }

    public static void createHero() {
        System.out.println("Select your hero's name:");
        Name = console.nextLine();
        while (Name.contains(" ") || Name.contains("\t")){
            System.out.println("Please choose a single worded name.");
            Name = console.nextLine();
        }
        System.out.println("Choose your hero's class: Warrior, Assasin, Mage");
        Class = console.nextLine().toLowerCase();
        System.out.println(Class);
        while ("assasin" != Class.intern() && "warrior" != Class.intern() && "mage" != Class.intern()
                && "hacker" != Class.intern()) {
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
            Attack = 3;
            Defense = 1;
        } else if ("warrior".equals(Class)) {
            BleedDmg = 1;
            CritChance = 0;
            MagicDmg = 0;
            Attack = 1;
            Defense = 2;
        } else if ("mage".equals(Class)) {
            MagicDmg = 2;
            CritChance = 0;
            BleedDmg = 0;
            Attack = 1;
            Defense = 0;
        } else if ("hacker".equals(Class)) {
            MagicDmg = 10;
            CritChance = 100;
            BleedDmg = 10;
            Attack = 10;
            Defense = 10;
            HitPoints = 100;
            System.out.println("W0W You are a hacker!");
        }
        myHero = new Hero(Name, Class, Level, Experience, ExperienceCap, Attack, Defense, HitPoints, CritChance,
                MagicDmg, BleedDmg, Coordinates);
        System.out.println(Name + " the " + Class + " has been teleported to the fantasy realm!");
        System.out.println("Your Stats:" + "\nLevel:" + Level + "\nExperience:" + Experience + "\nExperienceCap:"
                + ExperienceCap + "\nAttack:" + Attack + "\nDefense:" + Defense + "\nHitPoints" + HitPoints
                + "\nCritChance:" + CritChance + "\nMagicDmg" + MagicDmg + "\nBleedDmg" + BleedDmg);
        Artifact.preStatsSave();
    }

    public static void loadHero(String name, String heroclass, int level, int experience, int attack, int defense,
            int hitPoints, int critChance, int magicDmg, int bleedDmg, int artiSavedAttack, int artiSavedDefense,
            int artiSavedHitPoints) {
        Name = name;
        Class = heroclass;
        Level = level;
        Experience = experience;
        ExperienceCap = (Level * 1000 + ((Level - 1) * (Level - 1)) * 450);
        CritChance = critChance;
        BleedDmg = bleedDmg;
        MagicDmg = magicDmg;
        Attack = attack;
        Defense = defense;
        HitPoints = hitPoints;
        Artifact.savedAttack = (Attack - artiSavedAttack);
        Artifact.savedDefense = (Defense - artiSavedDefense);
        Artifact.savedHitPoints = (HitPoints - artiSavedHitPoints);
        // Artifact.preStatsSave();
    }

    public static String heroPrintable() {
        String heroData;
        return heroData = Name + " " + Class + " " + Level + " " + Experience + " " + ExperienceCap + " " + Attack + " "
                + Defense + " " + HitPoints + " " + CritChance + " " + MagicDmg + " " + BleedDmg + " "
                + (Attack - Artifact.savedAttack) + " " + (Defense - Artifact.savedDefense) + " " + (HitPoints - Artifact.savedHitPoints);
    }

    public static void heroDieGUI() {
        GameMenu.downButton.setEnabled(false);
        GameMenu.leftButton.setEnabled(false);
        GameMenu.rightButton.setEnabled(false);
        GameMenu.upButton.setEnabled(false);
        GameMenu.saveButton.setText("Create");
        // GameMenu.loadButton.setEnabled(false);
        // GameMenu.closeButton.setEnabled(false);
        GameMenu.statsButton.setEnabled(false);
        // MainMenu mainMenu = new MainMenu();
        // mainMenu.setVisible(true);
        JOptionPane.showMessageDialog(null, "You have died! Create new hero or load from save file");
    }

    public static void heroDie() {
        System.out.println("You have died!");
        System.out.println("Create new hero or load from save file");
        choice = console.nextLine().toLowerCase();
        while ("create" != choice.intern() && "load" != choice.intern() && "close" != choice.intern()) {
            System.out.println("Incorrect command!\nChoose Create, Load or Close!");
            choice = console.nextLine().toLowerCase();
        }
        if ("create".equals(choice))
            createHero();
        if ("load".equals(choice)) {
            try {
                HeroSave.loadHero();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if ("close".equals(choice))
            Menu.closeGame();
        // Sound.play();
    }

    public static boolean choiceFight() {
        boolean OutCome = true;
        return OutCome;
    }

    public static void choiceRunGUI() {
        boolean OutCome =  Math.random() < 0.5;
        if (OutCome) {
            GameMenu.terminalArea.setText("You ran away successfully!");
            // GameMenu.terminalArea.append("You ran away successfully!");
        }
        else {
            RunSuccess = false;
            battleOutcomeGUI();
            if (Villains.HitPoints <= 0) {
                if ("up".equals(AttackRunMenu.attackRunDirectionTemp))
                    x = x - 1;
                if ("right".equals(AttackRunMenu.attackRunDirectionTemp))
                    y = y + 1;
                if ("down".equals(AttackRunMenu.attackRunDirectionTemp))
                    x = x + 1;
                if ("left".equals(AttackRunMenu.attackRunDirectionTemp))
                    y = y - 1;
                Map.assignHero(Hero.getCoordX(), Hero.getCoordY());
                Map.mapDisplayGUI();
            }
            RunSuccess = true;
        }
    }

    public static void choiceRun() {
        boolean OutCome =  Math.random() < 0.5;
        if (OutCome) {
            System.out.println("You ran away successfully!");
        }
        else {
            System.out.println("Failed to run away!\nNow you have to fight!");
            battleOutcome();
            if (Villains.HitPoints <= 0) {
                if (Map.Direction.equals("up"))
                    x = x - 1;
                if (Map.Direction.equals("right"))
                    y = y + 1;
                if (Map.Direction.equals("down"))
                    x = x + 1;
                if (Map.Direction.equals("left"))
                    y = y - 1;
            }
        }
    }

    public static void battleOutcomeGUI() {
        String append;
        StringBuilder battleReport = new StringBuilder();
        int fullDamage = (Attack + MagicDmg + BleedDmg);
        if (!RunSuccess) {
            append = "Failed to run away!\nNow you have to fight!";
            battleReport.append(append);
            battleReport.append("\n");
        }
        while (Villains.getHitPoints() > 0 && HitPoints > 0) {
            //CritChance Ignored
            Villains.HitPoints = Villains.HitPoints - (((Villains.Defense > Attack) ? 0 : Attack - Villains.Defense) + MagicDmg + BleedDmg);
            append = ("You attacked for " + fullDamage + " damage!\n" + Villains.Name + Villains.Title + " has " + Villains.HitPoints + " hp left.");
            battleReport.append(append);
            battleReport.append("\n");
            if (Villains.getHitPoints() <= 0)
                break;
            HitPoints = HitPoints - ((Villains.Attack <= Defense) ? 0 : Villains.Attack - Defense);
            append = (Villains.Name + Villains.Title + " has attacked you for " + Villains.Attack + "\nYou have " + HitPoints + " hp left.");
            battleReport.append(append);
            battleReport.append("\n");
        }
        if (Villains.getHitPoints() <= 0) {
            append = ("You have killed " + Villains.Name + Villains.Title);
            battleReport.append(append);
            battleReport.append("\n");
            Villains.villainDeathGUI();
            GameMenu.terminalArea.setText(battleReport.toString());
        }
        else {
            append = ("You Died!");
            battleReport.append(append);
            GameMenu.terminalArea.setText(battleReport.toString());
            heroDieGUI();
        }
    }

    public static void battleOutcome() {
        Villains.villainStats();
        System.out.println("You have encountered " + Villains.Name + Villains.Title);
        int fullDamage = (Attack + MagicDmg + BleedDmg);
        while (Villains.getHitPoints() > 0 && HitPoints > 0) {
            //CritChance Ignored
            Villains.HitPoints = Villains.HitPoints - (((Villains.Defense > Attack) ? 0 : Attack - Villains.Defense) + MagicDmg + BleedDmg);
            System.out.println("You attacked for " + fullDamage + " damage!\n" + Villains.Name + Villains.Title + " has " + Villains.HitPoints + " hp left.");
            if (Villains.getHitPoints() <= 0)
                break;
            HitPoints = HitPoints - ((Villains.Attack <= Defense) ? 0 : Villains.Attack - Defense);
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
        Artifact.unEquipArtifact();
        Level = Level + 1;
        Experience = 0;
        ExperienceCap = (Level * 1000 + ((Level - 1) * (Level - 1)) * 450);
        if (Class.equals("assasin")) {
            Attack = Attack + 1;
            CritChance = CritChance + 10;
        }
        if (Class.equals("warrior"))
            BleedDmg = BleedDmg + 1;
        if (Class.equals("mage"))
            MagicDmg = MagicDmg + 1;
        Attack = Attack + 1;
        HitPoints = Level * 5;
        Artifact.preStatsSave();
        Artifact.levelEquipArtifact();
    }

    public static void expAddGUI(int exp) {
        System.out.println("Gained " + exp + "exp!");
        Experience = Experience + exp;
        if (Experience >= ExperienceCap) {
            JOptionPane.showMessageDialog(null, "* * WOW you level'd up! * *");
            statsLevelUp();
        }
    }

    public static void expAdd(int exp) {
        System.out.println("Gained " + exp + "exp!");
        Experience = Experience + exp;
        if (Experience >= ExperienceCap) {
            JOptionPane.showMessageDialog(null, "* * WOW you level'd up! * *");
            System.out.println("* * WOW you level'd up! * *");
            statsLevelUp();
        }
    }

    public static void attackRunGUI() {
        Map.unAssignHero(getCoordX(), getCoordY());
        if ("up".equals(AttackRunMenu.attackRunDirection)) {
            battleOutcomeGUI();
            x = x - 1;
        }
        else if ("right".equals(AttackRunMenu.attackRunDirection)) {
            battleOutcomeGUI();
            y = y + 1;
        }
        else if ("down".equals(AttackRunMenu.attackRunDirection)) {
            battleOutcomeGUI();
            x = x + 1;
        }
        else if ("left".equals(AttackRunMenu.attackRunDirection)) {
            battleOutcomeGUI();
            y = y - 1;
        }
        else
            choiceRunGUI();
        Map.assignHero(Hero.getCoordX(), Hero.getCoordY());
    }

    public static void movementUpGUI() {
        Map.unAssignHero(getCoordX(), getCoordY());
        if (Map.MapLayout[(getCoordX() - 1 == -1) ? 0 : getCoordX() - 1][getCoordY()] == 2) {
            if (attackRunMenu == null){
                attackRunMenu = new AttackRunMenu();
                attackRunMenu.setVisible(true);
                Villains.villainStats();
                AttackRunMenu.monsterLabel.setText("You have encountered " + Villains.Name + Villains.Title);
            }
            else
                attackRunMenu.setVisible(true);
            AttackRunMenu.attackRunDirection = "up";
        }
        else if((x - 1) == -1)
            Menu.winRoundGUI(); 
        else
            x = x - 1;
        Map.assignHero(Hero.getCoordX(), Hero.getCoordY());
    }

    public static void movementRightGUI() {
        Map.unAssignHero(getCoordX(), getCoordY());
        if (Map.MapLayout[getCoordX()][(getCoordY() + 1) >= Map.tempMapSize() ? getCoordY() : getCoordY() + 1] == 2) {
            if (attackRunMenu == null){
                attackRunMenu = new AttackRunMenu();
                attackRunMenu.setVisible(true);
                Villains.villainStats();
                AttackRunMenu.monsterLabel.setText("You have encountered " + Villains.Name + Villains.Title);
            }
            else
                attackRunMenu.setVisible(true);
            AttackRunMenu.attackRunDirection = "right";
        }
        else if((y + 1) == Map.tempMapSize())
            Menu.winRoundGUI(); 
        else
            y = y + 1;
        Map.assignHero(Hero.getCoordX(), Hero.getCoordY());
    }

    public static void movementDownGUI() {
        Map.unAssignHero(getCoordX(), getCoordY());
        if (Map.MapLayout[(getCoordX() + 1 >= Map.tempMapSize()) ? getCoordX() : getCoordX() + 1][getCoordY()] == 2) {
            if (attackRunMenu == null){
                attackRunMenu = new AttackRunMenu();
                attackRunMenu.setVisible(true);
                Villains.villainStats();
                AttackRunMenu.monsterLabel.setText("You have encountered " + Villains.Name + Villains.Title);
            }
            else
                attackRunMenu.setVisible(true);
            AttackRunMenu.attackRunDirection = "down";
        }
        else if((x + 1) == Map.tempMapSize())
            Menu.winRoundGUI(); 
        else
            x = x + 1;
        Map.assignHero(Hero.getCoordX(), Hero.getCoordY());
    }

    public static void movementLeftGUI() {
        Map.unAssignHero(getCoordX(), getCoordY());
        if (Map.MapLayout[getCoordX()][(getCoordY() - 1) == -1 ? getCoordY() : getCoordY() - 1] == 2) {
            if (attackRunMenu == null){
                attackRunMenu = new AttackRunMenu();
                attackRunMenu.setVisible(true);
                Villains.villainStats();
                AttackRunMenu.monsterLabel.setText("You have encountered " + Villains.Name + Villains.Title);
            }
            else
                attackRunMenu.setVisible(true);
            AttackRunMenu.attackRunDirection = "left";
        }
        else if((y - 1) == -1)
            Menu.winRoundGUI(); 
        else
            y = y - 1;
        Map.assignHero(Hero.getCoordX(), Hero.getCoordY());
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
                else
                    choiceRun();
            }
            else if((x - 1) == -1)
                Menu.winRound(); 
            else
                x = x - 1;
        }
        if (Map.Direction.equals("right")) {
            if (Map.MapLayout[getCoordX()][(getCoordY() + 1) >= Map.tempMapSize() ? getCoordY() : getCoordY() + 1] == 2) {
                System.out.println("Encountered a monster!\nFight or Run!");
                choice = console.nextLine().toLowerCase();
                while ("fight" != choice.intern() && "run" != choice.intern()) {
                    System.out.println("Incorrect command!\nChoose Fight or Run!");
                    choice = console.nextLine().toLowerCase();
                }
                if ("fight".equals(choice)) {
                    battleOutcome();
                    y = y + 1;
                }
                else
                    choiceRun();
            }
            else if((y + 1) == Map.tempMapSize())
                Menu.winRound(); 
            else
                y = y + 1;
        }
        if (Map.Direction.equals("down")) {
            if (Map.MapLayout[(getCoordX() + 1 >= Map.tempMapSize()) ? getCoordX() : getCoordX() + 1][getCoordY()] == 2) {
                System.out.println("Encountered a monster!\nFight or Run!");
                choice = console.nextLine().toLowerCase();
                while ("fight" != choice.intern() && "run" != choice.intern()) {
                    System.out.println("Incorrect command!\nChoose Fight or Run!");
                    choice = console.nextLine().toLowerCase();
                }
                if ("fight".equals(choice)) {
                    battleOutcome();
                    x = x + 1;
                }
                else
                    choiceRun();
            }
            else if((x + 1) == Map.tempMapSize())
                Menu.winRound(); 
            else
                x = x + 1;
        }
        if (Map.Direction.equals("left")) {
            if (Map.MapLayout[getCoordX()][(getCoordY() - 1) == -1 ? getCoordY() : getCoordY() - 1] == 2) {
                System.out.println("Encountered a monster!\nFight or Run!");
                choice = console.nextLine().toLowerCase();
                while ("fight" != choice.intern() && "run" != choice.intern()) {
                    System.out.println("Incorrect command!\nChoose Fight or Run!");
                    choice = console.nextLine().toLowerCase();
                }
                if ("fight".equals(choice)) {
                    battleOutcome();
                    y = y - 1;
                }
                else
                    choiceRun();
            }
            else if((y - 1) == -1)
                Menu.winRound(); 
            else
                y = y - 1;
        }
    }
}