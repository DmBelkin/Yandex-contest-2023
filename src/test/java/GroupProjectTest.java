
import junit.framework.TestCase;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GroupProjectTest extends TestCase {

    private GroupProject groupProject = new GroupProject();

    private File resultFile = new File("out/output10.txt");

    public void testProject() throws IOException {
        File file = new File("input/input32.txt");
        groupProject.project(file);
        String result = Files.readString(Paths.get(resultFile.getPath()));
        assertEquals("YES\n" +
                "NO\n" +
                "YES\n" +
                "YES", result);
    }

    public void testProject1() throws IOException {
        File file = new File("input/input33.txt");
        groupProject.project(file);
        String result = Files.readString(Paths.get(resultFile.getPath()));
        assertEquals("NO\n" +
                "NO\n" +
                "YES\n" +
                "YES\n" +
                "YES\n" +
                "YES\n" +
                "YES\n" +
                "YES\n" +
                "YES\n" +
                "YES\n" +
                "YES\n" +
                "YES\n" +
                "YES\n" +
                "YES\n" +
                "YES\n" +
                "YES\n" +
                "YES\n" +
                "NO\n" +
                "YES\n" +
                "NO\n" +
                "YES\n" +
                "YES\n" +
                "YES\n" +
                "YES\n" +
                "YES\n" +
                "YES\n" +
                "YES\n" +
                "YES\n" +
                "YES\n" +
                "YES\n" +
                "YES\n" +
                "NO\n" +
                "NO\n" +
                "YES\n" +
                "NO\n" +
                "NO\n" +
                "NO\n" +
                "YES\n" +
                "YES\n" +
                "YES\n" +
                "YES\n" +
                "YES\n" +
                "NO\n" +
                "NO\n" +
                "YES\n" +
                "YES\n" +
                "YES\n" +
                "NO\n" +
                "YES\n" +
                "NO\n" +
                "YES\n" +
                "YES\n" +
                "NO\n" +
                "YES\n" +
                "YES\n" +
                "YES\n" +
                "YES\n" +
                "YES\n" +
                "YES\n" +
                "YES\n" +
                "YES\n" +
                "NO\n" +
                "YES\n" +
                "YES\n" +
                "NO\n" +
                "YES\n" +
                "YES\n" +
                "YES\n" +
                "YES\n" +
                "YES\n" +
                "YES\n" +
                "YES\n" +
                "NO\n" +
                "YES\n" +
                "NO\n" +
                "YES\n" +
                "NO\n" +
                "YES\n" +
                "YES\n" +
                "NO\n" +
                "YES\n" +
                "YES\n" +
                "YES\n" +
                "NO\n" +
                "YES\n" +
                "YES\n" +
                "YES\n" +
                "YES\n" +
                "YES\n" +
                "YES\n" +
                "YES\n" +
                "YES\n" +
                "YES\n" +
                "YES\n" +
                "NO\n" +
                "YES\n" +
                "YES\n" +
                "YES\n" +
                "YES\n" +
                "YES", result);
    }

}
