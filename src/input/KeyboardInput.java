package input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardInput implements KeyListener {
    public static KeyboardInput instance = new KeyboardInput();

    public boolean isA = false;
    public boolean isD = false;
    public boolean isW = false;
    public boolean isSpace = false;
    public boolean isS = false;

    private KeyboardInput() {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) this.isW = true;
        if (e.getKeyCode() == KeyEvent.VK_A) this.isA = true;
        if (e.getKeyCode() == KeyEvent.VK_D) this.isD = true;
        if (e.getKeyCode() == KeyEvent.VK_SPACE) this.isSpace = true;
        if (e.getKeyCode() == KeyEvent.VK_S) this.isS = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) this.isW = false;
        if (e.getKeyCode() == KeyEvent.VK_A) this.isA = false;
        if (e.getKeyCode() == KeyEvent.VK_D) this.isD = false;
        if (e.getKeyCode() == KeyEvent.VK_SPACE) this.isSpace = false;
        if (e.getKeyCode() == KeyEvent.VK_S) this.isS = false;
    }
}