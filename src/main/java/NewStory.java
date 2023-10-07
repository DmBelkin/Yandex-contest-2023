import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class NewStory {

    public File time(File file) throws IOException {
        long start = System.currentTimeMillis();
        File resultFile = new File("out/output4.txt");
        List<String> list = Files.readAllLines(Paths.get(file.getPath()));
        StringBuilder builder = new StringBuilder();
        String[] beginData = list.get(0).split("\\s");
        String[] endData = list.get(1).split("\\s");
        int lifeTime = 0;
        int lifeSeconds = 0;
        int[] mothsValues = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        lifeTime += (Integer.parseInt(endData[0]) - Integer.parseInt(beginData[0])) * 365;
        int beginMonths = Integer.parseInt(beginData[1]);
        int endMonths = Integer.parseInt(endData[1]);
        if (endMonths > beginMonths) {
            for (int i = beginMonths; i < endMonths; i++) {
                lifeTime += mothsValues[i - 1];
            }
        } else {
            for (int i = endMonths; i < beginMonths; i++) {
                lifeTime += mothsValues[i - 1];
            }
        }
        lifeTime -= Integer.parseInt(beginData[2]);
        lifeTime += Integer.parseInt(endData[2]) - 1;
        int beginSeconds = Integer.parseInt(beginData[3]) * 3600 + Integer.parseInt(beginData[4]) * 60 +
                Integer.parseInt(beginData[5]);
        int endSeconds = Integer.parseInt(endData[3]) * 3600 + Integer.parseInt(endData[4]) * 60 +
                Integer.parseInt(endData[5]);
        lifeSeconds += (86400 - beginSeconds) + endSeconds;
        if (lifeSeconds > 86400) {
            lifeTime++;
            lifeSeconds -= 86400;
        }
        builder.append(lifeTime + "\s" + lifeSeconds);
        PrintWriter writer = new PrintWriter(resultFile);
        writer.write(builder.toString());
        writer.flush();
        writer.close();
        long end = System.currentTimeMillis();
        System.out.println(end - start + " time");
        return resultFile;
    }
}
