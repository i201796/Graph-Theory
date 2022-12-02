import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    private final ReadFile readFile = new ReadFile();
    private final WriteFile writeFile = new WriteFile();
    private final ArrayList<GraphData> graphData;
    private final ArrayList<Integer> vertices;
    private final Graph udGraph = new Graph();
    private final Graph dirGraph = new Graph();

    private final Graph absGraph = new Graph();
    private final BFS_DFS_201796_200760_202308 traversal = new BFS_DFS_201796_200760_202308();
    private final ArrayList<Node> undirectedGraph;
    private final ArrayList<Node> directedGraph;

    private final ArrayList<Node> absUdGraph;

    public Menu(String fileName) {
        graphData = readFile.readFile(fileName);
        vertices = new GraphData().removeDuplicate(graphData);
        undirectedGraph = udGraph.undirectedGraph(graphData, vertices);
        directedGraph = dirGraph.directedGraph(graphData, vertices);
        absUdGraph = absGraph.undirectedGraph(graphData, vertices);
        absGraph.takeAbsOfWeight();
    }

    private void dfs(){
        boolean flag = false;
        do {
            System.out.print("\nDepth First Search\nEnter the source vertex or Enter S to skip: ");
            String source = new Scanner(System.in).next();
            if (source.equalsIgnoreCase("S")) {
                System.out.println("Depth First Search Traversal:");
                double startTime = System.nanoTime();
                traversal.dfs(undirectedGraph.get(1));
                double elapsedTime = System.nanoTime() - startTime;
                System.out.println("\nExecution Time: " + elapsedTime/1000000000 + " sec");
                Results.DFSResult += "\nExecution Time: " + elapsedTime/1000000000 + " sec";
                udGraph.makeAllNodesUnvisited();
                flag = true;
            } else {
                Node temp = udGraph.getNode(Integer.parseInt(source));
                if (temp != null) {
                    System.out.println("Depth First Search Traversal:");
                    double startTime = System.nanoTime();
                    traversal.dfs(temp);
                    double elapsedTime = System.nanoTime() - startTime;
                    System.out.println("\nExecution Time: " + elapsedTime/1000000000 + " sec");
                    Results.DFSResult += "\nExecution Time: " + elapsedTime/1000000000 + " sec";
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
                double startTime = System.nanoTime();
                traversal.bfs(undirectedGraph.get(1));
                double elapsedTime = System.nanoTime() - startTime;
                System.out.println("\nExecution Time: " + elapsedTime/1000000000 + " sec");
                Results.BFSResult += "\nExecution Time: " + elapsedTime/1000000000 + " sec";
                udGraph.makeAllNodesUnvisited();
                flag = true;
            } else {
                Node temp = udGraph.getNode(Integer.parseInt(source));
                if (temp != null) {
                    System.out.println("Breath First Search Traversal:");
                    double startTime = System.nanoTime();
                    traversal.bfs(temp);
                    double elapsedTime = System.nanoTime() - startTime;
                    Results.BFSResult += "\nExecution Time: " + elapsedTime/1000000000 + " sec";
                    System.out.println("\nExecution Time: " + elapsedTime/1000000000 + " sec");
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
                double startTime = System.nanoTime();
                dijkstra.dijkstra(absUdGraph.get(1));
                double elapsedTime = System.nanoTime() - startTime;
                dijkstra.printResult(absUdGraph);
                System.out.println("\nExecution Time: " + elapsedTime/1000000000 + " sec");
                Results.dijkstra += "\nExecution Time: " + elapsedTime/1000000000 + " sec";
                udGraph.makeAllNodesUnvisited();
                flag = true;
            } else {
                Node temp = absGraph.getNode(Integer.parseInt(source));
                if (temp != null) {
                    System.out.println("Dijkstra's Algorithm:");
                    double startTime = System.nanoTime();
                    dijkstra.dijkstra(temp);
                    double elapsedTime = System.nanoTime() - startTime;
                    dijkstra.printResult(absUdGraph);
                    System.out.println("\nExecution Time: " + elapsedTime/1000000000 + " sec");
                    Results.dijkstra += "\nExecution Time: " + elapsedTime/1000000000 + " sec";
                    flag = true;
                } else {
                    System.out.println("Invalid Source Vertex");
                }
            }
        }while (!flag);
    }

    public void bellmanFord() {
        BellmanFord_201796_200760_202308 bellmenFord = new BellmanFord_201796_200760_202308();
        boolean flag = false;
        do {
            System.out.print("\n\nBellman Ford Algorithm\nEnter the source vertex or Enter S to skip: ");
            String source = new Scanner(System.in).next();
            if (source.equalsIgnoreCase("S")) {
                System.out.println("Bellman Ford Algorithm:");
                double startTime = System.nanoTime();
                boolean flag1 = bellmenFord.bellmanFord(directedGraph, directedGraph.get(1));
                double elapsedTime = System.nanoTime() - startTime;
                if (flag1) {
                    bellmenFord.printResult(directedGraph);
                    System.out.println("\nExecution Time: " + elapsedTime/1000000000 + " sec");
                    Results.bellmanFordResult += "\nExecution Time: " + elapsedTime/1000000000 + " sec";
                    dirGraph.makeAllNodesUnvisited();
                    flag = true;
                } else {
                    System.out.println("Negative Cycle Detected");
                    System.out.println("\nExecution Time: " + elapsedTime/1000000000 + " sec");
                    Results.bellmanFordResult += "Negative Cycle Detected\nExecution Time: " + elapsedTime/1000000000 + " sec";
                    flag = true;
                }
            } else {
                Node temp = udGraph.getNode(Integer.parseInt(source));
                if (temp != null) {
                    double startTime = System.nanoTime();;
                    boolean flag1 = bellmenFord.bellmanFord(undirectedGraph, temp);
                    double elapsedTime = System.nanoTime() - startTime;
                    if (flag1) {
                        bellmenFord.printResult(undirectedGraph);
                        System.out.println("\nExecution Time: " + elapsedTime/1000000000 + " sec");
                        Results.bellmanFordResult += "\nExecution Time: " + elapsedTime/1000000000 + " sec";
                        dirGraph.makeAllNodesUnvisited();
                        flag = true;
                    } else {
                        System.out.println("Negative Cycle Detected");
                        System.out.println("\nExecution Time: " + elapsedTime/1000000000 + " sec");
                        Results.bellmanFordResult += "Negative Cycle Detected\nExecution Time: " + elapsedTime/1000000000 + " sec";
                        flag = true;
                    }
                } else {
                    System.out.println("Invalid Source Vertex");
                }
            }
        } while (!flag);
    }

    public void cycle(){
       Cycle_201796_200760_202308 cycle = new Cycle_201796_200760_202308();
        double startTime = System.nanoTime();
        boolean result = cycle.hasCycle(directedGraph.get(1));
        double elapsedTime = System.nanoTime() - startTime;
        System.out.println("\nCycle: " + result +"\n");
        System.out.println("Execution Time: " + elapsedTime/1000000000 + " sec");
        Results.cycle += "\nExecution Time: " + elapsedTime/1000000000 + " sec";
        dirGraph.makeAllNodesUnvisited();
    }
    public void diameter(){
        Diameter_201796_200760_202308 diameter = new Diameter_201796_200760_202308();
        double startTime = System.nanoTime();
        int diameterOfGraph = diameter.diameter(absUdGraph);
        double elapsedTime = System.nanoTime() - startTime;
        Results.diameterResult += "Diameter: " + diameterOfGraph;
        System.out.println("\nDiameter: " + diameterOfGraph);
        System.out.println("Execution Time: " + elapsedTime/1000000000 + " sec");
        Results.diameterResult += "\nExecution Time: " + elapsedTime/1000000000 + " sec";
        udGraph.makeAllNodesUnvisited();
    }

    public void menu() {
        int choice;
        do {
            System.out.println("\n\nPress 1 to Print the Graph(adjacency list)");
            System.out.println("Press 2 to Print DFS Traversal");
            System.out.println("Press 3 to Print BFS Traversal");
            System.out.println("Press 4 to Check if there is a Cycle");
            System.out.println("Press 5 to Print Dijkstra's Result");
            System.out.println("Press 6 to Print Bellman-Ford Result");
            System.out.println("Press 7 to Find the Diameter of the graph");
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
                   cycle();
                    writeFile.writeCycleToFile();
                }
                case 5 -> {
                    dijkstra();
                    writeFile.writeDijkstraResult();
                }
                case 6 -> {
                    bellmanFord();
                    writeFile.writeBellmanFordResult();
                }
                case 7 -> {
                    diameter();
                    writeFile.writeDiameterResult();
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
                    cycle();
                    writeFile.writeCycleToFile();
                    dijkstra();
                    writeFile.writeDijkstraResult();
                    bellmanFord();
                    writeFile.writeBellmanFordResult();
                    diameter();
                    writeFile.writeCycleToFile();
                }
                case -1 -> {
                    System.out.println("\nExiting...");
                }
                default -> {
                    System.out.println("Invalid Choice");
                }
            }
        } while (choice != -1);
    }
}
