package app;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.sound.sampled.*;

public class Sound {
    public static void play() {
        try {
            String gongFile = "YouDied.mp3";
            InputStream filename = new FileInputStream(gongFile);
            InputStream bufferedIn = new BufferedInputStream(filename);

            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(bufferedIn));
            clip.start();
        } catch (Exception exc) {
            exc.printStackTrace(System.out);
        }
    }
}