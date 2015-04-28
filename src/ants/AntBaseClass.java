package ants;

import java.util.UUID;
import lejos.hardware.motor.Motor;
import lejos.robotics.navigation.DifferentialPilot;


public class AntBaseClass {

	//establish a pilot
	DifferentialPilot pilot;
	
	// This ants unique id
	private UUID id;

	/**
	 * Creates a new ant object with a random UUID identifier
	 */
	public AntBaseClass() {
		
		
		// Generates this ants id
		this.id = UUID.randomUUID();

		// Set Motor speed
		pilot.setTravelSpeed(400);
	}

	/**
	 * This will allow another ant to poll this ant and it will send back its id
	 * number.
	 */
	public UUID identify() {
		return this.id;
	}

	/**
	 * Moves ant forward moveAmmount
	 */
	public void moveForward(int moveAmount) {
		pilot.forward();
		pilot.travel(moveAmount, true);
	}

	/**
	 * Moves and backwards moveAmmount
	 */
	public void moveBackward(int moveAmount) {
		pilot.backward();
		pilot.travel(moveAmount, true);
	}

	/**
	 * Turns ant left. Locking
	 */
	public void turnLeft() {
		pilot.rotate(360);
	}

	/**
	 * Turns ant right. Locking
	 */
	public void turnRight() {
		pilot.rotate(-360);
	}

	/**
	 * Stops the ant in its tracks
	 */
	public void stop() {
		pilot.stop();
	}
}
