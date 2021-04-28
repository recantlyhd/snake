package at.htlklu;

import java.awt.Color;
import java.awt.Graphics;

public class Poison extends Food {

	
	
	public Poison() {
		super.bonusPoints = -5;
		setRandomColor();
		
		
	}
	
	@Override
	public void move() {
		this.position = new Point();
		setRandomColor();
		resetCounter();
		
	}

	
	private void setRandomColor() {
		double r = Math.random();
		if(r>0.5) {
			super.color = Color.BLUE;
		}else {
			super.color = Color.RED;
		}
	}

}
