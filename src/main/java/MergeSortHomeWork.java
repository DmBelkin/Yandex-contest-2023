import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class MergeSortHomeWork {

    public static void main(String[] args) throws IOException {
        File file = new File("input/in.txt");
        PrintWriter writer = new PrintWriter("out/outputPart.txt");
        List<String> list = Files.readAllLines(Paths.get(file.getPath()));
        int size = Integer.parseInt(list.get(0));
        int[] array = new int[size];
        String result = "";
        if (size == 0) {
            result = "0";
        } else {
            String[] ary = list.get(1).split("\\s");
            while (size > 0) {
                array[array.length - size] = Integer.parseInt(ary[ary.length - size--]);
            }
            mergeSort(array, ary.length);
            result = Arrays.toString(array);
            result = result.substring(1, result.length() - 1).replaceAll(",", "");
        }
        writer.write(result);
        System.out.println(Arrays.toString(array));
        writer.close();
    }

    public static void mergeSort(int[] array, int length) {
        if (length < 2) {
            return;
        }
        int middle = length / 2;
        int[] left = new int[middle];
        int[] right = new int[length - middle];

        for (int i = 0; i < middle; i++) {
            left[i] = array[i];
        }
        for (int i = middle; i < length; i++) {
            right[i - middle] = array[i];
        }
        mergeSort(left, middle);
        mergeSort(right, length - middle);

        merge(array, left, right, middle, length - middle);
    }

    public static void merge( int[] a, int[] l, int[] r, int left, int right) {
        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            }
            else {
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }
    }

}
