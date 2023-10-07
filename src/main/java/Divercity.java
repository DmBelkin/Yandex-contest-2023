import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Divercity {


    public File getResult(File file) throws IOException {
        long start = System.currentTimeMillis();
        File result = new File("out/output.txt");
        StringBuilder builder = new StringBuilder();
        List<String> list = Files.readAllLines(Paths.get(file.getPath()));
        String[] cardsDataA = list.get(1).split("\\s");
        String[] cardsDataB = list.get(2).split("\\s");
        String[] playsData = list.get(0).split("\\s");
        List<String> A = new ArrayList<>(Arrays.stream(cardsDataA).toList());
        List<String> B = new ArrayList<>(Arrays.stream(cardsDataB).toList());
        for (int i = 3; i <= Integer.parseInt(playsData[2]) + 2; i++) {
            String[] changeData = list.get(i).split("\\s");
            int changeType = Integer.parseInt(changeData[0]);
            String playerName = changeData[1];
            String card = changeData[2];
            if (playerName.equals("A")) {
                if (changeType == 1) {
                    A.add(card);
                } else {
                    A.remove(card);
                }
            } else {
                if (changeType == 1) {
                    B.add(card);
                } else {
                    B.remove(card);
                }
            }
            List<String> tableA = new ArrayList<>(A);
            List<String> tableB = new ArrayList<>(B);
            for (int j = 0; j <= tableA.size() - 1; j++) {
                if (tableB.contains(tableA.get(j))) {
                    String token = tableA.get(j);
                    tableA.remove(token);
                    tableB.remove(token);
                    j--;
                }
            }
            builder.append(tableA.size() + tableB.size() + "\s");
        }
        PrintWriter writer = new PrintWriter(result);
        writer.write(builder.toString());
        writer.flush();
        writer.close();
        long end = System.currentTimeMillis();
        System.out.println(end - start + " time");
        return result;
    }

}
