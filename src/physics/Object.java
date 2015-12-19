package physics;

import java.awt.Color;
import java.awt.Graphics2D;

public class Object {
	public double x, y, xvel, yvel, size, volume, mass, density;
	
	public static double G = 5 * Math.pow(10, -16);
	
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
			
			double distance = Math.sqrt(Math.pow(this.x - Physics.objects.get(i).x, 2) + Math.pow(this.y - Physics.objects.get(i).y, 2));
			
			if(!Physics.objects.get(i).equals(this) && distance < this.size + Physics.objects.get(i).size) {
//				System.out.println((Math.sqrt(Math.pow(this.x - Physics.objects.get(i).x, 2) + Math.pow(this.y - Physics.objects.get(i).y, 2))) + "; " + (this.size + Physics.objects.get(i).size));
/*				this.x -= ((this.size + Physics.objects.get(i).size) / distance) * this.xvel;
				this.y -= ((this.size + Physics.objects.get(i).size) / distance) * this.yvel;
				
				Physics.objects.get(i).x -= ((this.size + Physics.objects.get(i).size) / distance) * Physics.objects.get(i).xvel;
				Physics.objects.get(i).y -= ((this.size + Physics.objects.get(i).size) / distance) * Physics.objects.get(i).yvel;
*/				
				this.xvel = -(this.xvel * (this.mass - Physics.objects.get(i).mass) + (2 * Physics.objects.get(i).mass * Physics.objects.get(i).xvel)) / (this.mass + Physics.objects.get(i).mass);
				this.xvel = -(this.yvel * (this.mass - Physics.objects.get(i).mass) + (2 * Physics.objects.get(i).mass * Physics.objects.get(i).yvel)) / (this.mass + Physics.objects.get(i).mass);
				
				Physics.objects.get(i).xvel = (Physics.objects.get(i).xvel * (Physics.objects.get(i).mass - this.mass) + (2 * this.mass * this.xvel)) / (Physics.objects.get(i).mass + this.mass);
				Physics.objects.get(i).yvel = (Physics.objects.get(i).yvel * (Physics.objects.get(i).mass - this.mass) + (2 * this.mass * this.yvel)) / (Physics.objects.get(i).mass + this.mass);
				
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
		g2d.fillOval((int)(this.x - size), (int)(this.y - size), (int)size * 2, (int)size * 2);
		
	}
	
}
