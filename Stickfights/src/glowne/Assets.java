package glowne;

import java.awt.image.BufferedImage;

import engine.LoadImageFrom;
import engine.SpriteSheet;
import ladowanie_poziomu.TrainingLevelLoader;

public class Assets {
	
	public static SpriteSheet blackPlayerRun = new SpriteSheet();
	public static SpriteSheet blackPlayerJump = new SpriteSheet();
	public static SpriteSheet blackPlayerHit = new SpriteSheet();
	
	public static SpriteSheet redPlayerRun = new SpriteSheet();
	public static SpriteSheet redPlayerJump = new SpriteSheet();
	public static SpriteSheet redPlayerHit = new SpriteSheet();
	
	BufferedImage element_mapy;

	public void init() {
		
		blackPlayerRun.setSpriteSheet(LoadImageFrom.loadImageFrom(Stickfights.class, "30x90runBlack.png"));
		blackPlayerJump.setSpriteSheet(LoadImageFrom.loadImageFrom(Stickfights.class, "25x90skok.png"));
		blackPlayerHit.setSpriteSheet(LoadImageFrom.loadImageFrom(Stickfights.class, "40x90hitBlack.png"));
		
		redPlayerRun.setSpriteSheet(LoadImageFrom.loadImageFrom(Stickfights.class, "30x90runRed.png"));
		redPlayerJump.setSpriteSheet(LoadImageFrom.loadImageFrom(Stickfights.class, "25x90skok.png"));
		redPlayerHit.setSpriteSheet(LoadImageFrom.loadImageFrom(Stickfights.class, "40x90hitRed.png"));
		
	}

}
