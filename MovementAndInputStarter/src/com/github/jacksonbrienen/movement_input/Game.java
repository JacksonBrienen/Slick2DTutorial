package com.github.jacksonbrienen.movement_input;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class Game extends BasicGame{
	
	/*
	 * This is the default constructor for a BasicGame, the parameter title will be the title of the window
	 */
	public Game(String title) {
		super(title);
		// TODO Auto-generated constructor stub
	}

	private Player player;
	
	@Override
	/*
	 * This method will be called before the render or update methods are run, 
	 * this method is usually run when the AppGameContainer's start method is called
	 */
	public void init(GameContainer container) throws SlickException {
		// TODO Auto-generated method stub
		KeySet wasd = new KeySet(Input.KEY_W,Input.KEY_D,Input.KEY_S,Input.KEY_A);
		player = new Player(wasd);
	}
	
	@Override
	/*
	 * This method gets called every frame used to update the graphics on the screen
	 */
	public void render(GameContainer container, Graphics g) throws SlickException {
		// TODO Auto-generated method stub
		player.render(container, g);
	}

	@Override
	/*
	 * This method gets called every frame used to update the positions or mathematics needed for the objects on the screen
	 */
	public void update(GameContainer container, int delta) throws SlickException {
		// TODO Auto-generated method stub
		float deltaSeconds = delta/1000f;
		player.update(container, delta, deltaSeconds); // what should be happening every update call?
	}

}