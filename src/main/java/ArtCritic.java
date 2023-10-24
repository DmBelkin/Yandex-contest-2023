import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ArtCritic {

    public File getScores(File file) throws IOException {
        File resultFile = new File("out/output6.txt");
        List<String> list = Files.readAllLines(Paths.get(file.getPath()));
        String[] scores = list.get(1).split("\\s");
        int resultScores = 0;
        int secondaryScores = 0;
        for (int j = 0; j < scores.length; j++) {
            int score = Integer.parseInt(scores[j]);
            if (score == 0) {
                continue;
            }
            secondaryScores += score * score;
            for (int i = j + 1; i < scores.length && i <= score + i; i++) {
                secondaryScores += Integer.parseInt(scores[i]);
                if (i == score) {
                    break;
                }
            }
            resultScores += secondaryScores;
            secondaryScores = 0;
        }
        PrintWriter writer = new PrintWriter(resultFile);
        writer.write(Integer.toString(resultScores));
        writer.close();
        return resultFile;
    }

}
