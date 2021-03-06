package pyramid;

import java.util.ArrayList;

/** Represents the hierarchical structure of the pyramid scheme.
 * @author Bryan J Sanchez
 */
public class PyramidNetwork {
	private String filename;
	private Member greatBoss;
	private ArrayList<Member> members;
	
	/**Creates a new pyramid network.
	 * @param filename Name of the file containing data for this pyramid network.
	 * @param members List of members that form this pyramid network. Members on the list contain only
	 * data from input file, constructor takes care of generating remaining hierarchical relationships.
	 */
	public PyramidNetwork(String filename, ArrayList<Member> members) {
		this.filename = filename;
		this.members = members;
		generatePyramid();
	}
	
	/** Generates hierarchical relationship between members of this pyramid network. Sets mentor and children relationship.
	 */
	private void generatePyramid() {
		for (Member member : members) {
			if (member.getSponsor() == null) {
				this.greatBoss = member;
			} else {
				for (Member sponsor : members) {
					if (member.getSponsor().equals(sponsor)) {
						if (sponsor.getChildren().isEmpty()) {
							member.setMentor(sponsor);
						} else {
							member.setMentor(sponsor.getLastChild());
						}
						sponsor.addChild(member);
					}
				}
			}
		}
	}

	/**
	 * @return Returns filename which contains data used to generate this pyramid network.
	 */
	public String getFilename() {
		return filename;
	}

	/**
	 * @return Returns the network's great boss.
	 */
	public Member getGreatBoss() {
		return greatBoss;
	}

	/**
	 * @return Returns an iterable list of members of this pyramid network.
	 */
	public ArrayList<Member> getMembers() {
		return members;
	}
}
