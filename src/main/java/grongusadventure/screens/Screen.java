package grongusadventure.screens;

import asciiPanel.AsciiPanel;

import java.awt.event.KeyEvent;

public interface Screen {

    void display(AsciiPanel terminal);

    Screen respondToUserInput(KeyEvent key);

}
