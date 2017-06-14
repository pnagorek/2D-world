package com.hyaves.engine.entity.projectile;

import com.hyaves.engine.graphics.Screen;
import com.hyaves.engine.graphics.Sprite;

public class WizardProjectile extends Projectile {
	
	public static final int FIRE_RATE = 10;

	public WizardProjectile(int x, int y, double dir) {
		super(x, y, dir);
		
		range = 200;
		speed = 4;		
		sprite = Sprite.projectile;
		
		nx = speed * Math.cos(angle);
		ny = speed * Math.sin(angle);

	}
	
	public void update(){
		move();
	}
	
	protected void move(){
		x += nx;
		y += ny;		
		if(distance() > range){
			remove();
		}
	}
	
	private double distance() {
		
		double distance = Math.sqrt(Math.abs((Math.pow((xOrigin - x), 2) + Math.pow((yOrigin - y), 2))));
		return distance;
	}

	public void render(Screen screen){
		screen.renderTile((int)x, (int)y, sprite);
	}

}
