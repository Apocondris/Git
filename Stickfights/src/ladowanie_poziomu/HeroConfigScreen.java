package ladowanie_poziomu;

import java.awt.Font;
import java.awt.Graphics2D;

import stany_gry.GameState;
import stany_gry.GameStateManager;

public class HeroConfigScreen extends GameState {

	public HeroConfigScreen(GameStateManager gsm) {
		super(gsm);
	}

	@Override
	public void init() {

	}

	@Override
	public void tick(double deltaTime) {

	}

	@Override
	public void render(Graphics2D g) {
		g.setFont(new Font("Ariel", Font.BOLD, 27));
		g.drawString("Przepraszamy. Okno nie zosta³o jeszcze ukoñczone.", 300, 300);
	}

}
