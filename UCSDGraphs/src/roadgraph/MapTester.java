package roadgraph;

import java.util.List;

import geography.GeographicPoint;
import util.GraphLoader;

public class MapTester {
	public static void main (String[] args) {
		System.out.print("Making a new map...");
		MapGraph theMap = new MapGraph();
		System.out.print("DONE. \nLoading the map...");
		
		GraphLoader.loadRoadMap("data/testdata/simpletest.map", theMap);
		
		System.out.println("DONE.");
		
		System.out.println("Num nodes: " + theMap.getNumVertices()); // should be 9
		System.out.println("Num edges: " + theMap.getNumEdges()); // should be 22
		
		List<GeographicPoint> route = theMap.bfs(new GeographicPoint(1.0, 1.0), new GeographicPoint(8.0, -1.0));
		System.out.println(route); // (1, 1) -> (4, 1) -> (7, 3) -> (8, -1)
	}
}
