package main;

/*
 * Library imports
 */
import java.awt.Canvas;
import java.awt.Dimension;

/*
 * Import JFrame
 */
import javax.swing.JFrame;

/*
 * Window creates the application window using Canvas
 */
public class Window extends Canvas {
	private static final long serialVersionUID = -866437234064034313L;

	public Window(int width, int height, String title, Game game) {
		JFrame frame = new JFrame(title);

		frame.setPreferredSize(new Dimension(width, height));
		frame.setMinimumSize(new Dimension(width, height));
		frame.setMaximumSize(new Dimension(width, height));

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.add(game);
		frame.setVisible(true);
		game.start();
	}

}
