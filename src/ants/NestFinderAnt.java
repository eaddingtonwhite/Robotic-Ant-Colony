package ants;

public class NestFinderAnt extends WorkerAnt {

	/**
	 * The amount of leverage this ant has in vote TODO are we going to use
	 * this? EAW
	 **/
	int influence;

	private final static String NEST_COLOR = "Green";

	/**
	 * Creates a nest finder Ant
	 */
	public NestFinderAnt() {
		super();
	}

	/**
	 * implemented as going in a straight line until we get navigator paths working.
	 */
	public void searchForNest() {
		while(!(getCurrentColor().equals(NEST_COLOR))){
			 moveForward(1000);
			}
		//makes sure reading is correct.
		evauluateNestSite();
		}

		/* We found a nest!! O_O */

		// Notify other ants to come vote
		//initiateVote();

		// Start this ants evaluation of nest
		//evauluateNestSite();

		// TODO Does ant who initially found nest make final decision or should
		// Queen? EAW
	

	/**
	 * Evaluates nest potential based on color. 
	 */
	private void evauluateNestSite() {

		if(getCurrentColor().equals(NEST_COLOR))
			votePass();
		else
			voteFail();
	}

	/**
	 * Ant communicates possible nest location to other ants
	 */
	public void sendAntSiteLocation() {
		// TODO We will probably use the navigator class here?
	}

	/**
	 * Ant asks other ants to send their rating of the nesting site
	 */
	public void initiateVote() {
		sendAntSiteLocation();
	}

	// TODO Are we going to use a rating system or yes and no votes?? EAW

	/**
	 * Ant votes that proposed location is sufficient
	 */
	public void votePass() {

	}

	/**
	 * Ant votes that proposed location is insufficient
	 */
	public void voteFail() {

	}

	/**
	 * Ants vote on the suitability of the nest location proposed by
	 * NestFinderAnt
	 */
	public void sendRating() {

	}
}
