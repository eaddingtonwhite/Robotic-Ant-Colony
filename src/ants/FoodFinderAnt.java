package ants;

public class FoodFinderAnt extends WorkerAnt {

	private final static String FOOD_COLOR = "Red";

	public FoodFinderAnt() {
		super();
	}

	//TODO make this work in a way similar to find nest. 
	public void searchForFood() {
		// Starting move forward amount
		int baselength = 500;
		int i = 1;
		int count = 0;
		while (getCurrentColor() != FOOD_COLOR) {
			// Move forward
			moveForward(baselength * i);
			// Turn
			turnRight();
			count++;
			if (count % 2 == 0) {
				i *= 2;
			}
		}

		// TODO Jessie What do we do once we have found food!?!? eat it..?
		// Return Home? Die and go to heaven? Do victory dance?
	}

}
