package com.github.jacksonbrienen.input_collisions;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class Collider {
	
	// This constructor must be written
	// What are he parameters?
	// What is needed to be setup here?
	public Collider() {
		
	}
	
	/*
	 * This method gets called every frame used to update the graphics on the screen
	 */
	public void render(GameContainer container, Graphics g) throws SlickException {

	}
	
	/**
	 * The update method, called every frame, making any visual updates to the Collider that are Needed
	 * @param container - The GameContainer object needed for any information or interaction with the game window
	 * @param dm - The amount of time passed in milliseconds between this update call and the last
	 * @param ds - The amount of time passed in seconds between this update call and the last
	 * @throws SlickException
	 */
	// Notice ds, this is the difference in update calls in seconds, simply dm/1000f,
	// This is nice because it is easier to think in "Pixels Per Second" then "Pixels Per Millisecond"
	public void update(GameContainer container, int dm, float ds) throws SlickException {
		
	}
	
	// This method must be written
	// What are the parameters?
	// What must be returned?
	public boolean collidesWith() {
		return false;
	}
}
