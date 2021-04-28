package at.htlklu;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Food implements Moveable{

	protected Point position;
	protected int bonusPoints;
	protected Color color;
	protected int foodsize;
	protected int counter;
	
	public Food() {
		this.foodsize = 10;
		this.counter = 50;
		this.position = new Point();
	}
	
	
	public void resetCounter() {
		this.counter = 50;
	}
	
	public void draw(Graphics g) {
		if(counter == 0) {
			move();
			resetCounter();
		}
		
		g.setColor(color);
		g.fillOval(position.x, position.y, this.foodsize, this.foodsize);
		this.counter--;
		
		
	}
	

}
