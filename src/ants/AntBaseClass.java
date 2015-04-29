package ants;

import java.io.IOException;
import java.util.UUID;

import lejos.hardware.motor.Motor;
import lejos.robotics.RegulatedMotor;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.navigation.Navigator;
import lejos.robotics.navigation.Waypoint;
import lejos.utility.PilotProps;

public class AntBaseClass {

	/** Create Navigation **/
	Navigator navigator;

	/** This ants unique id **/
	private UUID id;

	/** Status Codes **/
	private static final int CONFIG_LOAD_FAIL = 3;

	/**
	 * Creates a new ant object.
	 */
	public AntBaseClass() {
		// Generates this ants id
		this.id = UUID.randomUUID();
		// set up navigation
		this.initilizeNavigation();
		// set default motor speed
		Motor.B.setSpeed(500);
		Motor.C.setSpeed(500);
	}

	/**
	 * Get this ants unique ID
	 */
	public UUID identify() {
		return this.id;
	}

	/** NAVIGATION **/

	/**
	 * Initialize the navigation
	 */
	private void initilizeNavigation() {
		// Create Configuration object for pilot
		PilotProps pp = new PilotProps();
		try {
			// Load
			pp.loadPersistentValues();
		} catch (IOException ioe) {
			System.exit(CONFIG_LOAD_FAIL);
		}

		// Set configuration values for pilot try and sense otherwise fall back
		// to defaults

		// Wheel diameter
		float wheelDiameter = Float.parseFloat(pp.getProperty(
				PilotProps.KEY_WHEELDIAMETER, "6"));
		;
		// Distance between wheels
		float trackWidth = Float.parseFloat(pp.getProperty(
				PilotProps.KEY_TRACKWIDTH, "18.0"));
		// Set motor preset
		RegulatedMotor leftMotor = PilotProps.getMotor(pp.getProperty(
				PilotProps.KEY_LEFTMOTOR, "B"));
		RegulatedMotor rightMotor = PilotProps.getMotor(pp.getProperty(
				PilotProps.KEY_RIGHTMOTOR, "C"));
		// Set true if we flip motors around
		boolean reverse = Boolean.parseBoolean(pp.getProperty(
				PilotProps.KEY_REVERSE, "false"));

		// Create pilot object
		DifferentialPilot robot = new DifferentialPilot(wheelDiameter,
				trackWidth, leftMotor, rightMotor, reverse);
		// Create Navigator class pass in pilot
		this.navigator = new Navigator(robot);
	}

	/**
	 * Adds a new way point to this ants navigation queue
	 * 
	 * @param x
	 *            vertices of new way point
	 * @param y
	 *            vertices of new way point
	 */
	public void addWayPoint(float x, float y) {
		this.navigator.addWaypoint(new Waypoint(x, y));
	}

	/**
	 * Clears the current navigation list
	 */
	public void clearCurrentPath() {
		this.navigator.clearPath();
	}

	/**
	 * Will make this ant stop following navigation
	 */
	public void stopNavigation() {
		this.navigator.stop();
	}

	/**
	 * Starts navigation and will also resume navigation if previously stopped
	 * NON-BLOCKING
	 */
	public void startNavigation() {
		this.navigator.followPath();
	}

	/**
	 * Returns whether or not this ant is still on its navigation path
	 * 
	 * @return
	 */
	public boolean isAntStillNavigating() {
		return this.navigator.isMoving();
	}

	/**
	 * Tells this ant to navigate to specific point
	 * 
	 * @param x
	 *            vertices of go to point
	 * @param y
	 *            vertices of go to point
	 */
	public void navigateToPoint(float x, float y) {
		this.navigator.goTo(x, y);
	}

	/** BASIC MOVEMENT **/

	/**
	 * Moves ant forward moveAmmount
	 */
	public void moveForward(int moveAmmount) {
		Motor.B.rotate(moveAmmount, true);
		Motor.C.rotate(moveAmmount, true);
	}

	/**
	 * Moves and backwards moveAmmount
	 */
	public void moveBackward(int moveAmmount) {
		Motor.B.rotate(-moveAmmount, true);
		Motor.C.rotate(-moveAmmount, true);
	}

	/**
	 * Turns ant left. Locking
	 */
	public void turnLeft() {
		Motor.C.rotate(540);
	}

	/**
	 * Turns ant right. Locking
	 */
	public void turnRight() {
		Motor.B.rotate(540);
	}

	/**
	 * Stops the ant in its tracks
	 */
	public void stop() {
		Motor.B.stop();
		Motor.C.stop();
	}
}
