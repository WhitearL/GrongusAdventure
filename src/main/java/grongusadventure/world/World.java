package grongusadventure.world;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import grongusadventure.entities.Creature;

public class World {

	private Tile[][] tileGrid;
	private List<Creature> creatures;
	private int width;
	private int height;
	
	public World(Tile[][] tileGrid) {
		this.creatures = new ArrayList<>();
		this.tileGrid = tileGrid;
		this.width = tileGrid.length;
		this.height = tileGrid[0].length;
	}

	public void dig(int x, int y) {
		if (getTile(x, y).isDiggable()) {
			tileGrid[x][y] = Tile.FLOOR;
		}
	}

	public void addAtEmptyLocation(Creature creature){
	    int x;
	    int y;
	  
	    do {
	        x = (int)(Math.random() * width);
	        y = (int)(Math.random() * height);
	    } 
	    while (!getTile(x,y).isGround() || getCreature(x,y) != null);
	  
	    creature.setPosX(x);
	    creature.setPosY(y);
	    creatures.add(creature);
	}
	
	public Creature getCreature(int x, int y){
	    for (Creature c : creatures){
	        if (c.getPosX() == x && c.getPosY() == y)
	            return c;
	    }
	    return null;
	}
	
	public Tile getTile(int posX, int posY) {
		if (posX < 0 || posX >= width || posY < 0 || posY >= height) {
			return Tile.BOUNDS;
		} else {
			return tileGrid[posX][posY];
		}
	}
	
	public char getTileGlyph(int x, int y){
        return getTile(x, y).getGlyph();
    }

	public Color getTileColour(int x, int y){
        return getTile(x, y).getColor();
    }
	
	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

}
