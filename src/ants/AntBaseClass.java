package ants;

import java.util.UUID;

import lejos.hardware.motor.Motor;

public class AntBaseClass {
	
	//This ants unique id
	private UUID id;

	/**
	 * Creates a new ant object with a random UUID identifier
	 */
	public AntBaseClass(){
		
		//Generates this ants id
		this.id = UUID.randomUUID();
		
        // Set Motor speed
        Motor.B.setSpeed(600);
        Motor.C.setSpeed(600);
	}
	
	/**
	 * This will allow another ant to poll this ant and it will
	 * send back its id number.
	 */
	public UUID identify() {
		return this.id;
	}

	/**
	 * Moves ant forward moveAmmount
	 */
	public void moveForward(int moveAmmount) {
		Motor.B.rotate(moveAmmount, true);
		Motor.C.rotate(moveAmmount, true);
	}
	
	/**
	 * Moves and backwards moveAmmount
	 */
	public void moveBackward(int moveAmmount) {
		Motor.B.rotate(-moveAmmount, true);
		Motor.C.rotate(-moveAmmount, true);
	}
	
	/**
	 * Turns ant left. Locking
	 */
	public void turnLeft() {
		Motor.C.rotate(540);
	}
	
	/**
	 * Turns ant right. Locking
	 */
	public void turnRight() {
		Motor.B.rotate(540);
	}
	
	/**
	 * Stops the ant in its tracks
	 */
	public void stop(){
		Motor.B.stop();
		Motor.C.stop();
	}
}
