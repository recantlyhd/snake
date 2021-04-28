package at.htlklu;

import java.util.Random;

public class Point {
	public int x;
	public int y;
	private static final int RAND_POS = 29;
	private static final int FOODSIZE = 10;
	private static Random rand = new Random();
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Point() {
		int r = rand.nextInt(RAND_POS+1);
		this.x = r * FOODSIZE;
		 r = rand.nextInt(RAND_POS+1);
		this.y = r * FOODSIZE;
		
	}
	
}
