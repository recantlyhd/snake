package at.htlklu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

public class JFrameSnake extends JFrame {

	private JPanel contentPane;
	private JLabel lblScore;
	private JLabel label;
	private JPanelSnake panelSnake;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameSnake frame = new JFrameSnake();
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JFrameSnake() {
		initComponents();
	}
	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 320, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		lblScore = new JLabel("Score:");
		
		label = new JLabel("0");
		
		panelSnake = new JPanelSnake(this);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblScore)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(label)
					.addContainerGap(258, Short.MAX_VALUE))
				.addComponent(panelSnake, GroupLayout.PREFERRED_SIZE, 310, GroupLayout.PREFERRED_SIZE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblScore)
						.addComponent(label))
					.addGap(18)
					.addComponent(panelSnake, GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	public JLabel getScoreLabel() {
		return this.label;
	}
}
