package physics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class Physics extends JPanel implements Runnable {
	private static final long serialVersionUID = 1L;
	
	public static boolean running = false;

	public static void main(String[] args) {
		start();
		
	}

	public static void start() {
		Window.createWindow();
		Thread thread = new Thread(new Physics());
		thread.start();
		
	}
	
	@Override
	public void run() {
		long then = System.nanoTime();
		long now;
		while(running) {
			now = System.nanoTime();
			if(now - then >= 16666667) {
				tick();
				Window.frame.repaint();
				
			}
			
		}
		
	}
	
	public static void tick() {
		
	}
	
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		g2d.setColor(new Color(0, 0, 0));
		g2d.fillRect(0, 0, Window.width, Window.height);
		g2d.setColor(new Color(0, 255, 0));
		g2d.fillRect(500, 500, 50, 50);
		
	}
	
}
