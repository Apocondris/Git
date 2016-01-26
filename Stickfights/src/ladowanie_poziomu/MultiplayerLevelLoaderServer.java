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

	static ConnectionSever polaczenie;
	Map map;
	SpriteSheet background = new SpriteSheet();
	Player player;
	EnemyPlayer enemyPlayer;
	int przebiegi = 0;
	
	public MultiplayerLevelLoaderServer(GameStateManager gsm, ConnectionSever polaczenie) {
		super(gsm);
		this.polaczenie = polaczenie;
		przebiegi = 0;
	}

	@Override
	public void init() {
		player = new Player(200,650);
		enemyPlayer = new EnemyPlayer(800,650);
		
		player.init(enemyPlayer);
		enemyPlayer.init(player);
		background.setSpriteSheet(LoadImageFrom.loadImageFrom(Stickfights.class,"tloGry.png"));
		File plik = new File("mapa.txt");
		map = new Map(plik);
		map.init();
		przebiegi = 0;
	}

	@Override
	public void tick(double deltaTime) {
		String[] data = {"0","0","0","0","0","0","0","0"};
		String enemyKeys = "00000000";
		przebiegi ++;
		
		map.tick(deltaTime);
		player.tick(deltaTime);
		try {
			data = player.getPressedKeys();
			if(przebiegi > 50) data[7] = "1";
			else data[7] = "0";
			polaczenie.sendData(data);
			
			if (data[7].equals("1")){
				
				//synchronizacja();
			}
			
			enemyKeys = polaczenie.getData();
			if(enemyKeys.equals("exit")){
				gsm.states.pop();
				gsm.states.push(new MenuState(gsm));
			}
			else {
				data = enemyKeys.split("");
				enemyPlayer.setKeys(data);
			}
			//System.out.println("koniec ticku server");
		} catch (IOException e) {
			e.printStackTrace();
		}
		enemyPlayer.tick(deltaTime);
	}

	private void synchronizacja() throws IOException {
		System.out.println("synchronizacja server");
		
		String temp = Float.toString(player.getPosX());
		polaczenie.sendData(temp);
		System.out.print(temp);
		System.out.println(" - wyslano server");
		
		temp = polaczenie.getData();
		enemyPlayer.setPosX(temp);
		System.out.print(temp);
		System.out.println(" - odebrano server");
		
		temp = Float.toString(player.getPosY());
		polaczenie.sendData(temp);
		System.out.print(temp);
		System.out.println(" - wyslano server");
		
		temp = polaczenie.getData();
		enemyPlayer.setPosY(temp);
		System.out.print(temp);
		System.out.println(" - odebrano server");
		przebiegi = 0;
	}

	@Override
	public void render(Graphics2D g) {
		//g.setFont(new Font("Ariel", Font.BOLD, 23));
		//g.drawString("Tu bêdzie gra", 500, 200);
		
		g.drawImage(background.getTile(0, 0, 1399, 799),0,0,Stickfights.width, Stickfights.height, null);
		
		map.render(g);
		player.render(g);
		enemyPlayer.render(g);

	}

}
