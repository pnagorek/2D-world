package com.hyaves.engine.level.tile;

import com.hyaves.engine.graphics.Sprite;
import com.hyaves.engine.graphics.Screen;

public abstract class Tile {
	
	public int x, y;
	public Sprite sprite;
	
	public static Tile grass = new GrassTile(Sprite.grass);
	public static Tile rock = new RockTile(Sprite.rock);
	public static Tile flower = new FlowerTile(Sprite.flower);
	public static Tile voidTile = new VoidTile(Sprite.voidSprite);
	
	public static Tile spawn_grass = new SpawnGrassTile(Sprite.spawn_grass);
	public static Tile hedge = new SpawnHedgeTile(Sprite.hedge);
	public static Tile wall1 = new SpawnWallTile(Sprite.wall1);
	public static Tile wall2 = new SpawnWallTile(Sprite.wall2);
	public static Tile floor = new SpawnFloorTile(Sprite.floor);
	public static Tile water = new SpawnWaterTile(Sprite.water);
	
	public static final int color_grass = 0xff4CFF00;
	public static final int color_hedge = 0xff007F46;
	public static final int color_water = 0xff4314FF;
	public static final int color_floor = 0xff7F3300;
	public static final int color_wall1 = 0xff808080;
	public static final int color_wall2 = 0xffFFD800;
	
	public Tile(Sprite sprite){
		this.sprite = sprite;
	}
	
	public void render(int x, int y, Screen screen){
		screen.renderTile(x << 4, y << 4, this.sprite);
	}
	
	public boolean isSolid(){
		return false;
	}

}
