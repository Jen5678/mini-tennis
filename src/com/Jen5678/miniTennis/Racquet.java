package com.Jen5678.miniTennis;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;


public class Racquet {
	
	private static final int RACQET_LENGTH 	= 70;
	private static final int RACQET_HEIGHT 	= 10;
	private static final int Y_POSITION 	= 430;
	
	private int x 	= 0;
	private int xa 	= 0;
	
	private Game game;
	
	public Racquet(Game game) {
		this.game = game;
	}

	public void move() {
		if (x + xa > 0 && x + xa < game.getWidth() - RACQET_LENGTH);
			x += xa;
	}
	
	public void paint(Graphics2D g) {
		g.fillRect(x, Y_POSITION, RACQET_LENGTH, RACQET_HEIGHT);
	}
	
	public void keyReleased(KeyEvent e) {
		xa = 0;
	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT) 
			xa = -1;
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) 
			xa = 1;	
	}
	
	public Rectangle getBounds() {
		return new Rectangle (x, Y_POSITION, RACQET_LENGTH, RACQET_HEIGHT);
	}

	public int getTopY() {
		return Y_POSITION;
	}
}
