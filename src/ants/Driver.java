package ants;

import lejos.utility.Delay;

public class Driver {

	private static final int WARRIOR_DEMO = 0;
	private static final int FOOD_DEMO = 1;
	private static final int NEST_DEMO = 2;

	private static final int BAD_MODE_STATUS = 2;

	/**
	 * Will dictate what demo we are currently running
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		int currentMode = FOOD_DEMO; // Change this for different demos

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

		// Create food finder ant
		FoodFinderAnt foodFinder = new FoodFinderAnt();

		// Start it searching
		foodFinder.startSearchPath();

		// Start event loop
		do {
			// Check if found a good nesting site
			System.out.println(foodFinder.getCurrentColor());
			foodFinder.evauluateSiteForFood(foodFinder.getCurrentColor());

			// Delay half a second we don't need to check constantly
			Delay.msDelay(500);
		} while (true);
	}

	/**
	 * Executes the demo showing how ants find a new nest
	 */
	private static void nestDemo() {

		// Create nest finder ant
		NestFinderAnt searcherAnt = new NestFinderAnt();

		// Start it searching
		searcherAnt.startSearchPath();

		// Start event loop
		do {
			// Check if found a good nesting site
			System.out.println(searcherAnt.getCurrentColor());
			searcherAnt.evauluateNestSite(searcherAnt.getCurrentColor());

			// Delay half a second we don't need to check constantly
			Delay.msDelay(500);
		} while (true);

	}

	/**
	 * Executes the demo showing how ants defend their nest
	 */
	private static void warriorDemo() {

		// Create Warrior ant
		WarriorAnt warrior = new WarriorAnt();

		// Initialize warrior position outside of nest
		warrior.navigateToPoint(0, 50);

		// Start event loop
		do {
			// Check if warrior is done with patrol
			if (!warrior.isAntStillNavigating()) {
				// Clear path
				warrior.clearCurrentPath();

				// Commence war dance
				warrior.warDance();

				// Start patrolling again
				warrior.startPatrol();
			}

			// Delay half a second we don't need to check constantly
			Delay.msDelay(500);
		} while (true);
	}

}
