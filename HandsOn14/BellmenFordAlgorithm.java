import java.util.Arrays;

public class BellmenFordAlgorithm {

    // Class to represent a graph edge
    static class Route {
        int from, to, cost;

        Route(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }

    // Bellman-Ford algorithm to find shortest paths
    public static void findShortestPaths(int totalVertices, int totalEdges, Route[] routes, int start) {
        int[] minDistances = new int[totalVertices];
        int[] previousNode = new int[totalVertices];
        Arrays.fill(minDistances, Integer.MAX_VALUE);
        Arrays.fill(previousNode, -1);
        minDistances[start] = 0;

        // Relax all edges (totalVertices - 1) times
        for (int round = 1; round < totalVertices; round++) {
            for (int edge = 0; edge < totalEdges; edge++) {
                int u = routes[edge].from;
                int v = routes[edge].to;
                int weight = routes[edge].cost;

                if (minDistances[u] != Integer.MAX_VALUE && minDistances[u] + weight < minDistances[v]) {
                    minDistances[v] = minDistances[u] + weight;
                    previousNode[v] = u;
                }
            }
        }

        // Check for negative-weight cycles
        for (int edge = 0; edge < totalEdges; edge++) {
            int u = routes[edge].from;
            int v = routes[edge].to;
            int weight = routes[edge].cost;

            if (minDistances[u] != Integer.MAX_VALUE && minDistances[u] + weight < minDistances[v]) {
                System.out.println("The graph contains a negative-weight cycle.");
                return;
            }
        }

        // Display the results
        displayResults(minDistances, previousNode, start);
    }

    // Print the shortest distances and paths
    private static void displayResults(int[] distances, int[] previousNode, int source) {
        System.out.println("Vertex Distance from Source and Path:");
        for (int vertex = 0; vertex < distances.length; vertex++) {
            if (distances[vertex] == Integer.MAX_VALUE) {
                System.out.println("Vertex " + vertex + ": No path from source.");
            } else {
                System.out.print("Vertex " + vertex + " : " + distances[vertex] + " (Path: ");
                tracePath(vertex, previousNode);
                System.out.println(")");
            }
        }
    }

    // Trace and print the path recursively
    private static void tracePath(int current, int[] previousNode) {
        if (current == -1) {
            return;
        }
        tracePath(previousNode[current], previousNode);
        System.out.print(current + " ");
    }

    // Main function to test the algorithm
    public static void main(String[] args) {
        int totalVertices = 5; // Number of vertices
        int totalEdges = 10;  // Number of edges

        Route[] routes = new Route[totalEdges];

        // Define the graph with edges
        routes[0] = new Route(0, 1, 6);
        routes[1] = new Route(0, 2, 7);
        routes[2] = new Route(1, 3, 5);
        routes[3] = new Route(1, 2, 8);
        routes[4] = new Route(1, 4, -4);
        routes[5] = new Route(2, 3, -3);
        routes[6] = new Route(2, 4, 9);
        routes[7] = new Route(3, 1, -2);
        routes[8] = new Route(4, 0, 2);
        routes[9] = new Route(4, 3, 7);

        // Run the Bellman-Ford algorithm from vertex 0
        findShortestPaths(totalVertices, totalEdges, routes, 0);
    }
}
