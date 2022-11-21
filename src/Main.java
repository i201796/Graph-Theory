import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        ReadFile readFile = new ReadFile();
        ArrayList<GraphData> graphData = readFile.readFile("Graph.txt");
        ArrayList<Integer> vertices = new GraphData().removeDuplicate(graphData);
        Graph graph = new Graph();
        ArrayList<Node> nodes = graph.GraphCreation(graphData, vertices);

        System.out.println("Graph (Adjacency List):");
        graph.printGraph();

        System.out.println("DFS:");
        graph.dfs(nodes.get(1));

    }
}