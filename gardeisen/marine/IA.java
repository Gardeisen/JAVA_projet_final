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
			//System.out.println("le nombre random = "+r);
			//System.out.println("la coordonée x de débit convertit en int + taille -1 = "+xx);
			//System.out.println("la coordonnée qui serait celle en fin avec la lettre = "+xxx);
			//System.out.println("la coordonnée de debut Y = "+start.getY());
			//System.out.println("la taille= "+taille);
			
			if((start.getY()+taille -1 <= 10) && r<0.50) {
				
					Coordinate end = new Coordinate(start.getX(),start.getY()+taille-1);
					Ship s = new Ship(taille,start,end);
					//System.out.println("je suis passé ici 1");
					
						
						return s;			
			}
			
			if(xx<=73 && r>=0.50) {
				
					Coordinate end = new Coordinate(xxx,start.getY());
					Ship s = new Ship(taille,start,end);
					//System.out.println("je suis passé ici 2");
					return s;
					
					
			}
					
			else { 
				start = new Coordinate();
				//System.out.println("hop hop hop autre");
				return this.randomboat(taille);
			}
			
		}
		
		public Coordinate chooseWhereHit() {
			
			Coordinate c= new Coordinate();
			return c;
		}

		
}
