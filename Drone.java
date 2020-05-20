//Libby Snedaker
//May 20, 2020
//Snedaker_Drone_Redo
//Simulation using button, drone movement in x,y,z location

//drone class
public class Drone {
	
	//variables
	private int x = 0;
	private int y = 0;
	private int z = 0;
					
	private String droneOrientation = "North";
	private int orientationCounter = 0;

	//default class constructor
	public Drone() {
					
	}
	
	//get x coordinate method
	public int getX() {
		return x;
	}
	
	//get y coordinate method
	public int getY() {
		return y;
	}
	
	//get z coordinate method
	public int getZ() {
		return z;
	}
	
	//get orientation method
	public String getOrientation() {
		if (orientationCounter%4 == 0) {
			droneOrientation = "North";
		} else if (orientationCounter%4 == 1 || orientationCounter%4 == -3) {
			droneOrientation = "East";		
		} else if (orientationCounter%4 == 2 || orientationCounter%4 == -2) {
			droneOrientation = "South";
		} else if (orientationCounter%4 == 3 || orientationCounter%4 == -1) {
			droneOrientation = "West";
		}
		return droneOrientation;
	}
	
	//move up method
	public void moveUp() {
		System.out.println("You have moved up.");
		y++;
	}
	
	//move down method
	public void moveDown() {
		System.out.println("You have moved down.");
		y--;
	}
	
	//move forward method
	public void moveForward() {
		System.out.println("You have moved forward.");
		//first check orientation, then move accordingly
		if (orientationCounter%4 == 0) {
			droneOrientation = "North";
			z++;
		} else if (orientationCounter%4 == 1 || orientationCounter%4 == -3) {
			droneOrientation = "East";
			x++;
		} else if (orientationCounter%4 == 2 || orientationCounter%4 == -2) {
			droneOrientation = "South";
			z--;
		} else if (orientationCounter%4 == 3 || orientationCounter%4 == -1) {
			droneOrientation = "West";
			x--;
		}
	}
	
	//move backward method
	public void moveBackward() {
		System.out.println("You have moved backward.");
		//first check orientation, then move accordingly
		if (orientationCounter%4 == 0) {
			droneOrientation = "North";
			z--;
		} else if (orientationCounter%4 == 1 || orientationCounter%4 == -3) {
			droneOrientation = "East";
			x--;
		} else if (orientationCounter%4 == 2 || orientationCounter%4 == -2) {
			droneOrientation = "South";
			z++;
		} else if (orientationCounter%4 == 3 || orientationCounter%4 == -1) {
			droneOrientation = "West";
			x++;
		}
	}
	
	//turn left method
	public void turnLeft() {
		System.out.println("You have turned left.");
		//first check orientation, then turn accordingly
		orientationCounter--;
		if (orientationCounter%4 == 0) {
			droneOrientation = "North";
		} else if (orientationCounter%4 == 1 || orientationCounter%4 == -3) {
			droneOrientation = "East";
		} else if (orientationCounter%4 == 2 || orientationCounter%4 == -2) {
			droneOrientation = "South";
		} else if (orientationCounter%4 == 3 || orientationCounter%4 == -1) {
			droneOrientation = "West";
		}
	}
	
	//turn right method
	public void turnRight() {
		System.out.println("You have turned right.");
		//first check orientation, then turn accordingly
		orientationCounter++;
		if (orientationCounter%4 == 0) {
			droneOrientation = "North";
		} else if (orientationCounter%4 == 1 || orientationCounter%4 == -3) {
			droneOrientation = "East";
		} else if (orientationCounter%4 == 2 || orientationCounter%4 == -2) {
			droneOrientation = "South";
		} else if (orientationCounter%4 == 3 || orientationCounter%4 == -1) {
			droneOrientation = "West";
		}
	}
	
	//display position method
	public void displayPos() {
		System.out.println("The drone is at [x-position] = " + x + "," + " [y-position] = " + y + "," +
		" [z-position] = " + z + "," + " and its orientation = " + droneOrientation);
	}
		
}
