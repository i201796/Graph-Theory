import java.util.ArrayList;

public class AverageDegree_201796_200760_202308 {
    public double averageDegree(ArrayList<GraphData> graphData){
        double averageDegree = 0;
        ArrayList<Integer> vertices = new ArrayList<>();
        vertices = new GraphData().removeDuplicate(graphData);
        int numofVertices = vertices.size();
        System.out.println("Number of Vertices: "+numofVertices);
        System.out.println("Number of Edges: "+graphData.size());
        int numofEdges = graphData.size();
        averageDegree = ((double)(numofEdges)/(double)(numofVertices));
        return averageDegree;
    }



}
