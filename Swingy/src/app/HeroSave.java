package app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import app.Hero;

public class HeroSave {
    static PrintWriter pr;
    static BufferedReader br;

    public void SaveHero() throws FileNotFoundException {
        File outputFile = new File("HeroSave.txt");
        pr = new PrintWriter(outputFile);
        pr.println("WRITES TO FILE");
    }

    public void LoadHero() throws IOException {
        String st;

        File inputFile = new File("HeroSave.txt");
        br = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile)));

        while ((st = br.readLine()) != null) {
            String[] parts = st.split("\\s+");
            if (parts.length == 5) {
                // aircraftFactory.newAircraft(parts[0], parts[1], Integer.parseInt(parts[2]), Integer.parseInt(parts[3]), Integer.parseInt(parts[4])).registerTower(weatherTower);
            }
        }
        br.close();
    }
}