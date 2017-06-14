package com.hyaves.engine.level.tile;

import com.hyaves.engine.graphics.Sprite;

public class RockTile extends Tile {

	public RockTile(Sprite sprite) {
		super(sprite);
	}
	
	public boolean isSolid(){
		return true;
	}

}
