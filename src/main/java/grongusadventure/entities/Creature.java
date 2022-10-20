package grongusadventure.entities;

import java.awt.Color;

import grongusadventure.world.World;

public class Creature {

	private World world;
	public int posX;
	public int posY;
	private char glyph;
	private Color colour;


    public Creature(World world, char glyph, Color colour){
        this.world = world;
        this.glyph = glyph;
        this.colour = colour;
    }
	
	public char getGlyph() {
		return glyph;
	}

	public Color getColour() {
		return colour;
	}
}
