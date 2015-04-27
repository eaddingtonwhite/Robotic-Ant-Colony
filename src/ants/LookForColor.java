package ants;

import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.utility.Delay;

public class LookForColor extends Thread {
	/** The current color that the color sensor is seeing **/
	private String currentColor = "None";

	public String getCurrentColor() {
		return this.currentColor;
	}

	public void run() {

		// Set up color sensor
		@SuppressWarnings("resource")
		// Ignore scanner not closed warning
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
}