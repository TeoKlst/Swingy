package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.JOptionPane;

import view.Map;
import gui.ArtifactMenu;
import gui.GameMenu;

public class Villains {
    protected static String        Name;
    protected static String        Title;
    protected static int           Level;
    protected static int           Attack;
    protected static int           Defense;
    protected static int           HitPoints;
    protected Coordinates   Coordinates;
    static List<String> listName = new ArrayList<String>();
    static List<String> listTitle = new ArrayList<String>();
    static Scanner console = new Scanner(System.in);
    protected static String choice;

    protected Villains(String Name, int Level, int Attack, int Defense, int HitPoints, Coordinates Coordinates) {
        this.Name = Name;
        this.Level = Level;
        this.Attack = Attack;
        this.Defense = Defense;
        this.HitPoints = HitPoints;
        this.Coordinates = Coordinates;
    }

    public static String getName() {
        listName.add("Adam");
        listName.add("Sam");
        listName.add("Thorin");
        listName.add("Urkai");
        listName.add("Xeno");
        listName.add("Obi");
        listName.add("Arthas");
        String random = listName.get(new Random().nextInt(listName.size()));
        return random;
    }

    public static String getTitle() {
        listTitle.add(" the Great");
        listTitle.add(" the Orc");
        listTitle.add(" the Ham");
        listTitle.add(" the 'I have existential crisis Orc'");
        listTitle.add(" the Goblin");
        listTitle.add(" the Mage");
        listTitle.add(" the Developer");
        String random = listTitle.get(new Random().nextInt(listTitle.size()));
        return random;
    }

    public static int getHitPoints() {
        return HitPoints;
    }
    
    public static void villainStats() {
        int min = 1;
        int max = Hero.getHeroLevel();
        int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
        Name = getName();
        Title = getTitle();
        Level = (Map.getMapLevel() == 1) ? 1 : (Map.getMapLevel());
        Attack = randomNum + Level;
        Defense = 0 + (Level / 2);
        HitPoints = 5 * Level;
    }

    public static void villainGenerate() {
        int i = 0;
        int mapDistance = Map.getMapSize();
        int mapArea = mapDistance * mapDistance;
        int maxMonsterPlacement = (mapArea / 3);
        while (i < maxMonsterPlacement) {
            int randomNumX = ThreadLocalRandom.current().nextInt(0, (mapDistance));
            int randomNumY = ThreadLocalRandom.current().nextInt(0, (mapDistance));
            Map.assignMonster(randomNumX, randomNumY);
            i++;
        }
    }

    public static boolean itemDropRate() {
        boolean OutCome =  Math.random() < 0.5;
        return OutCome;   
    }

    public static void equipDropGUI() {
        if ("equip".equals(ArtifactMenu.choice)) {
            Artifact.unEquipArtifactHitPoints();
            Artifact.equipArtifact();
            GameMenu.terminalArea.setText("You have equiped the artifact!");
        }
        else
            GameMenu.terminalArea.setText("You have droped the artifact.");
    }

    public static void villainDeathGUI() {
        Hero.expAddGUI(250 * Level);
        if (itemDropRate()) {
            Artifact.createArtifact();
            ArtifactMenu artifactMenu = new ArtifactMenu();
            artifactMenu.setVisible(true);
            Artifact.getArtifactStatsGUI();
            ArtifactMenu.IntroText.setText("The enemy droped a " + Artifact.Rarity + " " +
            Artifact.Name + " " + Artifact.Type);
        }
    }

    public static void villainDeath() {
        Hero.expAdd(250 * Level);
        if (itemDropRate()) {
            Artifact.createArtifact();
            System.out.println("The enemy droped a " + Artifact.Rarity + " " +
            Artifact.Name + " " + Artifact.Type + "\nEquip or drop the artifact");
            Artifact.getArtifactStats();
            choice = console.nextLine().toLowerCase();
            while ("equip" != choice.intern() && "drop" != choice.intern()) {
                    System.out.println("Incorrect action!\nEquip or drop the artifact");
                    choice = console.nextLine().toLowerCase();
            }
            if ("equip".equals(choice)) {
                Artifact.unEquipArtifact();
                Artifact.equipArtifact();
            }
            else
                System.out.println("You have droped the artifact.");
        }
    }
}