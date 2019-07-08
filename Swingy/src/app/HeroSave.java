package app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

import app.Hero;

public class HeroSave {
    static PrintWriter pr;
    static BufferedReader br;
    static Scanner console = new Scanner(System.in);
    protected static String chosenHero;
    
    public static void saveHero() throws FileNotFoundException {
        File outputFile = new File("HeroSave.txt");
        pr = new PrintWriter(outputFile);
        pr.println("Arthas");
        pr.close();
        System.out.println("Hero saved successfully!");
    }

    public static void loadHero() throws IOException {
        String st;

        File inputFile = new File("HeroSave.txt");
        br = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile)));

        System.out.println("Heroes list: ");
        while ((st = br.readLine()) != null) {
            // String[] parts = st.split("\\s+");
            System.out.println("-->" + st);
        }
        br.close();
        System.out.println("Choose your saved hero!");
        chosenHero = console.nextLine();
        if (!chosenHero.equals(st)) {
            System.out.println("Chosen hero doesn't exist or incorrect name.");
        }
        //  Choose Hero
        System.out.println("Hero loaded successfully!");
    }
}