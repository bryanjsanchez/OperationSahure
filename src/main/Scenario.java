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
	public Scenario(int recoveredAssets, ArrayList<Member> arrestedMembers) {
		this.recoveredAssets = recoveredAssets;
		this.arrestedMembers = (ArrayList<Member>) arrestedMembers.clone();
	}
	
	public Scenario() {
		this(0, new ArrayList<Member>());
	}
	
	public void incrementRecoveredAssets(int assets) {
		this.recoveredAssets += assets;
	}
	
	public int getRecoveredAssets() {
		return this.recoveredAssets;
	}
	
	public ArrayList<Member> getArrestedMembers() {
		return this.arrestedMembers;
	}
}
