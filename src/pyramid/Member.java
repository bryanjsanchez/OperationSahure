package pyramid;
import java.util.ArrayList;

/** Represents a member of the pyramid network.
 * @author Bryan J Sanchez
 */

public class Member {
	private String name;
	private int illegalAsset;
	private Member sponsor;
	private Member mentor;
	private ArrayList<Member> children;
	
	public Member (String name, int illegalAsset, Member sponsor) {
		this.name = name;
		this.illegalAsset = illegalAsset;
		this.sponsor = sponsor;
	}

	/**
	 * @return Returns member's mentor.
	 */
	public Member getMentor() {
		return mentor;
	}
	
	/**
	 * @param mentor Member's mentor.
	 */
	public void setMentor(Member mentor) {
		this.mentor = mentor;
	}

	/**
	 * @return Returns member's name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return Returns member's illegal asset.
	 */
	public int getIllegalAsset() {
		return illegalAsset;
	}

	/**
	 * @return Returns member's sponsor.
	 */
	public Member getSponsor() {
		return sponsor;
	}

	/**
	 * @return Returns member's children.
	 */
	public ArrayList<Member> getChildren() {
		return children;
	}
}