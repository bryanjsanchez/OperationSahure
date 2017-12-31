package iomanager;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

import pyramid.Member;

/** Class to write output files.
 * @author Bryan J Sanchez
 */

public class OutputWriter {
	
	/** Static method which creates an output file listing all possible scenarios that will generate the
	 * maximum seized assets possible.
	 * @param filepath Path of the file where data is to be written.
	 * @param seizedAssets Maximum seized assets.
	 * @param listOfScenarios List of all possible scenarios. A scenario is any order in which members 
	 * were arrested that generates the maximum seized assets.
	 */
	public static void saveFile(String filepath, int seizedAssets, ArrayList<ArrayList<Member>> listOfScenarios) {
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(filepath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		writer.println("Maximum seized assets: " + seizedAssets);
		for (int i = 1; i <= listOfScenarios.size(); i++) {
			writer.print("List " + i + ": " + listOfScenarios.get(i).get(0).getName());
			for (int j = 1; j < listOfScenarios.get(i).size(); j++) {
				writer.print(", " + listOfScenarios.get(i).get(j).getName());
			}
			writer.println();
		}
		writer.close();
	}
}
