package ladowanie_poziomu;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
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

	static ConnectionClient polaczenie;
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
		player = new Player(800,650);
		enemyPlayer = new EnemyPlayer(200,650);
		
		player.init(enemyPlayer);
		enemyPlayer.init(player);
		background.setSpriteSheet(LoadImageFrom.loadImageFrom(Stickfights.class,"tloGry.png"));
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
			if(enemyKeys.equals("exit")){
				gsm.states.pop();
				gsm.states.push(new MenuState(gsm));
			}
			else {
				data = enemyKeys.split("");
				enemyPlayer.setKeys(data);
				if(data[7].equals("1")){
					//synchronizacja();
				}
				
				data = player.getPressedKeys();
				polaczenie.sendData(data);
				//System.out.println("koniec ticku klient");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		enemyPlayer.tick(deltaTime);
	}

	private void synchronizacja() throws IOException {
		System.out.println("synchronizacja klient");
		
		String temp = polaczenie.getData();
		enemyPlayer.setPosX(temp);
		System.out.print(temp);
		System.out.println(" - odebrano klient");
		
		temp = Float.toString(player.getPosX());
		polaczenie.sendData(temp);
		System.out.print(temp);
		System.out.println(" - wyslano klient");
		
		temp = polaczenie.getData();
		enemyPlayer.setPosY(temp);
		System.out.print(temp);
		System.out.println(" - odebrano klient");
		
		temp = Float.toString(player.getPosY());
		polaczenie.sendData(temp);
		System.out.print(temp);
		System.out.println(" - wyslano klient");
	}


	@Override
	public void render(Graphics2D g) {
		
		g.drawImage(background.getTile(0, 0, 1399, 799),0,0,Stickfights.width, Stickfights.height, null);
		map.render(g);
		player.render(g);
		enemyPlayer.render(g);

	}

}
