package ants;

import lejos.hardware.motor.Motor;
import lejos.utility.Delay;

public class WarriorAnt extends AntBaseClass {

	//TODO implement recognition with color.

	/**
	 * Vigilantly Patrols ands checks for enemies.
	 */
	public void patrol() {
		// TODO I need to figure out how far one rotation will get me. Inputting
		// guess for now.
		moveForward(5000);
		turnRight();
		identifyThreat(true);
		turnLeft();
		turnLeft();
		identifyThreat(true);
		turnLeft();
		moveForward(5000);
	}

	/**
	 * Calls warDance() if the identity check fails.
	 * 
	 * @param good
	 *           For testing. Controls the reaction.
	 */
	// TODO Make this work with Color.
	public void identifyThreat(boolean good) {
		if (!good)
			warDance();
	}

	/**
	 * Ant begins a ferocious display that will definitely scare off any bad
	 * guys O_O
	 */
	public void warDance() {

		Motor.B.setSpeed(300);
		Motor.C.setSpeed(300);
		for (int i = 0; i < 3; i++) {
			Motor.B.forward();
			Motor.C.backward();
			Delay.msDelay(100);
			Motor.B.backward();
			Motor.C.forward();
			Delay.msDelay(200);
			Motor.B.forward();
			Motor.C.backward();
		}
		// sets speed back to default.
		Motor.B.setSpeed(600);
		Motor.C.setSpeed(600);
	}

}
