package stany_gry;

import java.awt.Graphics2D;
import java.util.Stack;

import engine.OknoGry;
import ladowanie_poziomu.MenuState;
import ladowanie_poziomu.TrainingLevelLoader;

public class GameStateManager {

	public static Stack<GameState> states;
	
	public GameStateManager(OknoGry okno) {
		states = new Stack<GameState>();
		//states.push(new TrainingLevelLoader(this));
		states.push(new MenuState(this,okno));
	}
	
	public void tick(double deltaTime){
		if(states.isEmpty()){
			System.exit(1);
		}
		states.peek().tick(deltaTime);
	}
	

	public void render(Graphics2D g){
		states.peek().render(g);
	}

	public void init() {
		states.peek().init();
	}
	
	
}
