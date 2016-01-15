package ladowanie_poziomu;

import java.awt.Font;
import java.awt.Graphics2D;
import java.io.IOException;

import polaczenie.ConnectionSever;
import stany_gry.GameState;
import stany_gry.GameStateManager;

public class MultiplayerLevelLoaderServer extends GameState {

	ConnectionSever polaczenie;
	String a ="";
	
	public MultiplayerLevelLoaderServer(GameStateManager gsm, ConnectionSever polaczenie) {
		super(gsm);
		this.polaczenie = polaczenie;
	}

	@Override
	public void init() {

	}

	@Override
	public void tick(double deltaTime) {
		
		try {
			polaczenie.sendData("b");
			
			a=a+polaczenie.getData();

			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void render(Graphics2D g) {

		g.setFont(new Font("Ariel", Font.BOLD, 23));
		g.drawString("Tu bêdzie gra", 500, 200);
		

		g.setFont(new Font("Ariel", Font.BOLD, 23));
		g.drawString("Otrzymane wiadomoœci:", 200, 300);
		g.setFont(new Font("Ariel", Font.BOLD, 13));
		g.drawString(a, 100, 400);

	}

}
