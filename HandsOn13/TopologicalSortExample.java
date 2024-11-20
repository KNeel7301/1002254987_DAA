import java.util.*;

public class TopologicalSortExample {
    private int totalNodes;
    private List<Integer>[] adjacencyList;

    public TopologicalSortExample(int totalNodes) {
        this.totalNodes = totalNodes;
        adjacencyList = new ArrayList[totalNodes];
        for (int i = 0; i < totalNodes; i++) {
            adjacencyList[i] = new ArrayList<>();
        }
    }

    public void createEdge(int from, int to) {
        adjacencyList[from].add(to);
    }

    public void performTopologicalSort() {
        boolean[] isVisited = new boolean[totalNodes];
        Deque<Integer> resultStack = new ArrayDeque<>();

        for (int node = 0; node < totalNodes; node++) {
            if (!isVisited[node]) {
                exploreNode(node, isVisited, resultStack);
            }
        }

        System.out.println("Topological Order:");
        while (!resultStack.isEmpty()) {
            System.out.print((char) (resultStack.poll() + 'm') + " ");
        }
    }

    private void exploreNode(int current, boolean[] isVisited, Deque<Integer> resultStack) {
        isVisited[current] = true;

        for (int neighbor : adjacencyList[current]) {
            if (!isVisited[neighbor]) {
                exploreNode(neighbor, isVisited, resultStack);
            }
        }

        resultStack.push(current);
    }

    public static void main(String[] args) {
        TopologicalSortExample graph = new TopologicalSortExample(12); // 12 nodes (m to z)
        
        // Adding edges
        graph.createEdge(0, 4);  
        graph.createEdge(0, 5);  
        graph.createEdge(0, 9);  
        graph.createEdge(1, 4);  
        graph.createEdge(1, 6);  
        graph.createEdge(1, 2);  
        graph.createEdge(2, 5);  
        graph.createEdge(2, 7);  
        graph.createEdge(2, 10); 
        graph.createEdge(3, 2);  
        graph.createEdge(3, 7);  
        graph.createEdge(3, 11); 
        graph.createEdge(4, 8);  
        graph.createEdge(5, 6);  
        graph.createEdge(5, 10); 
        graph.createEdge(7, 5);  
        graph.createEdge(8, 9);  
        graph.createEdge(8, 10); 
        graph.createEdge(6, 10); 
        graph.createEdge(10, 11); 
        graph.createEdge(9, 11);  

        graph.performTopologicalSort();
    }
}
