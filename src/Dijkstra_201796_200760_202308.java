import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Dijkstra_201796_200760_202308 {

    int count =1;
    public void dijkstra(Node node) {
        Results.dijkstraTrace += "Step " + count++ + ":\n Set distance of " + node.getLabel() + " to 0\n\n";
        node.setDistance(0);
        PriorityQueue<Node> queue = new PriorityQueue<Node>(Comparator.comparing(Node::getDistance));
        Results.dijkstraTrace += "Step " + count++ + ":\n Add " + node.getLabel() + " to queue\n\n";
        queue.add(node);
        Results.dijkstraTrace += "Queue is not empty\n\n";
        while (!queue.isEmpty()) {
            Node temp = queue.remove();
            Results.dijkstraTrace += "Step " + count++ + ":\n Remove " + temp.getLabel() + " from queue\n\n";
            for (int i = 0; i < temp.getNeighbors().size(); i++) {
                Node neighbor = temp.getNeighbors().get(i);
                int weight = temp.getWeights().get(i);
                int distance = temp.getDistance() + weight;
                Results.dijkstraTrace += "Step " + count++ + ":\n Calculate distance of " + neighbor.getLabel() + " = " + temp.getLabel() + " + " + weight + "\n\n";
                if (distance < neighbor.getDistance()) {
                    Results.dijkstraTrace += "Step " + count++ + ":\n Distance of " + neighbor.getLabel() + " is less than current distance" +
                            "\nRemove " + neighbor.getLabel() + " from queue and set distance.\n\n";
                    queue.remove(neighbor);
                    neighbor.setDistance(distance);
                    neighbor.setPrevious(temp);
                    queue.add(neighbor);
                    Results.dijkstraTrace += "Step " + count++ + ":\n Add " + neighbor.getLabel() + " to queue\n\n";
                }
            }
        }
        Results.dijkstraTrace += "Queue is empty\n\n";
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
