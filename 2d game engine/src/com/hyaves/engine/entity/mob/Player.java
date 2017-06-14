package com.hyaves.engine.entity.mob;

import com.hyaves.engine.Game;
import com.hyaves.engine.entity.projectile.WizardProjectile;
import com.hyaves.engine.graphics.Screen;
import com.hyaves.engine.graphics.Sprite;
import com.hyaves.engine.input.Keyboard;
import com.hyaves.engine.input.Mouse;

public class Player extends Mob {
	
	private Keyboard input;
	private int tick;
	
	private int fireRate;;
	
	public Player(Keyboard input){
		this.input = input;
		fireRate = WizardProjectile.FIRE_RATE;
	}
	
	public Player(int x, int y, Keyboard input){
		this.x = x;
		this.y = y;		
		this.input = input;
		fireRate = WizardProjectile.FIRE_RATE;
	}
	
	public void update(){
		
		if(fireRate > 0) fireRate--;
		
		int dx = 0, dy = 0;
		if(input.up) dy--;
		if(input.down) dy++;
		if(input.left) dx--;
		if(input.right) dx++;
		
		if(tick > 1000){
			tick = 0;
		} else {
			tick++;
		}
		
		if(dx != 0 || dy != 0) {
			move(dx, dy);
			moving = true;
		} else {
			moving = false;
		}
		
		clear();
		updateShooting();
	}
	
	private void clear() {
		for(int i = 0; i < level.getProjectile().size(); i++){
			if(level.getProjectile().get(i).isRemoved()){
				level.getProjectile().remove(i);
			}
		}
		
	}

	public void render(Screen screen){

		if(dir == 0) {
			sprite =  Sprite.playerUp;
			if(moving){
				if(tick % 20 > 10){
					sprite =  Sprite.playerUp1;
				} else {
					sprite =  Sprite.playerUp2;
				}				
			}
		}
		if(dir == 1) {
			sprite = Sprite.playerRight;
			if(moving){
				if(tick % 20 > 10){
					sprite =  Sprite.playerRight1;
				} else {
					sprite =  Sprite.playerRight2;
				}				
			}
		}
		
		if(dir == 2) {
			sprite = Sprite.playerDown;
			if(moving){
				if(tick % 20 > 10){
					sprite =  Sprite.playerDown1;
				} else {
					sprite =  Sprite.playerDown2;
				}				
			}
		}
		if(dir == 3) {
			sprite = Sprite.playerLeft;
			if(moving){
				if(tick % 20 > 10){
					sprite =  Sprite.playerLeft1;
				} else {
					sprite =  Sprite.playerLeft2;
				}				
			}
		}
		
		screen.renderPlayer(x - 16, y - 16, sprite);
	} 
	
	private void updateShooting(){
		if(Mouse.getButton() == 1 && fireRate <= 0){
			
			double dx = Mouse.getX() - Game.getWindowWidth() / 2;
			double dy = Mouse.getY() - Game.getWindowHeight() / 2;
			double dir = Math.atan2(dy, dx);			
			shoot(x, y, dir);
			fireRate = WizardProjectile.FIRE_RATE;
		}
	}

}
