package tests;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import iomanager.InputReader;
import pyramid.Member;
import pyramid.PyramidNetwork;

public class PyramidNetworkTest {
	public InputReader reader = new InputReader();
	public ArrayList<Member> members = reader.parseMembers("log1.txt");
	public PyramidNetwork pyramidNetwork = new PyramidNetwork(members);
	public Member liam = pyramidNetwork.getGreatBoss();
	public Member emma = liam.getChild(0);
	public Member jacob = liam.getLastChild();
	public Member mason = emma.getChild(0);
	public Member sophia = emma.getChild(1);
	public Member olivia = emma.getLastChild();
	public Member william = jacob.getChild(0);
	public Member ethan = jacob.getLastChild();
	public Member james = william.getChild(0);
	public Member alexander = james.getChild(0);
	
	@Test
	public void membersTest() {
		assertEquals(members.size(), 10);
	}

	@Test
	public void liamTest() {
		assertEquals(liam.getSponsor(), null);
		assertEquals(liam.getMentor(), null);
		assertEquals(liam.getName(), "Liam");
		assertEquals(liam.getIllegalAssets(), 20);
	}
	
	@Test
	public void emmaTest() {
		assertEquals(emma.getSponsor(), liam);
		assertEquals(emma.getMentor(), liam);
		assertEquals(emma.getName(), "Emma");
		assertEquals(emma.getIllegalAssets(), 42);
	}
	
	@Test
	public void jacobTest() {
		assertEquals(jacob.getSponsor(), liam);
		assertEquals(jacob.getMentor(), emma);
		assertEquals(jacob.getName(), "Jacob");
		assertEquals(jacob.getIllegalAssets(), 50);
	}
	
	@Test
	public void masonTest() {
		assertEquals(mason.getSponsor(), emma);
		assertEquals(mason.getMentor(), emma);
		assertEquals(mason.getName(), "Mason");
		assertEquals(mason.getIllegalAssets(), 14);
	}
	
	@Test
	public void sophiaTest() {
		assertEquals(sophia.getSponsor(), emma);
		assertEquals(sophia.getMentor(), mason);
		assertEquals(sophia.getName(), "Sophia");
		assertEquals(sophia.getIllegalAssets(), 5);
	}
	
	@Test 
	public void oliviaTest() {
		assertEquals(olivia.getSponsor(), emma);
		assertEquals(olivia.getMentor(), sophia);
		assertEquals(olivia.getName(), "Olivia");
		assertEquals(olivia.getIllegalAssets(), 8);
	}
	
	@Test 
	public void williamTest() {
		assertEquals(william.getSponsor(), jacob);
		assertEquals(william .getMentor(), jacob);
		assertEquals(william.getName(), "William");
		assertEquals(william.getIllegalAssets(), 42);
	}
	
	@Test
	public void ethanTest() {
		assertEquals(ethan.getSponsor(), jacob);
		assertEquals(ethan.getMentor(), william);
		assertEquals(ethan.getName(), "Ethan");
		assertEquals(ethan.getIllegalAssets(), 5);
	}
	
	@Test
	public void jamesTest() {
		assertEquals(james.getSponsor(), william);
		assertEquals(james.getMentor(), william);
		assertEquals(james.getName(), "James");
		assertEquals(james.getIllegalAssets(), 10);
	}
	
	@Test
	public void alexanderTest() {
		assertEquals(alexander.getSponsor(), james);
		assertEquals(alexander.getMentor(), james);
		assertEquals(alexander.getName(), "Alexander");
		assertEquals(alexander.getIllegalAssets(), 60);
	}

}
