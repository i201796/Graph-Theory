import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ReadFile readFile = new ReadFile();
        ArrayList<GraphData> graphData = readFile.readFile("Graph");
     //   System.out.println(new GraphData().numberOfVertices(graphData));
        Graph graph = new Graph(new GraphData().numberOfVertices(graphData), graphData);
        System.out.println("Number of vertices: " + (graph.getNumberOfVertices()-1));
        System.out.println("Graph:");
        graph.printGraph();
        System.out.println("DFS:");
        graph.DFS(1);
        System.out.println("\nBFS:");
        graph.BFS(1);
        if (graph.isCyclic()){
            System.out.println("\nCycle Exists");
        }
        else System.out.println("\nCycle Doesnt Exists");
    }
}