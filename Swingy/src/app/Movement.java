package app;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Movement implements KeyListener {
    
    Map map;

    public Movement(Map map) {
        this.map = map;
    }

    public void keyPressed(KeyEvent e) {
        map.keyPressed(e);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}