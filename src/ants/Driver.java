package ants;

import java.io.IOException;

import lejos.robotics.RegulatedMotor;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.navigation.Navigator;
import lejos.robotics.navigation.Waypoint;
import lejos.utility.PilotProps;

public class Driver {

	private static final int WARRIOR_DEMO = 0;
	private static final int FOOD_DEMO = 1;
	private static final int NEST_DEMO = 2;

	private static final int BAD_MODE_STATUS = 2;
	private static final int CONFIG_LOAD_FAIL = 3;

	/**
	 * Will dictate what demo we are currently running
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
		
		//Create Configuration object for pilot
        PilotProps pp = new PilotProps();
        try {
        	//Load 
            pp.loadPersistentValues();
        } catch (IOException ioe) {
            System.exit(CONFIG_LOAD_FAIL);
        }
        
        //Set configuration values for pilot try and sense otherwise fall back to defaults
        
        //Wheel diameter
        float wheelDiameter = Float.parseFloat(pp.getProperty(PilotProps.KEY_WHEELDIAMETER, "6"));;
        //Distance between wheels
        float trackWidth = Float.parseFloat(pp.getProperty(PilotProps.KEY_TRACKWIDTH, "18.0"));
        //Set motor preset
        RegulatedMotor leftMotor = PilotProps.getMotor(pp.getProperty(PilotProps.KEY_LEFTMOTOR, "B"));
        RegulatedMotor rightMotor = PilotProps.getMotor(pp.getProperty(PilotProps.KEY_RIGHTMOTOR, "C"));
        //Set true if we flip motors around 
        boolean reverse = Boolean.parseBoolean(pp.getProperty(PilotProps.KEY_REVERSE,"false"));
         
        //Create pilot object
        final DifferentialPilot robot = new DifferentialPilot(wheelDiameter,trackWidth,leftMotor,rightMotor,reverse);
        //Create Navigator class pass in pilot 
        final Navigator navigator = new Navigator(robot);

        //Add some way points for testing
		navigator.addWaypoint(new Waypoint(30, 0));
		navigator.addWaypoint(new Waypoint(30, 40));
		
		//Start along path WARNING non blocking
		navigator.followPath();
		
		do{
			//Spin wait for now 
		}while(true);
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
