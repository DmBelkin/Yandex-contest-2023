import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Cubes {

    private static long[] h;

    private static long[] rewerse;

    private static long[] i;

    public static void main(String[] args) throws IOException {
        File file = new File("input/inE15.txt");
        List<String> list = Files.readAllLines(Paths.get(file.getPath()));
        String input = list.get(1).trim();
        int p = (int) Math.pow(10, 9) + 7;
        int x = 257;
        input = "\s"+ input;
        String[] in = input.split("\\s");
        String[] re = input.split("\\s");
        for (int j = 1;j < re.length / 2 + 1; j++) {
            String tmp = re[j];
            re[j] = re[re.length - j];
            re[re.length - j] = tmp;
        }
        h = new long[in.length + 1];
        i = new long[in.length + 1];
        rewerse = new long[in.length + 1];
        i[0] = 1;
        for (int j = 1; j < in.length; j++) {
            if (in[j].equals("\\s") || in[j].equals("")) {
                continue;
            }
            h[j] = (h[j - 1] * x + Integer.parseInt(in[j])) % p;
            rewerse[j] = (rewerse[j - 1] * x + Integer.parseInt(re[j])) % p;
            i[j] = (i[j - 1] * x) % p;
        }
        System.out.println(Arrays.toString(h));
        System.out.println(Arrays.toString(rewerse));
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i < in.length + 1; i++) {
            int len = in.length - i;
//            System.out.println(len + " -  " + i);
//            System.out.println(builder);
            if (isEquals(i, i, len, p) && (len + i + 1) % i == 0 && len > 0) {
                builder.append(len + "\s");
            }
        }
        System.out.println(builder.reverse().toString().trim());
    }

    public static boolean isEquals(int from1, int from2, int length, int p) {
        return (h[from1 + length - 1] + h[from2 - 1] * i[length]) % p ==
                (rewerse[from2 + length - 1] + rewerse[from1 - 1] * i[length]) % p;
    }
}
