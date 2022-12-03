import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {

    public  void writeGraphToFile() {
        try {
            FileWriter fileWriter = new FileWriter("Graph Result.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(Results.graph);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public  void writeDFSToFile() {
        try {
            FileWriter fileWriter = new FileWriter("DFS Result.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(Results.DFSResult);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public  void writeKruskalToFile() {
        try {
            FileWriter fileWriter = new FileWriter("Kruskals.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(Results.Kruskals);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public   void writePrimsToFile(){
        try {
            FileWriter fileWriter = new FileWriter("Prims.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(Results.Prims);
            bufferedWriter.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public   void writeAverageDegreeToFile(){
        try {
            FileWriter fileWriter = new FileWriter("AverageDegree.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(Results.AverageDegree);
            bufferedWriter.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public  void writeBFSToFile() {
        try {
            FileWriter fileWriter = new FileWriter("BFS Result.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(Results.BFSResult);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public  void writeCycleToFile(){
        try {
            FileWriter fileWriter = new FileWriter("Cycle Result.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(Results.cycle);
            bufferedWriter.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public   void writeDijkstraResult(){
        try {
            FileWriter fileWriter = new FileWriter("Dijkstra Result.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(Results.dijkstra);
            bufferedWriter.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void writeBellmanFordResult() {
        try {
            FileWriter fileWriter = new FileWriter("Bellman Ford Result.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(Results.bellmanFordResult);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeDiameterResult() {
        try {
            FileWriter fileWriter = new FileWriter("Diameter Result.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(Results.diameterResult);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
