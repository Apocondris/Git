package ladowanie_poziomu;

import java.awt.Graphics2D;
import java.io.File;
import java.io.IOException;

import engine.LoadImageFrom;
import engine.SpriteSheet;
import generator.Map;
import glowne.Stickfights;
import polaczenie.ConnectionSever;
import ruchomeObiekty.EnemyPlayer;
import ruchomeObiekty.Player;
import stany_gry.GameState;
import stany_gry.GameStateManager;

public class MultiplayerLevelLoaderServer extends GameState {

	ConnectionSever polaczenie;
	Map map;
	SpriteSheet background = new SpriteSheet();
	Player player = new Player(700,600);
	EnemyPlayer enemyPlayer = new EnemyPlayer(800,700);
	int przebiegi = 0;
	
	public MultiplayerLevelLoaderServer(GameStateManager gsm, ConnectionSever polaczenie) {
		super(gsm);
		this.polaczenie = polaczenie;
		przebiegi = 0;
	}

	@Override
	public void init() {
		player.init();
		enemyPlayer.init();
		background.setSpriteSheet(LoadImageFrom.loadImageFrom(Stickfights.class,"training_map.png"));
		File plik = new File("mapa.txt");
		map = new Map(plik);
		map.init();
		przebiegi = 0;
	}

	@Override
	public void tick(double deltaTime) {
		String[] data = {"0","0","0","0","0"};
		String enemyKeys = "00000";
		przebiegi ++;
		

		map.tick(deltaTime);
		player.tick(deltaTime);
		try {
			data = player.getPresserdKeys();
			if(przebiegi > 150) data[4] = "1";
			else data[4] = "0";
			polaczenie.sendData(data);
			
			enemyKeys = polaczenie.getData();
			data = enemyKeys.split("");
			enemyPlayer.setKeys(data);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		enemyPlayer.tick(deltaTime);
		System.out.println("\n");
	}

	@Override
	public void render(Graphics2D g) {
		//g.setFont(new Font("Ariel", Font.BOLD, 23));
		//g.drawString("Tu bêdzie gra", 500, 200);
		System.out.println("Odswiezenie");
		
		g.drawImage(background.getTile(0, 0, 999, 699),0,0,Stickfights.width, Stickfights.height, null);
		
		map.render(g);
		player.render(g);
		enemyPlayer.render(g);

	}

}
