package ladowanie_poziomu;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

import engine.OknoGry;
import glowne.Stickfights;
import polaczenie.ConnectionClient;
import polaczenie.ConnectionSever;
import stany_gry.GameState;
import stany_gry.GameStateManager;

public class ClientScreen extends GameState implements KeyListener{
	private static boolean enter=false;
	private static String ip="localhost";
	ConnectionClient polaczenie;

	public ClientScreen(GameStateManager gsm) {
		super(gsm);
		enter=false;
	}

	@Override
	public void init() {

	}

	@Override
	public void tick(double deltaTime) {
		if (enter){
			polaczenie = new ConnectionClient(ip);
			if(polaczenie.connected){
				gsm.states.pop();
				gsm.states.push(new MultiplayerLevelLoaderClient(gsm,polaczenie));
				gsm.states.peek().init();
			}
		}
		enter = false;
	}

	@Override
	public void render(Graphics2D g) {
		g.setFont(new Font("Ariel", Font.BOLD, 23));
		g.drawString("Podaj ip gracza z którym chcesz siê po³¹czyæ:", 200, 300);
		g.drawString(ip, 750, 300);
		g.drawString("i wciœnij enter", 200, 370);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_NUMPAD0){
			ip=ip+"0";
		}
		if(key == KeyEvent.VK_NUMPAD1){
			ip=ip+"1";
		}
		if(key == KeyEvent.VK_NUMPAD2){
			ip=ip+"2";
		}
		if(key == KeyEvent.VK_NUMPAD3){
			ip=ip+"3";
		}
		if(key == KeyEvent.VK_NUMPAD4){
			ip=ip+"4";
		}
		if(key == KeyEvent.VK_NUMPAD5){
			ip=ip+"5";
		}
		if(key == KeyEvent.VK_NUMPAD6){
			ip=ip+"6";
		}
		if(key == KeyEvent.VK_NUMPAD7){
			ip=ip+"7";
		}
		if(key == KeyEvent.VK_NUMPAD8){
			ip=ip+"8";
		}
		if(key == KeyEvent.VK_NUMPAD9){
			ip=ip+"9";
		}
		if(key == KeyEvent.VK_PERIOD){
			ip=ip+".";
		}
		if(key == KeyEvent.VK_BACK_SPACE){
			ip=ip.substring(0,ip.length()-1);
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
