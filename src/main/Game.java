
package main;

/* 
 * Library imports
 */
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

/*
 * Game class
 * extends canvas (JFrame)
 * implements Runnable (make the window)
 */
public class Game extends Canvas implements Runnable {
	private static final long serialVersionUID = 9207193493046036381L;

	/*
	 * Current game resolution, will eventually remove static so the resolution can
	 * change
	 */
	public static final int WIDTH = 1280, HEIGHT = WIDTH / 16 * 9;

	/*
	 * Thread stuff
	 */
	private Thread thread;
	private boolean threadRunning = false;

	/*
	 * handler placeholder
	 */
	private Handler handler;

	/*
	 * game state placeholder
	 */
	public Screen gameState;

	/*
	 * Game class
	 * loads the window JFrame, handler and game state
	 */
	public Game() {
		new Window(WIDTH, HEIGHT, "RTS Game v4", this);

		handler = new Handler();
		gameState = new TitleScreen(handler);
	}

	/*
	 * Starts a thread which helps with game optimization
	 */
	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		threadRunning = true;
	}

	/*
	 * Stop code for the thread
	 */
	public synchronized void stop() {
		try {
			thread.join();
			threadRunning = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * Game Loop
	 */
	public void run() {
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double nanoseconds = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;

		while (threadRunning) {
			long now = System.nanoTime();
			delta += (now - lastTime) / nanoseconds;
			lastTime = now;
			while (delta >= 1) {
				tick();
				delta--;
			}
			if (threadRunning) {
				render();
			}
			frames++;

			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println("FPS: " + frames);
				frames = 0;
			}

		}
		stop();
	}

	/*
	 * Tick function is the game's update loop
	 * This main tick function will update:
	 * A) the handler
	 * B) the current game state
	 */
	private void tick() {
		handler.tick();
		gameState.tick();
	}

	/*
	 * Render function will render the graphics onto the screen
	 * It creates a buffer (everything loads into buffer, then the entire buffer
	 * loads onto the screen)
	 */
	private void render() {
		BufferStrategy buffer = this.getBufferStrategy();
		if (buffer == null) {
			// create 3 buffers
			this.createBufferStrategy(3);
			return;
		}

		Graphics g = buffer.getDrawGraphics();

		// Set default white screen
		g.setColor(Color.white);
		g.fillRect(0, 0, WIDTH, HEIGHT);

		handler.render(g);
		gameState.render(g);

		g.dispose();
		buffer.show();
	}

	/*
	 * Main function
	 * all this does is start a new game instance
	 */
	public static void main(String[] args) {
		new Game();
	}

}
