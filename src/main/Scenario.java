package main;

import java.util.ArrayList;

import pyramid.Member;

/** A scenario of arrested members and the total assets recovered by the police.
 * @author Bryan J Sanchez
 */

public class Scenario {
	private int totalAssets;
	private ArrayList<Member> arrestedMembers;
	
	@SuppressWarnings("unchecked")
	public Scenario(int totalAssets, ArrayList<Member> arrestedMembers) {
		this.totalAssets = totalAssets;
		this.arrestedMembers = (ArrayList<Member>) arrestedMembers.clone();
	}
	
	public Scenario() {
		this(0, new ArrayList<Member>());
	}
}
