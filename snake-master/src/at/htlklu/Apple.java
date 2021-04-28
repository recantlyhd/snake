package at.htlklu;

import java.awt.Color;
import java.awt.Graphics;

public class Apple extends Food {

	public Apple() {
		super.color = Color.RED;
		super.bonusPoints = 5;
	}
	
	@Override
	public void move() {
		this.position = new Point();
		resetCounter();

	}


}
