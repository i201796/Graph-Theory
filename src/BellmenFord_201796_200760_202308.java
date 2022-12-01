import java.util.ArrayList;

public class BellmenFord_201796_200760_202308 {
    public void bellmenFord(Node node) {
        node.setDistance(0);
        for (int i = 0; i < node.getNeighbors().size(); i++) {
            Node neighbor = node.getNeighbors().get(i);
            int weight = node.getWeights().get(i);
            int distance = node.getDistance() + weight;
            if (distance < neighbor.getDistance()) {
                neighbor.setDistance(distance);
                neighbor.setPrevious(node);
            }
        }

        for (int i = 1; i < node.getNeighbors().size(); i++) {
            for (int j = 0; j < node.getNeighbors().get(i).getNeighbors().size(); j++) {
                Node neighbor = node.getNeighbors().get(i).getNeighbors().get(j);
                int weight = node.getNeighbors().get(i).getWeights().get(j);
                int distance = node.getNeighbors().get(i).getDistance() + weight;
                if (distance < neighbor.getDistance()) {
                    neighbor.setDistance(distance);
                    neighbor.setPrevious(node.getNeighbors().get(i));
                }
            }
        }
    }

    public void printResult(ArrayList<Node> graph){
        System.out.println("Bellmen-Ford:");
        for (int i = 1; i < graph.size(); i++) {
            if(graph.get(i).getDistance() == Integer.MAX_VALUE){
                //Results.bellmenFord += graph.get(i).getLabel() + " is not reachable from Vertex 1\n";
                System.out.println(graph.get(i).getLabel() + " is not reachable from Vertex 1");
            } else {
               // Results.bellmenFord += graph.get(i).getLabel() + " -->      " + graph.get(i).getDistance() + "\n";
                System.out.println(graph.get(i).getLabel() + " -->      " + graph.get(i).getDistance());
            }
        }
        System.out.println();
    }
}
