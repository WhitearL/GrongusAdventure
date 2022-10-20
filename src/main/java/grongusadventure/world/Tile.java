package grongusadventure.world;

import java.awt.Color;

import asciiPanel.AsciiPanel;

public enum Tile {

	FLOOR ((char) 250, AsciiPanel.yellow),
	WALL ((char) 177, AsciiPanel.yellow),
	BOUNDS ('x', AsciiPanel.brightBlack);

	private char glyph;
	private Color tileColour;
	
	Tile(char glyph, Color tileColour) {
		this.glyph = glyph;
		this.tileColour = tileColour;
	}
	
	public boolean isDiggable() {
	    return this == Tile.WALL;
	}
	
	public char getGlyph() {
		return this.glyph;
	}
	
	public Color getColor() {
		return this.tileColour;
	}
	
    public boolean isGround() {
        return this != WALL && this != BOUNDS;
    }
	
}
