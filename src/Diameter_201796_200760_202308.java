import java.util.ArrayList;

public class Diameter_201796_200760_202308 {

    int step = 1;

    public int diameter(ArrayList<Node> graph) {
        int diameter = 0;
        Results.diameterTrace += "Iterate the graph and find the longest path from each node to the rest of the nodes\n\n";
        for (int i = 1; i < graph.size(); i++) {
            Results.diameterTrace += "Step " + step++ + ":\n";
            int max = 0;
            Results.diameterTrace += "Find the longest path from " + graph.get(i).getLabel() + " to the rest of the nodes\n\n";
            for (int j = 1; j < graph.size(); j++) {
                Results.diameterTrace += "Step " + step++ + ":\n";
                Results.diameterTrace += "Find the shortest path from " + graph.get(i).getLabel() + " to " + graph.get(j).getLabel() + "\n\n";
                if (i != j) {
                    Results.diameterTrace += "Step " + step++ + ":\n";
                    Results.diameterTrace += "Run Dijkstra's algorithm to find the shortest path from " + graph.get(i).getLabel() + " to " + graph.get(j).getLabel() + "\n\n";
                    int distance = shortestPath(graph.get(i), graph.get(j));
                    if (distance > max) {
                        Results.diameterTrace += "Step " + step++ + ":\n";
                        Results.diameterTrace += "The distance from " + graph.get(i).getLabel() + " to " + graph.get(j).getLabel() + " is greater than the current maximum distance\n\n";
                        max = distance;
                        Results.diameterTrace += "Step " + step++ + ":\n";
                        Results.diameterTrace += "Set the maximum distance to " + max + "\n\n";
                    }
                }
            }
            if (max > diameter) {
                diameter = max;
                Results.diameterTrace += "Step " + step++ + ":\n";
                Results.diameterTrace += "The maximum distance from " + graph.get(i).getLabel() + " to the rest of the nodes is greater than the current diameter\n\n";
                Results.diameterTrace += "Step " + step++ + ":\n";
                Results.diameterTrace += "Set the diameter to " + diameter + "\n\n";
            }
        }
        return diameter;
    }

    private int shortestPath(Node source, Node destination) {
        source.setDistance(0);
        ArrayList<Node> queue = new ArrayList<>();
        queue.add(source);
        source.setVisited(true);
        while (!queue.isEmpty()) {
            Node temp = queue.remove(0);
            for (int i = 0; i < temp.getNeighbors().size(); i++) {
                Node neighbor = temp.getNeighbors().get(i);
                int weight = temp.getWeights().get(i);
                int distance = temp.getDistance() + weight;
                if (distance < neighbor.getDistance()) {
                    queue.remove(neighbor);
                    neighbor.setDistance(distance);
                    neighbor.setPrevious(temp);
                    queue.add(neighbor);
                }
            }
        }
        return destination.getDistance();
    }
}
