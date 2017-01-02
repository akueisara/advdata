package roadgraph;

import java.util.HashSet;
import java.util.Set;

import geography.GeographicPoint;

public class MapNode{
	/** The list of edges out of this node */
	private HashSet<MapEdge> edges;
	
	/** the latitude and longitude of this node */
	private GeographicPoint location;
	
	/** the predicted distance of this node (used in Week 3 algorithms) */
	private double distance;
	
	MapNode(GeographicPoint loc) {
		location = loc;
		edges = new HashSet<MapEdge>();
		distance = 0.0;
	}
	
	public void addEdge(MapEdge edge)
	{
		edges.add(edge);
	}
	
	/** Return the neighbors of this MapNode */
	public Set<MapNode> getNeighbors()
	{
		Set<MapNode> neighbors = new HashSet<MapNode>();
		for (MapEdge edge : edges) {
			neighbors.add(edge.getOtherNode(this));
		}
		return neighbors;
	}
	
	/** get the location of a node */
	public GeographicPoint getLocation()
	{
		return location;
	}
	
	// get node distance (predicted)
	public double getDistance() {
		return this.distance;
	}
	
	/** Returns whether two nodes are equal.
	 * Nodes are considered equal if their locations are the same, 
	 * even if their street list is different.
	 */
	public boolean equals(Object o)
	{
		if (!(o instanceof MapNode) || (o == null)) {
			return false;
		}
		MapNode node = (MapNode)o;
		return node.location.equals(this.location);
	}
}
