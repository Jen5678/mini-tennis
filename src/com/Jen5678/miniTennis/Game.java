package com.Jen5678.miniTennis;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Game extends JPanel{
	
	static int x = 0;
	static int y = 0;
	
	public void moveBall() {
		x++; 
		y++;
	}

		@Override 
		public void paint(Graphics g) {
			super.paint(g);
			Graphics2D g2D = (Graphics2D) g; 
			g2D.setColor(Color.RED);
			g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
					RenderingHints.VALUE_ANTIALIAS_ON);
			g2D.fillOval(x, y, 30, 30);		}
	
	public static void main(String[] args) throws InterruptedException {
		JFrame frame = new JFrame("Mini-Tennis");
		frame.setSize(500, 500);
		Game Game = new Game();
		frame.add(Game);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
	
		while (true) {
			Game.moveBall();
			Game.repaint();
			Thread.sleep(10);
		
		}
	
	}
}
