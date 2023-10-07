import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QueryToTable {


    public File queryControl(File file) throws IOException {
        File resultFile = new File("out/output5.txt");
        List<String> list = Files.readAllLines(Paths.get(file.getPath()));
        String[] data = list.get(0).split("\\s");
        int rowsCount = Integer.parseInt(data[0]);
        String[] columns = list.get(1).split("\\s");
        List<String[]> base = new ArrayList<>();
        for (int i = 2; i <= rowsCount + 1; i++) {
            String[] row = list.get(i).split("\\s");
            base.add(row);
        }
        for (int j = rowsCount + 2; j <= list.size() - 1; j++) {
            String[] point = list.get(j).split("\\s");
            int num = Integer.parseInt(point[2]);
            int index = Arrays.binarySearch(columns, point[0]);
            for (int k = 0; k <= base.size() - 1; k++) {
                 if (point[1].equals("<")) {
                     if (Integer.parseInt(base.get(k)[index]) >= num) {
                         base.remove(k);
                     }
                 } else if (point[1].equals(">")) {
                     if (Integer.parseInt(base.get(k)[index]) <= num) {
                         base.remove(k);
                     }
                 }
            }
        }
        int result = 0;
        for (String[] row : base) {
            for (String num : row) {
                result += Integer.parseInt(num);
            }

        }
        PrintWriter writer = new PrintWriter(resultFile);
        writer.write(Integer.toString(result));
        writer.flush();
        writer.close();
        return resultFile;
    }

}
