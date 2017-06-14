package com.hyaves.engine.level.tile;

import com.hyaves.engine.graphics.Sprite;

public class SpawnWallTile extends Tile {

	public SpawnWallTile(Sprite sprite) {
		super(sprite);
	}

	public boolean isSolid(){
		return true;
	}
}
