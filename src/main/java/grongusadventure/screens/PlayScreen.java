package grongusadventure.screens;

import java.awt.event.KeyEvent;

import asciiPanel.AsciiPanel;
import grongusadventure.entities.Creature;
import grongusadventure.entities.CreatureFactory;
import grongusadventure.world.World;
import grongusadventure.world.WorldBuilder;

public class PlayScreen implements Screen {

	private World world;
	private int screenWidth;
	private int screenHeight;
	private Creature player;
	
	public PlayScreen(){
	    screenWidth = 80;
	    screenHeight = 21;
	    createWorld();
	  
	    CreatureFactory creatureFactory = new CreatureFactory(world);
	    createCreatures(creatureFactory);
	}
	
	private void createCreatures(CreatureFactory creatureFactory){
	    player = creatureFactory.createPlayer();
	  
	    for (int i = 0; i < 8; i++){
	        creatureFactory.newFungus();
	    }
	}
	
	private void createWorld() {
		world = new WorldBuilder(90, 31).generateCaves().build();	
	}
	
	private void displayTiles(AsciiPanel terminal, int left, int top) {
	    for (int x = 0; x < screenWidth; x++){
	        for (int y = 0; y < screenHeight; y++){
	            int wx = x + left;
	            int wy = y + top;

	            Creature creature = world.getCreature(wx, wy);
	            if (creature != null)
	                terminal.write(creature.getGlyph(), creature.getPosX() - left, creature.getPosY() - top, creature.getColour());
	            else
	                terminal.write(world.getTileGlyph(wx, wy), x, y, world.getTileColour(wx, wy));
	        }
	    }
	}
	
	public int getScrollX() {
		return Math.max(0, Math.min(player.getPosX() - screenWidth / 2, world.getWidth() - screenWidth));
	}
	
	public int getScrollY() {
		return Math.max(0, Math.min(player.getPosY() - screenHeight / 2, world.getHeight() - screenHeight));
	}
	
	@Override
	public void display(AsciiPanel terminal) {
		int left = getScrollX();
		int top = getScrollY();
		displayTiles(terminal, left, top);
		
		terminal.write(player.getGlyph(), player.getPosX() - left, player.getPosY() - top, player.getColour());
	}

	@Override
	public Screen respondToUserInput(KeyEvent key) {
		
        switch (key.getKeyCode()) {
	        case KeyEvent.VK_ESCAPE: 
	        	return new LoseScreen();
	        case KeyEvent.VK_ENTER: 
	        	return new WinScreen();
	        	
	        case KeyEvent.VK_LEFT:
	        case KeyEvent.VK_H: player.moveBy(-1, 0); 
	        	break;
	        case KeyEvent.VK_RIGHT:
	        case KeyEvent.VK_L: player.moveBy( 1, 0); 
	        	break;
	        case KeyEvent.VK_UP:
	        case KeyEvent.VK_K: player.moveBy( 0,-1); 
	        	break;
	        case KeyEvent.VK_DOWN:
	        case KeyEvent.VK_J: player.moveBy( 0, 1); 
	        	break;
	        	
	        case KeyEvent.VK_Y: player.moveBy(-1,-1); 
	        	break;
	        case KeyEvent.VK_U: player.moveBy( 1,-1); 
	        	break;
	        case KeyEvent.VK_B: player.moveBy(-1, 1); 
	        	break;
	        case KeyEvent.VK_N: player.moveBy( 1, 1); 
	        	break;
        }
        
        return this;
	}

}
