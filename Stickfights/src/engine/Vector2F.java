package engine;

public class Vector2F {
	
	public float xPos;
	public float yPos;
	
	public Vector2F() {
		this.xPos = 30.0f;
		this.yPos = 400.0f;
	}

	public Vector2F(float xpos, float ypos) {
		this.xPos = xpos;
		this.yPos = ypos;
	}
	
	public static Vector2F zero(){
		return new Vector2F(30,400);
	}
	
	public void normalize(){
		double length = Math.sqrt(xPos * xPos + yPos * yPos);
		
		if(length != 0.0){
			float s = 1.0f / (float) length;
			xPos = xPos * s;
			yPos = yPos * s;
		}
	}
	
	public Vector2F getScreenLocation(){
		return new Vector2F(xPos,yPos);
	}
		
	public boolean equals(Vector2F vec){
		return (this.xPos == vec.xPos && this.yPos == vec.yPos);
	}
	
	public Vector2F copy(Vector2F vec){
		xPos = vec.xPos;
		yPos = vec.yPos;
		return new Vector2F(xPos,yPos);
	}
	
	public Vector2F add(Vector2F vec){
		xPos = vec.xPos;
		yPos = vec.yPos;
		return new Vector2F(xPos,yPos);
	}
	
	public static double getDistanceOnScreen(Vector2F vec1, Vector2F vec2){
		float v1 = vec1.xPos - vec2.xPos;
		float v2 = vec1.yPos - vec2.yPos;
		return Math.sqrt(v1*v1 + v2*v2);
	}
	
}
