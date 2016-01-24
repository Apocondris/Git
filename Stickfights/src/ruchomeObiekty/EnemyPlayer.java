package ruchomeObiekty;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.text.html.HTMLDocument.HTMLReader.BlockAction;

import engine.Vector2F;
import glowne.Animator;
import glowne.Assets;
import glowne.Check;
import glowne.Stickfights;

public class EnemyPlayer {
	
	Vector2F pos = new Vector2F();
	private int width = 30; 
	private int height = 70;
	private static boolean up,down = true,left,right, useSkill=false;
	private static boolean lookLeft, lookRight, useSkillJ, useSkillK, useSkillL;
	private float speed = 2.9F;
	private float zdrowie = 2.8F;
	private float wytrzymalosc = 2.8F;
	
	private int animationState = 0;
	
	private ArrayList<BufferedImage> listStay;
	Animator ani_Stay;
	private ArrayList<BufferedImage> listJumpRight;
	Animator ani_JumpRight;
	private ArrayList<BufferedImage> listJumpLeft;
	Animator ani_JumpLeft;
	private ArrayList<BufferedImage> listRight;
	Animator ani_Right;
	private ArrayList<BufferedImage> listLeft;
	Animator ani_Left;

	private static int flaga=0;
	private static int flaga2=0;
	
	private Skill skillJ;
	private Skill skillK;
	private Skill skillL;
	
	public EnemyPlayer() {
		pos = new Vector2F(Stickfights.width/3,Stickfights.height-200);
	}
	
	public EnemyPlayer (int posX, int posY)
	{
		pos = new Vector2F(posX, posY);
	}

	public void init() {
		ladujTekstury("red");
		skillJ.init();
		
	}

	private void ladujTekstury(String kolor) {
		
		listStay = new ArrayList<BufferedImage>();
		listJumpRight = new ArrayList<BufferedImage>();
		listJumpLeft = new ArrayList<BufferedImage>();
		listRight = new ArrayList<BufferedImage>();
		listLeft = new ArrayList<BufferedImage>();
		if (kolor.equals("black")){
			listStay.add(Assets.blackPlayerRun.getTile(0, 180, 30, 90));
			
			listRight.add(Assets.blackPlayerRun.getTile(0, 0, 30, 90));
			listRight.add(Assets.blackPlayerRun.getTile(30, 0, 30, 90));
			listRight.add(Assets.blackPlayerRun.getTile(60, 0, 30, 90));
			listRight.add(Assets.blackPlayerRun.getTile(90, 0, 30, 90));
			listRight.add(Assets.blackPlayerRun.getTile(120, 0, 30, 90));
			
			listLeft.add(Assets.blackPlayerRun.getTile(0, 90, 30, 90));
			listLeft.add(Assets.blackPlayerRun.getTile(30, 90, 30, 90));
			listLeft.add(Assets.blackPlayerRun.getTile(60, 90, 30, 90));
			listLeft.add(Assets.blackPlayerRun.getTile(90, 90, 30, 90));
			listLeft.add(Assets.blackPlayerRun.getTile(120, 90, 30, 90));
			
			listJumpRight.add(Assets.blackPlayerJump.getTile(30, 0, 30, 90));

			listJumpLeft.add(Assets.blackPlayerJump.getTile(30, 90, 30, 90));
			
			skillJ = new Skill("Cios piêœci¹", 0, 10, 0, 0, Assets.blackPlayerHit);
		}
		if (kolor.equals("blue")){
			listStay.add(Assets.bluePlayerRun.getTile(0, 180, 30, 90));
			
			listRight.add(Assets.bluePlayerRun.getTile(0, 0, 30, 90));
			listRight.add(Assets.bluePlayerRun.getTile(30, 0, 30, 90));
			listRight.add(Assets.bluePlayerRun.getTile(60, 0, 30, 90));
			listRight.add(Assets.bluePlayerRun.getTile(90, 0, 30, 90));
			listRight.add(Assets.bluePlayerRun.getTile(120, 0, 30, 90));
			
			listLeft.add(Assets.bluePlayerRun.getTile(0, 90, 30, 90));
			listLeft.add(Assets.bluePlayerRun.getTile(30, 90, 30, 90));
			listLeft.add(Assets.bluePlayerRun.getTile(60, 90, 30, 90));
			listLeft.add(Assets.bluePlayerRun.getTile(90, 90, 30, 90));
			listLeft.add(Assets.bluePlayerRun.getTile(120, 90, 30, 90));
			
			listJumpRight.add(Assets.bluePlayerJump.getTile(30, 0, 30, 90));

			listJumpLeft.add(Assets.bluePlayerJump.getTile(30, 90, 30, 90));
			
			skillJ = new Skill("Cios piêœci¹", 0, 10, 0, 0, Assets.bluePlayerHit);
			
		}
		if (kolor.equals("red")){
			listStay.add(Assets.redPlayerRun.getTile(0, 180, 30, 90));
			
			listRight.add(Assets.redPlayerRun.getTile(0, 0, 30, 90));
			listRight.add(Assets.redPlayerRun.getTile(30, 0, 30, 90));
			listRight.add(Assets.redPlayerRun.getTile(60, 0, 30, 90));
			listRight.add(Assets.redPlayerRun.getTile(90, 0, 30, 90));
			listRight.add(Assets.redPlayerRun.getTile(120, 0, 30, 90));
			
			listLeft.add(Assets.redPlayerRun.getTile(0, 90, 30, 90));
			listLeft.add(Assets.redPlayerRun.getTile(30, 90, 30, 90));
			listLeft.add(Assets.redPlayerRun.getTile(60, 90, 30, 90));
			listLeft.add(Assets.redPlayerRun.getTile(90, 90, 30, 90));
			listLeft.add(Assets.redPlayerRun.getTile(120, 90, 30, 90));
			
			listJumpRight.add(Assets.redPlayerJump.getTile(30, 0, 30, 90));

			listJumpLeft.add(Assets.redPlayerJump.getTile(30, 90, 30, 90));
			
			skillJ = new Skill("Cios piêœci¹", 0, 10, 0, 0, Assets.redPlayerHit);
		}
		
		ani_Stay = new Animator(listStay);
		ani_Stay.setSpeed(100);
		ani_Stay.play();
		
		ani_JumpRight = new Animator(listJumpRight);
		ani_JumpRight.setSpeed(100);
		ani_JumpRight.play();
		
		ani_JumpLeft = new Animator(listJumpLeft);
		ani_JumpLeft.setSpeed(100);
		ani_JumpLeft.play();
		
		ani_Right = new Animator(listRight);
		ani_Right.setSpeed(100);
		ani_Right.play();
		
		ani_Left = new Animator(listLeft);
		ani_Left.setSpeed(100);
		ani_Left.play();
		
	}

