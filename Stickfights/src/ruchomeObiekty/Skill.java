package ruchomeObiekty;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import engine.LoadImageFrom;
import engine.SpriteSheet;
import glowne.Animator;
import glowne.Stickfights;

public class Skill {
	String nazwa;
	int koszt;
	float obrazenia;
	float zasieg;
	float leczenie;
	private ArrayList<BufferedImage> listSkillRight;
	Animator ani_SkillRight;
	private ArrayList<BufferedImage> listSkillLeft;
	Animator ani_SkillLeft;
	SpriteSheet grafika;
	
	public Skill(String nazwa, int koszt, float obrazenia, float zasieg, float leczenie, SpriteSheet grafika) {
		this.nazwa = nazwa;
		this.koszt = koszt;
		this.obrazenia = obrazenia;
		this.zasieg = zasieg;
		this.leczenie = leczenie;
		this.grafika = grafika;
	}

	public void init() {
		
		listSkillRight= new ArrayList<BufferedImage>();
		listSkillLeft= new ArrayList<BufferedImage>();
		
		listSkillRight.add(grafika.getTile(0, 0, 40, 90));
		listSkillRight.add(grafika.getTile(40, 0, 40, 90));
		//listSkillRight.add(grafika.getTile(80, 0, 40, 90));
		listSkillRight.add(grafika.getTile(120, 0, 40, 90));
		listSkillRight.add(grafika.getTile(160, 0, 40, 90));
		//listSkillRight.add(grafika.getTile(200, 0, 40, 90));
		listSkillRight.add(grafika.getTile(240, 0, 40, 90));
		listSkillRight.add(grafika.getTile(280, 0, 40, 90));
		listSkillRight.add(grafika.getTile(320, 0, 40, 90));
		//listSkillRight.add(grafika.getTile(360, 0, 40, 90));
		
		listSkillLeft.add(grafika.getTile(0, 90, 40, 90));
		listSkillLeft.add(grafika.getTile(40, 90, 40, 90));
		//listSkillLeft.add(grafika.getTile(80, 90, 40, 90));
		listSkillLeft.add(grafika.getTile(120, 90, 40, 90));
		listSkillLeft.add(grafika.getTile(160, 90, 40, 90));
		//listSkillLeft.add(grafika.getTile(200, 90, 40, 90));
		listSkillLeft.add(grafika.getTile(240, 90, 40, 90));
		listSkillLeft.add(grafika.getTile(280, 90, 40, 90));
		listSkillLeft.add(grafika.getTile(320, 90, 40, 90));
		//listSkillLeft.add(grafika.getTile(360, 90, 40, 90));
		
		ani_SkillRight = new Animator(listSkillRight);
		ani_SkillRight.setSpeed(50);
		ani_SkillRight.play();
		
		ani_SkillLeft = new Animator(listSkillLeft);
		ani_SkillLeft.setSpeed(50);
		ani_SkillLeft.play();
	}
	
	
}
