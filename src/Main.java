import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        ReadFile readFile = new ReadFile();
        ArrayList<GraphData> graphData = readFile.readFile("Graph.txt");
        int numberOfVertices = new GraphData().numberOfVertices(graphData);
        ArrayList<Integer> vertices = GraphData.uniqueVertices;
        Graph graph = new Graph();
        ArrayList<Node> nodes = graph.GraphCreation(numberOfVertices, graphData, vertices);
        graph.printGraph();
    }
}