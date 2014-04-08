package calculateMinimumTreeSpan;

public class UnitTest {

	public UnitTest() {
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// This is a plain test class it could be much better
		
		String filePath = "/Users/shawnkyzer/Documents/workspace/minimumTreeSpan/data/networkTest.txt";
		
		try{
			
		GraphLoader testLoader = new GraphLoader();
		
		Graph testGraphLoader = testLoader.load(filePath);
		
		MinSpanGraphGenerator testGenerator = new MinSpanGraphGenerator();
		
		Graph testMinimumSpanGraph = testGenerator.getMinimumGraph(testGraphLoader);

		System.out.println("Start Graph: "+ testGraphLoader.getTotalWeight()+" End Graph "+testMinimumSpanGraph.getTotalWeight());
		System.out.println("Difference: "+(testGraphLoader.getTotalWeight() -testMinimumSpanGraph.getTotalWeight() ));
		
		}catch(Exception e){
			System.out.println(e);
		}finally{
			// close everything etc. 
		}
		
	}

}
