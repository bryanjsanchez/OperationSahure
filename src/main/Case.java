package main;

/** A case consists of the network log file and the maximum number of arrests that can be made. 
 * The list of cases should be obtained from a file named input.txt.
 * @author Bryan J Sanchez
 */
public class Case {
	private int maxArrests;
	private String filename;
	
	/** Constructs a Case with specified maximum number of arrests and the input file name.
	 * @param maxArrests Maximum number of arrests that can be made by the police.
	 * @param filename Name of the file containing pyramid network data.
	 */
	public Case(int maxArrests, String filename) {
		this.maxArrests = maxArrests;
		this.filename = filename;
	}

	/**
	 * @return Returns maximum number of arrests that can be made in this case.
	 */
	public int getMaxArrests() {
		return maxArrests;
	}

	/**
	 * @return Returns the name of the file which contains pyramid network data.
	 */
	public String getFilename() {
		return filename;
	}
}
