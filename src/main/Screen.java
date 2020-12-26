package main;

/*
 * Library imports
 */
import java.awt.Graphics;

/*
 * Public class screen will allow us to differentiate between the Title, Game, and end screens
 * Allowing us to only run the actual game code when needed
 */
public abstract class Screen {
	/*
	 * placeholder for a local copy of the handler
	 */
	protected Handler handler;

	/*
	 * Screen constructor, passes the handler
	 */
	public Screen(Handler handler) {
		this.handler = handler;
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
	 * loadOverlay will determine which overlay is currently active, and then load
	 * it
	 */
	public abstract void loadOverlay();

	/*
	 * screenChange will switch between screens, deleting all old objects
	 */
	public void screenChange(Game game, Handler handler, Screen newState) {

		// Delete all Objects from previous screen
		handler.resetObjectList();

		// Set the new gameState
		game.gameState = newState;
	}
}
