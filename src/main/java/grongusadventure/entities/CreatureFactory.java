package grongusadventure.entities;

import asciiPanel.AsciiPanel;
import grongusadventure.entities.behavior.PlayerAI;
import grongusadventure.world.World;

public class CreatureFactory {

	private World world;
	
	public CreatureFactory(World world) {
		this.world = world;
	}

	public Creature newFungus(){
	    Creature fungus = new Creature(world, 'f', AsciiPanel.green);
	    world.addAtEmptyLocation(fungus);
	    new FungusAI(fungus);
	    return fungus;
	}
	
	public Creature createPlayer() {
		Creature player = new Creature(world, '@', AsciiPanel.brightWhite);
		world.addAtEmptyLocation(player);
		new PlayerAI(player);
		return player;
	}
	
}
