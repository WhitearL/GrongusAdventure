package grongusadventure.world;

import java.awt.Color;

public class World {

	private Tile[][] tileGrid;
	private int width;
	private int height;
	
	public World(Tile[][] tileGrid) {
		this.tileGrid = tileGrid;
		this.width = tileGrid.length;
		this.height = tileGrid[0].length;
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
