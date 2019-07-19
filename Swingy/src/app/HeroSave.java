package app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

import app.Hero;

public class HeroSave {
    static String st;
    static PrintWriter pr;
    static BufferedReader br;
    static Scanner console = new Scanner(System.in);
    static int index;
    protected static String chosenHero;
    
    public static boolean isInteger(String str) {
        if (str == null) {
            return false;
        }
        int length = str.length();
        if (length == 0) {
            return false;
        }
        int i = 0;
        if (str.charAt(0) == '-') {
            if (length == 1) {
                return false;
            }
            i = 1;
        }
        for (; i < length; i++) {
            char c = str.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }
    //Save pre stats for the artifacts
    public static void saveHero() throws IOException {
        index = 1;
        File inputFile = new File("HeroSave.txt");
        br = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile)));
        while ((st = br.readLine()) != null) {
            String[] parts = st.split("\\s+");
            if (Integer.parseInt(parts[0]) == index);
                index = index + 1;
        }
        br.close();
        //
        File outputFile = new File("HeroSave.txt");
        pr = new PrintWriter(new FileWriter(outputFile, true));
        pr.println(index + " " + Hero.heroPrintable());
        pr.close();
        System.out.println("Hero saved successfully!");
    }

    public static void loadHero() throws IOException {
        index = 1;
        int iCount = 0;
        Boolean successFind = false;
        StringBuilder sb = new StringBuilder();
        File inputFile = new File("HeroSave.txt");
        br = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile)));

        System.out.println("Heroes list: ");
        while ((st = br.readLine()) != null) {
            String[] parts = st.split("\\s+");
            sb.append(st);
            sb.append("\n");
            System.out.println("-->" + parts[0] + " " + parts[1] + " the " + parts[2]);
            iCount = iCount + 1;
        }
        br.close();
        System.out.println("Choose your saved hero!\n(Choose character index)");
        chosenHero = console.nextLine();
        String[] parts = sb.toString().split("\\s+");
        //Load in pre stats for artifacts
        try {
            if (Integer.parseInt(chosenHero) <= iCount) {
                if (isInteger(chosenHero)) {
                    while (index != Integer.parseInt(chosenHero) + 1) {
                        int multiplier = (index - 1) * 12;
                        if (chosenHero.equals(parts[multiplier])) {
                            successFind = true;
                        }
                        index = index + 1;
                    }
                }
                if (successFind) {
                    index = index - 1;
                    Hero.loadHero(parts[index * 12 - 11], parts[index * 12 - 10], Integer.parseInt(parts[index * 12 - 9]), Integer.parseInt(parts[index * 12 - 8]),
                    Integer.parseInt(parts[index * 12 - 6]), Integer.parseInt(parts[index * 12 - 5]), Integer.parseInt(parts[index * 12 - 4]),
                    Integer.parseInt(parts[index * 12 - 3]), Integer.parseInt(parts[index * 12 - 2]), Integer.parseInt(parts[index * 12 - 1]));
                    Map.mapGeneration();
                    Villains.villainGenerate();
                    Map.assignHeroCL();
                    System.out.println("Hero loaded successfully!");
                }
            }
            else {
                System.out.println("Hero doesn't exist or incorrect id chosen.");
                loadHero();
            }
        } catch (NumberFormatException e) {
            System.out.println("! - Please enter an integer - !");
            loadHero();
            // e.printStackTrace();
        }
    }
}