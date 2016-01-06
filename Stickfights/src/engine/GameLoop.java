package engine;
import java.awt.Component;

import glowne.Assets;
import stany_gry.GameStateManager;

public class GameLoop extends IDGameLoop {
	
	GameStateManager gsm;
	public static Assets assets = new Assets();
	private OknoGry okno;

	public GameLoop(int width, int height, OknoGry okno) {
		super(width, height);
		this.okno=okno;
	}
	
	@Override
	public void init() {
		assets.init();
		gsm = new GameStateManager(okno);
		gsm.init();
		super.init();
	}
	
	@Override
	public void ticks(double deltaTime) {
		gsm.tick(deltaTime);
		super.ticks(deltaTime);
	}

	@Override
	public void render() {
		super.render();
		gsm.render(graphics2D);
		clear();
	}
	
	@Override
	public void clear() {
		super.clear();
	}
}
