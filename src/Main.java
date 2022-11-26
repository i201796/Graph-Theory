import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void run(){
        ReadFile readFile = new ReadFile();
        ArrayList<GraphData> graphData = readFile.readFile("soc-sign-bitcoinalpha.csv");
        ArrayList<Integer> vertices = new GraphData().removeDuplicate(graphData);
        Graph graph = new Graph();
        BFS_DFS_201796_200760_202308 traversal = new BFS_DFS_201796_200760_202308();
        Cycle_201796_200760_202308 cycle = new Cycle_201796_200760_202308();
        ArrayList<Node> nodes = graph.undirectedGraph(graphData, vertices);

        System.out.println("Graph (Adjacency List):");
        graph.printGraph();

        System.out.println("DFS:");
        traversal.dfs(nodes.get(1));

        graph.makeAllNodesUnvisited();
        System.out.println("\nBFS:");
        traversal.bfs(nodes.get(1));

        Graph obj = new Graph();
        ArrayList<Node> directedGraph = obj.directedGraph(graphData,vertices);
        System.out.println("\nCycle: " + cycle.hasCycle(directedGraph.get(1)) + "\n"+ Results.cycle);

        writeToFile();
    }

    public static void writeToFile(){
        WriteFile.writeGraphToFile();
        WriteFile.writeDFSToFile();
        WriteFile.writeBFSToFile();
        WriteFile.writeCycleToFile();
    }
    public static void main(String[] args) throws IOException {
        run();
    }
}