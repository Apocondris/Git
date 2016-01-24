package generator;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import engine.Vector2F;

public class Block extends Rectangle{
	
	Vector2F pos = new Vector2F();
	int BlockSizeX;
	int BlockSizeY;
	private BufferedImage block;
	
	public Block(Vector2F pos, int BlockSizeX, int BlockSizeY) {
		this.pos = pos;
		this.BlockSizeX = BlockSizeX;
		this.BlockSizeY = BlockSizeY;
		setBounds((int)pos.xPos, (int)pos.yPos, BlockSizeX, BlockSizeY);
	}
	
	public void tick(double deltaTime){
	}

	public void render (Graphics2D g){
		//g.setColor(new Color(88, 88, 88));
		g.setColor(new Color(10, 10, 10, 0));
		g.fillRect((int)pos.xPos, (int)pos.yPos, BlockSizeX, BlockSizeY);
	}
	
	public enum BlockType{
		
	}
}
