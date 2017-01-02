package roadgraph;

public class MapEdge {
	/** Locations of start and end points */
	private MapNode start;
	private MapNode end;
	
	/** The name of the road */
	private String roadName;
	
	/** The type of the road */
	private String roadType;
	
	/** The length of the road segment, in km */
	private double length;
	
	static final double DEFAULT_LENGTH = 0.01;
	
	MapEdge(MapNode n1, MapNode n2, String roadName, String roadType, double length) {
		start = n1;
		end = n2;
		this.roadName = roadName;
		this.roadType = roadType;
		this.length = length;
	}
	
	// given one node in an edge, return the other node
	MapNode getOtherNode(MapNode node)
	{
		if (node.equals(start)) 
			return end;
		else if (node.equals(end))
			return start;
		throw new IllegalArgumentException("Looking for " +"a point that is not in the edge");
	}
}
