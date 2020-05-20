import java.util.Scanner;

//Libby Snedaker
//May 20, 2020
//Snedaker_Drone_Redo
//Simulation using button, drone movement in x,y,z location
public class Test_Drone {
	
	public static void main(String[] args) {
		
			//variable
			int menuOption = 0;
	
			//drone object
			Drone drone = new Drone();
				
			//scanner input to get info from user
			Scanner input = new Scanner(System.in);
			
			//welcome message
			System.out.println("Welcome to the drone navigation simulator. Starting out, the drone is at [x-position] = " + drone.getX() + "," + " [y-position] = " + drone.getY() + "," +
					" [z-position] = " + drone.getZ() + "," + " and its orientation = " + drone.getOrientation());
			
			//menu
			while (menuOption != 8) {
				System.out.println("Which direction would you like to move the drone?");
				System.out.println("1 - Move Up");
				System.out.println("2 - Move Down");
				System.out.println("3 - Move Forward");
				System.out.println("4 - Move Backward");
				System.out.println("5 - Turn Left");
				System.out.println("6 - Turn Right");
				System.out.println("7 - Display Position");
				System.out.println("8 - Exit Navigation");
					
				//get menu option from user
				menuOption = input.nextInt();
				input.nextLine();
						
				//move up
				if (menuOption == 1) {
					drone.moveUp();
				}		
			
				//move down
				if (menuOption == 2) {
					drone.moveDown();
				}
			
				//move forward
				if (menuOption == 3) {
					drone.moveForward();
				}
			
				//move backward
				if (menuOption == 4) {
					drone.moveBackward();
				}
			
				//turn left
				if (menuOption == 5) {
					drone.turnLeft();
				}
			
				//turn right
				if (menuOption == 6) {
					drone.turnRight();
				}
				
				//orientation method
				drone.getOrientation();
				
				//display position
				if (menuOption == 7) {
					drone.displayPos();
				}
			
				//exit navigation
				if (menuOption == 8) {
					endProgram();
				}
			}
		}
	
	//exit program method
	public static void endProgram() {
		System.out.println("Thank you for using the drone navigation.");
	}

}
