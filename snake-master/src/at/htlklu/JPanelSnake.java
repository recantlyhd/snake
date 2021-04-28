package at.htlklu;

import java.awt.*;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import static java.awt.Font.*;

public class JPanelSnake extends JPanel implements ActionListener {

	private Snake snake;
	private Food apple;
	private Food poison;
	private boolean isRunning;
	private JLabel score;
	private static int DELAY = 200;
	private Timer timer;

	/**
	 * Create the panel.
	 */
	public JPanelSnake(JFrameSnake parent) {
		initComponents();
		snake = new Snake();
		apple = new Apple();
		poison = new Poison();
		isRunning = true;
		score = parent.getScoreLabel();
		timer = new Timer(DELAY, this);
		timer.start();
		this.setFocusable(true);

	}

	private void initComponents() {
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				thisKeyPressed(e);
			}
		});
		setBackground(Color.DARK_GRAY);
	}

	protected void thisKeyPressed(KeyEvent ke) {

		int key = ke.getKeyCode();
		Direction dir = snake.getDirection();

		if ((key == KeyEvent.VK_LEFT) && (dir != Direction.EAST)) {
			dir = Direction.WEST;
		}

		if ((key == KeyEvent.VK_RIGHT) && (dir != Direction.WEST)) {
			dir = Direction.EAST;
		}

		if ((key == KeyEvent.VK_UP) && (dir != Direction.SOUTH)) {
			dir = Direction.NORTH;
		}

		if ((key == KeyEvent.VK_DOWN) && (dir != Direction.NORTH)) {
			dir = Direction.SOUTH;
		}
		if (!isRunning && key == KeyEvent.VK_N){
			restartGame();
		}
		snake.setDirection(dir);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (isRunning) {
			snake.draw(g);
			apple.draw(g);
			poison.draw(g);

		} else {
			timer.stop(); 	// TIMER STOPPEN

			g.setColor(Color.BLUE);
			g.setFont(new Font("sans-serif", Font.ITALIC, 20));
			g.drawString("GAME OVER...", this.getHeight() / 2, this.getWidth() / 3);

		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (isRunning) {
			snake.move();
			snake.eatFood(apple);
			snake.eatFood(poison);
			score.setText(snake.getScore() + "");
			if (snake.eatsItself() || hasCollisionWithSnake()) {
				isRunning = false;
			}

		}
		repaint();

	}

	public boolean hasCollisionWithSnake() {
		Point head = snake.getHead();
		int height = this.getHeight();
		int width = this.getWidth();

		if (head.x >= width || head.x < 0 || head.y >= height || head.y <= 0) {
			return true;
		}

		return false;
	}
	private void restartGame(){
		isRunning = true;
		snake = new Snake();
		timer.start();
	}
}
