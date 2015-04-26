package ants;

import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.robotics.SampleProvider;
import lejos.utility.Delay;

public class WorkerAnt extends AntBaseClass {

	/**
	 * Will spiral out from origin in the most efficient search pattern possible
	 */
	public void search() {

	}

	/**
	 * Will follow a found color trail to a POI
	 */
	public void followTrail() {

	}

	/**
	 * Will draw a color trail back home to POI for other ants to follow
	 */
	public void makeTrail() {

	}

}

class LookForColor implements Runnable {
	private String currentColor = "None";

	public void run() {

		// Set up color sensor
		EV3ColorSensor cs = new EV3ColorSensor(SensorPort.S3);
		
		// Start event loop
		while (true) {

			// Fetch the current color and update currentColor
			switch (cs.getColorID()) {
			case 0:
				currentColor = "None";
				break;
			case 1:
				currentColor = "Black";
				break;
			case 2:
				currentColor = "Blue";
				break;
			case 3:
				currentColor = "Green";
				break;
			case 4:
				currentColor = "Yellow";
				break;
			case 5:
				currentColor = "Red";
				break;
			case 6:
				currentColor = "White";
				break;
			case 7:
				currentColor = "Brown";
				break;
			}

			// Take reading every half second
			Delay.msDelay(500);
		}
	}

	/**
	 * Getter for the current color that the color sensor is seeing
	 * 
	 * @return String representation of what color is currently below the robot
	 */
	public String getCurrentColor() {
		return currentColor;
	}
}