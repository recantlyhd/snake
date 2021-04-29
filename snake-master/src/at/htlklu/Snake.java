package at.htlklu;

import java.awt.Color;
import java.awt.Graphics;

public class Snake implements Moveable, Drawable {

	private Point[] points;
	private int parts; // 
	private int size;
	private int score;
	private Direction direction;
	
	public Snake() {
		points = new Point[100];
		parts = 3;
		size = 10;
		score = 0;
		direction = Direction.EAST;
		for (int i = 0; i < parts; i++) {
			points[i] = new Point(50 - i * size, 50);
		}
		
	}
	
	@Override
	public void move() {
		
		// Schlange um eines nach "hinten" rücken, letzte Position kann dabei ignoriert werden
		for (int i = parts; i >0; i--) {
			points[i] = points[i-1];
		}
		points[0] = new Point(points[0].x, points[0].y);
		switch(direction) {
		case EAST:
			points[0].x  +=  size;
			break;
		case SOUTH:
			points[0].y +=  size;
			break;
		case WEST:
			points[0].x -= size;
			break;
		case NORTH:
			points[0].y -= size;
			break;
		}
		
	}
	
	public void setDirection(Direction dir) {
		this.direction = dir;
	}
	public Direction getDirection() {
		return direction;
	}
	
	public int getScore() {
		return this.score;
	}
	
	public void eatFood(Food f) {
		if(f.position.x == getHead().x && f.position.y == getHead().y) {
			this.score += f.bonusPoints;
			if(f instanceof Apple) {
				parts++;
			}else if(f instanceof Poison) {
				parts--;
			}
			f.move();			
		}
	}

	@Override
	public void draw(Graphics g) {
		// Kopf
		g.setColor(Color.WHITE);
		g.fillOval(points[0].x, points[0].y, this.size, this.size);
		
		// Körper
		g.setColor(Color.PINK);
		for (int i = 1; i < parts; i++) {
			g.fillOval(points[i].x, points[i].y, this.size, this.size);
		}
	}
	
	public boolean eatsItself() {
		int x = getHead().x;
		int y = getHead().y;
		for (int i = 1; i < parts; i++) {
			Point p = points[i];
			if(p.x == x && p.y == y) {
				return true;
			}
		}
		return false;
	}
	
	public Point getHead() {
		return points[0];
	}

}
