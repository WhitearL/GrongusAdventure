package grongusadventure.screens;

import java.awt.event.KeyEvent;

import asciiPanel.AsciiPanel;

public class WinScreen implements Screen {

    @Override
    public void display(AsciiPanel terminal) {
	terminal.write("You win", 1, 1);
	terminal.writeCenter("Press enter to restart", 22);
    }

    @Override
    public Screen respondToUserInput(KeyEvent key) {
	return key.getKeyCode() == KeyEvent.VK_ENTER ? new PlayScreen() : this;
    }

}
