import java.util.*;

public class Dijkstra {

    static class Edge {
        int destination, cost;

        public Edge(int destination, int cost) {
            this.destination = destination;
            this.cost = cost;
        }
    }

    static class Graph {
        int totalVertices;
        List<List<Edge>> edges;

        public Graph(int totalVertices) {
            this.totalVertices = totalVertices;
            edges = new ArrayList<>();

            for (int i = 0; i < totalVertices; i++) {
                edges.add(new ArrayList<>());
            }
        }

        public void addEdge(int from, int to, int weight) {
            edges.get(from).add(new Edge(to, weight));
        }

        public void dijkstra(int source) {
            PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(pair -> pair[1]));
            int[] shortestDistances = new int[totalVertices];
            Arrays.fill(shortestDistances, Integer.MAX_VALUE);
            shortestDistances[source] = 0;

            minHeap.add(new int[]{source, 0});

            while (!minHeap.isEmpty()) {
                int[] current = minHeap.poll();
                int currentNode = current[0];
                int distanceCovered = current[1];

                if (distanceCovered > shortestDistances[currentNode]) continue;

                for (Edge edge : edges.get(currentNode)) {
                    int nextNode = edge.destination;
                    int newDistance = distanceCovered + edge.cost;

                    if (newDistance < shortestDistances[nextNode]) {
                        shortestDistances[nextNode] = newDistance;
                        minHeap.add(new int[]{nextNode, newDistance});
                    }
                }
            }

            // Output the shortest distances
            System.out.println("Shortest paths from vertex " + source + ":");
            for (int i = 0; i < totalVertices; i++) {
                System.out.println("Vertex " + i + " -> " + (shortestDistances[i] == Integer.MAX_VALUE ? "Infinity" : shortestDistances[i]));
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(5);

        graph.addEdge(0, 1, 10);
        graph.addEdge(0, 2, 5);
        graph.addEdge(1, 2, 2);
        graph.addEdge(1, 3, 1);
        graph.addEdge(2, 1, 3);
        graph.addEdge(2, 3, 9);
        graph.addEdge(2, 4, 2);
        graph.addEdge(3, 4, 6);
        graph.addEdge(4, 0, 7);
        graph.addEdge(4, 3, 4);

        graph.dijkstra(0);
    }
}
