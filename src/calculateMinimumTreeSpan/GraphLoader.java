package calculateMinimumTreeSpan;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class GraphLoader {
	
	private static String EMPTYCELL = "-";

    private static String DELIMITER = ","; // Ideally these would go in some XML 
    									  // config file or a .prop file 
    
    
    public GraphLoader() throws IOException {
    	
    	
    }
    
       public Graph load(String filePath) throws IOException {
    	   
    	   List<Edge> edges = new ArrayList<Edge>();
    	   Graph importedGraph = new Graph(edges); 
    	   	
    	    RandomAccessFile aFile = new RandomAccessFile
                    (filePath, "r"); // This is for read only 
            FileChannel inChannel = aFile.getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(2000); // Lets only allocate what we need for a single line. Since we may be dealing with 
                                                           // enormous files located in a distributed environment. 
            while(inChannel.read(buffer) > 0)
            {
                buffer.flip();
                
                StringBuilder sb = new StringBuilder();
                
                int curXPos = 1; // Node A -  Column number 
                int curYPos = 1; // Node B -  Line number 
                
                String curWeightToken;
                
                for (int i = 0; i < buffer.limit(); i++)
                {
                    char curCharacter = (char) buffer.get(); // gets char and increments by two 

                    if (curCharacter == '\n'){
                       // System.out.println("Line: "+sb.toString()+ "\n");
                        
                        StringTokenizer st = new StringTokenizer(sb.toString());
                        
                        while (st.hasMoreTokens()) {
                            curWeightToken = st.nextToken(DELIMITER);
                            if (!curWeightToken.startsWith(EMPTYCELL)){
                            	     // Had to add this check point reluctantly due to the matrix format they used 
                            	     if (!edgeExists(importedGraph,curXPos,curYPos)){
                                	// System.out.println("Edge: "+" Node A: "+ curXPos + " Node B: "+curYPos+ " Weight: "+curWeightToken + "\n");
                            	     importedGraph.addEdge(Integer.toString(curXPos), Integer.toString(curYPos), Integer.parseInt(curWeightToken));
                            	     }
                            }
                            curXPos++;
                        }
                        sb.delete(0, sb.length()); // clear out the strbuilder for a new line
                        curXPos = 1; // reset 
                        curYPos++;  // increment next line
                    }else {
                    sb.append(curCharacter);     
                    }

                }

                buffer.clear(); // clear out buffer to avoid overload in JVM memory  
            }
            inChannel.close();
            aFile.close();
			return importedGraph;
        }

	private boolean edgeExists(Graph importedGraph, int curXPos, int curYPos) {
		for (Edge curEdge : importedGraph.getEdges()){
			// check for inverse
			if ( (Integer.parseInt(curEdge.getStartNode().getNodeName()) == curYPos) && (Integer.parseInt(curEdge.getEndNode().getNodeName()) == curXPos)){
				return true;
			}
		}
		return false;
		

	}
		
	}


