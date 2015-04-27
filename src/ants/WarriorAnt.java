package ants;

import java.util.UUID;

import lejos.hardware.motor.Motor;
import lejos.utility.Delay;

public class WarriorAnt extends AntBaseClass {

	// TODO Lucas this could be a way to check against if ant are friendly or
	// not after other ant indentify's itself.. Just an idea EAW
	UUID[] friendlyAnts = new UUID[3];

	/**
	 * Vigilantly Patrols ands checks for enemies.
	 */
	public void patrol() {
		Motor.B.setSpeed(300);
		Motor.C.setSpeed(300);
		// TODO Lucas how far forward do you want this to move
		// moveForward();
		turnRight();
		identifyThreat();
		turnLeft();
		turnLeft();
		identifyThreat();
		turnLeft();
		// TODO Lucas how far forward do you want this to move
		// moveForward();
	}

	/**
	 * Calls warDance() if the identity check fails.
	 */
	public void identifyThreat() {
		// TODO Dont worry about this yet Lucas im not sure how this will work
		// yet
		// Just hard code in good guy or bad guy for debugging EAW
		// if(!identify())
		// warDance();
		// }
	}

	/**
	 * Ant begins a ferocious display that will definitely scare off any bad
	 * guys O_O
	 * 
	 * TODO Check out inherited methods you can define how much to move forward
	 * instead instead of using delays here. EAW
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
	}

}
