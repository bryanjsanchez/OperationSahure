package pyramid;

import java.util.ArrayList;

/** Represents the hierarchical structure of the pyramid scheme.
 * @author Bryan J Sanchez
 */
public class PyramidNetwork {
	private String filename;
	private Member greatBoss;
	private ArrayList<Member> members;
	
	public PyramidNetwork(ArrayList<Member> members) {
		this.members = members;
		this.generatePyramid();
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
