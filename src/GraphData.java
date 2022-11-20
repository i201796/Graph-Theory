import java.util.ArrayList;

public class GraphData {
    private int source;
    private int destination;

    public GraphData() {
    }

    public GraphData(int source, int destination) {
        this.source = source;
        this.destination = destination;
    }

    public int numberOfVertices(ArrayList<GraphData> graphData) {
        ArrayList<Integer> vertices = new ArrayList<Integer>();

        for (int i = 0; i < graphData.size(); i++) {
            vertices.add(graphData.get(i).source);
            vertices.add(graphData.get(i).destination);
        }
        return removeDuplicate(vertices).size();
    }

    public ArrayList<Integer> removeDuplicate(ArrayList<Integer> vertices) {
        ArrayList<Integer> uniqueVertices = new ArrayList<Integer>();
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
