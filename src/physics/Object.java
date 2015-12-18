package physics;

import java.awt.Color;
import java.awt.Graphics2D;

public class Object {
	public double x, y, xvel, yvel, size, volume, mass, density;
	
	public Object(double x, double y, double size) {
		this.x = x;
		this.y = y;
		this.size = size;
		this.volume = Math.pow(size, 3);
		Physics.objects.add(this);
		
	}
	
	public void tick() {
		for(int i = 0; i < Physics.objects.size(); i++) {
			if(this.x - Physics.objects.get(i).x != 0) {
				Physics.objects.get(i).xvel += -((this.volume * Physics.objects.get(i).volume) / 5);
				
			}
			
			if(this.y - Physics.objects.get(i).y != 0) {
				Physics.objects.get(i).yvel += (1 / (this.y - Physics.objects.get(i).y)) / 1000000000;
				
			}
			
		}
		
		
		this.x += xvel;
		this.y += yvel;
		
	}
	
	public void render(Graphics2D g2d) {
		g2d.setColor(new Color(255, 150, 0));
		g2d.fillOval((int)(this.x - size / 2), (int)(this.y - size / 2), (int)size, (int)size);
		
	}
	
}
