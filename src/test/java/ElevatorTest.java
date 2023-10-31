import junit.framework.TestCase;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ElevatorTest extends TestCase {

    Elevator elevator = new Elevator();

    private File resultFile = new File("out/output8.txt");

    public  void testElevator() throws IOException {
        File file = new File("input/input20.txt");
        elevator.elevator(file);
        String result = Files.readString(Paths.get(resultFile.getPath()));
        assertEquals("8", result);
    }
}
