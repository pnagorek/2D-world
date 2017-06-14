package com.hyaves.engine.graphics;

import java.util.Random;


public class Screen {

	public int width, height;
	public int[] pixels;
	public final int MAP_SIZE = 64;
	public final int MAP_SIZE_MASK = MAP_SIZE - 1;
	
	public int[] tiles = new int[MAP_SIZE * MAP_SIZE];
	
	private Random random = new Random();
	private int xOffset, yOffset;
	
	public Screen(int width, int height){
		this.width = width;
		this.height = height;	
		pixels = new int[width * height];		
		
		for(int i = 0; i < tiles.length; i++){
			tiles[i] = random.nextInt(0xffffff);
		}
	}
	
	public void renderTile(int xp, int yp, Sprite sprite){
		xp -= xOffset;
		yp -= yOffset;		
		for(int y = 0; y < sprite.SIZE; y++){
			int ya = yp + y;
			for(int x = 0; x < sprite.SIZE; x++){
				int xa = xp + x;
				if(xa < -sprite.SIZE || xa >= width || ya < 0 || ya >= height) break;
				if(xa < 0) xa = 0;
				int color = sprite.pixels[x + y * sprite.SIZE];
				if(color != 0xffff00ff){
					pixels[xa + (ya * width)] = color;
				}
				
			}
		}		
	}
	
	public void renderPlayer(int xp, int yp, Sprite sprite){
		xp -= xOffset;
		yp -= yOffset;		
		for(int y = 0; y < sprite.SIZE; y++){
			int ya = yp + y;
			for(int x = 0; x < sprite.SIZE; x++){
				int xa = xp + x;
				if(xa < -sprite.SIZE || xa >= width || ya < 0 || ya >= height) break;
				if(xa < 0) xa = 0;
				int color = sprite.pixels[x + y * sprite.SIZE];
				if(color != 0xffff00ff) {
					pixels[xa + (ya * width)] = color;
				}				
			}
		}		
	}
	
	public void setOffset(int xOffset, int yOffset){
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}

	public void clear(){
		
		for(int i = 0; i < pixels.length; i++){
			pixels[i] = 0;
		}
	}	
	

	/*public void render(int xOffset, int yOffset){
		
		for(int y = 0; y < height; y++){
			
			int yp = y + yOffset;
			if(yp < 0 || yp >= height) continue;
			
			for(int x = 0; x < width; x++){	
				
				int xp = x + xOffset;
				if(xp < 0 || xp >= width) continue;
				
				//int tileIndex = (((x + xOffset) >> 4) & MAP_SIZE_MASK) + (((y + yOffset) >> 4) & MAP_SIZE_MASK) * MAP_SIZE;
				//pixels[x + (y * width)] = tiles[tileIndex];
				//pixels[x + (y * width)] = Sprite.grass.pixels[((x + xOffset) & 15) + ((y + yOffset) & 15) * Sprite.grass.SIZE];
				
				pixels[xp + (yp * width)] = Sprite.grass.pixels[(x & 15) + ((y & 15) * Sprite.grass.SIZE)];
			}
		}
	}*/
}
