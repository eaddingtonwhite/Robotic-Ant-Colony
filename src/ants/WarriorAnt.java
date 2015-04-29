package ants;

import lejos.hardware.motor.Motor;
import lejos.utility.Delay;

public class WarriorAnt extends AntBaseClass {

	/**
	 * Resets this warrior ant patrol path
	 */
	private void intilizePatrolPath() {
		this.addWayPoint(50, 0);
		this.addWayPoint(-50, 0);
	}

	/**
	 * Commences this warriors patrol path
	 */
	public void startPatrol(){
		this.intilizePatrolPath();
		this.startNavigation();
	}
	
	/**
	 * Ant begins a ferocious display that will definitely scare off any bad
	 * guys O_O
	 */
	public void warDance() {
		//Stop Navigation and clear path
		this.stopNavigation();
		this.clearCurrentPath();
		
		//Commence the dance
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
		Motor.B.setSpeed(500);
		Motor.C.setSpeed(500);
	}

}
