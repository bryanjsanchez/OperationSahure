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
}