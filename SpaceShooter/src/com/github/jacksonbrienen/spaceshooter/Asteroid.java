package com.github.jacksonbrienen.spaceshooter;

import org.newdawn.slick.*;
import org.newdawn.slick.geom.*;

public class Asteroid {
	
	/*Declare our three asteroids into float array*/
	private static float[] ASTEROID_POLYGON_0 = new float[]{
			-11, -45,
			24, -39,
			52, -27,
			62, -16,
			61, 11,
			37, 25,
			26, 24,
			18, 39,
			-7, 49,
			-29, 46,
			-30, 20,
			-49, 6,
			-49, -3,
			-44, -10,
			-42, -37,
			-20, -36,
		};
	
	private static float[] ASTEROID_POLYGON_1 = new float[]{
			4, -35,
			-46, -21,
			-32, 0,
			-25, 14,
			-11, 35,
			18, 21,
			39, 7,
			53, -21,
		};
	
	private static float[] ASTEROID_POLYGON_2 = new float[]{
			-44, -9,
			-14, -31,
			8, -32,
			9, -32,
			23, -30,
			26, -18,
			33, 9,
			36, 23,
			36, 24,
			19, 29,
			-6, 19,
			-27, 26,
			-50, 20,
			-52, 6,
		};
	
	/*use these three asteroid float arrays into polygons*/
	private static Polygon[] ASTEROIDS = new Polygon[] {
			new Polygon(ASTEROID_POLYGON_0),
			new Polygon(ASTEROID_POLYGON_1),
			new Polygon(ASTEROID_POLYGON_2)
	};
	
	private static float SPEED = 250f; // This is the speed of our asteroid in pixels per second, we use static because the same SPEED will be used by all instances of Asteroid
	private static Color COLOR = Color.gray; // This is the color of our asteroid, we use static here as well because all instances of Asteroid use the same COLOR
	
	private float rotationSpeed; // A float in radians that describes the speed of our rotation in radians per second 
	private Polygon bounds;
	
	
	/*
	 * Constructor for Asteroid that randomizes the asteroid shape that is picked
	 */
	public Asteroid(GameContainer container) {
		this(Game.RANDOM.nextInt(ASTEROIDS.length), container);
	}
	
	/*
	 * Constructor for Asteroid that allows the specific shape of asteroid to be picked
	 */
	public Asteroid(int index, GameContainer container) {
		if(index>ASTEROIDS.length || index<0) { // Bounds check on the passed index argument
			index = 0;
			System.err.printf("Invalid index parameter %d for array size %d, defaulting to 0", index, ASTEROIDS.length);
		}
		Polygon tmp = ASTEROIDS[index];
		bounds = (Polygon) tmp.transform(Transform.createTranslateTransform(Game.RANDOM.nextInt((int)tmp.getBoundingCircleRadius(), container.getWidth()-(int)tmp.getBoundingCircleRadius()), -tmp.getBoundingCircleRadius()));
		rotationSpeed = (float)Math.toRadians(Game.RANDOM.nextInt(10, 35)); // creates random rotation between 10 and 35 degrees, then converts to radians
		if(Game.RANDOM.nextBoolean())
			rotationSpeed*=-1;
	}
	
	public void render(GameContainer container, Graphics g) {
		g.setColor(COLOR);
		g.fill(bounds);
	}
	
	public void update(GameContainer container, float delta) {
		bounds = (Polygon) bounds.transform(Transform.createRotateTransform(rotationSpeed*delta, bounds.getCenterX(), bounds.getCenterY()))// rotates polygon
				.transform(Transform.createTranslateTransform(0, SPEED*delta)); // moves polygon 
	}
	
	public boolean isOffScreen(GameContainer container) {
		return bounds.getCenterY()-bounds.getBoundingCircleRadius()>container.getHeight();
	}
	
	public Polygon getBounds() {
		return bounds;
	}
	
}