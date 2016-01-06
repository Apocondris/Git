package glowne;

import java.awt.image.BufferedImage;

import engine.LoadImageFrom;
import engine.SpriteSheet;
import ladowanie_poziomu.TrainingLevelLoader;

public class Assets {
	
	public static SpriteSheet blackPlayerRun = new SpriteSheet();
	public static SpriteSheet blackPlayerJump = new SpriteSheet();
	public static SpriteSheet blackPlayerHit = new SpriteSheet();
	
	BufferedImage element_mapy;

	public void init() {
		
		blackPlayerRun.setSpriteSheet(LoadImageFrom.loadImageFrom(Stickfights.class, "25x90bieg.png"));
		blackPlayerJump.setSpriteSheet(LoadImageFrom.loadImageFrom(Stickfights.class, "25x90skok.png"));
		blackPlayerHit.setSpriteSheet(LoadImageFrom.loadImageFrom(Stickfights.class, "40x90cios.png"));
		
	}

}
