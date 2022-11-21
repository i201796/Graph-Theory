import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Graph {

    private ArrayList<Node> nodes;
    public Graph() {
        nodes = new ArrayList<Node>();
    }

    public ArrayList<Node> GraphCreation(int numberOfVertices, ArrayList<GraphData> graphData, ArrayList<Integer> vertices) throws IOException {
        nodes.add(new Node(-1));

        for (int i = 0; i < vertices.size(); i++) {
            this.nodes.add(new Node(vertices.get(i)));
        }

        for (int i = 0; i < graphData.size(); i++) {
            for (int j = 1; j < nodes.size(); j++) {
                if (graphData.get(i).getSource() == nodes.get(j).getLabel() ) {
                    Node temp = new Node();
                    for (int k = 1; k < this.nodes.size(); k++) {
                        if (nodes.get(k).getLabel() == graphData.get(i).getDestination()) {
                            temp = nodes.get(k);
                            break;
                        }
                    }
                    nodes.get(j).getNeighbors().add(temp);
                    nodes.get(j).getWeights().add(graphData.get(i).getWeight());
                }
            }
        }
        return nodes;
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

