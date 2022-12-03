import java.util.ArrayList;

public class BFS_DFS_201796_200760_202308 {

    int count = 1;
    private ArrayList<Node> bfs = new ArrayList<Node>();
    private ArrayList<Node> dfs = new ArrayList<Node>();
    public void bfs(Node node) {
        ArrayList<Node> queue = new ArrayList<>();
        Results.BFSResult+= "Step " + count++ + "\n";
        Results.BFSResult += node.getLabel() + " Added to Queue \n";
        queue.add(node);
        Results.BFSResult += "Queue: " + printQueue(queue)  + "\n";
        node.setVisited(true);
        Results.BFSResult+= "\nStep " + count++ + "\n";
        Results.BFSResult += node.getLabel() + " Visited \n";

        while (!queue.isEmpty()) {
            Results.BFSResult+= "\nStep " + count++ + "\n";
            Results.BFSResult += "-> Queue not empty \n";
            Node temp = queue.remove(0);
            Results.BFSResult+= "\nStep " + count++ + "\n";
            Results.BFSResult += "Removed " + temp.getLabel() + " from Queue\n";
            System.out.print(temp.getLabel() + " ");
            bfs.add(temp);
            Results.BFSResult+="BFS Traversal: "+ printQueue(bfs) + "\n";
            for (int i = 0; i < temp.getNeighbors().size(); i++) {
                if (!temp.getNeighbors().get(i).isVisited()) {
                    Results.BFSResult+= "\nStep " + count++ + "\n";
                    Results.BFSResult += temp.getNeighbors().get(i).getLabel() + " Not visited so Added to Queue";
                    queue.add(temp.getNeighbors().get(i));
                    temp.getNeighbors().get(i).setVisited(true);
                    Results.BFSResult+= "\nStep " + count++ + "\n";
                    Results.BFSResult += temp.getNeighbors().get(i).getLabel() + " Visited\n";
                    Results.BFSResult += "Queue: " + printQueue(queue)  + "\n";
                }
            }
        }
        Results.BFSResult+= "\nStep " + count++ + "\n";
        Results.BFSResult += "-> Queue empty \n";
        count = 0;
    }

    private String printQueue(ArrayList<Node> queue){
        StringBuilder result = new StringBuilder();
        for (Node node : queue) {
            result.append(node.getLabel()).append(" ");
        }
        return result.toString();
    }

    public void dfs(Node node) {
        Results.DFSResult+= "Step " + count++ + "\n";
        node.setVisited(true);
        Results.DFSResult += node.getLabel() + " Visited \n";
        System.out.print(node.getLabel() + " ");
        dfs.add(node);
        Results.DFSResult+="DFS Traversal: "+ printQueue(dfs) + "\n";
        for (int i = 0; i < node.getNeighbors().size(); i++) {
            if (!node.getNeighbors().get(i).isVisited()) {
                Results.DFSResult+= "\nStep " + count++ + "\n";
                Results.DFSResult += node.getNeighbors().get(i).getLabel() + " Not visited so Performing DFS on it Again\n\n";
                dfs(node.getNeighbors().get(i));
            }
        }
    }


}
