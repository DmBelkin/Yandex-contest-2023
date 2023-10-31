import junit.framework.TestCase;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class NotMinTest extends TestCase
{
    NotMin notMin = new NotMin();
    File resultFile = new File("out/output8.txt");

    public  void testNotMin() throws IOException {
        File file = new File("input/input19.txt");
        notMin.notMin(file);
        List<String>  result= Files.readAllLines(Paths.get(resultFile.getPath()));
        String res = "";
        for (String str : result) {
            res += str + "\n";
        }
        assertEquals("NOT FOUND\n" +
                "2", res.trim());
    }

    public void testNotMin1() throws IOException {
        File file = new File("input/input18.txt");
        notMin.notMin(file);
        List<String>  result= Files.readAllLines(Paths.get(resultFile.getPath()));
        String res = "";
        for (String str : result) {
            res += str + "\n";
        }
        assertEquals("NOT FOUND\n" +
                "2\n" +
                "NOT FOUND\n" +
                "10\n" +
                "3", res.trim());
    }
}
