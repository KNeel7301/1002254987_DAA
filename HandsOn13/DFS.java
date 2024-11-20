import java.util.*;

public class DFS {
    private Map<Character, List<Character>> connections;

    public DFS() {
        connections = new HashMap<>();
    }

    // Add bidirectional link
    public void connectNodes(char node1, char node2) {
        connections.computeIfAbsent(node1, key -> new ArrayList<>()).add(node2);
        connections.computeIfAbsent(node2, key -> new ArrayList<>()).add(node1);
    }

    // Perform DFS starting from a specific node
    public void traverseGraph(char start) {
        Set<Character> explored = new HashSet<>();
        explore(start, explored);
    }

    // Helper method for DFS
    private void explore(char current, Set<Character> explored) {
        if (explored.contains(current)) return;

        System.out.print(current + " ");
        explored.add(current);

        for (char adjacent : connections.getOrDefault(current, Collections.emptyList())) {
            explore(adjacent, explored);
        }
    }

    public static void main(String[] args) {
        DFS network = new DFS();

        // Establishing connections
        network.connectNodes('a', 'b');
        network.connectNodes('a', 'h');
        network.connectNodes('b', 'c');
        network.connectNodes('b', 'h');
        network.connectNodes('c', 'd');
        network.connectNodes('c', 'i');
        network.connectNodes('c', 'f');
        network.connectNodes('d', 'e');
        network.connectNodes('d', 'f');
        network.connectNodes('e', 'f');
        network.connectNodes('f', 'g');
        network.connectNodes('g', 'h');
        network.connectNodes('g', 'i');
        network.connectNodes('h', 'i');

        System.out.println("DFS traversal starting from node 'a':");
        network.traverseGraph('a');
    }
}
