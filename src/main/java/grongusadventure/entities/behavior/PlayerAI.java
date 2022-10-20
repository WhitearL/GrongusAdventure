package grongusadventure.entities.behavior;

import grongusadventure.entities.Creature;
import grongusadventure.world.Tile;

public class PlayerAI extends CreatureAI {

    public PlayerAI(Creature creature) {
    	super(creature);
    }
    
    public void onEnter(int x, int y, Tile tile) {
    	if (tile.isGround()) {
    		creature.setPosX(x);
    		creature.setPosY(y);
    	} else if (tile.isDiggable()) {
    		creature.dig(x, y);
    	}
    }
    
}