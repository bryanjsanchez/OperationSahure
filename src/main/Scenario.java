package main;

import java.util.ArrayList;

import pyramid.Member;

/** A scenario of arrested members and the total assets recovered from them by the police.
 * @author Bryan J Sanchez
 */

public class Scenario {
	private int recoveredAssets;
	private ArrayList<Member> arrestedMembers;
	
	/** Constructs a clone of another Scenario.
	 * @param scenario Scenario from which arrested members list is to be cloned.
	 */
	@SuppressWarnings("unchecked")
	public Scenario(Scenario scenario) {
		this.recoveredAssets = scenario.getRecoveredAssets();
		this.arrestedMembers = (ArrayList<Member>) scenario.getArrestedMembers().clone();
	}
	
	/** Creates a Scenario with zero (0) arrests.
	 */
	public Scenario() {
		this.recoveredAssets = 0;
		this.arrestedMembers = new ArrayList<>();
	}
	
	/** Increases the total recovered assets by the specified amount.
	 * @param assets Amount to add to recovered assets.
	 */
	public void incrementRecoveredAssets(int assets) {
		this.recoveredAssets += assets;
	}
	
	/**
	 * @return Returns assets recovered from this scenario.
	 */
	public int getRecoveredAssets() {
		return this.recoveredAssets;
	}
	
	/**
	 * @param member Member to be arrested.
	 */
	public void arrestMember(Member member) {
		this.arrestedMembers.add(member);
		this.recoveredAssets += member.getIllegalAssets();
	}
	
	/**
	 * @return Returns a list of members arrested in this scenario.
	 */
	public ArrayList<Member> getArrestedMembers() {
		return this.arrestedMembers;
	}
	
	/**
	 * @return Returns last member that was arrested in this scenario.
	 */
	public Member getLastArrestedMember() {
		return this.arrestedMembers.get(this.arrestedMembers.size()-1);
	}
}
