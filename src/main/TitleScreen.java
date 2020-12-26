package main;

/*
 * Library imports
 */
import java.awt.Graphics;

/*
 * TitleScreen is the first screen loaded when the game launches
 * It starts loaded onto the titleOverlay
 */
public class TitleScreen extends Screen {

	public enum OVERLAY {
		Title
	}

	public TitleScreen(Handler handler) {
		super(handler);
		loadOverlay();
	}

	@Override
	public void tick() {

	}

	@Override
	public void render(Graphics g) {
		// g.setColor(Color.gray);
		// g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
	}

	@Override
	public void loadOverlay() {
		// System.out.println("Load Button");
		handler.addObject(new Button(0, 0, 700, 300));
	}

	/*
	 * Title overlay will have 4 buttons
	 * 1) Play Single Player
	 * 2) Play Multiplayer
	 * 3) Options
	 * 4) Quit
	 */
	public void titleOverlay() {
		handler.addObject(new Button(0, 0, 700, 300));
	}

}
