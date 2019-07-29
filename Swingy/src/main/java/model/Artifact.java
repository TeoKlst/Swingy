package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import gui.ArtifactMenu;

public class Artifact {
    protected static String     Name;
    protected static String     Rarity;
    protected static String     Type;
    protected static int        Attack;
    protected static int        savedAttack;
    protected static int        Defense;
    protected static int        savedDefense;
    protected static int        HitPoints;
    protected static int        savedHitPoints;
    protected static int        hpCap;
    static List<String>         listName = new ArrayList<String>();
    static List<String>         listRarity = new ArrayList<String>();
    static List<String>         listType = new ArrayList<String>();
    protected static int        min;
    protected static int        max;
    public static int           previousItem = 0;
    public static int           damagedHP;

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

    public static String getName() {
        listName.add("wooden");
        listName.add("bronze");
        listName.add("iron");
        listName.add("gold");
        listName.add("dimond");
        listName.add("damascus");
        String random = listName.get(new Random().nextInt(listName.size()));
        return random;
    }

    public static String getRarity() {
        listRarity.add("Common");
        listRarity.add("Rare");
        listRarity.add("Legendary");
        listRarity.add("Mythic");
        String random = listRarity.get(new Random().nextInt(listRarity.size()));
        return random;
    }

    public static String getType() {
        listType.add("weapon");
        listType.add("armor");
        listType.add("helm");
        String random = listType.get(new Random().nextInt(listType.size()));
        return random;
    }

    public static int getAttack() {
        int attack = 0;
        int heroLevel = Hero.getHeroLevel();
        if (Rarity.equals("Common")) {
            min = 1;
            max = 1;
            attack = ThreadLocalRandom.current().nextInt(min, max + heroLevel);
        }
        if (Rarity.equals("Rare")) {
            min = 2;
            max = 3;
            attack = ThreadLocalRandom.current().nextInt(min, max + heroLevel);
        }
        if (Rarity.equals("Legendary")) {
            min = 3;
            max = 5;
            attack = ThreadLocalRandom.current().nextInt(min, max + heroLevel);
        }
        if (Rarity.equals("Mythic")) {
            min = 4;
            max = 7;
            attack = ThreadLocalRandom.current().nextInt(min, max + heroLevel);
        }
        return attack;
    }

    public static int getDefense() {
        int defense = 0;
        int heroLevel = Hero.getHeroLevel();
        if (Rarity.equals("Common")) {
            min = 1;
            max = 1;
            defense  = ThreadLocalRandom.current().nextInt(min, max + heroLevel);
        }
        if (Rarity.equals("Rare")) {
            min = 2;
            max = 3;
            defense  = ThreadLocalRandom.current().nextInt(min, max + heroLevel);
        }
        if (Rarity.equals("Legendary")) {
            min = 3;
            max = 5;
            defense  = ThreadLocalRandom.current().nextInt(min, max + heroLevel);
        }
        if (Rarity.equals("Mythic")) {
            min = 4;
            max = 7;
            defense  = ThreadLocalRandom.current().nextInt(min, max + heroLevel);
        }
        return defense;
    }

    public static int getHitPoints() {
        int hitpoints = 0;
        int heroLevel = Hero.getHeroLevel();
        if (Rarity.equals("Common")) {
            min = 1;
            max = 1;
            hitpoints = ThreadLocalRandom.current().nextInt(min, max + heroLevel);
        }
        if (Rarity.equals("Rare")) {
            min = 2;
            max = 3;
            hitpoints = ThreadLocalRandom.current().nextInt(min, max + heroLevel);
        }
        if (Rarity.equals("Legendary")) {
            min = 3;
            max = 5;
            hitpoints = ThreadLocalRandom.current().nextInt(min, max + heroLevel);
        }
        if (Rarity.equals("Mythic")) {
            min = 4;
            max = 7;
            hitpoints = ThreadLocalRandom.current().nextInt(min, max + heroLevel);
        }
        return hitpoints;
    }

    public static void createArtifact() {
        Name = getName();
        Rarity = getRarity();
        Type = getType();
        if (Type.equals("weapon")) {
            Attack = getAttack();
        }
        if (Type.equals("armor")) {
            Defense = getDefense();
        }
        if (Type.equals("helm")) {
            HitPoints = getHitPoints();
        }
        
    }

    public static void getArtifactStatsGUI() {
        if ("weapon".equals(Type)) {
            ArtifactMenu.ArtifactLabel.setText("Stats-> +" + Attack + "attack");
            if ((Hero.Attack - Attack) != savedAttack)
                ArtifactMenu.ArtifactStats.setText("Current equiped artifact stats -> +" + (Hero.Attack - savedAttack) + "attack");
        }
        if ("armor".equals(Type)) {
            ArtifactMenu.ArtifactLabel.setText("Stats-> +" + Defense + "defense");
            if ((Hero.Defense - Defense) != savedDefense)
                ArtifactMenu.ArtifactStats.setText("Current equiped artifact stats -> +" + (Hero.Defense - savedDefense) + "defense");
        }
        if ("helm".equals(Type)) {
            hpCap = HitPoints + savedHitPoints;
            ArtifactMenu.ArtifactLabel.setText("Stats-> +" + HitPoints + "hp");
            //Current artifact equipped stats
            ArtifactMenu.ArtifactStats.setText("Current equiped artifact stats -> +" + previousItem + "hp");
        }
    }

    public static void getArtifactStats() {
        if ("weapon".equals(Type)) {
            System.out.println("Stats-> +" + Attack + "attack");
            if ((Hero.Attack - Attack) != savedAttack)
                System.out.println("Current equiped artifact stats -> +" + (Hero.Attack - savedAttack) + "attack");
        }
        if ("armor".equals(Type)) {
            System.out.println("Stats-> +" + Defense + "defense");
            if ((Hero.Defense - Defense) != savedDefense)
                System.out.println("Current equiped artifact stats -> +" + (Hero.Defense - savedDefense) + "defense");
        }
        if ("helm".equals(Type)) {
            System.out.println("Stats-> +" + HitPoints + "hp");
            if ((Hero.HitPoints - HitPoints) != savedHitPoints)
                System.out.println("Current equiped artifact stats -> +" + (Hero.HitPoints - savedHitPoints) + "hp");
        }
    }

    public static void preStatsSave() {
        savedAttack = Hero.Attack;
        savedDefense = Hero.Defense;
        savedHitPoints = Hero.HitPoints;
    }

    public static void unEquipArtifact() {
        Hero.Attack = savedAttack;
        Hero.Defense = savedDefense;
        Hero.HitPoints = savedHitPoints;
    }

    public static void unEquipArtifactHitPoints() {
        damagedHP = savedHitPoints - Hero.HitPoints;
        Hero.Attack = savedAttack;
        Hero.Defense = savedDefense;
        Hero.HitPoints = savedHitPoints;
    }

    public static void levelEquipArtifact() {
        Hero.Attack = Hero.Attack + Attack;
        Hero.Defense = Hero.Defense + Defense;
        Hero.HitPoints = Hero.HitPoints + HitPoints;
    }

    public static void equipArtifact() {
        previousItem = HitPoints;
        Hero.Attack = Hero.Attack + Attack;
        Hero.Defense = Hero.Defense + Defense;
        Hero.HitPoints = (Hero.HitPoints + HitPoints) - damagedHP;
        System.out.println("You have equiped the artifact!");
    }
}