import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;


public class Z_function {

    public static void main(String[] args) throws IOException {
        File file = new File("input/inE15.txt");
        List<String> list = Files.readAllLines(Paths.get(file.getPath()));
        String input = list.get(1).trim();
        int[] zFunc = mirrorZ(input);
        String res = Arrays.toString(zFunc);
        System.out.println(res.substring(1, res.length() - 1).replaceAll(",", ""));
    }


    public static int[] mirrorZ(String s) {
        int n = s.length();
        int z[] = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = i; j >= 0; j--) {
                if (s.charAt(z[i]) == s.charAt(j)) {
                    z[i]++;
                } else {
                    break;
                }
            }
        }
        return z;
    }

    public static int[] zFucntion(String s) {
        int n = s.length();
        int z[] = new int[n];
        int r = 0;
        int l = 0;
        for (int i = 1; i < n; i++) {
            if (r > i) {
                z[i] = Math.min(r - i, z[i - l]);
            }
            while (i + z[i] < n && s.charAt(i + z[i]) == s.charAt(z[i])) {
                z[i]++;
            }
            if (i + z[i] > r) {
                l = i;
                r = i + z[i];
            }
            System.out.println(Arrays.toString(z));
        }
        return z;
    }
}
