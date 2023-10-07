import junit.framework.TestCase;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class QueryToTableTest extends TestCase {

    private QueryToTable toTable = new QueryToTable();

    private File resultFile = new File("out/output5.txt");

    public void testQuery () throws IOException {
      File file = new File("input/input9.txt");
      toTable.queryControl(file);
      String result = Files.readString(Paths.get(resultFile.getPath()));
      assertEquals("4", result);
    }
}
