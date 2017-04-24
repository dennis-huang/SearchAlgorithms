package dennis.learning.graph;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
	int numberVertices;
	Map<Integer, List<Integer>> adjacentMap;
	public Graph(int numVertex) {
		numberVertices = numVertex;
		adjacentMap = new HashMap<Integer, List<Integer>>();
	}
}
