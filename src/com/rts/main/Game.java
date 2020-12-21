package com.rts.main;

import java.awt.Canvas;

public class Game extends Canvas implements Runnable{
	private static final long serialVersionUID = 9207193493046036381L;
	
	public static final int WIDTH = 640, HEIGHT = WIDTH/12*9;
	
	private Thread thread;
	private boolean threadRunning = false;
	
	
	public Game() {
		new Window(WIDTH, HEIGHT, "RTS Game by Josh", this);
	}
	
	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		threadRunning = true;
	}
	
	public synchronized void stop() {
		try {
			thread.join();
			threadRunning = false;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void runGameLoop() {
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double nanoseconds = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		
		while(threadRunning) {
			long now = System.nanoTime();
			delta += (now - lastTime) / nanoseconds;
			lastTime = now;
			while(delta >= 1) {
				tick();
				delta--;
			}
			if(threadRunning) {
				render();
			}
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println("FPS: " + frames);
				frames = 0;
			}
			
		}
		stop();
	}
	
	public static void main(String[] args) {
		new Game();
	}

}
