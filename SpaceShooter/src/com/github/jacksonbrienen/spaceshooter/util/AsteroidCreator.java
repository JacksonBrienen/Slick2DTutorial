package com.github.jacksonbrienen.spaceshooter.util;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Polygon;
import org.newdawn.slick.geom.Transform;

import com.github.jacksonbrienen.spaceshooter.Ship;

public class AsteroidCreator extends BasicGame{

	public AsteroidCreator() {
		super("Asteroid Creator");
	}
	
	private Ship ship;
	private Polygon asteroid;

	@Override
	public void init(GameContainer container) throws SlickException {
		resetPolygon();
		ship = new Ship(container);
	}
	
	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {
		if(asteroid.getPointCount()>1)
			g.draw(asteroid);
		// If the polygon only has one point, we will render that as a small square
		else if(asteroid.getPointCount()>0) {
			g.fillRect(asteroid.getPoints()[0], asteroid.getPoints()[1], 1, 1);
		}
		
		ship.render(container, g);
		
		// Prompts the user with controls
		g.drawString("Click to add point", 0, 0);
		g.drawString("[C] to close Polygon", 0, 15);
		g.drawString("[ENTER] to print", 0, 30);
		g.drawString("[ESCAPE] to reset", 0, 45);
	}
	
	@Override
	public void update(GameContainer container, int delta) throws SlickException {
		Input input = container.getInput();
		// Left click adds a point to the asteroid
		if(input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
			asteroid.addPoint(input.getMouseX(), input.getMouseY());
		}
		// Left click adds a point to the asteroid
		if(input.isKeyPressed(Input.KEY_C)) {
			asteroid.setClosed(true);
		}
		// Press enter to print the polygon's float array to the console
		if(input.isKeyPressed(Input.KEY_ENTER)) {
			Polygon tmp = (Polygon)asteroid.transform(Transform.createTranslateTransform(-asteroid.getCenterX(), -asteroid.getCenterY()));
			System.out.println("new float[]{");
			for(int i=0; i<asteroid.getPoints().length; i+=2) {
				System.out.printf("\t%.0f, %.0f,\n",tmp.getPoints()[i],tmp.getPoints()[i+1]);
			}
			System.out.println("}");
		}
		// Escape resets the polygon
		if(input.isKeyPressed(Input.KEY_ESCAPE)) {
			resetPolygon();
		}
	}
	
	public void resetPolygon() {
		asteroid = new Polygon();
		asteroid.setClosed(false);
		asteroid.setAllowDuplicatePoints(false);
	}
}
