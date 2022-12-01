import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Dijkstra_201796_200760_202308 {

    public void dijkstra(Node node) {

        node.setDistance(0);
        PriorityQueue<Node> queue = new PriorityQueue<Node>(Comparator.comparing(Node::getDistance));
        queue.add(node);
        while (!queue.isEmpty()) {
            Node temp = queue.remove();
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
    }

    public void printResult(ArrayList<Node> graph){
        System.out.println("Dijkstra:");
        for (int i = 1; i < graph.size(); i++) {
            if(graph.get(i).getDistance() == Integer.MAX_VALUE){
                Results.dijkstra += graph.get(i).getLabel() + " is not reachable from Vertex 1\n";
                System.out.println(graph.get(i).getLabel() + " is not reachable from Vertex 1");

            } else {
                Results.dijkstra += graph.get(i).getLabel() + " -->      " + graph.get(i).getDistance() + "\n";
                System.out.println(graph.get(i).getLabel() + " -->      " + graph.get(i).getDistance());
            }
        }
        System.out.println();
    }

}
