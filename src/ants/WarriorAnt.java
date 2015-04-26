package ants;

import lejos.hardware.motor.Motor;
import lejos.utility.Delay;

public class WarriorAnt extends AntBaseClass {
	
	/**
	 * Vigilantly Patrols ands checks for enemies.
	 */
	public static void patrol(){
		Motor.B.setSpeed(300);
		Motor.C.setSpeed(300);
		//this depends on how moveForward() is implemented.
		moveForward();
		turnRight();
		identifyThreat();
		turnLeft();
		turnLeft();
		identifyThreat();
		turnLeft();
		moveForward();	
	}
	
	/**
	 * Calls wiggle() if the identity check fails.
	 */
	public static void identifyThreat(){
		if(!identify())
			wiggle();
		}
	
	/**
	 * Wiggles back and forth.
	 */
	public static void wiggle(){
		Motor.B.setSpeed(300);
		Motor.C.setSpeed(300);
		for(int i = 0;i<3;i++){
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
