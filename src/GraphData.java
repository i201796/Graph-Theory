import java.util.ArrayList;

public class GraphData {
    private int source;
    private int destination;

    private int weight;

    public static ArrayList<Integer> uniqueVertices = new ArrayList<Integer>();
    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public GraphData() {
    }

    public GraphData(int source, int destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }
    public ArrayList<Integer> removeDuplicate(ArrayList<GraphData> graphData) {
        ArrayList<Integer> vertices = new ArrayList<Integer>();

        for (int i = 0; i < graphData.size(); i++) {
            vertices.add(graphData.get(i).source);
            vertices.add(graphData.get(i).destination);
        }

        for (int i = 0; i < vertices.size(); i++) {
            if (!uniqueVertices.contains(vertices.get(i))) {
                uniqueVertices.add(vertices.get(i));
            }
        }
        return uniqueVertices;
    }
    @Override
    public String toString() {
        return this.source + " " + this.destination;
    }

    public int getSource() {
        return source;
    }

    public void setSource(int source) {
        this.source = source;
    }

    public int getDestination() {
        return destination;
    }

    public void setDestination(int destination) {
        this.destination = destination;
    }


}
