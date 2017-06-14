package com.hyaves.engine.level;

import java.util.ArrayList;
import java.util.List;

import com.hyaves.engine.entity.Entity;
import com.hyaves.engine.entity.projectile.Projectile;
import com.hyaves.engine.graphics.Screen;
import com.hyaves.engine.level.tile.Tile;

public abstract class Level {
	
	public int width, height;
	protected int[] tilesInt;
	protected int[] tiles;
	
	protected List<Entity> entities = new ArrayList<Entity>();
	protected List<Projectile> projectiles = new ArrayList<Projectile>();
	
	public static Level spawn = new SpawnLevel("/textures/spawnlevel.png");
	
	public Level(int width, int height){
		
		this.width = width;
		this.height = height;
		tilesInt = new int[width * height];
		generateLevel();
	}
	
	public Level(String path){
		loadLevel(path);
	}

	protected void generateLevel() {
		
	}
	
	protected void loadLevel(String path){
		
	}
	
	public void update(){
		for(int i = 0; i < entities.size(); i++){
			entities.get(i).update();
		}
		
		for(int i = 0; i < projectiles.size(); i++){
			projectiles.get(i).update();
		}
	}
	
	public void render(int xScroll, int yScroll, Screen screen){
		screen.setOffset(xScroll, yScroll);
		int x0 = xScroll >> 4;
		int x1 = (xScroll + screen.width + 16) >> 4;
		int y0 = yScroll >> 4;
		int y1 = (yScroll + screen.height + 16) >> 4;
		
		for(int y = y0; y < y1; y++){
			for(int x = x0; x < x1; x++){
				getTile(x, y).render(x, y, screen);									
			}
		}	
		
		for(int i = 0; i < entities.size(); i++){
			entities.get(i).render(screen);
		}
		
		for(int i = 0; i < projectiles.size(); i++){
			projectiles.get(i).render(screen);
		}
	}
	
	public Tile getTile(int x, int y){
		if(x < 0 || y < 0 || x >= width || y >= height) return Tile.voidTile;
		if(tiles[x + y * width] == Tile.color_grass) return Tile.spawn_grass;	
		if(tiles[x + y * width] == Tile.color_hedge) return Tile.hedge;
		if(tiles[x + y * width] == Tile.color_water) return Tile.water;
		if(tiles[x + y * width] == Tile.color_wall1) return Tile.wall1;	
		if(tiles[x + y * width] == Tile.color_wall2) return Tile.wall2;
		if(tiles[x + y * width] == Tile.color_floor) return Tile.floor;
		return Tile.voidTile;
	}
	
	public void add(Entity e){
		entities.add(e);
	}
	
	public void addProjectile(Projectile e){
		projectiles.add(e);
	}
	
	public List<Projectile> getProjectile(){
		return projectiles;
	}
}
