package gardeisen.marine;
import java.util.ArrayList;

public class IAniveau1 extends IA {

	
	//constructor 
	public IAniveau1(String name) {
		
		super(name);
		
	}
	
	public Coordinate chooseWhereHit() { 
		Coordinate c= new Coordinate();
		boolean ok=true;
		while(ok) {
		if(this.canHit(c)==true) {
		
		
			ok=false;
			if(this.getlistofHits().isEmpty()) {
				c= c;
			}
			else {
				for (Coordinate hit : this.getlistofHits()) {
					int y=hit.getY();
					int xi =(int)hit.getX();
					Coordinate newshot=new Coordinate(hit.getX(),y-1);
					if (newshot.validCo() && this.canHit(newshot)) {
						c = newshot;
				}
		
				
				
			}	
		
	}
		}
		else c=new Coordinate();
		}
		return c;
}
	
}
