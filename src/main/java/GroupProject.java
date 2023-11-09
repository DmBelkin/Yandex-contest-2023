import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class GroupProject {

    public File project(File file) throws IOException {
        File resultFile = new File("out/output10.txt");
        List<String> list = Files.readAllLines(Paths.get(file.getPath()));
        int testAmount = Integer.parseInt(list.get(0));
        StringBuilder builder = new StringBuilder();
        for (int j = 1; j <= testAmount; j++) {
            String[] input = list.get(j).split("\\s");
            int students = Integer.parseInt(input[0]);
            int a = Integer.parseInt(input[1]);
            int b = Integer.parseInt(input[2]);
            for (int i = a; i <= b; i++) {
                int groups = students / i;
                int freeStudents = students % i;
                if (freeStudents == 0) {
                    builder.append("YES" + "\n");
                    break;
                } else if (students % i <= groups * (b - a)) {
                    builder.append("YES" + "\n");
                    break;
                }
                if (i == b) {
                    builder.append("NO" + "\n");
                }
            }
        }
        PrintWriter writer = new PrintWriter(resultFile);
        writer.write(builder.toString().trim());
        writer.close();
        return resultFile;
    }

}
