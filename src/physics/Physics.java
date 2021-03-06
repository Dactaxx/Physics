package physics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.LinkedList;

import javax.swing.JPanel;

public class Physics extends JPanel implements Runnable {
	private static final long serialVersionUID = 1L;
	
	public static LinkedList<Object> objects = new LinkedList<Object>();
	public static boolean running = false;

	public static void main(String[] args) {
		start();
//		objects.add(new Object(Window.width / 2, Window.height / 2, 0, 0, 500));
		objects.add(new Object(700, 200, 1, 1, 50));
		objects.add(new Object(750, 250, -3, 4, 2.5));
		objects.add(new Object(200, 1000, 0, -.5, 50));
//		objects.add(new Object(1800, 1000, 0, -100, 120));
		
	}

	public static void start() {
		Window.createWindow();
		Thread thread = new Thread(new Physics());
		thread.start();
		running = true;
		
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
				then = System.nanoTime();
//				System.out.println("test");
				
			}
			
		}
		
	}
	
	public static void tick() {
		for(int i = 0; i < objects.size(); i++) {
			objects.get(i).tick();
			
		}
		
	}
	
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		g2d.setColor(new Color(0, 0, 0));
		g2d.fillRect(0, 0, Window.width, Window.height);
		for(int i = 0; i < objects.size(); i++) {
			objects.get(i).render(g2d);
			
		}
		
	}
	
}
