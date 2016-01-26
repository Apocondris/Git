package ladowanie_poziomu;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import stany_gry.GameState;
import stany_gry.GameStateManager;

public class SubmenuPlay extends GameState implements KeyListener{
	
	private String[] options = {"Do³¹cz do gracza", "Stwórz server", "Wstecz"};
	private static int currentSelection = 0;
	private static boolean enter;

	public SubmenuPlay(GameStateManager gsm) {
		super(gsm);
		enter = false;
	}

	@Override
	public void init() {
	}

	@Override
	public void tick(double deltaTime) {
		if (enter){
			if (currentSelection == 0){
				gsm.states.pop();
				gsm.states.push(new ClientScreen(gsm));
				gsm.states.peek().init();
				enter = false;
			}
			else if (currentSelection == 1){
				gsm.states.pop();
				gsm.states.push(new ServerScreen(gsm));
				gsm.states.peek().init();
				enter = false;
			}
			else if (currentSelection == 2){
				gsm.states.pop();
				gsm.states.push(new MenuState(gsm));
				enter = false;
			}
		}
		enter = false;
	}

	@Override
	public void render(Graphics2D g) {
		g.setBackground(new Color(255, 255, 255));
		g.setFont(new Font("Ariel", Font.BOLD, 40));
		for (int i=0; i<options.length; i++){
			if(i == currentSelection){
				g.setColor(new Color(255, 0, 0));
			}
			else {
				g.setColor(Color.BLACK);
			}
			g.drawString(options[i], 1050, 400 + i*70);
		}
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		int key = arg0.getKeyCode();
		
		if(key == KeyEvent.VK_DOWN){
			currentSelection++;
			if (currentSelection >= options.length){
				currentSelection = 0;
			}
		}
		if(key == KeyEvent.VK_UP){
			currentSelection--;
			if (currentSelection < 0){
				currentSelection = options.length - 1;
			}
		}
		if(key == KeyEvent.VK_ENTER){
			enter = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		
	}

}
