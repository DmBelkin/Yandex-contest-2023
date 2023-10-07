import junit.framework.TestCase;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class nodesTest extends TestCase {

    InterplanetaryOrganization organization = new InterplanetaryOrganization();

    File resultFile = new File("out/output1.txt");


    public  void testNodes() throws IOException {
        File file = new File("input/input3.txt");
        organization.nodesCompany(file);
        String result = "";
        List<String> list = Files.readAllLines(Paths.get(resultFile.getPath()));
        for (String str : list) {
            result += str + "\s";
        }
        assertEquals("0 0 0 2 0 ", result);
    }

    public void testNodes1() throws IOException {
        File file = new File("input/input4.txt");
        organization.nodesCompany(file);
        String result = "";
        List<String> list = Files.readAllLines(Paths.get(resultFile.getPath()));
        for (String str : list) {
            result += str + "\s";
        }
        assertEquals("0 1 1 1 ", result);
    }
}
