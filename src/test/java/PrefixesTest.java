import junit.framework.TestCase;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class PrefixesTest extends TestCase {

    Intimacy intimacy = new Intimacy();

    File resultFile = new File("out/output3.txt");


    public  void testPrefixes() throws IOException {
        File file = new File("input/input5.txt");
        intimacy.prefixes(file);
        String result = "";
        List<String> list = Files.readAllLines(Paths.get(resultFile.getPath()));
        for (String str : list) {
            result += str + "\s";
        }
        assertEquals("4 ", result);
    }

    public  void testPrefixes1() throws IOException {
        File file = new File("input/input6.txt");
        intimacy.prefixes(file);
        String result = "";
        List<String> list = Files.readAllLines(Paths.get(resultFile.getPath()));
        for (String str : list) {
            result += str + "\s";
        }
        assertEquals("1 ", result);
    }
}
