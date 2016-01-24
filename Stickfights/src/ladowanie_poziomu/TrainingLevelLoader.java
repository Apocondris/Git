package ladowanie_poziomu;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;

import engine.SpriteSheet;
import generator.Map;
import engine.LoadImageFrom;
import glowne.Stickfights;
import ruchomeObiekty.Player;
import stany_gry.GameState;
import stany_gry.GameStateManager;

public class TrainingLevelLoader extends GameState implements KeyListener{
	
	Map map;
	SpriteSheet background = new SpriteSheet();
	private static boolean quit = false;
	Player player = new Player();
	
	public TrainingLevelLoader(GameStateManager gsm){
		super(gsm);
	}
	
	@Override
	public void init() {
		
		player.init();
		background.setSpriteSheet(LoadImageFrom.loadImageFrom(Stickfights.class,"training_map.png"));
		File plik = new File("mapa.txt");
		map = new Map(plik);
		map.init();
	}

	@Override
	public void tick(double deltaTime) {
		map.tick(deltaTime);
		player.tick(deltaTime);
	}

	@Override
	public void render(Graphics2D g) {
		//g.setBackground(new Color(255, 255, 255));
		//g.drawString("Hello world", 200, 200);

		g.drawImage(background.getTile(0, 0, 999, 699),0,0,Stickfights.width, Stickfights.height, null);
		
		map.render(g);
		player.render(g);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_ESCAPE){
			gsm.states.pop();
			gsm.states.push(new MenuState(gsm));
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
	}

}
