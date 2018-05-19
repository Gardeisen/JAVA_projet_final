package gardeisen.marine;
public class Coordinate {

	private char x;
	private int y;
	
	
	// Getters and Setters
	
	public char getX() {
		return x;
	}
	public void setX(char x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	// Constructor
	
	public Coordinate(char x, int y) {
		if ((int)x>74 || (int)x< 65) { 
			//System.out.println("coordinate not good, try other");
			}
		else 
		{
			this.x=x; 
		}
		if (y>10 || y< 1) { 
			//System.out.println("coordinate not good, try other"); 
			}
		else {
		this.y=y;}
	}
	
	
	// valid coordinate 
	public boolean validCo() {
		boolean solu = true;
		if ((int)x>74 || (int)x< 65) { solu =false; }
		if (y>10 || y< 1) {solu =false; }
		return solu;
		}
	
	//override
	public boolean equals(Coordinate co) {
		
		if (this.getX()==co.getX() && this.getY()==co.getY()) {
			
			return true;}
		
		else return false ;
	}
	
	// constructor return directly random Coordinate
	public Coordinate() {
		
		//max and min
		int lowerX = 74;
		int higherX= 65;
		int lowerY = 1;
		int higherY = 11;
		//pour x
		int xx=(int)(Math.random() * (higherX-lowerX))+lowerX;
		char xc= (char)xx;
		this.x=xc;
		//pour y
		int yy=(int)(Math.random() * (higherY-lowerY))+lowerY;
		this.y=yy;
		
		
	}
	
}
