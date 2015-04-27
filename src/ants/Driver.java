package ants;

public class Driver {

	private static final int WARRIOR_DEMO = 0;
	private static final int FOOD_DEMO = 1;
	private static final int NEST_DEMO = 2;

	private static final int BAD_MODE_STATUS = -1;

	public static void main(String[] args) {

		int currentMode = WARRIOR_DEMO; // Change this for different demos

		if (currentMode == WARRIOR_DEMO) {
			warriorDemo();
		} else if (currentMode == FOOD_DEMO) {
			foodDemo();
		} else if (currentMode == NEST_DEMO) {
			nestDemo();
		} else {
			System.exit(BAD_MODE_STATUS);
		}

	}

	/**
	 * Executes the demo showing how ants collect food
	 */
	private static void foodDemo() {
		// TODO Implement this
	}

	/**
	 * Executes the demo showing how ants defend their nest
	 */
	private static void warriorDemo() {
		// TODO Implement this
	}

	/**
	 * Executes the demo showing how ants find a new nest
	 */
	private static void nestDemo() {
		// TODO Implement this
	}

}
