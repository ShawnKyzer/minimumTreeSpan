package calculateMinimumTreeSpan;

/**
 *		
 *		 Minimal Network - https://projecteuler.net/problem=107 
		 Algorithm: Kruskal's algorithm
			
		 NOTE: There are several other algorithms but I chose this one since I felt it was 
		 optimal since run time is O(n Log n) where n is the total number of edges. 
			
 * 
 * @author Shawn C. Kyzer 
 *
 */

public class CreateMinNetwork {

	/**
	 * Command Line utility 
	 * @param args - filePath 
	 * 
	 * 
	 * Usage: 
	 * 
	 */
	public static void main(String[] args) {
		
		if (args.length==0){
			System.out.println("Please add file path as an argument. (ie java -jar minimumnetwork.jar /user/file/filename.txt)" );
	        System.exit(0);
		}
		
		try{
			
		GraphLoader loader = new GraphLoader();
		
		Graph graphLoader = loader.load(args[0]);
		
		MinSpanGraphGenerator generator = new MinSpanGraphGenerator();
		
		Graph minimumSpanGraph = generator.getMinimumGraph(graphLoader);

		System.out.println("Start Graph: "+ graphLoader.getTotalWeight()+" End Graph: "+minimumSpanGraph.getTotalWeight());
		System.out.println("Savings: "+(graphLoader.getTotalWeight() -minimumSpanGraph.getTotalWeight() ));
		
		}catch(Exception e){
			System.out.println("ERROR: "+ e);
		}finally{
			// close everything 
		}
	}

}
