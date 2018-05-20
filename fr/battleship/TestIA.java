package fr.battleship;
import gardeisen.marine.*;
import java.io.FileWriter;
import java.io.IOException;

public class TestIA {

	public static void main(String[] args) {

		
	
				
				int i=0;
				int scoreI1=0;
				int scoreI2=0;
				IA I1=null;
				IA I2=null;
				while(i<100) {
					I1=new IA("level 0");
					I2=new IAniveau1("level 1");
					int result=game2(I1,I2);
					
					if(result==1) {
						scoreI1=scoreI1+1;
					}
					else if(result==2){
						scoreI2=scoreI2+1;
					}
					i++;
					
				}
				
				
				
				
				
				int j=0;
				int scoreI3=0;
				int scoreI4=0;
				IA I3=null;
				IA I4=null;
				while(j<100) {
					I3=new IAniveau1("level 1");
					I4=new IAniveau2("level 2");
					int result=game2(I3,I4);
					
					if(result==1) {
						scoreI3=scoreI3+1;
					}
					else if(result==2){
						scoreI4=scoreI4+1;
					}
					j++;
					
				}
				
				
				
				
				
				
				
				
				//la boucle pour 100 partie L0vsL
				
				int k=0;
				int scoreI5=0;
				int scoreI6=0;
				IA I5=null;
				IA I6=null;
				
				while(k<100) {
					I5=new IA("level 0");
					I6=new IAniveau2("level 2");
					int result=game2(I5,I6);
					
					if(result==1) {
						scoreI5=scoreI5+1;
					}
					else if(result==2){
						scoreI6=scoreI6+1;
					}
					k++;
					
				}
				
				
				try {
					FileWriter file = new FileWriter("ai_proof.csv");
					file.append("AI NAME1; SCORE1; AI NAME2; SCORE2\n");
					file.append(I1.getName()+";"+scoreI1+";"+I2.getName()+";"+scoreI2+"\n");
					file.append(I3.getName()+";"+scoreI3+";"+I4.getName()+";"+scoreI4+"\n");
					file.append(I5.getName()+";"+scoreI5+";"+I6.getName()+";"+scoreI6+"\n");
					file.close();
				} catch (IOException e) {
					
					e.printStackTrace();
				}

	}
			
			public static int game2(IA A1,IA A2) {
				
				//return 0 si A0 gagne 1 sinon 
				
				//initialisation les bateaux de A1
				
				boolean okIA= true;
				while (okIA) {
					
					Ship ship = A1.randomboat(2);
					if(ship.validePosition() && A1.aPieceShipisAlreadyHere(ship)==false) {
						A1.addCoordinate(ship);
						A1.addaShip(ship);
						okIA=false;	
					}
					
				}
				
				okIA= true;
				while (okIA) {
					
					Ship ship = A1.randomboat(3);
					if(ship.validePosition() && A1.aPieceShipisAlreadyHere(ship)==false) {
						A1.addCoordinate(ship);
						A1.addaShip(ship);
						okIA=false;	
					}
					
				}
				
				okIA= true;
				while (okIA) {
					
					Ship ship = A1.randomboat(3);
					if(ship.validePosition()  && A1.aPieceShipisAlreadyHere(ship)==false) {
						A1.addCoordinate(ship);
						A1.addaShip(ship);
						okIA=false;	
					}
					
				}
				
				okIA= true;
				while (okIA) {
					
					Ship ship = A1.randomboat(4);
					if(ship.validePosition() && A1.aPieceShipisAlreadyHere(ship)==false) {
						A1.addCoordinate(ship);
						A1.addaShip(ship);
						okIA=false;	
					}
					
				}
				okIA= true;
				while (okIA) {
					
					Ship ship = A1.randomboat(5);
					if(ship.validePosition() && A1.aPieceShipisAlreadyHere(ship)==false) {
						A1.addCoordinate(ship);
						A1.addaShip(ship);
						okIA=false;	
					}
					
				}
				
				//initailisation bateau de l'IA2
				
				boolean okIA2= true;
				while (okIA2) {
					
					Ship ship = A2.randomboat(2);
					if(ship.validePosition() && A2.aPieceShipisAlreadyHere(ship)==false) {
						A2.addCoordinate(ship);
						A2.addaShip(ship);
						okIA2=false;	
					}
					
				}
				
				okIA2= true;
				while (okIA2) {
					
					Ship ship = A2.randomboat(3);
					if(ship.validePosition() && A2.aPieceShipisAlreadyHere(ship)==false) {
						A2.addCoordinate(ship);
						A2.addaShip(ship);
						okIA2=false;	
					}
					
				}
				
				okIA2= true;
				while (okIA2) {
					
					Ship ship = A2.randomboat(3);
					if(ship.validePosition() && A2.aPieceShipisAlreadyHere(ship)==false) {
						A2.addCoordinate(ship);
						A2.addaShip(ship);
						okIA2=false;	
					}
					
				}
				
				okIA2= true;
				while (okIA2) {
					
					Ship ship = A2.randomboat(4);
					if(ship.validePosition() && A2.aPieceShipisAlreadyHere(ship)==false) {
						A2.addCoordinate(ship);
						A2.addaShip(ship);
						okIA2=false;	
					}
					
				}
				
				okIA2= true;
				while (okIA2) {
					
					Ship ship = A2.randomboat(5);
					if(ship.validePosition() && A2.aPieceShipisAlreadyHere(ship)==false) {
						A2.addCoordinate(ship);
						A2.addaShip(ship);
						okIA2=false;	
					}
					
				}
				
				
				int winner=0; // si A1 gagne winner=1 si A2 gagne winner=2
				
				while(A1.getlistofHits().size()!=17 && A2.getlistofHits().size()!=17) {
					
					//on commence par faire jouer A1
					Coordinate c= A1.chooseWhereHit();
					if (c.validCo()) {
							if(A2.isHit(c)) {
								A1.addCoordListHits(c);
							}
							else { A1.addCoordListMiss(c); }
							
					}
					if (A1.getlistofHits().size()==17) {
						winner=1;
					
					}
					//ensuite A2
					Coordinate c2= A2.chooseWhereHit();
					if (c2.validCo()) {
						if(A1.isHit(c2)) {
							A2.addCoordListHits(c2);
						}
						else { A2.addCoordListMiss(c2); }
						
					}
					if (A2.getlistofHits().size()==17) {
						winner=2;
					
					}
					
					
				}
				
			return winner;	
				
				
				
				
				
				
			}
			
		

	}


