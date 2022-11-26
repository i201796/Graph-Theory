import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {

    public static void writeGraphToFile() {
        try {
            FileWriter fileWriter = new FileWriter("Graph Result.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(Results.graph);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeDFSToFile() {
        try {
            FileWriter fileWriter = new FileWriter("DFS Result.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(Results.DFSResult);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeBFSToFile() {
        try {
            FileWriter fileWriter = new FileWriter("BFS Result.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(Results.BFSResult);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeCycleToFile(){
        try {
            FileWriter fileWriter = new FileWriter("Cycle.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(Results.cycle);
            bufferedWriter.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
