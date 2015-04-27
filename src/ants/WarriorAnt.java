package ants;

import lejos.hardware.motor.Motor;
import lejos.utility.Delay;

public class WarriorAnt extends AntBaseClass {
	
	/**
	 * Vigilantly Patrols ands checks for enemies.
	 */
	public void patrol(){
		Motor.B.setSpeed(300);
		Motor.C.setSpeed(300);
		//TODO Lucas how far forward do you want this to move
//		moveForward();
		turnRight();
		identifyThreat();
		turnLeft();
		turnLeft();
		identifyThreat();
		turnLeft();
		//TODO Lucas how far forward do you want this to move
//		moveForward();	
	}
	
	/**
	 * Calls wiggle() if the identity check fails.
	 */
	public void identifyThreat(){
		//TODO Dont worry about this yet Lucas im not sure how this will work yet
		//Just hard code in good guy or bad guy for debugging EAW
//		if(!identify())
//			warDance();
//		}
	}
	
	/**
	 * Ant begins a ferocious display that will definitely scare off any bad guys O_O
	 * 
	 * TODO Check out inherited methods you can define how much to move forward instead
	 * instead of using delays here. EAW
	 */
	public void warDance(){
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
