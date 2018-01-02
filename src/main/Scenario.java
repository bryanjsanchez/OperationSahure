package main;

import java.util.ArrayList;

import pyramid.Member;

/** A scenario of arrested members and the total assets recovered by the police.
 * @author Bryan J Sanchez
 */

public class Scenario {
	private int recoveredAssets;
	private ArrayList<Member> arrestedMembers;
	
	@SuppressWarnings("unchecked")
	public Scenario(Scenario scenario) {
		this.recoveredAssets = scenario.getRecoveredAssets();
		this.arrestedMembers = (ArrayList<Member>) scenario.getArrestedMembers().clone();
	}
	
	public Scenario() {
		this.recoveredAssets = 0;
		this.arrestedMembers = new ArrayList<>();
	}
	
	public void incrementRecoveredAssets(int assets) {
		this.recoveredAssets += assets;
	}
	
	public int getRecoveredAssets() {
		return this.recoveredAssets;
	}
	
	public void arrestMember(Member member) {
		this.arrestedMembers.add(member);
		this.recoveredAssets += member.getIllegalAssets();
	}
	
	public ArrayList<Member> getArrestedMembers() {
		return this.arrestedMembers;
	}
	
	public Member getLastArrestedMember() {
		return this.arrestedMembers.get(this.arrestedMembers.size()-1);
	}
}
