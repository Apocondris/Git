package generator;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import engine.LoadImageFrom;
import engine.SpriteSheet;
import engine.Vector2F;
import glowne.Stickfights;
import ruchomeObiekty.Player;

public class Map {
	
	TileMenager tiles = new TileMenager();
	Player player = new Player();
	File plik;
	
	public Map(File plik) {
		this.plik = plik;
	}
	
	public void init(){
		player.init();
		
		
		Scanner odczyt = null;
		try {
			odczyt = new Scanner(plik);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		int przebiegi;
		
		tiles.blocks.add(
				new Block(
						new Vector2F(0,Stickfights.height-35),
						Stickfights.width,10));
		
		tiles.blocks.add(
				new Block(
						new Vector2F(0,0),
						3,Stickfights.height));
		
		tiles.blocks.add(
				new Block(
						new Vector2F(Stickfights.width-10,0),
						Stickfights.width,Stickfights.height));
		

		int posX, posY, sizeX, sizeY;
		przebiegi = odczyt.nextInt();
		for(int i=0; i<przebiegi;i++){
			posX = odczyt.nextInt();
			posY = odczyt.nextInt();
			sizeX = odczyt.nextInt();
			sizeY = odczyt.nextInt();
			//System.out.println(posX+ " "+ posY+ " "+ sizeX+ " "+ sizeY);
			tiles.blocks.add(
					new Block(
							new Vector2F(posX,posY),
							sizeX,sizeY));
		}
		
	}

	public void tick(double deltaTime){
		tiles.tick(deltaTime);
		player.tick(deltaTime);
	}
	
	public void render(Graphics2D g){
		tiles.render(g);
		player.render(g);
	}
}