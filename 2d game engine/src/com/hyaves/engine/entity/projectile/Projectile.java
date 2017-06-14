package com.hyaves.engine.entity.projectile;

import com.hyaves.engine.entity.Entity;
import com.hyaves.engine.graphics.Sprite;

public abstract class Projectile extends Entity {
	
	protected final int xOrigin, yOrigin;
	protected double angle;
	protected double x, y;
	protected Sprite sprite;
	protected double nx, ny;
	protected double distance;
	protected double speed, damage, range;

	public Projectile(int x, int y, double dir) {
		xOrigin = x;
		yOrigin = y;
		angle = dir;
		this.x = x;
		this.y = y;
	}
	
	protected void move(){
		
	}

}
