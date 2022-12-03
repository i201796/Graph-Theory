import java.util.ArrayList;
import java.util.HashMap;

public class Kruskals_201796_200760_202308 {


    public void kruskals(ArrayList<GraphData> graphdata){
        Results.Kruskals += "Kruskals Algorithm: \n Step 1: Removing Duplicate Vertices";
        ArrayList<Integer> uniqueVertices = new ArrayList<Integer>();
        uniqueVertices = new GraphData().removeDuplicate(graphdata);

        ArrayList<Integer> visited = new ArrayList<Integer>();
        ArrayList<GraphData> MST = new ArrayList<GraphData>();
        int e =0;
        int Weight = 0;
        HashMap<Integer,subset> subsets = new HashMap<Integer, subset>();

        for(int i=0;i<uniqueVertices.size();i++){
            subsets.put(uniqueVertices.get(i), new subset(uniqueVertices.get(i), 0, uniqueVertices.get(i)));
        }
        int currentIndex = 0;
        while(e<uniqueVertices.size()-1 && currentIndex<graphdata.size()){
            GraphData nextEdge = new GraphData();
            nextEdge = graphdata.get(currentIndex++);
            int x = find(subsets, nextEdge.getSource());
            int y = find(subsets, nextEdge.getDestination());
            if(x!=y){
                MST.add(nextEdge);
                Weight += nextEdge.getWeight();
                Union(subsets, x, y);
                e++;
            }

        }
        for(int i=0;i<MST.size();i++){
            System.out.println("Edge: " + MST.get(i).getSource() + " " + MST.get(i).getDestination() + " Weight: " + MST.get(i).getWeight());
            Results.Kruskals+=("Edge: " + MST.get(i).getSource() + " " + MST.get(i).getDestination() + " Weight: " + MST.get(i).getWeight()+"\r \n");
        }
        System.out.println("Total Weight: " + Weight);
    }

    int find(HashMap<Integer,subset> subsets, int i) {
//        int j=0;
//        for(j=0;j<subsets.size();j++){
//            if(subsets.get(j).value==i){
//                break;
//            }
//        }
//
        if (subsets.get(i).parent != i)
            subsets.get(i).parent = find(subsets, subsets.get(i).parent);
        return subsets.get(i).parent;
    }

    void Union(HashMap<Integer,subset> subsets, int x, int y) {
        int xroot = find(subsets, x);
        int yroot = find(subsets, y);
//        int xtemp;
//        int ytemp;
//        for( ytemp=0;ytemp< subsets.size();ytemp++) {
//            if(subsets.get(ytemp).value==yroot)
//                break;
//        }
//        for( xtemp=0;xtemp< subsets.size();xtemp++) {
//            if(subsets.get(xtemp).value==xroot)
//                break;
//        }
//

        if (subsets.get(xroot).rank < subsets.get(yroot).rank)
            subsets.get(xroot).parent = yroot;
        else if (subsets.get(xroot).rank > subsets.get(yroot).rank)
            subsets.get(yroot).parent = xroot;
        else {
            subsets.get(yroot).parent = xroot;
            subsets.get(xroot).rank++;
        }
    }




}
