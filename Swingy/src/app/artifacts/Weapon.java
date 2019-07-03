package app.artifacts;
import java.util.concurrent.ThreadLocalRandom;
import app.Artifact;
import app.Hero;
import app.Map;

class Weapon extends Artifact {

    protected Weapon(String Name, String Rarity, int Attack, int Defense, int HitPoints) {
        super(Name, Rarity, Attack, Defense, HitPoints);
    }

    private Map Map;

    public void raritySet() {
        int mapLevel = Map.getMapLevel();
        // int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public void attackStats() {
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