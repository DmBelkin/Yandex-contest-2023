import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class NotMin {


    public File notMin(File file) throws IOException {
        List<String> list = Files.readAllLines(Paths.get(file.getPath()));
        String[] inputString = list.get(1).split("\\s");
        StringBuilder builder = new StringBuilder();
        for (int i = 2; i < list.size(); i++) {
            String[] boundaries = list.get(i).split("\\s");
            int start = Integer.parseInt(boundaries[0]);
            int end = Integer.parseInt(boundaries[1]) + 1;
            String []slice = Arrays.copyOfRange(inputString, start, end);
            Set<Integer> set = Arrays.stream(slice).map(o -> Integer.parseInt(o))
                    .collect(Collectors.toSet());
            if (set.size() == 1) {
                builder.append("NOT FOUND" + "\n");
                continue;
            }
            int min = set.stream().min(Comparator.comparing(o -> o.intValue()))
                    .get().intValue();
            set.remove(min);
            builder.append(set.stream().findFirst().get().intValue() + "\n");
        }
        File resultFile = new File("out/output8.txt");
        PrintWriter writer = new PrintWriter(resultFile);
        writer.write(builder.toString());
        writer.close();
        return resultFile;
    }
}
