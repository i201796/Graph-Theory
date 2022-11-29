import java.util.ArrayList;

public class Dijkstra_201796_200760_202308 {

    public void dijkstra(Node node) {
        ArrayList<Node> queue = new ArrayList<>();
        queue.add(node);
        node.setDistance(0);
        while (!queue.isEmpty()) {
            Node temp = queue.remove(0);
            for (int i = 0; i < temp.getNeighbors().size(); i++) {
                if (temp.getDistance() + temp.getWeights().get(i) < temp.getNeighbors().get(i).getDistance()) {
                    temp.getNeighbors().get(i).setDistance(temp.getDistance() + temp.getWeights().get(i));
                    queue.add(temp.getNeighbors().get(i));
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
