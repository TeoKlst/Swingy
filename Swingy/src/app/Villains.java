package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import app.Map;

public class Villains {
    protected static String        Name;
    protected static String        Title;
    protected static int           Level;
    protected static int           ExpAmount;
    protected static int           Attack;
    protected static int           Defense;
    protected static int           HitPoints;
    protected Coordinates   Coordinates;
    static List<String> listName = new ArrayList<String>();
    static List<String> listTitle = new ArrayList<String>();

    protected Villains(String Name, int Level, int ExpAmount, int Attack, int Defense, int HitPoints, Coordinates Coordinates) {
        this.Name = Name;
        this.Level = Level;
        this.ExpAmount = ExpAmount;
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
        listTitle.add("the Great");
        listTitle.add("the Orc");
        listTitle.add("the Ham");
        listTitle.add("the 'I have existential crisis Orc'");
        listTitle.add("the Goblin");
        listTitle.add("the Mage");
        listTitle.add("the Developer");
        String random = listTitle.get(new Random().nextInt(listTitle.size()));
        return random;
    }

    public static int getHitPoints() {
        return HitPoints;
    }
    
    public static void villainStats() {
        int min = 1;
        int max = Level;
        int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
        Name = getName();
        Title = getTitle();
        Level = (Map.getMapLevel() == 1) ? 1 : (Map.getMapLevel() + 1);
        ExpAmount = Level * 150;
        Attack = randomNum + 1;
        Defense = randomNum = ThreadLocalRandom.current().nextInt(0, 5);;
        HitPoints = randomNum + 10;
    }

    public static void villainGenerate() {
        int i = 0;
        int mapDistance = Map.getMapSize();
        int mapArea = mapDistance * mapDistance;
        int maxMonsterPlacement = (mapArea / 3);
        while (i < maxMonsterPlacement) {
            int randomNumX = ThreadLocalRandom.current().nextInt(0, mapDistance);
            int randomNumY = ThreadLocalRandom.current().nextInt(0, mapDistance);
            Map.assignMonster(randomNumX, randomNumY);
            i++;
        }

        //create villain
        //  villainStats();
    }

    /*  50% drop rate  */
    public boolean itemDropRate() {
        boolean OutCome =  Math.random() < 0.5;
        return OutCome;   
    }

    public void villainDeath() {
        if (itemDropRate()) {
            Artifact.createArtifact();
            //Attach Artifact
        }
        //Destroy and remove villain from map
        //Give Hero Exp accordibg to villain lvl Exp = Exp + ExpAmount
    }
}