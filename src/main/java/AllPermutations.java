
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class AllPermutations {

    private List<String> list;

    public File permutation(File file) throws IOException {
        File resultFile = new File("out/output40.txt");
        /**
         * решена до значения 4
         */
        FileWriter writer = new FileWriter(resultFile);
        String st = Files.readString(Paths.get(file.getPath())).trim();
        int num = Integer.parseInt(st);
        String str = "";
        for (int i = 1; i <= num; i++) {
            str += i;
        }
        list = new ArrayList<>();
        permutation("", str);

        String res = "";
        for(String s : list) {
            res += s + "\n";
        }
        writer.write(res.trim());
        writer.close();
        return resultFile;
    }

    public void permutation(String prefix, String str) {
        int n = str.length();
        if (n == 0) {
            if (!list.contains(prefix)) {
                list.add(prefix);
            }
        } else {
            for (int i = 0; i < n; i++) {
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
            }
        }
    }
}
