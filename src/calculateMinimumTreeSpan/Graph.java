package calculateMinimumTreeSpan;

import java.util.List;

public class Graph {
	
	private List<Edge> edges;
	

	public Graph(List<Edge> edges) {
		super();
		this.edges = edges;
	}


	public List<Edge> getEdges() {
		return edges;
	}


	public void setEdges(List<Edge> edges) {
		this.edges = edges;
	}
	

	public void addEdge(String nodeNameStart, String nodeNameEnd, int weight) {	
			
		Node nodes[] = new Node[2];
		
		nodes[0] = new Node(nodeNameStart);
		nodes[1] = new Node(nodeNameEnd);
		
		Edge newEdge = new Edge(weight, nodes);		
		
		edges.add(newEdge);
	}
	
	public void addCompleteEdge(Edge newEdge) {					
		edges.add(newEdge);
	}
	
	public int getTotalWeight(){
		
		int sum = 0; 
		
		for (Edge curEdge : edges ){
		sum = sum + curEdge.getWeight();
		}
		
		return sum;
	
		
	
	}
	
}
	
	

