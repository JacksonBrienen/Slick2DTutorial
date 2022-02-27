package com.github.jacksonbrienen.spaceshooter.util;

import java.io.File;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

public class Launcher {
	
	public static void main(String[] args) throws SlickException {
		// Basic necessary library loading
		String nativePath = new File("native").getAbsolutePath();
		System.setProperty("org.lwjgl.librarypath", nativePath);
		System.setProperty("net.java.games.input.librarypath", nativePath);
		
		// Setting up default screen, no fps control is needed here because this is just a utility for us developers
		AppGameContainer screen = new AppGameContainer(new AsteroidCreator(), 500, 500, false);
		screen.setShowFPS(false);
		screen.start();
	}
}
