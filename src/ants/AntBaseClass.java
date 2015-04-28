package ants;

import lejos.hardware.motor.Motor;
import lejos.robotics.navigation.DifferentialPilot;


public class AntBaseClass {

	//establish a pilot
	DifferentialPilot pilot;
	

	/**
	 * Creates a new ant object.
	 */
	public AntBaseClass() {
		// Set Motor speed
		pilot.setTravelSpeed(400);
	}

	/**
	 * TODO This will allow ant to check color of recognized ant.
	 */
	//public UUID identify() {
	//	return this.id;
	//}

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
