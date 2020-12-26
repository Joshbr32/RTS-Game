package main;

/*
 * Library imports
 */
import java.awt.Graphics;

/*
 * Abstract class GameObject
 * Every object that is displayed onto the screen is a of this class
 * Contains methods to properly display the object at a certain coordinate
 */
public abstract class GameObject {

	/*
	 * Variable declaration for x and y coordinates
	 */
	protected int x, y;

	/*
	 * ID is what type of game object the object is
	 */
	protected ID id;

	/*
	 * GameObject constructor
	 */
	public GameObject(int x, int y, ID id) {
		this.x = x;
		this.y = y;
		this.id = id;
	}

	/*
	 * Tick function acts as an update loop
	 */
	public abstract void tick();

	/*
	 * Render function displays everything
	 */
	public abstract void render(Graphics g);

	/*
	 * Public function to change the X coordinate
	 */
	public void setX(int x) {
		this.x = x;
	}

	/*
	 * Public function to change the Y coordinate
	 */
	public void setY(int y) {
		this.y = y;
	}

	/*
	 * Public function to get the X coordinate
	 */
	public int getX() {
		return x;
	}

	/*
	 * Public function to get the Y coordinate
	 */
	public int getY() {
		return y;
	}

	/*
	 * Public function to change the ID
	 * Should not be used?
	 */
	public ID setID(ID id) {
		return id;
	}
}
