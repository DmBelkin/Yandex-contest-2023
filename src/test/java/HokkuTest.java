import junit.framework.TestCase;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class HokkuTest extends TestCase {

    Hokku hokku = new Hokku();

    File resultFile = new File("out/output7.txt");

    public  void testNodes() throws IOException {
        File file = new File("input/input13.txt");
        hokku.hokku(file);
        String result = Files.readString(Paths.get(resultFile.getPath()));
        assertEquals("YandexCup", result);
    }

    public void testNodes1() throws IOException {
        File file = new File("input/input14.txt");
        hokku.hokku(file);
        String result = Files.readString(Paths.get(resultFile.getPath()));
        assertEquals("YandexCup", result);
    }

    public  void testNodes2() throws IOException {
        File file = new File("input/input15.txt");
        hokku.hokku(file);
        String result = Files.readString(Paths.get(resultFile.getPath()));
        assertEquals("YandexYetAnotherCup", result);
    }

    public  void testNodes3() throws IOException {
        File file = new File("input/input16.txt");
        hokku.hokku(file);
        String result = Files.readString(Paths.get(resultFile.getPath()));
        assertEquals("YandexjhdskCupsajdhfgk", result);
    }

    public  void testNodes4() throws IOException {
        File file = new File("input/input17.txt");
        hokku.hokku(file);
        String result = Files.readString(Paths.get(resultFile.getPath()));
        assertEquals("YandexCup", result);
    }

}
