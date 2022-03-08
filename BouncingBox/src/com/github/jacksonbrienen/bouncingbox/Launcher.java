package introduction;

import java.io.File;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

public class Launcher {

	public static void main(String[] args) throws SlickException {
		String nativePath = new File("native").getAbsolutePath();
		System.setProperty("org.lwjgl.librarypath", nativePath);
		System.setProperty("net.java.games.input.librarypath", nativePath);
		
		AppGameContainer screen = new AppGameContainer(new App("Box Example!"), 750, 500, false);
		screen.start();
	}
	
}
