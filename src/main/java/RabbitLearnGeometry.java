import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.*;

public class RabbitLearnGeometry {



    public static File rabbit(File file) throws IOException {
        File resultFile = new File("out/output11.txt");
        List<String> list = Files.readAllLines(Paths.get(file.getPath()));
        String[] lenths = list.get(0).split("\\s");
        int high = Integer.parseInt(lenths[0]);
        int length = Integer.parseInt(lenths[1]);
        int[][] field = new int[high][length];
        int[][] prefixField = new int[high][length];
        int index = 0;
        for (int i = 1; i < list.size(); i++) {
            String[] ary = list.get(i).split("\\s");
            int[] array = new int[ary.length];
            for (int j = 0; j < array.length; j++) {
                array[j] = Integer.parseInt(ary[j]);
            }
            field[index] = array;
            prefixField[index] = Arrays.copyOfRange(array, 0, array.length);
            index++;
        }
        int highest = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i < field.length; i++) {
            for (int j = 1; j < field[i].length; j++) {
                if (field[i][j] == 1) {
                    prefixField[i][j] = 1 +
                            min(prefixField[i - 1][j], prefixField[i][j - 1], prefixField[i - 1][j - 1]);
                    set.add(prefixField[i][j]);
                }
            }
        }
        for (int i = 0; i < field.length - 1; i++) {
            System.out.println(Arrays.toString(prefixField[i]));
        }
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            highest = iterator.next();
        }
        PrintWriter writer = new PrintWriter(resultFile);
        writer.write(Integer.toString(highest));
        writer.close();
        return resultFile;
    }

    public static int min (int x, int y, int z) {
        int min = 0;
        if (x <= y && x <= z) {
            min = x;
        }
        if (y <= x && y <= z) {
            min = y;
        }
        if (z <= x && z <= y) {
            min = z;
        }
        return min;
    }
}
