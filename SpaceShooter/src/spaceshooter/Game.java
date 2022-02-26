package spaceshooter;

import java.util.*;
import org.newdawn.slick.*;

public class Game extends BasicGame{
	
	public Game() {
		super("Space Shooter"); // We call the super constructor and pass it the title "Space Shooter", this sets the title of our window
	}
	
	// Create a public static random variable, this is useful because it means this
	// single variable can be accessed from any class just by calling Game.RANDOM
	public static SplittableRandom RANDOM = new SplittableRandom();
	private static Color SCORE_COLOR;
	private static int ASTEROID_DELAY = 1250; // in milliseconds
	
	private int points, lives;
	private Ship ship;
	private ArrayList<Laser> lasers;
	private ArrayList<Asteroid> asteroids;
	private int asteroidTimer; // timer to store how long has passed between each asteroid creation
	
	@Override
	/*
	 * This method will be called when the Game is started, we prefer to put our game components in here rather then the constructor
	 * Major Note: We prefer to initialize objects here instead of initializing them in the constructor.
	 * This is because if we ever deal with things like image or audio handling, 
	 * and the display has not yet been started it will crash our program.
	 */
	public void init(GameContainer container) throws SlickException {
		ship = new Ship(container);

		lasers = new ArrayList<>();
		
		asteroids = new ArrayList<>();
		
		SCORE_COLOR = Color.white;
		
		points = 0;
		lives = 3;
	}
	
	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {
		ship.render(container, g);
		
		for(int i=0; i<asteroids.size(); i++)
			asteroids.get(i).render(container, g);
		
		for(int i=0; i<lasers.size(); i++)
			lasers.get(i).render(container, g);
		
		g.setColor(SCORE_COLOR);
		String livesOutput = String.format("Lives: %d", lives);
		g.drawString(livesOutput, container.getWidth()-g.getFont().getWidth(livesOutput)-1, 0);
		g.drawString(String.format("Score: %d", points), 0, 0);
	}
	
	@Override
	public void update(GameContainer container, int delta) throws SlickException {
		if(delta>100)
			delta=100;
		 // Converts milliseconds to seconds this is nice because working on a per second dimension is much nicer then a per millisecond dimension
		float deltaTime = delta/1000f;
		
		Input input = container.getInput();
		
		
		// Object Updating
		ship.update(container, deltaTime);
		
		if(input.isKeyPressed(Input.KEY_SPACE)) {
			lasers.add(ship.shoot());
		}
		
		asteroidTimer+=delta; // add the amount of passed milliseconds to the timer
		if(asteroidTimer>=ASTEROID_DELAY) { // if the value in the timer is greater then amount of delay we want we...
			asteroidTimer-=ASTEROID_DELAY; // subtract the delay value
			asteroids.add(new Asteroid(container)); // make new asteroid
		}
		
		// Updates all the lasers and deletes any that have gone off the screen
		for(int i=0; i<lasers.size(); i++) {
			Laser laser = lasers.get(i);
			laser.update(container, deltaTime);
			if(laser.isOffScreen()) {
				lasers.remove(i);
				i--;
			}
		}
		
		// Updates all the asteroids and deletes any that have gone off the screen
		for(int i=0; i<asteroids.size(); i++) {
			Asteroid asteroid = asteroids.get(i);
			asteroid.update(container, deltaTime);
			if(asteroid.isOffScreen(container)) {
				asteroids.remove(i);
				i--;
			}
		}
		
		
		// Collision Detection for Lasers and Asteroids
		for(int i=0; i<asteroids.size(); i++) {
			Asteroid asteroid = asteroids.get(i);
			for(int n=0; n<lasers.size(); n++) {
				Laser laser = lasers.get(n);
				if(asteroid.getBounds().intersects(laser.getBounds())||asteroid.getBounds().contains(laser.getBounds())) {
					lasers.remove(n);
					n--;
					asteroids.remove(i);
					i--;
					points++;
					break;
				}
			}
		}
		
		// Collision Detection for Ship and Asteroids
		for(int i=0; i<asteroids.size(); i++) {
			Asteroid asteroid = asteroids.get(i);
			if(asteroid.getBounds().intersects(ship.getBounds())||asteroid.getBounds().contains(ship.getBounds())) {
				lives--;
				asteroids.remove(i);
				break;
			}
		}
	}
}
