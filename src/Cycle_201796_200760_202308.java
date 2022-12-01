import java.util.ArrayList;

public class Cycle_201796_200760_202308 {
    public boolean hasCycle(Node node) {
        ArrayList<Node> queue = new ArrayList<>();
        queue.add(node);
        node.setVisited(true);
        while (!queue.isEmpty()) {
            Node temp = queue.remove(0);
            for (int i = 0; i < temp.getNeighbors().size(); i++) {
                if (!temp.getNeighbors().get(i).isVisited()) {
                    queue.add(temp.getNeighbors().get(i));
                    temp.getNeighbors().get(i).setVisited(true);
                } else {
                    Results.cycle = "A Cycle was found between Vertex " + temp.getLabel() +" and " +
                            temp.getNeighbors().get(i).getLabel();
                    return true;
                }
            }
        }
        return false;
    }
}

