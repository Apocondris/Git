package ladowanie_poziomu;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import engine.OknoGry;
import stany_gry.GameState;
import stany_gry.GameStateManager;

public class MenuState extends GameState implements KeyListener{

	private String[] options = {"Pojedynek", "Trening", "Postaæ", "Statystyki", "Wyjœcie"};
	private static int currentSelection = 0;
	private static boolean enter;
	private OknoGry okno;
	
	public MenuState(GameStateManager gsm, OknoGry okno) {
		super(gsm);
		this.okno=okno;
	}

	@Override
	public void init() {
	}

	@Override
	public void tick(double deltaTime) {
		if (enter){
			if (currentSelection == 0){
				//gsm.states.push(new ConectionScreen(gsm,okno));
				gsm.states.push(new SubmenuPlay(gsm));
				enter = false;
			}
			else if (currentSelection == 1){
				gsm.states.push(new TrainingLevelLoader(gsm));
				gsm.states.peek().init();
				enter = false;
			}
			else if (currentSelection == 2){
			}
			else if (currentSelection == 3){
			}
			else if (currentSelection == 4){
				System.exit(1);
			}
		}
		enter=false;
	}

	@Override
	public void render(Graphics2D g) {
		g.setBackground(new Color(255, 255, 255));
		g.setFont(new Font("Ariel", Font.BOLD, 40));
		for (int i=0; i<options.length; i++){
			if(i == currentSelection){
				g.setColor(Color.GRAY.darker());
			}
			else {
				g.setColor(Color.BLACK);
			}
			g.drawString(options[i], 1050, 400 + i*70);
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
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
	public void keyReleased(KeyEvent e) {
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	
}
