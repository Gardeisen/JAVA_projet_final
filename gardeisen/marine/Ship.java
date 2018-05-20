package gardeisen.marine;

import java.util.ArrayList;

public class Ship {

	// attributes
	private int size;
	private ArrayList<Coordinate> coordlist;
	private int nbtouch;
	
	// Constructor
	Ship(int size, Coordinate start, Coordinate end)

		{
			this.size = size;
			this.nbtouch=0;
			coordlist = new ArrayList<>(); // list of coordinates of ship
			// place boat
				//horizontal
				if (start.getY() == end.getY() && start.getX() != end.getX()) {
					for (char i= start.getX(); i<=end.getX(); i++) {
						Coordinate co = new Coordinate(i,start.getY());
						coordlist.add(co);
					}
				}
				// vertical
				else {
					for (int i = start.getY(); i<=end.getY();i++) {
						Coordinate co = new Coordinate(start.getX(),i);
						coordlist.add(co);
					}
				}
			}

	
	// Getters and Setters
	
	public int getNbtouch() {
		return nbtouch;
		
	}
	
	public void setNbtouch(int nb) {
		nbtouch=nb;
	}
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	public  ArrayList<Coordinate> getCoordList() {
		
		return this.coordlist;
	}
	
	// Methods

	//shows list coordinates's ship
	public String showList() {
		String result ="";
		for (int i = 0; i < coordlist.size(); i++) {
			Coordinate c = coordlist.get(i);
			result+="x=" + c.getX() + "  ,   y = " + c.getY();

		}
		return result;

	}
	
	//give first Coordinate of the ship 
	public Coordinate firstCo() {
		return coordlist.get(0); 
	}
	
	//give last Coordinate of the ship 
	public Coordinate lastCo() {
		int indexoflast = coordlist.size() - 1;
		return coordlist.get(indexoflast); 
	}
	
	//the boat isHit
	public boolean aShipisHit(Coordinate missile) {
		boolean solu = false;
		for (Coordinate c : this.coordlist) {
			if (c.equals(missile)) { 
				solu= true;
				this.nbtouch=this.nbtouch+1;}
		}
		return solu;
		}
	
	//destroyed

	public boolean destroyed() {
		if (size==nbtouch) {
			this.nbtouch=0;
			return true;
		}
		else {return false;}
	
	}
	
	//position of boat valid
	
		public boolean validePosition() {
			 boolean solu=false;
				// case ship horizontal
						if (this.firstCo().getY()==this.lastCo().getY() && this.firstCo().getX() != this.lastCo().getX())
						{	
							//transform character into number  
							int startx = (int) this.firstCo().getX();
							int endx = (int) this.lastCo().getX();
							int s = Math.abs(endx - startx);
							if (s  == size - 1) { 
									solu=true;
								 }
						}
						
						// case ship vertical
						else if (this.firstCo().getX()==this.lastCo().getX() && this.firstCo().getY() !=this.lastCo().getY())
								{	
									int s = Math.abs(this.firstCo().getY() - this.lastCo().getY());
									if (s ==size - 1) 
									{ 	solu=true;
										}	 
									}
						else { solu=false;}
						
			return solu;
}
}
