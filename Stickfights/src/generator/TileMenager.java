package generator;

import java.awt.Graphics2D;
import java.util.ArrayList;

public class TileMenager {
	
	public static ArrayList<Block> blocks = new ArrayList<Block>();

	public TileMenager() {

	}
	
	public void init(){
		
	}
	
	public void tick(double deltaTime){
		for(Block block : blocks){
			block.tick(deltaTime);
		}
	}
	
	public void render(Graphics2D g){
		for(Block block : blocks){
			block.render(g);
		}
	}
}
