package grongusadventure.screens;

import java.awt.event.KeyEvent;

import asciiPanel.AsciiPanel;
import grongusadventure.world.World;
import grongusadventure.world.WorldBuilder;

public class PlayScreen implements Screen {

	private World world;
	private int centerX;
	private int centerY;
	private int screenWidth;
	private int screenHeight;
	
	public PlayScreen() {
		screenWidth = 80;
		screenHeight = 21;
		createWorld();
	}
	
	private void createWorld() {
		world = new WorldBuilder(90, 31).generateCaves().build();	
	}
	
	private void displayTiles(AsciiPanel terminal, int left, int top) {
		for (int x = 0; x < screenWidth; x++) {
			for (int y = 0; y < screenHeight; y++) {
				int boundX = x + left;
				int boundY = y + top;
				
				terminal.write(world.getTileGlyph(boundX, boundY), x, y, world.getTileColour(boundX, boundY));
			}
		}
	}
	
	private void scrollBy(int x, int y) {
		centerX = Math.max(0, Math.min(centerX + x, world.getWidth() - 1));
		centerY = Math.max(0, Math.min(centerX + y, world.getWidth() - 1));
	}
	
	public int getScrollX() {
		return Math.max(0, Math.min(centerX - screenWidth / 2, world.getWidth() - screenWidth));
	}
	
	public int getScrollY() {
		return Math.max(0, Math.min(centerY - screenHeight / 2, world.getHeight() - screenHeight));
	}
	
	@Override
	public void display(AsciiPanel terminal) {
		int left = getScrollX();
		int top = getScrollY();
		displayTiles(terminal, left, top);
		
		terminal.write('X', centerX - left, centerY - top);
	}

	@Override
	public Screen respondToUserInput(KeyEvent key) {
		
        switch (key.getKeyCode()) {
	        case KeyEvent.VK_ESCAPE: 
	        	return new LoseScreen();
	        case KeyEvent.VK_ENTER: 
	        	return new WinScreen();
	        	
	        case KeyEvent.VK_LEFT:
	        case KeyEvent.VK_H: scrollBy(-1, 0); 
	        	break;
	        case KeyEvent.VK_RIGHT:
	        case KeyEvent.VK_L: scrollBy( 1, 0); 
	        	break;
	        case KeyEvent.VK_UP:
	        case KeyEvent.VK_K: scrollBy( 0,-1); 
	        	break;
	        case KeyEvent.VK_DOWN:
	        case KeyEvent.VK_J: scrollBy( 0, 1); 
	        	break;
	        	
	        case KeyEvent.VK_Y: scrollBy(-1,-1); 
	        	break;
	        case KeyEvent.VK_U: scrollBy( 1,-1); 
	        	break;
	        case KeyEvent.VK_B: scrollBy(-1, 1); 
	        	break;
	        case KeyEvent.VK_N: scrollBy( 1, 1); 
	        	break;
        }
        
        return this;
	}

}
