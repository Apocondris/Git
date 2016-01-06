package ladowanie_poziomu;

import java.awt.Font;
import java.awt.Graphics2D;
import java.io.File;
import java.io.IOException;

import engine.LoadImageFrom;
import engine.SpriteSheet;
import generator.Map;
import glowne.Stickfights;
import polaczenie.ConnectionClient;
import ruchomeObiekty.EnemyPlayer;
import ruchomeObiekty.Player;
import stany_gry.GameState;
import stany_gry.GameStateManager;

public class MultiplayerLevelLoaderClient extends GameState {

	ConnectionClient polaczenie;
	Map map;
	SpriteSheet background = new SpriteSheet();
	private static boolean quit = false;
	Player player = new Player();
	EnemyPlayer enemyPlayer = new EnemyPlayer();
	
	

	public MultiplayerLevelLoaderClient(GameStateManager gsm, ConnectionClient polaczenie) {
		super(gsm);
		this.polaczenie = polaczenie;
	}

	@Override
	public void init() {
		
		player.init();
		enemyPlayer.init();
		background.setSpriteSheet(LoadImageFrom.loadImageFrom(Stickfights.class,"training_map.png"));
		File plik = new File("mapa.txt");
		map = new Map(plik);
		map.init();
	}

	@Override
	public void tick(double deltaTime) {

		map.tick(deltaTime);
		player.tick(deltaTime);
		enemyPlayer.tick(deltaTime);
	}

	@Override
	public void render(Graphics2D g) {
		
		g.drawImage(background.getTile(0, 0, 999, 699),0,0,Stickfights.width, Stickfights.height, null);
		map.render(g);
		player.render(g);
		enemyPlayer.render(g);

	}

}
