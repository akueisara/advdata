package roadgraph;

import java.util.HashSet;
import java.util.Set;

import geography.GeographicPoint;

public class MapNode implements Comparable{
	/** The list of edges out of this node */
	private HashSet<MapEdge> edges;
	
	/** the latitude and longitude of this node */
	private GeographicPoint location;
	
	/** the predicted distance of this node (used in Week 3 algorithms) */
	private double distance;
	
	/** the actual distance of this node from start (used in Week 4 algorithms) */
	private double actualDistance;
	
	MapNode(GeographicPoint loc) {
		location = loc;
		edges = new HashSet<MapEdge>();
		distance = 0.0;
		actualDistance = 0.0;
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
	
	/** return the edges out of this node */
	Set<MapEdge> getEdges()
	{
		return edges;
	}
	
	// get node distance (predicted)
	public double getDistance() {
		return this.distance;
	}
	
	// set node distance (predicted)
	public void setDistance(double distance) {
	    this.distance = distance;
	}
	
	// get node distance (actual)
	public double getActualDistance() {
		return this.actualDistance;
	}
	
	// set node distance (actual)	
	public void setActualDistance(double actualDistance) {
	    this.actualDistance = actualDistance;
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
	
	/** ToString to print out a MapNode method
	 *  @return the string representation of a MapNode
	 */
	public String toString()
	{
		String toReturn = "[NODE at location (" + location + ")";
		toReturn += " intersects streets: ";
		for (MapEdge e: edges) {
			toReturn += e.getRoadName() + ", ";
		}
		toReturn += "]";
		return toReturn;
	}
	
	// Code to implement Comparable
	public int compareTo(Object o) {
		// convert to map node, may throw exception
		MapNode m = (MapNode)o; 
		return ((Double)this.getDistance()).compareTo((Double) m.getDistance());
	}
}
