package iomanager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

import main.Scenario;
import pyramid.Member;

/** Class to write output files with results from a certain case analysis.
 * @author Bryan J Sanchez
 */

public class OutputWriter {

	/** Static method which creates an output file listing all possible scenarios that will generate the
	 * maximum seized assets possible.
	 * @param filename Name of the file where data is to be written.
	 * @param seizedAssets Maximum seized assets for the case being analyzed.
	 * @param scenarioList List of all possible arrest scenarios that generated the maximum seized assets.
	 */
	public static void saveFile(String filename, int seizedAssets, ArrayList<Scenario> scenarioList) {
		PrintWriter writer = null;
		ArrayList<Member> currentArrestedList;
		File outputDirectory = new File("output");
		if (!outputDirectory.exists()){
			outputDirectory.mkdir(); //Creates an output directory if it does not exist.
		}
		try {
			writer = new PrintWriter(outputDirectory.getName() + "/" + filename);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		writer.println("Maximum seized assets: " + seizedAssets);
		for (int i = 0; i < scenarioList.size(); i++) {
			currentArrestedList = scenarioList.get(i).getArrestedMembers();
			writer.print("List " + (i+1) + ": " + currentArrestedList.get(0).getName());
			for (int j = 1; j < currentArrestedList.size(); j++) {
				writer.print(", " + currentArrestedList.get(j).getName());
			}
			writer.println();
		}
		writer.close();
	}

	/** Static method which creates an output file with message explaining why the simulation failed.
	 * @param filename Name of the file where data is to be written.
	 * @param message Error message to write in output file.
	 */
	public static void saveInvalidFile(String filename, String message) {
		PrintWriter writer = null;
		File outputDirectory = new File("output");
		if (!outputDirectory.exists()){
			outputDirectory.mkdir(); //Creates an output directory if it does not exist.
		}
		try {
			writer = new PrintWriter(outputDirectory.getName() + "/" + filename);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		writer.println("Maximum seized assets: 0");
		writer.println(message);
		writer.close();
	}
}
