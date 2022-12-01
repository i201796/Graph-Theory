import java.util.ArrayList;

public class BellmanFord_201796_200760_202308 {

    private boolean negativeCycle = false;
    public boolean bellmanFord(ArrayList<Node> graph, Node source) {
        source.setDistance(0);

        for (int i = 0; i < graph.size() - 1; i++) {
            for (Node node : graph) {
                for (int k = 0; k < node.getNeighbors().size(); k++) {
                    Node neighbor = node.getNeighbors().get(k);
                    int weight = node.getWeights().get(k);
                    int distance = node.getDistance() + weight;
                    if (distance < neighbor.getDistance()) {
                        neighbor.setDistance(distance);
                    }
                }
            }
        }

        for (Node node : graph) {
            for (int k = 0; k < node.getNeighbors().size(); k++) {
                Node neighbor = node.getNeighbors().get(k);
                int weight = node.getWeights().get(k);
                int distance = node.getDistance() + weight;
                if (distance < neighbor.getDistance()) {
                    negativeCycle = true;
                    return false;
                }
            }
        }
        return true;
    }
    public void printResult(ArrayList<Node> graph){

        System.out.println("Bellmen-Ford:");
        if (negativeCycle) {
            Results.bellmanFordResult = "Negative cycle detected";
            System.out.println("Negative cycle detected");
            return;
        }
        for (int i = 1; i < graph.size(); i++) {
            if(graph.get(i).getDistance() == Integer.MAX_VALUE){
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
