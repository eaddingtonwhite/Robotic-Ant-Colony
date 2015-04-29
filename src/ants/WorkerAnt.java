package ants;

public class WorkerAnt extends AntBaseClass {

	/** Thread that monitors current color below ant **/
	LookForColor colorSensor;

	/**
	 * Creates an instance of a worker ant and starts its color sensor
	 */
	public WorkerAnt() {
		// Create color sensor thread
		colorSensor = new LookForColor();
		// Start color sensor thread
		colorSensor.start();
	}

	/**
	 * Returns what color is currently below this ant
	 * 
	 * @return the color below the ant
	 */
	public String getCurrentColor() {
		return this.colorSensor.getCurrentColor();
	}

	/**
	 * Will start the worker ant on an algorithmic search path
	 */
	public void startSearchPath() {

		// Initialize Search Path
		float currentX = 0;
		float currentY = 0;
		float baseMoveAmmount = 20;
		int currentSide = 0;

		for (int i = 0; i < 1000; i++) {

			// Check if we should increase base move amount
			if (i % 2 == 0) {
				baseMoveAmmount += 10;
			}

			// Figure out location of next way point
			switch (currentSide) {
			case 0:
				currentX += baseMoveAmmount;
				break;
			case 1:
				currentY += baseMoveAmmount;
				break;
			case 2:
				currentX -= baseMoveAmmount;
				break;
			case 3:
				currentY -= baseMoveAmmount;
				break;
			}

			// Add calculated way point
			this.addWayPoint(currentX, currentY);

			// increment side count
			currentSide++;

			// Check if we should reset current side
			if (currentSide > 3) {
				currentSide = 0;
			}
		}

		// Start Searching
		this.startNavigation();
	}

}
