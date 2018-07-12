package com.Jen5678.miniTennis;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


@SuppressWarnings("serial")
public class Game extends JPanel{

	Ball ball = new Ball(this);
	Racquet racquet = new Racquet(this); 
	int speed = 1;
	
	private int getScore() {
	return speed = 1;
	}
	
	
	public Game() {
	
		addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}
		
			@Override
			public void keyPressed(KeyEvent e) {
			racquet.keyPressed(e);
			}
		
			@Override
			public void keyReleased(KeyEvent e) {
				racquet.keyReleased(e);
			}
		});
		setFocusable(true);
	}
	
	private void move() {
		ball.move();
		racquet.move();
	}
	
	@Override 
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2D = (Graphics2D) g; 
		g2D.setColor(Color.BLACK);
		g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
					RenderingHints.VALUE_ANTIALIAS_ON);
		ball.paint(g2D);
		racquet.paint(g2D);
	
		g2D.setColor(Color.GRAY);
		g2D.setFont(new Font("Verdana", Font.BOLD, 30));
		g2D.drawString(String.valueOf(getScore()), 10, 30);
	
	}

	public static void main(String[] args) throws InterruptedException {
		JFrame frame = new JFrame("Mini-Tennis");
		Game game = new Game();
		game.setPreferredSize(new Dimension(500, 500));
		frame.add(game);
		frame.setResizable(false);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	
		while (true) {
			game.move();
			game.repaint();
			Thread.sleep(5);
		}
	}
	
//	public class MyKeyListener implements KeyListener {
		
	
	public void gameOver() {
		JOptionPane.showMessageDialog(this, "Game Over", "Game Over", JOptionPane.YES_NO_OPTION);
		System.exit(0);
	}
}
