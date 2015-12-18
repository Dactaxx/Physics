package physics;

import java.awt.Color;
import java.awt.Graphics2D;

public class Object {
	public double x, y, xvel, yvel, size, volume, mass, density;
	
	public static double G = 5 * Math.pow(10, -18);
	
	public Object(double x, double y, double xvel, double yvel, double size) {
		this.x = x;
		this.y = y;
		this.xvel = xvel;
		this.yvel = yvel;
		this.size = size;
		this.volume = (4/3) * Math.PI * Math.pow(size, 3);
		this.mass = (5.5 * this.volume) * 100;
		
	}
	
	public void tick() {
//		Physics.objects.remove(this);
		for(int i = 0; i < Physics.objects.size(); i++) {
			if(!Physics.objects.get(i).equals(this)) {
				Physics.objects.get(i).xvel += -((G * this.mass * Physics.objects.get(i).mass) / Math.pow(Math.sqrt(Math.pow(Physics.objects.get(i).x - this.x ,2) + Math.pow(Physics.objects.get(i).y - this.y, 2)), 2.05)) * (Physics.objects.get(i).x - this.x) * (this.mass / Physics.objects.get(i).mass);
				Physics.objects.get(i).yvel += -((G * this.mass * Physics.objects.get(i).mass) / Math.pow(Math.sqrt(Math.pow(Physics.objects.get(i).x - this.x ,2) + Math.pow(Physics.objects.get(i).y - this.y, 2)), 2.05)) * (Physics.objects.get(i).y - this.y) * (this.mass /Physics.objects.get(i).mass);
//				System.out.println(-((G * this.mass * Physics.objects.get(i).mass) / Math.sqrt(Math.pow(Physics.objects.get(i).x - this.x ,2) + Math.pow(Physics.objects.get(i).y - this.y, 2))) * (Physics.objects.get(i).x - this.x));
//				System.out.println(Physics.objects.size());
				
			}
			
		}
		
//		System.out.println(this.xvel + "; " + this.yvel);
//		System.exit(1);
		
		this.x += this.xvel;
		this.y += this.yvel;
//		Physics.objects.add(this);
		
	}
	
	public void render(Graphics2D g2d) {
		g2d.setColor(new Color(255, 150, 0));
		g2d.fillOval((int)(this.x - size / 2), (int)(this.y - size / 2), (int)size, (int)size);
		
	}
	
}
