import java.util.ArrayList;

public class Node {
    private int label;
    private ArrayList<Node> neighbors;
    private ArrayList<Integer> weights;
    private boolean visited;

    public Node() {
    }
    public Node(int label) {
        this.label = label;
        this.neighbors = new ArrayList<Node>();
        this.weights = new ArrayList<Integer>();
        this.visited = false;
    }

    public int getLabel() {
        return label;
    }

    public void setLabel(int label) {
        this.label = label;
    }

    public ArrayList<Node> getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(ArrayList<Node> neighbors) {
        this.neighbors = neighbors;
    }

    public ArrayList<Integer> getWeights() {
        return weights;
    }

    public void setWeights(ArrayList<Integer> weights) {
        this.weights = weights;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }
}
