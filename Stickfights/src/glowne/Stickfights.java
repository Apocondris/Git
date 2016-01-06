package glowne;

import javax.swing.*;

import engine.GameLoop;
import engine.OknoGry;
import ladowanie_poziomu.ClientScreen;
import ladowanie_poziomu.MenuState;
import ladowanie_poziomu.SubmenuPlay;
import ladowanie_poziomu.TrainingLevelLoader;
import ruchomeObiekty.Player;

public class Stickfights extends JFrame{
	public static OknoGry okno;
	
	public Stickfights() {
	}
	
	public static int width = 1400;
	public static int height = 800;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		OknoGry okno = new OknoGry("Stickfight", width, height);
		okno.addKeyListener(new MenuState(null,okno));
		okno.addKeyListener(new SubmenuPlay(null));
		okno.addKeyListener(new ClientScreen(null));
		okno.addKeyListener(new Player());
		okno.addKeyListener(new TrainingLevelLoader(null));
		okno.getContentPane().add(new GameLoop(width,height,okno));
		
	}

}
