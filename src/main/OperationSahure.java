package main;

import java.util.ArrayList;

import iomanager.InputReader;
import iomanager.OutputWriter;
import pyramid.Member;
import pyramid.PyramidNetwork;

/** Runs simulation to determine which arrest scenarios return the maximum assets.
 * @author Bryan J Sanchez
 */

public class OperationSahure {

	static ArrayList<PyramidNetwork> networkList = new ArrayList<>();

	/** Program's main method. Gets list of cases and generates an output file with results for each case.
	 * @param args Command line arguments.
	 */
	public static void main(String[] args) {
		ArrayList<Case> caseList = InputReader.getCaseList();
		for (int i = 0; i < caseList.size(); i++) {
			analyzeCase(i+1, caseList.get(i));
		}
	}

	/** Analyzes a case and generates an output file containing the arrests which will lead to the maximum assets recovery.
	 * @param currentCase Case to be analyzed.
	 * @param caseNumber Number which will identify the output file for this case.
	 */
	private static void analyzeCase(int caseNumber, Case currentCase) {
		String filename = "output" + caseNumber + ".txt";
		int maxAssets = 0;
		PyramidNetwork currentNetwork = null;
		try {
			currentNetwork = getCurrentNetwork(currentCase);
		} catch (IllegalArgumentException e) {
			OutputWriter.saveInvalidFile(filename, e.getMessage());
			return;
		}
		ArrayList<Scenario> bestScenarioList = new ArrayList<>();
		if (currentCase.getMaxArrests() <= 0) {
			OutputWriter.saveInvalidFile(currentCase.getFilename(), "No arrests were made.");;
		} else {
			ArrayList<Scenario> scenarioList = generateAllScenarios(currentCase.getMaxArrests(), currentNetwork);
			for (Scenario scenario : scenarioList) {
				if (scenario.getRecoveredAssets() == maxAssets) {
					bestScenarioList.add(scenario);
				} else if (scenario.getRecoveredAssets() > maxAssets) {
					maxAssets = scenario.getRecoveredAssets();
					bestScenarioList = new ArrayList<>();
					bestScenarioList.add(scenario);
				}
			}
			OutputWriter.saveFile(filename, maxAssets, bestScenarioList);
		}
	}

	/** Gets PyramidNetwork connected to the current case being analyzed.
	 * @param currentCase Case to be analyzed.
	 * @return Returns PyramidNetwork connected to the case being analyzed. 
	 * @throws IllegalArgumentException Input file is invalid for this case.
	 */
	private static PyramidNetwork getCurrentNetwork(Case currentCase) throws IllegalArgumentException {
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

	/** Generates a list of all possible arrest scenarios.
	 * @param maxArrests Maximum number of arrests possible.
	 * @param pyramidNetwork The pyramid network related to the current case being analyzed.
	 * @return Returns a list of all possible arrest scenarios.
	 */
	private static ArrayList<Scenario> generateAllScenarios(int maxArrests, PyramidNetwork pyramidNetwork) {
		ArrayList<Scenario> scenarioList = new ArrayList<>();
		ArrayList<Scenario> tempScenarioList;
		Scenario newScenario;
		int remainingArrests = --maxArrests;
		for (Member targetZero : pyramidNetwork.getMembers()) {
			newScenario = new Scenario();
			newScenario.arrestMember(targetZero);
			tempScenarioList = new ArrayList<>();
			tempScenarioList.add(newScenario);
			scenarioList.addAll(recursiveArrest(tempScenarioList, remainingArrests));
		}
		return scenarioList;
	}

	/** Creates a new scenario for each of the possible arrests that can be made. A different scenario is created for
	 * each of the members that the last arrested member can reveal.
	 * @param scenarioList The list containing the members that have been arrested so far.
	 * @param remainingArrests The number of arrests that can still be made. 
	 * @return Returns a list with all the possible scenarios that are possible so far. 
	 */
	private static ArrayList<Scenario> recursiveArrest(ArrayList<Scenario> scenarioList, int remainingArrests) {
		if (remainingArrests == 0) {
			return scenarioList;
		} else {
			remainingArrests--;
			ArrayList<Scenario> tempScenarioList = new ArrayList<>();
			for (Scenario scenario : scenarioList) {
				Member lastArrest = scenario.getLastArrestedMember();
				ArrayList<Member> connectedMembers = new ArrayList<>();
				if (lastArrest.getSponsor() != null
						&& !scenario.getArrestedMembers().contains(lastArrest.getSponsor())
						&& !connectedMembers.contains(lastArrest.getSponsor())) {
					connectedMembers.add(lastArrest.getSponsor());
				}
				if (lastArrest.getMentor() != null
						&& !scenario.getArrestedMembers().contains(lastArrest.getMentor())
						&& !connectedMembers.contains(lastArrest.getMentor())) {
					connectedMembers.add(lastArrest.getMentor());
				}
				for (Member child : lastArrest.getChildren()) {
					if (!scenario.getArrestedMembers().contains(child)
							&& !connectedMembers.contains(child)) {
						connectedMembers.add(child);
					}
				}
				if (connectedMembers.isEmpty()) {
					tempScenarioList.add(scenario);
				} else {
					for (Member connectedMember : connectedMembers) {
						Scenario newScenario = new Scenario(scenario);
						newScenario.arrestMember(connectedMember);
						tempScenarioList.add(newScenario);
					}
				}
			}
			return recursiveArrest(tempScenarioList, remainingArrests);
		}
	}
}

