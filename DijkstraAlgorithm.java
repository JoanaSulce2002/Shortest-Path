import java.util.*;

public class DijkstraAlgorithm {
    // Dijkstra's algorithm to find the shortest path from a start node to all other
    // nodes
    public static void dijkstra(Node startNode) {

        // Priority queue to store nodes based on their distances
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();

        // Initialize the distance of the start node to be 0
        startNode.setDistance(0);

        // Add the start node to the priority queue
        priorityQueue.add(startNode);

        while (!priorityQueue.isEmpty()) {
            // Retrieve the node with the smallest distance from the priority queue
            Node currentNode = priorityQueue.poll();

            // Explore adjacent nodes and update their distances if a shorter path is found
            for (Map.Entry<Node, Integer> entry : currentNode.getAdjacentNodes().entrySet()) {
                Node adjacentNode = entry.getKey();
                int edgeWeight = entry.getValue();
                int newDistance = currentNode.getDistance() + edgeWeight;

                // If a shorter path is found, update the distance and path
                if (newDistance < adjacentNode.getDistance()) {
                    priorityQueue.remove(adjacentNode);
                    adjacentNode.setDistance(newDistance);

                    // Create a new path by copying the shortest path of the current node
                    List<Node> newPath = new LinkedList<>(currentNode.getShortestPath());
                    newPath.add(currentNode);
                    // Update the shortest path of the adjacent node
                    adjacentNode.shortestPath = newPath;
                    // Add the updated adjacent node to the priority queue
                    priorityQueue.add(adjacentNode);
                }
            }
        }
    }

    // Main method for testing Dijkstra's algorithm
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Graph graph = new Graph();

            // User input: number of nodes in the graph
            System.out.print("Enter the number of nodes in the graph: ");
            int numNodes = scanner.nextInt();

            // User input: create nodes and add them to the graph
            for (int i = 0; i < numNodes; i++) {
                System.out.print("Enter the name of node " + (i + 1) + ": ");
                String nodeName = scanner.next();
                graph.addNode(nodeName);
            }

            // User input: create edges between nodes and add them to the graph
            System.out.println("Enter the edges (format: node1 node2 weight), one per line. Enter 'done' to finish.");

            while (true) {
                String input = scanner.nextLine().trim();
                if (input.equals("done")) {
                    break;
                }

                String[] parts = input.split(" ");
                if (parts.length != 3) {
                    System.out.println("Invalid input. Please enter edges in the correct format.");
                    continue;
                }

                String nodeName1 = parts[0];
                String nodeName2 = parts[1];
                int weight;

                try {
                    weight = Integer.parseInt(parts[2]);

                    // Check if the weight is negative
                    if (weight < 0) {
                        System.out.println("Invalid weight. Please enter a non-negative integer.");
                        continue;
                    }

                } catch (NumberFormatException e) {
                    System.out.println("Invalid weight. Please enter a valid integer.");
                    continue;
                }

                graph.addEdge(nodeName1, nodeName2, weight);
            }

            System.out.print("Enter the starting node: ");
            String startNodeName = scanner.next();
            Node startNode = graph.getNode(startNodeName);

            // Run Dijkstra's algorithm from the chosen starting node
            dijkstra(startNode);

            System.out.print("Enter the destination node: ");
            String destinationNodeName = scanner.next();
            Node destinationNode = graph.getNode(destinationNodeName);

            // Display the shortest path and distance from the start to the destination node
            System.out.println("Shortest path from " + startNodeName + " to " + destinationNodeName + ": "
                    + destinationNode.getShortestPath());
            System.out.println("Shortest distance from " + startNodeName + " to " + destinationNodeName + ": "
                    + destinationNode.getDistance());
        }
    }
}
