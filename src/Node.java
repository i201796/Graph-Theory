import java.util.ArrayList;

public class Node {
    private int label;
    private ArrayList<Node> neighbors;
    private ArrayList<Integer> weights;
    private Node previous;
    private boolean visited;
    private boolean reVisited;

    public boolean isReVisited() {
        return reVisited;
    }

    public void setReVisited(boolean reVisited) {
        this.reVisited = reVisited;
    }

    private int distance;


    public Node() {
    }
    public Node(int label) {
        this.label = label;
        this.neighbors = new ArrayList<Node>();
        this.weights = new ArrayList<Integer>();
        this.visited = false;
        this.reVisited = false;
        this.distance = Integer.MAX_VALUE;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
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
