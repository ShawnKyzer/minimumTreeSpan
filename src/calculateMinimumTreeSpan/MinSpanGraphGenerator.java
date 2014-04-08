package calculateMinimumTreeSpan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;


public class MinSpanGraphGenerator {
	
			// Minimal Network - https://projecteuler.net/problem=107 
			// Algorithm: Kruskal's algorithm
			
			// NOTE: There are several other algorithms but I chose this one since I felt it was 
			// optimal since run time is O(n Log n) where n is the total number of edges. 
			
			// Author: S. Kyzer 
	
	public static Graph getMinimumGraph(Graph originalGraph){
	
		// 1. Create Edge object to sort where the key is the edges and the value is the weight 
		// you could possibly implement a HashMap, but sorting on value and not key is not only 
		// cumbersome but really against the idea of a Map 
	
		List<Edge> edges = new ArrayList<Edge>();
 	   Graph minimumSpanGraph = new Graph(edges); // Initialize new graph to store the final output
 	   
 	   
 	   List<Edge> curEdges = originalGraph.getEdges(); // Retrieve edges from graph
 	  
	   Collections.sort(curEdges); // Lets use the built in merge sort algorithm for the object with 
	   							   // O(n Log n) run time on average which allows us to sort on weight
	   							   // in the object using comparable 
 	   
	   // Add the first edge to the graph. It won't be added twice due to the cyclical detection function 
		minimumSpanGraph.addCompleteEdge(curEdges.get(0));

		// Iterate through each of the edges starting with the smallest weight since they have been sorted
		for(Edge currentIteratedEdge: curEdges){
			
			// Next we need to identify edges that DO NOT create a cyclical relationship in the graph.
			// Once these have been identified we will then add them to the minimumGraph object
			
			if (!isCyclical(minimumSpanGraph, currentIteratedEdge)){
		//	   System.out.println("edges " + ++i + " : " + currentIteratedEdge.getStartNode().getNodeName() +":"+ currentIteratedEdge.getEndNode().getNodeName() + 
		//		", weight : " + currentIteratedEdge.getWeight());
			   minimumSpanGraph.addCompleteEdge(currentIteratedEdge);
			}
		}
		
		return minimumSpanGraph;	
		
	}
	

	public static boolean isCyclical(Graph minimumSpanGraph, Edge compEdge){

		// If node A is present and node B is present then adding the edge
		// will create a cyclical relationship. We need to check for this 
		// in order to avoid creating an additional edge. 
		
		String compNodeStart = compEdge.getStartNode().getNodeName();
		String compNodeEnd = compEdge.getEndNode().getNodeName();	
		
		// Lets create a hash map to store the value to avoid searching over duplicates later
		HashMap<String, String>  graphNodeNames= new HashMap<String, String>();

		for(Edge curEdge: minimumSpanGraph.getEdges()){			
			String nodeStart = curEdge.getStartNode().getNodeName();
			String nodeEnd = curEdge.getEndNode().getNodeName();
			graphNodeNames.put(nodeStart, "");
			graphNodeNames.put(nodeEnd, "");
		}
				
		
		if (graphNodeNames.containsKey(compNodeEnd) && graphNodeNames.containsKey(compNodeStart)){
			return true;
		}
		return false;
		
	}
}
