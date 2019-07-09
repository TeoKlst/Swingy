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
    
    public static void saveHero() throws IOException {
        index = 1;
        //Reader index
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
        }
        br.close();
        System.out.println(" Choose your saved hero!\n(Choose character index)");
        chosenHero = console.nextLine();
        String[] parts = sb.toString().split("\\s+");
        while (index != Integer.parseInt(chosenHero) + 1) {
            int multiplier = (index - 1) * 12;
            if (chosenHero.equals(parts[multiplier])) {
                successFind = true;
            }
            // Index check
            if (multiplier > parts.length)
                break;
            // index = ((index + 1) > parts.length) ?  System.out.println("INDEX TOO LARGE") : index;
            index = index + 1;
        }
        if (successFind) {
            System.out.println("Hero loaded successfully!");
            //Grabs Hero Information
        }
        else {
            System.out.println("Hero doesn't exist or incorrect id chosen.");
            loadHero();
        }
    }
}