	public void tick(double deltaTime) {
		float moveAmount = (float)(speed);
		float jumpAmount = (float) (2.*speed);
		
		if(up){
			if(flaga<33){
				if (!Check.CollisionPlayerBlock(
					new Point((int) (pos.xPos),
						(int) (pos.yPos - jumpAmount) ),
					new Point((int) (pos.xPos + width),
						(int) (pos.yPos - jumpAmount) ),
					new Point((int) (pos.xPos + width/2),
							(int) (pos.yPos - jumpAmount) )
					) ){
							
					pos.yPos=pos.yPos-(jumpAmount);
					flaga++;
				}	
				else {
					flaga=flaga+50;
				}	
			}
			else {
				down=true;										
			}
		}
		if(down){
			if (!Check.CollisionPlayerBlock(
					new Point((int) (pos.xPos),
						(int) (pos.yPos + height + jumpAmount)),
					new Point((int) (pos.xPos + width),
						(int) (pos.yPos + height + jumpAmount) ),
					new Point((int) (pos.xPos + width/2),
							(int) (pos.yPos + height + jumpAmount) )
					) ){

				pos.yPos=pos.yPos+jumpAmount;
				flaga2=1;
			}
			else {
				flaga=0;
				up=false;
				flaga2=0;
			}
		}
		if(left && !useSkill){
			if (!Check.CollisionPlayerBlock(
					new Point((int) (pos.xPos - moveAmount),
						(int) pos.yPos),
					new Point((int) (pos.xPos - moveAmount),
						(int) (pos.yPos + height) ),
					new Point((int) (pos.xPos - moveAmount),
							(int) (pos.yPos + height/2) )
					) ){

				pos.xPos=pos.xPos-moveAmount;
			}
			animationState = 4;
		}
		if(right && !useSkill){
			if (!Check.CollisionPlayerBlock(
					new Point((int) (pos.xPos + width + moveAmount),
						(int) pos.yPos),
					new Point((int) (pos.xPos + width + moveAmount),
						(int) (pos.yPos + height) ),
					new Point((int) (pos.xPos + width + moveAmount),
							(int) (pos.yPos + height/2) )
					) ){

				pos.xPos=pos.xPos+moveAmount;
			}
			animationState =3;
			
		}
		
		if(!up && !left && !right && down && !useSkill){
			animationState = 0;
		}
		if(up && !left && right && !useSkill){
			animationState = 1;
		}
		if(up && left && !right && !useSkill){
			animationState = 2;
		}
		if(up && lookRight && !useSkill){
			animationState = 1;
		}
		if(up && lookLeft && !useSkill){
			animationState = 2;
		}
		if(useSkillJ && lookRight){
			animationState = 11;
		}
		if(useSkillJ && lookLeft){
			animationState = 12;
		}
	}

