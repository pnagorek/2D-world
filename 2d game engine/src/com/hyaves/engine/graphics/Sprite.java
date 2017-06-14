package com.hyaves.engine.graphics;

public class Sprite {
	
	public final int SIZE;
	private int x, y;
	public int[] pixels;
	private SpriteSheet sheet;
	
	public static Sprite grass = new Sprite(16, 0, 0, SpriteSheet.tiles);
	public static Sprite hedge = new Sprite(16, 3, 0, SpriteSheet.tiles);
	public static Sprite wall1 = new Sprite(16, 6, 0, SpriteSheet.tiles);
	public static Sprite wall2 = new Sprite(16, 6, 1, SpriteSheet.tiles);
	public static Sprite floor = new Sprite(16, 7, 0, SpriteSheet.tiles);
	public static Sprite water = new Sprite(16, 5, 0, SpriteSheet.tiles);
	public static Sprite spawn_grass = new Sprite(16, 4, 0, SpriteSheet.tiles);
	
	public static Sprite voidSprite = new Sprite(16, 0);
	public static Sprite flower = new Sprite(16, 1, 0, SpriteSheet.tiles);
	public static Sprite rock = new Sprite(16, 2, 0, SpriteSheet.tiles);
	
	public static Sprite playerDown = new Sprite(32, 2, 1, SpriteSheet.tiles);
	public static Sprite playerUp = new Sprite(32, 0, 1, SpriteSheet.tiles);
	public static Sprite playerLeft = new Sprite(32, 3, 1, SpriteSheet.tiles);
	public static Sprite playerRight = new Sprite(32, 1, 1, SpriteSheet.tiles);
	
	public static Sprite playerDown1 = new Sprite(32, 2, 2, SpriteSheet.tiles);
	public static Sprite playerDown2 = new Sprite(32, 2, 3, SpriteSheet.tiles);
	
	public static Sprite playerUp1 = new Sprite(32, 0, 2, SpriteSheet.tiles);
	public static Sprite playerUp2 = new Sprite(32, 0, 3, SpriteSheet.tiles);
	
	public static Sprite playerLeft1 = new Sprite(32, 3, 2, SpriteSheet.tiles);
	public static Sprite playerLeft2 = new Sprite(32, 3, 3, SpriteSheet.tiles);
	
	public static Sprite playerRight1 = new Sprite(32, 1, 2, SpriteSheet.tiles);
	public static Sprite playerRight2 = new Sprite(32, 1, 3, SpriteSheet.tiles);
	
	public static Sprite projectile = new Sprite(16, 9, 0, SpriteSheet.tiles);
	
	public Sprite(int size, int x, int y, SpriteSheet sheet){
		SIZE = size;
		pixels = new int[SIZE * SIZE];
		this.x = x * size;
		this.y = y * size;
		this.sheet = sheet;
		load();
	}
	
	public Sprite(int size, int color){
		SIZE = size;
		pixels = new int[SIZE * SIZE];
		setColor(color);
	}
	

	private void setColor(int color) {
		for(int i = 0; i < pixels.length; i++){
			pixels[i] = color;	
		}				
	}

	private void load() {
		for(int y = 0; y < SIZE; y++){
			for(int x = 0; x < SIZE; x++){
				pixels[x + (y * SIZE)] = sheet.pixels[(this.x + x) + ((this.y + y) * sheet.SIZE)];
			}
		}		
	}
}
