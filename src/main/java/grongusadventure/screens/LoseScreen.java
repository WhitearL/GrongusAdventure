package grongusadventure.screens;

import asciiPanel.AsciiPanel;

import java.awt.event.KeyEvent;

public class LoseScreen implements Screen {

    @Override
    public void display(AsciiPanel terminal) {
        terminal.write("You lose", 1, 1);
        terminal.writeCenter("Press enter to restart", 22);
    }

    @Override
    public Screen respondToUserInput(KeyEvent key) {
        return key.getKeyCode() == KeyEvent.VK_ENTER ? new PlayScreen() : this;
    }

}
