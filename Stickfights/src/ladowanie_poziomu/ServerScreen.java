package ladowanie_poziomu;

import java.awt.Font;
import java.awt.Graphics2D;

import stany_gry.GameState;
import stany_gry.GameStateManager;

import polaczenie.ConnectionSever;

public class ServerScreen extends GameState {
	private String wait = "";
	int delay=0;
	ConnectionSever polaczenie;

	public ServerScreen(GameStateManager gsm) {
		super(gsm);
	}

	@Override
	public void init() {
		polaczenie = new ConnectionSever();
		
		Thread th = new Thread(polaczenie);
		th.start();
	}

	@Override
	public void tick(double deltaTime) {
		if(delay >= 30){
			if(wait.length()<15){
				wait+=" . ";
			}
			else {
				wait = "";
			}
			delay=0;
		}
		else {
			delay++;
		}
		if (polaczenie.connected){
			gsm.states.pop();
			gsm.states.push(new MultiplayerLevelLoaderServer(gsm,polaczenie));
		}
	}

	@Override
	public void render(Graphics2D g) {
		g.setFont(new Font("Ariel", Font.BOLD, 23));
		g.drawString("Oczekiwanie na gracza", 500, 300);
		g.drawString(wait, 600, 400);
	}

}
