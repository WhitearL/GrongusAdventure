package grongusadventure.world;

import java.awt.Color;
import java.util.List;

import grongusadventure.entities.Creature;

public class World {

	private Tile[][] tileGrid;
	private List<Creature> creatures;
	private int width;
	private int height;
	
	public World(Tile[][] tileGrid) {
		this.tileGrid = tileGrid;
		this.width = tileGrid.length;
		this.height = tileGrid[0].length;
	}

	public void dig(int x, int y) {
		if (getTile(x, y).isDiggable()) {
			tileGrid[x][y] = Tile.FLOOR;
		}
	}

	public void addAtEmptyLocation(Creature creature) {
		int posX;
		int posY;
		
		do {
			posX = (int) Math.random() * width;
			posY = (int) Math.random() * height;
		} while (!getTile(posX, posY).isGround());
		
		creature.setPosX(posX);
		creature.setPosY(posY);
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
