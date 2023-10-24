import junit.framework.TestCase;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ArtCriticTest extends TestCase {

    ArtCritic critic = new ArtCritic();

    File resultFile = new File("out/output6.txt");

    public  void testNodes() throws IOException {
        File file = new File("input/input10.txt");
        critic.getScores(file);
        String result = Files.readString(Paths.get(resultFile.getPath()));
        assertEquals("117", result);
    }

    public void testNodes1() throws IOException {
        File file = new File("input/input11.txt");
        critic.getScores(file);
        String result = Files.readString(Paths.get(resultFile.getPath()));
        assertEquals("0", result);
    }

    public  void testNodes2() throws IOException {
        File file = new File("input/input12.txt");
        critic.getScores(file);
        String result = Files.readString(Paths.get(resultFile.getPath()));
        assertEquals("5", result);
    }

}
