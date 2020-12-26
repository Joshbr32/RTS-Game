package main;

/*
 * Library imports
 */
import java.awt.Graphics;
import java.util.LinkedList;

/*
 * Handler class
 * Handles all the game objects by adding them to a linked list
 */
public class Handler {
	/*
	 * Creates a linked list that will hold all the objects
	 */
	LinkedList<GameObject> object = new LinkedList<GameObject>();

	/*
	 * Tick function is the update loop
	 * loops through all game objects and run their tick functions
	 */
	public void tick() {
		for (int i = 0; i < object.size(); i++) {
			GameObject tempObject = object.get(i);
			tempObject.tick();
		}
	}

	/*
	 * Render function updates the game's display
	 * loops through all game objects and run their render functions
	 */
	public void render(Graphics g) {
		for (int i = 0; i < object.size(); i++) {
			GameObject tempObject = object.get(i);
			tempObject.render(g);
		}
	}

	/*
	 * Adds an object to the list
	 */
	public void addObject(GameObject object) {
		this.object.add(object);
	}

	/*
	 * removes an object from the list
	 */
	public void removeObject(GameObject object) {
		this.object.remove(object);
	}

	/*
	 * Resets the list
	 * used when the gameState's screen or the gameState iteself changes
	 */
	public void resetObjectList() {
		for (int i = 0; i < object.size(); i++) {
			removeObject(object.get(i));
		}
	}
}
