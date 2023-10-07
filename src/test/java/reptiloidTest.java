import junit.framework.TestCase;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class reptiloidTest extends TestCase {

    NewStory story = new NewStory();

    File resultFile = new File("out/output4.txt");


    public  void testNodes() throws IOException {
        File file = new File("input/input7.txt");
        story.time(file);
        String result = Files.readString(Paths.get(resultFile.getPath()));
        assertEquals("17 96", result);
    }

    public void testNodes1() throws IOException {
        File file = new File("input/input8.txt");
        story.time(file);
        String result = Files.readString(Paths.get(resultFile.getPath()));
        assertEquals("2923033 79555", result);
    }
}
