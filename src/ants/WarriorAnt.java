package ants;

import java.util.UUID;

import lejos.hardware.motor.Motor;
import lejos.utility.Delay;

public class WarriorAnt extends AntBaseClass {

	// TODO Lucas this could be a way to check against if ant are friendly or
	// not after other ant indentify's itself.. Just an idea EAW
	
	//This is a good idea. How would I know the friendly ant's UUID?
	UUID[] friendlyAnts = new UUID[3];

	/**
	 * Vigilantly Patrols ands checks for enemies.
	 */
	public void patrol() {
		// TODO I need to figure out how far one rotation will get me. Inputting guess for now.
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
	 * @param For testing. Controls the reaction.
	 */
	//TODO Make this work with UUID.
	public void identifyThreat(boolean good) {
		if(!good)
			warDance();	
	}

	/**
	 * Ant begins a ferocious display that will definitely scare off any bad
	 * guys O_O
	 */
	/*
	 TODO If the delays are problematic I can create some methods in Base that
	  turn only one wheel a certain amount. For now, I don't want the ants actually be
	  in a different spot than when the dance started so I can't use the current methods
	  as they will move both wheels. 
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
		//sets speed back to default. 
		Motor.B.setSpeed(600);
		Motor.C.setSpeed(600);
	}

}
