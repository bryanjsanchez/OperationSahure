package iomanager;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import pyramid.Member;

/** Class to manage input files. It should open an input.txt file which contains a list of CSV containing Customer data to be analyzed. 
 * @author Bryan J Sanchez
 */

public class InputReader {

	private String directory;

	public InputReader() {
		openFile();
	}

	/** Sets the working directory to the location where the program was run.
	 * @return file path of the input.txt file with the list of cases to be evaluated. A case consists of
	 * the maximum number of arrests that can be made and the network log file.
	 */
	private String openFile() {
		this.directory = System.getProperty("user.dir") + "/";
		String inputfilePath = directory + "input.txt"; 
		return inputfilePath;
	}

	/** Creates an ArrayList of Customers with data obtained from a CSV file.
	 * @param filePath File path of *.csv with Customer data to parse.
	 * @return Returns a list of Customers.
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public ArrayList<Member> parseMembers(String filePath) throws NumberFormatException, IOException {

		ArrayList<Member> members = new ArrayList<>();
		String name;
		int illegalAssets;
		String sponsorName;
		Member sponsor;

		BufferedReader reader = new BufferedReader(new FileReader(filePath));
		String inputLine;
		while ((inputLine = reader.readLine()) != null) {
			String [] memberData = inputLine.split(",");
			name = memberData[0];
			illegalAssets = Integer.parseInt(memberData[1]);
			sponsor = null;
			if (memberData.length == 3) {
				sponsorName = memberData[2];
				for (Member member : members) {
					if (member.getName() == sponsorName) {
						sponsor = member;
						break;
					}
				}
			}
			members.add(new Member(name, illegalAssets, sponsor));
		}
		reader.close();
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
