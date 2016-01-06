package glowne;

import java.awt.Point;

import generator.Block;
import generator.TileMenager;

public class Check {

	public static boolean CollisionPlayerBlock(Point p1, Point p2, Point p3){
		for (Block block : TileMenager.blocks){
			if(block.contains(p1) || block.contains(p2) || block.contains(p3)){
				return true;
			}
		}
		return false;
	}
	
	public static boolean CollisionPlayerHit(Point p1, Point p2){
		for (Block block : TileMenager.blocks){
			if(block.contains(p1) || block.contains(p2)){
				return true;
			}
		}
		return false;
	}
}
