import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortByDischarge {

    private static int sortIndex;

    private static int[][] sorted;

    public static void main(String[] args) throws IOException {
        File file = new File("input/inE15.txt");
        PrintWriter writer = new PrintWriter("out/outputPart.txt");
        List<String> list = Files.readAllLines(Paths.get(file.getPath()));
        int size = Integer.parseInt(list.get(0));
        StringBuilder builder = new StringBuilder();
        Bucket[] buckets = new Bucket[10];
        sortIndex = list.get(1).length() - 1;
        Item[] stack = new Item[size];
        for (int i = 0; i <= 9; i++) {
            buckets[i] = new Bucket(new ArrayList<>(), i);
        }
        int index = 0;
        for (int i = 1; i < list.size(); i++) {
            int[] array = new int[list.get(i).length()];
            String[] arr = list.get(i).split("");
            for (int j = 0; j < arr.length; j++) {
                array[j] = Integer.parseInt(arr[j]);
            }
            stack[index++] = new Item(array, array[sortIndex]);
        }
        for (Item item : stack) {
            System.out.println(item);
        }
        int maximum = max(stack);
        System.out.println(maximum);
    }

    public static int max(Item[] items) {
        int max = 0;
        for (int i = 0; i < items.length - 1; i++) {
            max = Integer.max(max, items[i].value);
        }
        return max;
    }

    public static void sortByDischarge(Item[] stack, int max) {

    }
}


class Item {

    int[] array;
    int value;

    public Item(int[] array, int value) {
        this.array = array;
        this.value = value;
    }

    public String toString() {
        return Arrays.toString(array) + " - " + value;
    }

}

class Bucket {
    List<Integer> sortIndex;
    int index;
    int number;

    public Bucket(List<Integer> sortIndex, int number) {
        this.sortIndex = sortIndex;
        this.number = number;
    }

    @Override
    public String toString() {
        return "Bucket" + "\s" + number +
                "\s" + sortIndex;
    }
}
