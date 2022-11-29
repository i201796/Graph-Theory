import java.util.ArrayList;

public class BFS_DFS_201796_200760_202308 {
    public void bfs(Node node) {
        ArrayList<Node> queue = new ArrayList<>();
        queue.add(node);
        node.setVisited(true);
        while (!queue.isEmpty()) {
            Node temp = queue.remove(0);
            System.out.print(temp.getLabel() + " ");
            Results.BFSResult+=temp.getLabel()+" ";
            for (int i = 0; i < temp.getNeighbors().size(); i++) {
                if (!temp.getNeighbors().get(i).isVisited()) {
                    queue.add(temp.getNeighbors().get(i));
                    temp.getNeighbors().get(i).setVisited(true);
                }
            }
        }
    }

    public void dfs(Node node) {
        node.setVisited(true);
        System.out.print(node.getLabel() + " ");
        Results.DFSResult+=node.getLabel()+" ";
        for (int i = 0; i < node.getNeighbors().size(); i++) {
            if (!node.getNeighbors().get(i).isVisited()) {
                dfs(node.getNeighbors().get(i));
            }
        }
    }


}
