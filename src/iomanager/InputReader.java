package iomanager;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import main.Case;
import pyramid.Member;
import pyramid.PyramidNetwork;

/** Class to manage input files. It should open an input.txt file which contains a list of cases to be evaluated.
 * A case consists of the network log file and the maximum number of arrests that can be made. 
 * @author Bryan J Sanchez
 */

public class InputReader {
	
	/** Creates an ArrayList of Case objects with data obtained from input.txt file.
	 * @return Return list of cases to be analyzed in Operation Suhare.
	 */
	public static ArrayList<Case> getCaseList() {
		ArrayList<Case> caseList = new ArrayList<>();
		BufferedReader reader = null;
		String caseLine;
		int maxArrests;
		String filename;
		String[] caseData;
		try {
			reader = new BufferedReader(new FileReader(getDirectory() + "input.txt"));
			while ((caseLine = reader.readLine()) != null) {
				caseData = caseLine.split(" ");
				maxArrests = Integer.parseInt(caseData[0]);
				filename = caseData[1];
				caseList.add(new Case(maxArrests, filename));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return caseList;
	}
	
	/** Creates an ArrayList of Member objects with data obtained from an input file.
	 * @param filePath File path of input file with Member data to parse.
	 * @return Returns a list of Member objects.
	 */
	public static PyramidNetwork parseMembers(String filename) {
		ArrayList<Member> members = new ArrayList<>();
		String name;
		int illegalAssets;
		String sponsorName;
		Member sponsor;
		String inputLine;
		String [] memberData;
		BufferedReader reader = null;
		
		try {
			reader = new BufferedReader(new FileReader(getDirectory() + filename));
			while ((inputLine = reader.readLine()) != null) {
				memberData = inputLine.split("#");
				name = memberData[0];
				illegalAssets = Integer.parseInt(memberData[1]);
				sponsor = null;
				if (memberData.length == 3) {
					sponsorName = memberData[2];
					for (Member member : members) {
						if (member.getName().equals(sponsorName)) {
							sponsor = member;
							break;
						}
					}
				}
				members.add(new Member(name, illegalAssets, sponsor));
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new PyramidNetwork(filename, members);
	}

	/**
	 * @return Returns directory where files are located.
	 */
	public static String getDirectory() {
		return System.getProperty("user.dir") + "/";
	}
}
