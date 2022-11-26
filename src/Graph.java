import java.util.ArrayList;

public class Graph {

    private final ArrayList<Node> nodes;
    public Graph() {
        nodes = new ArrayList<>();
    }
    public ArrayList<Node> undirectedGraph(ArrayList<GraphData> graphData, ArrayList<Integer> vertices) {
        nodes.add(new Node(-1));

        for (Integer vertex : vertices) {
            this.nodes.add(new Node(vertex));
        }

        for (GraphData graphDatum : graphData) {
            int j , k;
            for (j = 1; j < nodes.size(); j++) {
                if (graphDatum.getSource() == nodes.get(j).getLabel()) {
                    Node temp = new Node();
                    for (k = 1; k < this.nodes.size(); k++) {
                        if (nodes.get(k).getLabel() == graphDatum.getDestination()) {
                            temp = nodes.get(k);
                            break;
                        }
                    }
                    nodes.get(j).getNeighbors().add(temp);
                    nodes.get(k).getNeighbors().add(nodes.get(j));
                    nodes.get(j).getWeights().add(graphDatum.getWeight());
                    nodes.get(k).getWeights().add(graphDatum.getWeight());
                }
            }
        }
        return nodes;
    }

    public ArrayList<Node> directedGraph(ArrayList<GraphData> graphData, ArrayList<Integer> vertices) {
        nodes.add(new Node(-1));

        for (Integer vertex : vertices) {
            this.nodes.add(new Node(vertex));
        }

        for (GraphData graphDatum : graphData) {
            int j , k;
            for (j = 1; j < nodes.size(); j++) {
                if (graphDatum.getSource() == nodes.get(j).getLabel()) {
                    Node temp = new Node();
                    for (k = 1; k < this.nodes.size(); k++) {
                        if (nodes.get(k).getLabel() == graphDatum.getDestination()) {
                            temp = nodes.get(k);
                            break;
                        }
                    }
                    nodes.get(j).getNeighbors().add(temp);
                  //  nodes.get(k).getNeighbors().add(nodes.get(j));
                    nodes.get(j).getWeights().add(graphDatum.getWeight());
                    // nodes.get(k).getWeights().add(graphDatum.getWeight());
                }
            }
        }
        return nodes;
    }
    public void printGraph() {
        for (int i = 1; i < this.nodes.size(); i++) {
            System.out.print(this.nodes.get(i).getLabel() + " -> ");
            Results.graph+=this.nodes.get(i).getLabel() + " -> ";
            for (int j = 0; j < this.nodes.get(i).getNeighbors().size(); j++) {
                System.out.print(this.nodes.get(i).getNeighbors().get(j).getLabel() + "("+this.nodes.get(i).getWeights().get(j)+") ");
                Results.graph+=this.nodes.get(i).getNeighbors().get(j).getLabel() + "("+this.nodes.get(i).getWeights().get(j)+") ";
            }
            System.out.println();
            Results.graph+="\n";
        }
    }

    public void makeAllNodesUnvisited() {
        for (int i = 1; i < this.nodes.size(); i++) {
            this.nodes.get(i).setVisited(false);
        }
    }
}

