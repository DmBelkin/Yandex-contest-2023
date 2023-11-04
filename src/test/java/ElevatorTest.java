import junit.framework.TestCase;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ElevatorTest extends TestCase {

    Elevator elevator = new Elevator();

    private File resultFile = new File("out/output8.txt");

    public  void testElevator3() throws IOException {
        File file = new File("input/input24.txt");
        elevator.elevator(file);
        String result = Files.readString(Paths.get(resultFile.getPath()));
        assertEquals("2286", result);
    }

    public  void testElevator() throws IOException {
        File file = new File("input/input20.txt");
        elevator.elevator(file);
        String result = Files.readString(Paths.get(resultFile.getPath()));
        assertEquals("8", result);
    }

    public  void testElevator1() throws IOException {
        File file = new File("input/input22.txt");
        elevator.elevator(file);
        String result = Files.readString(Paths.get(resultFile.getPath()));
        assertEquals("30", result);
    }

    public  void testElevator2() throws IOException {
        File file = new File("input/input23.txt");
        elevator.elevator(file);
        String result = Files.readString(Paths.get(resultFile.getPath()));
        assertEquals("7278", result);
    }

    public  void testElevator4() throws IOException {
        File file = new File("input/input25.txt");
        elevator.elevator(file);
        String result = Files.readString(Paths.get(resultFile.getPath()));
        assertEquals("2147468026", result);
    }

}
