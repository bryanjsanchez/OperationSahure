package iomanager;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import pyramid.Member;

/** Class to manage input files. It should open an input.txt file which contains a list of cases to be evaluated.
 * A case consists of the network log file and the maximum number of arrests that can be made. 
 * @author Bryan J Sanchez
 */

public class InputReader {

	private String directory;

	public InputReader() {
		openFile();
	}

	/** Sets the working directory to the location where the program was run.
	 * @return file path of the input.txt file with the list of cases to be evaluated. A case consists 
	 * of the network log file and the maximum number of arrests that can be made. 
	 */
	private String openFile() {
		this.directory = System.getProperty("user.dir") + "/";
		String inputfilePath = directory + "input.txt"; 
		return inputfilePath;
	}

	/** Creates an ArrayList of Member objects with data obtained from an input file.
	 * @param filePath File path of intput file with Member data to parse.
	 * @return Returns a list of Member objects.
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public ArrayList<Member> parseMembers(String filename) {

		ArrayList<Member> members = new ArrayList<>();
		String name;
		int illegalAssets;
		String sponsorName;
		Member sponsor;

		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(this.directory + filename));
		} catch (IOException e) {
			e.printStackTrace();
		}
		String inputLine;
		try {
			while ((inputLine = reader.readLine()) != null) {
				String [] memberData = inputLine.split("#");
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
		return members;
	}

	/**
	 * @return Returns directory where files are located.
	 */
	public String getDirectory() throws IllegalStateException {
		if (directory == null) {
			throw new IllegalStateException();
		}
		return directory;
	}
}
