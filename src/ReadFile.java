import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadFile {

    public ArrayList<GraphData> readFile(String fileName) {
        ArrayList<GraphData> graphData = new ArrayList<GraphData>();
        try {
            File file = new File(fileName + ".txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(" ");
                graphData.add(new GraphData(Integer.parseInt(data[0]), Integer.parseInt(data[1])));
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred: File Not Found.");
        }
        return graphData;
    }
}
