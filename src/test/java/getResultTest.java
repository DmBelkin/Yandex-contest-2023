import junit.framework.TestCase;

import java.util.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class getResultTest extends TestCase {

    Divercity divercity = new Divercity();

    File resultFile = new File("out/output.txt");

    public void testGetResult() throws IOException {
        File file = new File("input/input.txt");
        divercity.getResult(file);
        String result = "";
        List<String> list = Files.readAllLines(Paths.get(resultFile.getPath()));
        for (String str : list) {
            result += str + "\s";
        }
        assertEquals("5 4 5 6 7 8 9 10 9 8 9 8 7 6 5 6 5 4 3 4",
                result.trim());
    }

    public void testGetResult1() throws IOException {
        File file2 = new File("input/input1.txt");
        divercity.getResult(file2);
        String result = "";
        List<String> list = Files.readAllLines(Paths.get(resultFile.getPath()));
        for (String str : list) {
            result += str + "\s";
        }
        assertEquals("2 1 0 1 2 3 2 1 0 1",
                result.trim());
    }

    public void testGetResult2() throws IOException {
        File file = new File("input/input2.txt");
        divercity.getResult(file);
        String result = "";
        List<String> list = Files.readAllLines(Paths.get(resultFile.getPath()));
        for (String str : list) {
            result += str + "\s";
        }
        assertEquals("3 2 1 2 3",
                result.trim());
    }
}



