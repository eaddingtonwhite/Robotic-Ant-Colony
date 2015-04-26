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
	 * Sets ant moving forward
	 */
	public void moveForward() {
		Motor.B.forward();
		Motor.C.forward();
	}
	
	/**
	 * Sets ant moving backwards
	 */
	public void moveBackward() {
		Motor.B.backward();
		Motor.C.backward();
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
