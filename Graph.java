import java.util.*;

public class Graph {
	// Map to store nodes in the graph, where node names are the keys
    private Map<String, Node> nodeMap = new HashMap<>();
 // Method to add a new node to the graph
    public void addNode(String nodeName) {
        Node node = new Node(nodeName);
        nodeMap.put(nodeName, node);
    }
 // Method to add an edge between two nodes with a given weight
    public void addEdge(String nodeName1, String nodeName2, int weight) {
        Node node1 = nodeMap.get(nodeName1);
        Node node2 = nodeMap.get(nodeName2);
     // Check if both nodes exist
        if (node1 != null && node2 != null) {
        	// Add an edge between the nodes with the specified weight
            node1.addAdjacentNode(node2, weight);
            node2.addAdjacentNode(node1, weight);
        } else {
        	// Print an error message if one or both nodes do not exist
            System.out.println("Invalid node names. Please enter valid node names.");
        }
    }
 // Method to retrieve a node from the graph based on its name
    public Node getNode(String nodeName) {
        return nodeMap.get(nodeName);
    }
 // Getter method for the entire node map
    public Map<String, Node> getNodeMap() {
        return nodeMap;
    }
}