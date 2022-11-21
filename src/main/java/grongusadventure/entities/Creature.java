package grongusadventure.entities;

import java.awt.Color;

import grongusadventure.entities.behavior.CreatureAI;
import grongusadventure.world.World;

public class Creature {

    private World world;
    private CreatureAI ai;
    public int posX;
    public int posY;
    private char glyph;
    private Color colour;

    public Creature(World world, char glyph, Color colour) {
	this.world = world;
	this.glyph = glyph;
	this.colour = colour;
    }

    public void dig(int cellX, int cellY) {
	world.dig(cellX, cellY);
    }

    public void moveBy(int dx, int dy) {
	ai.onEnter(posX + dx, posY + dy, world.getTile(posX + dx, posY + dy));
    }

    public void setCreatureAI(CreatureAI ai) {
	this.ai = ai;
    }

    public char getGlyph() {
	return glyph;
    }

    public Color getColour() {
	return colour;
    }

    public void setPosX(int posX) {
	this.posX = posX;
    }

    public void setPosY(int posY) {
	this.posY = posY;
    }

    public int getPosX() {
	return posX;
    }

    public int getPosY() {
	return posY;
    }
}
