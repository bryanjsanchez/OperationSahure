package pyramid;
import java.util.ArrayList;

public class Member {
	private String name;
	private int illegalAsset;
	private Member sponsor;
	private Member mentor;
	private ArrayList<Member> children;
	private boolean isArrested = false;
	
	public Member (String name, int illegalAsset, Member sponsor) {
		this.name = name;
		this.illegalAsset = illegalAsset;
		this.sponsor = sponsor;
	}

	public Member getMentor() {
		return mentor;
	}

	public void setMentor(Member mentor) {
		this.mentor = mentor;
	}

	public boolean isArrested() {
		return isArrested;
	}

	public void arrest() {
		this.isArrested = true;
	}

	public String getName() {
		return name;
	}

	public int getIllegalAsset() {
		return illegalAsset;
	}

	public Member getSponsor() {
		return sponsor;
	}

	public ArrayList<Member> getChildren() {
		return children;
	}
}