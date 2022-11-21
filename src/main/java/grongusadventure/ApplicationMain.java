package grongusadventure;

import javax.swing.JFrame;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import asciiPanel.AsciiPanel;
import grongusadventure.screens.Screen;
import grongusadventure.screens.StartScreen;

public class ApplicationMain extends JFrame implements KeyListener {

    private static final long serialVersionUID = -7895776404902719682L;

    private AsciiPanel terminal;
    private Screen activeScreen;

    public ApplicationMain() {
	super();
	terminal = new AsciiPanel();
	add(terminal);
	pack();
	activeScreen = new StartScreen();
	addKeyListener(this);
	repaint();
    }

    public static void main(String[] args) {
	ApplicationMain app = new ApplicationMain();
	app.setTitle("Grongus adventure");
	app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	app.setVisible(true);
    }

    public void repaint() {
	terminal.clear();
	activeScreen.display(terminal);
	super.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
	activeScreen = activeScreen.respondToUserInput(e);
	repaint();
    }

}
