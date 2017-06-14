package com.hyaves.engine.level.tile;

import com.hyaves.engine.graphics.Sprite;

public class SpawnHedgeTile extends Tile {

	public SpawnHedgeTile(Sprite sprite) {
		super(sprite);
	}
	
	public boolean isSolid(){
		return true;
	}

}
