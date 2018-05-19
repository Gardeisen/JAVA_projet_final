package gardeisen.marine;
import java.util.ArrayList;
public class Player {
	
	private String name;
	private ArrayList<Coordinate> listCoordShip;
	private ArrayList<Coordinate> listHits;
	private ArrayList<Coordinate> listMissed;
	private ArrayList<Ship> listShips;
	
	
	//Constructor
	
	public Player(String name) {
		this.name=name;
		listCoordShip= new ArrayList<>();
		listHits= new ArrayList<>();
		listMissed= new ArrayList<>();
		listShips= new ArrayList<>();
	}

	// Getters
	public String getName() {
		return name;
	}
	
	
	public ArrayList<Coordinate> getlistofHits(){
		return this.listHits;
	}
	public ArrayList<Coordinate> getlistofMiss(){
		return this.listMissed;
	}
	public ArrayList<Ship> getlistShip(){
		return this.listShips;
	}
	
	public ArrayList<Coordinate> getlistCoordShip(){
		return this.listCoordShip;
	}
	//Methods 
	
	// add a coordinate touch 
	public void addCoordListHits(Coordinate c) {
		listHits.add(c);
	}
	
	// add a coordinate miss
	public void addCoordListMiss(Coordinate c) {
			listMissed.add(c);
	}
	
		// add a ship
	public void addaShip(Ship c) {
			listShips.add(c);
	}
	
	
	// for add all the coordinate of the ship to the global list
	public void addCoordinate(Ship ship) {
		//
		for (Coordinate coord : ship.getCoordList())
			{
			listCoordShip.add(coord);
			}
	}
	
	// to know if a boat is already where you want to place an other boat 
	public boolean aPieceShipisAlreadyHere(Ship ship) {
		boolean solu = false;
		for (Coordinate coord : listCoordShip) {
			 for (Coordinate co : ship.getCoordList()) {
				if (co.equals(coord)) {
					solu= true;
				}
			}
		}
			return solu;
	}	
	
	//if you can hit smthing at this coordinate (that mean if u don't already try or hit smng here
	public boolean canHit(Coordinate coord) {
		boolean solu = true;
		
		for (Coordinate c : listHits) {
			if( c.equals(coord)) {
				solu = false;
			}
		for (Coordinate co : listMissed) {
			if (co.equals(coord)) {
				solu = false;}
			}
		}
		return solu;
	}
	
	// isHit, for a coordinate if list of coordinates contains the missile (sire)
		public boolean isHit(Coordinate missile) {
			
			for(Coordinate coord : this.listCoordShip) {
				if(missile.equals(coord))
					
					return true;
			}
			
			return false;
		}

	
	public String showHitsCoord() {
		String result ="";
		for (Coordinate c : this.listHits) {
			result+="x=" + c.getX()+ "  ,   y = " + c.getY();
		}
		return result;
	}
	
	public String showMissCoord() {
		String result ="";
		for (Coordinate c : this.listMissed) {
			result+="x=" + c.getX()+ "  ,   y = " + c.getY();
		}
		return result;
	}
	
	public String showShipCoord() {
		String result ="";
		for (int i=0; i<this.listCoordShip.size();i++) {
			Coordinate c = this.listCoordShip.get(i);
			result+="x=" + c.getX()+ "  ,   y = " + c.getY();
			
		}	
		return result;
		
	}
	
	public char xORo(char x, int y) {
		char solu='-';
		for (Coordinate coo :this.listCoordShip) {
			if (x==coo.getX() && y==coo.getY()) {
				solu='o';
			}
		}
		return solu;
	}
	
	public String showMyGrille() {
		
		String result ="";
		
		result+="   ";
		for (char c='A';c<='J' ; c++) {
			result+="  "+c+"  ";
		}
		result+="\n";
		for (int i=1;i<=10;i++) {
			if (i==10) {
				result+=i+" ";
			}
			else {
				result+=i+"  "; }
			
			result+="  "+xORo('A',i)+"  ";
			result+="  "+xORo('B',i)+"  ";
			result+="  "+xORo('C',i)+"  ";
			result+="  "+xORo('D',i)+"  ";
			result+="  "+xORo('E',i)+"  ";
			result+="  "+xORo('F',i)+"  ";
			result+="  "+xORo('G',i)+"  ";
			result+="  "+xORo('H',i)+"  ";
			result+="  "+xORo('I',i)+"  ";
			result+="  "+xORo('J',i)+"  ";
			result+="\n";
			
		}
	return result;
	}
	
	public char xORoShot(char x, int y) {
		char solu='-';
		for (Coordinate coo :this.listHits) {
			if (x==coo.getX() && y==coo.getY()) {
				solu='o';
			}
		}
		for (Coordinate coo :this.listMissed) {
			if (x==coo.getX() && y==coo.getY()) {
				solu='x';
			}
		}
		return solu;
	}
	
	public String showMeMyShot() {
		
		
		String result="";
		result+="   ";
		for (char c='A';c<='J' ; c++) {
			result+="  "+c+"  ";
		}
		result+="\n";
		for (int i=1;i<=10;i++) {
			if (i==10) {
				result+=i+" ";
			}
			else {
				result+=i+"  "; }
			
			result+="  "+xORoShot('A',i)+"  ";
			result+="  "+xORoShot('B',i)+"  ";
			result+="  "+xORoShot('C',i)+"  ";
			result+="  "+xORoShot('D',i)+"  ";
			result+="  "+xORoShot('E',i)+"  ";
			result+="  "+xORoShot('F',i)+"  ";
			result+="  "+xORoShot('G',i)+"  ";
			result+="  "+xORoShot('H',i)+"  ";
			result+="  "+xORoShot('I',i)+"  ";
			result+="  "+xORoShot('J',i)+"  ";
			result+="\n";
			
			
			
		}
		return result;
	}
	
	////////////////////////////
	
	public char xORoORShot(char x, int y,Player P) {
	char solu='-';
	for (Coordinate coo :this.listCoordShip) {
		if (x==coo.getX() && y==coo.getY()) {
			solu='o';
		}
	}
	for (Coordinate coo :P.listMissed) {
		if (x==coo.getX() && y==coo.getY()) {
			solu='x';
		}
	}
	for (Coordinate coo :P.listHits) {
		if (x==coo.getX() && y==coo.getY()) {
			solu='x';
		}
	}
	return solu;
}

public String showMeMyShipButWhithTheHitsOfOtherPlayer(Player P) {
	
	
	String result="";
	result+="   ";
	for (char c='A';c<='J' ; c++) {
		result+="  "+c+"  ";
	}
	result+="\n";
	for (int i=1;i<=10;i++) {
		if (i==10) {
			result+=i+" ";
		}
		else {
			result+=i+"  "; }
		
		result+="  "+xORoORShot('A',i,P)+"  ";
		result+="  "+xORoORShot('B',i,P)+"  ";
		result+="  "+xORoORShot('C',i,P)+"  ";
		result+="  "+xORoORShot('D',i,P)+"  ";
		result+="  "+xORoORShot('E',i,P)+"  ";
		result+="  "+xORoORShot('F',i,P)+"  ";
		result+="  "+xORoORShot('G',i,P)+"  ";
		result+="  "+xORoORShot('H',i,P)+"  ";
		result+="  "+xORoORShot('I',i,P)+"  ";
		result+="  "+xORoORShot('J',i,P)+"  ";
		result+="\n";
		
		
		
	}
	return result;
}

public boolean valideName() {
	boolean result = false;
	if(this.name.matches("[a-zA-Z]")) {
		result =true;
	}
	return result;
}
}
