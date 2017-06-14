package com.hyaves.engine.level.tile;

import com.hyaves.engine.graphics.Screen;
import com.hyaves.engine.graphics.Sprite;

public class VoidTile extends Tile {

	public VoidTile(Sprite sprite) {
		super(sprite);		
	}
	
	public void render(int x, int y, Screen screen){
		screen.renderTile(x << 4, y << 4, this.sprite);
	}
	
	public boolean isSolid(){
		return true;
	}

}
