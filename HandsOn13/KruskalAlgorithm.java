import java.util.*;

class Edge implements Comparable<Edge> {
    char from, to;
    int weight;

    public Edge(char from, char to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge other) {
        return Integer.compare(this.weight, other.weight);
    }
}

public class KruskalAlgorithm {
    private List<Edge> edgeList; // All edges in the graph
    private Map<Character, Character> parentMap; // Tracks the parent of each node in DSU
    private Map<Character, Integer> rankMap; // Tracks rank for DSU optimization

    public KruskalAlgorithm() {
        edgeList = new ArrayList<>();
        parentMap = new HashMap<>();
        rankMap = new HashMap<>();
    }

    public void addEdge(char from, char to, int weight) {
        edgeList.add(new Edge(from, to, weight));
        parentMap.putIfAbsent(from, from);
        parentMap.putIfAbsent(to, to);
        rankMap.putIfAbsent(from, 0);
        rankMap.putIfAbsent(to, 0);
    }

    private char findRoot(char node) {
        if (parentMap.get(node) != node) {
            parentMap.put(node, findRoot(parentMap.get(node))); // Path compression
        }
        return parentMap.get(node);
    }

    private void unionNodes(char node1, char node2) {
        char root1 = findRoot(node1);
        char root2 = findRoot(node2);

        if (root1 != root2) {
            if (rankMap.get(root1) > rankMap.get(root2)) {
                parentMap.put(root2, root1);
            } else if (rankMap.get(root1) < rankMap.get(root2)) {
                parentMap.put(root1, root2);
            } else {
                parentMap.put(root2, root1);
                rankMap.put(root1, rankMap.get(root1) + 1);
            }
        }
    }

    public void runKruskal() {
        Collections.sort(edgeList); // Sort edges by weight

        List<Edge> mst = new ArrayList<>(); // To store edges in the MST
        int totalCost = 0;

        for (Edge edge : edgeList) {
            if (findRoot(edge.from) != findRoot(edge.to)) {
                mst.add(edge);
                totalCost += edge.weight;
                unionNodes(edge.from, edge.to);
            }
        }

        // Output the MST
        System.out.println("Edges in the Minimum Spanning Tree:");
        for (Edge edge : mst) {
            System.out.println(edge.from + " - " + edge.to + " : " + edge.weight);
        }
        System.out.println("Total weight of MST: " + totalCost);
    }

    public static void main(String[] args) {
        KruskalAlgorithm graph = new KruskalAlgorithm();

        // Adding edges to the graph
        graph.addEdge('a', 'b', 4);
        graph.addEdge('a', 'h', 8);
        graph.addEdge('b', 'h', 11);
        graph.addEdge('b', 'c', 8);
        graph.addEdge('c', 'i', 2);
        graph.addEdge('c', 'f', 4);
        graph.addEdge('c', 'd', 7);
        graph.addEdge('d', 'e', 9);
        graph.addEdge('d', 'f', 14);
        graph.addEdge('e', 'f', 10);
        graph.addEdge('f', 'g', 2);
        graph.addEdge('g', 'h', 1);
        graph.addEdge('g', 'i', 6);
        graph.addEdge('h', 'i', 7);

        // Running Kruskal's algorithm to find the MST
        graph.runKruskal();
    }
}
