package calculateMinimumTreeSpan;

public class Node {

	private String nodeName = ""; // I used string in case the user may want to use the classic alpha node
	// references at a later date. 

	private boolean visited;


	public Node(String nodeName) {
		super();
		this.nodeName = nodeName;
	}

	/**
	 * @return the nodeName
	 */
	public String getNodeName() {
		return nodeName;
	}

	/**
	 * @param nodeName the nodeName to set
	 */
	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}


}