	public void render(Graphics2D g) {
		//g.setColor(new Color(0, 0, 0));
		//g.fillOval((int)pos.xPos, (int)pos.yPos, width, height);
		
		//stay
		if(animationState == 0){
			this.width = 25;
			g.drawImage(ani_Stay.sprite, (int)pos.xPos, (int)pos.yPos, width, height, null);
			if(!right && !left && !up){
				ani_Stay.update(System.currentTimeMillis());
			}
		}
		//skok w prawo
		if(animationState == 1){
			this.width = 25;
			g.drawImage(ani_JumpRight.sprite, (int)pos.xPos, (int)pos.yPos, width, height, null);
			if(right && up || up && lookRight){
				ani_JumpRight.update(System.currentTimeMillis());
			}
					
		}
		//skok w lewo
		if(animationState == 2){
			this.width = 25;
			g.drawImage(ani_JumpLeft.sprite, (int)pos.xPos, (int)pos.yPos, width, height, null);
			if(left && up || up && lookLeft){
				ani_JumpLeft.update(System.currentTimeMillis());
			}
		}
		//prawo
		if(animationState == 3){
			this.width = 25;
			g.drawImage(ani_Right.sprite, (int)pos.xPos, (int)pos.yPos, width, height, null);
			if(right){
				ani_Right.update(System.currentTimeMillis());
			}
		}
		//lewo
		if(animationState == 4){
			this.width = 25;
			g.drawImage(ani_Left.sprite, (int)pos.xPos, (int)pos.yPos, width, height, null);
			if(left){
				ani_Left.update(System.currentTimeMillis());
			}
		}
		//cios J w prawo
		if(animationState == 11){
			this.width = 40;
			g.drawImage(skillJ.ani_SkillRight.sprite, (int)pos.xPos, (int)pos.yPos, width, height, null);
			if(lookRight && useSkillJ){
				if(!skillJ.ani_SkillRight.updateSkill(System.currentTimeMillis())) {
					useSkill = false;
					useSkillJ = false;
					skillJ.ani_SkillRight.reset();
				}
			}
		}
		//cios J w lewo
		if(animationState == 12){
			this.width = 40;
			pos.xPos -= 15.;
			g.drawImage(skillJ.ani_SkillLeft.sprite, (int)pos.xPos, (int)pos.yPos, width, height, null);
			if(lookLeft && useSkillJ){
				if(!skillJ.ani_SkillLeft.updateSkill(System.currentTimeMillis())) {
					useSkill = false;
					useSkillJ = false;
					skillJ.ani_SkillLeft.reset();
				}
			}
			pos.xPos += 15.;
		}
	}

	public void setKeys(String[] enemyKeys) {
		if(enemyKeys[0].equals("1")) up = true; else up = false;
		if(enemyKeys[1].equals("1")) down = true; else down = false;
		if(enemyKeys[2].equals("1")) left = true; else left = false;
		if(enemyKeys[3].equals("1")) right = true; else right = false;
		if(enemyKeys[4].equals("1")) useSkillJ = true; else useSkillJ = false;
		if(enemyKeys[5].equals("1")) useSkillK = true; else useSkillK = false;
		if(enemyKeys[6].equals("1")) useSkillL = true; else useSkillL = false;
	}
	
	public Object getPos() {
		return pos;
	}

	public void setPos(Vector2F pozycja) {
		pos = pozycja;
	}

}
