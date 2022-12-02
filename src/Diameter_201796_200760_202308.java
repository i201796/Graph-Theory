import java.util.ArrayList;

public class Diameter_201796_200760_202308 {

    public int diameter(ArrayList<Node> graph) {
        int diameter = 0;
        for (int i = 1; i < graph.size(); i++) {
            int max = 0;
            for (int j = 1; j < graph.size(); j++) {
                if (i != j) {
                    int distance = shortestPath(graph.get(i), graph.get(j));
                    if (distance > max) {
                        max = distance;
                    }
                }
            }
            if (max > diameter) {
                diameter = max;
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
