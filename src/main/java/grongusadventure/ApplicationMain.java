package grongusadventure;

import asciiPanel.AsciiPanel;
import grongusadventure.screens.Screen;
import grongusadventure.screens.StartScreen;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ApplicationMain extends JFrame implements KeyListener {

    private static final long serialVersionUID = -7895776404902719682L;

    private transient Screen activeScreen;
    private final AsciiPanel terminal;

    public static void main(String[] args) {
        ApplicationMain app = new ApplicationMain();
        app.setTitle("Grongus Adventure");
        app.setDefaultCloseOperation(EXIT_ON_CLOSE);
        app.setVisible(true);
    }

    public ApplicationMain() {
        super();
        terminal = new AsciiPanel();
        activeScreen = new StartScreen();

        add(terminal);
        addKeyListener(this);

        pack();
        repaint();
    }

    @Override
    public void repaint() {
        terminal.clear();
        activeScreen.display(terminal);
        super.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Not implemented
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Not implemented
    }

    @Override
    public void keyPressed(KeyEvent e) {
        activeScreen = activeScreen.respondToUserInput(e);
        repaint();
    }

}
