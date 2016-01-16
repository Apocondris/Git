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
	File plik;
	
	public Map(File plik) {
		this.plik = plik;
	}
	
	public void init(){
		
		
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
						Stickfights.width,30));
		
		tiles.blocks.add(
				new Block(
						new Vector2F(-20,0),
						30,Stickfights.height));
		
		tiles.blocks.add(
				new Block(
						new Vector2F(Stickfights.width-15,0),
						30,Stickfights.height));
		

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
	}
	
	public void render(Graphics2D g){
		tiles.render(g);
	}
}
