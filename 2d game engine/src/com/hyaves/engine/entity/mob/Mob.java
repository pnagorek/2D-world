package com.hyaves.engine.entity.mob;


import com.hyaves.engine.entity.Entity;
import com.hyaves.engine.entity.projectile.Projectile;
import com.hyaves.engine.entity.projectile.WizardProjectile;
import com.hyaves.engine.graphics.Sprite;

public abstract class Mob extends Entity {
	
	protected Sprite sprite;
	protected int dir = 0;
	protected boolean moving = false;
	
	
	public void move(int dx, int dy){
		
		if(dx != 0 && dy != 0){
			move(dx, 0);
			move(0, dy);
			return;
		}
		
		if(dx > 0) dir = 1; //east
		if(dx < 0) dir = 3;	//west
		if(dy < 0) dir = 0; //north
		if(dy > 0) dir = 2; //south
		
		if(!collision(dx, dy)){
			x += dx;
			y += dy;
		}	
	}
	
	public void update(){
		
	}
	
	public void render(){
		
	}
	
	private boolean collision(int dx, int dy){

		boolean solid = false;
		
		for(int i = 0; i < 4; i++){
			
			int xt = ((x + dx) + i % 2 * 14 - 8) >> 4;
			int yt = ((y + dy) + i / 2 * 12 + 3) >> 4;
			if(level.getTile(xt, yt).isSolid()) solid = true;
		}
		
		return solid;		
	}
	
	public void shoot(int x, int y, double dir){

		Projectile p = new WizardProjectile(x, y, dir);
		level.addProjectile(p);
	}
	
	
	
}
