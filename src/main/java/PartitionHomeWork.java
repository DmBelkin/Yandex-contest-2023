import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;


public class PartitionHomeWork {


    public static void main(String[] args) throws IOException {
        File file = new File("input/inpt.txt");
        PrintWriter writer = new PrintWriter("out/outputPart.txt");
        List<String> list = Files.readAllLines(Paths.get(file.getPath()));
        int size = Integer.parseInt(list.get(0));
        long[] array = new long[size];
        String result = "";
        if (size == 0) {
            writer.write("");
        } else {
            String input = list.get(1);
            String[] ary = input.split("\\s");
            while (size > 0) {
                array[array.length - size] = Long.parseLong(ary[ary.length - size--]);
            }
            if (wasSorted(array)) {
                result = Arrays.toString(array);
            } else if (wasRewerseSorted(array)) {
                StringBuilder builder = new StringBuilder(Arrays.toString(array));
                builder.reverse();
                result = builder.toString();
            } else {
                quickSort(array);
                result = Arrays.toString(array);
            }
            writer.write(result.substring(1, result.length() - 1).replaceAll(",", ""));
        }
        writer.close();
    }

    public static void quickSort(long[] arr) {
        int subArray = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        stack.push(arr.length - 1);
        while (subArray > -1) {
            int right = stack.pop();
            int left = stack.pop();
            --subArray;
            while (left < right) {
                int leftMarker = left;
                int rightMarker = right;
                long leftPivot = arr[leftMarker];
                long rightPivot = arr[rightMarker];
                long middlePivot = arr[(left + right) / 2];
                long pivot = (leftPivot + rightPivot + middlePivot) / 3;
                while (rightMarker >= leftMarker) {
                    while (pivot < arr[rightMarker]) {
                        rightMarker--;
                    }
                    while (pivot > arr[leftMarker]) {
                        leftMarker++;
                    }
                    if (leftMarker <= rightMarker) {
                        if (leftMarker != rightMarker) {
                            long temp = arr[leftMarker];
                            arr[leftMarker] = arr[rightMarker];
                            arr[rightMarker] = temp;
                        }
                        rightMarker--;
                        leftMarker++;
                    }
                }
                if (leftMarker < right) {
                    ++subArray;
                    stack.push(leftMarker);
                    stack.push(right);
                }
                right = rightMarker;
            }
        }
    }



    public static boolean wasRewerseSorted(long[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            if (array[i - 1] < array[i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean wasSorted(long[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i + 1] < array[i]) {
                return false;
            }
        }
        return true;
    }


}
