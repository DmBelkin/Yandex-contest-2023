
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class HashesForStringsHomeWorks {

    public static void main(String[] args) throws IOException {
        File file = new File("input/inE15.txt");
        String input = Files.readString(Paths.get(file.getPath())).trim();
        int[] a = computePrefix(input);
        System.out.println(Arrays.toString(a));
        System.out.println(input.length() - a[a.length - 1]);
    }

    public static int[] computePrefix(String input) {
        int[] prefix = new int[input.length()];
        int j;
        for (int i = 1; i < input.length(); i++) {
            j = prefix[i - 1];
            while (j > 0 && input.charAt(j) != input.charAt(i)) {
                j = prefix[j - 1];
            }
            if (input.charAt(j) == input.charAt(i)) {
                j += 1;
            }
            prefix[i] = j;
        }
        return prefix;
    }

}

//    public static long[] h;
//
//    public static long[] i;
//
//    public static void main(String[] args) throws IOException {
//        File file = new File("input/inE15.txt");
//        String input = Files.readString(Paths.get(file.getPath())).trim();
//        int l = input.length();
//        int p = (int) Math.pow(10, 9) + 7;
//        int x = 257;
//        h = new long[l + 1];
//        i = new long[l + 1];
//        i[0] = 1;
//        input = "\s" + input;
//        for (int j = 1; j < l + 1; j++) {
//            h[j] = (h[j - 1] * x + input.charAt(j)) % p;
//            i[j] = (i[j - 1] * x) % p;
//        }
//        int f = 1;
//        List<Integer> list = new ArrayList<>();
//        for (int k = 1; k < (input.length() / 2) + 1; k++) {
//            if (isEquals(f, k, k, p)) {
//                //System.out.println(input.substring(f, k));
//                //System.out.println(k - 1);
//                list.add(k - 1);
//            }
//        }
//        String pattern = "";
//        System.out.println(list);
//        if (list.size() > 1) {
//            pattern = input.substring(1, list.get(1) + 1);
//        }
//        System.out.println(pattern);
//        String[] s = input.split(pattern);
//        //System.out.println(Arrays.toString(s));
//        String tale = s[s.length - 1];
//        //System.out.println(list);
//        System.out.println(list.size() + " size");
//        System.out.println(pattern);
//        System.out.println(tale);
//        if (list.size() == 1) {
//            System.out.println(s.length - 1);
//        } else if (tale.equals("") || pattern.startsWith(tale)) {
//            System.out.println(pattern.length());
//        } else {
//            if (!pattern.contains("" + tale.charAt(tale.length() - 1)) || pattern.equals("")) {
//                System.out.println(s.length);
//            }  else {
//                System.out.println(input.length() - 2);
//            }
//        }
//
////        System.out.println(pattern + "    pattern");
////        System.out.println(pattern.length());
////        System.out.println(list.get(list.size() - 1) * 2);
////        System.out.println(input.length());
//    }
//
//    public static boolean isEquals(int from1, int from2, int length, int p) {
//        return (h[from1 + length - 1] + h[from2 - 1] * i[length]) % p ==
//                (h[from2 + length - 1] + h[from1 - 1] * i[length]) % p;
//    }
//
