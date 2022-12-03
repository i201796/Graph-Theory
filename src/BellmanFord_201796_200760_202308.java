import java.util.ArrayList;

public class BellmanFord_201796_200760_202308 {

    int step = 1;
    public boolean bellmanFord(ArrayList<Node> graph, Node source) {
        Results.bellmanFordResult += "Step " + step++ + ":\n Set source distance to 0\n\n";
        source.setDistance(0);

        Results.bellmanFordResult+= "Step " + step++ + ":\n Relax all edges " + (graph.size() - 1) + " times\n\n";
        for (int i = 0; i < graph.size() - 1; i++) {
            for (Node node : graph) {
                for (int k = 0; k < node.getNeighbors().size(); k++) {
                    Node neighbor = node.getNeighbors().get(k);
                    int weight = node.getWeights().get(k);
                    int distance = node.getDistance() + weight;
                    Results.bellmanFordResult += "Step " + step++ + ":\n";
                    Results.bellmanFordResult += "Relaxing edge " + node.getLabel() + " --> " + neighbor.getLabel() + "\n\n";
                    if (distance < neighbor.getDistance()) {
                        Results.bellmanFordResult += "Step " + step++ + ":\n";
                        Results.bellmanFordResult += "Distance of " + neighbor.getLabel() + " is updated to " + distance + "\n\n";
                        neighbor.setDistance(distance);
                    }
                }
            }
        }

        for (Node node : graph) {
            Results.bellmanFordResult += "Step " + step++ + ":\n";
            Results.bellmanFordResult += "Checking for negative weight cycle\n\n";
            for (int k = 0; k < node.getNeighbors().size(); k++) {
                Results.bellmanFordResult += "Step " + step++ + ":\n";
                Results.bellmanFordResult += "Relaxing edge " + node.getLabel() + " --> " + node.getNeighbors().get(k).getLabel() + "\n\n";
                Node neighbor = node.getNeighbors().get(k);
                int weight = node.getWeights().get(k);
                int distance = node.getDistance() + weight;
                Results.bellmanFordResult += "Step " + step++ + ":\n";
                Results.bellmanFordResult += "Distance of " + neighbor.getLabel() + " is updated to " + distance + "\n\n";
                if (distance < neighbor.getDistance()) {
                    Results.bellmanFordResult += "Step " + step++ + ":\n";
                    Results.bellmanFordResult += "Negative weight cycle detected\n\n";
                    return false;
                }
            }
        }
        Results.bellmanFordResult += "Step " + step++ + ":\n";
        Results.bellmanFordResult += "No negative weight cycle detected\n\n";
        return true;
    }
    public void printResult(ArrayList<Node> graph) {
        System.out.println("Bellmen-Ford:");
            for (int i = 1; i < graph.size(); i++) {
                if (graph.get(i).getDistance() == Integer.MAX_VALUE) {
                    Results.bellmanFordResult += graph.get(i).getLabel() + " is not reachable from Vertex 1\n";
                    System.out.println(graph.get(i).getLabel() + " is not reachable from Vertex 1");
                } else {
                    Results.bellmanFordResult += graph.get(i).getLabel() + " -->      " + graph.get(i).getDistance() + "\n";
                    System.out.println(graph.get(i).getLabel() + " -->      " + graph.get(i).getDistance());
                }
            }
            System.out.println();
        }

}
