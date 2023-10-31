import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Elevator {

    public File elevator(File file) throws IOException {
        File resultFile = new File("out/output8.txt");
        List<String> list = Files.readAllLines(Paths.get(file.getPath()));
        int elevatorMax = Integer.parseInt(list.get(0));
        System.out.println(elevatorMax + "max");
        int floorCount = Integer.parseInt(list.get(1));
        System.out.println(floorCount + "count");
        int[] floors = new int[floorCount];
        int index = 0;
        int peopleCount = 0;
        for (int i = 2; i < list.size(); i++) {
            floors[index++] = Integer.parseInt(list.get(i));
            peopleCount += Integer.parseInt(list.get(i));
        }
        System.out.println(Arrays.toString(floors));
        int seconds = 0;
        int high = floorCount;
        for (int i = high - 1; i >= 0; i--) {
            seconds += high;
            System.out.println(high + "high");
            System.out.println(seconds + "seconds");
            int people = 0;
            while (people <= elevatorMax && peopleCount > 0 && floors[i] >= 0) {
                if (people == elevatorMax) {
                    seconds += high;
                }
                if (floors[i] == 0) {
                    high--;
                    seconds++;
                }
                people++;
                floors[i]--;
                peopleCount--;
            }
        }
        PrintWriter writer = new PrintWriter(resultFile);
        writer.write(Integer.toString(seconds));
        writer.close();
        return resultFile;
    }

}