package main;

import java.util.ArrayList;

import iomanager.InputReader;
import pyramid.PyramidNetwork;

/** Runs simulation to determine which arrest scenarios return the maximum assets.
 * @author Bryan J Sanchez
 */

public class OperationSuhare {
	static ArrayList<PyramidNetwork> networkList = new ArrayList<>();

	public static void main(String[] args) {
		ArrayList<Case> caseList = InputReader.getCaseList();
		
		PyramidNetwork currentNetwork;
		ArrayList<Scenario> scenarioList;
		for (Case currentCase : caseList) {
			currentNetwork = getCurrentNetwork(currentCase);
			scenarioList = generateAllScenarios(currentCase, currentNetwork);
		}
	}
	
	/** Gets PyramidNetwork connected to the current case being analyzed.
	 * @param c Case to be analyzed.
	 * @param networks List of networks generated from John Doe's computer files.
	 * @return Returns PyramidNetwork connected to the case being analyzed. 
	 */
	private static PyramidNetwork getCurrentNetwork(Case currentCase) {
		PyramidNetwork currentNetwork = null;
		for (PyramidNetwork network : networkList) {
			if (network.getFilename().equals(currentCase.getFilename())) {
				currentNetwork = network;
				break;
			}
		}
		if (currentNetwork == null) {
			currentNetwork = InputReader.parseMembers(currentCase.getFilename());
			networkList.add(currentNetwork);
		}
		return currentNetwork;
	}

	private static ArrayList<Scenario> generateAllScenarios(Case currentCase, PyramidNetwork pyramidNetwork) {
		//TODO
		return null;
	}
}
