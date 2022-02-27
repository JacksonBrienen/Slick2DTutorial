package com.github.jacksonbrienen.spaceshooter;

import org.newdawn.slick.*;
import org.newdawn.slick.geom.*;

public class Laser {
	
	public static float WIDTH = 5, HEIGHT = 20; // Default width and height of the laser, we use static because the same default width and height will be used across all instances of Laser
	private static float SPEED = 200; // Speed of the laser, again static is used because all instances of static will access the same SPEED
	private static Color COLOR = Color.orange; // The color of the laser, static is also used for the same reasons as above
	private Polygon bounds;
	
	public Laser(float x, float y) {
		this(x, y, WIDTH, HEIGHT);
	}
	
	public Laser(float x, float y, float width, float height) {
		bounds = new Polygon(new float[] {
				x, y,
				x+width, y,
				x+width, y+height,
				x, y+height
			});
	}
	
	public void render(GameContainer container, Graphics g) {
		g.setColor(COLOR);
		g.draw(bounds);
	}
	
	public void update(GameContainer container, float delta) {
		bounds = (Polygon)bounds.transform(Transform.createTranslateTransform(0, -SPEED*delta));
	}
	
	public boolean isOffScreen() {
		return bounds.getCenterY()+bounds.getBoundingCircleRadius()<0;
	}
	
	public Polygon getBounds() {
		return bounds;
	}
}
