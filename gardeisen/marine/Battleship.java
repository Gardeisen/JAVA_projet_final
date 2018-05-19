package gardeisen.marine;

import java.util.Scanner;
import java.io.Console;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {

		// Start of the game, initialization of players and ships

		Scanner input = new Scanner(System.in);

		System.out.println("Let's play !!!!");
		System.out.println("Set the number that match with the type of game you want to play");
		System.out.println("1 = I want to play against my dear friend next to me let's go for 1vs1");
		System.out.println("2 = Nobody wants to play with me let's go for a 1vsAI");
		System.out.println("3 = I only want to see two AI fight with a lot of blood\n");
		boolean ok12=true;
		int typeofgame=0;
		while(ok12) {
			String ty=input.next();
			if(ty.matches("[1-3]")) {
				typeofgame=Integer.parseInt(ty);
				ok12=false ;
			}
			else { System.out.println("no no no a Number between 1-3"); }
			
		}
		if (typeofgame == 1) {

			// names
			boolean ok8 = true;
			Player P1 = null;

			while (ok8) {

				System.out.println("Player 1 set your name :");
				String name = input.next();

				if (name.matches("[a-zA-Z]+")) {
					P1 = new Player(name);
					ok8 = false;
				}
			}

			boolean ok9 = true;
			Player P2 = null;
			while (ok9) {
				System.out.println("Player 2 set your name :");
				String name2 = input.next();
				if (name2.matches("[a-zA-Z]+")) {
					P2 = new Player(name2);
					ok9 = false;
				}
			}

			System.out.println("");
			game(P1, P2);
			

			boolean restart = true;
			while (restart) {
				System.out.println("The game ends but do you want to play again and take your revange? yes or no");
				String anser = input.next();
				if(anser.matches("[a-zA-Z]+")) {
					if (anser == "yes") {
						game(P2, P1);
						System.out.println("The game ends but do you want to play again and take your revange? yes or no");
						String anser2 = input.next();
						if(anser.matches("[a-zA-Z]+")) {
						if (anser2 == "yes") {
							game(P1, P2);
						} 	else {
					restart = false;
					System.out.println("Thank you for playing BattleShip! Come back soon for an other game");
				}
			} }
				}
		}
		}

		// if the player want to play alone
		if (typeofgame == 2) {

			// System.out.println("initialisation de l'IA");
			System.out.println(
					"Choose the level that the boot will have : \n 0 = take it easy\n 1 = let's try \n 2 = show me your best opponent \n ");
			
			
			boolean ok11=true;
			IA A1=null;
			while(ok11) {
				String l = input.next();
				if(l.matches("[0-2]")) {
					
					int level=Integer.parseInt(l);
					A1 = chooseLevelsofIA(level, "IA");
					ok11=false;
				}
				else {System.out.println("no no no a NUMBEEEEEER between 0-2");}
			}

			// Partie initialisation de l'odinateur

			boolean okIA = true;

			while (okIA) {

				Ship destroyerIA = A1.randomboat(2);

				if (destroyerIA.validePosition()) {
					A1.addCoordinate(destroyerIA);
					A1.addaShip(destroyerIA);
					okIA = false;
					// destroyerIA.showList();
					// System.out.println("destroyer ok !");
				}

			}

			okIA = true;
			while (okIA) {

				Ship carrierIA = A1.randomboat(5);

				if (carrierIA.validePosition() && A1.aPieceShipisAlreadyHere(carrierIA) == false) {
					okIA = false;
					A1.addaShip(carrierIA);
					A1.addCoordinate(carrierIA);
					// System.out.println("carrier ok !");
				}
			}

			okIA = true;
			while (okIA) {

				Ship submarineIA = A1.randomboat(3);

				if (submarineIA.validePosition() && A1.aPieceShipisAlreadyHere(submarineIA) == false) {
					okIA = false;
					A1.addaShip(submarineIA);
					A1.addCoordinate(submarineIA);

					// System.out.println("submarine ok !");
				}
			}

			okIA = true;
			while (okIA) {

				Ship cruiserIA = A1.randomboat(3);
				if (cruiserIA.validePosition() && A1.aPieceShipisAlreadyHere(cruiserIA) == false) {
					okIA = false;
					A1.addaShip(cruiserIA);
					A1.addCoordinate(cruiserIA);
					// System.out.println("cruiser ok !");
				}
			}

			okIA = true;
			while (okIA) {

				Ship battleShipIA = A1.randomboat(4);
				if (battleShipIA.validePosition() && A1.aPieceShipisAlreadyHere(battleShipIA) == false) {
					okIA = false;
					A1.addaShip(battleShipIA);
					A1.addCoordinate(battleShipIA);
					// System.out.println("battleship ok !");
				}
			}

			//System.out.println(A1.showMyGrille());
			System.out.println("\n\n\n\n\n\n\n\n\n\n");

			// initialisation pour l'unique joueur
			System.out.println("Player set your name :");
			boolean ok14=true;
			Player J=null;
			while(ok14) {
			String name = input.next();
			if (name.matches("[a-zA-Z]+")) {
				J = new Player(name);
				ok14 = false;
				
			}
			else { System.out.println("I say enter your NAME"); }
			}
			// FOR PLAYER
			// carrier size =5
			boolean ok = true;
			System.out.println(J.showMyGrille() + "\n\n");

			while (ok) {

				System.out.println("Player " + J.getName() + " set START position of your carrier size 5 :");
				
				boolean ok15=true;
				Coordinate startc1=null;
				while(ok15) {
					System.out.print("Start with the letter in MAJ en press enter  ");
					String a = input.next();
					System.out.print("Then with the number en press enter  ");
					String bs = input.next();
					
					if(a.matches("[A-Z]") && bs.matches("[0-9]+") ) {
						
						char abis = a.charAt(0);
						int b =Integer.parseInt(bs);
						startc1 = new Coordinate(abis, b);
						ok15=false;
					}
					else { System.out.println("Please put the correct type");}
					System.out.println("\n");
				}

				System.out.println("Player " + J.getName() + " set END position of your carrier size 5 :");
				
				boolean ok16=true;
				Coordinate endc1=null;
				while(ok16) {
					System.out.print("Start with the letter in MAJ en press enter  ");
					String a = input.next();
					System.out.print("Then with the number en press enter  ");
					String bs = input.next();
					
					if(a.matches("[A-Z]") && bs.matches("[0-9]+") ) {
						
						char abis = a.charAt(0);
						int b =Integer.parseInt(bs);
						endc1 = new Coordinate(abis, b);
						ok16=false;
					}
					else { System.out.println("Please put the correct type");}
					System.out.println("\n");
				}

				
				Ship car = new Ship(5, startc1, endc1); // same as placeShip is in the constructor
				if (car.validePosition() && startc1.validCo() && endc1.validCo()) {

					J.addCoordinate(car);
					J.addaShip(car);// put in the list all the coordinate of the ship
					// car.showList(); // show the list of coordinate that we just have use in the
					// different
					ok = false;
					System.out.print(J.showMyGrille() + "\n\n");

				} else {
					System.out.println("Invalid position ! Try again ");
				}

			}

			// Battleship size = 4
			ok=true;
			while (ok) {

				System.out.println("Player " + J.getName() + " set START position of your battleship size 4 :");
				
				boolean ok15=true;
				Coordinate startc1=null;
				while(ok15) {
					System.out.print("Start with the letter in MAJ en press enter  ");
					String a = input.next();
					System.out.print("Then with the number en press enter  ");
					String bs = input.next();
					
					if(a.matches("[A-Z]") && bs.matches("[0-9]+") ) {
						
						char abis = a.charAt(0);
						int b =Integer.parseInt(bs);
						startc1 = new Coordinate(abis, b);
						ok15=false;
					}
					else { System.out.println("Please put the correct type");}
					System.out.println("\n");
				}

				System.out.println("Player " + J.getName() + " set END position of your  battleship size 4 :");
				
				boolean ok16=true;
				Coordinate endc1=null;
				while(ok16) {
					System.out.print("Start with the letter in MAJ en press enter  ");
					String a = input.next();
					System.out.print("Then with the number en press enter  ");
					String bs = input.next();
					
					if(a.matches("[A-Z]") && bs.matches("[0-9]+") ) {
						
						char abis = a.charAt(0);
						int b =Integer.parseInt(bs);
						endc1 = new Coordinate(abis, b);
						ok16=false;
					}
					else { System.out.println("Please put the correct type");}
					System.out.println("\n");
				}

				
				Ship car = new Ship(4, startc1, endc1); // same as placeShip is in the constructor
				if (car.validePosition() && startc1.validCo() && endc1.validCo()) {

					J.addCoordinate(car);
					J.addaShip(car);// put in the list all the coordinate of the ship
					// car.showList(); // show the list of coordinate that we just have use in the
					// different
					ok = false;
					System.out.print(J.showMyGrille() + "\n\n");

				} else {
					System.out.println("Invalid position ! Try again ");
				}

			}


			// Cruiser size = 3
			ok=true;
			while (ok) {

				System.out.println("Player " + J.getName() + " set START position of your crusier size 3 :");
				
				boolean ok15=true;
				Coordinate startc1=null;
				while(ok15) {
					System.out.print("Start with the letter in MAJ en press enter  ");
					String a = input.next();
					System.out.print("Then with the number en press enter  ");
					String bs = input.next();
					
					if(a.matches("[A-Z]") && bs.matches("[0-9]+") ) {
						
						char abis = a.charAt(0);
						int b =Integer.parseInt(bs);
						startc1 = new Coordinate(abis, b);
						ok15=false;
					}
					else { System.out.println("Please put the correct type");}
					System.out.println("\n");
				}

				System.out.println("Player " + J.getName() + " set END position of your crusier size 3 :");
				
				boolean ok16=true;
				Coordinate endc1=null;
				while(ok16) {
					System.out.print("Start with the letter in MAJ en press enter  ");
					String a = input.next();
					System.out.print("Then with the number en press enter  ");
					String bs = input.next();
					
					if(a.matches("[A-Z]") && bs.matches("[0-9]+") ) {
						
						char abis = a.charAt(0);
						int b =Integer.parseInt(bs);
						endc1 = new Coordinate(abis, b);
						ok16=false;
					}
					else { System.out.println("Please put the correct type");}
					System.out.println("\n");
				}

				
				Ship car = new Ship(3, startc1, endc1); // same as placeShip is in the constructor
				if (car.validePosition() && startc1.validCo() && endc1.validCo()) {

					J.addCoordinate(car);
					J.addaShip(car);// put in the list all the coordinate of the ship
					// car.showList(); // show the list of coordinate that we just have use in the
					// different
					ok = false;
					System.out.print(J.showMyGrille() + "\n\n");

				} else {
					System.out.println("Invalid position ! Try again ");
				}

			}

			// submarine size = 3
			ok=true;
			while (ok) {

				System.out.println("Player " + J.getName() + " set START position of your submarine size 3 :");
				
				boolean ok15=true;
				Coordinate startc1=null;
				while(ok15) {
					System.out.print("Start with the letter in MAJ en press enter  ");
					String a = input.next();
					System.out.print("Then with the number en press enter  ");
					String bs = input.next();
					
					if(a.matches("[A-Z]") && bs.matches("[0-9]+") ) {
						
						char abis = a.charAt(0);
						int b =Integer.parseInt(bs);
						startc1 = new Coordinate(abis, b);
						ok15=false;
					}
					else { System.out.println("Please put the correct type");}
					System.out.println("\n");
				}

				System.out.println("Player " + J.getName() + " set END position of your submarine size 3 :");
				
				boolean ok16=true;
				Coordinate endc1=null;
				while(ok16) {
					System.out.print("Start with the letter in MAJ en press enter  ");
					String a = input.next();
					System.out.print("Then with the number en press enter  ");
					String bs = input.next();
					
					if(a.matches("[A-Z]") && bs.matches("[0-9]+") ) {
						
						char abis = a.charAt(0);
						int b =Integer.parseInt(bs);
						endc1 = new Coordinate(abis, b);
						ok16=false;
					}
					else { System.out.println("Please put the correct type");}
					System.out.println("\n");
				}

				
				Ship car = new Ship(3, startc1, endc1); // same as placeShip is in the constructor
				if (car.validePosition() && startc1.validCo() && endc1.validCo()) {

					J.addCoordinate(car);
					J.addaShip(car);// put in the list all the coordinate of the ship
					// car.showList(); // show the list of coordinate that we just have use in the
					// different
					ok = false;
					System.out.print(J.showMyGrille() + "\n\n");

				} else {
					System.out.println("Invalid position ! Try again ");
				}

			}

			// Destroyer size = 2
			ok=true;
			while (ok) {

				System.out.println("Player " + J.getName() + " set START position of your destroyer size 2 :");
				
				boolean ok15=true;
				Coordinate startc1=null;
				while(ok15) {
					System.out.print("Start with the letter in MAJ en press enter  ");
					String a = input.next();
					System.out.print("Then with the number en press enter  ");
					String bs = input.next();
					
					if(a.matches("[A-Z]") && bs.matches("[0-9]+") ) {
						
						char abis = a.charAt(0);
						int b =Integer.parseInt(bs);
						startc1 = new Coordinate(abis, b);
						ok15=false;
					}
					else { System.out.println("Please put the correct type");}
					System.out.println("\n");
				}

				System.out.println("Player " + J.getName() + " set END position of your destroyer size 2 :");
				
				boolean ok16=true;
				Coordinate endc1=null;
				while(ok16) {
					System.out.print("Start with the letter in MAJ en press enter  ");
					String a = input.next();
					System.out.print("Then with the number en press enter  ");
					String bs = input.next();
					
					if(a.matches("[A-Z]") && bs.matches("[0-9]+") ) {
						
						char abis = a.charAt(0);
						int b =Integer.parseInt(bs);
						endc1 = new Coordinate(abis, b);
						ok16=false;
					}
					else { System.out.println("Please put the correct type");}
					System.out.println("\n");
				}

				
				Ship car = new Ship(2, startc1, endc1); // same as placeShip is in the constructor
				if (car.validePosition() && startc1.validCo() && endc1.validCo()) {

					J.addCoordinate(car);
					J.addaShip(car);// put in the list all the coordinate of the ship
					// car.showList(); // show the list of coordinate that we just have use in the
					// different
					ok = false;
					System.out.print(J.showMyGrille() + "\n\n");

				} else {
					System.out.println("Invalid position ! Try again ");
				}

			}

			// the game

			System.out.println("Player " + J.getName() + "  your turn!");

			// game ends when one of the list hits == 17
			while (J.getlistofHits().size() != 17 && A1.getlistofHits().size() != 17) {

				// try to shoot condition
				boolean ok3 = true;

				while (ok3) {
					// for player J, choose where he wants to shoot canHit
					System.out.println("This is where the other player shoot (x) and your ship (o) \n "
							+ J.showMeMyShipButWhithTheHitsOfOtherPlayer(A1));
					
					System.out.println("This is the grill where YOU shoot");
					System.out.println(J.showMeMyShot());
					System.out.println("Player " + J.getName() + ", where do you want to shoot?");
					

					String c = input.next();
					char cbis = c.charAt(0);
					int d = input.nextInt();
					Coordinate shot = new Coordinate(cbis, d);
					System.out.println("shoot X = " + shot.getX() + " , Y= " + shot.getY());

					// System.out.println("avant le if");
					if (J.canHit(shot) == true && shot.validCo()) {
						// shoot

						for (Ship s : A1.getlistShip()) {
							// System.out.println("la fonction aShipisHit" +s.getSize()+s.aShipisHit(shot));
							if (s.aShipisHit(shot)) {
								J.addCoordListHits(shot);
								System.out.println("touched!\n");
								System.out.print(J.showMeMyShot());
								if (s.destroyed()) {
									System.out.println("you succely flow a ship!");
								}
							}
						}

						if (A1.isHit(shot) == false) {
							J.addCoordListMiss(shot);
							System.out.print(J.showMeMyShot());
							System.out.println("miss!");
						}
						ok3 = false;
						
					}

					else {
						System.out.println("Choose an other coordinate to shoot, you already try this one");
					}

				}

				if (J.getlistofHits().size() == 17) {
					System.out.println("End of the game, player " + J.getName() + " WIN !");
				} else {
					System.out.println("Round of AI \n");

					// same but with AI
					boolean ok4 = true;

					while (ok4) {

						Coordinate shot2 = A1.chooseWhereHit();
						System.out.println("The AI choose to shoot at x= " + shot2.getX() + " , y= " + shot2.getY());
						if (A1.canHit(shot2) == false) {
							System.out.println("Bad luck you already shoot here " + A1.getName());
						}
						if (shot2.validCo()) {
							// shoot

							for (Ship s : J.getlistShip()) {
								if (s.aShipisHit(shot2)) {
									A1.addCoordListHits(shot2);
									System.out.println("touched !");
									// System.out.println(A1.showMeMyShot());

									if (s.destroyed()) {
										System.out.println("you succely flow a ship!");
									}
								}
							}
							if (J.isHit(shot2) == false) {
								A1.addCoordListMiss(shot2);
								System.out.println("missed!");
								// System.out.println(A1.showMeMyShot());

							}

							ok4 = false;

							System.out.println("\n\n\n\n\n\n\n\n\n\n");

						}

						else {
							System.out.println("Choose an other coordinate to shoot, you already try this one");
						}
					}
					if (A1.getlistofHits().size() == 17) {
						System.out.println("End of the game, you loose against the AI !");
					}

				}

			}

		}

		// IA / IA :

		if (typeofgame == 3) {

			System.out.println("Ok, you want to see two AI fight??\n\n");
			System.out.println("Right ! Choose level of the first AI\n");
			System.out.println("level 0 1 or 2 ?");
			int level1 = input.nextInt();
			IA A1 = chooseLevelsofIA(level1, "The first AI ");
			System.out.println("Right ! Choose level of the second AI\n");
			System.out.println("level 0 1 or 2 ?");
			int level2 = input.nextInt();
			IA A2 = chooseLevelsofIA(level2, "The second AI ");

			// Partie initialisation de A1

			boolean okIA = true;

			while (okIA) {

				Ship destroyerIA = A1.randomboat(2);

				if (destroyerIA.validePosition()) {
					A1.addCoordinate(destroyerIA);
					A1.addaShip(destroyerIA);
					okIA = false;
					// destroyerIA.showList();
					// System.out.println("destroyer ok !");
				}

			}

			okIA = true;
			while (okIA) {

				Ship carrierIA = A1.randomboat(5);

				if (carrierIA.validePosition() && A1.aPieceShipisAlreadyHere(carrierIA) == false) {
					okIA = false;
					A1.addaShip(carrierIA);
					A1.addCoordinate(carrierIA);
					// System.out.println("carrier ok !");
				}
			}

			okIA = true;
			while (okIA) {

				Ship submarineIA = A1.randomboat(3);

				if (submarineIA.validePosition() && A1.aPieceShipisAlreadyHere(submarineIA) == false) {
					okIA = false;
					A1.addaShip(submarineIA);
					A1.addCoordinate(submarineIA);

					// System.out.println("submarine ok !");
				}
			}

			okIA = true;
			while (okIA) {

				Ship cruiserIA = A1.randomboat(3);
				if (cruiserIA.validePosition() && A1.aPieceShipisAlreadyHere(cruiserIA) == false) {
					okIA = false;
					A1.addaShip(cruiserIA);
					A1.addCoordinate(cruiserIA);
					// System.out.println("cruiser ok !");
				}
			}

			okIA = true;
			while (okIA) {

				Ship battleShipIA = A1.randomboat(4);
				if (battleShipIA.validePosition() && A1.aPieceShipisAlreadyHere(battleShipIA) == false) {
					okIA = false;
					A1.addaShip(battleShipIA);
					A1.addCoordinate(battleShipIA);
					// System.out.println("battleship ok !");
				}
			}

			System.out.println("This is the ships placement of first AI\n" + A1.showMyGrille());
			System.out.println("\n\n\n\n\n\n\n\n\n\n");

			// Partie initialisation de A2

			boolean okIA2 = true;

			while (okIA2) {

				Ship destroyerIA = A2.randomboat(2);

				if (destroyerIA.validePosition()) {
					A2.addCoordinate(destroyerIA);
					A2.addaShip(destroyerIA);
					okIA2 = false;
					// destroyerIA.showList();
					// System.out.println("destroyer ok !");
				}

			}

			okIA2 = true;
			while (okIA2) {

				Ship carrierIA = A2.randomboat(5);

				if (carrierIA.validePosition() && A2.aPieceShipisAlreadyHere(carrierIA) == false) {
					okIA2 = false;
					A2.addaShip(carrierIA);
					A2.addCoordinate(carrierIA);
					// System.out.println("carrier ok !");
				}
			}

			okIA2 = true;
			while (okIA2) {

				Ship submarineIA = A2.randomboat(3);

				if (submarineIA.validePosition() && A2.aPieceShipisAlreadyHere(submarineIA) == false) {
					okIA2 = false;
					A2.addaShip(submarineIA);
					A2.addCoordinate(submarineIA);

					// System.out.println("submarine ok !");
				}
			}

			okIA2 = true;
			while (okIA2) {

				Ship cruiserIA = A2.randomboat(3);
				if (cruiserIA.validePosition() && A2.aPieceShipisAlreadyHere(cruiserIA) == false) {
					okIA2 = false;
					A2.addaShip(cruiserIA);
					A2.addCoordinate(cruiserIA);
					// System.out.println("cruiser ok !");
				}
			}

			okIA2 = true;
			while (okIA2) {

				Ship battleShipIA = A2.randomboat(4);
				if (battleShipIA.validePosition() && A2.aPieceShipisAlreadyHere(battleShipIA) == false) {
					okIA2 = false;
					A2.addaShip(battleShipIA);
					A2.addCoordinate(battleShipIA);
					// System.out.println("battleship ok !");
				}
			}

			System.out.println("This is the ships placement of the second AI \n" + A2.showMyGrille());
			System.out.println("\n\n\n\n\n\n\n\n\n\n");

			// the game

			System.out.println(A2.getName() + " turn!");

			// game ends when one of the list hits == 17
			while (A1.getlistofHits().size() != 17 && A2.getlistofHits().size() != 17) {

				// try to shoot condition
				boolean ok = true;

				while (ok) {
					// beging with A2

					// System.out.println(A2.showMeMyShot());

					Coordinate shot = A2.chooseWhereHit();
					// System.out.println("the second AI choose to shoot at X = "+shot.getX()+" , Y=
					// "+shot.getY());
					if (A2.canHit(shot) == false) {
						System.out.println("Bad luck you already shoot here " + A2.getName());
					}

					else if (shot.validCo()) {
						// shoot

						for (Ship s : A1.getlistShip()) {
							// System.out.println("la fonction aShipisHit" +s.getSize()+s.aShipisHit(shot));
							if (s.aShipisHit(shot)) {
								A2.addCoordListHits(shot);
								System.out.println("touched!\n");
								// System.out.print(A2.showMeMyShot());
								if (s.destroyed()) {
									System.out.println("you succely flow a ship!");
								}
							}
						}

						if (A1.isHit(shot) == false) {
							A2.addCoordListMiss(shot);
							// System.out.print(A2.showMeMyShot());
							System.out.println("miss!");
						}
						ok = false;

					}

					else {
						System.out.println("Choose an other coordinate to shoot");
					}

				}

				if (A2.getlistofHits().size() == 17) {
					System.out.println("End of the game " + A2.getName() + " WIN !");
				} else {
					System.out.println("Round of first AI \n");

					// same but with AI
					boolean ok4 = true;

					while (ok4) {

						Coordinate shot2 = A1.chooseWhereHit();
						System.out.println("The AI choose to shoot at x= " + shot2.getX() + " , y= " + shot2.getY());
						if (A1.canHit(shot2) == false) {
							System.out.println("Bad luck you already shoot here " + A1.getName());
						} else if (shot2.validCo()) {
							// shoot

							for (Ship s : A2.getlistShip()) {
								if (s.aShipisHit(shot2)) {
									A1.addCoordListHits(shot2);
									System.out.println("touched !");
									// System.out.println(A1.showMeMyShot());

									if (s.destroyed()) {
										System.out.println("you succely flow a ship!");
									}
								}
							}
							if (A2.isHit(shot2) == false) {
								A1.addCoordListMiss(shot2);
								System.out.println("missed!");
								// System.out.println(A1.showMeMyShot());

							}

							ok4 = false;

							System.out.println("\n\n\n\n\n\n\n\n\n\n");

						}

						else {
							System.out.println("Choose an other coordinate to shoot");
						}
					}
					if (A1.getlistofHits().size() == 17) {
						System.out.println("End of the game " + A1.getName() + " WIN !");
					}

				}

			}

		}
		
		
	}

	public static IA chooseLevelsofIA(int level, String name) {

		if (level == 0) {
			IA A1 = new IA(name);
			return A1;
		} else if (level == 1) {

			IAniveau1 A1 = new IAniveau1(name);
			return A1;
		} else if (level == 2) {

			IAniveau2 A1 = new IAniveau2(name);
			return A1;
		}
		return null;

	}

	public static void game(Player J1, Player J2) {

		Scanner input = new Scanner(System.in);
		// FOR PLAYER 1
		// carrier size =5

		boolean ok = true;
		System.out.println(J1.showMyGrille() + "\n\n");

		while (ok) {

			System.out.println("Player " + J1.getName() + " set START position of your carrier size 5 :");
			
			boolean ok15=true;
			Coordinate startc1=null;
			while(ok15) {
				System.out.print("Start with the letter in MAJ en press enter  ");
				String a = input.next();
				System.out.print("Then with the number en press enter  ");
				String bs = input.next();
				
				if(a.matches("[A-Z]") && bs.matches("[0-9]+") ) {
					
					char abis = a.charAt(0);
					int b =Integer.parseInt(bs);
					startc1 = new Coordinate(abis, b);
					ok15=false;
				}
				else { System.out.println("Please put the correct type");}
				System.out.println("\n");
			}

			System.out.println("Player " + J1.getName() + " set END position of your carrier size 5 :");
			
			boolean ok16=true;
			Coordinate endc1=null;
			while(ok16) {
				System.out.print("Start with the letter in MAJ en press enter  ");
				String a = input.next();
				System.out.print("Then with the number en press enter  ");
				String bs = input.next();
				
				if(a.matches("[A-Z]") && bs.matches("[0-9]+") ) {
					
					char abis = a.charAt(0);
					int b =Integer.parseInt(bs);
					endc1 = new Coordinate(abis, b);
					ok16=false;
				}
				else { System.out.println("Please put the correct type");}
				System.out.println("\n");
			}

			
			Ship car = new Ship(5, startc1, endc1); // same as placeShip is in the constructor
			if (car.validePosition() && startc1.validCo() && endc1.validCo()) {

				J1.addCoordinate(car);
				J1.addaShip(car);// put in the list all the coordinate of the ship
				// car.showList(); // show the list of coordinate that we just have use in the
				// different
				ok = false;
				System.out.print(J1.showMyGrille() + "\n\n");

			} else {
				System.out.println("Invalid position ! Try again ");
			}

		}

		// Battleship size = 4
		ok=true;
		while (ok) {

			System.out.println("Player " + J1.getName() + " set START position of your battleship size 4 :");
			
			boolean ok15=true;
			Coordinate startc1=null;
			while(ok15) {
				System.out.print("Start with the letter in MAJ en press enter  ");
				String a = input.next();
				System.out.print("Then with the number en press enter  ");
				String bs = input.next();
				
				if(a.matches("[A-Z]") && bs.matches("[0-9]+") ) {
					
					char abis = a.charAt(0);
					int b =Integer.parseInt(bs);
					startc1 = new Coordinate(abis, b);
					ok15=false;
				}
				else { System.out.println("Please put the correct type");}
				System.out.println("\n");
			}

			System.out.println("Player " + J1.getName() + " set END position of your  battleship size 4 :");
			
			boolean ok16=true;
			Coordinate endc1=null;
			while(ok16) {
				System.out.print("Start with the letter in MAJ en press enter  ");
				String a = input.next();
				System.out.print("Then with the number en press enter  ");
				String bs = input.next();
				
				if(a.matches("[A-Z]") && bs.matches("[0-9]+") ) {
					
					char abis = a.charAt(0);
					int b =Integer.parseInt(bs);
					endc1 = new Coordinate(abis, b);
					ok16=false;
				}
				else { System.out.println("Please put the correct type");}
				System.out.println("\n");
			}

			
			Ship car = new Ship(4, startc1, endc1); // same as placeShip is in the constructor
			if (car.validePosition() && startc1.validCo() && endc1.validCo()) {

				J1.addCoordinate(car);
				J1.addaShip(car);// put in the list all the coordinate of the ship
				// car.showList(); // show the list of coordinate that we just have use in the
				// different
				ok = false;
				System.out.print(J1.showMyGrille() + "\n\n");

			} else {
				System.out.println("Invalid position ! Try again ");
			}

		}


		// Cruiser size = 3
		ok=true;
		while (ok) {

			System.out.println("Player " + J1.getName() + " set START position of your crusier size 3 :");
			
			boolean ok15=true;
			Coordinate startc1=null;
			while(ok15) {
				System.out.print("Start with the letter in MAJ en press enter  ");
				String a = input.next();
				System.out.print("Then with the number en press enter  ");
				String bs = input.next();
				
				if(a.matches("[A-Z]") && bs.matches("[0-9]+") ) {
					
					char abis = a.charAt(0);
					int b =Integer.parseInt(bs);
					startc1 = new Coordinate(abis, b);
					ok15=false;
				}
				else { System.out.println("Please put the correct type");}
				System.out.println("\n");
			}

			System.out.println("Player " + J1.getName() + " set END position of your crusier size 3 :");
			
			boolean ok16=true;
			Coordinate endc1=null;
			while(ok16) {
				System.out.print("Start with the letter in MAJ en press enter  ");
				String a = input.next();
				System.out.print("Then with the number en press enter  ");
				String bs = input.next();
				
				if(a.matches("[A-Z]") && bs.matches("[0-9]+") ) {
					
					char abis = a.charAt(0);
					int b =Integer.parseInt(bs);
					endc1 = new Coordinate(abis, b);
					ok16=false;
				}
				else { System.out.println("Please put the correct type");}
				System.out.println("\n");
			}

			
			Ship car = new Ship(3, startc1, endc1); // same as placeShip is in the constructor
			if (car.validePosition() && startc1.validCo() && endc1.validCo()) {

				J1.addCoordinate(car);
				J1.addaShip(car);// put in the list all the coordinate of the ship
				// car.showList(); // show the list of coordinate that we just have use in the
				// different
				ok = false;
				System.out.print(J1.showMyGrille() + "\n\n");

			} else {
				System.out.println("Invalid position ! Try again ");
			}

		}

		// submarine size = 3
		ok=true;
		while (ok) {

			System.out.println("Player " + J1.getName() + " set START position of your submarine size 3 :");
			
			boolean ok15=true;
			Coordinate startc1=null;
			while(ok15) {
				System.out.print("Start with the letter in MAJ en press enter  ");
				String a = input.next();
				System.out.print("Then with the number en press enter  ");
				String bs = input.next();
				
				if(a.matches("[A-Z]") && bs.matches("[0-9]+") ) {
					
					char abis = a.charAt(0);
					int b =Integer.parseInt(bs);
					startc1 = new Coordinate(abis, b);
					ok15=false;
				}
				else { System.out.println("Please put the correct type");}
				System.out.println("\n");
			}

			System.out.println("Player " + J1.getName() + " set END position of your submarine size 3 :");
			
			boolean ok16=true;
			Coordinate endc1=null;
			while(ok16) {
				System.out.print("Start with the letter in MAJ en press enter  ");
				String a = input.next();
				System.out.print("Then with the number en press enter  ");
				String bs = input.next();
				
				if(a.matches("[A-Z]") && bs.matches("[0-9]+") ) {
					
					char abis = a.charAt(0);
					int b =Integer.parseInt(bs);
					endc1 = new Coordinate(abis, b);
					ok16=false;
				}
				else { System.out.println("Please put the correct type");}
				System.out.println("\n");
			}

			
			Ship car = new Ship(3, startc1, endc1); // same as placeShip is in the constructor
			if (car.validePosition() && startc1.validCo() && endc1.validCo()) {

				J1.addCoordinate(car);
				J1.addaShip(car);// put in the list all the coordinate of the ship
				// car.showList(); // show the list of coordinate that we just have use in the
				// different
				ok = false;
				System.out.print(J1.showMyGrille() + "\n\n");

			} else {
				System.out.println("Invalid position ! Try again ");
			}

		}

		// Destroyer size = 2
		ok=true;
		while (ok) {

			System.out.println("Player " + J1.getName() + " set START position of your destroyer size 2 :");
			
			boolean ok15=true;
			Coordinate startc1=null;
			while(ok15) {
				System.out.print("Start with the letter in MAJ en press enter  ");
				String a = input.next();
				System.out.print("Then with the number en press enter  ");
				String bs = input.next();
				
				if(a.matches("[A-Z]") && bs.matches("[0-9]+") ) {
					
					char abis = a.charAt(0);
					int b =Integer.parseInt(bs);
					startc1 = new Coordinate(abis, b);
					ok15=false;
				}
				else { System.out.println("Please put the correct type");}
				System.out.println("\n");
			}

			System.out.println("Player " + J1.getName() + " set END position of your destroyer size 2 :");
			
			boolean ok16=true;
			Coordinate endc1=null;
			while(ok16) {
				System.out.print("Start with the letter in MAJ en press enter  ");
				String a = input.next();
				System.out.print("Then with the number en press enter  ");
				String bs = input.next();
				
				if(a.matches("[A-Z]") && bs.matches("[0-9]+") ) {
					
					char abis = a.charAt(0);
					int b =Integer.parseInt(bs);
					endc1 = new Coordinate(abis, b);
					ok16=false;
				}
				else { System.out.println("Please put the correct type");}
				System.out.println("\n");
			}

			
			Ship car = new Ship(2, startc1, endc1); // same as placeShip is in the constructor
			if (car.validePosition() && startc1.validCo() && endc1.validCo()) {

				J1.addCoordinate(car);
				J1.addaShip(car);// put in the list all the coordinate of the ship
				// car.showList(); // show the list of coordinate that we just have use in the
				// different
				ok = false;
				System.out.print(J1.showMyGrille() + "\n\n");

			} else {
				System.out.println("Invalid position ! Try again ");
			}

		}
		

		// // FOR PLAYER 2
		// carrier size =5

		ok = true;
		System.out.println(J2.showMyGrille() + "\n\n");

		while (ok) {

			System.out.println("Player " + J2.getName() + " set START position of your carrier size 5 :");
			
			boolean ok15=true;
			Coordinate startc1=null;
			while(ok15) {
				System.out.print("Start with the letter in MAJ en press enter  ");
				String a = input.next();
				System.out.print("Then with the number en press enter  ");
				String bs = input.next();
				
				if(a.matches("[A-Z]") && bs.matches("[0-9]+") ) {
					
					char abis = a.charAt(0);
					int b =Integer.parseInt(bs);
					startc1 = new Coordinate(abis, b);
					ok15=false;
				}
				else { System.out.println("Please put the correct type");}
				System.out.println("\n");
			}

			System.out.println("Player " + J2.getName() + " set END position of your carrier size 5 :");
			
			boolean ok16=true;
			Coordinate endc1=null;
			while(ok16) {
				System.out.print("Start with the letter in MAJ en press enter  ");
				String a = input.next();
				System.out.print("Then with the number en press enter  ");
				String bs = input.next();
				
				if(a.matches("[A-Z]") && bs.matches("[0-9]+") ) {
					
					char abis = a.charAt(0);
					int b =Integer.parseInt(bs);
					endc1 = new Coordinate(abis, b);
					ok16=false;
				}
				else { System.out.println("Please put the correct type");}
				System.out.println("\n");
			}

			
			Ship car = new Ship(5, startc1, endc1); // same as placeShip is in the constructor
			if (car.validePosition() && startc1.validCo() && endc1.validCo()) {

				J2.addCoordinate(car);
				J2.addaShip(car);// put in the list all the coordinate of the ship
				// car.showList(); // show the list of coordinate that we just have use in the
				// different
				ok = false;
				System.out.print(J2.showMyGrille() + "\n\n");

			} else {
				System.out.println("Invalid position ! Try again ");
			}

		}

		// Battleship size = 4
		ok=true;
		while (ok) {

			System.out.println("Player " + J2.getName() + " set START position of your battleship size 4 :");
			
			boolean ok15=true;
			Coordinate startc1=null;
			while(ok15) {
				System.out.print("Start with the letter in MAJ en press enter  ");
				String a = input.next();
				System.out.print("Then with the number en press enter  ");
				String bs = input.next();
				
				if(a.matches("[A-Z]") && bs.matches("[0-9]+") ) {
					
					char abis = a.charAt(0);
					int b =Integer.parseInt(bs);
					startc1 = new Coordinate(abis, b);
					ok15=false;
				}
				else { System.out.println("Please put the correct type");}
				System.out.println("\n");
			}

			System.out.println("Player " + J2.getName() + " set END position of your  battleship size 4 :");
			
			boolean ok16=true;
			Coordinate endc1=null;
			while(ok16) {
				System.out.print("Start with the letter in MAJ en press enter  ");
				String a = input.next();
				System.out.print("Then with the number en press enter  ");
				String bs = input.next();
				
				if(a.matches("[A-Z]") && bs.matches("[0-9]+") ) {
					
					char abis = a.charAt(0);
					int b =Integer.parseInt(bs);
					endc1 = new Coordinate(abis, b);
					ok16=false;
				}
				else { System.out.println("Please put the correct type");}
				System.out.println("\n");
			}

			
			Ship car = new Ship(4, startc1, endc1); // same as placeShip is in the constructor
			if (car.validePosition() && startc1.validCo() && endc1.validCo()) {

				J2.addCoordinate(car);
				J2.addaShip(car);// put in the list all the coordinate of the ship
				// car.showList(); // show the list of coordinate that we just have use in the
				// different
				ok = false;
				System.out.print(J2.showMyGrille() + "\n\n");

			} else {
				System.out.println("Invalid position ! Try again ");
			}

		}


		// Cruiser size = 3
		ok=true;
		while (ok) {

			System.out.println("Player " + J2.getName() + " set START position of your crusier size 3 :");
			
			boolean ok15=true;
			Coordinate startc1=null;
			while(ok15) {
				System.out.print("Start with the letter in MAJ en press enter  ");
				String a = input.next();
				System.out.print("Then with the number en press enter  ");
				String bs = input.next();
				
				if(a.matches("[A-Z]") && bs.matches("[0-9]+") ) {
					
					char abis = a.charAt(0);
					int b =Integer.parseInt(bs);
					startc1 = new Coordinate(abis, b);
					ok15=false;
				}
				else { System.out.println("Please put the correct type");}
				System.out.println("\n");
			}

			System.out.println("Player " + J2.getName() + " set END position of your crusier size 3 :");
			
			boolean ok16=true;
			Coordinate endc1=null;
			while(ok16) {
				System.out.print("Start with the letter in MAJ en press enter  ");
				String a = input.next();
				System.out.print("Then with the number en press enter  ");
				String bs = input.next();
				
				if(a.matches("[A-Z]") && bs.matches("[0-9]+") ) {
					
					char abis = a.charAt(0);
					int b =Integer.parseInt(bs);
					endc1 = new Coordinate(abis, b);
					ok16=false;
				}
				else { System.out.println("Please put the correct type");}
				System.out.println("\n");
			}

			
			Ship car = new Ship(3, startc1, endc1); // same as placeShip is in the constructor
			if (car.validePosition() && startc1.validCo() && endc1.validCo()) {

				J2.addCoordinate(car);
				J2.addaShip(car);// put in the list all the coordinate of the ship
				// car.showList(); // show the list of coordinate that we just have use in the
				// different
				ok = false;
				System.out.print(J2.showMyGrille() + "\n\n");

			} else {
				System.out.println("Invalid position ! Try again ");
			}

		}

		// submarine size = 3
		ok=true;
		while (ok) {

			System.out.println("Player " + J2.getName() + " set START position of your submarine size 3 :");
			
			boolean ok15=true;
			Coordinate startc1=null;
			while(ok15) {
				System.out.print("Start with the letter in MAJ en press enter  ");
				String a = input.next();
				System.out.print("Then with the number en press enter  ");
				String bs = input.next();
				
				if(a.matches("[A-Z]") && bs.matches("[0-9]+") ) {
					
					char abis = a.charAt(0);
					int b =Integer.parseInt(bs);
					startc1 = new Coordinate(abis, b);
					ok15=false;
				}
				else { System.out.println("Please put the correct type");}
				System.out.println("\n");
			}

			System.out.println("Player " + J2.getName() + " set END position of your submarine size 3 :");
			
			boolean ok16=true;
			Coordinate endc1=null;
			while(ok16) {
				System.out.print("Start with the letter in MAJ en press enter  ");
				String a = input.next();
				System.out.print("Then with the number en press enter  ");
				String bs = input.next();
				
				if(a.matches("[A-Z]") && bs.matches("[0-9]+") ) {
					
					char abis = a.charAt(0);
					int b =Integer.parseInt(bs);
					endc1 = new Coordinate(abis, b);
					ok16=false;
				}
				else { System.out.println("Please put the correct type");}
				System.out.println("\n");
			}

			
			Ship car = new Ship(3, startc1, endc1); // same as placeShip is in the constructor
			if (car.validePosition() && startc1.validCo() && endc1.validCo()) {

				J2.addCoordinate(car);
				J2.addaShip(car);// put in the list all the coordinate of the ship
				// car.showList(); // show the list of coordinate that we just have use in the
				// different
				ok = false;
				System.out.print(J2.showMyGrille() + "\n\n");

			} else {
				System.out.println("Invalid position ! Try again ");
			}

		}

		// Destroyer size = 2
		ok=true;
		while (ok) {

			System.out.println("Player " + J2.getName() + " set START position of your destroyer size 2 :");
			
			boolean ok15=true;
			Coordinate startc1=null;
			while(ok15) {
				System.out.print("Start with the letter in MAJ en press enter  ");
				String a = input.next();
				System.out.print("Then with the number en press enter  ");
				String bs = input.next();
				
				if(a.matches("[A-Z]") && bs.matches("[0-9]+") ) {
					
					char abis = a.charAt(0);
					int b =Integer.parseInt(bs);
					startc1 = new Coordinate(abis, b);
					ok15=false;
				}
				else { System.out.println("Please put the correct type");}
				System.out.println("\n");
			}

			System.out.println("Player " + J2.getName() + " set END position of your destroyer size 2 :");
			
			boolean ok16=true;
			Coordinate endc1=null;
			while(ok16) {
				System.out.print("Start with the letter in MAJ en press enter  ");
				String a = input.next();
				System.out.print("Then with the number en press enter  ");
				String bs = input.next();
				
				if(a.matches("[A-Z]") && bs.matches("[0-9]+") ) {
					
					char abis = a.charAt(0);
					int b =Integer.parseInt(bs);
					endc1 = new Coordinate(abis, b);
					ok16=false;
				}
				else { System.out.println("Please put the correct type");}
				System.out.println("\n");
			}

			
			Ship car = new Ship(2, startc1, endc1); // same as placeShip is in the constructor
			if (car.validePosition() && startc1.validCo() && endc1.validCo()) {

				J2.addCoordinate(car);
				J2.addaShip(car);// put in the list all the coordinate of the ship
				// car.showList(); // show the list of coordinate that we just have use in the
				// different
				ok = false;
				System.out.print(J2.showMyGrille() + "\n\n");

			} else {
				System.out.println("Invalid position ! Try again ");
			}

		}
		

		// A game

		// game ends when one of the list hits == 17
		while (J1.getlistofHits().size() != 17 && J2.getlistofHits().size() != 17) {

			// try to shoot condition
			boolean ok3 = true;
			System.out.println("let start the game !!");
			while (ok3) {
				// for player 1, choose where he wants to shoot canHit
				
				System.out.println("this is where the other player shoot (x) and your boat (o) \n "
						+ J1.showMeMyShipButWhithTheHitsOfOtherPlayer(J2));
				System.out.println("Player " + J1.getName() + ", where do you want to shoot?");
				System.out.println(J1.getName() + " this is where you already shoot and missed (x) or hited (o) \n"
						+ J1.showMeMyShot());
				String c = input.next();
				char cbis = c.charAt(0);
				int d = input.nextInt();
				Coordinate shot = new Coordinate(cbis, d);

				if (J1.canHit(shot) == true && shot.validCo()) {
					// shoot

					ok3 = false;

					for (Ship s : J2.getlistShip()) {
						if (s.aShipisHit(shot)) {
							J1.addCoordListHits(shot);
							System.out.println("touched!");
							// System.out.println(J1.showMeMyShot());
							if (s.destroyed()) {
								System.out.println("you succely flow a ship!");
							}
						}
					}

					if (J2.isHit(shot) == false) {
						J1.addCoordListMiss(shot);
						System.out.println("miss!");
						// System.out.println(J1.showMeMyShot());
					}
					System.out.println("\n\n\n\n\n\n\n\n\n\n");
				} else {
					System.out.println("choose an other coordinate to shoot");
				}

			}

			if (J1.getlistofHits().size() == 17) {
				System.out.println("End of the game, player " + J1.getName() + " WIN !");
			} else {
				System.out.println("Round of player " + J2.getName() + " ");

				// same but with player 2
				boolean ok4 = true;

				while (ok4) {
					
					System.out.println("this is where the other player shoot x and your boot o \n "
							+ J2.showMeMyShipButWhithTheHitsOfOtherPlayer(J1));
					System.out.println("Player " + J2.getName() + ", where do you want to shoot?");
					System.out.println(J2.getName() + " this is where you already shoot and missed x or hited o \n"
							+ J2.showMeMyShot());
					String x = input.next();
					char xbis = x.charAt(0);
					int y = input.nextInt();
					Coordinate shot2 = new Coordinate(xbis, y);

					if (J2.canHit(shot2) && shot2.validCo()) {
						// shoot

						for (Ship s : J1.getlistShip()) {
							if (s.aShipisHit(shot2)) {
								J2.addCoordListHits(shot2);
								System.out.println("touched !" + "\n\n");
								// System.out.println(J2.showMeMyShot());
								if (s.destroyed()) {
									System.out.println("you succely flow a ship!");
								}
							}
						}
						if (J1.isHit(shot2) == false) {
							J2.addCoordListMiss(shot2);
							System.out.println("missed!");
							// System.out.println(J2.showMeMyShot());
						}

						ok4 = false;
						System.out.println("\n\n\n\n\n\n\n\n\n\n");

					}

					else {
						System.out.println("choose an other coordinate to shoot");
					}
				}
				if (J2.getlistofHits().size() == 17) {
					System.out.println("End of the game, player " + J2.getName() + " WIN !");
				}

			}

		}
	}

	
}
