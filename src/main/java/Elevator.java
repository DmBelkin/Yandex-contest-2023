import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Elevator {

    public  File elevator(File file) throws IOException {
        File resultFile = new File("out/output8.txt");
        List<String> list = Files.readAllLines(Paths.get(file.getPath()));
        int elevatorMax = Integer.parseInt(list.get(0));
        int floorCount = Integer.parseInt(list.get(1));
        int[] floors = new int[floorCount];
        int index = 0;
        int peopleCount = 0;
        for (int i = 2; i < list.size(); i++) {
            floors[index++] = Integer.parseInt(list.get(i));
            peopleCount += Integer.parseInt(list.get(i));
        }
        int seconds = 0;
        int high = floorCount;
        while (peopleCount >= 0) {
              seconds += high;
              int people = 0;
              for (int i = high - 1; i >= 0; i--) {
                  while (people <= elevatorMax) {
                      people++;
                      floors[i]--;
                      peopleCount--;
                      if (floors[i] == 0) {
                          high--;
                          seconds++;
                          break;
                      }
                  }
              }
        }
        PrintWriter writer = new PrintWriter(resultFile);
        writer.write(Integer.toString(seconds + high));
        writer.close();
        return resultFile;
    }

}