package gardeisen.marine;
public class IAniveau2 extends IA {

	// constructor
	public IAniveau2(String name) {
		
		super(name);
		
	}
	
	public Coordinate chooseWhereHit() {
		
		Coordinate c= new Coordinate();
		
		if(this.getlistofHits().isEmpty()) {
			return c;
		}
		else {
			for (Coordinate hit : this.getlistofHits()) {
				int y=hit.getY();
				int xi =(int)hit.getX();
				Coordinate newshot=new Coordinate(hit.getX(),y-1);
				if (newshot.validCo() && this.canHit(newshot)) {
					return newshot;
				}
				else if (canHit(newshot)==false){
					newshot.setX(hit.getX());
					newshot.setY(y+1);
					if (newshot.validCo() && this.canHit(newshot)) {
						return newshot;
					}
					
				}
				else if (canHit(newshot)==false) {
					int newx=xi-1;
					char x=(char)newx;
					newshot.setX(x);
					newshot.setY(y);
					if (newshot.validCo() && this.canHit(newshot)) {
						return newshot;
					}
				}
				else if (canHit(newshot)==false) {
					int newx2=xi+1;
					char x=(char)newx2;
					newshot.setX(x);
					newshot.setY(y);
					if (newshot.validCo() && this.canHit(newshot)) {
						return newshot;
					}
				}
				else {
					Coordinate shooot=new Coordinate();
					return shooot;
				}
				
				
			}	
		}
	//ici on regarde si la liste hits vide 
		//si oui on tire au hasard coordinate() random
		//sinon on get une des coordinate de la liste hits, on regarde si sont bateau a etait coulé 
		//si oui coulé on choisit une autre coordonée faire plusiuer for
		//sinon on tape à coté en s'assurant que il n'y a pas déja appartient à hit ou miss 
		return c;
	}

}
