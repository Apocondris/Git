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
	Player player;
	EnemyPlayer enemyPlayer;
	
	

	public MultiplayerLevelLoaderClient(GameStateManager gsm, ConnectionClient polaczenie) {
		super(gsm);
		this.polaczenie = polaczenie;
	}

	@Override
	public void init() {
		player = new Player(200,690);
		enemyPlayer = new EnemyPlayer(800,690);
		
		player.init(enemyPlayer);
		enemyPlayer.init();
		background.setSpriteSheet(LoadImageFrom.loadImageFrom(Stickfights.class,"training_map.png"));
		File plik = new File("mapa.txt");
		map = new Map(plik);
		map.init();
	}

	@Override
	public void tick(double deltaTime) {
		String[] data = {"0","0","0","0","0","0","0","0"};
		String enemyKeys = "00000000";
		
		map.tick(deltaTime);
		player.tick(deltaTime);

		try {
			enemyKeys = polaczenie.getData();
			System.out.println(enemyKeys);
			data = enemyKeys.split("");
			enemyPlayer.setKeys(data);
			if(data[7]=="1"){
				
			}
			
			data = player.getPressedKeys();
			polaczenie.sendData(data);
			
		} catch (IOException e) {
			e.printStackTrace();
		}

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
