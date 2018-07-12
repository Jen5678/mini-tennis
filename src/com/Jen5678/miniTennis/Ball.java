package com.Jen5678.miniTennis;

import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Ball {
	
	private static final int BALLDIAMETER = 30;
	
	private int x = 0;
	private int y = 0;
	private int xa = 1;
	private int ya = 1;
	
	private Game game;
	
	public Ball(Game game) {
		this.game = game;
	}
	
	void move() {

		if (x + xa < 0) {
			xa = game.speed; 
		} else if (x + xa > game.getWidth() - BALLDIAMETER) {
			xa = -game.speed;
		} else if (y + ya < 0) {  
			ya = game.speed;
		} else if (y + ya > game.getHeight() - BALLDIAMETER) { 
			game.gameOver();
		} else if (collision()) {
			ya = -game.speed;
			y = game.racquet.getTopY() - BALLDIAMETER;
			game.speed++;
		}
		
		x += xa;
		y += ya;
	}
	
	
	private boolean collision() {
		return game.racquet.getBounds().intersects(getBounds());
	}

	public void paint (Graphics2D g2D) {
		g2D.fillOval(x, y, BALLDIAMETER, BALLDIAMETER);		
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, BALLDIAMETER, BALLDIAMETER);
	}
}
