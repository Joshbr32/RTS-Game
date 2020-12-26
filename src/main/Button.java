package main;

/*
 * Library imports
 */
import java.awt.Graphics;

/*
 * Button class 
 */
public class Button extends GameObject {
	private int length, height;

	public Button(int x, int y, int length, int height) {
		super(x, y, ID.Button);
		this.length = length;
		this.height = height;
	}

	/*
	 * Tick function runs as the game update loop
	 * Tick should check when action runs
	 */
	public void tick() {
		// TODO Auto-generated method stub

	}

	/*
	 * Draws the button using JFrame
	 */
	public void render(Graphics g) {

	}

	/*
	 * Placeholder function
	 */
	public void action() {

	}
}
