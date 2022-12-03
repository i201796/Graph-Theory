import java.util.ArrayList;

public class Graph {

    public ArrayList<GraphData> graphData = new ArrayList<>();
    private final ArrayList<Node> nodes;
    private int numberOfEdges;
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
                    nodes.get(j).getWeights().add(graphDatum.getWeight());
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

    public void makeAllNodesDistanceMax() {
        for (int i = 1; i < this.nodes.size(); i++) {
            this.nodes.get(i).setDistance(Integer.MAX_VALUE);
        }
    }

    public void takeAbsOfWeight() {
        for (int i = 1; i < this.nodes.size(); i++) {
            for (int j = 0; j < this.nodes.get(i).getWeights().size(); j++) {
                this.nodes.get(i).getWeights().set(j, Math.abs(this.nodes.get(i).getWeights().get(j)));
            }
        }
    }
    public Node getNode(int label){
        for (int i = 1; i < this.nodes.size(); i++) {
            if(this.nodes.get(i).getLabel() == label){
                return this.nodes.get(i);
            }
        }
        return null;
    }

    public ArrayList<GraphData> heapSort() {
        int n = graphData.size();
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(graphData, n, i);
        }
        for (int i = n - 1; i >= 0; i--) {
            GraphData temp = graphData.get(0);
            graphData.set(0, graphData.get(i));
            graphData.set(i, temp);
            heapify(graphData, i, 0);
        }

        return graphData;

    }
    public ArrayList<GraphData> undirectedGraph(ArrayList<GraphData> dataset){
        ArrayList<GraphData> graphData = new ArrayList<>();
        for (GraphData graphDatum : dataset) {
            graphData.add(new GraphData(graphDatum.getSource(), graphDatum.getDestination(), graphDatum.getWeight()));
            graphData.add(new GraphData(graphDatum.getDestination(), graphDatum.getSource(), graphDatum.getWeight()));
        }
        return graphData;
    }
    private void heapify(ArrayList<GraphData> graphData, int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        if (l < n && graphData.get(l).getWeight() > graphData.get(largest).getWeight()) {
            largest = l;
        }
        if (r < n && graphData.get(r).getWeight() > graphData.get(largest).getWeight()) {
            largest = r;
        }
        if (largest != i) {
            GraphData swap = graphData.get(i);
            graphData.set(i, graphData.get(largest));
            graphData.set(largest, swap);
            heapify(graphData, n, largest);
        }
    }


}

