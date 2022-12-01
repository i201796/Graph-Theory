import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    private final ReadFile readFile = new ReadFile();
    private final WriteFile writeFile = new WriteFile();
    private final ArrayList<GraphData> graphData;
    private final ArrayList<Integer> vertices;
    private final Graph udGraph = new Graph();
    private final Graph dirGraph = new Graph();
    private final BFS_DFS_201796_200760_202308 traversal = new BFS_DFS_201796_200760_202308();
    private final Cycle_201796_200760_202308 cycle = new Cycle_201796_200760_202308();
    private final ArrayList<Node> undirectedGraph;
    private final ArrayList<Node> directedGraph;

    public Menu(String fileName) {
        graphData = readFile.readFile(fileName);
        vertices = new GraphData().removeDuplicate(graphData);
        undirectedGraph = udGraph.undirectedGraph(graphData, vertices);
        directedGraph = dirGraph.directedGraph(graphData, vertices);
    }

    private void dfs(){
        boolean flag = false;
        do {
            System.out.print("\nDepth First Search\nEnter the source vertex or Enter S to skip: ");
            String source = new Scanner(System.in).next();
            if (source.equalsIgnoreCase("S")) {
                System.out.println("Depth First Search Traversal:");
                traversal.dfs(undirectedGraph.get(1));
                udGraph.makeAllNodesUnvisited();
                flag = true;
            } else {
                Node temp = udGraph.getNode(Integer.parseInt(source));
                if (temp != null) {
                    System.out.println("Depth First Search Traversal:");
                    traversal.dfs(temp);
                    udGraph.makeAllNodesUnvisited();
                    flag = true;
                } else {
                    System.out.println("Invalid Source Vertex");
                }
            }
        }while (!flag);
    }

    private void bfs(){
        boolean flag = false;
        do {
            System.out.print("\n\nBreath First Search\nEnter the source vertex or Enter S to skip: ");
            String source = new Scanner(System.in).next();
            if (source.equalsIgnoreCase("S")) {
                System.out.println("Breath First Search Traversal:");
                traversal.bfs(undirectedGraph.get(1));
                udGraph.makeAllNodesUnvisited();
                flag = true;
            } else {
                Node temp = udGraph.getNode(Integer.parseInt(source));
                if (temp != null) {
                    System.out.println("Breath First Search Traversal:");
                    traversal.bfs(temp);
                    dirGraph.makeAllNodesUnvisited();
                    flag = true;
                } else {
                    System.out.println("Invalid Source Vertex");
                }
            }
        }while (!flag);
    }

    public void dijkstra(){
        boolean flag = false;
        do {
            Dijkstra_201796_200760_202308 dijkstra = new Dijkstra_201796_200760_202308();
            System.out.print("\n\nDijkstra's Algorithm\nEnter the source vertex or Enter S to skip: ");
            String source = new Scanner(System.in).next();
            if (source.equalsIgnoreCase("S")) {
                System.out.println("Dijkstra's Algorithm:");
                dijkstra.dijkstra(undirectedGraph.get(1));
                dijkstra.printResult(undirectedGraph);
                udGraph.makeAllNodesUnvisited();
                flag = true;
            } else {
                Node temp = udGraph.getNode(Integer.parseInt(source));
                if (temp != null) {
                    System.out.println("Dijkstra's Algorithm:");
                    dijkstra.dijkstra(temp);
                    dijkstra.printResult(undirectedGraph);
                    flag = true;
                } else {
                    System.out.println("Invalid Source Vertex");
                }
            }
        }while (!flag);
    }

    public void menu() {
        int choice;
        do {
            System.out.println("\n\nPress 1 to Print the Graph(adjacency list)");
            System.out.println("Press 2 to Print DFS Traversal");
            System.out.println("Press 3 to Print BFS Traversal");
            System.out.println("Press 4 to Check if there is a Cycle");
            System.out.println("Press 5 to Print Dijkstra's Algorithm");
            System.out.println("Press 0 to Perform All the Above");
            System.out.println("Press -1 to Exit");
            System.out.print("Enter your choice: ");
            Scanner sc = new Scanner(System.in);
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.println("\nGraph:");
                    udGraph.printGraph();
                    writeFile.writeGraphToFile();
                    break;
                }
                case 2 -> {
                    dfs();
                    writeFile.writeDFSToFile();
                    break;
                }
                case 3 -> {
                    bfs();
                    writeFile.writeBFSToFile();
                    break;
                }
                case 4 -> {
                    System.out.println("\nCycle: " + cycle.hasCycle(directedGraph.get(0))+"\n");
                    dirGraph.makeAllNodesUnvisited();
                    writeFile.writeCycleToFile();

                    break;
                }
                case 5 -> {
                    dijkstra();
                    writeFile.writeDijkstraResult();
                    break;
                }
                case 0 -> {
                    System.out.println("\nGraph:");
                    dirGraph.printGraph();
                    writeFile.writeGraphToFile();
                    dfs();
                    udGraph.makeAllNodesUnvisited();
                    writeFile.writeDFSToFile();
                    bfs();
                    udGraph.makeAllNodesUnvisited();
                    writeFile.writeBFSToFile();
                    System.out.println("\nCycle: " + cycle.hasCycle(directedGraph.get(0))+"\n");
                    writeFile.writeCycleToFile();
                    dirGraph.makeAllNodesUnvisited();
                    dijkstra();
                    break;
                }
                case -1 -> {
                    System.out.println("\nExiting...");
                    break;
                }
                default -> {
                    System.out.println("Invalid Choice");
                    break;
                }
            }
        } while (choice != -1);
    }
}
