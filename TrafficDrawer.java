package A4Traffic;

import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Color;

public class TrafficDrawer extends JFrame {
	private final int PLUS = 1;
	private final int MINUS = 2;
	private int[][] array;
	private int size;
	private Color colorOne;
	private Color colorTwo;

	// set up all the above variables
	public TrafficDrawer(int[][] array, int size) {
		this.colorOne = Color.CYAN;
		this.colorTwo = Color.WHITE;
		this.array = array;
		this.size = size;
		setSize(5 * size, 5 * size);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	// Same old paint method from the handout, I just pulled the colors out to
	// variables.
	public void paint(Graphics g) {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (array[i][j] == PLUS) {
					g.setColor(colorOne);
					g.fillRect(5 * j, 5 * i, 5, 5);
				} else if (array[i][j] == MINUS) {
					g.setColor(colorTwo);
					g.fillRect(5 * j, 5 * i, 5, 5);
				} else {
					g.setColor(Color.BLACK);
					g.fillRect(5 * j, 5 * i, 5, 5);
				}
			}
		}
	}
}
