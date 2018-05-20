package gardeisen.marine;

public class IA extends Player {

	public IA(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
	//methods
		public Ship randomboat(int taille) {
			
			
			Coordinate start =new Coordinate();
			char x = start.getX();
			int xx =(int)x;
			xx=xx+ taille -1;
			char xxx=(char)xx;
			
			double r = Math.random();
			
			
			if((start.getY()+taille -1 <= 10) && r<0.50) {
				
					Coordinate end = new Coordinate(start.getX(),start.getY()+taille-1);
					Ship s = new Ship(taille,start,end);
					
						
						return s;			
			}
			
			if(xx<=73 && r>=0.50) {
				
					Coordinate end = new Coordinate(xxx,start.getY());
					Ship s = new Ship(taille,start,end);
					return s;
					
					
			}
					
			else { 
				start = new Coordinate();
				return this.randomboat(taille);
			}
			
		}
		
		public Coordinate chooseWhereHit() {
			
			Coordinate c= new Coordinate();
			return c;
		}

		
}
