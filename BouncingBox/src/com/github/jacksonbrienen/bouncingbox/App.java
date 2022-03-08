package introduction;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class App extends BasicGame{

	// These variables hold the boundaries of our box
	private float x, y, width, height;
	// These variables hold the velocity of the box in the x and y directions
	private float vx, vy;
	
	public App(String title) {
		super(title);
	}

	@Override
	public void init(GameContainer container) throws SlickException {
		x = y = 100f; // sets the starting x and y to (100,100)
		width = height = 50f; // sets the width and height to 50px
		vx = vy = 0.25f; // sets the starting velocity in both the x and y direction to 0.25
		/*
		 * This is one way to set the color of what is being displayed on the screen
		 * It is only called once, there are upsides and downsides of doing this,
		 * One up side is that it is only called once, which means it takes less processing power(And memory in this case)
		 * One down side is that if the g.setColor method is called within the render method, it will override the color set here	
		*/
		container.getGraphics().setColor(Color.red);
	}
	
	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {
		g.fillRect(x, y, width, height);
		/*
		 * This setColor method, even though it is called after the square is drawn will override the
		 * setColor call from the init method for the rest of the time.
		 * There are upsides and downsides to doing this as well.
		 * The upsides are we can have multiple colors throughout our program,
		 * The downsides are that it is slow because we set the color every render call, which gets called many times per second
		 */
		g.setColor(Color.white);
	}

	@Override
	public void update(GameContainer container, int delta) throws SlickException {
		// if the box is going to go off the screen, reverse the direction it is traveling
		// this creates our "bouncing effect"
		if(x+vx+width>container.getWidth() || x+vx<0)
			vx*=-1;
		if(y+vy+height>container.getHeight() || y+vy<0)
			vy*=-1;
		
		// Adds the current velocity to their respective x and y components
		x+= vx;
		y+= vy;
	}

}
