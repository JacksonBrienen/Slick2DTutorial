package com.github.jacksonbrienen.spaceshooter;

import java.io.File;
import org.lwjgl.opengl.Display;
import org.newdawn.slick.*;

public class Launcher {
	
	public static void main(String[] args) throws SlickException, InterruptedException {
		// Gets path to a our native folder then sets that path to load our Slick2D libraries
		// Note: This is fundamental for your code to work properly
		String nativePath = new File("native").getAbsolutePath();
		System.setProperty("org.lwjgl.librarypath", nativePath);
		System.setProperty("net.java.games.input.librarypath", nativePath);
		
		Game game = new Game(); // Creates a new instance of our Game
		// Width = 500, Height = 750, Fullscreen = false
		AppGameContainer screen = new AppGameContainer(game, 500, 750, false);
		// Allows us to click of the window and our game still render
		screen.setAlwaysRender(true);
		// Sets the frame rate to match the refresh rate of the users monitor
		screen.setTargetFrameRate(Display.getDesktopDisplayMode().getFrequency()); // VSync Fail Safe because on some systems setVSync(true) doesn't always work
		screen.setVSync(true);
		// Turns off the default showing of the fps
		screen.setShowFPS(false);
		// Starts our game, this will call our Game's init method
		screen.start();
	}
	
}
