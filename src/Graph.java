import java.util.ArrayList;

public class Graph {
    ArrayList<ArrayList<Integer>> graph;
    private int numberOfVertices;

    public ArrayList<ArrayList<Integer>> getGraph() {
        return graph;
    }

    public void setGraph(ArrayList<ArrayList<Integer>> graph) {
        this.graph = graph;
    }
    public int getNumberOfVertices() {
        return numberOfVertices;
    }

    public Graph(int numberOfVertices, ArrayList<GraphData> graphData) {
        this.numberOfVertices = numberOfVertices+1;
        this.graph = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < numberOfVertices+1; i++) {
            this.graph.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < graphData.size(); i++) {
            addEdge(graphData.get(i).getSource(), graphData.get(i).getDestination());
        }
    }

    private void addEdge(int source, int destination) {
        this.graph.get(source).add(destination);
    }

    public void printGraph() {
        for (int i = 1; i < this.numberOfVertices; i++) {
            System.out.print(i + " -> ");
            for (int j = 0; j < this.graph.get(i).size(); j++) {
                System.out.print(this.graph.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
    public void DFS(int source) {
        boolean[] visited = new boolean[this.numberOfVertices];
        DFSVisit(source, visited);
    }
    private void DFSVisit(int source, boolean[] visited) {
        visited[source] = true;
        System.out.print(source + " ");
        for (int i = 0; i < this.graph.get(source).size(); i++) {
            if (!visited[this.graph.get(source).get(i)]) {
                DFSVisit(this.graph.get(source).get(i), visited);
            }
        }
    }

    public void BFS(int source) {
        boolean[] visited = new boolean[this.numberOfVertices];
        ArrayList<Integer> queue = new ArrayList<Integer>();
        queue.add(source);
        visited[source] = true;
        while (!queue.isEmpty()) {
            int current = queue.remove(0);
            System.out.print(current + " ");
            for (int i = 0; i < this.graph.get(current).size(); i++) {
                if (!visited[this.graph.get(current).get(i)]) {
                    queue.add(this.graph.get(current).get(i));
                    visited[this.graph.get(current).get(i)] = true;
                }
            }
        }
    }

    public boolean isCyclic() {
        boolean[] visited = new boolean[this.numberOfVertices];
        boolean[] recStack = new boolean[this.numberOfVertices];
        for (int i = 1; i < this.numberOfVertices; i++) {
            if (isCyclicUtil(i, visited, recStack)) {
                return true;
            }
        }
        return false;
    }
    private boolean isCyclicUtil(int source, boolean[] visited, boolean[] recStack) {
        if (recStack[source]) {
            return true;
        }
        if (visited[source]) {
            return false;
        }
        visited[source] = true;
        recStack[source] = true;
        for (int i = 0; i < this.graph.get(source).size(); i++) {
            if (isCyclicUtil(this.graph.get(source).get(i), visited, recStack)) {
                return true;
            }
        }
        recStack[source] = false;
        return false;
    }
}
