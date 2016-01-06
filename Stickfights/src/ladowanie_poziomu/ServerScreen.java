package ladowanie_poziomu;

import java.awt.Font;
import java.awt.Graphics2D;

import stany_gry.GameState;
import stany_gry.GameStateManager;

public class ServerScreen extends GameState {
	private String wait = "";
	int delay=0;

	public ServerScreen(GameStateManager gsm) {
		super(gsm);
	}

	@Override
	public void init() {

	}

	@Override
	public void tick(double deltaTime) {
		if(delay >= 40){
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

	}

	@Override
	public void render(Graphics2D g) {
		g.setFont(new Font("Ariel", Font.BOLD, 23));
		g.drawString("Oczekiwanie na gracza", 500, 300);
		g.drawString(wait, 600, 400);
	}

}
