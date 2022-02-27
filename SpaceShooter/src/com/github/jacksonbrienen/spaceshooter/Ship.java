package com.github.jacksonbrienen.spaceshooter;

import org.newdawn.slick.*;
import org.newdawn.slick.geom.*;

public class Ship {
	private static float SPEED = 150f; // The speed of our ship in pixels per second, we use static because it will be accessed by all instances of ship
	private static Color COLOR = Color.white; // The color of the ship, we use static because it will be accessed by all instances of ship
	private Polygon bounds;
	
	public Ship(GameContainer container) {
		// Create the shape of our ship
		bounds = new Polygon(new float[] { 
				0, 0,
				-7, 20,
				0, 12,
				7, 20
		});
		// Scale up our ship
		bounds = (Polygon)bounds.transform(Transform.createScaleTransform(2f, 2f));
		// Move ship to correct location
		bounds = (Polygon)bounds.transform(Transform.createTranslateTransform(container.getWidth()/2, container.getHeight() - bounds.getBoundingCircleRadius()*2-50)); 
	}
	
	public void render(GameContainer container, Graphics g) {
		g.setColor(COLOR);
		g.draw(bounds);
	}
	
	public void update(GameContainer container, float delta) {
		Input input  = container.getInput();
		// Move the ship to the right is the right arrow or d is pressed
		if(input.isKeyDown(Input.KEY_RIGHT)||input.isKeyDown(Input.KEY_D)) {
			// only move if the movement does not cause the ship to go off the screen
			if(bounds.getCenterX()+bounds.getBoundingCircleRadius()/2+SPEED*delta<container.getWidth())
				bounds = (Polygon)bounds.transform(Transform.createTranslateTransform(SPEED*delta, 0));
		}
		// Move the ship to the left is the left arrow or a is pressed
		if(input.isKeyDown(Input.KEY_LEFT)||input.isKeyDown(Input.KEY_A)) {
			// only move if the movement does not cause the ship to go off the screen
			if(bounds.getCenterX()-bounds.getBoundingCircleRadius()/2-SPEED*delta>0)
				bounds = (Polygon)bounds.transform(Transform.createTranslateTransform(-SPEED*delta, 0));
		}
	}
	
	/*
	 * Shooting creates a new Laser object that is located at the top of the ship
	 */
	public Laser shoot() {
		return new Laser(bounds.getCenter()[0]-Laser.WIDTH/2, bounds.getCenter()[1]-bounds.getBoundingCircleRadius()-Laser.HEIGHT);
	}
	
	public Polygon getBounds() {
		return bounds;
	}
}
