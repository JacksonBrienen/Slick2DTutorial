package com.github.jacksonbrienen.example;

import java.io.File;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

public class Launcher {

	public static void main(String[] args) throws SlickException {
		/*
		 * These Three lines are needed to make Slick2D work properly, they rely on "native" folder,
		 * it will not work if the "native" folder is missing
		 */
		String nativePath = new File("native").getAbsolutePath();
		System.setProperty("org.lwjgl.librarypath", nativePath);
		System.setProperty("net.java.games.input.librarypath", nativePath);
		
		/*
		 * This creates a GameContainer application for our Game, which we title with "Hello World!" through its constructor
		 * The 500, 500 sets the Width to 500px and the Height to 500px
		 * The false refers to if the Window should be fullscreened or not, in this case it is windowed
		 */
		AppGameContainer display = new AppGameContainer(new Game("Hello World!"), 500, 500, false);
		// This starts the display, showing the window, and calling the Game's init method
		display.start();
	}

}
