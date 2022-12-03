import java.util.ArrayList;

public class Cycle_201796_200760_202308 {

    int count = 1;
    int cycleCount = 1;
    public void findCycle(Node node) {
        Results.cycle += "Step " + count++ + ":\n";
        Results.cycle += "Visited: " + node.getLabel() + "\n\n";
        node.setVisited(true);
        for (int i = 0; i < node.getNeighbors().size(); i++) {
            Results.cycle +="Step " + count++ + "\n";
            Results.cycle += "Checking neighbor: " + node.getNeighbors().get(i).getLabel() + "\n";
            Node neighbor = node.getNeighbors().get(i);
            if (neighbor.isVisited() && !neighbor.isReVisited()) {
                Results.cycle += "Neighbor " + neighbor.getLabel() + " is visited and not reVisited\n";
                Node temp = node;
                Results.cycle += "Cycle "+cycleCount++ +": ";
                System.out.print("Cycle "+cycleCount++ +": ");
                while (temp.getLabel() != neighbor.getLabel()) {
                    System.out.print(temp.getLabel() + " --> ");
                    Results.cycle += temp.getLabel() + " --> ";
                    temp = temp.getPrevious();
                }
                System.out.println(neighbor.getLabel());
                Results.cycle += temp.getLabel() + "\n\n";
            } else if (!neighbor.isVisited()) {
                Results.cycle += "\nStep " + count++ + "\n";
                Results.cycle += "Neighbor " + neighbor.getLabel() + " is not visited\n\n";
                neighbor.setPrevious(node);
                Results.cycle += "Step " + count++ + "\n";
                Results.cycle += "Previous of " + neighbor.getLabel() + " is set to " + node.getLabel() + "\n\n";
                Results.cycle += "Step " + count++ + "\n";
                Results.cycle += "Recursively calling findCycle on neighbor " + neighbor.getLabel() + "\n\n";
                findCycle(neighbor);
            }
        }
        Results.cycle += "Step " + count++ + ":\n";
        Results.cycle += "ReVisited Ture for node: " + node.getLabel() + "\n\n";
        node.setReVisited(true);
    }
}

