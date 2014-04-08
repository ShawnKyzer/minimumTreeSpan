package calculateMinimumTreeSpan;

// Note that we are implementing Comparable which is used in the Arrays sort (quick sort alg.) 
// and then we override comparTo so that we can sort by the weight and preserve duplicate weights etc.

public class Edge implements Comparable<Edge>{

	private Node nodes[];
	private int weight;

	public Edge(int weight, Node[] nodes) {
		super();
		this.nodes = nodes;
		this.weight = weight;
	}

	// Getters and setters for our object 
	
	/**
	 * @return the nodes
	 */
	public Node[] getNodes() {
		return nodes;
	}

	/**
	 * @return the nodes
	 */
	public Node getStartNode() {
		try {
			return nodes[0];
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	/**
	 * @return the nodes
	 */
	public Node getEndNode() {
		try {
			return nodes[1];
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @param nodes the nodes to set
	 */
	public void setNodes(Node[] nodes) {
		this.nodes = nodes;
	}

	
	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

 
	public int compareTo(Edge compareEdge) {
 
		int compareWeight = ((Edge) compareEdge).getWeight(); 
 
		return this.weight - compareWeight;  // This will return ascending order reverse for desc.

 
	}	
}