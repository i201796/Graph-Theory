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

    private BellmanFord_201796_200760_202308 bellmenFord = new BellmanFord_201796_200760_202308();

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
                udGraph.takeAbsOfWeight();
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

    public void bellmanFord(){
        boolean flag = false;
        do {
            System.out.print("\n\nBellman Ford Algorithm\nEnter the source vertex or Enter S to skip: ");
            String source = new Scanner(System.in).next();
            if (source.equalsIgnoreCase("S")) {
                System.out.println("Bellman Ford Algorithm:");
                if (bellmenFord.bellmanFord(directedGraph, directedGraph.get(1))) {
                    bellmenFord.printResult(directedGraph);
                    dirGraph.makeAllNodesUnvisited();
                    flag = true;
                }else {
                    System.out.println("Negative Cycle Detected");
                    flag = true;
                }
            } else {
                Node temp = udGraph.getNode(Integer.parseInt(source));
                if (temp != null) {
                    if (bellmenFord.bellmanFord(undirectedGraph, temp)) {
                        bellmenFord.printResult(undirectedGraph);
                        dirGraph.makeAllNodesUnvisited();
                        flag = true;
                    }else {
                        System.out.println("Negative Cycle Detected");
                        flag = true;
                    }
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
            System.out.println("Press 6 to Print Bellman-Ford Algorithm");
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
                }
                case 2 -> {
                    dfs();
                    writeFile.writeDFSToFile();
                }
                case 3 -> {
                    bfs();
                    writeFile.writeBFSToFile();
                }
                case 4 -> {
                    System.out.println("\nCycle: " + cycle.hasCycle(directedGraph.get(0))+"\n");
                    dirGraph.makeAllNodesUnvisited();
                    writeFile.writeCycleToFile();
                }
                case 5 -> {
                    dijkstra();
                    writeFile.writeDijkstraResult();
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
                }
                case -1 -> {
                    System.out.println("\nExiting...");
                }
                case 6 -> {
                    bellmanFord();
                    writeFile.writeBellmanFordResult();
                }
                default -> {
                    System.out.println("Invalid Choice");
                }
            }
        } while (choice != -1);
    }
}
