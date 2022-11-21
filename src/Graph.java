import java.util.ArrayList;

public class Graph {

    private final ArrayList<Node> nodes;
    public Graph() {
        nodes = new ArrayList<>();
    }
    public ArrayList<Node> GraphCreation(ArrayList<GraphData> graphData, ArrayList<Integer> vertices) {
        nodes.add(new Node(-1));

        for (Integer vertex : vertices) {
            this.nodes.add(new Node(vertex));
        }

        for (GraphData graphDatum : graphData) {
            for (int j = 1; j < nodes.size(); j++) {
                if (graphDatum.getSource() == nodes.get(j).getLabel()) {
                    Node temp = new Node();
                    for (int k = 1; k < this.nodes.size(); k++) {
                        if (nodes.get(k).getLabel() == graphDatum.getDestination()) {
                            temp = nodes.get(k);
                            break;
                        }
                    }
                    nodes.get(j).getNeighbors().add(temp);
                    nodes.get(j).getWeights().add(graphDatum.getWeight());
                }
            }
        }
        return nodes;
    }
    public void dfs(Node node) {
        node.setVisited(true);
        System.out.print(node.getLabel() + " ");
        for (int i = 0; i < node.getNeighbors().size(); i++) {
            if (!node.getNeighbors().get(i).isVisited()) {
                dfs(node.getNeighbors().get(i));
            }
        }
    }
    public void printGraph() {
        for (int i = 1; i < this.nodes.size(); i++) {
            System.out.print(this.nodes.get(i).getLabel() + " -> ");
            for (int j = 0; j < this.nodes.get(i).getNeighbors().size(); j++) {
                System.out.print(this.nodes.get(i).getNeighbors().get(j).getLabel() + "("+this.nodes.get(i).getWeights().get(j)+") ");
            }
            System.out.println();
        }
    }
}

