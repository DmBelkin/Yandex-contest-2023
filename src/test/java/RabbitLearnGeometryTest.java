
import junit.framework.TestCase;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class RabbitLearnGeometryTest extends TestCase {

    private RabbitLearnGeometry geometry = new RabbitLearnGeometry();

    private File resultFile = new File("out/output11.txt");

    public void testRabbit() throws IOException {
        File file = new File("input/input27.txt");
        geometry.rabbit(file);
        String result = Files.readString(Paths.get(resultFile.getPath()));
        assertEquals("2", result);
    }

    public void testRabbit1() throws IOException {
        File file = new File("input/input28.txt");
        geometry.rabbit(file);
        String result = Files.readString(Paths.get(resultFile.getPath()));
        assertEquals("10", result);
    }

    public void testRabbit2() throws IOException {
        File file = new File("input/input29.txt");
        geometry.rabbit(file);
        String result = Files.readString(Paths.get(resultFile.getPath()));
        assertEquals("0", result);
    }

    public void testRabbit3() throws IOException {
        File file = new File("input/input30.txt");
        geometry.rabbit(file);
        String result = Files.readString(Paths.get(resultFile.getPath()));
        assertEquals("20", result);
    }

    public void testRabbit4() throws IOException {
        File file = new File("input/input31.txt");
        geometry.rabbit(file);
        String result = Files.readString(Paths.get(resultFile.getPath()));
        assertEquals("30", result);
    }

    public void testRabbit5() throws IOException {
        File file = new File("input/input34.txt");
        geometry.rabbit(file);
        String result = Files.readString(Paths.get(resultFile.getPath()));
        assertEquals("384", result);
    }

    public void testRabbit6() throws IOException {
        File file = new File("input/input36.txt");
        geometry.rabbit(file);
        String result = Files.readString(Paths.get(resultFile.getPath()));
        assertEquals("5", result);
    }

    public void testRabbit7() throws IOException {
        File file = new File("input/input37.txt");
        geometry.rabbit(file);
        String result = Files.readString(Paths.get(resultFile.getPath()));
        assertEquals("37", result);
    }
}
