import java.util.Arrays;

public class FloydwarshallAlgorithm {

    private static final int INFINITY = 99999; // Represents an unreachable path

    // Main algorithm to compute shortest paths
    public static void computeShortestPaths(int[][] matrix, int nodes) {
        int[][] shortestPaths = new int[nodes][nodes];

        // Initialize the shortestPaths matrix with the given input matrix
        for (int row = 0; row < nodes; row++) {
            for (int col = 0; col < nodes; col++) {
                shortestPaths[row][col] = matrix[row][col];
            }
        }

        // Core Floyd-Warshall algorithm
        for (int intermediate = 0; intermediate < nodes; intermediate++) {
            for (int source = 0; source < nodes; source++) {
                for (int destination = 0; destination < nodes; destination++) {
                    if (shortestPaths[source][intermediate] != INFINITY &&
                        shortestPaths[intermediate][destination] != INFINITY &&
                        shortestPaths[source][intermediate] + shortestPaths[intermediate][destination] < shortestPaths[source][destination]) {
                        shortestPaths[source][destination] = shortestPaths[source][intermediate] + shortestPaths[intermediate][destination];
                    }
                }
            }
        }

        // Output the results
        displayResults(shortestPaths, nodes);
    }

    // Utility method to print the shortest paths
    private static void displayResults(int[][] distances, int nodes) {
        System.out.println("Minimum distances between every pair of nodes:");
        for (int row = 0; row < nodes; row++) {
            for (int col = 0; col < nodes; col++) {
                if (distances[row][col] == INFINITY) {
                    System.out.print("INF ");
                } else {
                    System.out.print(distances[row][col] + "   ");
                }
            }
            System.out.println();
        }
    }

    // Driver code to test the algorithm
    public static void main(String[] args) {
        int nodes = 4;

        // Input adjacency matrix representation of the graph
        int[][] graph = {
            {0, 3, INFINITY, 7},
            {8, 0, 2, INFINITY},
            {5, INFINITY, 0, 1},
            {2, INFINITY, INFINITY, 0}
        };

        computeShortestPaths(graph, nodes);
    }
}
