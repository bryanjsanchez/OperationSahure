package main;

/** A case consists of the network log file and the maximum number of arrests that can be made. 
 * List of cases is obtained from input.txt file.
 * @author Bryan J Sanchez
 */
public class Case {
	private int maxArrests;
	private String filename;
	
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
