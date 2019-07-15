package app;

import java.util.concurrent.ThreadLocalRandom;

public class Artifact {
    protected static String    Name;
    protected static String    Rarity;
    protected static int       Attack;
    protected static int       savedAttack;
    protected static int       Defense;
    protected static int       savedDefense;
    protected static int       HitPoints;
    protected static int       savedHitPoints;

    protected Artifact(String Name, String Rarity, int Attack, int savedAttack, int Defense, int savedDefense, int HitPoints, int savedHitPoints) {
        this.Name = Name;
        this.Rarity = Rarity;
        this.Attack = Attack;
        this.savedAttack = savedAttack;
        this.Defense = Defense;
        this.savedDefense = savedDefense;
        this.HitPoints = HitPoints;
        this.savedHitPoints = savedHitPoints;
    }

    public static void createArtifact() {
        
    }

    public void RaritySet() {
        int mapLevel = Map.getMapLevel();
        // int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public void AttackStats() {
        int min;
        int max;
        int mapLevel = Map.getMapLevel();
        if (Rarity.equals("Common")) {
            min = 1;
            max = 1;
            int attackStat = ThreadLocalRandom.current().nextInt(min, max + mapLevel);
        }
        else if (Rarity.equals("UnCommon")) {
            min = 2;
            max = 2;
            int attackStat = ThreadLocalRandom.current().nextInt(min, max + mapLevel);
        }
        else if (Rarity.equals("Rare")) {
            min = 3;
            max = 3;
            int attackStat = ThreadLocalRandom.current().nextInt(min, max + mapLevel);
        }
        else if (Rarity.equals("Legendary")) {
            min = 5;
            max = 6;
            int attackStat = ThreadLocalRandom.current().nextInt(min, max + mapLevel);
        }
        else if (Rarity.equals("Mythic")) {
            min = 7;
            max = 8;
            int attackStat = ThreadLocalRandom.current().nextInt(min, max + mapLevel);
        }
        else if (Rarity.equals("EzModeActivatedWTF")) {
            min = 9;
            max = 10;
            int attackStat = ThreadLocalRandom.current().nextInt(min, max + mapLevel);
        }
    }
}