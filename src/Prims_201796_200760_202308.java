import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Prims_201796_200760_202308 {

    public void prims(ArrayList<GraphData> Edges, ArrayList<Node> nodes){

        ArrayList<Integer> vertices = new ArrayList<>();
        vertices = new GraphData().removeDuplicate(Edges);
        int numofVertices = vertices.size();
        HashMap<Integer,Integer> parent = new HashMap<Integer,Integer>();
        HashMap<Integer,Integer> key = new HashMap<Integer,Integer>();
        HashMap<Integer,Boolean> mstSet = new HashMap<Integer,Boolean>();

        for(int i=0;i<numofVertices;i++){
            key.put(vertices.get(i),Integer.MAX_VALUE);
            mstSet.put(vertices.get(i),false) ;
        }

        HashMap<Integer,Node> nodeMap = new HashMap<>();


        for (int i = 0;i<nodes.size();i++){
            Node temp = nodes.get(i);
            nodeMap.put(temp.getLabel(),temp);
        }
        key.put(vertices.get(0),0);
        parent.put(vertices.get(0),-1) ;

        for(int i=0;i<numofVertices-1;i++){
            int u = minKey(key,mstSet,vertices);
            mstSet.put(u,true);
            for(int v=0;v<numofVertices;v++){
                int j=0;
                boolean flag = false;
                int vtemp = vertices.get(v);
                for(j=0;j<nodeMap.get(u).getNeighbors().size();j++){
                    if(nodeMap.get(u).getNeighbors().get(j).getLabel() == vtemp) {
                        flag = true;
                        break;
                    }
                }
                if(flag) {
                    if (mstSet.get(vtemp) == false && nodeMap.get(u).getWeights().get(j) < key.get(vtemp)) {
                        parent.put(vtemp,u);
                        key.put(vtemp,nodeMap.get(u).getWeights().get(j)) ;
                    }
                }
            }
        }

        int total = 0;
        int f =0;
        System.out.println("Size: "+numofVertices);
        for(int i=0;i<numofVertices;i++){
            int vtemp = vertices.get(i);
            if(parent.get(vtemp)==null)
                continue;
            int temp = parent.get(vtemp);
            int j=0;
            boolean flag = false;
            for(j=0;j<nodeMap.get(vtemp).getNeighbors().size();j++){
                if(nodeMap.get(vtemp).getNeighbors().get(j).getLabel() == temp) {
                    flag = true;
                    break;
                }
            }
            if (flag){
                System.out.println("Edge: "+ temp+ " -> "+vtemp+" Weight: "+nodeMap.get(vtemp).getWeights().get(j));
                Results.Prims+="Edge: "+temp+" -> "+vtemp+" Weight: "+nodeMap.get(vtemp).getWeights().get(j)+" \n\r";
            }
        }


    }

    public int minKey(HashMap<Integer,Integer> key, HashMap<Integer,Boolean> mstSet, ArrayList<Integer> vertices){
        int min = Integer.MAX_VALUE;
        int min_index = -1;
        for(int i=0;i<vertices.size();i++){
            if(mstSet.get(vertices.get(i))==false && key.get(vertices.get(i))<min){
                min = key.get(vertices.get(i));
                min_index = vertices.get(i);
            }
        }
        return min_index;
    }


}
