import java.util.ArrayList;

public class Cycle_201796_200760_202308 {
    int step = 1;
    public boolean hasCycle(Node node) {
        ArrayList<Node> queue = new ArrayList<>();
        Results.cycle += "Step " + step++ + ":\n";
        Results.cycle += "Add " + node.getLabel() + " to queue\n\n";
        queue.add(node);
        node.setVisited(true);
        Results.cycle += "Step " + step++ + ":\nSet " + node.getLabel() + " to visited\n\n";
        while (!queue.isEmpty()) {
            Results.cycle += "Step " + step++ + ":\nRemove " + queue.get(0).getLabel() + " from queue\n\n";
            Node temp = queue.remove(0);
            for (int i = 0; i < temp.getNeighbors().size(); i++) {
                Results.cycle += "Step " + step++ + ":\nGet neighbor " + temp.getNeighbors().get(i).getLabel() + " of " + temp.getLabel() + "\n\n";
                if (!temp.getNeighbors().get(i).isVisited()) {
                    Results.cycle += "Step " + step++ + ":\n"+temp.getNeighbors().get(i).getLabel() + " is not visited so added to queue and set true\n\n";
                    queue.add(temp.getNeighbors().get(i));
                    temp.getNeighbors().get(i).setVisited(true);
                } else {
                    System.out.println("Cycle was found between " + temp.getLabel() + " and " + temp.getNeighbors().get(i).getLabel());
                    Results.cycle += "A Cycle was found between Vertex " + temp.getLabel() +" and " +
                            temp.getNeighbors().get(i).getLabel();
                    return true;
                }
            }
        }
        return false;
    }
}