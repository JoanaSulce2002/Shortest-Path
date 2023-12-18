import java.util.*;

public class Node implements Comparable<Node> {
	// The name of the node
    private final String name;
    // Current distance from the start node in the Dijkstra algorithm
    private Integer distance = Integer.MAX_VALUE;
    // List to store the shortest path to this node
    List<Node> shortestPath = new LinkedList<>();
    // Map to store adjacent nodes and their corresponding edge weights
    private Map<Node, Integer> adjacentNodes = new HashMap<>();

     // Constructor to initialize the node with a name
    public Node(String name) {
        this.name = name;
    }

    // Method to add an adjacent node with a given edge weight
    public void addAdjacentNode(Node node, int weight) {
        adjacentNodes.put(node, weight);
    }

    // Comparable interface implementation based on node distance
    @Override
    public int compareTo(Node node) {
        return Integer.compare(this.distance, node.getDistance());
    }

    // toString method to provide a string representation of the node
    @Override
    public String toString() {
        return name;
    }
    // Getter method for the node's name
    public String getName() {
        return name;
    }
    // Getter method for the current distance from the start node
    public Integer getDistance() {
        return distance;
    }
    // Setter method to update the distance from the start node
    public void setDistance(Integer distance) {
        this.distance = distance;
    }
    // Public accessor method for the list representing the shortest path to this node
    public List<Node> getShortestPath() {
        return shortestPath;
    }
    // Getter method for the map of adjacent nodes and their edge weights
    public Map<Node, Integer> getAdjacentNodes() {
        return adjacentNodes;
    }
}