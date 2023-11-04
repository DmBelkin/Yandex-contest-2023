import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Elevator {

    public File elevator(File file) throws IOException {
        File resultFile = new File("out/output8.txt");
        long start = System.currentTimeMillis();
        List<String> list = Files.readAllLines(Paths.get(file.getPath()));
        int elevatorMax = Integer.parseInt(list.get(0));
        int floorCount = Integer.parseInt(list.get(1));
        int index = 1;
        BigInteger peopleCount = BigInteger.ZERO;//накапливает огромное число
        long[] floors = new long[floorCount + 1];
        for (int i = 2; i < floorCount + 2; i++) {
            floors[index++] = Integer.parseInt(list.get(i));
            peopleCount = peopleCount.add(BigInteger.valueOf(Long.parseLong(list.get(i))));
        }
        BigInteger seconds = BigInteger.ZERO;
        long people = 0;
        while (peopleCount.compareTo(BigInteger.ZERO) > 0 && floorCount >= 0) {
            if (floors[floorCount] > 1000000 && people == 0) {
                seconds = seconds.add(BigInteger.valueOf((floors[floorCount] / elevatorMax) * floorCount * 2));
                peopleCount = peopleCount.subtract(BigInteger.valueOf(floors[floorCount]
                        - floors[floorCount] % elevatorMax));
                floors[floorCount] -= floors[floorCount] - floors[floorCount] % elevatorMax;
                continue;
            }
            if (people == 0) {
                seconds = seconds.add(BigInteger.valueOf(floorCount));
                while (floors[floorCount] == 0) {
                    seconds = seconds.subtract(BigInteger.ONE);
                    floorCount--;
                }
            }
            long peopleOnFloor = floors[floorCount];
            long transaction = peopleOnFloor <= elevatorMax - people ? peopleOnFloor : elevatorMax - people;
            people += transaction;
            peopleCount = peopleCount.subtract(BigInteger.valueOf(transaction));
            floors[floorCount] -= transaction;
            if (floors[floorCount] == 0) {
                seconds = seconds.add(BigInteger.ONE);
                floorCount--;
            }
            if (people == elevatorMax || peopleCount.intValue() == 0) {
                people = 0;
                seconds = seconds.add(BigInteger.valueOf(floorCount));
            }
        }
        PrintWriter writer = new PrintWriter(resultFile);
        writer.write(seconds.toString());
        writer.close();
        long end = System.currentTimeMillis();
        System.out.println("time: " + (end - start));
        return resultFile;
    }
}