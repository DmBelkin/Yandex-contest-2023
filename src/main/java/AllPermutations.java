import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class AllPermutations {



    public static File permutation(File file) throws IOException {
        File resultFile = new File("out/output40.txt");
        /**
         * решена до значения 4
         */
        FileWriter writer = new FileWriter(resultFile);
        String st = Files.readString(Paths.get(file.getPath())).trim();
        int num = Integer.parseInt(st);
        int factorial = 1;
        String str = "";
        for (int i = 1; i <= num; i++) {
            factorial *= i;
            str += i;
        }
        if (str.length() == 1) {
            writer.write(Integer.toString(1));
        } else {
            int[] ary = new int[str.length()];
            for (int i = 0; i < str.length(); i++) {
                ary[i] = Integer.parseInt("" + str.charAt(i));
            }
            int[][] res = new int[(str.length())][str.length() - 1];
            int s = 0;
            for (int j = 0; j < res.length; j++) {
                int ind = 0;
                for (int i = 0; i < ary.length; i++) {
                    if (ary[s] == i + 1) {
                        continue;
                    }
                    res[j][ind++] = ary[i];
                }
                s++;
            }
            StringBuilder builder = new StringBuilder();
            for (int k = 0; k < res.length; k++) {
                builder.append(ary[k]);
                int length = res[k].length;
                int[] ar = res[k];
                String result = Arrays.toString(ar);
                builder.append(result.substring(1, result.length() - 1).
                        replaceAll(",\s", "") + "\n");
                for (int m = length; m > 0; m--) {
                    for (int i = length - 1; i > 0 ; i--) {
                        if (ar[i - 1] < ar[i]) {
                            int pivot = i;
                            for (int j = pivot; j < length; j++) {
                                if (ar[j] <= ar[pivot] && ar[i - 1] < ar[j]) {
                                    pivot = j;
                                }
                            }
                            int tmp = ar[i - 1];
                            ar[i - 1] = ar[pivot];
                            ar[pivot] = tmp;
                            for (int j = pivot; j < length; j++) {
                                int tmp1 = ar[j];
                                ar[j] = ar[i];
                                ar[i] = tmp1;
                            }
                            result = Arrays.toString(ar);
                            builder.append(ary[k]);
                            builder.append(result.substring(1, result.length() - 1).
                                    replaceAll(",\s", "") + "\n");
                        }
                    }
                }
            }
            String r = builder.deleteCharAt(builder.length() - 1).toString();
            writer.write(r);

        }
        writer.close();
        return resultFile;
    }
}
